package com.kadmos.apigw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiGWApplicationTest {

    @LocalServerPort
    int port;
    private WebTestClient client;

    @BeforeEach
    public void setup() {
        client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenRetrievingAbalanceSuccesful() {
        client.get().uri("/savings/a/balance")
            .exchange()
            .expectStatus().isOk()
            .expectBody(BigDecimal.class)
            .consumeWith(result -> {
                Assertions.assertNotNull(result.getResponseBody());
            });
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenRetrievingBbalanceSuccesful() {
        client.get().uri("/savings/b/balance")
            .exchange()
            .expectStatus().isOk()
            .expectBody(BigDecimal.class)
            .consumeWith(result -> {
                Assertions.assertNotNull(result.getResponseBody());
            });
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenIncreaseAbalanceSuccessful() {
        client.post().uri("/savings/a/balance").bodyValue(1000)
            .exchange()
            .expectStatus().isOk()
            .expectBody(BigDecimal.class)
            .consumeWith(result -> {
                Assertions.assertNotNull(result.getResponseBody());
            });
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenIncreaseBbalanceSuccessful() {
        client.post().uri("/savings/b/balance").bodyValue(10000)
            .exchange()
            .expectStatus().isOk()
            .expectBody(BigDecimal.class)
            .consumeWith(result -> {
                Assertions.assertNotNull(result.getResponseBody());
            });
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenInsufficientWithdrawalThenThrowError() {
        client.post().uri("/savings/b/balance").bodyValue(-10000)
            .exchange()
            .expectStatus().is5xxServerError()
            .expectBody(String.class)
            .consumeWith(result -> {
                Assertions.assertNotNull(result.getResponseBody());
            });
    }
}
