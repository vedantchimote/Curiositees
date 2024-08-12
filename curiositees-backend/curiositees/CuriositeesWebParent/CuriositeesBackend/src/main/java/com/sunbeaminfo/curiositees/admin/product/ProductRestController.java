/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 * @Time : 12:41 am
 **/

package com.sunbeaminfo.curiositees.admin.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 **/

@RestController
public class ProductRestController {

  @Autowired
  private ProductService service;

  @PostMapping("/products/check_unique")
  public String checkUnique(@Param("id") Integer id, @Param("name") String name) {
    return service.checkUnique(id, name);
  }

}