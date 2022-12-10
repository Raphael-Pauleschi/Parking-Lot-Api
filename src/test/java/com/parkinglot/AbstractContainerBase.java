package com.parkinglot;

import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.PostgreSQLContainer;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public abstract class AbstractContainerBase {
	static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;
	static {
		POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:15.1-alpine");
		POSTGRE_SQL_CONTAINER.start(); 
		
		System.out.println("########## "+POSTGRE_SQL_CONTAINER.getJdbcUrl());
		
		System.setProperty("spring.datasource.url", POSTGRE_SQL_CONTAINER.getJdbcUrl());
		System.setProperty("spring.datasource.hikari.username", POSTGRE_SQL_CONTAINER.getUsername());
		System.setProperty("spring.datasource.password", POSTGRE_SQL_CONTAINER.getPassword());
		
	}

}