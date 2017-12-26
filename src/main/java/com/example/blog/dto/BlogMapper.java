package com.example.blog.dto;

import com.example.blog.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    @Mappings({
            @Mapping(target = "title", source = "title"),
            @Mapping(target="text", source = "text"),
            @Mapping(target="datePublic", expression = "java(new java.util.Date())")
    })
    Post NewPostDTOToPost(NewPostDTO post);

    PostDTO PostToPostDTO(Post post);

}
