package com.techelevator.finalcapstonespringboot.repository;

import com.techelevator.finalcapstonespringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
