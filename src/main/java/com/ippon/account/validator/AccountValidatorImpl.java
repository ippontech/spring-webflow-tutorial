package com.ippon.account.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.service.AccountService;

/**
 * Account validator implementation
 * 
 * @author ebrigand
 * 
 */
@Service("accountValidator")
@Scope("prototype")
public class AccountValidatorImpl extends BaseEntityValidatorImpl<Account, AccountService, AccountDaoService> implements AccountValidator {

  private final Logger logger = Logger.getLogger(AccountValidator.class);

  @Autowired
  protected AccountService accountService;

  @Override
  public void validateEditAccount(Account account, ValidationContext context) {
    validateAccountFields(account, context.getMessageContext());
    validateDesactivationDate(account, context.getMessageContext());
  }

  /**
   * Validate the desativation date, check if null and format
   * 
   * @param account
   * @param messageContext
   */
  private void validateDesactivationDate(Account account, MessageContext messageContext) {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
      if (StringUtils.isNotEmpty(account.getDesactivationDateStr())) {
        format.parse(account.getDesactivationDateStr());
      }
    } catch (ParseException e) {
      createErrorMessage(messageContext, "editAccount.field.error.account.desactivationDateStr", "La date de désactivation est malformée");
    }
  }

  /**
   * Generic validation of all account fields and address fields (addresses
   * linked to the account), checking the JPA constraints.
   * 
   * @param account
   * @param messageContext
   */
  private void validateAccountFields(Account account, MessageContext messageContext) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
    if (constraintViolations.size() > 0) {
      for (ConstraintViolation<Account> contraintes : constraintViolations) {
        // Check account
        String propertyPath = contraintes.getPropertyPath().toString();
        // Check addresses
        if (contraintes.getPropertyPath().toString().startsWith("addresses") && contraintes.getPropertyPath().toString().length() > 12) {
          propertyPath = contraintes.getPropertyPath().toString().substring(0, 9).concat(contraintes.getPropertyPath().toString().substring(12, contraintes.getPropertyPath().toString().length()));
        }
        if (!propertyPath.equals("addresses.id")) {
          propertyPath = "editAccount.field.error.account." + propertyPath;
          createErrorMessage(messageContext, propertyPath, contraintes.getMessage());
        }
      }
    }
  }

  @Override
  public AccountService getService() {
    return accountService;
  }

}