/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 * @Time : 09:57 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 **/

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repo;

  public List<Category> listAll() {
    return (List<Category>) repo.findAll();
  }

  public Category save(Category category) {
    return repo.save(category);
  }

  public List<Category> listCategoriesUsedInForm() {
    List<Category> categoriesUsedInForm = new ArrayList<>();

    Iterable<Category> categoriesInDB = repo.findAll();

    for (Category category : categoriesInDB) {
      if (category.getParent() == null) {
        categoriesUsedInForm.add(Category.copyIdAndName(category));

        Set<Category> children = category.getChildren();

        for (Category subCategory : children) {
          String name = "--" + subCategory.getName();
          categoriesUsedInForm.add(Category.copyIdAndName(subCategory.getId(), name));

          listChildren(categoriesUsedInForm, subCategory, 1);
        }
      }
    }

    return categoriesUsedInForm;
  }

  private void listChildren(List<Category> categoriesUsedInForm, Category parent, int subLevel) {
    int newSubLevel = subLevel + 1;
    Set<Category> children = parent.getChildren();

    for (Category subCategory : children) {
      String name = "";
      for (int i = 0; i < newSubLevel; i++) {
        name += "--";
      }
      name += subCategory.getName();

      categoriesUsedInForm.add(Category.copyIdAndName(subCategory.getId(), name));

      listChildren(categoriesUsedInForm, subCategory, newSubLevel);
    }
  }
}