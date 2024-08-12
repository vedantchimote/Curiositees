/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 * @Time : 08:02 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.curiositees.common.entity.Role;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 19-05-2024, Sunday
 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

  @Autowired
  private RoleRepository roleRepository;

  @Test
  public void testCreateFirstRole() {
    Role roleAdmin = new Role("Admin", "manage everything");
    Role savedRole = roleRepository.save(roleAdmin);
    assertThat(savedRole.getId()).isGreaterThan(0);
  }

  @Test
  public void testCreateRestRoles() {
    Role roleSalesperson = new Role("Salesperson", "manage product price, customers , "
        + "shipping, orders and sales reports");
    Role roleEditor = new Role("Editor", "manage categories, brands, products, articles and menus");
    Role roleShipper = new Role("Shipper", "view products, view orders and update order status");
    Role roleAssistant = new Role("Assistant", "manage questions and reviews");

    roleRepository.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
  }
}
