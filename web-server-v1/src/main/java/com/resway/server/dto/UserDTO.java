package com.resway.server.dto;

import java.time.LocalDateTime;

import com.resway.server.framework.dto.BaseRequestDTO;

public class UserDTO extends BaseRequestDTO {
	/** Unique ID for the user */
	private int usrId;
	/** The user's email address */
	private String usrEmail;
	/** The user's phone number */
	private String usrPhNumber;
	/** The user's password, hashed and salted */
	private String usrPassword;
	/** The user's password salt value */
	private String usrSalt;
	/** The last time the user logged in to the system */
	private LocalDateTime usrLastLogin;
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	public String getUsrPhNumber() {
		return usrPhNumber;
	}
	public void setUsrPhNumber(String usrPhNumber) {
		this.usrPhNumber = usrPhNumber;
	}
	public String getUsrPassword() {
		return usrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	public String getUsrSalt() {
		return usrSalt;
	}
	public void setUsrSalt(String usrSalt) {
		this.usrSalt = usrSalt;
	}
	public LocalDateTime getUsrLastLogin() {
		return usrLastLogin;
	}
	public void setUsrLastLogin(LocalDateTime usrLastLogin) {
		this.usrLastLogin = usrLastLogin;
	}
	/*
	 * (non-Javadoc)
	 * @see com.resway.server.framework.dto.BaseRequestDTO#validate()
	 */
	@Override
	public void validate() {
		/**
		 * PERFORM CUSTOM VALIDATIONS HERE.
		 */
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usrEmail == null) ? 0 : usrEmail.hashCode());
		result = prime * result + usrId;
		result = prime * result + ((usrLastLogin == null) ? 0 : usrLastLogin.hashCode());
		result = prime * result + ((usrPassword == null) ? 0 : usrPassword.hashCode());
		result = prime * result + ((usrPhNumber == null) ? 0 : usrPhNumber.hashCode());
		result = prime * result + ((usrSalt == null) ? 0 : usrSalt.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (usrEmail == null) {
			if (other.usrEmail != null)
				return false;
		} else if (!usrEmail.equals(other.usrEmail))
			return false;
		if (usrId != other.usrId)
			return false;
		if (usrLastLogin == null) {
			if (other.usrLastLogin != null)
				return false;
		} else if (!usrLastLogin.equals(other.usrLastLogin))
			return false;
		if (usrPassword == null) {
			if (other.usrPassword != null)
				return false;
		} else if (!usrPassword.equals(other.usrPassword))
			return false;
		if (usrPhNumber == null) {
			if (other.usrPhNumber != null)
				return false;
		} else if (!usrPhNumber.equals(other.usrPhNumber))
			return false;
		if (usrSalt == null) {
			if (other.usrSalt != null)
				return false;
		} else if (!usrSalt.equals(other.usrSalt))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDTO [usrId=" + usrId + ", usrEmail=" + usrEmail + ", usrPhNumber=" + usrPhNumber + ", usrPassword="
				+ usrPassword + ", usrSalt=" + usrSalt + ", usrLastLogin=" + usrLastLogin + "]";
	}
	
	
}
