package com.example.redis.payload.request;

import com.example.redis.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {

    private String name;
    private Gender gender;
    private Integer grade;
}
