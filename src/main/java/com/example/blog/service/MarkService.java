package com.example.blog.service;

import com.example.blog.dto.MarkDTO;
import com.example.blog.dto.NewMarkDTO;
import com.example.blog.mapper.MarkMapper;
import com.example.blog.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public MarkDTO createMark(NewMarkDTO mark) {
        return MarkMapper.INSTANCE.MarkToMarkDTO(markRepository.save(MarkMapper.INSTANCE.NewMarkDTOToMark(mark)));
    }

    public List<MarkDTO> readMarks() {
        return markRepository.getList();
    }

    public MarkDTO readMark(int id) {
        return markRepository.getById(id);
    }

    public int updateMark(MarkDTO mark, int id) {
        return markRepository.updateMark(id, mark.getName());
    }

    public void deleteMarks() {
        markRepository.deleteAll();
    }

    public void deleteMark(int id) {
        markRepository.deleteById(id);
    }

}
