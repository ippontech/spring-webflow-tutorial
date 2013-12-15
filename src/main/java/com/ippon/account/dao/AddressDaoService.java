package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.Address;

/**
 * DAO Layer interface to manage addresses
 * 
 * @author ebrigand
 * 
 */
public interface AddressDaoService extends BaseEntityDaoService<Address> {

  /**
   * Search addresses by column name and column value. Generic part, if a new
   * column is created in Address, this method will work for the new column
   * Introspection is used for the column name
   * 
   * @param columnName
   * @param columnValue
   * @return
   * @throws NoSuchFieldException
   * @throws IllegalAccessException
   */
  <S extends Object> List<Address> getBy(String columnName, String columnValue);

}
