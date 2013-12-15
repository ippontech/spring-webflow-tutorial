package com.ippon.account.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * Entity Address
 * 
 * @author ebrigand
 */
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "line1", nullable = false)
  private String line1;

  @Column(name = "line2")
  private String line2;

  @Pattern(regexp = "\\d\\d\\d\\d\\d")
  @Length(min = 5, max = 5)
  @Column(name = "zip_code", nullable = false)
  private String zipCode;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state", nullable = false)
  private String state;

  @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "account", nullable = false)
  private Account account;

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
    if (!account.getAddresses().contains(this)) {
      account.getAddresses().add(this);
    }
  }

  public void removeAccount(Account account) {
    this.account = null;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Address 1  : ");
    builder.append(this.getLine1());
    builder.append("\n");

    builder.append("Address 2  : ");
    builder.append(this.getLine2());
    builder.append("\n");

    builder.append("City       : ");
    builder.append(this.getCity());
    builder.append("\n");

    builder.append("State      : ");
    builder.append(this.getState());
    builder.append("\n");

    builder.append("ZIP        : ");
    builder.append(this.getZipCode());
    builder.append("\n");

    return builder.toString();
  }
}
