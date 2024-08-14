/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 * @Time : 08:35 pm
 **/

package com.sunbeaminfo.curiositees.category;
import static org.assertj.core.api.Assertions.assertThat;
import com.curiositees.common.entity.Category;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoryRepositoryTests {

  @Autowired
  private CategoryRepository repo;

  @Test
  public void testListEnabledCategories() {
    List<Category> categories = repo.findAllEnabled();
    categories.forEach(category -> {
      System.out.println(category.getName() + " (" + category.isEnabled() + ")");
    });
  }

  @Test
  public void testFindCategoryByAlias() {
    String alias = "electronics";
    Category category = repo.findByAliasEnabled(alias);

    assertThat(category).isNotNull();
  }
}