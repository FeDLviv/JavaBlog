package com.example.blog.controller;

import com.example.blog.dto.PostDTO;
import com.example.blog.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
UNIT TEST
 */
@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @Test
    public void testReadPost() {
        int id = 1;
        when(postService.readPost(id)).thenReturn(new PostDTO());
        postController.readPost(id);
        verify(postService).readPost(id);
    }

}