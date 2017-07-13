/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.dto;

import org.springframework.http.HttpStatus;

/**
 * Indicates the status of the transaction or the request.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class StatusMessage {
	/**
	 * Indicates the HTTP status.
	 */
	private HttpStatus status;
	/**
	 * Indicates any message to be returned to the user.
	 */
	private String message;
	/**
	 * Indicates an error code (if any) associated with the transaction.
	 */
	private String errorCode;

	/**
	 * Instantiates a new status message.
	 *
	 * @param status
	 *            the status
	 */
	public StatusMessage(HttpStatus status) {
		super();
		this.status = status;
	}

	/**
	 * Instantiates a new status message.
	 */
	public StatusMessage() {
		super();
	}

	/**
	 * Fetches the {@link HttpStatus} of the transaction.
	 *
	 * @return status, {@link HttpStatus} of the transaction.
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Sets the {@link HttpStatus} of the transaction.
	 *
	 * @param status
	 *            {@link HttpStatus} of the transaction.
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * Fetches any message to be returned to the user.
	 *
	 * @return {@link String} any message to be returned to the user.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets any message to be returned to the user.
	 *
	 * @param message
	 *            {@link String} any message to be returned to the user.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Fetches an error code (if any) associated with the transaction.
	 *
	 * @return {@link String} custom error code.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets an error code (if any) associated with the transaction.
	 *
	 * @param errorCode
	 *            {@link String} custom error code.
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
