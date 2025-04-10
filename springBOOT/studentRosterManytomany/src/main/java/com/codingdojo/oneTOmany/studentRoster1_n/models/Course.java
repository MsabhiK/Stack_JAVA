package com.codingdojo.oneTOmany.studentRoster1_n.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(min = 3, max = 30, message="Name of Course must be at least 3 and max 30 characters.")
	private String nameCourse;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "courses_students", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
	
	public Course() {}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameCourse() {
		return nameCourse;
	}


	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	    }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	    }
}
