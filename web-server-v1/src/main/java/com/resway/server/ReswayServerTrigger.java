/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Represents a launcher class for the SpringBoot Application. Used to fetch all
 * properties from the <b>application.properties</b> file and triggers to start
 * an instance on the TomCat server on the desired port (8080: dev purpose)
 *
 * </br></br><u>Refresh project</u> </br><i>mvn clean eclipse:eclipse </i>
 * </br></br><u>Start up server</u> </br><i>mvn spring-boot:run </i>
 *
 * @since 1.0.0
 * @author Kevin
 */
@SpringBootApplication
@ComponentScan({ "com.resway.server.core.controller", "com.resway.server.core.service" })
@ComponentScan({})
@EnableJpaRepositories({ "com.resway.server.entity.repository" })
public class ReswayServerTrigger extends SpringBootServletInitializer {
	/** The application. */
	private static Class<ReswayServerTrigger> application = ReswayServerTrigger.class;

	/**
	 * The main method to trigger the launch of the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReswayServerTrigger.class, args);
		System.out.println("\n =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=" + "\n		    	     SERVER STARTED"
				+ "\n =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.boot.web.support.SpringBootServletInitializer#configure
	 * (org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(application);
	}
}