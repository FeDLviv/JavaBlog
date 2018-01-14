package com.example.blog.controller;

import com.example.blog.dto.PostDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/*
INTEGRATION TEST
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostControllerIT {

    public static final String URL = "http://localhost:8080/api/v1/";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testReadPost() {
        int id = 31;
        String url = URL + "/posts/" + id;
        ResponseEntity<PostDTO> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<PostDTO>() {
                });
        PostDTO entity = response.getBody();
        assertEquals("Fuck!!!", id, entity.getId());
    }
}