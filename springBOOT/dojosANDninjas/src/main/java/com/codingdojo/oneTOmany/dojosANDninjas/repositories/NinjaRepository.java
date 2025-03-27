package com.codingdojo.oneTOmany.dojosANDninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.oneTOmany.dojosANDninjas.models.Dojo;
import com.codingdojo.oneTOmany.dojosANDninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}
