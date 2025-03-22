package com.codingdojo.saveTRavel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saveTRavel.models.Depense;

@Repository
public interface DepenseRepository extends CrudRepository<Depense, Long> {
	
	// this method retrieves all the books from the database
    List<Depense> findAll();

}
