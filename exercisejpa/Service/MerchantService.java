package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Repostiry.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final  MerchantRepository merchantRepository;
    public List<Merchant> getMerchants(){
        return merchantRepository.findAll();
    }
    public void addMerchants(Merchant merchant){
        merchantRepository.save(merchant);
    }
    public Boolean updateMerchants(Integer id,Merchant merchant){
        Merchant oldCMerchant=merchantRepository.getById(id);
        if(oldCMerchant==null){
            return false;
        }
        oldCMerchant.setName(merchant.getName());

        return true;
    }
    public  Boolean deleteMerchants(Integer id){
  Merchant oldmerchant=merchantRepository.getById(id);
  if(oldmerchant==null){
      return false;
  }
  merchantRepository.delete(oldmerchant);
  return true;
}}

