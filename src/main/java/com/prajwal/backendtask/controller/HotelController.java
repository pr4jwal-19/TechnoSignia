package com.prajwal.backendtask.controller;

import com.prajwal.backendtask.exception.ResourceNotFoundException;
import com.prajwal.backendtask.model.Hotel;
import com.prajwal.backendtask.model.Rating;
import com.prajwal.backendtask.repo.HotelRepo;
import com.prajwal.backendtask.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelRepo.findAll();
    }
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelRepo.save(hotel);
    }
    @GetMapping("{id}")
    public ResponseEntity<Hotel> getHotelByID(@PathVariable long id){
        Hotel hotel= hotelRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel doesn't exist by the id: "+id));
        return ResponseEntity.ok(hotel);
    }
    @PutMapping("{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable long id,@RequestBody Hotel hotelDetails){
        Hotel updatedHotel= hotelRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel doesn't exist by the id: "+id));
        updatedHotel.setHotelID(hotelDetails.getHotelID());
        updatedHotel.setHotelName(hotelDetails.getHotelName());
        updatedHotel.setHotelAddress(hotelDetails.getHotelAddress());
        updatedHotel.setContactInfo(hotelDetails.getContactInfo());
        updatedHotel.setNoOfRooms(hotelDetails.getNoOfRooms());
        updatedHotel.setAmenities(hotelDetails.getAmenities());
        updatedHotel.setRating(hotelDetails.getRating());
        hotelRepo.save(updatedHotel);
        return ResponseEntity.ok(updatedHotel);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteHotel(@PathVariable long id){
        Hotel deletedHotel= hotelRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel doesn't exist by the id: "+id));
        hotelRepo.delete(deletedHotel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{hotelID}/ratings")
    public List<Rating> getRatingsForHotel(@PathVariable long hotelID){
        Optional<Hotel> hotelOptional=hotelRepo.findById(hotelID);
        if (hotelOptional.isPresent()){
            Hotel hotelRating=hotelOptional.get();
            return ratingRepo.findByHotel(hotelRating);
        }else {
            throw new ResourceNotFoundException("Hotel not found with id: "+hotelID);
        }
    }
}
