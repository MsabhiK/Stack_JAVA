package com.codingdojo.oneTOmany.dojosANDninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.oneTOmany.dojosANDninjas.models.Dojo;
import com.codingdojo.oneTOmany.dojosANDninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	public final DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	//1 Read All
		public List<Dojo> allDojos(){
			return dojoRepository.findAll();
		}
		
		//2 Create
		public Dojo createDojo(Dojo dojo) {
			return dojoRepository.save(dojo);
		}
		
		//3 Read one by Id
		public Dojo findDojo(Integer id) {
			Optional<Dojo> optionalDojo = dojoRepository.findById(id);
			if(optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
		}
		
		//4  Update 
		public Dojo updateDojo(Dojo dojo) {
			return dojoRepository.save(dojo);
		}
		
		//5 Delete by Id
		public void deleteDojo(Integer id) {
			dojoRepository.deleteById(id);
		}

}
