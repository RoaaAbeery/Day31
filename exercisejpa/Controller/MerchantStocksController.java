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
        merchantStockService.addgetMerchantStocks(merchantsStock);
        return ResponseEntity.status(HttpStatus.OK).body("Merchant add");
    }




    @PutMapping("/updateMerchantsStocks/{id}")
    public ResponseEntity updatemerchants(@PathVariable Integer id, @Valid@RequestBody MerchantsStock merchantsStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdate=merchantStockService.updateMerchantStocks(id, merchantsStock);
        if(isupdate){
            return ResponseEntity.status(HttpStatus.OK).body(" Merchants updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant not found");

    }
    @DeleteMapping("/deleteMerchantsStocks/{id}")
    public ResponseEntity deletemerchants(@PathVariable Integer id){

        boolean isdelete=merchantStockService.deleteMerchantStocks(id);
        if(isdelete){
            return ResponseEntity.status(HttpStatus.OK).body(" Merchants deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant not found");

    }
}
