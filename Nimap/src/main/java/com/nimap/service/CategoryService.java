package com.nimap.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nimap.model.Category;
import com.nimap.repository.CategoryRepository;

@Service
public class CategoryService {
	
    @Autowired
    private CategoryRepository categoryinterface;
    
    public void deleteCategory(Long id) {
    	categoryinterface.deleteById(id);
    }
    
    public List<Category> getAllCategories(int page, int size) {
    	
    	
        Pageable pageableobj = PageRequest.of(page, size);
        
        Page<Category> categoryPageobj = categoryinterface.findAll(pageableobj);
        
        return categoryPageobj.getContent();
    }

    public List<Category> getAllCategories() {
      
    	return categoryinterface.findAll();
    }

    public Category getCategoryById(Long id) {
       
    	return categoryinterface.findById(id).orElse(null);
    }

  

    public Category updateCategory(Category cat) {
       
    	return categoryinterface.save(cat);
    }

   
    public Category createCategory(Category cat) {
      
    	return categoryinterface.save(cat);
    }
}


