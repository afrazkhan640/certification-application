package com.afraz.certification_application.service;

import com.afraz.certification_application.dto.CertificateResponseDto;
import com.afraz.certification_application.dto.CourseRequestDto;
import com.afraz.certification_application.dto.CourseResponseDto;
import com.afraz.certification_application.dto.UserRequestDto;
import com.afraz.certification_application.dto.UserResponseDto;
import com.afraz.certification_application.entity.Certificate;

public interface ApplicationService {

	UserResponseDto createUser(UserRequestDto dto);
	CourseResponseDto createCourse(CourseRequestDto dto, Long UserId);
	CourseResponseDto startCourse(Long id);
	CourseResponseDto completeCourse(Long id);
	CertificateResponseDto generateCertificate(Long courseId);
}
