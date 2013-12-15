package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.Address;

public interface AddressDaoService extends BaseEntityDaoService<Address> {
  /*
   * Address getAddress(String addressId);
   * 
   * List<Address> getByAccount(Account account);
   */

  <S extends Object> List<Address> getBy(String columnName, String columnValue);

}
