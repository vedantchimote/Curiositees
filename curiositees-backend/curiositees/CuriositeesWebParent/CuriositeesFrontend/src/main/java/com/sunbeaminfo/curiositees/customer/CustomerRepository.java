/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 * @Time : 07:54 pm
 **/

package com.sunbeaminfo.curiositees.customer;

import com.curiositees.common.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 15-08-2024, Thursday
 **/

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  @Query("SELECT c FROM Customer c WHERE c.email = ?1")
  public Customer findByEmail(String email);

  @Query("SELECT c FROM Customer c WHERE c.verificationCode = ?1")
  public Customer findByVerificationCode(String code);

  @Query("UPDATE Customer c SET c.enabled = true WHERE c.id = ?1")
  @Modifying
  public void enable(Integer id);
}