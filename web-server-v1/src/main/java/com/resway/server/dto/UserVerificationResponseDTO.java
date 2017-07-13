/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.dto;

import com.resway.server.framework.dto.BaseResponseDTO;

/**
 * Indicates the response object for the request {@link UserVerificationDTO}
 *
 * @author Kevin
 * @since 1.0.0
 */
public class UserVerificationResponseDTO extends BaseResponseDTO {
	/** Indicates the id of the user. */
	private Integer userId;
	/** Indicates the token value. */
	private String token;
	/** Indicates the duration in millisec after which the token will expire. */
	private Long expiryIn;
	/** Indicates the number of times the token has been tried */
	private Integer attemptCount;
	/** Indicates the url to redirect to post successful vverification. */
	private String redirectUri;
	/** Indicates whether the user is verified */
	private Boolean isVerified;

	/**
	 * Fetches the id of the user.
	 *
	 * @return {@link Integer} id of the user.
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the id of the user.
	 *
	 * @param userId
	 *            {@link Integer} id of the user.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Fetches the token.
	 *
	 * @return {@link String} returns the token.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token
	 *            {@link String} returns the token.
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Fetches the duration in millisec after which the token will expire.
	 *
	 * @return {@link Long} the duration in millisec after which the token will
	 *         expire.
	 */
	public Long getExpiryIn() {
		return expiryIn;
	}

	/**
	 * Sets the duration in millisec after which the token will expire.
	 *
	 * @param expiryIn
	 *            {@link Long} the duration in millisec after which the token
	 *            will expire.
	 */
	public void setExpiryIn(Long expiryIn) {
		this.expiryIn = expiryIn;
	}

	/**
	 * Fetches if the user is verified.
	 *
	 * @return {@link Boolean} if the user is verified.
	 */
	public Boolean getIsVerified() {
		return isVerified;
	}

	/**
	 * Sets if the user is verified.
	 *
	 * @param {@link Boolean} if the user is verified.
	 */
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * @return the redirectUri
	 */
	public String getRedirectUri() {
		return redirectUri;
	}

	/**
	 * @param redirectUri
	 *            the redirectUri to set
	 */
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
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
		return "UserVerificationResponseDTO [userId=" + userId + ", token=" + token + ", expiryIn=" + expiryIn + ", attemptCount=" + attemptCount + ", redirectUri=" + redirectUri + ", isVerified="
				+ isVerified + "]";
	}
}
