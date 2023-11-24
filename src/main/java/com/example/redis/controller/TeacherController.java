package com.example.redis.controller;

import com.example.redis.entity.Student;
import com.example.redis.entity.Teacher;
import com.example.redis.payload.request.CreateStudentRequest;
import com.example.redis.service.StudentService;
import com.example.redis.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    public Teacher createStudent(@PathVariable String id){
        return teacherService.getTeacherById(id);
    }
}
