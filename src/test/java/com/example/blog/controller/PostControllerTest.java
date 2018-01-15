package com.example.blog.controller;

import com.example.blog.dto.PostDTO;
import com.example.blog.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
UNIT TEST
 */
@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PostControllerTest {

    @MockBean
    //@Mock
    private PostService postService;

    @Autowired
    //@InjectMocks
    private PostController postController;

    @Test
    public void testReadPost() {
        int id = 1;
        when(postService.readPost(id)).thenReturn(new PostDTO());
        postController.readPost(id);
        verify(postService).readPost(id);
    }

}