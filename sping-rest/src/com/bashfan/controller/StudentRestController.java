package com.bashfan.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bashfan.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void addStudents() {
		students=new ArrayList<>();
		students.add(new Student("j","j"));
		students.add(new Student("a","a"));
		students.add(new Student("b","b"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) throws Exception {
		if (studentId>students.size()) {
			
		}
		return students.get(studentId);
	}
}
