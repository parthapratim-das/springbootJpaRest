package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentResource {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GET
	@RequestMapping("/all")
	public List<Student> findAllStudents()
	{
		return studentRepository.findAll();
	}
	
	@GET
	@RequestMapping("/{id}")
	public Student findStudentById(@PathVariable("id") String studentId)
	{
		Optional<Student> optionalEntity =  studentRepository.findById(Integer.parseInt(studentId));
		Student student = optionalEntity.get();
		return student;
	}

}
