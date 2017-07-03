/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.entity.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.entity.key.SampleArticleKey;
import com.resway.server.framework.entity.repository.AbstractRepository;

/**
 * Repository for {@link SampleArticle} to perform CRUD operations test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
@Repository
@Transactional
public class SampleArticleRepository extends AbstractRepository<SampleArticle, SampleArticleKey> implements ISampleArticleRepository<SampleArticle, SampleArticleKey> {
	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#getArticleById
	 * (java.lang.Object)
	 */
	@Override
	public SampleArticle read(SampleArticleKey key) throws Exception {
		return super.read(SampleArticle.class, key);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#addArticle
	 * (java.lang.Object)
	 */
	@Override
	public SampleArticle create(SampleArticle article) throws Exception {
		return super.create(article);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#updateArticle
	 * (java.lang.Object)
	 */
	@Override
	public void update(SampleArticle article) throws Exception {
		super.update(article);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#deleteArticle
	 * (java.lang.Object)
	 */
	@Override
	public void delete(SampleArticle article) throws Exception {
		super.delete(article);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#getAllArticles
	 * ()
	 */
	@Override
	public List<SampleArticle> readAll() throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.entity.repository.ISampleArticleRepository#articleExists
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public boolean articleExists(String title, String category) throws Exception {
		return false;
	}
}