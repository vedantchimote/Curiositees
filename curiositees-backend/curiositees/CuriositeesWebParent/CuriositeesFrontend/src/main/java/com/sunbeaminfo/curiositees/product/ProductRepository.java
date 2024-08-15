
/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
 * @Time : 03:11 pm
**/

package com.sunbeaminfo.curiositees.product;

import com.curiositees.common.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 14-08-2024, Wednesday
**/

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.enabled = true "
        + "AND (p.category.id = ?1 OR p.category.allParentIDs LIKE %?2%)"
        + " ORDER BY p.name ASC")
    public Page<Product> listByCategory(Integer categoryId, String categoryIDMatch, Pageable pageable);

    public Product findByAlias(String alias);

    @Query(value = "SELECT * FROM products WHERE enabled = true AND "
        + "MATCH(name, short_description, full_description) AGAINST (?1)",
        nativeQuery = true)
   // @Query(value ="SELECT * FROM products WHERE MATCH(name, description) AGAINST(?1)", nativeQuery = true)
    public Page<Product> search(String keyword, Pageable pageable);
}