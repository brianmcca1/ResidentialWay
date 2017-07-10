package com.resway.server.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resway.server.core.service.UserService;
import com.resway.server.dto.UserDTO;
import com.resway.server.dto.UserResponseDTO;
import com.resway.server.framework.core.controller.AbstractController;


@Controller
@RequestMapping("users")
public class UserController extends AbstractController {
	/** The User service */
	@Autowired
	private UserService userService;
	/**
	 * Gets a user by id
	 * @param id  The User's id
	 * @return The User
	 */
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> read(@PathVariable("id") Integer id){
		final UserDTO dto = new UserDTO();
		dto.setUsrId(id);
		final UserResponseDTO responseDTO = userService.read(dto);
		return new ResponseEntity<UserResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}
	
	/**
	 * Gets all users
	 * @return all users
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> fetchAll(){
		final UserResponseDTO responseDTO = userService.readAll();
		return new ResponseEntity<UserResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}
	
	/**
	 * Creates a user
	 * @param requestDTO The user to create
	 * @return The response
	 */
	@RequestMapping(value = "users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> create(@RequestBody UserDTO requestDTO){
		final UserResponseDTO responseDTO = userService.create(requestDTO);
		return new ResponseEntity<UserResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}
	
	/**
	 * Updates a user
	 * @param id The user to update
	 * @param requestDTO The updated user
	 * @return The response
	 */
	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> update(@PathVariable("id") Integer id, @RequestBody UserDTO requestDTO){
		requestDTO.setUsrId(id);
		UserResponseDTO responseDTO = userService.update(requestDTO);
		return new ResponseEntity<UserResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}
	
	/** 
	 * Delete a user
	 * @param id The user to delete
	 * @return The response
	 */
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> delete(@PathVariable("id") Integer id){
		final UserDTO requestDTO = new UserDTO();
		requestDTO.setUsrId(id);
		UserResponseDTO responseDTO = userService.delete(requestDTO);
		return new ResponseEntity<UserResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}
}
