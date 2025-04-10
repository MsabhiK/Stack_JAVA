package com.codingdojo.oneTOmany.studentRoster1_n.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Course;
import com.codingdojo.oneTOmany.studentRoster1_n.models.Student;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

		List<Course> findAll();
		//Course findByIdIs(Long id);
		List<Course> findAllByStudents(Student student);
		List<Course> findByStudentsNotContains(Student student);
}
