package com.ippon.account.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ippon.account.domain.Account;
import com.ippon.account.domain.Account_;

@Repository("accountDaoService")
public class AccountDaoServiceImpl extends BaseEntityDaoServiceImpl<Account> implements AccountDaoService {

  public AccountDaoServiceImpl() {
    super(Account.class);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Account> getAll(boolean isEnabled) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Account> cq = cb.createQuery(type);
    Root<Account> root = cq.from(type);
    cq.select(root);
    cq.where(cb.equal(root.get(Account_.enabled), isEnabled));
    TypedQuery<Account> q = em.createQuery(cq);
    return q.getResultList();
  }
}
