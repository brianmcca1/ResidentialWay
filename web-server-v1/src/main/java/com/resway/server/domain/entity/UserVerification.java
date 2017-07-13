/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.resway.server.domain.key.UserVerificationKey;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

/**
 * Domain Object to verify a given email id/mobile number of a
 * {@link UserVerification} after registration.
 *
 * @author Kevin
 * @since 1.0.0
 *
 */
@Entity
@Table(name = "user_verification")
public class UserVerification extends AbstractDomainObject {
	/** Serial version id. */
	private static final long serialVersionUID = -4540054100772981226L;
	/** Uniquely identifies the userverification object. */
	@Id
	@Column(name = "uv_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer key;
	/** Indicates the unique id of the user. */
	@Column(name = "uv_user_id")
	private Integer userId;
	/** Indicates the unique id of the token. */
	@Column(name = "uv_token_id")
	private String tokenId;
	/** Indicates the email id or the phone number value of the user */
	@Column(name = "uv_identifier")
	private String identifier;
	/**
	 * Indicates the type of identifier </br>{@link UserVerificationType#EML, @link
	 * UserVerificationType#MOB}
	 * */
	//	@Column(name = "uv_identifier_type")
	//	@Enumerated(EnumType.ORDINAL)
	//	private UserVerificationType type;
	/** Indicates if the user is verified */
	@Column(name = "is_verified")
	private boolean isVerified;
	/** Indicates the number of times the token has been tried */
	@Column(name = "uv_count")
	private int attemptCount;
	/** Indicates the time the object was created in the database */
	@Column(name = "creation_date")
	private Date creationDate;

	//	/**
	//	 * Fetches the unique identifier for the userverification object.
	//	 *
	//	 * @return {@link UserVerificationKey} unique identifier for the
	//	 *         userverification object.
	//	 */
	//	@Override
	//	public UserVerificationKey getKey() {
	//		return key;
	//	}
	//
	//	/**
	//	 * Sets the unique identifier for the userverification object.
	//	 *
	//	 * @param key
	//	 *            {@link UserVerificationKey} unique identifier for the
	//	 *            userverification object.
	//	 */
	//	public void setKey(UserVerificationKey key) {
	//		this.key = key;
	//	}
	/**
	 * Fetches the unique identifier for the userverification object.
	 *
	 * @return {@link UserVerificationKey} unique identifier for the
	 *         userverification object.
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 * Sets the unique identifier for the userverification object.
	 *
	 * @param key
	 *            {@link UserVerificationKey} unique identifier for the
	 *            userverification object.
	 */
	public void setKey(Integer key) {
		this.key = key;
	}

	/**
	 * Fetches the unique identifier for the userverification object.
	 *
	 * @return {@link Integer} unique identifier for the userverification
	 *         object.
	 */
	public String getTokenId() {
		return tokenId;
	}

	/**
	 * Sets the unique identifier for the userverification object.
	 *
	 * @param tokenId
	 *            {@link String} unique identifier for the userverification
	 *            object.
	 */
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	/**
	 * Fetches the unique id of the user.
	 *
	 * @return {@link Integer} unique id of the user.
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the unique id of the user.
	 *
	 * @param userId
	 *            {@link Integer} unique id of the user.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Fetches the email id or the phone number value of the user.
	 *
	 * @return {@link String} email id or the phone number value of the user.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the email id or the phone number value of the user.
	 *
	 * @param identifier
	 *            {@link String} email id or the phone number value of the user.
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Fetches the type of identifier.
	 *
	 * @return {@link UserVerificationType} type of identifier.
	 */
	/*
	 * public UserVerificationType getType() { return type; }
	 *//**
	  * Sets the type of identifier.
	  *
	  * @param {@link UserVerificationType} type of identifier.
	  */
	/*
	 * public void setType(UserVerificationType type) { this.type = type; }
	 */
	/**
	 * Fetches the value of if the user is verified.
	 *
	 * @return {@link Boolean} the value of if the user is verified
	 */
	public boolean isVerified() {
		return isVerified;
	}

	/**
	 * Sets the if the user is verified
	 *
	 * @param isVerified
	 *            {@link Boolean} the value of if the user is verified.
	 */
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * Fetches the number of times the token has been tried
	 *
	 * @return {@link Integer} the number of times the token has been tried
	 */
	public int getAttemptCount() {
		return attemptCount;
	}

	/**
	 * Sets the number of times the token has been tried
	 *
	 * @param attemptCount
	 *            {@link Integer} the number of times the token has been tried
	 */
	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attemptCount;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (isVerified ? 1231 : 1237);
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((tokenId == null) ? 0 : tokenId.hashCode());
		/*
		 * result = prime * result + ((type == null) ? 0 : type.hashCode());
		 */result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserVerification other = (UserVerification) obj;
		if (attemptCount != other.attemptCount) {
			return false;
		}
		if (creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!creationDate.equals(other.creationDate)) {
			return false;
		}
		if (identifier == null) {
			if (other.identifier != null) {
				return false;
			}
		} else if (!identifier.equals(other.identifier)) {
			return false;
		}
		if (isVerified != other.isVerified) {
			return false;
		}
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (tokenId == null) {
			if (other.tokenId != null) {
				return false;
			}
		} else if (!tokenId.equals(other.tokenId)) {
			return false;
		}
		/*
		 * if (type != other.type) { return false; }
		 */
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
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
		return "UserVerification [key=" + key + ", tokenId=" + tokenId + ", userId=" + userId + ", identifier=" + identifier /*
																															 * +
																															 * ", type="
																															 * +
																															 * type
																															 */+ ", isVerified=" + isVerified + ", attemptCount=" + attemptCount
				+ ", creationDate=" + creationDate + "]";
	}
}
