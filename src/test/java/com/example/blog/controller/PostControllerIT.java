package com.example.blog.controller;

import com.example.blog.dto.PostDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/*
INTEGRATION TEST
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostControllerIT {

    public static final String URL = "http://localhost:8080/api/v1/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testReadPost() {
        int id = 31;
        String url = URL + "/posts/" + id;
        ResponseEntity<PostDTO> response = restTemplate.getForEntity(url, PostDTO.class);
        assertThat(response.getBody().getId()).isEqualTo(id);
    }
    
}