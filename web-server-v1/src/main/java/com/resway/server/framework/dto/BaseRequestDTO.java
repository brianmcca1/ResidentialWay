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
 * Base Request DTO is responsible to fetch data from the client and send it to
 * the REST layer. As the name suggests all interactions must be strictly
 * restricted to only inputs from the REST layer to the Service layer. Please
 * look at {@link BaseResponseDTO} to perform output operation from the REST
 * layer.
 *
 * @since 1.0.0
 * @author Kevin
 */
public class BaseRequestDTO extends AbstractDTO implements IBaseDTO {
	/*
	 * (non-Javadoc)
	 * @see com.resway.server.framework.dto.IBaseDTO#validate()
	 */
	@Override
	public void validate() {
	}
}
