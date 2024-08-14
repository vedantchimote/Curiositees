/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
 * @Time : 03:45 pm
 **/

package com.sunbeaminfo.curiositees.product;
import static org.assertj.core.api.Assertions.assertThat;
import com.curiositees.common.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTests {

  @Autowired
  ProductRepository repo;

  @Test
  public void testFindByAlias() {
    String alias = "canon-eos-m50";
    Product product = repo.findByAlias(alias);

    assertThat(product).isNotNull();
  }
}