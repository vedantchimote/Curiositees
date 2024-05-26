/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 26-05-2024, Sunday
 * @Time : 10:55 am
 **/

package com.sunbeaminfo.curiositees.admin.user;

import com.curiositees.common.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
