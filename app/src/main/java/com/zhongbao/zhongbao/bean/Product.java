package com.zhongbao.zhongbao.bean;

import com.google.gson.annotations.SerializedName;

public class Product {

  /**
   * 如果后台给你返回了,那最好
   */
  private String categoryID;
  @SerializedName("productID")
  private String productID;
  @SerializedName("productName")
  private String productName;
  @SerializedName("productPrice")
  private String productPrice;
  @SerializedName("surplusNumber")
  private String surplusNumber;
  @SerializedName("totalNumber")
  private String totalNumber;

  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(String productPrice) {
    this.productPrice = productPrice;
  }

  public String getSurplusNumber() {
    return surplusNumber;
  }

  public void setSurplusNumber(String surplusNumber) {
    this.surplusNumber = surplusNumber;
  }

  public String getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(String totalNumber) {
    this.totalNumber = totalNumber;
  }
}