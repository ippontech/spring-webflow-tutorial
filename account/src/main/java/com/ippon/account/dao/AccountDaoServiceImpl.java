package com.ippon.account.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.transaction.annotation.Transactional;

import com.ippon.account.domain.Account;
import com.ippon.account.domain.Account_;

@ApplicationScoped
@Named
// @QualifierService("accountDaoService")
public class AccountDaoServiceImpl extends BaseEntityDaoServiceImpl<Account> implements AccountDaoService {

  public AccountDaoServiceImpl() {
    super(Account.class);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Account> getAll(boolean isEnabled) {
    EntityType<Account> account_ = getEntityType();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Account> cq = cb.createQuery(type);
    Root<Account> root = cq.from(account_);
    cq.select(root);
    cq.where(cb.equal(root.get(Account_.enabled), isEnabled));
    TypedQuery<Account> q = em.createQuery(cq);
    return q.getResultList();
  }
}
