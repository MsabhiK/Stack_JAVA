package com.codingdojo.manyTOmany.productAndCategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.manyTOmany.productAndCategory.models.Category;
import com.codingdojo.manyTOmany.productAndCategory.models.Product;
import com.codingdojo.manyTOmany.productAndCategory.repositories.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	// returns all the products
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    // creates a book
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    //list all of books by one user
    /*
    public List<Product> userProducts(Long userId) {
		return productRepository.findByUserIdIs(userId);
	}*/
    
    public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void removeProduct(Product product) {
		productRepository.delete(product);
	}
    
    public List<Product> classificationProducts(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> notAssignedProducts(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
}


