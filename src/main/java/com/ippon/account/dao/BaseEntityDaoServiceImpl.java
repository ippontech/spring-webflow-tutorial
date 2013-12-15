package com.ippon.account.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ippon.account.domain.BaseEntity;
import com.ippon.account.domain.BaseEntity_;

/**
 * Abstract DAO Layer implementation with common repository actions for entities
 * 
 * @author ebrigand
 * 
 * @param <E>
 */
public abstract class BaseEntityDaoServiceImpl<E extends BaseEntity> implements BaseEntityDaoService<E> {

  protected final Class<E> type;

  BaseEntityDaoServiceImpl(Class<E> type) {
    this.type = type;
  }

  @PersistenceContext
  protected EntityManager em;

  protected EntityManager getEntityManager() {
    return em;
  }

  @Override
  @Transactional
  public void save(E entity) {
    if (entity.getId() == null) {
      em.persist(entity);
    } else {
      em.merge(entity);
    }
  }

  @Override
  @Transactional
  public void remove(E entity) {
    em.remove(entity);
  }

  @Override
  @Transactional(readOnly = true)
  public void refresh(E entity) {
    if (em.contains(entity)) {
      em.refresh(entity);
    }
    entity.setInitialized(false);
    entity.initialize();
  }

  @Override
  @Transactional(readOnly = true)
  public List<E> getAll() {
    return getAll(null);
  }

  @Override
  @Transactional(readOnly = true)
  public List<E> getAll(String columnNameForOrderBy) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<E> cq = cb.createQuery(type);
    Root<E> root = cq.from(type);
    cq.select(root);
    if (StringUtils.isNotEmpty(columnNameForOrderBy))
      cq.orderBy(cb.asc(root.get(columnNameForOrderBy)));
    TypedQuery<E> q = em.createQuery(cq);
    List<E> entities = q.getResultList();
    for (E entity : entities) {
      entity.initialize();
    }
    return entities;
  }

  @Override
  @Transactional(readOnly = true)
  public E get(int id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<E> cq = cb.createQuery(type);
    Root<E> root = cq.from(type);
    cq.select(root);
    cq.where(cb.equal(root.get(BaseEntity_.id), id));
    TypedQuery<E> q = em.createQuery(cq);
    E entity = q.getSingleResult();
    entity.initialize();
    return entity;
  }

}
