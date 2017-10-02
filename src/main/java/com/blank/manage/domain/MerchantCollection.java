package com.blank.manage.domain;

import java.util.Date;

public class MerchantCollection {
  private Long id;
  private String merchantType;
  private Long merchantId;
  private Long userId;
  private Date createTime;

  //非持久层对象
  private String merchantName;
  private String merchantAvatar;
  private Double minPrice;
  private Double deliveryPrice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMerchantType() {
    return merchantType;
  }

  public void setMerchantType(String merchantType) {
    this.merchantType = merchantType;
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getMerchantAvatar() {
    return merchantAvatar;
  }

  public void setMerchantAvatar(String merchantAvatar) {
    this.merchantAvatar = merchantAvatar;
  }

  public Double getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Double minPrice) {
    this.minPrice = minPrice;
  }

  public Double getDeliveryPrice() {
    return deliveryPrice;
  }

  public void setDeliveryPrice(Double deliveryPrice) {
    this.deliveryPrice = deliveryPrice;
  }
}
