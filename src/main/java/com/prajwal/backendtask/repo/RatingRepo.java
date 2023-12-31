package com.prajwal.backendtask.repo;

import com.prajwal.backendtask.model.Hotel;
import com.prajwal.backendtask.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,Long> {

    List<Rating> findByHotel(Hotel hotelID);
}
