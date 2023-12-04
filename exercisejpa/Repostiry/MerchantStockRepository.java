package com.example.exercisejpa.Repostiry;

import com.example.exercisejpa.Model.MerchantsStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStockRepository extends JpaRepository<MerchantsStock,Integer> {

}
