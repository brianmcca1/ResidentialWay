/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.assembler;

import com.resway.server.domain.entity.UserVerification;
import com.resway.server.domain.key.UserVerificationKey;
import com.resway.server.dto.SampleArticleDTO;
import com.resway.server.dto.UserVerificationDTO;
import com.resway.server.dto.UserVerificationResponseDTO;
import com.resway.server.framework.assembler.IAbstractAssembler;

/**
 * Assembler between {@link UserVerification}, {@link UserVerificationDTO} and
 * {@link SampleArticleDTO}, {@link UserVerificationKey} conversion for test
 * purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class UserVerificationAssembler implements IAbstractAssembler<UserVerification, UserVerificationDTO, UserVerificationKey> {
	@Override
	public UserVerification toDomainObject(UserVerificationDTO dto) {
		UserVerification verification = new UserVerification();
		verification.setIdentifier(dto.getIdentifier());
		//		verification.setType(dto.getType());
		verification.setUserId(dto.getUserId());
		//		verification.setTokenId(dto.getToken());
		return verification;
	}

	@Override
	public UserVerificationDTO toDTOObject(UserVerification entity) {
		return null;
	}

	@Override
	public UserVerificationKey toDomainKey(UserVerificationDTO dto) {
		return null;
	}

	@Override
	public UserVerificationDTO fromDomainKeytoDTOObject(UserVerificationKey key) {
		return null;
	}

	public UserVerificationResponseDTO toResponseDTOObject(UserVerification entity, boolean isCreate) {
		UserVerificationResponseDTO responseDTO = new UserVerificationResponseDTO();
		responseDTO.setUserId(entity.getUserId());
		responseDTO.setIsVerified(entity.isVerified());
		responseDTO.setAttemptCount(entity.getAttemptCount());
		responseDTO.setToken(entity.getTokenId());
		responseDTO.setExpiryIn(87864L); //TODO: Set actual difference.
		responseDTO.setRedirectUri("http://localhost:8080/api/v1/users/" + responseDTO.getUserId() + "/verification?token=" + entity.getTokenId()); //TODO: Build this.
		//			long diffInMillies = new Date(System.currentTimeMillis()).getTime() - entity.getExpiryDate().getTime();
		//			TimeUnit unit = TimeUnit.SECONDS;
		//			diffInMillies = unit.convert(diffInMillies, TimeUnit.SECONDS);
		return responseDTO;
	}
}
