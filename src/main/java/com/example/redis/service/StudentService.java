package com.example.redis.service;

import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;

import java.util.List;

public interface StudentService {

    Student createStudent(CreateStudentRequest request);

    void deleteStudentById(String id);

    Student getStudentById(String id);

    void sendRedis(CreateStudentRequest createStudentRequest);

    List<Student> getStudents();
}
