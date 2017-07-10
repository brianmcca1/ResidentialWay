/**
 * 
 */
package com.resway.server.entity.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.resway.server.entity.key.UserKey;
import com.resway.server.framework.entity.domain.AbstractDomainKey;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

/**
 * Entity/Domain Object class for a ResWay User
 * @author Brian
 * @since 1.0.0
 *
 */
@Entity
@Table(name = "User")
public class User extends AbstractDomainObject {

	@Override
	public String toString() {
		return "User [key=" + key + ", usrEmail=" + usrEmail + ", usrPhNumber=" + usrPhNumber + ", usrPassword="
				+ usrPassword + ", usrSalt=" + usrSalt + ", usrLastLogin=" + usrLastLogin + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780447284189200304L;
	@EmbeddedId
	@AttributeOverride(name = "userId", column = @Column(name = "usr_id"))
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UserKey key;
	/** The user's email */
	@Column(name = "usr_email")
	private String usrEmail;
	/** The user's phone number */
	@Column(name="usr_ph_number")
	private String usrPhNumber;
	/** The user's password, hashed & salted */
	@Column(name = "usr_auth_pass")
	private String usrPassword;
	/** The user's password salt value */
	@Column(name = "usr_auth_salt")
	private String usrSalt;
	/** The last time the user logged in to the system */
	@Column(name = "usr_last_login")
	private LocalDateTime usrLastLogin;
	
	/** Instantiates a new User */
	public User() {
		super();
	}

	@Override
	public UserKey getKey() {
		return key;
	}

	@Override
	public void setKey(AbstractDomainKey key) {
		this.key = (UserKey) key;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		User other = (User) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
