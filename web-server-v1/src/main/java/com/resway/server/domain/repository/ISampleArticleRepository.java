/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.domain.repository;

import java.util.List;

/**
 * Interface for {@link SampleArticleRepository} for test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 *
 * @param <SampleArticle>
 * @param <SampleArticleKey>
 */
public interface ISampleArticleRepository<SampleArticle, SampleArticleKey> {
	/**
	 * Adds the article.
	 *
	 * @param article
	 *            the article
	 * @return the article
	 */
	public SampleArticle create(SampleArticle article) throws Exception;

	/**
	 * Gets the all articles.
	 *
	 * @return the all articles
	 */
	public List<SampleArticle> readAll() throws Exception;

	/**
	 * Gets the article by id.
	 *
	 * @param articleId
	 *            the article id
	 * @return the article by id
	 */
	public SampleArticle read(SampleArticleKey key) throws Exception;

	/**
	 * Update article.
	 *
	 * @param article
	 *            the article
	 */
	public void update(SampleArticle article) throws Exception;

	/**
	 * Delete article.
	 *
	 * @param articleId
	 *            the article id
	 */
	public void delete(SampleArticle article) throws Exception;

	/**
	 * Article exists.
	 *
	 * @param title
	 *            the title
	 * @param category
	 *            the category
	 * @return true, if successful
	 */
	boolean articleExists(String title, String category) throws Exception;
}