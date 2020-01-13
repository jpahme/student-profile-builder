package com.techelevator.finalcapstonespringboot.authentication;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.finalcapstonespringboot.model.User;


import com.techelevator.finalcapstonespringboot.repository.UserRepository;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RequestAuthProvider
 */
@Component
public class RequestAuthProvider implements AuthProvider {
    
    private HttpServletRequest request;
    private UserRepository     repository;
    
    private PasswordHasher passwordHasher;
    
    public final static String USER_KEY = "appCurrentUser";
    
    @Autowired
    public RequestAuthProvider(HttpServletRequest request, UserRepository repository) {
        passwordHasher = new PasswordHasher();
        this.request = request;
        this.repository = repository;
    }
    
    @Override
    public boolean isLoggedIn() {
        return (request.getAttribute(USER_KEY) != null);
    }
    
    @Override
    public User getCurrentUser() {
        return (User) request.getAttribute(USER_KEY);
    }
    
    @Override
    public boolean signIn(User user) {
        User currentUser       = repository.findByUsername(user.getUsername());
        User authenticatedUser = null;
        if (currentUser != null)
            authenticatedUser = repository.findByUsernameAndPassword(currentUser.getUsername(), currentUser.getPassword());

//        System.out.println(user.toString());
//        System.out.println(currentUser.toString());
//        System.out.println(authenticatedUser.toString());
        if (authenticatedUser != null) {
            request.setAttribute(USER_KEY, authenticatedUser);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void logOff() {
        request.removeAttribute(USER_KEY);
    }
    
    @Override
    public boolean changePassword(String existingPassword, String newPassword) {
        User userFromSession = (User) request.getAttribute(USER_KEY);
        if (userFromSession == null) {
            return false;
        }
        User userFromDb = repository.findByUsernameAndPassword(userFromSession.getUsername(), existingPassword);
        if (userFromDb != null && userFromDb.getId() == userFromDb.getId()) {
            userFromSession.setPassword(newPassword);
            repository.save(userFromSession);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void register(User user) {
        byte[] salt           = passwordHasher.generateRandomSalt();
        String hashedPassword = passwordHasher.computeHash(user.getPassword(), salt);
        String saltString     = new String(Base64.encode(salt));
        user.setPassword(hashedPassword);
        user.setSalt(saltString);
        repository.save(user);
    }
    
    @Override
    public boolean userHasRole(Integer[] roles) {
        User currentUser = getCurrentUser();
        if (currentUser != null && roles != null) {
            return Arrays.asList(roles).contains(currentUser.getRole());
        } else {
            return false;
        }
    }
}