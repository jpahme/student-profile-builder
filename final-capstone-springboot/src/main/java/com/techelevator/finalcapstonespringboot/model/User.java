package com.techelevator.finalcapstonespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_id_generator")
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_sequence",
            initialValue = 1000
    )
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @NotBlank
    @Size(min = 5, max = 32, message = "User name must be at least {min} characters and not more than {max}.")
    @Column(name = "user_name", updatable = true, nullable = false, unique = true)
    private String username;
    
    @Size(min = 10, message = "Password too short, must be at least 10 characters.")
    @Pattern.List({
    	@Pattern(regexp = "(.*[A-Z]*.)", message = "Password must contain one uppercase letter."),                  
    	// @Pattern(regexp = "(.*[a-z]*.)", message = "Password must contain one lowercase letter.")
                  })
    @Column(name = "password", updatable = true, nullable = false)
    private String password;
    
    @Column(name = "role", updatable = true, nullable = false)
    private Integer role;
    
    @Transient
    private String confirmPassword;
    
    @JsonIgnore
    private String salt;
    
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;
    
    public UserProfile getUserProfile() {
        return userProfile;
    }
    
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getRole() {
        return role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
               Objects.equals(getUsername(), user.getUsername()) &&
               Objects.equals(getPassword(), user.getPassword()) &&
               Objects.equals(getRole(), user.getRole()) &&
               Objects.equals(getConfirmPassword(), user.getConfirmPassword()) &&
               Objects.equals(getSalt(), user.getSalt());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(),
                            getRole(), getConfirmPassword(), getSalt());
    }
    
    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", userName='" + username + '\'' +
               ", password='" + password + '\'' +
               ", role=" + role +
               ", salt='" + salt + '\'' +
               '}';
    }
}
