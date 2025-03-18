package com.codingdojo.burgerTracker1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgerTracker1.models.Burger;
import com.codingdojo.burgerTracker1.repositories.BurgerRepository;


@Service
public class BurgerService {

	// adding the burger repository as a dependency
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    // returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a burger
    public Burger createBurger(Burger burg) {
        return burgerRepository.save(burg);
    }
    // retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    
 // update a burger
    public Burger updateBurger(Burger burg) {
        return burgerRepository.save(burg);
    }
    
    // delete a book by ID
    public void deleteBurger(Long id) {
    	burgerRepository.deleteById(id);
    }
}
