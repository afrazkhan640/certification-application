package com.afraz.certification_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afraz.certification_application.dto.CertificateResponseDto;
import com.afraz.certification_application.dto.CourseRequestDto;
import com.afraz.certification_application.dto.CourseResponseDto;
import com.afraz.certification_application.dto.UserRequestDto;
import com.afraz.certification_application.dto.UserResponseDto;
import com.afraz.certification_application.entity.Certificate;
import com.afraz.certification_application.service.ApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class UserController {

	private final ApplicationService service;
	
	
	 UserController(ApplicationService service) {
		super();
		this.service = service;
	}


	@PostMapping("saveUser")
	public UserResponseDto saveUser(@Valid @RequestBody UserRequestDto dto) {
	
		UserResponseDto response= service.createUser(dto);
		
		return response;
	}
	@PostMapping("saveCourse/{id}")
	public CourseResponseDto saveCourse(@Valid @RequestBody CourseRequestDto dto ,@PathVariable Long id) {
		
		CourseResponseDto response=service.createCourse(dto, id);
		return response;
	}
	
	@PostMapping("start/{id}")
	public CourseResponseDto startCourse(@PathVariable Long id) {
		
	    return service.startCourse(id);
	}
	
	@PostMapping("completeCourse/{id}")
	public CourseResponseDto completeCourse(@PathVariable Long id) {
		
		return service.completeCourse(id);
	}
	
	@PostMapping("generateCertificate/{id}")
	public CertificateResponseDto generateCourseCertificate(@PathVariable Long id) {
		
		return service.generateCertificate(id);
	}
	
}
