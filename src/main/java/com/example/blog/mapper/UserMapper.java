package com.example.blog.mapper;

import com.example.blog.dto.NewUserDTO;
import com.example.blog.dto.UserDTO;
import com.example.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User NewUserDTOToUser(NewUserDTO user);

    UserDTO UserToUserDTO(User user);
}
