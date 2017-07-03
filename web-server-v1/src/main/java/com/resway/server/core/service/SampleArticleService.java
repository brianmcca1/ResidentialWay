/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resway.server.assembler.SampleArticleAssembler;
import com.resway.server.dto.SampleArticleRequestDTO;
import com.resway.server.dto.SampleArticleResponseDTO;
import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.entity.key.SampleArticleKey;
import com.resway.server.entity.repository.ISampleArticleRepository;
import com.resway.server.framework.core.service.AbstractService;

/**
 * The service class for {@link SampleArticle} object that interacts with the
 * database.<br>
 *
 * <u>NOTE:</u>
 * <ul>
 * <li>Write brief business description of what the purpose of this class is.</li>
 * <li>List the methods that are as a part of the class.</li>
 * </ul>
 *
 * @author Kevin
 * @since 1.0.0
 */
@Service
public class SampleArticleService extends AbstractService implements ISampleArticleService {
	/** Repository for {@link SampleArticle} */
	@Autowired
	private ISampleArticleRepository<SampleArticle, SampleArticleKey> sampleArticleRepo;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#read(com.resway.
	 * server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public SampleArticleResponseDTO read(SampleArticleRequestDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		SampleArticleResponseDTO respObject = null;
		try {
			final SampleArticleKey key = assembler.toDomainKey(articleDTO);
			final SampleArticle domainObject = sampleArticleRepo.read(key);
			respObject = assembler.toResponseDTOObject(domainObject);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return respObject;
	}

	/*
	 * (non-Javadoc)
	 * @see com.resway.server.core.service.ISampleArticleService#readAll()
	 */
	@Override
	public List<SampleArticleResponseDTO> readAll() {
		final List<SampleArticleResponseDTO> articlesList = new ArrayList<SampleArticleResponseDTO>();
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		try {
			final List<SampleArticle> articles = sampleArticleRepo.readAll();
			for (final SampleArticle sampleArticle : articles) {
				articlesList.add(assembler.toResponseDTOObject(sampleArticle));
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return articlesList;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#create(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public SampleArticleResponseDTO create(SampleArticleRequestDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		SampleArticle article = assembler.toDomainObject(articleDTO);
		SampleArticleResponseDTO respObject = null;
		try {
			article = sampleArticleRepo.create(article);
			respObject = assembler.toResponseDTOObject(article);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return respObject;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#update(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public void update(SampleArticleRequestDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		final SampleArticle article = assembler.toDomainObject(articleDTO);
		try {
			sampleArticleRepo.update(article);
		} catch (final Exception ex) {
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#delete(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public void delete(SampleArticleRequestDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		final SampleArticle article = assembler.toDomainObject(articleDTO);
		try {
			sampleArticleRepo.delete(article);
		} catch (final Exception ex) {
		}
	}
}