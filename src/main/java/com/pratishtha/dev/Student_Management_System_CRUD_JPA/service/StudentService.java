package com.pratishtha.dev.Student_Management_System_CRUD_JPA.service;

import com.pratishtha.dev.Student_Management_System_CRUD_JPA.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Long id);
    Student saveStudent (Student student);
    Student updateStudent (Long id, Student student);
    void deleteStudentById (Long id);

}
