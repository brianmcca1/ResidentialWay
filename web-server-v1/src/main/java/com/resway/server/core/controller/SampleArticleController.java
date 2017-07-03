/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resway.server.core.service.SampleArticleService;
import com.resway.server.dto.SampleArticleRequestDTO;
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
	@GetMapping("articles/{id}")
	public ResponseEntity<SampleArticleResponseDTO> getArticleById(@PathVariable("id") Integer id) {
		final SampleArticleRequestDTO dto = new SampleArticleRequestDTO();
		dto.setArticleId(id);
		final SampleArticleResponseDTO responseDTO = articleService.read(dto);
		return new ResponseEntity<SampleArticleResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Gets the all articles.
	 *
	 * @return the all articles
	 */
	@RequestMapping(value = "articles", method = RequestMethod.GET)
	public ResponseEntity<List<SampleArticleResponseDTO>> getAllArticles() {
		System.out.println("Service triggered");
		final List<SampleArticleResponseDTO> list = articleService.readAll();
		System.out.println("Items found : " + list.size());
		return new ResponseEntity<List<SampleArticleResponseDTO>>(list, HttpStatus.OK);
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
	public ResponseEntity<SampleArticleResponseDTO> addArticle(@RequestBody SampleArticleRequestDTO requestDTO) {
		final SampleArticleResponseDTO responseDTO = articleService.create(requestDTO);
		return new ResponseEntity<SampleArticleResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
	 * Update article.
	 *
	 * @param article
	 *            the article
	 * @return the response entity
	 */
	@PutMapping("articles")
	public ResponseEntity<Void> updateArticle(@RequestBody SampleArticleRequestDTO requestDTO) {
		articleService.update(requestDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Delete article.
	 *
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@DeleteMapping("articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		final SampleArticleRequestDTO requestDTO = new SampleArticleRequestDTO();
		requestDTO.setArticleId(id);
		articleService.delete(requestDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}