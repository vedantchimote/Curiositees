/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 * @Time : 08:39 pm
 **/

package com.sunbeaminfo.curiositees.admin.brand;

import com.curiositees.common.entity.Brand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 12-08-2024, Monday
 **/

@Service
public class BrandService {
  @Autowired
  private BrandRepository repo;

  public List<Brand> listAll() {
    return (List<Brand>) repo.findAll();
  }
}