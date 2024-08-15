/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:45 pm
 **/

package com.sunbeaminfo.curiositees.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@RestController
public class CustomerRestController {

  @Autowired
  private CustomerService service;

  @PostMapping("/customers/check_unique_email")
  public String checkDuplicateEmail(@Param("email") String email) {
    return service.isEmailUnique(email) ? "OK" : "Duplicated";
  }
}