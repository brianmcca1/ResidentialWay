package com.resway.server.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.resway.server.assembler.UserAssembler;
import com.resway.server.common.ApplicationHelper;
import com.resway.server.dto.UserDTO;
import com.resway.server.dto.UserResponseDTO;
import com.resway.server.entity.domain.User;
import com.resway.server.entity.key.UserKey;
import com.resway.server.entity.repository.IUserRepository;
import com.resway.server.framework.core.service.AbstractService;
import com.resway.server.framework.dto.StatusMessage;

@Service
public class UserService extends AbstractService implements IUserService {

	@Autowired
	private IUserRepository<User, UserKey> userRepo;
	
	@Override
	public UserResponseDTO create(UserDTO userDTO) {
		final UserAssembler assembler = new UserAssembler();
		User user = assembler.toDomainObject(userDTO);
		UserResponseDTO response = new UserResponseDTO();
		try {
			user = userRepo.create(user);
			UserDTO respDTO = assembler.toDTOObject(user);
			response.getDtos().add(respDTO);
			response.setStatusMessage(new StatusMessage(HttpStatus.CREATED));
		} catch(final Exception ex) {
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	@Override
	public UserResponseDTO read(UserDTO userDTO) {
		final UserAssembler assembler = new UserAssembler();
		UserResponseDTO response = new UserResponseDTO();
		try {
			final UserKey key = assembler.toDomainKey(userDTO);
			final User domainObject = userRepo.read(key);
			UserDTO respDTO = assembler.toDTOObject(domainObject);
			response.getDtos().add(respDTO);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	@Override
	public UserResponseDTO update(UserDTO userDTO) {
		final UserAssembler assembler = new UserAssembler();
		final UserResponseDTO response = new UserResponseDTO();
		try {
			final User originalObject = userRepo.read(assembler.toDomainKey(userDTO));
			final User updatedObject = assembler.toDomainObject(userDTO);
			ApplicationHelper.copyNonNullProperties(updatedObject, originalObject);
			userRepo.update(originalObject);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
 		} catch (final Exception ex) {
 			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
 		}
		return response;
	}

	@Override
	public UserResponseDTO delete(UserDTO userDTO) {
		final UserAssembler assembler = new UserAssembler();
		final UserResponseDTO response = new UserResponseDTO();
		final User user = assembler.toDomainObject(userDTO);
		try {
			userRepo.delete(user);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

	@Override
	public UserResponseDTO readAll() {
		final UserAssembler assembler = new UserAssembler();
		final UserResponseDTO response = new UserResponseDTO();
		try {
			final List<User> users = userRepo.readAll();
			List<UserDTO> dtoList = new ArrayList<UserDTO>(users.size());
			for(final User user : users) {
				dtoList.add(assembler.toDTOObject(user));
			}
			response.setDtos(dtoList);
			response.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (final Exception ex) {
			ex.printStackTrace();
			response.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return response;
	}

}
