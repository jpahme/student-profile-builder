package com.techelevator.finalcapstonespringboot.controller;


import com.techelevator.finalcapstonespringboot.model.User;
import com.techelevator.finalcapstonespringboot.model.UserProfile;
import com.techelevator.finalcapstonespringboot.repository.UserProfileRepository;
import com.techelevator.finalcapstonespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserProfileController {
    
    @Autowired
    UserRepository userRep;
    
    @Autowired
    UserProfileRepository userProfRep;
    
    @PostMapping(path = "/addprofile", produces = "application/json")
    public UserProfile addUserProfile(@RequestBody UserProfile userProfile) {
        User user = userRep.findByUsername(userProfile.getUsername());

        UserProfile existingProfile = userProfRep.findByUsername(userProfile.getUsername());
        if (existingProfile == null) {
            existingProfile = new UserProfile();
            user.setUserProfile(existingProfile);
            existingProfile.setUser(user);
        }
        existingProfile.setAllFields(userProfile);

        return userProfRep.save(existingProfile);
    }
    
    @GetMapping(path = "/getprofile", produces = "application/json")
    public UserProfile getProfileByUsername(@RequestParam String username) {
        UserProfile userProfile = userProfRep.findByUsername(username);
//        System.out.println("user: " + username);
//        System.out.println(userProfile);
        return userProfile;
    }
}
