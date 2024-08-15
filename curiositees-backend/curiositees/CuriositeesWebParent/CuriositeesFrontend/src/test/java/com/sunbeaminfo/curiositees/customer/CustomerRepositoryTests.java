/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:54 pm
 **/

package com.sunbeaminfo.curiositees.customer;
import static org.assertj.core.api.Assertions.assertThat;
import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.Customer;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

  @Autowired
  private CustomerRepository repo;
  @Autowired private TestEntityManager entityManager;

  @Test
  public void testCreateCustomer1() {
    Integer countryId = 1; // India
    Country country = entityManager.find(Country.class, countryId);

    Customer customer = new Customer();
    customer.setCountry(country);
    customer.setFirstName("Vedant");
    customer.setLastName("Chimote");
    customer.setPassword("vedant1234");
    customer.setEmail("vedantchimote3302.com");
    customer.setPhoneNumber("8209304333");
    customer.setAddressLine1("173 , A-, Shah & Nahar Indl.estate, Sunmill Road");
    customer.setAddressLine2("Dhanraj Mill Compound, Lower Parel (west)");
    customer.setCity("Nagpur");
    customer.setState("Maharashtra");
    customer.setPostalCode("441108");
    customer.setCreatedTime(new Date());

    Customer savedCustomer = repo.save(customer);

    assertThat(savedCustomer).isNotNull();
    assertThat(savedCustomer.getId()).isGreaterThan(0);
  }

  @Test
  public void testListCustomers() {
    Iterable<Customer> customers = repo.findAll();
    customers.forEach(System.out::println);

    assertThat(customers).hasSizeGreaterThan(0);
  }

  @Test
  public void testUpdateCustomer() {
    Integer customerId = 1;
    String lastName = "Chimote";

    Customer customer = repo.findById(customerId).get();
    customer.setLastName(lastName);
    customer.setEnabled(true);

    Customer updatedCustomer = repo.save(customer);
    assertThat(updatedCustomer.getLastName()).isEqualTo(lastName);
  }

  @Test
  public void testGetCustomer() {
    Integer customerId = 1;
    Optional<Customer> findById = repo.findById(customerId);

    assertThat(findById).isPresent();

    Customer customer = findById.get();
    System.out.println(customer);
  }

  @Test
  public void testDeleteCustomer() {
    Integer customerId = 2;
    repo.deleteById(customerId);

    Optional<Customer> findById = repo.findById(customerId);
    assertThat(findById).isNotPresent();
  }

  @Test
  public void testFindByEmail() {
    String email = "vedantchimote3302@gmail.com";
    Customer customer = repo.findByEmail(email);

    assertThat(customer).isNotNull();
    System.out.println(customer);
  }

  @Test
  public void testFindByVerificationCode() {
    String code = "vedant1234";
    Customer customer = repo.findByVerificationCode(code);

    assertThat(customer).isNotNull();
    System.out.println(customer);
  }

  @Test
  public void testEnableCustomer() {
    Integer customerId = 1;
    repo.enable(customerId);

    Customer customer = repo.findById(customerId).get();
    assertThat(customer.isEnabled()).isTrue();
  }
}