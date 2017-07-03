/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.dto;

import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.framework.dto.BaseResponseDTO;

/**
 * Sample Response DTO for {@link SampleArticle} --> test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class SampleArticleResponseDTO extends BaseResponseDTO {
	/** Unique id of the article. */
	private int articleId;
	/** The title. */
	private String title;
	/** The category. */
	private String category;

	/**
	 * @return the articleId
	 */
	public int getArticleId() {
		return articleId;
	}

	/**
	 * @param articleId
	 *            the articleId to set
	 */
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SampleArticleResponseDTO [articleId=" + articleId + ", title=" + title + ", category=" + category + "]";
	}
}
