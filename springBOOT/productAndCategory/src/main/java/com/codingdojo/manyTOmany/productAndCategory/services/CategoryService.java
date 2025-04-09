package com.codingdojo.manyTOmany.productAndCategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.manyTOmany.productAndCategory.models.Category;
import com.codingdojo.manyTOmany.productAndCategory.models.Product;
import com.codingdojo.manyTOmany.productAndCategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// returns all the category
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
    // creates a Category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    // retrieves a Category
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    //list all of Categories by one user
    /*
    public List<Category> userCategories(Long userId) {
		return categoryRepository.findByUserIdIs(userId);
	}*/
    
    public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void removeCategory(Category category) {
		categoryRepository.delete(category);
	}
	
	public List<Category> categoriesByProduct(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> notAssignedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
}
