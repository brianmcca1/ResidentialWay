/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.resway.server.framework.infra.Token;

/**
 * Enumeration to identify the type of {@link Token}.
 *
 * @author Kevin
 * @since 1.0.0
 */
public enum TokenStatus {
	/** Active. */
	ACT("Active"),
	/** Active. */
	RGN("Regenerated"),
	/** Expired. */
	EXP("Expired");
	/**
	 * Value of enum to be persisted to data store.
	 */
	private String value = null;

	/**
	 * private overloaded constructor to receive a value as argument.
	 *
	 * @param value
	 *            Value of enum to be persisted to data store
	 */
	private TokenStatus(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.value;
	}

	/**
	 * Returns the Enum Type from value.
	 *
	 * @param value
	 *            of Enum
	 * @return {@link TokenStatus}
	 */
	@JsonCreator
	public static TokenStatus fromValue(String value) {
		for (final TokenStatus element : TokenStatus.values()) {
			if (element.toString().equals(value)) {
				return element;
			}
		}
		return null;
	}
}
