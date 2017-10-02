package com.blank.manage.domain;

import java.util.Date;

public class Delivery {
  private Long id;
  private String consignee;
  private String tel;
  private String address;
  private String area;
  private Long zipcode;
  private Long selected;
  private Long userId;
  private Date createtime;
  private Date updatetime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getConsignee() {
    return consignee;
  }

  public void setConsignee(String consignee) {
    this.consignee = consignee;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public Long getZipcode() {
    return zipcode;
  }

  public void setZipcode(Long zipcode) {
    this.zipcode = zipcode;
  }

  public Long getSelected() {
    return selected;
  }

  public void setSelected(Long selected) {
    this.selected = selected;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
}
