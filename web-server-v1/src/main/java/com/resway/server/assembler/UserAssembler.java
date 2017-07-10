package com.resway.server.assembler;

import com.resway.server.dto.UserDTO;
import com.resway.server.entity.domain.User;
import com.resway.server.entity.key.UserKey;
import com.resway.server.framework.assembler.IAbstractAssembler;

public class UserAssembler implements IAbstractAssembler<User, UserDTO, UserKey> {

	@Override
	public User toDomainObject(UserDTO dto) {
		final User domainObj = new User();
		domainObj.setUsrEmail(dto.getUsrEmail());
		domainObj.setUsrPhNumber(dto.getUsrPhNumber());
		domainObj.setUsrPassword(dto.getUsrPassword());
		domainObj.setUsrSalt(dto.getUsrSalt());
		domainObj.setUsrLastLogin(dto.getUsrLastLogin());
		domainObj.setKey(toDomainKey(dto));
		return domainObj;
	}

	@Override
	public UserDTO toDTOObject(User entity) {
		final UserDTO requestDTO = new UserDTO();
		requestDTO.setUsrEmail(entity.getUsrEmail());
		requestDTO.setUsrPhNumber(entity.getUsrPhNumber());
		requestDTO.setUsrPassword(entity.getUsrPassword());
		requestDTO.setUsrSalt(entity.getUsrSalt());
		requestDTO.setUsrLastLogin(entity.getUsrLastLogin());
		requestDTO.setUsrId(entity.getKey().getUserId());
		return requestDTO;
	}

	@Override
	public UserKey toDomainKey(UserDTO dto) {
		final UserKey key = new UserKey();
		if(dto.getUsrId() != 0) {
			key.setUserId(dto.getUsrId());
		}
		return key;
	}

	@Override
	public UserDTO fromDomainKeytoDTOObject(UserKey key) {
		final UserDTO requestDTO = new UserDTO();
		requestDTO.setUsrId(key.getUserId());
		return requestDTO;
	}

}
