package com.ippon.account.service;

import java.util.List;

import com.ippon.account.dao.AddressDaoService;
import com.ippon.account.domain.Address;

/**
 * Front Service interface layer to manage addresses
 * 
 * @author ebrigand
 * 
 */
public interface AddressService extends BaseEntityService<Address, AddressDaoService> {

  /**
   * Search addresses by column name and column value.
   * 
   * @param columnName
   * @param columnValue
   * @return
   */
  List<Address> getBy(String columnName, String columnValue);

}
