package com.afraz.certification_application.dto;

import com.afraz.certification_application.enums.Status;

public class CourseResponseDto {

	private Long courseId;
	private String title;
	private Status status;
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
