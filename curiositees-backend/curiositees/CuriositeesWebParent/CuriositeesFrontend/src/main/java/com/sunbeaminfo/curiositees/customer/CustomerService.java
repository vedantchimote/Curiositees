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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

@Service
public class CustomerService {

  @Autowired
  private CountryRepository countryRepo;
  @Autowired private CustomerRepository customerRepo;

  public List<Country> listAllCountries() {
    return countryRepo.findAllByOrderByNameAsc();
  }

  public boolean isEmailUnique(String email) {
    Customer customer = customerRepo.findByEmail(email);
    return customer == null;
  }
}