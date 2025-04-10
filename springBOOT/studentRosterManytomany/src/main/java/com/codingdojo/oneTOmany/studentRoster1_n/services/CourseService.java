package com.codingdojo.oneTOmany.studentRoster1_n.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Course;
import com.codingdojo.oneTOmany.studentRoster1_n.models.Student;
import com.codingdojo.oneTOmany.studentRoster1_n.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> allCourses(){
		return courseRepository.findAll();
	}
	
	public List<Course> getAssignedCourses(Student student){
		return courseRepository.findAllByStudents(student);
	}
	
	public List<Course> getNotAssignedCourse(Student student){
		return courseRepository.findByStudentsNotContains(student);
	}
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public void removeFromStudent(Course course) {
		course.setStudents(null);
		courseRepository.save(course);
	}
	
	public Course findCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		}else {
			return null;
		}
	}
	
	public void dropCourse(Course course, Student student) {
		course.getStudents().remove(student);
		courseRepository.save(course);
	}

}
