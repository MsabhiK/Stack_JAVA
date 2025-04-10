package com.codingdojo.oneTOmany.studentRoster1_n.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();
	List<Student> findByDormIdIs(Long dormId);
}