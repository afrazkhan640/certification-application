package com.afraz.certification_application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CourseRequestDto {

	@NotNull(message= "User Id is Required")
	private Long userId;
	@NotBlank(message= "Course title cannot be empty")
	private String title;
	

	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
