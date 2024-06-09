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

@RestController
public class UserRestController {

  @Autowired
  private UserService userService;

  @PostMapping("/users/check_email")
  public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
    return userService.isEmailUnique(id, email) ? "OK" : "Duplicated";
  }

}
