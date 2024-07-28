/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:55 am
 **/

package com.sunbeaminfo.curiositees.admin.user;


import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import com.sunbeaminfo.curiositees.admin.FileUploadUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 **/
/* This class is a controller for handling user-related requests */
@Controller
public class UserController {

  // This annotation is used to inject the UserService bean
  @Autowired
  private UserService userService;

  private static String getString(User user) {
    String firstPartOfEmail = user.getEmail().split("@")[0];
    return "redirect:/users/page/1?sortField=id&sortDir=asc&keyword=" + firstPartOfEmail;
  }

  /* This method is used to list all users and display them on the users page
    using the users.html template and the list of users */
  @GetMapping("/users")
  public String listFirstPage(Model model) {

    return listByPage(model, 1, "firstName", "asc", null);

//    List<User> listUsers = userService.listAll();
//    // Add the list of users to the model
//    model.addAttribute("listUsers", listUsers);
//    return "users";
  }

  @GetMapping("/users/page/{pageNum}")
  public String listByPage(Model model, @PathVariable(name = "pageNum") int pageNum,
      @Param("sortField") String sortField, @Param("sortDir") String sortDir,
      @Param("keyword") String keyword) {

    System.out.println("Sort Field: " + sortField);
    System.out.println("Sort Dir: " + sortDir);

    Page<User> page = userService.listByPage(pageNum, sortField, sortDir, keyword);

    List<User> listUsers = page.getContent();

//    System.out.println("Pagenum" + pageNum);
//    System.out.println("Total elements = " + page.getTotalElements());
//    System.out.println("Total pages = " + page.getTotalPages());

    long startCount = (pageNum - 1) * UserService.USERS_PER_PAGE + 1;
    long endCount = startCount + UserService.USERS_PER_PAGE - 1;
    if (endCount > page.getTotalElements()) {
      endCount = page.getTotalElements();
    }

    String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";

    model.addAttribute("currentPage", pageNum);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("startCount", startCount);
    model.addAttribute("endCount", endCount);
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("sortField", sortField);
    model.addAttribute("sortDir", sortDir);
    model.addAttribute("listUsers", listUsers);
    model.addAttribute("reverseSortDir", reverseSortDir);
    model.addAttribute("keyword", keyword);

    return "users";
  }

  /* This method is used to display the new user form using the users_form.html template and the User object*/
  @GetMapping("/users/new")
  public String newUser(Model model) {
    List<Role> listRoles = userService.listRoles();
    User user = new User();
    user.setEnabled(true);
    model.addAttribute("user", user);
    model.addAttribute("listRoles", listRoles);
    model.addAttribute("pageTitle", "Create New User");
    return "users_form";
  }

  /*   This method is used to save a user's photo
     If the photo is not empty, it saves the photo and the user
     If the photo is empty, it just saves the user */
  @PostMapping("/users/save")
  public String saveUser(User user, RedirectAttributes redirectAttributes,
      @RequestParam("image") MultipartFile multipartFile) throws IOException {
//    System.out.println(user);
//    System.out.println(multipartFile.getOriginalFilename());

    // Check if the photo is not empty
    if (!multipartFile.isEmpty()) {
      // Get the file name of the photo
      String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
      // Set the photo for the user
      user.setPhotos(fileName);
      // Save the user
      User savedUser = userService.save(user);
      // Define the directory to upload the photo
      String uploadDir = "user-photos/" + savedUser.getId();

      // Clean the directory and save the file
      FileUploadUtil.cleanDir(uploadDir);
      // Save the file to the specified directory with the specified file name and the multipart file to be saved to the directory
      FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    } else {
      // If the photo is empty, check if the user has a photo
      // If not, set the photo to null and save the user
      if (user.getPhotos().isEmpty()) {
        user.setPhotos(null);
      }
      userService.save(user);
    }

    // Add a success message and redirect to the users page
    redirectAttributes.addFlashAttribute("message", "The User has been saved successfully!");
    return getString(user);
  }

  /*  This method is used to edit a user using the users_form.html template and the User object
    with the specified ID and the list of roles available in the system*/
  @GetMapping("/users/edit/{id}")
  public String editUser(@PathVariable(name = "id") Integer id, Model model,
      // This annotation is used to add a flash attribute to the redirect URL
      RedirectAttributes redirectAttributes) {

    // Try to get the user with the specified ID and list of roles
    try {
      User user = userService.get(id);

      List<Role> listRoles = userService.listRoles();

      // Add the user, list of roles, and the page title to the model and return the users_form.html template
      model.addAttribute("user", user);
      model.addAttribute("pageTitle",
          "Edit User (ID: " + id + " & Email: " + user.getEmail() + ")");
      model.addAttribute("listRoles", listRoles);

      return "users_form";
    } catch (UserNotFoundException e) {
      // If the user is not found, add an error message and redirect to the users page with the list of users and the list of roles
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/users";
    }
  }

  /*
    This method is used to delete a user with the specified ID and redirect to the users page with the list of users and the list of roles
  */
  @GetMapping("/users/delete/{id}")
  public String deleteUser(
      // This annotation is used to bind the ID from the URL to the id parameter
      @PathVariable(name = "id") Integer id,
      // This annotation is used to add a flash attribute to the redirect URL
      RedirectAttributes redirectAttributes) {
    try {
      userService.delete(id);
      // Add a success message and redirect to the users page
      redirectAttributes.addFlashAttribute("message",
          "The User ID " + id + " has been deleted successfully!");
    } catch (UserNotFoundException e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }
    return "redirect:/users";
  }

  /*
    This method is used to enable or disable a user with the specified ID and status
  */
  @GetMapping("/users/{id}/enabled/{status}")
  public String updateUserEnabledStatus(@PathVariable("id") Integer id,
      @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
    // Update the user's enabled status with the specified ID and status
    userService.updateUserEnabledStatus(id, enabled);
    String status = enabled ? "enabled" : "disabled";
    String message = "The User ID " + id + " has been " + status + " successfully!";
    redirectAttributes.addFlashAttribute("message", message);
    // Redirect to the users page with the list of users and the list of roles available in the system and return the users.html template
    return "redirect:/users";
  }

  //Used to export the list of users to a CSV file and download it
  @GetMapping("/users/export/csv")
  public void exportToCSV(HttpServletResponse response) throws IOException {
    List<User> listUsers = userService.listAll();
    UserCsvExporter exporter = new UserCsvExporter();
    exporter.export(listUsers, response);
  }

  @GetMapping("/users/export/excel")
  public void exportToExcel(HttpServletResponse response) throws IOException {
    List<User> listUsers = userService.listAll();

    UserExcelExporter exporter = new UserExcelExporter();
    exporter.export(listUsers, response);
  }

  @GetMapping("/users/export/pdf")
  public void exportToPDF(HttpServletResponse response) throws IOException {
    List<User> listUsers = userService.listAll();

    UserPdfExporter exporter = new UserPdfExporter();
    exporter.export(listUsers, response);
  }

}
