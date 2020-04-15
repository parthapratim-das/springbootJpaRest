package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.models.Department;

@Component
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

	

}
