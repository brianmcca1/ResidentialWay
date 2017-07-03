/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import java.util.List;

import com.resway.server.dto.SampleArticleRequestDTO;
import com.resway.server.dto.SampleArticleResponseDTO;

/**
 * Interface for class {@link SampleArticleService}.
 *
 * @author Kevin
 * @since 1.0.0
 */
public interface ISampleArticleService {
	/**
	 * Creates the article.
	 *
	 * @param article
	 *            the article
	 */
	public SampleArticleResponseDTO create(SampleArticleRequestDTO articleDTO);

	/**
	 * Fetches the article.
	 *
	 * @param key
	 *            the key
	 * @return the sample article
	 */
	public SampleArticleResponseDTO read(SampleArticleRequestDTO articleDTO);

	/**
	 * Updates the article.
	 *
	 * @param article
	 *            the article
	 */
	public void update(SampleArticleRequestDTO articleDTO);

	/**
	 * Deletes the article.
	 *
	 * @param article
	 *            the article
	 */
	public void delete(SampleArticleRequestDTO articleDTO);

	/**
	 * Fetches all the article.
	 *
	 * @return the list
	 */
	public List<SampleArticleResponseDTO> readAll();
}