package com.example.redis.service;

import com.example.redis.dto.StudentDto;
import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;

public interface StudentService {

    Student createStudent(CreateStudentRequest request);
    void deleteStudentById(String id);
    Student getStudentById(String id);

    void sendRedis(CreateStudentRequest createStudentRequest);
}
