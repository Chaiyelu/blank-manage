package com.blank.manage.domain;

public class Project {
  private Long id;
  private java.sql.Timestamp createdat;
  private java.sql.Timestamp updatedat;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public java.sql.Timestamp getCreatedat() {
    return createdat;
  }

  public void setCreatedat(java.sql.Timestamp createdat) {
    this.createdat = createdat;
  }

  public java.sql.Timestamp getUpdatedat() {
    return updatedat;
  }

  public void setUpdatedat(java.sql.Timestamp updatedat) {
    this.updatedat = updatedat;
  }
}
