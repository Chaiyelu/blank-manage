package com.blank.manage.domain;

public class FoodRating {
  private Long id;
  private Long sellerId;
  private Long userId;
  private Long foodId;
  private String rateTime;
  private String deliveryTime;
  private Long score;
  private Integer rateType;
  private String text;
  private Long status;

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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getFoodId() {
    return foodId;
  }

  public void setFoodId(Long foodId) {
    this.foodId = foodId;
  }

  public String getRateTime() {
    return rateTime;
  }

  public void setRateTime(String rateTime) {
    this.rateTime = rateTime;
  }

  public String getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(String deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public Integer getRateType() {
    return rateType;
  }

  public void setRateType(Integer rateType) {
    this.rateType = rateType;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "FoodRating{" +
            "id=" + id +
            ", sellerId=" + sellerId +
            ", userId=" + userId +
            ", foodId=" + foodId +
            ", rateTime='" + rateTime + '\'' +
            ", deliveryTime='" + deliveryTime + '\'' +
            ", score=" + score +
            ", rateType=" + rateType +
            ", text='" + text + '\'' +
            ", status=" + status +
            '}';
  }
}
