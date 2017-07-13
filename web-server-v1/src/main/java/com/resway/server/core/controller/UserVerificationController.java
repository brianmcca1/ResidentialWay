/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.resway.server.core.service.UserVerificationService;
import com.resway.server.domain.entity.UserVerification;
import com.resway.server.dto.UserVerificationDTO;
import com.resway.server.dto.UserVerificationResponseDTO;
import com.resway.server.framework.core.controller.AbstractController;

/**
 * Controller class for {@link UserVerification} that handles RESTful requests
 * and communicates with the database layer via the service layer. The
 * {@link UserVerificationService} service performs token generationa and
 * validation for verification of a users email address and mobile number.
 *
 * <u>NOTE:</u>
 * <ul>
 * <li>Write brief business description of what the purpose of this class is.</li>
 * <li>List the methods that are as a part of the class.</li>
 * </ul>
 *
 * @author Kevin
 * @since 1.0.0
 */
@Controller
@RequestMapping("verification")
public class UserVerificationController extends AbstractController {
	/** The {@link UserVerificationService} */
	@Autowired
	private UserVerificationService userVerificationService;

	//	/** Unique id of the user */
	//	private Integer userId;
	//
	//	/**
	//	 * Fetches the unique id of the user.
	//	 *
	//	 * @return {@link Integer} unique id of the user.
	//	 */
	//	public Integer getUserId() {
	//		return userId;
	//	}
	//
	//	/**
	//	 * Sets the unique id of the user.
	//	 *
	//	 * @param userId
	//	 *            {@link Integer} unique id of the user.
	//	 */
	//	public void setUserId(Integer userId) {
	//		this.userId = userId;
	//	}
	//
	//	public UserVerificationController(Integer userID) {
	//		super();
	//		setUserId(userID);
	//	}
	/**
	 * Creates a verification request for the given medium (Email of Phone).
	 * Generates a token and a redirection link for the user to validate his
	 * email/phone number.
	 *
	 * @param requestDTO
	 * @return {@link ResponseEntity} returns the entity status and details
	 *         associated with the token consisting of the redirection url.
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVerificationResponseDTO> create(@RequestBody UserVerificationDTO requestDTO) {
		final UserVerificationResponseDTO responseDTO = userVerificationService.create(requestDTO);
		return new ResponseEntity<UserVerificationResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}

	/**
	 * Validates the user with the identity (email address or mobile number) and
	 * the token provided. These details are then verified with the database
	 * against previous entries and to ensure authentication.
	 *
	 * @param requestQueryParams
	 *            </br><u>Query parameters. </u> <li>token: indicates the token</li>
	 *            <li>
	 *            identity: indicates the identity of the user (email or mobile)
	 *            </li>
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVerificationResponseDTO> verify(@RequestParam Map<String, String> requestQueryParams) {
		UserVerificationDTO requestDTO = new UserVerificationDTO();
		requestDTO.setUserId(getUserId());
		requestDTO.setToken(requestQueryParams.get("token"));
		requestDTO.setIdentifier(requestQueryParams.get("identity"));
		final UserVerificationResponseDTO responseDTO = userVerificationService.validate(requestDTO);
		return new ResponseEntity<UserVerificationResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}

	/**
	 * TODO: DELETE This. User from UserController.
	 */
	private Integer getUserId() {
		return 7235512;
	}
}