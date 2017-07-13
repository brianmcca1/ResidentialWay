/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.dto;

import com.resway.server.common.enums.UserVerificationType;
import com.resway.server.domain.entity.UserVerification;
import com.resway.server.framework.dto.BaseRequestDTO;

/**
 * Data transfer object for {@link UserVerification}
 *
 * @author Kevin
 * @since 1.0.0
 */
public class UserVerificationDTO extends BaseRequestDTO {
	/** Indicates the unique id of the user verification object */
	private Integer id;
	/** Indicates the token. */
	private String token;
	/** Indicates the unique id of the user. */
	private Integer userId;
	/**
	 * Indicates the type of identifier </br>{@link UserVerificationType#EML, @link
	 * UserVerificationType#MOB}
	 * */
	private UserVerificationType type;
	/** Indicates the email id or the phone number value of the user */
	private String identifier;
	/** Indicates if the user is verified */
	private boolean isVerified;
	/** Indicates the number of times the token has been tried */
	private int attemptCount;

	/**
	 * Fetches the unique identifier for the userverification object.
	 *
	 * @return {@link Integer} unique identifier for the userverification
	 *         object.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the userverification object.
	 *
	 * @param key
	 *            {@link Integer} unique identifier for the userverification
	 *            object.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Fetches the unique identifier for the userverification object.
	 *
	 * @return {@link String} unique identifier for the userverification object.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the unique identifier for the userverification object.
	 *
	 * @param tokenId
	 *            {@link String} unique identifier for the userverification
	 *            object.
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Fetches the unique id of the user.
	 *
	 * @return {@link Integer} unique id of the user.
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the unique id of the user.
	 *
	 * @param userId
	 *            {@link Integer} unique id of the user.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Fetches the email id or the phone number value of the user.
	 *
	 * @return {@link String} email id or the phone number value of the user.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the email id or the phone number value of the user.
	 *
	 * @param identifier
	 *            {@link String} email id or the phone number value of the user.
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Fetches the type of identifier.
	 *
	 * @return {@link UserVerificationType} type of identifier.
	 */
	public UserVerificationType getType() {
		return type;
	}

	/**
	 * Sets the type of identifier.
	 *
	 * @param {@link UserVerificationType} type of identifier.
	 */
	public void setType(UserVerificationType type) {
		this.type = type;
	}

	/**
	 * Fetches the value of if the user is verified.
	 *
	 * @return {@link Boolean} the value of if the user is verified
	 */
	public boolean isVerified() {
		return isVerified;
	}

	/**
	 * Sets the if the user is verified
	 *
	 * @param isVerified
	 *            {@link Boolean} the value of if the user is verified.
	 */
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * Fetches the number of times the token has been tried
	 *
	 * @return {@link Integer} the number of times the token has been tried
	 */
	public int getAttemptCount() {
		return attemptCount;
	}

	/**
	 * Sets the number of times the token has been tried
	 *
	 * @param attemptCount
	 *            {@link Integer} the number of times the token has been tried
	 */
	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserVerificationDTO [id=" + id + ", token=" + token + ", userId=" + userId + ", type=" + type + ", identifier=" + identifier + ", isVerified=" + isVerified + ", attemptCount="
				+ attemptCount + "]";
	}
}
