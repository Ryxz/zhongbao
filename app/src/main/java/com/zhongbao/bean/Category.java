package com.zhongbao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

  @SerializedName("categoryID")
  private String categoryID;
  @SerializedName("categoryName")
  private String categoryName;
  @SerializedName("product")
  private List<Product> product;

  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<Product> getProduct() {
    return product;
  }

  public void setProduct(List<Product> product) {
    this.product = product;
  }
}
