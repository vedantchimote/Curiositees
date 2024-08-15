/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:45 pm
 **/

package com.sunbeaminfo.curiositees.customer;

import com.curiositees.common.entity.Country;
import com.curiositees.common.entity.Customer;
import com.sunbeaminfo.curiositees.setting.CountryRepository;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import net.bytebuddy.utility.RandomString;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Service
@Transactional
public class CustomerService {

  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  private CountryRepository countryRepo;
  @Autowired
  private CustomerRepository customerRepo;

  public List<Country> listAllCountries() {
    return countryRepo.findAllByOrderByNameAsc();
  }

  public boolean isEmailUnique(String email) {
    Customer customer = customerRepo.findByEmail(email);
    return customer == null;
  }


  public void registerCustomer(Customer customer) {
    encodePassword(customer);
    customer.setEnabled(false);
    customer.setCreatedTime(new Date());

    String randomCode = RandomString.make(64);
    customer.setVerificationCode(randomCode);

    customerRepo.save(customer);

  }

  private void encodePassword(Customer customer) {
    String encodedPassword = passwordEncoder.encode(customer.getPassword());
    customer.setPassword(encodedPassword);
  }

  public boolean verify(String verificationCode) {
    Customer customer = customerRepo.findByVerificationCode(verificationCode);

    if (customer == null || customer.isEnabled()) {
      return false;
    } else {
      customerRepo.enable(customer.getId());
      return true;
    }
  }
}