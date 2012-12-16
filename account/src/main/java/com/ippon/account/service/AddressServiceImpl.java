package com.ippon.account.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ippon.account.dao.AddressDaoService;
import com.ippon.account.domain.Address;

@ApplicationScoped
@Named("addressService")
public class AddressServiceImpl extends BaseEntityServiceImpl<Address, AddressDaoService> implements AddressService {

  @Inject
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
