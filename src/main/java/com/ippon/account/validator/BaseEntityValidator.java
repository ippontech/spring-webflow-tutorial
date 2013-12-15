package com.ippon.account.validator;

import com.ippon.account.dao.BaseEntityDaoService;
import com.ippon.account.domain.BaseEntity;
import com.ippon.account.service.BaseEntityService;

public interface BaseEntityValidator<E extends BaseEntity, G extends BaseEntityService<E, H>, H extends BaseEntityDaoService<E>> {

  abstract G getService();

}
