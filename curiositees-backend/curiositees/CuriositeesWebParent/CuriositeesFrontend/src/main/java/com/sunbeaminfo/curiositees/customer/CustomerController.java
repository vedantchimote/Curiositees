/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:44 pm
 **/

package com.sunbeaminfo.curiositees.customer;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Controller
public class CustomerController {
  @Autowired
  private CustomerService service;

  @GetMapping("/register")
  public String showRegisterForm(Model model) {
    List<Country> listCountries = service.listAllCountries();

    model.addAttribute("listCountries", listCountries);
    model.addAttribute("pageTitle", "Customer Registration");
    model.addAttribute("customer", new Customer());

    return "register/register_form";
  }
}