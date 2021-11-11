package com.labforward;

/**
 * @author Edgard Saad
 * the below class is created for testing the API
 * it will make sure the build has no error before run
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labforward.vo.WordSearchResponse;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "10000")
class AnalyzerServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	public static HttpHeaders headers;
	public static ObjectMapper mapper;
	
	@BeforeAll
	public static void initialize() throws Exception {

        mapper = new ObjectMapper();
	}

	/**
	 * first test scenario
	 * check if http status is 200
	 * check if response is not null
	 * validate if the response is correct given specific parameters
	 */
	@Test
	public void testFirstScenario() throws Exception {
		ResponseEntity<WordSearchResponse> resp = null;
		resp = this.restTemplate.getForEntity("http://localhost:"+port+"/WordSearchService/ProcessText?word=Word&text=Word Words Wor word", WordSearchResponse.class);
		assertEquals(HttpStatus.OK, resp.getStatusCode(), "word-search-service Request returned not OK");
		assertNotNull(resp.getBody(), "word-search-service Response is null");
		assertEquals(resp.getBody().getFrequency(), 1);
		assertEquals(resp.getBody().getSimilarities(), "Words,Wor,word");
	}
	
	/**
	 * Second test scenario
	 * check if http status is 200
	 * check if response is not null
	 * validate if the response is correct given specific parameters
	 */
	@Test
	public void testSecondScenario() throws Exception {
		ResponseEntity<WordSearchResponse> resp = null;
		resp = this.restTemplate.getForEntity("http://localhost:"+port+"/WordSearchService/ProcessText?word=Word&text=Word Word Word word", WordSearchResponse.class);
		assertEquals(HttpStatus.OK, resp.getStatusCode(), "word-search-service Request returned not OK");
		assertNotNull(resp.getBody(), "word-search-service Response is null");
		assertEquals(resp.getBody().getFrequency(), 3);
		assertEquals(resp.getBody().getSimilarities(), "word");
	}
}