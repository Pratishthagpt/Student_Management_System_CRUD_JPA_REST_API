package com.pratishtha.dev.Student_Management_System_CRUD_JPA.service;

import com.pratishtha.dev.Student_Management_System_CRUD_JPA.entity.Student;
import com.pratishtha.dev.Student_Management_System_CRUD_JPA.exception.InvalidStudentException;
import com.pratishtha.dev.Student_Management_System_CRUD_JPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        Student student;
        if (studentOptional.isEmpty()) {
            throw new InvalidStudentException("Student id not found.");
        }
        student = studentOptional.get();

        return student;
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setPhoneNo(student.getPhoneNo());

        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student studentfromRepo = findStudentById(id);

        studentfromRepo.setFirstName(student.getFirstName());
        studentfromRepo.setLastName(student.getLastName());
        studentfromRepo.setEmail(student.getEmail());
        studentfromRepo.setPhoneNo(student.getPhoneNo());

        return studentRepository.save(studentfromRepo);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
