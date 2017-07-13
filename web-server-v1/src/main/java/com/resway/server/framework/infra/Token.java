/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.infra;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.resway.server.common.enums.TokenStatus;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

@Entity
@Table(name = "token")
public class Token extends AbstractDomainObject {
	/** Serial version id. */
	private static final long serialVersionUID = -4146740814511969875L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tkn_id")
	private int id;
	/** Indicates the actual value of the token */
	@Column(name = "tkn_value")
	private String value;
	/** Indicates the hashed value of the token */
	@Column(name = "tkn_hash_code")
	private String hashedValue;
	/** Indicates the status of the token */
	@Column(name = "tkn_status")
	private TokenStatus status;
	/** Indicates the time until when the token is valid */
	@Column(name = "tkn_expiry_date")
	private Date expiryDate;
	/** Indicates the time the object was created in the database */
	@Column(name = "creation_date")
	private Date creationDate;

	/**
	 * Fetches the unique id of the token.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique id of the token.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Fetches the actual value of the token
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the actual value of the token
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Fetches the hashed value of the token
	 *
	 * @return the hashedValue
	 */
	public String getHashedValue() {
		return hashedValue;
	}

	/**
	 * Sets the actual value of the token
	 *
	 * @param hashedValue
	 *            the hashedValue to set
	 */
	public void setHashedValue(String hashedValue) {
		this.hashedValue = hashedValue;
	}

	/**
	 * Fetches the status of the token
	 *
	 * @return the status
	 */
	public TokenStatus getStatus() {
		return status;
	}

	/**
	 * Sets status of the token
	 *
	 * @param status
	 *            the status to set
	 */
	public void setStatus(TokenStatus status) {
		this.status = status;
	}

	/**
	 * Fetches the time until when the token is valid.
	 *
	 * @return {@link Date} time until when the token is valid.
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Sets the time until when the token is valid.
	 *
	 * @param expiryDate
	 *            {@link Date} time until when the token is valid.
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((hashedValue == null) ? 0 : hashedValue.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Token other = (Token) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null) {
				return false;
			}
		} else if (!expiryDate.equals(other.expiryDate)) {
			return false;
		}
		if (hashedValue == null) {
			if (other.hashedValue != null) {
				return false;
			}
		} else if (!hashedValue.equals(other.hashedValue)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
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
		return "Token [id=" + id + ", value=" + value + ", hashedValue=" + hashedValue + ", status=" + status + ", expiryDate=" + expiryDate + ", creationDate=" + creationDate + "]";
	}
}
