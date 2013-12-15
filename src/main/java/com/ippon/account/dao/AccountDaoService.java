package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.Account;

/**
 * DAO Layer interface to manage accounts
 * 
 * @author ebrigand
 * 
 */
public interface AccountDaoService extends BaseEntityDaoService<Account> {

  /**
   * Get all the accounts enabled or not
   * 
   * @param isEnabled
   * @return
   */
  List<Account> getAll(boolean isEnabled);

}
