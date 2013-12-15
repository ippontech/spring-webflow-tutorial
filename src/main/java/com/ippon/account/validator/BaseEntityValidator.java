package com.ippon.account.validator;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;
import com.ippon.account.service.BaseEntityService;

/**
 * Validator interface, used to check entity fields
 * 
 * @author ebrigand
 * 
 * @param <E>
 * @param <G>
 * @param <H>
 */
public interface BaseEntityValidator<E extends BaseEntity, G extends BaseEntityService<E, H>, H extends BaseEntityDaoService<E>> {

  /**
   * @return the service layer related to the entity
   */
  G getService();

}
