package com.codingdojo.manyTOmany.productAndCategory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.manyTOmany.productAndCategory.models.Category;
import com.codingdojo.manyTOmany.productAndCategory.models.Product;
import com.codingdojo.manyTOmany.productAndCategory.services.CategoryService;
import com.codingdojo.manyTOmany.productAndCategory.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products=productService.allProducts();
		List<Category> categories=categoryService.allCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	 public String productNew(@ModelAttribute("product") Product product) {
	    	
	    	return "addProduct.jsp";
	    }
	    
	@PostMapping("/products/new")
	public String createP(@Valid @ModelAttribute("product") Product product, BindingResult result) {

	    	if (result.hasErrors()) {
	    		return "addProduct.jsp";
	    	}
	    	
	    	productService.createProduct(product);
	    	
	    	return "redirect:/";
	    }
	    
	@GetMapping("/categories/new")
	public String categoryNew(@ModelAttribute("category") Category category) {
		    	
		    	return "addCategory.jsp";
		    }
		    
	@PostMapping("/categories/new")
	public String createC(@Valid @ModelAttribute("category") Category category, BindingResult result) {

		    	if (result.hasErrors()) {
		    		return "addCategory.jsp";
		    	}
		    	
		    	categoryService.createCategory(category);
		    	
		    	return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", productService.classificationProducts(category));
		model.addAttribute("unassignedProducts", productService.notAssignedProducts(category));
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		Category category = categoryService.findCategory(id);
		Product product = productService.findProduct(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		return "redirect:/categories/"+id;
	}
	
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categoriesByProduct", categoryService.categoriesByProduct(product));
		model.addAttribute("notAssignedCategories", categoryService.notAssignedCategories(product));
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
		Product product = productService.findProduct(id);
		Category category = categoryService.findCategory(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		return "redirect:/products/"+id;
	}

}
