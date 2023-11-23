package com.example.redis.entity;

import com.example.redis.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String id;
    private String name;
    private Gender gender;
    private Integer grade;
}
