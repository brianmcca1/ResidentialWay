/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import com.resway.server.dto.SampleArticleDTO;
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
	public SampleArticleResponseDTO create(SampleArticleDTO articleDTO);

	/**
	 * Fetches the article.
	 *
	 * @param key
	 *            the key
	 * @return the sample article
	 */
	public SampleArticleResponseDTO read(SampleArticleDTO articleDTO);

	/**
	 * Updates the article.
	 *
	 * @param article
	 *            the article
	 */
	public SampleArticleResponseDTO update(SampleArticleDTO articleDTO);

	/**
	 * Deletes the article.
	 *
	 * @param article
	 *            the article
	 */
	public SampleArticleResponseDTO delete(SampleArticleDTO articleDTO);

	/**
	 * Fetches all the article.
	 *
	 * @return the list
	 */
	public SampleArticleResponseDTO readAll();
}