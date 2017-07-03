/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.assembler;

import com.resway.server.framework.dto.AbstractDTO;
import com.resway.server.framework.entity.domain.AbstractDomainKey;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

/**
 * Assembler performs conversion between Request DTOs and Response DTOs to
 * Domain Objects(Entity)and vice versa. Also, can be used for retriving
 * {@link AbstractDomainKey} from {@link AbstractDTO} and vice-versa. All
 * Assemblers should inherit this abstract assembler to follow the standard
 * template methods for conversion.
 *
 * @since 1.0.0
 * @author Kevin
 */
public interface IAbstractAssembler<E extends AbstractDomainObject, D extends AbstractDTO, K extends AbstractDomainKey> {
	/**
	 * Converts from DTO to Domain object.
	 *
	 * @param dto
	 *            Object of type {@link AbstractDTO}.
	 * @return object of type {@link AbstractDomainObject}
	 */
	public E toDomainObject(D dto);

	/**
	 * Converts from Domain object to DTO.
	 *
	 * @param entity
	 *            Object of type {@link AbstractDomainObject}
	 * @return Object of type {@link AbstractDTO}.
	 */
	public D toDTOObject(E entity);

	/**
	 * Converts from DTO to Domain object.
	 *
	 * @param dto
	 *            Object of type {@link AbstractDTO}.
	 * @return object of type {@link AbstractDomainKey}
	 */
	public K toDomainKey(D dto);

	/**
	 * Converts from Domain object to DTO.
	 *
	 * @param key
	 *            Object of type {@link AbstractDomainKey}
	 * @return Object of type {@link AbstractDTO}.
	 */
	public D fromDomainKeytoDTOObject(K key);
}
