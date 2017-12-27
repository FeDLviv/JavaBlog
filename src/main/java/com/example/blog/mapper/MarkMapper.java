package com.example.blog.mapper;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewMarkDTO;
import com.example.blog.entity.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    Mark NewMarkDTOToMark(NewMarkDTO mark);

    MarkDTO MarkToMarkDTO(Mark mark);

}
