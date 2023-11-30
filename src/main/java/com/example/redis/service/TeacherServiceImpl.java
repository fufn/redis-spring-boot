package com.example.redis.service;

import com.example.redis.entity.Teacher;
import com.example.redis.payload.request.CreateTeacherRequest;
import com.example.redis.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher createTeacher(CreateTeacherRequest request){
        Teacher teacher = Teacher.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .name(request.getName())
                .salary(request.getSalary())
                .build();
        teacherRepository.save(teacher);
        return teacher;
    }
}
