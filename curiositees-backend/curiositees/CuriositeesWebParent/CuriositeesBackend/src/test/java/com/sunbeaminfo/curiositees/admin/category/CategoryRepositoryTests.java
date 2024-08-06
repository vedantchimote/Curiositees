/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 * @Time : 01:17 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 **/

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {

  @Autowired
  private CategoryRepository repo;

  @Test
  public void testCreateRootCategory() {
    Category category = new Category("Electronics");
    Category savedCategory = repo.save(category);

    assertThat(savedCategory.getId()).isGreaterThan(0);
  }

  @Test
  public void testCreateSubCategory() {
    Category parent = new Category(3);
    Category subCategory = new Category("iPhone", parent);
    Category savedCategory = repo.save(subCategory);

    assertThat(savedCategory.getId()).isGreaterThan(0);
  }

  @Test
  public void testGetCategory() {
    Category category = repo.findById(3).get();
    System.out.println(category.getName());

    Set<Category> children = category.getChildren();

    for (Category subCategory : children) {
      System.out.println(subCategory.getName());
    }

    assertThat(children.size()).isGreaterThan(0);
  }

  @Test
  public void testPrintHierarchicalCategories() {
    Iterable<Category> categories = repo.findAll();

    for (Category category : categories) {
      if (category.getParent() == null) {
        System.out.println(category.getName());

        Set<Category> children = category.getChildren();

        for (Category subCategory : children) {
          System.out.println("--" + subCategory.getName());
          printChildren(subCategory, 1);
        }
      }
    }
  }

  private void printChildren(Category parent, int subLevel) {
    int newSubLevel = subLevel + 1;
    Set<Category> children = parent.getChildren();

    for (Category subCategory : children) {
      for (int i = 0; i < newSubLevel; i++) {
        System.out.print("--");
      }

      System.out.println(subCategory.getName());

      printChildren(subCategory, newSubLevel);
    }
  }

  @Test
  public void testListRootCategories() {
    List<Category> rootCategories = repo.findRootCategories();
    rootCategories.forEach(cat -> System.out.println(cat.getName()));
  }
}