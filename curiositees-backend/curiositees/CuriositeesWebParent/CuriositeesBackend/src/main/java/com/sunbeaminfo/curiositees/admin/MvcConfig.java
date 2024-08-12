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

// This class is used to configure Spring MVC to expose the user-photos directory to the web
@Configuration
/* This class implements the WebMvcConfigurer interface to provide custom configuration for Spring MVC*/
public class MvcConfig implements WebMvcConfigurer {

  /*
    This method is used to add a resource handler for the user-photos directory to the resource handler registry
  */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

//    // Define the directory name and path for user photos
//    String dirName = "user-photos";
//    // Define the path to the user-photos directory
//    Path userPhotosDir = Paths.get(dirName);
//    // Get the absolute path of the user-photos directory
//    String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();
//
//    // Add a resource handler for the user-photos directory to the resource handler registry
//    registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + userPhotosPath + "/");
//
//    String categoryImagesDirName = "../category-images";
//    Path categoryImagesDir = Paths.get(categoryImagesDirName);
//
//    String categoryImagesPath = categoryImagesDir.toFile().getAbsolutePath();
//
//    registry.addResourceHandler("/category-images/**")
//        .addResourceLocations("file:/" + categoryImagesPath + "/");
//
//    String brandLogosDirName = "../brand-logos";
//    Path brandLogosDir = Paths.get(brandLogosDirName);
//
//    String brandLogosPath = brandLogosDir.toFile().getAbsolutePath();
//
//    registry.addResourceHandler("/brand-logos/**")
//        .addResourceLocations("file:/" + brandLogosPath + "/");

    exposeDirectory("user-photos", registry);
    exposeDirectory("../category-images", registry);
    exposeDirectory("../brand-logos", registry);
    exposeDirectory("../product-images", registry);
  }

  private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
    Path path = Paths.get(pathPattern);
    String absolutePath = path.toFile().getAbsolutePath();

    String logicalPath = pathPattern.replace("../", "") + "/**";

    registry.addResourceHandler(logicalPath)
        .addResourceLocations("file:/" + absolutePath + "/");
  }
}

