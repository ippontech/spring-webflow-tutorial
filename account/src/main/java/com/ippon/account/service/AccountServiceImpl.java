package com.ippon.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.domain.Address;

@Controller("accountService")
@Scope("singleton")
public class AccountServiceImpl extends BaseEntityServiceImpl<Account, AccountDaoService> implements AccountService {

  @Autowired
  private AccountDaoService accountDaoService;

  @Override
  protected Account getNew() {
    return new Account();
  }

  @Override
  public List<Account> getAll(boolean isEnabled) {
    return getDao().getAll(isEnabled);
  }

  @Override
  public void addNewAddress(Account entity) {
    Address address = new Address();
    entity.addAddress(address);
  }

  @Override
  public void deleteAddress(Account entity, String addressIdx) {
    Address address = entity.getAddresses().get(Integer.valueOf(addressIdx));
    entity.removeAddress(address);
  }

  @Override
  public AccountDaoService getDao() {
    return accountDaoService;
  }

}
