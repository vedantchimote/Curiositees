/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 10-06-2024, Monday
 * @Time : 06:53 pm
 **/

package com.sunbeaminfo.curiositees.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 10-06-2024, Monday
 **/

// This class provides utility methods for file upload
public class FileUploadUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);

  // This method saves a file to a specified directory
  // It takes the directory path, file name, and the file to be saved as input
  public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile)
      throws IOException {

    //Before changing the run configuration (#Experimental #Ignore)
//    Path uploadPath = Paths.get(
//        "curiositees-backend//curiositees//CuriositeesWebParent//CuriositeesBackend//src//main//resources//static//images//",
//        uploadDir);

    // Define the path to upload the file
    Path uploadPath = Paths.get(uploadDir);

    // If the directory does not exist, create it
    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    // Try to save the file
    try (InputStream inputStream = multipartFile.getInputStream()) {
      Path filePath = uploadPath.resolve(fileName);
      Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException ex) {
      throw new IOException("Could not save file: " + fileName, ex);
    }
  }

  // This method cleans a directory by deleting all its files
  public static void cleanDir(String dir) {
    // Define the path to the directory to be cleaned
    Path dirPath = Paths.get(dir);

    // Try to list all files in the directory and delete them
    try {
      Files.list(dirPath).forEach(file -> {
        if (!Files.isDirectory(file)) {
          try {
            Files.delete(file);
          } catch (IOException e) {
            LOGGER.error("Could not delete file: " + file);
            // System.out.println("Could not delete file: " + file);

          }
        }
      });
    } catch (IOException e) {
      LOGGER.error("Could not list directory: " + dirPath);
     // System.out.println("Could not list directory: " + dirPath);
    }
  }
}


