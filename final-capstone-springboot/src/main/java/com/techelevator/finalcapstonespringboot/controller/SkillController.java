package com.techelevator.finalcapstonespringboot.controller;

import com.techelevator.finalcapstonespringboot.model.Skill;
import com.techelevator.finalcapstonespringboot.model.UserProfile;
import com.techelevator.finalcapstonespringboot.repository.SkillRepository;
import com.techelevator.finalcapstonespringboot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class SkillController {
    
    @Autowired
    UserProfileRepository userProfRep;
    
    @Autowired
    SkillRepository skillRepository;
    
    @PostMapping("/addskill/{username}")
    public Skill addSkillByUsername(@PathVariable String username, @RequestBody Skill skill) {
        UserProfile userProfile = userProfRep.findByUsername(username);
        skill.setUserProfile(userProfile);
        return skillRepository.save(skill);
    }
    
    @GetMapping("/getskill/{name}")
    public List<Skill> getSkillsByUsername(@PathVariable String name) {
        return skillRepository.findByName(name);
    }
    
    @GetMapping("/finduser/{skillName}")
    public Set<UserProfile> findUserProfileBySkillName(@PathVariable String skillName) {
        Set<UserProfile> profiles = new HashSet<>();
        List<Skill>      skills   = skillRepository.findByName(skillName);
        
        for (Skill skill : skills) {
            //if (skillName.equalsIgnoreCase(skill.getName()))
            profiles.add(skill.getUserProfile());
            System.out.println(skill.getUserProfile());
        }
        return profiles;
        //return profiles.toArray(new UserProfile[profiles.size()]);
        
    }
}
