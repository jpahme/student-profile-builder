package com.techelevator.finalcapstonespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date endDate;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private UserProfile userProfile;
    
    public Long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public UserProfile getUserProfile() {
        return userProfile;
    }
    
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(getProjectId(), project.getProjectId()) &&
               Objects.equals(getName(), project.getName()) &&
               Objects.equals(getDescription(), project.getDescription()) &&
               Objects.equals(getStartDate(), project.getStartDate()) &&
               Objects.equals(getEndDate(), project.getEndDate()) &&
               Objects.equals(getUserProfile(), project.getUserProfile());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getName(), getDescription(), getStartDate(), getEndDate(), getUserProfile());
    }
}
