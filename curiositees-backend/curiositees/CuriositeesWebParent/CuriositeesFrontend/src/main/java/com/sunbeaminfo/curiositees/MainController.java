package com.sunbeaminfo.curiositees;
/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 23-04-2024, Tuesday
 * @Time : 05:42 pm
 **/

import com.curiositees.common.entity.Category;
import com.sunbeaminfo.curiositees.category.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan(basePackages = "com.sunbeaminfo.curiositees.category")
public class MainController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping("")
  public String viewHomePage(Model model) {
    List<Category> listCategories = categoryService.listNoChildrenCategories();
    model.addAttribute("listCategories", listCategories);
    return "index";
  }

}
