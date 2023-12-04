package com.example.exercisejpa.Repostiry;

import com.example.exercisejpa.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategory extends JpaRepository<Category,Integer> {
}
