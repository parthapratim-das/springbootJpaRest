package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Teacher;
import com.example.demo.repositories.TeacherRepository;

@RestController
@RequestMapping("/teachers")
public class TeacherResource {
	
	Logger logger = LoggerFactory.getLogger(TeacherResource.class);
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@GET
	@RequestMapping("/all")
	public List<Teacher> getAllTeachers()
	{
		
		logger.trace("TeacherResources getAll method invoked");
		return teacherRepository.findAll();
				
	}
	
	@GET
	@RequestMapping("/{id}")
	public Teacher findTeacherById(@PathVariable("id") Integer teacherId)
	{
		Optional<Teacher> optionalEntity = teacherRepository.findById(teacherId);
		Teacher teacher = optionalEntity.get();
		return teacher;
	}
	

}
