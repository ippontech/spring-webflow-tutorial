package com.ippon.account.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author ebrigand
 */
@StaticMetamodel(Address.class)
public class Address_ extends BaseEntity_ {

  public static volatile SingularAttribute<Address, String> line1;
  public static volatile SingularAttribute<Address, String> line2;
  public static volatile SingularAttribute<Address, String> zipCode;
  public static volatile SingularAttribute<Address, String> city;
  public static volatile SingularAttribute<Address, String> state;
  public static volatile SingularAttribute<Address, Account> account;

}
