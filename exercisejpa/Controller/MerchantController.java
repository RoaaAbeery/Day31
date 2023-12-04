package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/getMerchants")
    public ResponseEntity getMerchants(){

        return ResponseEntity.status(HttpStatus.OK).body(merchantService.getMerchants());
    }
    @PostMapping("/addMerchants")
    public ResponseEntity addMerchants (@Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        merchantService.addMerchants(merchant);
        return ResponseEntity.status(HttpStatus.OK).body("Merchant add");
    }




    @PutMapping("/updatemerchant/{id}")
    public ResponseEntity updatemerchants(@PathVariable Integer id, @Valid@RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdate=merchantService.updateMerchants(id, merchant);
        if(isupdate){
            return ResponseEntity.status(HttpStatus.OK).body(" Merchants updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant not found");

    }
    @DeleteMapping("/deletemerchants/{id}")
    public ResponseEntity deletemerchants(@PathVariable Integer id){

        boolean isdelete=merchantService.deleteMerchants(id);
        if(isdelete){
            return ResponseEntity.status(HttpStatus.OK).body(" Merchants deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("merchant not found");

    }
}
