package com.codingdojo.oneTOmany.dojosANDninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.oneTOmany.dojosANDninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Integer> {
	
	List<Dojo> findAll();

}
