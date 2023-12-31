package com.prajwal.backendtask.repo;

import com.prajwal.backendtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    // all the CRUD methods

}
