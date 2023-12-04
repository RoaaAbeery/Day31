package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.MerchantsStock;
import com.example.exercisejpa.Repostiry.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    public List<MerchantsStock> getMerchantStocks(){
        return merchantStockRepository.findAll();
    }
    public void addgetMerchantStocks(MerchantsStock merchantsStock){
        merchantStockRepository.save(merchantsStock);
    }
    public Boolean updateMerchantStocks(Integer id,MerchantsStock merchantsStock){
        MerchantsStock old=merchantStockRepository.getById(id);
        if(old==null){
            return false;
        }
        old.setStock(merchantsStock.getStock());
        old.setProductid(merchantsStock.getProductid());
        old.setMerchantid(merchantsStock.getMerchantid());
        merchantStockRepository.save(old);
        return true;
    }
    public Boolean deleteMerchantStocks(Integer id){
        MerchantsStock old=merchantStockRepository.getById(id);
        if(old==null){
            return false;
        }
        merchantStockRepository.delete(old);
        return true;
    }

}
