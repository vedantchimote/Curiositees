/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 08:39 pm
 **/

package com.sunbeaminfo.curiositees.admin.brand;

import com.curiositees.common.entity.Brand;
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
public class BrandController {

  @Autowired
  private BrandService service;

  @GetMapping("/brands")
  public String listAll(Model model) {
    List<Brand> listBrands = service.listAll();
    model.addAttribute("listBrands", listBrands);

    return "brands/brands";
  }
}
