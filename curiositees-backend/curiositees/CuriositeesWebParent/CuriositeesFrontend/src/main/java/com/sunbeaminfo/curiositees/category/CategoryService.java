/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 * @Time : 08:33 pm
 **/

package com.sunbeaminfo.curiositees.category;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 **/

import com.curiositees.common.entity.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repo;

  public List<Category> listNoChildrenCategories() {
    List<Category> listNoChildrenCategories = new ArrayList<>();

    List<Category> listEnabledCategories = repo.findAllEnabled();

    listEnabledCategories.forEach(category -> {
      Set<Category> children = category.getChildren();
      if (children == null || children.size() == 0) {
        listNoChildrenCategories.add(category);
      }
    });
    return listNoChildrenCategories;
  }
}