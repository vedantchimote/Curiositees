/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 08:29 pm
 **/

package com.sunbeaminfo.curiositees;

import com.sunbeaminfo.curiositees.setting.EmailSettingBag;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Properties;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public class Utility {
  public static String getSiteURL(HttpServletRequest request) {
    String siteURL = request.getRequestURL().toString();

    return siteURL.replace(request.getServletPath(), "");
  }

  public static JavaMailSenderImpl prepareMailSender(EmailSettingBag settings) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    mailSender.setHost(settings.getHost());
    mailSender.setPort(settings.getPort());
    mailSender.setUsername(settings.getUsername());
    mailSender.setPassword(settings.getPassword());

    Properties mailProperties = new Properties();
    mailProperties.setProperty("mail.smtp.auth", settings.getSmtpAuth());
    mailProperties.setProperty("mail.smtp.starttls.enable", settings.getSmtpSecured());

    mailSender.setJavaMailProperties(mailProperties);

    return mailSender;
  }
}