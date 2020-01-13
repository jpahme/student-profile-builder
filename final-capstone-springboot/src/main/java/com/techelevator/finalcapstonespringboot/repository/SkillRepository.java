package com.techelevator.finalcapstonespringboot.repository;

import com.techelevator.finalcapstonespringboot.model.Skill;
import com.techelevator.finalcapstonespringboot.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    //List<Skill> findByUsername(String username);
    List<Skill> findByName(String name);
}
