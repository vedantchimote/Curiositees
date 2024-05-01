package com.sunbeaminfo.curiositees.admin;
/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 23-04-2024, Tuesday
 * @Time : 05:22 pm
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("")
  public String viewHomePage() {
    return "index";
  }

}

