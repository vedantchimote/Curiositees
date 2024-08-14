/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
 * @Time : 03:11 pm
 **/

package com.sunbeaminfo.curiositees.product;

import com.curiositees.common.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
 **/

@Service
public class ProductService {
  public static final int PRODUCTS_PER_PAGE = 10;

  @Autowired
  private ProductRepository repo;

  public Page<Product> listByCategory(int pageNum, Integer categoryId) {
    String categoryIdMatch = "-" + String.valueOf(categoryId) + "-";
    Pageable pageable = PageRequest.of(pageNum - 1, PRODUCTS_PER_PAGE);

    return repo.listByCategory(categoryId, categoryIdMatch, pageable);
  }
}