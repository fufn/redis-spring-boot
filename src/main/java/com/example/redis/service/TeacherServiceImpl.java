package com.example.redis.service;

import com.example.redis.entity.Teacher;
import com.example.redis.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    @Override
    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id).orElse(null);
    }
}
