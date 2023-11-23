package com.example.redis.service;

import com.example.redis.dto.StudentDto;
import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;
import com.example.redis.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StringRedisTemplate stringRedisTemplate;
    @Override
    public Student createStudent(CreateStudentRequest request) {
        Student student = Student.builder()
                .id(UUID.randomUUID().toString())
                .gender(request.getGender())
                .name(request.getName())
                .grade(request.getGrade())
                .build();
        studentRepository.save(student);
        return student;
    }
    @Override
    public void deleteStudentById(String id) {

    }
    @Override
    public Student getStudentById(String id) {
        System.out.println(studentRepository.findById(id));
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void sendRedis(CreateStudentRequest createStudentRequest) {
        stringRedisTemplate.convertAndSend("chat", createStudentRequest.toString());
    }
}
