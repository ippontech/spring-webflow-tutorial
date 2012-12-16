package com.ippon.account.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;

import com.ippon.account.dao.AccountDaoService;
import com.ippon.account.domain.Account;
import com.ippon.account.service.AccountService;

@SessionScoped
@Named("accountValidator")
public class AccountValidatorImpl extends BaseEntityValidatorImpl<Account, AccountService, AccountDaoService> implements AccountValidator {

  private final Logger logger = Logger.getLogger(AccountValidator.class);

  @Inject
  protected AccountService accountService;

  @Override
  public void validateEditAccount(Account account, ValidationContext context) {
    validateAccountFields(account, context.getMessageContext());
    validateDesactivationDate(account, context.getMessageContext());
  }

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

  private void validateAccountFields(Account account, MessageContext messageContext) {
    /**
     * TO_DO: Il serait finalement mieux de faire de la validation champs par
     * champs (avec ValidationUtils, EmailValidator....), le système actuel est
     * trop générique et ne fonctionne pas très bien comme le cssErrorClass qui
     * ne marche pas sur tous les champs
     */
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
    if (constraintViolations.size() > 0) {
      for (ConstraintViolation<Account> contraintes : constraintViolations) {
        // Cas compte
        String propertyPath = contraintes.getPropertyPath().toString();
        // Cas addresse
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