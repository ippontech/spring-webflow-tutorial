package com.ippon.account.service;

import java.util.List;
import java.util.Locale;

import org.springframework.binding.message.MessageContext;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;

public interface BaseEntityService<E extends BaseEntity, F extends BaseEntityDaoService<E>> {

  abstract F getDao();

  void remove(E entity, MessageContext messageContext, String messageKey);

  void save(E entity, MessageContext messageContext, String messageKey);

  List<E> getAll();

  E get(int id);

  E getNewWithDefaults();

  void refresh(E entity);

  String getMessage(String code, Object[] args, Locale locale);

}
