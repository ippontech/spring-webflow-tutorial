package com.ippon.account.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Abstract Entity
 * 
 * @author ebrigand
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Transient
  protected boolean isInitialized = false;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setInitialized(boolean isInitialized) {
    this.isInitialized = isInitialized;
  }

  /**
   * Template pattern to initialize transient values in sub classes. Used when
   * entity is created, loaded or refreshed
   */
  public void initialize() {
    if (!isInitialized) {
      this.initDefaultValues();
    }
    isInitialized = true;
  }

  protected void initDefaultValues() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
      return false;
    }

    BaseEntity that = (BaseEntity) obj;

    return this.id.equals(that.getId());
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return id == null ? 0 : id.hashCode();
  }
}
