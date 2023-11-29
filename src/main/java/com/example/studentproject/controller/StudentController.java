package com.example.studentproject.controller;

import com.example.studentproject.dto.StudentDto;
import com.example.studentproject.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import com.example.studentproject.service.StudentServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    private final ModelMapper modelMapper;
    private final StudentServiceImpl studentService;

    public StudentController(ModelMapper modelMapper, StudentServiceImpl studentService) {
        this.modelMapper = modelMapper;
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        log.info("Starting GET method...");
        return studentService.getAllStudents().stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        log.info("Starting GET method...");
        Student student = studentService.getStudentById(id);
        return modelMapper.map(student, StudentDto.class);
    }

    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        log.info("Starting POST method...");
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        Student student = studentService.createStudent(studentRequest);
        return modelMapper.map(student, StudentDto.class);
    }

    @PutMapping("/students/{id}")
    public StudentDto updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDto studentDto) {
        log.info("Starting PUT method...");
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        Student student = studentService.updateStudent(id, studentRequest);
        return modelMapper.map(student, StudentDto.class);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        log.info("Starting DELETE method...");
        studentService.deleteStudent(id);
    }
}
