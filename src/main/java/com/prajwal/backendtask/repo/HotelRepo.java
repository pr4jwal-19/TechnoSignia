package com.prajwal.backendtask.repo;

import com.prajwal.backendtask.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Long> {

}
