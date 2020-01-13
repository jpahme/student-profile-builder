package com.techelevator.finalcapstonespringboot.controller;

import com.techelevator.finalcapstonespringboot.authentication.AuthProvider;
import com.techelevator.finalcapstonespringboot.authentication.JwtTokenHandler;
import com.techelevator.finalcapstonespringboot.authentication.UnauthorizedException;
import com.techelevator.finalcapstonespringboot.authentication.UserCreationException;
import com.techelevator.finalcapstonespringboot.model.User;
import com.techelevator.finalcapstonespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * AccountController
 */
@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    UserRepository userRep;
    
    @Autowired
    private AuthProvider auth;
    
    @Autowired
    private JwtTokenHandler tokenHandler;
    
    @PostMapping(path = "/login", produces = "application/json")
    public String login(@RequestBody User user, RedirectAttributes flash) throws UnauthorizedException {
        if (auth.signIn(user)) {
            User currentUser = auth.getCurrentUser();
            String token = tokenHandler.createToken(user.getUsername(), currentUser.getRole());
            return token;
        } else {
            throw new UnauthorizedException();
        }
    }
    
    @PostMapping(path = "/register")
    public String register(@Valid @RequestBody User user, BindingResult result) throws UserCreationException {
        if (result.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : result.getAllErrors()) {
                errorMessages += error.getDefaultMessage() + "\n";
            }
            throw new UserCreationException(errorMessages);
        }
        auth.register(user);
        return "{\"success\":true}";
    }
    
}

