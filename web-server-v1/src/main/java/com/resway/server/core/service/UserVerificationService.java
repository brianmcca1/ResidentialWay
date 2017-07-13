/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.service;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.resway.server.assembler.UserVerificationAssembler;
import com.resway.server.domain.entity.UserVerification;
import com.resway.server.domain.key.UserVerificationKey;
import com.resway.server.domain.repository.IUserVerificationRepository;
import com.resway.server.dto.UserVerificationDTO;
import com.resway.server.dto.UserVerificationResponseDTO;
import com.resway.server.framework.core.service.AbstractService;
import com.resway.server.framework.dto.StatusMessage;

/**
 * The service class for {@link UserVerification} object that interacts with the
 * database. The userverifiction service performs token generationa and
 * validation for verification of a users email address and mobile number.
 *
 * @author Kevin
 * @since 1.0.0
 */
@Service
public class UserVerificationService extends AbstractService implements IUserVerificationService {
	/** Repository for {@link UserVerification} */
	@Autowired
	private IUserVerificationRepository<UserVerification, UserVerificationKey> userVerificationRepo;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.IUserVerificationService#create(com.resway
	 * .server.dto.UserVerificationDTO)
	 */
	@Override
	public UserVerificationResponseDTO create(UserVerificationDTO verificationDTO) {
		UserVerificationResponseDTO responseDTO = new UserVerificationResponseDTO();
		try {
			final UserVerificationAssembler assembler = new UserVerificationAssembler();
			UserVerification verification = assembler.toDomainObject(verificationDTO);
			verification.setAttemptCount(verification.getAttemptCount() + 1);
			//			if (verification.getIdentifier().contains("@")) {
			//				verification.setType(UserVerificationType.EML);
			//			} else {
			//				verification.setType(UserVerificationType.MOB);
			//			}
			Integer token = 100000 + new Random().nextInt(900000);
			verification.setTokenId(token.toString());
			verification = userVerificationRepo.create(verification);
			responseDTO = assembler.toResponseDTOObject(verification, true);
			responseDTO.setStatusMessage(new StatusMessage(HttpStatus.CREATED));
		} catch (Exception ex) {
			ex.printStackTrace();
			responseDTO.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return responseDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.IUserVerificationService#validate(com.
	 * resway.server.dto.UserVerificationDTO)
	 */
	@Override
	public UserVerificationResponseDTO validate(UserVerificationDTO verificationRequestDTO) {
		UserVerificationResponseDTO responseDTO = new UserVerificationResponseDTO();
		try {
			HashMap<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("userId", verificationRequestDTO.getUserId().toString());
			queryMap.put("identifier", verificationRequestDTO.getIdentifier());
			queryMap.put("token", verificationRequestDTO.getToken());
			UserVerification fetchedVerification = fetchVerificationObject(queryMap);
			if (fetchedVerification.getTokenId().equals(verificationRequestDTO.getToken())) {
				responseDTO.setStatusMessage(new StatusMessage(HttpStatus.OK));
			} else {
				//TODO: set expiry and no of attemps here.
				responseDTO.setStatusMessage(new StatusMessage(HttpStatus.UNAUTHORIZED));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseDTO.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.IUserVerificationService#read(com.resway
	 * .server.dto.UserVerificationDTO)
	 */
	@Override
	public UserVerificationResponseDTO read(UserVerificationDTO verificationRequestDTO) {
		UserVerificationResponseDTO responseDTO = new UserVerificationResponseDTO();
		final UserVerificationAssembler assembler = new UserVerificationAssembler();
		try {
			assembler.toDomainObject(verificationRequestDTO);
			HashMap<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("userId", verificationRequestDTO.getUserId().toString());
			queryMap.put("identifier", verificationRequestDTO.getIdentifier());
			queryMap.put("token", verificationRequestDTO.getToken());
			UserVerification fetchedVerification = fetchVerificationObject(queryMap);
			assembler.toResponseDTOObject(fetchedVerification, false);
			responseDTO.setStatusMessage(new StatusMessage(HttpStatus.OK));
		} catch (Exception ex) {
			ex.printStackTrace();
			responseDTO.setStatusMessage(new StatusMessage(HttpStatus.BAD_REQUEST));
		}
		return null;
	}

	private UserVerification fetchVerificationObject(HashMap<String, String> queryMap) {
		UserVerification userVerification = userVerificationRepo.read(queryMap);
		return userVerification;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.IUserVerificationService#update(com.resway
	 * .server.dto.UserVerificationDTO)
	 */
	@Override
	public StatusMessage update(UserVerificationDTO verificationDTO) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.resway.server.core.service.IUserVerificationService#delete(com.resway
	 * .server.dto.UserVerificationDTO)
	 */
	@Override
	public StatusMessage delete(UserVerificationDTO verificationDTO) {
		return null;
	}
}