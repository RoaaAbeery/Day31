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
private final ProductService productService;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Boolean addProducts( Product product){
        for (int i = 0; i < categoryService.getCategories().size(); i++) {
            if(categoryService.getCategories().get(i).equals(product.getCategoryID())){
                productRepository.save(product);
                return true;
            }
        }
      return false;
    }
    public Boolean updateProduct (Integer id ,Product product){
        for (int i = 0; i <getProducts().size() ; i++) {
            if (getProducts().get(i).getId().equals(id)) {
                for (int j = 0; j < categoryService.getCategories().size(); j++) {
                    if (categoryService.getCategories().get(j).equals(product.getCategoryID())) {
                        Product oldProduct = productRepository.getById(id);
                        oldProduct.setCategoryID(product.getCategoryID());
                        oldProduct.setPrice(product.getPrice());
                        oldProduct.setName(product.getName());
                        oldProduct.setDiscounts(product.getDiscounts());
                        productRepository.save(oldProduct);
                        return true;
                    }
                }
            }
        }
     return false;
    }

    public Boolean deleteProduct(Integer id){
        Product delete=productRepository.getById(id);
        if(delete==null){
            return false;
        }
        productRepository.delete(delete);
        return true;
    }}

