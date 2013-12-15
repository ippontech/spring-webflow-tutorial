package com.ippon.account.validator;

import org.springframework.binding.validation.ValidationContext;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.service.AccountService;

/**
 * Validator for account entities
 * 
 * @author ebrigand
 * 
 */
public interface AccountValidator extends BaseEntityValidator<Account, AccountService, AccountDaoService> {

  /**
   * Validate an account when edited or saved
   * 
   * @param account
   * @param context
   */
  void validateEditAccount(Account account, ValidationContext context);

}
