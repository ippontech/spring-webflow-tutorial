package com.ippon.account.service;

import java.util.List;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;

public interface AccountService extends BaseEntityService<Account, AccountDaoService> {

  List<Account> getAll(boolean isEnabled);

  void addNewAddress(Account entity);

  void deleteAddress(Account entity, String addressIdx);
}
