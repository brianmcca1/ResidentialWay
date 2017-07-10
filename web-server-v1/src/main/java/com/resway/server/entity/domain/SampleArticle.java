/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.entity.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.resway.server.entity.key.SampleArticleKey;
import com.resway.server.framework.entity.domain.AbstractDomainKey;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

/**
 * Sample Article Entity/Domain Object class for test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
@Entity
@Table(name = "articles")
public class SampleArticle extends AbstractDomainObject {
	/** The serialVersionUID. */
	private static final long serialVersionUID = 7072648542528280535L;
	/** Uniquely identifies the article. */
	@EmbeddedId
	@AttributeOverride(name = "articleId", column = @Column(name = "article_id"))
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private SampleArticleKey key;
	/** The title. */
	@Column(name = "title")
	private String title;
	/** The category. */
	@Column(name = "category")
	private String category;

	/**
	 * Instantiates a new Article.
	 */
	public SampleArticle() {
		super();
	}

	/**
	 * Fetches the key.
	 *
	 * @return the key
	 */
	@Override
	public SampleArticleKey getKey() {
		return key;
	}

	/**
	 * Sets the key
	 *
	 * @param key
	 *            the key to set
	 */
	@Override
	public void setKey(AbstractDomainKey key) {
		this.key = (SampleArticleKey) key;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category
	 *            the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SampleArticle other = (SampleArticle) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SampleArticle [key=" + key + ", title=" + title + ", category=" + category + "]";
	}
}