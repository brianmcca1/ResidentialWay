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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.resway.server.assembler.SampleArticleAssembler;
import com.resway.server.common.ApplicationHelper;
import com.resway.server.dto.SampleArticleDTO;
import com.resway.server.dto.SampleArticleResponseDTO;
import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.entity.key.SampleArticleKey;
import com.resway.server.entity.repository.ISampleArticleRepository;
import com.resway.server.framework.core.service.AbstractService;
import com.resway.server.framework.dto.StatusMessage;

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
	public SampleArticleResponseDTO read(SampleArticleDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		SampleArticleResponseDTO respObject = new SampleArticleResponseDTO();
		try {
			final SampleArticleKey key = assembler.toDomainKey(articleDTO);
			final SampleArticle domainObject = sampleArticleRepo.read(key);
			SampleArticleDTO respDTO = assembler.toDTOObject(domainObject);
			respObject.getDtos().add(respDTO);
			respObject.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			ex.printStackTrace();
			respObject.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return respObject;
	}

	/*
	 * (non-Javadoc)
	 * @see com.resway.server.core.service.ISampleArticleService#readAll()
	 */
	@Override
	public SampleArticleResponseDTO readAll() {
		final SampleArticleResponseDTO response = new SampleArticleResponseDTO();
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		try {
			final List<SampleArticle> articles = sampleArticleRepo.readAll();
			List<SampleArticleDTO> dtosList = new ArrayList<SampleArticleDTO>(articles.size());
			for (final SampleArticle sampleArticle : articles) {
				dtosList.add(assembler.toDTOObject(sampleArticle));
			}
			response.setDtos(dtosList);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			ex.printStackTrace();
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#create(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public SampleArticleResponseDTO create(SampleArticleDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		SampleArticle article = assembler.toDomainObject(articleDTO);
		SampleArticleResponseDTO response = new SampleArticleResponseDTO();
		try {
			article = sampleArticleRepo.create(article);
			SampleArticleDTO respDTO = assembler.toDTOObject(article);
			response.getDtos().add(respDTO);
			response.setStatusMessage(new StatusMessage(HttpStatus.CREATED));
		} catch (final Exception ex) {
			ex.printStackTrace();
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#update(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public SampleArticleResponseDTO update(SampleArticleDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		final SampleArticleResponseDTO response = new SampleArticleResponseDTO();
		try {
			final SampleArticle originalObject = sampleArticleRepo.read(assembler.toDomainKey(articleDTO));
			final SampleArticle objToUpdate = assembler.toDomainObject(articleDTO);
			ApplicationHelper.copyNonNullProperties(objToUpdate, originalObject);
			sampleArticleRepo.update(originalObject);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			ex.printStackTrace();
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.ISampleArticleService#delete(com.resway
	 * .server.dto.SampleArticleRequestDTO)
	 */
	@Override
	public SampleArticleResponseDTO delete(SampleArticleDTO articleDTO) {
		final SampleArticleAssembler assembler = new SampleArticleAssembler();
		final SampleArticleResponseDTO response = new SampleArticleResponseDTO();
		final SampleArticle article = assembler.toDomainObject(articleDTO);
		try {
			sampleArticleRepo.delete(article);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			ex.printStackTrace();
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}
}