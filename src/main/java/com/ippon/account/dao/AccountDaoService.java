package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.Account;

public interface AccountDaoService extends BaseEntityDaoService<Account> {

  List<Account> getAll(boolean isEnabled);

}
