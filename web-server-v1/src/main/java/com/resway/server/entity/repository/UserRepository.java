package com.resway.server.entity.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.resway.server.entity.domain.User;
import com.resway.server.entity.key.UserKey;
import com.resway.server.framework.entity.repository.AbstractRepository;

@Repository
@Transactional
public class UserRepository extends AbstractRepository<User, UserKey> implements IUserRepository<User, UserKey> {

	@Override
	public User create(User user) throws Exception {
		return super.create(user);
	}
	
	@Override
	public void update(User user) throws Exception {
		super.update(user);
	}
	
	@Override
	public void delete(User user) throws Exception {
		super.delete(user);
	}
	
	@Override
	public List<User> readAll() throws Exception {
		return null;
	}

	@Override
	public User read(UserKey key) throws Exception {
		return super.read(User.class, key);
	}

}
