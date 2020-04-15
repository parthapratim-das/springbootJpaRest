package com.example.demo.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentResource {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GET
	@RequestMapping("/")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Department> getAllDepartment()
	{
		return departmentRepository.findAll();
	}
	

}
