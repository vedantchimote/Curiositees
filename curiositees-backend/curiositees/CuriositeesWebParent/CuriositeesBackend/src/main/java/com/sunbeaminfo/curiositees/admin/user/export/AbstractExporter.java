/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 27-07-2024, Saturday
 * @Time : 01:53 pm
 **/

package com.sunbeaminfo.curiositees.admin.user.export;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 27-07-2024, Saturday
 **/

public class AbstractExporter {

  public void setResponseHeader(HttpServletResponse response, String contentType,
      String extension, String prefix) throws IOException {
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    String timestamp = dateFormatter.format(new Date());
    String fileName = prefix + timestamp + extension;

    response.setContentType(contentType);

    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=" + fileName;
    response.setHeader(headerKey, headerValue);

  }

}
