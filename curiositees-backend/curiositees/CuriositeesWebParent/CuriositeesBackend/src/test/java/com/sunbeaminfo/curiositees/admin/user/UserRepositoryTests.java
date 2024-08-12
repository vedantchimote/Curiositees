/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 * @Time : 05:16 pm
 **/

package com.sunbeaminfo.curiositees.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.curiositees.common.entity.Role;
import com.curiositees.common.entity.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 25-05-2024, Saturday
 **/

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  public void testCreateUserWithOneRole() {

    Role roleAdmin = testEntityManager.find(Role.class, 1);
    User vedantUser = new User("vedantchimote3301@gmail.com", "vedant1234", "Vedant", "Chimote");
    vedantUser.addRole(roleAdmin);

    User savedUser = userRepository.save(vedantUser);
    assertThat(savedUser.getId()).isGreaterThan(0);
  }

  @Test
  public void testCreateUserWithTwoRoles() {

    User karanUser = new User("karanransing@gmail.com", "123456", "Karan", "Ransing");
    Role roleEditor = new Role(3);
    Role roleAssistant = new Role(5);

    karanUser.addRole(roleEditor);
    karanUser.addRole(roleAssistant);

    User savedUser = userRepository.save(karanUser);
    assertThat(savedUser.getId()).isGreaterThan(0);
  }

  @Test
  public void testListAllUsers() {
    Iterable<User> listUsers = userRepository.findAll();
    listUsers.forEach((user) -> System.out.println(user));
  }

  @Test
  public void testGetUserById() {
    User user = userRepository.findById(1).get();
    System.out.println(user);
    assertThat(user).isNotNull();
  }

  @Test
  public void testUpdateUserDetails() {
    User user = userRepository.findById(1).get();
    user.setEnabled(true);
    user.setEmail("vedantchimote3301@gmail.com");
    userRepository.save(user);
  }

  @Test
  public void testUpdateUserRoles() {
    User userKaran = userRepository.findById(2).get();
    Role roleEditor = new Role(3);
    Role roleSalespersion = new Role(2);

    userKaran.getRoles().remove(roleEditor);
    userKaran.getRoles().add(roleSalespersion);

    userRepository.save(userKaran);
  }

  @Test
  public void testDeleteUser() {
    Integer userId = 2;
    userRepository.deleteById(userId);
  }

  @Test
  public void testGetUserByEmail() {
    String email = "vedantchimote3301@gmail.com";
    User user = userRepository.getUserByEmail(email);
    assertThat(user).isNotNull();
  }

  @Test
  public void testCountById() {
    Integer id = 16;
    Long countById = userRepository.countById(id);

    assertThat(countById).isNotNull().isGreaterThan(0);
  }

  @Test
  public void testDisableUser() {
    Integer id = 3;
    userRepository.updateEnabledStatus(id, false);
  }

  @Test
  public void testEnableUser() {
    Integer id = 3;
    userRepository.updateEnabledStatus(id, true);
  }

  @Test
  public void testListFirstPage() {
    int pageNumber = 1;
    int pageSize = 4;

    Pageable pageable = PageRequest.of(pageNumber, pageSize);

    Page<User> page = userRepository.findAll(pageable);

    List<User> listUsers = page.getContent();
    listUsers.forEach(user -> System.out.println(user));

    assertThat(listUsers.size()).isEqualTo(pageSize);
  }

  @Test
  public void testSearchUsers() {
    String keyword = "vedantchimote";

    int pageNumber = 0;
    int pageSize = 4;

    Pageable pageable = PageRequest.of(pageNumber, pageSize);

    Page<User> page = userRepository.findAll(keyword, pageable);

    List<User> listUsers = page.getContent();
    listUsers.forEach(user -> System.out.println(user));

    assertThat(listUsers.size()).isGreaterThan(0);
  }
}
