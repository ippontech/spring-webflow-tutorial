package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.BaseEntity;

public interface BaseEntityDaoService<E extends BaseEntity> {

  void save(E entity);

  void refresh(E entity);

  void remove(E entity);

  E get(int id);

  List<E> getAll();

  List<E> getAll(String orderBy);
}
