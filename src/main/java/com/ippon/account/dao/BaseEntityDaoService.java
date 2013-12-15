package com.ippon.account.dao;

import java.util.List;

import com.ippon.account.domain.BaseEntity;

/**
 * DAO layer interface with common repository actions for entities
 * 
 * @author ebrigand
 * 
 * @param <E>
 */
public interface BaseEntityDaoService<E extends BaseEntity> {

  /**
   * Save entity
   * 
   * @param entity
   */
  void save(E entity);

  /**
   * Refresh entity from database
   * 
   * @param entity
   */
  void refresh(E entity);

  /**
   * Remove entity
   * 
   * @param entity
   */
  void remove(E entity);

  /**
   * Get entity by entity id
   * 
   * @param id
   * @return
   */
  E get(int id);

  /**
   * Get all entities
   * 
   * @return
   */
  List<E> getAll();

  /**
   * Get all entities with an "order by"
   * 
   * @param columnNameForOrderBy
   *          the column name for the "order by"
   * @return
   */
  List<E> getAll(String columnNameForOrderBy);
}
