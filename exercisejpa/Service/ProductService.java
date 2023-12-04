package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Repostiry.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
private final CategoryService categoryService;
private final ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public void addProducts( Product product){
       productRepository.save(product);
    }
    public Boolean updateProduct (Integer id ,Product product){
       Product oldProduct=productRepository.getById(id);
       if(oldProduct==null){
           return false;
       }
       oldProduct.setCategoryID(product.getCategoryID());
       oldProduct.setPrice(product.getPrice());
       oldProduct.setName(product.getName());
       oldProduct.setDiscounts(product.getDiscounts());
       productRepository.save(oldProduct);
       return true;
    }

    public Boolean deleteProduct(Integer id){
        Product delete=productRepository.getById(id);
        if(delete==null){
            return false;
        }
        productRepository.delete(delete);
        return true;
    }}

