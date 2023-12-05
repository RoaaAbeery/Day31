package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Model.MerchantsStock;
import com.example.exercisejpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/MerchantStocks")
public class MerchantStocksController {
    private final MerchantStockService merchantStockService;
    @GetMapping("/getMerchantsStocks")
    public ResponseEntity getMerchants(){

        return ResponseEntity.status(HttpStatus.OK).body(merchantStockService.getMerchantStocks());
    }
    @PostMapping("/addMerchantsStocks")
    public ResponseEntity addMerchants (@Valid @RequestBody MerchantsStock merchantsStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
       int add= merchantStockService.addgetMerchantStocks(merchantsStock);
        switch (add){
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Merchant id must be equal");
            case 2:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product id must be equal");
            default:
                return ResponseEntity.status(HttpStatus.OK).body("Merchant Stocks add");
        }
    }

    @PutMapping("/updateMerchantsStocks/{id}")
    public ResponseEntity updatemerchants(@PathVariable Integer id, @Valid@RequestBody MerchantsStock merchantsStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        Integer isupdate=merchantStockService.updateMerchantStocks(id, merchantsStock);
        switch (isupdate){
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock id must be equal");
            case 2:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant id must be equal");
            case 3:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product id must be equal");

            default:
                return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }

    }
    @DeleteMapping("/deleteMerchantsStocks/{id}")
    public ResponseEntity deletemerchants(@PathVariable Integer id){

        boolean isdelete=merchantStockService.deleteMerchantStocks(id);
        if(isdelete){
            return ResponseEntity.status(HttpStatus.OK).body(" Merchants deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant not found");

    }
    @PutMapping("/addStock/{productid}/{merchantid}/{amount}")
    public ResponseEntity addStock(@PathVariable Integer productid ,@PathVariable Integer
            merchantid ,@PathVariable int amount){
        int isadd=merchantStockService.addstock(productid, merchantid, amount);
        switch (isadd){
            case 0:
                return ResponseEntity.status(HttpStatus.OK).body("Stock has been increased");
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant id must be equal");
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product id must be equal");


        }
    }

    @PutMapping("/buy/{userid}/{productid}/{merchantid}")
    public ResponseEntity buy(@PathVariable Integer userid,@PathVariable Integer productid ,@PathVariable Integer merchantid ){
        int isadd=merchantStockService.buy1(userid, productid, merchantid);
        switch (isadd){
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("buy done");
            case 2:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock id must be equal");
            case 3:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant id must be equal");
            case 4:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product id must be equal");
            case 5:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user id must be equal");
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("balance not enough");


        }
    }
}
