package com.pratishtha.dev.Student_Management_System_CRUD_JPA.controller;

import com.pratishtha.dev.Student_Management_System_CRUD_JPA.entity.Student;
import com.pratishtha.dev.Student_Management_System_CRUD_JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//  for testing api
    @GetMapping("/test")
    public String testMyStudentManagementApi () {
        return "Hello All!!";
    }

//    READ all students
    @GetMapping("/list")
    public List<Student> getAllStudents () {
        return studentService.findAllStudents();
    }

//    READ single student
    @GetMapping("/{id}")
    public Student getStudentById (@PathVariable long id) {
        return studentService.findStudentById(id);
    }

//    CREATE student
    @PostMapping("/save")
    public Student addStudent (@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


    //    UPDATE student
    @PutMapping("/update/{id}")
    public Student updateStudent (@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

//    DELETE student
    @DeleteMapping("/delete/{id}")
    public void deleteStudent (@PathVariable long id) {
        studentService.deleteStudentById(id);
    }
}
