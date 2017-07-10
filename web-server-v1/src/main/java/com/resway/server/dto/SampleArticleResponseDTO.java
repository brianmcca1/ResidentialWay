/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.framework.dto.BaseResponseDTO;

/**
 * Sample Response DTO for {@link SampleArticle} --> test purpose.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class SampleArticleResponseDTO extends BaseResponseDTO {
	/**
	 * Indicates the list of {@link SampleArticleDTO}
	 */
	private List<SampleArticleDTO> dtos;

	public SampleArticleResponseDTO() {
		super();
		dtos = new ArrayList<SampleArticleDTO>();
	}

	/**
	 * Fetches the list of {@link SampleArticleDTO}
	 *
	 * @return List of {@link SampleArticleDTO}
	 */
	public List<SampleArticleDTO> getDtos() {
		return dtos;
	}

	/**
	 * Sets the list of {@link SampleArticleDTO}
	 *
	 * @param dtos
	 *            List of {@link SampleArticleDTO}
	 */
	public void setDtos(List<SampleArticleDTO> dtos) {
		this.dtos = dtos;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SampleArticleResponseDTO [dtos=" + dtos + "]";
	}
}
