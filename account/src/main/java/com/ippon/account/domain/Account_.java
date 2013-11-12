package com.ippon.account.domain;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author ebrigand
 */
@StaticMetamodel(Account.class)
public class Account_ extends BaseEntity_ {

  public static volatile SingularAttribute<Account, String> username;
  public static volatile SingularAttribute<Account, String> firstname;
  public static volatile SingularAttribute<Account, String> lastname;
  public static volatile SingularAttribute<Account, String> password;
  public static volatile SingularAttribute<Account, String> email;
  public static volatile SingularAttribute<Account, Date> desactivationDate;
  public static volatile SingularAttribute<Account, Boolean> enabled;
  public static volatile ListAttribute<Account, Long> addresses;

}
