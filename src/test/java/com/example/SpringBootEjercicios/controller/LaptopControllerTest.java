package com.example.SpringBootEjercicios.controller;

import com.example.SpringBootEjercicios.entity.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

        private TestRestTemplate testRestTemplate;

        @Autowired
        private RestTemplateBuilder restTemplateBuilder;

        @LocalServerPort
        private int port;

    @BeforeEach
    void setUp() {
            restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
            testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "marca": "MSI",
                    "sistemaOperativo": "Sin Sistema Operativo",
                    "memoriaRam": 16,
                    "discoDuro": 512,
                    "peso": 1.86,
                    "precio": 999.99,
                    "color": "Negro",
                    "envioGratis": true
                }
                """;

        HttpEntity<String> peticion = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, peticion, Laptop.class);
        Laptop resultado = response.getBody();
        assertEquals(1L, resultado.getId());
        assertEquals("MSI", resultado.getMarca());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }
}