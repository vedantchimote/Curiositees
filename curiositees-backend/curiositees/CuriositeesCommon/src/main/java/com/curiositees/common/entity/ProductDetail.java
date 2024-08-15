/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 * @Time : 01:43 am
 **/

package com.curiositees.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 13-08-2024, Tuesday
 **/

@Entity
@Table(name = "product_details")
public class ProductDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 10000)
  private String name;

  @Column(nullable = false, length = 10000)
  private String value;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public ProductDetail() {
  }

  public ProductDetail(Integer id, String name, String value, Product product) {
    super();
    this.id = id;
    this.name = name;
    this.value = value;
    this.product = product;
  }

  public ProductDetail(String name, String value, Product product) {
    this.name = name;
    this.value = value;
    this.product = product;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}