/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:55 am
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 **/

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping( "/users")
  public String listAll(Model model)
  {
    List<User> listUsers = userService.listAll();
    model.addAttribute("listUsers", listUsers);
    return "users";
  }

  @GetMapping( "/users/new")
  public String newUser(Model model)
  {
    List<Role> listRoles = userService.listRoles();
    User user = new User();
    user.setEnabled(true);
    model.addAttribute("user", user);
    model.addAttribute("listRoles", listRoles);
    return "users_form";
  }

  @PostMapping("/users/save")
  public String saveUser(User user, RedirectAttributes redirectAttributes)
  {
    userService.save(user);
    System.out.println(user);

    redirectAttributes.addFlashAttribute("message", "The User has been saved successfully!");
    return "redirect:/users";
  }

}
