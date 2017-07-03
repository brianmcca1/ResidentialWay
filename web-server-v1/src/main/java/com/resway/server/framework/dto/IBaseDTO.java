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
 * Interface to perform actions on objects of type {@link AbstractDTO}.
 *
 * @author Kevin
 * @since 1.0.0
 */
public interface IBaseDTO {
	/**
	 * Performs any validations required within objects.
	 */
	public void validate();
}
