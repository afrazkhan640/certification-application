package com.afraz.certification_application.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.afraz.certification_application.dto.CertificateResponseDto;
import com.afraz.certification_application.dto.CourseRequestDto;
import com.afraz.certification_application.dto.CourseResponseDto;
import com.afraz.certification_application.dto.UserRequestDto;
import com.afraz.certification_application.dto.UserResponseDto;
import com.afraz.certification_application.entity.Certificate;
import com.afraz.certification_application.entity.Course;
import com.afraz.certification_application.entity.User;
import com.afraz.certification_application.enums.Status;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private Map<Long ,User> userMap=new HashMap<>();
	private Map<Long,Course> courseMap=new HashMap<>();
	private Map<Long,Certificate> certificateMap=new HashMap<>();
	
	private long userCounter=1;
	private long courseCounter=1;
	private long certificateCounter=1000;
	
	@Override
	public UserResponseDto createUser(UserRequestDto dto) {
	
		User user=new User();
		
		user.setUserId(userCounter++);
		user.setName(dto.getName());
		user.setCourse(new ArrayList<>());
		
		userMap.put(user.getUserId(), user);
		
		UserResponseDto userResponse =new UserResponseDto();
		userResponse.setUserId(user.getUserId());;
		userResponse.setName(dto.getName());
		
		return userResponse;
	}

	@Override
	public CourseResponseDto createCourse(CourseRequestDto dto, Long userId) {
		
		System.out.println(userMap);
		User user=userMap.get(userId);
		
		if(user==null) {
			throw new RuntimeException(
					"No user Found with this id: "+dto.getUserId());
		}
		
		Course course=new Course();
		course.setCourseId(courseCounter++);
		course.setTitle(dto.getTitle());
		course.setStatus(Status.CREATED);
		
		course.setUser(user);
		user.getCourse().add(course);
		
		courseMap.put(course.getCourseId(), course);
		
		CourseResponseDto response=new CourseResponseDto();
		response.setCourseId(course.getCourseId());
		response.setTitle(course.getTitle());
		response.setStatus(course.getStatus());
				
		return response;
	}

	@Override
	public CourseResponseDto startCourse(Long courseId) {
		
		Course course=courseMap.get(courseId);
		
		if(course==null) {
		  throw new RuntimeException(
					"No Course found with id: "+courseId);
		}
		
		if(course.getStatus()!=Status.CREATED) {
			throw new RuntimeException(
					"Course cannot be started, Current status "+course.getStatus());
		}
		
		course.setStatus(Status.STARTED);
		
		CourseResponseDto response=new CourseResponseDto();
		
		response.setCourseId(course.getCourseId());
		response.setTitle(course.getTitle());
		response.setStatus(course.getStatus());
		
		return response;
	}
	
	@Override
	public CourseResponseDto completeCourse(Long courseId) {
		
		Course course= courseMap.get(courseId);
		if(course==null)
			throw new RuntimeException("No course Found with id: "+courseId);
		
		if(course.getStatus()!=Status.STARTED)
			throw new RuntimeException("Course not completed , current status: "+course.getStatus());
		
		course.setStatus(Status.COMPLETED);
		
		CourseResponseDto response=new CourseResponseDto();
		response.setCourseId(course.getCourseId());
		response.setTitle(course.getTitle());
		response.setStatus(course.getStatus());
		
		return response;
	}

	@Override
	public CertificateResponseDto generateCertificate(Long courseId) {
		
		Course course=courseMap.get(courseId);
		
		if(course==null)
			throw new RuntimeException("No course Found With this id: "+courseId);
		
		if(course.getStatus()!=Status.COMPLETED)
			throw new RuntimeException("Course Not Completed yet , Current Status: "+course.getStatus());
		
		if(certificateMap.containsKey(courseId))
			throw new RuntimeException("Certificate Already exist with Course: "+courseId);
		
		Certificate certificate=new Certificate();
		certificate.setCertificateId(certificateCounter++);
		certificate.setCourse(course);
		certificate.setIssueDate(LocalDate.now());
		
		certificateMap.put(courseId, certificate);
		
		CertificateResponseDto response=new CertificateResponseDto();
		response.setCertificateId(certificate.getCertificateId());
		response.setCourseTitle(course.getTitle());
		response.setCourseId(course.getCourseId());
		response.setUserName(course.getUser().getName());
		response.setIssueDate(certificate.getIssueDate());
		
		return response;
	}
	
}
