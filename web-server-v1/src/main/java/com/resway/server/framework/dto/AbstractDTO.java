/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.dto;

import com.resway.server.framework.entity.domain.AbstractDomainObject;
import com.resway.server.framework.entity.repository.AbstractRepository;

/**
 * This is the Data Transfer Object for transfer of data between client and
 * server. Under no circumstances will a DTO be responsible to persist data into
 * the database. All interactions with the database must be happen via a
 * {@link AbstractRepository} object called by {@link AbstractDomainObject}
 * object.
 *
 * @author Kevin
 * @since 1.0.0
 */
public abstract class AbstractDTO {
}
