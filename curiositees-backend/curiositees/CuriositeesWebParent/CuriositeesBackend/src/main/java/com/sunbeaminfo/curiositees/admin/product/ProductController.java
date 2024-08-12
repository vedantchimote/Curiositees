/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 09:24 pm
 **/

package com.sunbeaminfo.curiositees.admin.product;

import com.curiositees.common.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

@Controller
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public String listAll(Model model) {
    List<Product> listProducts = productService.listAll();

    model.addAttribute("listProducts", listProducts);

    return "products/products";
  }
}