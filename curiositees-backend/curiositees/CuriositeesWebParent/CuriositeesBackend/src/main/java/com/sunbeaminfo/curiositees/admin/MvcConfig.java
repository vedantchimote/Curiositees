/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 10-06-2024, Monday
 * @Time : 08:01 pm
 **/

package com.sunbeaminfo.curiositees.admin;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 10-06-2024, Monday
 **/

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  //Configure Spring MVC to Expose User Photos Directory
  //Basically, this method is used to expose the user-photos directory to the web

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    String dirName = "user-photos";
    Path userPhotosDir = Paths.get(dirName);
    String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

    registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + userPhotosPath + "/");

  }
}
