/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.domain.repository;

import java.sql.ResultSet;
import java.util.HashMap;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.resway.server.domain.entity.UserVerification;
import com.resway.server.domain.key.UserVerificationKey;
import com.resway.server.framework.entity.repository.AbstractRepository;
import com.resway.server.framework.entity.repository.MySqlDbHelper;

/**
 * Repository for {@link UserVerification} to perform CRUD operations.
 *
 * @author Kevin
 * @since 1.0.0
 */
@Repository
@Transactional
public class UserVerificationRepository extends AbstractRepository<UserVerification, UserVerificationKey> implements IUserVerificationRepository<UserVerification, UserVerificationKey> {
	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.IUserVerificationRepository#create
	 * (com.resway.server.entity.key.UserVerificationKey)
	 */
	@Override
	public UserVerification read(UserVerificationKey key) throws Exception {
		return super.read(UserVerification.class, key);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.IUserVerificationRepository#create
	 * (com.resway.server.entity.domain.UserVerification)
	 */
	@Override
	public UserVerification create(UserVerification object) throws Exception {
		return super.create(object);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.IUserVerificationRepository#update
	 * (com.resway.server.entity.domain.UserVerification)
	 */
	@Override
	public void update(UserVerification object) throws Exception {
		super.update(object);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.IUserVerificationRepository#delete
	 * (com.resway.server.entity.domain.UserVerification)
	 */
	@Override
	public void delete(UserVerification entity) throws Exception {
		super.delete(entity);
	}

	@Override
	public UserVerification read(HashMap<String, String> queryMap) {
		String query = "select * from user_verification where uv_user_id=? AND uv_identifier=? AND uv_token_id=? ";
		ResultSet results = MySqlDbHelper.getInstance().readData(query, (String[]) queryMap.values().toArray());
		System.out.println(results.toString());
		return new UserVerification();
	}
}