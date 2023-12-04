package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api1/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getusers());
    }
    @PostMapping("/addUsers")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addusers(user);
        return ResponseEntity.status(HttpStatus.OK).body("user add");
    }
    @PutMapping("/updateUsers/{id}")
    public ResponseEntity updateUserss(@PathVariable Integer id,@Valid@RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=userService.updateUser(id, user);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("User updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }
    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity delteUsers(@PathVariable Integer id){
        boolean isDeleted=userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("User deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }
}
