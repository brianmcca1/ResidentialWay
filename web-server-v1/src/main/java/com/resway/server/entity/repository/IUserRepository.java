package com.resway.server.entity.repository;

import java.util.List;

public interface IUserRepository<User, UserKey> {
	public User create(User user) throws Exception;
	
	public List<User> readAll() throws Exception;
	
	public User read(UserKey key) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(User user) throws Exception;
	
}
