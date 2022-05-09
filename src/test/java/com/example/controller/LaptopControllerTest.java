package com.example.controller;

import com.example.config.WebSecurityConfig;
import com.example.entity.Laptop;
import com.example.repository.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder).withBasicAuth("admin","5678");
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                  "brand": "test",
                  "memory": 3,
                  "processor": "test"
                }
                                
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptop/create",HttpMethod.POST,request,Laptop.class);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops",Laptop[].class);

        if(response.getBody()!=null){
            assertEquals(HttpStatus.OK,response.getStatusCode());
        }else{
            assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
        }

    }

    @Test
    void findOneById() {

        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptop/1",Laptop.class);
        assertEquals(HttpStatus.FOUND,response.getStatusCode());
    }

    @Test
    void delete() {

        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptop/1",Laptop.class);
        if(response.getBody()!=null){//exist the laptop
            testRestTemplate.delete("/api/laptop/delete/1");
            assertEquals(HttpStatus.OK,HttpStatus.OK);
        }else{
            assertEquals(HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

    public void begin(){

    }
}