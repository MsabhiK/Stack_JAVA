package com.codingdojo.oneTOmany.dojosANDninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.oneTOmany.dojosANDninjas.models.Dojo;
import com.codingdojo.oneTOmany.dojosANDninjas.models.Ninja;
import com.codingdojo.oneTOmany.dojosANDninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	public final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}

	//1 Read All
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	//2 Create
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//3 Read one by Id
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> byDojo(Dojo dojo) {
    	return ninjaRepository.findAllByDojo(dojo);
    }
	
	//4  Update 
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//5 Delete by Id
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

}
