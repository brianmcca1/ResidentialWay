/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.domain.repository;

import java.util.HashMap;

/**
 * Interface for {@link UserVerificationRepository} for test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 *
 * @param <UserVerification>
 * @param <UserVerificationKey>
 */
public interface IUserVerificationRepository<UserVerification, UserVerificationKey> {
	/**
	 * Creates the {@link UserVerification}.
	 *
	 * @param userVerification
	 *            the article
	 * @return {@link UserVerification} object with the id of the newly created
	 *         entry.
	 */
	public UserVerification create(UserVerification userVerification) throws Exception;

	/**
	 * Gets the {@link UserVerification} object by the key.
	 *
	 * @param key
	 *            {@link UserVerificationKey} uniquely identfies the
	 *            UserVerification object.
	 * @return Object of type {@link UserVerification}.
	 */
	public UserVerification read(UserVerificationKey key) throws Exception;

	/**
	 * Gets the {@link UserVerification} object by query params.
	 *
	 * @param queryMap
	 *            {@link HashMap} contains all the parameters.
	 * @return Object of type {@link UserVerification}.
	 */
	public UserVerification read(HashMap<String, String> queryMap);

	/**
	 * Updates the {@link UserVerification} object.
	 *
	 * @param userVerification
	 *            {@link UserVerification} object.
	 */
	public void update(UserVerification userVerification) throws Exception;

	/**
	 * Deletes the {@link UserVerification} object.
	 *
	 * @param userVerification
	 *            {@link UserVerification} object.
	 */
	public void delete(UserVerification userVerification) throws Exception;
}