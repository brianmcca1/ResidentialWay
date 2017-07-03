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

/**
 * Enumeration for test puerpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
public enum SampleArticleEnum {
	/** The urev. */
	UREV("Under review"),
	/** The publ. */
	PUBL("Published"),
	/** The remv. */
	REMV("Removed");
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
	private SampleArticleEnum(String value) {
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
	 * @return {@link SampleArticleEnum}
	 */
	@JsonCreator
	public static SampleArticleEnum fromValue(String value) {
		for (final SampleArticleEnum element : SampleArticleEnum.values()) {
			if (element.toString().equals(value)) {
				return element;
			}
		}
		return null;
	}
}
