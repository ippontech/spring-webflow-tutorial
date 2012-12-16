package com.ippon.account.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ippon.account.dao.rollback.BaseEntityDaoServiceRollBack;
import com.ippon.account.domain.BaseEntity;
import com.ippon.account.domain.BaseEntity_;

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

  protected EntityType<E> getEntityType() {
    Metamodel m = em.getMetamodel();
    EntityType<E> entityType = m.entity(type);
    return entityType;
  }

  @Override
  @Transactional(rollbackFor = { BaseEntityDaoServiceRollBack.class })
  public void save(E entity) {
    if (entity.getId() == null) {
      em.persist(entity);
    } else {
      em.merge(entity);
    }
  }

  @Override
  @Transactional(rollbackFor = { BaseEntityDaoServiceRollBack.class })
  public void remove(E entity) {
    em.remove(entity);
  }

  @Override
  @Transactional(readOnly = true)
  public void refresh(E entity) {
    if (em.contains(entity)) {
      em.refresh(entity);
    }
  }

  @Override
  @Transactional(readOnly = true)
  public List<E> getAll() {
    return getAll(null);
  }

  @Override
  @Transactional(readOnly = true)
  public List<E> getAll(String orderBy) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<E> cq = cb.createQuery(type);
    Root<E> root = cq.from(type);
    cq.select(root);
    if (StringUtils.isNotEmpty(orderBy))
      cq.orderBy(cb.asc(root.get(orderBy)));
    TypedQuery<E> q = em.createQuery(cq);
    return q.getResultList();
  }

  @Override
  @Transactional(readOnly = true)
  public E get(int id) {
    EntityType<E> entityType = getEntityType();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<E> cq = cb.createQuery(type);
    Root<E> root = cq.from(entityType);
    cq.select(root);
    cq.where(cb.equal(root.get(BaseEntity_.id), id));
    TypedQuery<E> q = em.createQuery(cq);
    return q.getSingleResult();
  }

}
