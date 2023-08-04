package com.nimap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Category;
import com.nimap.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryob;

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return categoryob.getAllCategories(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryob.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryob.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category cat) {
    
    	Category existingCat = categoryob.getCategoryById(id);
     
    	if (existingCat != null) {
            cat.setId(id);
            return ResponseEntity.ok(categoryob.updateCategory(cat));
        } else 
            
        	return ResponseEntity.notFound().build();
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
       
    	Category existingCategory = categoryob.getCategoryById(id);
     
        if (existingCategory != null) {
            categoryob.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } 
        else 
            return ResponseEntity.notFound().build();
        
    }
}
