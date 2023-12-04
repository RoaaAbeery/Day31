package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }
    @PostMapping("/addProducts")
    public ResponseEntity addProducts(@Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        productService.addProducts(product);

            return ResponseEntity.status(HttpStatus.OK).body("product add");
    }
    @PutMapping("/updateProducts/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        Boolean isupdate=productService.updateProduct(id, product);
        if(isupdate){
            return ResponseEntity.status(HttpStatus.OK).body("product updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product Not found");
    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        boolean isDelete= productService.deleteProduct(id);
        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body("product Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product not found");
    }

}
