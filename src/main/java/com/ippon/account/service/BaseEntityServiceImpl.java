package com.ippon.account.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.context.MessageSource;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;

/**
 * Front Service implementation layer for common actions on entities
 * 
 * @author ebrigand
 * 
 * @param <E>
 * @param <F>
 */
public abstract class BaseEntityServiceImpl<E extends BaseEntity, F extends BaseEntityDaoService<E>> implements BaseEntityService<E, F> {

  @Autowired
  @Qualifier("messageSource")
  private MessageSource messageSource;

  /**
   * Create a new entity, not persisted, used for getNewWithDefaults
   * 
   * @return
   */
  protected abstract E getNew();

  @Override
  public void save(E entity, MessageContext messageContext, String messageKey) {
    messageContext.addMessage(new MessageBuilder().info().code(messageKey).build());
    getDao().save(entity);
  }

  @Override
  public void remove(E entity, MessageContext messageContext, String messageKey) {
    messageContext.addMessage(new MessageBuilder().info().code(messageKey).build());
    getDao().remove(entity);
  }

  @Override
  public List<E> getAll() {
    return getDao().getAll();
  }

  @Override
  public E get(int id) {
    E entity = getDao().get(id);
    return entity;
  }

  @Override
  public void refresh(E entity) {
    getDao().refresh(entity);
  }

  @Override
  public E getNewWithDefaults() {
    E entity = getNew();
    entity.initialize();
    return entity;
  }

  @Override
  public String getMessage(String code, Object[] args, Locale locale) {
    return messageSource.getMessage(code, args, locale);
  }

}
