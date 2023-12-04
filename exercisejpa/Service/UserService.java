package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Repostiry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getusers(){
        return userRepository.findAll();
    }
    public void addusers(User user){
        userRepository.save(user);
    }
    public Boolean updateUser(Integer id,User user){
        User oldUser=userRepository.getById(id);
        if(oldUser==null){
            return false;
        }
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getEmail());
        oldUser.setBalance(user.getBalance());
        userRepository.save(oldUser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User oldUser=userRepository.getById(id);
        if(oldUser==null){
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }

}
