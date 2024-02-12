package com.pratishtha.dev.Student_Management_System_CRUD_JPA.repository;

import com.pratishtha.dev.Student_Management_System_CRUD_JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    List<Student> findAll();

    @Override
    Optional<Student> findById(Long id);

    @Override
    Student save(Student student);

    @Override
    void deleteById(Long id);
}
