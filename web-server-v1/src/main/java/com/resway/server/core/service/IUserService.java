/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import com.resway.server.dto.UserDTO;
import com.resway.server.dto.UserResponseDTO;

public interface IUserService {

	public UserResponseDTO create(UserDTO userDTO);
	
	public UserResponseDTO read(UserDTO userDTO);
	
	public UserResponseDTO update(UserDTO userDTO);
	
	public UserResponseDTO delete(UserDTO userDTO);
	
	public UserResponseDTO readAll();
}
