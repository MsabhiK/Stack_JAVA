package com.codingdojo.saveTRavel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.saveTRavel.models.Depense;
import com.codingdojo.saveTRavel.repositories.DepenseRepository;

@Service
public class DepenseService {
	
	public final DepenseRepository depenseRepository;
	
	public DepenseService(DepenseRepository depenseRepository) {
		this.depenseRepository = depenseRepository; 
	}
	
	//1 Read All
	public List<Depense> allDepenses(){
		return depenseRepository.findAll();
	}
	
	//2 Create
	public Depense createDepense(Depense depense) {
		return depenseRepository.save(depense);
	}
	
	//3 Read one by Id
	public Depense findDepense(Long id) {
		Optional<Depense> optionalDepense = depenseRepository.findById(id);
		if(optionalDepense.isPresent()) {
			return optionalDepense.get();
		} else {
			return null;
		}
	}
	
	//4  Update 
	public Depense updateDepense(Depense depense) {
		return depenseRepository.save(depense);
	}
	
	//5 Delete by Id
	public void deleteDepense(Long id) {
		depenseRepository.deleteById(id);
	}

}
