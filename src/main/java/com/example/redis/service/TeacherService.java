package com.example.redis.service;

import com.example.redis.entity.Teacher;
import com.example.redis.payload.request.CreateTeacherRequest;

public interface TeacherService {

    Teacher getTeacherById(String id);

    Teacher createTeacher(CreateTeacherRequest request);
}
