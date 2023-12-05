package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.MerchantsStock;
import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Repostiry.MerchantRepository;
import com.example.exercisejpa.Repostiry.MerchantStockRepository;
import com.example.exercisejpa.Repostiry.ProductRepository;
import com.example.exercisejpa.Repostiry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    private final ProductService productService;
    private final MerchantService merchantService;
    private final UserService userService;
    private final UserRepository userRepository;
    public List<MerchantsStock> getMerchantStocks(){
        return merchantStockRepository.findAll();
    }
    public int addgetMerchantStocks(MerchantsStock merchantsStock){
        for (int i = 0; i < productService.getProducts().size(); i++) {
            if(productService.getProducts().get(i).getId().equals(merchantsStock.getProductid())){
                for (int j = 0; j < merchantService.getMerchants().size(); j++) {
                    if(merchantService.getMerchants().get(j).getId().equals(merchantsStock.getMerchantid())){
                        merchantStockRepository.save(merchantsStock);
                        return 0;
                    }

                }return 1;//mid
            }

        } return 2;//pid

    }
    public Integer updateMerchantStocks(Integer id,MerchantsStock merchantsStock){
        for (int i = 0; i < productService.getProducts().size(); i++) {
            if(productService.getProducts().get(i).equals(merchantsStock.getProductid())){
                for (int j = 0; j < merchantService.getMerchants().size(); j++) {
                    if(merchantService.getMerchants().get(j).equals(merchantsStock.getMerchantid())){
                        for (int k = 0; k < getMerchantStocks().size(); k++) {
                            if(getMerchantStocks().get(k).getId().equals(id)){
                                MerchantsStock old=merchantStockRepository.getById(id);
                                old.setStock(merchantsStock.getStock());
                                old.setProductid(merchantsStock.getProductid());
                                 old.setMerchantid(merchantsStock.getMerchantid());
                                 merchantStockRepository.save(old);
                                      return 0;
                            }

                        } return 1;//m
                    }

                }return 2;//mid
            }

        }return 3;//p

    }
    public Boolean deleteMerchantStocks(Integer id){
        MerchantsStock old=merchantStockRepository.getById(id);
        if(old==null){
            return false;
        }
        merchantStockRepository.delete(old);
        return true;
    }
    public Integer addstock(Integer productid ,Integer merchantid , Integer amount) {
        for (int j = 0; j < productService.getProducts().size(); j++) {
            if (productService.getProducts().get(j).getId().equals(productid)) {
                for (int k = 0; k < merchantService.getMerchants().size(); k++) {
                    if (merchantService.getMerchants().get(k).getId().equals(merchantid)) {
                        for (int i = 0; i < getMerchantStocks().size(); i++) {
                            MerchantsStock old=merchantStockRepository.getById(productid);
                         old.setStock(getMerchantStocks().get(i).getStock() + amount);
                            merchantStockRepository.save(old);
                        }return 0;
                    }
                }return 1;//m
            }
        }return 2;//p
    }
    public int buy1(Integer userid,Integer productid,Integer merchantid) {
        for (int i = 0; i <userService.getusers().size(); i++) {
            if (userService.getusers().get(i).getId().equals(userid)) {
                for (int j = 0; j < productService.getProducts().size(); j++) {
                    if (productService.getProducts().get(j).getId().equals(productid)) {
                        for (int k = 0; k < merchantService.getMerchants().size(); k++) {
                            if (merchantService.getMerchants().get(k).getId().equals(merchantid)) {
                                for (int l = 0; l < getMerchantStocks().size(); l++) {
                                    if(getMerchantStocks().get(i).getStock()>0){
                                        getMerchantStocks().get(i).setStock(getMerchantStocks().get(i).getStock()-1);
                                        if(userService.getusers().get(i).getBalance()<productService.getProducts().get(j).getPrice()){
                                            return 0;
                                        }// balan
                                        User old=userRepository.getById(userid);
                                         old.setBalance(userService.getusers().get(j).getBalance()-productService.getProducts().get(i).getPrice());
                                        userRepository.save(old);

                                        return 1;//good
                                    }


                                }return 2;//sid

                            } return 3;//mid

                        }return 4;//pid

                    }

                }
            }

        }return 5;//uid
    }
}
