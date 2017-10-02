package com.blank.manage.domain;

import java.util.Date;

public class Seller {
  private Long id;
  private String name;
  private String description;
  private Long deliveryTime;
  private Double score;
  private Double serviceScore;
  private Double foodScore;
  private Double rankRate;
  private Double minPrice;
  private Double deliveryPrice;
  private String bulletin;
  private String avatar;
  private String sellercol;
  private String address;
  private String mobile;
  private String distInfo;
  private String distStartTime;
  private String distEndTime;
  private Date createtime;
  private Date updatetime;
  private Long status;

  //非持久层对象
  private Long collectionId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(Long deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public Double getServiceScore() {
    return serviceScore;
  }

  public void setServiceScore(Double serviceScore) {
    this.serviceScore = serviceScore;
  }

  public Double getFoodScore() {
    return foodScore;
  }

  public void setFoodScore(Double foodScore) {
    this.foodScore = foodScore;
  }

  public Double getRankRate() {
    return rankRate;
  }

  public void setRankRate(Double rankRate) {
    this.rankRate = rankRate;
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

  public String getBulletin() {
    return bulletin;
  }

  public void setBulletin(String bulletin) {
    this.bulletin = bulletin;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getSellercol() {
    return sellercol;
  }

  public void setSellercol(String sellercol) {
    this.sellercol = sellercol;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getDistInfo() {
    return distInfo;
  }

  public void setDistInfo(String distInfo) {
    this.distInfo = distInfo;
  }

  public String getDistStartTime() {
    return distStartTime;
  }

  public void setDistStartTime(String distStartTime) {
    this.distStartTime = distStartTime;
  }

  public String getDistEndTime() {
    return distEndTime;
  }

  public void setDistEndTime(String distEndTime) {
    this.distEndTime = distEndTime;
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

  public Long getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(Long collectionId) {
    this.collectionId = collectionId;
  }
}
