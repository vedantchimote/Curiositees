/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:44 pm
 **/

package com.sunbeaminfo.curiositees.customer;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.Customer;
import com.sunbeaminfo.curiositees.Utility;
import com.sunbeaminfo.curiositees.setting.EmailSettingBag;
import com.sunbeaminfo.curiositees.setting.SettingService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Controller
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  @Autowired
  private SettingService settingService;

  @GetMapping("/register")
  public String showRegisterForm(Model model) {

    List<Country> listCountries = customerService.listAllCountries();

    model.addAttribute("listCountries", listCountries);
    model.addAttribute("pageTitle", "Customer Registration");
    model.addAttribute("customer", new Customer());

    return "register/register_form";
  }


  @PostMapping("/create_customer")
  public String createCustomer(Customer customer, Model model,
      HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
    customerService.registerCustomer(customer);
    sendVerificationEmail(request, customer);

    model.addAttribute("pageTitle", "Registration Succeeded!");

    return "/register/register_success";
  }

  private void sendVerificationEmail(HttpServletRequest request, Customer customer)
      throws UnsupportedEncodingException, MessagingException {
    EmailSettingBag emailSettings = settingService.getEmailSettings();
    JavaMailSenderImpl mailSender = Utility.prepareMailSender(emailSettings);

    String toAddress = customer.getEmail();
    String subject = emailSettings.getCustomerVerifySubject();
    String content = emailSettings.getCustomerVerifyContent();

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setFrom(emailSettings.getFromAddress(), emailSettings.getSenderName());
    helper.setTo(toAddress);
    helper.setSubject(subject);

    content = content.replace("[[name]]", customer.getFullName());

    String verifyURL =
        Utility.getSiteURL(request) + "/verify?code=" + customer.getVerificationCode();

    content = content.replace("[[URL]]", verifyURL);

    helper.setText(content, true);

    mailSender.send(message);

    System.out.println("to Address: " + toAddress);
    System.out.println("Verify URL: " + verifyURL);
  }
}