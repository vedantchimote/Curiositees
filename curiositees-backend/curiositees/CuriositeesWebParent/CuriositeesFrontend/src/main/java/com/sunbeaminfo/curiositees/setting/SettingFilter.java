/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 03:59 pm
 **/

package com.sunbeaminfo.curiositees.setting;

import com.curiositees.common.entity.Setting;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Component
public class SettingFilter implements Filter {

  @Autowired
  private SettingService service;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest servletRequest = (HttpServletRequest) request;
    String url = servletRequest.getRequestURL().toString();

    if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png") ||
        url.endsWith(".jpg")) {
      chain.doFilter(request, response);
      return;
    }

    List<Setting> generalSettings = service.getGeneralSettings();

    generalSettings.forEach(setting -> {
      System.out.println(setting);
      request.setAttribute(setting.getKey(), setting.getValue());
    });

    chain.doFilter(request, response);

  }

}