package com.ippon.account.validator;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;
import com.ippon.account.service.BaseEntityService;

/**
 * Abstract validator for entities
 * 
 * @author ebrigand
 * 
 * @param <E>
 * @param <G>
 * @param <H>
 */
public abstract class BaseEntityValidatorImpl<E extends BaseEntity, G extends BaseEntityService<E, H>, H extends BaseEntityDaoService<E>> implements BaseEntityValidator<E, G, H> {

  @Override
  public abstract G getService();

  /**
   * Create an error message on the web page
   * 
   * @param messageContext
   * @param fieldId
   * @param errorMsg
   */
  protected void createErrorMessage(MessageContext messageContext, String fieldId, String errorMsg) {
    messageContext.addMessage(new MessageBuilder().error().source(fieldId).code(fieldId).arg(errorMsg).build());
  }

}
