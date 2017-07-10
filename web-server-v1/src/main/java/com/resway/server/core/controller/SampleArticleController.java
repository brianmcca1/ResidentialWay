/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resway.server.core.service.SampleArticleService;
import com.resway.server.dto.SampleArticleDTO;
import com.resway.server.dto.SampleArticleResponseDTO;
import com.resway.server.entity.domain.SampleArticle;
import com.resway.server.framework.core.controller.AbstractController;

/**
 * Controller class for {@link SampleArticle} that handles RESTful requests and
 * communicates with the database laye via the service layer.
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
@RequestMapping("users")
public class SampleArticleController extends AbstractController {
	/** The article service. */
	@Autowired
	private SampleArticleService articleService;

	/**
	 * Gets the article by id.
	 *
	 * @param id
	 *            the id
	 * @return the article by id
	 */
	@RequestMapping(value = "articles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleArticleResponseDTO> read(@PathVariable("id") Integer id) {
		final SampleArticleDTO dto = new SampleArticleDTO();
		dto.setArticleId(id);
		final SampleArticleResponseDTO responseDTO = articleService.read(dto);
		return new ResponseEntity<SampleArticleResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}

	/**
	 * Gets the all articles.
	 *
	 * @return the all articles
	 */
	@RequestMapping(value = "articles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleArticleResponseDTO> fetchAll() {
		final SampleArticleResponseDTO responseDTO = articleService.readAll();
		return new ResponseEntity<SampleArticleResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Adds the article.
	 *
	 * @param article
	 *            the article
	 * @param builder
	 *            the builder
	 * @return the response entity
	 */
	@RequestMapping(value = "articles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleArticleResponseDTO> create(@RequestBody SampleArticleDTO requestDTO) {
		final SampleArticleResponseDTO responseDTO = articleService.create(requestDTO);
		return new ResponseEntity<SampleArticleResponseDTO>(responseDTO, responseDTO.getStatusMessage().getStatus());
	}

	/**
	 * Update article.
	 *
	 * @param article
	 *            the article
	 * @return the response entity
	 */
	@RequestMapping(value = "articles/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody SampleArticleDTO requestDTO) {
		requestDTO.setArticleId(id);
		SampleArticleResponseDTO responseDTO = articleService.update(requestDTO);
		return new ResponseEntity<Void>(responseDTO.getStatusMessage().getStatus());
	}

	/**
	 * Delete article.
	 *
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@RequestMapping(value = "articles/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		final SampleArticleDTO requestDTO = new SampleArticleDTO();
		requestDTO.setArticleId(id);
		SampleArticleResponseDTO responseDTO = articleService.delete(requestDTO);
		return new ResponseEntity<Void>(responseDTO.getStatusMessage().getStatus());
	}
}