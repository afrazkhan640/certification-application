package com.afraz.certification_application.entity;

import java.time.LocalDate;

public class Certificate {

	private long certificateId;
	
	private Course course;
	
	private LocalDate issueDate;

	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
		this.certificateId = certificateId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	
	
	
}
