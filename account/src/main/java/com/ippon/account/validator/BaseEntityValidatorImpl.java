package com.ippon.account.validator;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;
import com.ippon.account.service.BaseEntityService;

public abstract class BaseEntityValidatorImpl<E extends BaseEntity, G extends BaseEntityService<E, H>, H extends BaseEntityDaoService<E>> implements BaseEntityValidator<E, G, H> {

  @Override
  public abstract G getService();

  protected void createErrorMessage(MessageContext messageContext, String fieldId, String errorMsg) {
    messageContext.addMessage(new MessageBuilder().error().source(fieldId).code(fieldId).arg(errorMsg).build());
  }

}
