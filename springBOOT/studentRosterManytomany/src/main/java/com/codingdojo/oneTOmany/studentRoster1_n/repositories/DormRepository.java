package com.codingdojo.oneTOmany.studentRoster1_n.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.oneTOmany.studentRoster1_n.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
	List<Dorm> findAll();
}
