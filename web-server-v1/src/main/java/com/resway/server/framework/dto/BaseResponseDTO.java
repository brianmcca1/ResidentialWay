/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.dto;

/**
 * Base Response DTO is responsible to send data from the REST layer as output
 * to the client. As the name suggests all interactions must be strictly
 * restricted to only output from the Service layer to the REST layer. Please
 * look at {@link BaseRequestDTO} to perform input operations from the REST
 * layer.
 *
 * @since 1.0.0
 * @author Kevin
 */
public class BaseResponseDTO extends AbstractDTO {
	/**
	 * Indicates the state of the transaction.
	 */
	private StatusMessage statusMessage;

	/**
	 * Fetches the state of the transaction.
	 *
	 * @return {@link StatusMessage} object that return the state of the
	 *         transaction.
	 */
	public StatusMessage getStatusMessage() {
		return statusMessage;
	}

	/**
	 * Sets the state of the transaction.
	 *
	 * @param statusMessage
	 *            {@link StatusMessage} object that return the state of the
	 *            transaction.
	 */
	public void setStatusMessage(StatusMessage statusMessage) {
		this.statusMessage = statusMessage;
	}
}
