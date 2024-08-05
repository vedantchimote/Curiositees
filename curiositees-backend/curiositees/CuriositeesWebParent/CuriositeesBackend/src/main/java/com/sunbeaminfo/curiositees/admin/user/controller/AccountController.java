/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 * @Time : 10:24 pm
 **/

package com.sunbeaminfo.curiositees.admin.user.controller;

import com.curiositees.common.entity.User;
import com.sunbeaminfo.curiositees.admin.FileUploadUtil;
import com.sunbeaminfo.curiositees.admin.security.CuriositeesUserDetails;
import com.sunbeaminfo.curiositees.admin.user.UserService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-07-2024, Sunday
 **/

@Controller
public class AccountController {

  @Autowired
  private UserService service;

  @GetMapping("/account")
  public String viewDetails(@AuthenticationPrincipal CuriositeesUserDetails loggedUser,
      Model model) {
    String email = loggedUser.getUsername();
    User user = service.getByEmail(email);
    model.addAttribute("user", user);

    return "users/account_form";
  }

  @PostMapping("/account/update")
  public String saveDetails(User user, RedirectAttributes redirectAttributes,
      @AuthenticationPrincipal CuriositeesUserDetails loggedUser,
      @RequestParam("image") MultipartFile multipartFile) throws IOException {

    if (!multipartFile.isEmpty()) {
      String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
      user.setPhotos(fileName);
      User savedUser = service.updateAccount(user);

      String uploadDir = "user-photos/" + savedUser.getId();

      FileUploadUtil.cleanDir(uploadDir);
      FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

    } else {
      if (user.getPhotos().isEmpty()) {
        user.setPhotos(null);
      }
      service.updateAccount(user);
    }

    loggedUser.setFirstName(user.getFirstName());
    loggedUser.setLastName(user.getLastName());

    redirectAttributes.addFlashAttribute("message", "Your account details have been updated.");

    return "redirect:/account";
  }
}
