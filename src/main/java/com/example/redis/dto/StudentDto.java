package com.example.redis.dto;

import com.example.redis.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private String id;
    private String name;
    private Gender gender;
    private Integer grade;
}
