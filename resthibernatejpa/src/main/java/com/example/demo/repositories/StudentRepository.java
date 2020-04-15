package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.models.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
