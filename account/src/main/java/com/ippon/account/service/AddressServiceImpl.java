package com.ippon.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ippon.account.dao.AddressDaoService;
import com.ippon.account.domain.Address;

@Controller("addressService")
@Scope("singleton")
public class AddressServiceImpl extends BaseEntityServiceImpl<Address, AddressDaoService> implements AddressService {

  @Autowired
  private AddressDaoService addressDaoService;

  @Override
  protected Address getNew() {
    return new Address();
  }

  @Override
  public AddressDaoService getDao() {
    return addressDaoService;
  }

  @Override
  public List<Address> getBy(String columnName, String columnValue) {
    return getDao().getBy(columnName, columnValue);
  }

}
