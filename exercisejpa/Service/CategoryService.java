package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Repostiry.RepositoryCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final RepositoryCategory repositoryCategory;
   public List<Category> getCategories(){
       return repositoryCategory.findAll();
   }
   public void addCategories(Category category){
       repositoryCategory.save(category);
   }
   public Boolean updatCategories(Integer id,Category category){
       Category oldCategories=repositoryCategory.getById(id);
       if (oldCategories==null){
           return false;
       }
       oldCategories.setName(category.getName());
       repositoryCategory.save(oldCategories);
       return true;
   }
   public Boolean deleteCategories(Integer id){
       Category oldCategories=repositoryCategory.getById(id);
       if (oldCategories==null){
           return false;
       }
       repositoryCategory.delete(oldCategories);
       return true;
   }
}
