/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 08:33 pm
 **/

package com.sunbeaminfo.curiositees.setting;

import com.curiositees.common.entity.Setting;
import com.curiositees.common.entity.SettingBag;
import java.util.List;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public class EmailSettingBag extends SettingBag {

  public EmailSettingBag(List<Setting> listSettings) {
    super(listSettings);
  }

  public String getHost() {
    return super.getValue("MAIL_HOST");
  }

  public int getPort() {
    return Integer.parseInt(super.getValue("MAIL_PORT"));
  }

  public String getUsername() {
    return super.getValue("MAIL_USERNAME");
  }

  public String getPassword() {
    return super.getValue("MAIL_PASSWORD");
  }

  public String getSmtpAuth() {
    return super.getValue("SMTP_AUTH");
  }

  public String getSmtpSecured() {
    return super.getValue("SMTP_SECURED");
  }

  public String getFromAddress() {
    return super.getValue("MAIL_FROM");
  }

  public String getSenderName() {
    return super.getValue("MAIL_SENDER_NAME");
  }

  public String getCustomerVerifySubject() {
    return super.getValue("CUSTOMER_VERIFY_SUBJECT");
  }

  public String getCustomerVerifyContent() {
    return super.getValue("CUSTOMER_VERIFY_CONTENT");
  }
}