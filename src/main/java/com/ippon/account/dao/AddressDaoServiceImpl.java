package com.ippon.account.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ippon.account.domain.Account;
import com.ippon.account.domain.Account_;
import com.ippon.account.domain.Address;
import com.ippon.account.domain.Address_;

/**
 * DAO Layer implementation to manage addresses
 * 
 * @author ebrigand
 * 
 */
@Repository("addressDaoService")
public class AddressDaoServiceImpl extends BaseEntityDaoServiceImpl<Address> implements AddressDaoService {

  private final Logger logger = Logger.getLogger(AddressDaoServiceImpl.class);

  public AddressDaoServiceImpl() {
    super(Address.class);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ippon.account.dao.AddressDaoService#getBy(java.lang.String,
   * java.lang.String)
   */
  @SuppressWarnings("unchecked")
  @Transactional(readOnly = true)
  @Override
  public <S extends Object> List<Address> getBy(String columnName, String columnValue) {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Address> cq = cb.createQuery(type);
      Root<Address> root = cq.from(type);
      cq.select(root);
      Predicate predicate = null;
      SingularAttribute<Address, S> singularAttribute = getSingularAttribute(columnName);
      if (singularAttribute.getJavaType().equals(String.class)) {
        predicate = cb.like(cb.upper((Expression<String>) root.get(singularAttribute)), "%" + columnValue.toUpperCase() + "%");
      } else if (singularAttribute.getJavaType().equals(Account.class)) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        predicate = builder.like(cb.upper(root.join(Address_.account).get(Account_.username)), columnValue.toUpperCase() + "%");
      } else {
        predicate = cb.equal(root.get(singularAttribute), columnValue);
      }
      cq.where(predicate);
      TypedQuery<Address> q = em.createQuery(cq);
      return q.getResultList();
    } catch (IllegalAccessException e) {
      logger.error("Introspection fails for column " + columnName + " on Address class", e.getCause());
    } catch (NoSuchFieldException e) {
      logger.error("Introspection fails for column " + columnName + " on Address class", e.getCause());
    }
    return null;
  }

  /**
   * Introspection on the column nama
   * 
   * @param columnName
   * @return
   * @throws IllegalAccessException
   * @throws NoSuchFieldException
   */
  @SuppressWarnings("unchecked")
  private <S extends Object> SingularAttribute<Address, S> getSingularAttribute(String columnName) throws IllegalAccessException, NoSuchFieldException {
    try {
      return (SingularAttribute<Address, S>) Address_.class.getDeclaredField(columnName).get(Address_.class);
    } catch (IllegalArgumentException e) {
      throw e;
    } catch (IllegalAccessException e) {
      throw e;
    } catch (NoSuchFieldException e) {
      throw e;
    } catch (SecurityException e) {
      throw e;
    }
  }

}
