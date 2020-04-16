package com.example.demo.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;


@ExtendWith(MockitoExtension.class)
class DepartmentResourceTest {

	@InjectMocks
	DepartmentResource departmentResource;
	
	@Mock
	DepartmentRepository departmentRepository;
	
	@Test
	void testGetAllDepartment() {
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department(101,"CSE"));
		departments.add(new Department(102,"IT"));
		
		when(departmentRepository.findAll()).thenReturn(departments);
		
		List<Department> expectedList = departmentRepository.findAll();
		
		assertThat(expectedList.size()).isEqualTo(2);
		assertThat(expectedList.get(0).getDeptName()).isEqualTo("CSE");
	}

}
