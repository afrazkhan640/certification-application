package com.afraz.certification_application.dto;


public class CourseRequestDto {

	private Long userId;
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
