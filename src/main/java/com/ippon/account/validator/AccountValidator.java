package com.ippon.account.validator;

import org.springframework.binding.validation.ValidationContext;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.service.AccountService;

public interface AccountValidator extends BaseEntityValidator<Account, AccountService, AccountDaoService> {

  void validateEditAccount(Account account, ValidationContext context);

}
