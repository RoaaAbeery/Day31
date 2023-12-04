package com.example.exercisejpa.Repostiry;

import com.example.exercisejpa.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

}
