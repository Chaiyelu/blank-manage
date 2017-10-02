package com.blank.manage.domain;

import java.util.Date;

public class Checkcode {
  private Long id;
  private String mobile;
  private String code;
  private String ip;
  private Long status;
  private Date expireAt;
  private Long used;
  private Date usingAt;
  private Date createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Date getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(Date expireAt) {
    this.expireAt = expireAt;
  }

  public Long getUsed() {
    return used;
  }

  public void setUsed(Long used) {
    this.used = used;
  }

  public Date getUsingAt() {
    return usingAt;
  }

  public void setUsingAt(Date usingAt) {
    this.usingAt = usingAt;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }
}
