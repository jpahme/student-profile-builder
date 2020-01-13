package com.techelevator.finalcapstonespringboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.techelevator.finalcapstonespringboot.model.Project;
import com.techelevator.finalcapstonespringboot.model.UserProfile;
import com.techelevator.finalcapstonespringboot.repository.ProjectRepository;
import com.techelevator.finalcapstonespringboot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin
@RestController
public class ProjectController {
    
    @Autowired
    UserProfileRepository userProfRep;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @PostMapping("/addproject/{username}")
    public Project saveProjectByUsername(@PathVariable String username, @RequestBody Project project) {
        UserProfile userProfile = userProfRep.findByUsername(username);
        System.out.println("***** ERRORS ****** ERRORS ********s");
        if (userProfile != null) {
            project.setUserProfile(userProfile);
            System.out.println(project.getName());
            System.out.println(project.getStartDate());
            return projectRepository.save(project);
        } else
            return null;
    }
    
    @GetMapping("/getprojects/{username}")
    public Set<Project> findProjectsByUsername(@PathVariable String username) {
        Set<Project> projects = new HashSet<>();
        for (Project project : projectRepository.findAll()) {
            if (project.getUserProfile() != null)
                if (username.equals(project.getUserProfile().getUsername()))
                    projects.add(project);
        }
        return projects;
    }
}
