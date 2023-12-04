package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/getCategories")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories());
    }
    @PostMapping("/addCategories")
    public ResponseEntity addCategories(@RequestBody@Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(HttpStatus.OK).body("category add");

    }
    @PutMapping("/updateCategories/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@RequestBody@Valid Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        Boolean isUpdate=categoryService.updatCategories(id, category);
        if(isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body("Category Updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
    @DeleteMapping("/deleteCategories/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        Boolean isdeleted=categoryService.deleteCategories(id);
        if(isdeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
}
