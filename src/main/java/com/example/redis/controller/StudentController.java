package com.example.redis.controller;

import com.example.redis.entity.Student;
import com.example.redis.payload.request.CreateStudentRequest;
import com.example.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Student")
    public Student getStudentById(@PathVariable String id) {
        log.info("GET request to one student");
        return studentService.getStudentById(id);
    }

    @GetMapping()
    public List<Student> getStudent() {
        log.info("GET request to all student");
        return studentService.getStudents();
    }

    @PostMapping("/redis")
    public void sendRedis(@RequestBody CreateStudentRequest createStudentRequest) {
        studentService.sendRedis(createStudentRequest);
    }
}
