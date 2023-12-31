package com.prajwal.backendtask.controller;

import com.prajwal.backendtask.exception.ResourceNotFoundException;
import com.prajwal.backendtask.model.Rating;
import com.prajwal.backendtask.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingRepo.findAll();
    }
    @PostMapping
    public Rating createRating(@RequestBody Rating rating){
        return ratingRepo.save(rating);
    }
    @GetMapping("{id}")
    public ResponseEntity<Rating> getRatingByID(@PathVariable long id){
        Rating rating= ratingRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Rating doesn't exist by the id: "+id));
        return ResponseEntity.ok(rating);
    }
    @PutMapping("{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable long id,@RequestBody Rating ratingDetails){
        Rating updatedRating = ratingRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Rating doesn't exist by the id: "+id));
        updatedRating.setRatingID(ratingDetails.getRatingID());
        updatedRating.setUser(ratingDetails.getUser());
        updatedRating.setHotel(ratingDetails.getHotel());
        updatedRating.setRatingValue(ratingDetails.getRatingValue());
        updatedRating.setComments(ratingDetails.getComments());
        updatedRating.setDate(ratingDetails.getDate());
        ratingRepo.save(updatedRating);
        return ResponseEntity.ok(updatedRating);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable long id){
        Rating deletedRating= ratingRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Rating doesn't exist by the id: "+id));
        ratingRepo.delete(deletedRating);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
