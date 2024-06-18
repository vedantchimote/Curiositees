/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 * @Time : 03:32 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 28-05-2024, Tuesday
 **/

// This annotation marks the class as a REST controller
@RestController
/* This class provides RESTful services for the User entity using the UserService class*/
public class UserRestController {

  @Autowired
  private UserService userService;

  /* This method checks if the email address is unique or not */
  @PostMapping("/users/check_email")
  public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
    return userService.isEmailUnique(id, email) ? "OK" : "Duplicated";
  }

}