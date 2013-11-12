package com.ippon.account.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

/**
 * @author ebrigand
 */
@Entity
@Table(name = "account")
public class Account extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "user_name", nullable = false)
  private String username;

  @Column(name = "first_name", nullable = false)
  private String firstname;

  @Column(name = "last_name", nullable = false)
  private String lastname;

  @Column(name = "password", nullable = false)
  private String password;

  @Email
  @Column(name = "email", nullable = false)
  private String email;

  @Transient
  @Pattern(regexp = "(\\d\\d[/]){2}\\d\\d\\d\\d")
  private String desactivationDateStr;

  @Future
  @Column(name = "desactivation_date")
  private Date desactivationDate;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  /**
   * Remove of CascadeType.ALL because doesn't work with the refresh()
   * https://hibernate.onjira.com/browse/HHH-2643
   **/
  @NotNull
  @Valid
  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "account")
  private List<Address> addresses;

  public String getUsername() {
    return username;
  }

  public void setUsername(String accountName) {
    this.username = accountName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDesactivationDateStr() {
    if (!isInitialized) {
      initialize();
    }
    return desactivationDateStr;
  }

  public void setDesactivationDateStr(String desactivationDateStr) {
    this.desactivationDateStr = desactivationDateStr;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
      desactivationDate = format.parse(this.desactivationDateStr);
    } catch (ParseException e) {
    }
  }

  public Date getDesactivationDate() {
    return desactivationDate;
  }

  public void setDesactivationDate(Date desactivationDate) {
    this.desactivationDate = desactivationDate;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void addAddress(Address address) {
    if (addresses == null) {
      addresses = new ArrayList<Address>();
    }
    addresses.add(address);
    if (address.getAccount() != this) {
      address.setAccount(this);
    }
  }

  public void removeAddress(Address address) {
    if (addresses != null) {
      addresses.remove(address);
    }
  }

  @Override
  public void initialize() {
    super.initialize();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    if (desactivationDate != null) {
      desactivationDateStr = format.format(desactivationDate);
    }
  }
}
