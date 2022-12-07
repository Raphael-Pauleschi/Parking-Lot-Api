package com.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest() {
		RestAssured.port = randomPort;
		System.out.println(randomPort);
	}

	@Test
	void findAll() {
		
	}

	@Test
	void create() {

	}
}
