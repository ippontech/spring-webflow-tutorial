package com.ippon.account.service;

import java.util.List;
import java.util.Locale;

import org.springframework.binding.message.MessageContext;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;

/**
 * Front Service interface layer for common actions on entities
 * 
 * @author ebrigand
 * 
 * @param <E>
 * @param <F>
 */
public interface BaseEntityService<E extends BaseEntity, F extends BaseEntityDaoService<E>> {

  /**
   * Get the DAO layer
   * 
   * @return
   */
  F getDao();

  /**
   * Remove an entity and set a message
   * 
   * @param entity
   * @param messageContext
   * @param messageKey
   */
  void remove(E entity, MessageContext messageContext, String messageKey);

  /**
   * Save an entity and set a message
   * 
   * @param entity
   * @param messageContext
   * @param messageKey
   */
  void save(E entity, MessageContext messageContext, String messageKey);

  /**
   * Get all the entities
   */
  List<E> getAll();

  /**
   * Get an entity by entity id
   * 
   * @param id
   * @return
   */
  E get(int id);

  /**
   * Create a new entity, initialized and not persisted
   * 
   * @return
   */
  E getNewWithDefaults();

  /**
   * Refresh an entity from the DAO layer
   * 
   * @param entity
   */
  void refresh(E entity);

  /**
   * Get a message from code, arg and locale
   * 
   * @param code
   * @param args
   * @param locale
   * @return
   */
  String getMessage(String code, Object[] args, Locale locale);

}
