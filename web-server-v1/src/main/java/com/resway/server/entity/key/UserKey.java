package com.resway.server.entity.key;

import javax.persistence.Embeddable;

import com.resway.server.framework.entity.domain.AbstractDomainKey;

@Embeddable
public class UserKey extends AbstractDomainKey {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3487842173054048014L;
	private int userId;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserKey other = (UserKey) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
}
