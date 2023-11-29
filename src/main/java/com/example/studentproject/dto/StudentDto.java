package com.example.studentproject.dto;


import com.example.studentproject.entity.Group;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private Timestamp enrollDate;
    private String studentName;
    private Group studentGroup;
}
