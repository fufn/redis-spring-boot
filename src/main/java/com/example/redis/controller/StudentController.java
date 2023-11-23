package com.example.redis.controller;

import com.example.redis.dto.StudentDto;
import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;
import com.example.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/redis")
    public void sendRedis(@RequestBody CreateStudentRequest createStudentRequest){
        studentService.sendRedis(createStudentRequest);
    }
}
