package com.example.redis.service;

import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;
import com.example.redis.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

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
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(String id) {
        log.info("Get from database");
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void sendRedis(CreateStudentRequest createStudentRequest) {
        stringRedisTemplate.convertAndSend("chat", createStudentRequest.toString());
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}
