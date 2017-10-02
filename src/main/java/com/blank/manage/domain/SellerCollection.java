package com.blank.manage.domain;

import java.util.Date;

public class SellerCollection {
  private Long id;
  private Long merchantId;
  private Long userId;
  private Long merchantType;
  private Date createTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Long getMerchantType() {
    return merchantType;
  }

  public void setMerchantType(Long merchantType) {
    this.merchantType = merchantType;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
