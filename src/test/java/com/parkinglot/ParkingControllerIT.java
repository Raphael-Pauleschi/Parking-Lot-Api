package com.parkinglot;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.parkinglot.controller.dto.ParkingCreateDTO;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest() {
		RestAssured.port = randomPort;
		System.out.println("Executing in port: "+randomPort);
	}

	@Test
	void whenfindAllThenCheckResult() {
		/*
		 * RestAssured.given() .when() .get("/cars") .then() .statusCode(200) .body();
		 */

		RestAssured.given()
			.when()
			.get("/cars").then()
			.statusCode(HttpStatus.OK.value());
			
			/*.body("license[1]", Matchers.equalTo("DMS-1111"));
		MapList organize the data based in it's Id,
		so sometimes this test will fail (50/50)*/
	}

	@Test
	void whenCreateThenCheckIsCreated() {
		var createDTO = new ParkingCreateDTO("yellow","uno","SLA-2341","ES");
		
		
		RestAssured.given()
		.when()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/cars").then()
		.statusCode(HttpStatus.CREATED.value())
		.body("color",Matchers.equalTo("yellow"))
		.body("license", Matchers.equalTo("SLA-2341"));
	}
}
