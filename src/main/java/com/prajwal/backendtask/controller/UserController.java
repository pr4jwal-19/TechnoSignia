package com.prajwal.backendtask.controller;

import com.prajwal.backendtask.exception.ResourceNotFoundException;
import com.prajwal.backendtask.model.User;
import com.prajwal.backendtask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }
    //get user by ID
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByID(@PathVariable long id){
        User user= userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User doesn't exist by the id: "+id));
        return ResponseEntity.ok(user);
    }

    // update user by ID
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userDetails){
        User updateUser= userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User doesn't exist by the id: "+id));
        updateUser.setUserID(userDetails.getUserID());
        updateUser.setUserName(userDetails.getUserName());
        updateUser.setEmailID(userDetails.getEmailID());
        updateUser.setMobNum(userDetails.getMobNum());
        updateUser.setAddress(userDetails.getAddress());
        updateUser.setRole(userDetails.getRole());
        userRepo.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        User deletedUser= userRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("User doesn't exist by the id: "+id));
        userRepo.delete(deletedUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}