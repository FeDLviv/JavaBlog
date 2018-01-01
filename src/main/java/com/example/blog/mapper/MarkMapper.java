package com.example.blog.mapper;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewMarkDTO;
import com.example.blog.entity.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MarkMapper {

    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    Mark NewMarkDTOToMark(NewMarkDTO mark);

    MarkDTO MarkToMarkDTO(Mark mark);

    Set<MarkDTO> MarkToMarkDTO(Set<Mark> mark);

}
