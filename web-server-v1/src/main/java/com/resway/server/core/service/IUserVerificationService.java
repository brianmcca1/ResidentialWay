/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import com.resway.server.dto.UserVerificationDTO;
import com.resway.server.dto.UserVerificationResponseDTO;
import com.resway.server.framework.dto.StatusMessage;

/**
 * Interface for class {@link SampleArticleService}.
 *
 * @author Kevin
 * @since 1.0.0
 */
public interface IUserVerificationService {
	/**
	 * Creates UserVerification object in the database.
	 *
	 * @param verificationDTO
	 *            {@link UserVerificationDTO}
	 */
	public UserVerificationResponseDTO create(UserVerificationDTO verificationDTO);

	/**
	 * Fetches the UserVerification object from the database.
	 *
	 * @param verificationDTO
	 *            {@link UserVerificationDTO}
	 * @return Object of type {@link UserVerificationResponseDTO}
	 */
	public UserVerificationResponseDTO read(UserVerificationDTO verificationDTO);

	/**
	 * Fetches the token details provided by the user corresponding to the
	 * database stored in the database.
	 *
	 * @param verificationDTO
	 *            {@link UserVerificationDTO}
	 * @return Object of type {@link UserVerificationResponseDTO}
	 */
	public UserVerificationResponseDTO validate(UserVerificationDTO verificationDTO);

	/**
	 * Updates the UserVerification object from the database.
	 *
	 * @param verificationDTO
	 *            {@link UserVerificationDTO}
	 * @return Object of type {@link StatusMessage}
	 */
	public StatusMessage update(UserVerificationDTO verificationDTO);

	/**
	 * Deletes the UserVerification object from the database.
	 *
	 * @param verificationDTO
	 *            {@link UserVerificationDTO}
	 * @return Object of type {@link StatusMessage}
	 */
	public StatusMessage delete(UserVerificationDTO verificationDTO);
}