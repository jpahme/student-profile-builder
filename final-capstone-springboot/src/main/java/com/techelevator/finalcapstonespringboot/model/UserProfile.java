package com.techelevator.finalcapstonespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity(name = "userProfile")
@Table(name = "user_profile")
public class UserProfile {
    
    @Id
    private Long userId;
    
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    
    @Email(message = "Must be a valid email address.")
    @Column(name = "email", updatable = true, nullable = false)
    private String email;
    
    @Column(name = "first_name", updatable = true, nullable = false)
    private String firstName;
    
    @Column(name = "last_name", updatable = true, nullable = false)
    private String lastName;
    
    @Column(name = "phone_number", updatable = true, nullable = true)
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits.")
    private String phoneNumber;
    
    @Size(max = 1000)
    @Column(name = "summary", updatable = true, nullable = true)
    private String summary;
    
    @Column(name = "cohort", updatable = true, nullable = false)
    private String cohort;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", updatable = true, nullable = false)
    private Date birthday;
    
    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getCohort() {
        return cohort;
    }
    
    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public void setAllFields(UserProfile userProfile) {
        this.setFirstName(userProfile.getFirstName());
        this.setLastName((userProfile.getLastName()));
        this.setEmail(userProfile.getEmail());
        this.setBirthday(userProfile.getBirthday());
        this.setPhoneNumber(userProfile.getPhoneNumber());
        this.setCohort(userProfile.getCohort());
        this.setSummary(userProfile.getSummary());
        this.setUsername(userProfile.getUsername());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
               Objects.equals(username, that.username) &&
               Objects.equals(getEmail(), that.getEmail()) &&
               Objects.equals(getFirstName(), that.getFirstName()) &&
               Objects.equals(getLastName(), that.getLastName()) &&
               Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
               Objects.equals(getSummary(), that.getSummary()) &&
               Objects.equals(getCohort(), that.getCohort()) &&
               Objects.equals(getBirthday(), that.getBirthday()) &&
               Objects.equals(getUser(), that.getUser());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), username, getEmail(), getFirstName(), getLastName(), getPhoneNumber(), getSummary(), getCohort(), getBirthday(), getUser());
    }
    
    @Override
    public String toString() {
        return "UserProfile{" +
               "userId=" + userId +
               ", username='" + username + '\'' +
               ", email='" + email + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", summary='" + summary + '\'' +
               ", cohort='" + cohort + '\'' +
               ", birthday=" + birthday +
               '}';
    }
}
