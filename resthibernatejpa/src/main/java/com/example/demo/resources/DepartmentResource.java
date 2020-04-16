package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GET
	@RequestMapping("/{id}")
	public Department findDepartmetById(@PathVariable("id") Integer deptId)
	{
		Optional<Department> optionalEntity = departmentRepository.findById(deptId);
		Department department = optionalEntity.get();
		return department;
	}
	
	@POST
	@RequestMapping("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentRepository.saveAndFlush(department);
	}
	
	@DeleteMapping("/delete/{id}")
	public Department deleteDepartmentById(@PathVariable("id")int deptId)
	{
		Department deletedDept = new Department();
		Optional<Department> optionalEntity = departmentRepository.findById(deptId);
		deletedDept = optionalEntity.get();
		departmentRepository.deleteById(deptId);
		return deletedDept;
	}
	
	@PutMapping("/put")
	public Department updateDepartment(@RequestBody Department department)
	{
		Department updatedDept = new Department();
		Optional<Department> optionalEntity = departmentRepository.findById(department.getId());
		updatedDept = optionalEntity.get();
		departmentRepository.save(department);
		return department;
	}
	

}
