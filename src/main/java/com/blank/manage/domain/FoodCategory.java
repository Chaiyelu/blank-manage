package com.blank.manage.domain;

import java.util.Date;
import java.util.List;

public class FoodCategory {
  private Long id;
  private Long sellerId;
  private String name;
  private Long supportId;
  private Date createtime;
  private Date updatetime;
  private Long status;
  private List<Food> foods;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getSupportId() {
    return supportId;
  }

  public void setSupportId(Long supportId) {
    this.supportId = supportId;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Date getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(Date updatetime) {
    this.updatetime = updatetime;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public List<Food> getFoods() {
    return foods;
  }

  public void setFoods(List<Food> foods) {
    this.foods = foods;
  }
}
