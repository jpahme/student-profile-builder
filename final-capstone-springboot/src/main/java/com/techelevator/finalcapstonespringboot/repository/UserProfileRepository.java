package com.techelevator.finalcapstonespringboot.repository;

import com.techelevator.finalcapstonespringboot.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByUserId(Long id);
    UserProfile findByUsername(String username);
}

