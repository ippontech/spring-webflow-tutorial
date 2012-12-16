package com.ippon.account.service;

import java.util.List;

import com.ippon.account.dao.AddressDaoService;
import com.ippon.account.domain.Address;

public interface AddressService extends BaseEntityService<Address, AddressDaoService> {

  List<Address> getBy(String columnNamee, String columnValue);

}
