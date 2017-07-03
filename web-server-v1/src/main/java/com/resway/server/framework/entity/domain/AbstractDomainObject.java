/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.entity.domain;

import java.io.Serializable;

/**
 * Entity object is responsible to interact with the Repository and perform CRUD
 * operations on the database. Every <i>Entity</i> object should be accompanied
 * with a <i>Key</i> object of type {@link AbstractDomainKey}.
 *
 * @since 1.0.0
 * @author Kevin
 */
public class AbstractDomainObject implements Serializable {
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -5926425674224614178L;
}
