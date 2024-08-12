/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 09:24 pm
 **/

package com.sunbeaminfo.curiositees.admin.product;

import com.curiositees.common.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

@Service
public class ProductService {

  @Autowired
  private ProductRepository repo;

  public List<Product> listAll() {
    return (List<Product>) repo.findAll();
  }
}