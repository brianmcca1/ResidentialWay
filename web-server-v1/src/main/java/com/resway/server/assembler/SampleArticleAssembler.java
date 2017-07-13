/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.assembler;

import com.resway.server.domain.entity.SampleArticle;
import com.resway.server.domain.key.SampleArticleKey;
import com.resway.server.dto.SampleArticleDTO;
import com.resway.server.dto.SampleArticleResponseDTO;
import com.resway.server.framework.assembler.IAbstractAssembler;

/**
 * Assembler between {@link SampleArticle}, {@link SampleArticleKey} and
 * {@link SampleArticleDTO}, {@link SampleArticleResponseDTO} conversion for
 * test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class SampleArticleAssembler implements IAbstractAssembler<SampleArticle, SampleArticleDTO, SampleArticleKey> {
	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.framework.assembler.IAbstractAssembler#toDomainObject
	 * (com.resway.server.framework.dto.AbstractDTO)
	 */
	@Override
	public SampleArticle toDomainObject(SampleArticleDTO dto) {
		final SampleArticle domainObj = new SampleArticle();
		domainObj.setTitle(dto.getTitle());
		domainObj.setCategory(dto.getCategory());
		domainObj.setKey(toDomainKey(dto));
		return domainObj;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.framework.assembler.IAbstractAssembler#toRequestDTOObject
	 * (com.resway.server.framework.entity.domain.AbstractDomainObject)
	 */
	@Override
	public SampleArticleDTO toDTOObject(SampleArticle entity) {
		final SampleArticleDTO requestDTO = new SampleArticleDTO();
		requestDTO.setArticleId(entity.getKey().getArticleId());
		requestDTO.setCategory(entity.getCategory());
		requestDTO.setTitle(entity.getTitle());
		return requestDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.framework.assembler.IAbstractAssembler#toDomainKey(
	 * com.resway.server.framework.dto.AbstractDTO)
	 */
	@Override
	public SampleArticleKey toDomainKey(SampleArticleDTO dto) {
		final SampleArticleKey key = new SampleArticleKey();
		if (dto.getArticleId() != 0) {
			key.setArticleId(dto.getArticleId());
		}
		return key;
	}

	/*
	 * (non-Javadoc)
	 * @see com.resway.server.framework.assembler.IAbstractAssembler#
	 * fromDomainKeytoDTOObject
	 * (com.resway.server.framework.entity.domain.AbstractDomainKey)
	 */
	@Override
	public SampleArticleDTO fromDomainKeytoDTOObject(SampleArticleKey key) {
		final SampleArticleDTO requestDTO = new SampleArticleDTO();
		requestDTO.setArticleId(key.getArticleId());
		return requestDTO;
	}
}
