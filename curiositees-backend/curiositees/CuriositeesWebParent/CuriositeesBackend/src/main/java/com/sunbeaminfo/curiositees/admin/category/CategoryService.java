/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 * @Time : 09:57 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 06-08-2024, Tuesday
 **/

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository repo;

  public List<Category> listAll() {
    return (List<Category>) repo.findAll();
  }
}