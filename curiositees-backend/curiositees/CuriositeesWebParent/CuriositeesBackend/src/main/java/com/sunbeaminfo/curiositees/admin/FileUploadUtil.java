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
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 10-06-2024, Monday
 **/

public class FileUploadUtil {

  public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile)
      throws IOException {

    //Before changing the run configuration (#Ignore)
//    Path uploadPath = Paths.get(
//        "curiositees-backend//curiositees//CuriositeesWebParent//CuriositeesBackend//src//main//resources//static//images//",
//        uploadDir);

    Path uploadPath = Paths.get(uploadDir);

    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    try (InputStream inputStream = multipartFile.getInputStream()) {
      Path filePath = uploadPath.resolve(fileName);
      Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException ex) {
      throw new IOException("Could not save file: " + fileName, ex);
    }
  }

  public static void cleanDir(String dir) {
    Path dirPath = Paths.get(dir);

    try {
      Files.list(dirPath).forEach(file -> {
        if (!Files.isDirectory(file)) {
          try {
            Files.delete(file);
          } catch (IOException e) {
            System.out.println("Could not delete file: " + file);
          }
        }
      });
    } catch (IOException e) {
      System.out.println("Could not list directory: " + dirPath);
    }
  }
}


