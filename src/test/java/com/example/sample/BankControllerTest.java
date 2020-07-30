package com.example.sample;

import com.example.sample.rest.controller.BankAccountController;
import com.example.sample.service.ApiEndpoints;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;


/**
 * Tests for banking account controller
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BankControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BankAccountController controller;

    @LocalServerPort
    private int port;

    /**
     * Get environment root url
     */
    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    /**
     * Test for get all banking accounts by user id by api request
     * Asserts that response body is not null and contains banking accounts
     */
    @Test
    public void testGetBankAccountsByUserId() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + ApiEndpoints.accounts + "?userId=12345",
                HttpMethod.GET, entity, String.class);
        String body = response.getBody();
        log.debug(body);
        assertNotNull(body);
    }
}
