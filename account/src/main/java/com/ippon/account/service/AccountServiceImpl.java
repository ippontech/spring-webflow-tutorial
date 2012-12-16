package com.ippon.account.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.domain.Address;

@ApplicationScoped
@Named("accountService")
public class AccountServiceImpl extends BaseEntityServiceImpl<Account, AccountDaoService> implements AccountService {

  @Inject
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
