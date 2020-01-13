package com.techelevator.finalcapstonespringboot.repository;

import com.techelevator.finalcapstonespringboot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
