package com.ippon.account.service;

import java.util.List;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;

/**
 * Front Service Layer interface to manage accounts
 * 
 * @author ebrigand
 * 
 */
public interface AccountService extends BaseEntityService<Account, AccountDaoService> {

  /**
   * Get all the accounts enabled or not
   * 
   * @param isEnabled
   * @return
   */
  List<Account> getAll(boolean isEnabled);

  /**
   * Add a new address to the account
   * 
   * @param entity
   */
  void addNewAddress(Account entity);

  /**
   * Delete an address to the account by the index of addresses
   * 
   * @param entity
   * @param addressIdx
   */
  void deleteAddress(Account entity, String addressIdx);
}
