package com.webbuild.javabrains.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.webbuild.javabrains.model.PasswordResetToken;
import com.webbuild.javabrains.repository.PasswordResetTokenRepository;


@Service //Create and store information in the server log
public class SecurityServiceImpl implements SecurityService{
    @Autowired //call the authentication layer
    private AuthenticationManager authenticationManager;

    @Autowired //call the user details method
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    //create a log object
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override //Search the log for a user
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override //Automate the user log in process
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        //Verify the log in information has a match in the Database
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //If found go to the next page in path
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username)); //log recored added
        }
    }
    
    //Call up all of the user defined roles
    public String FindAuthentication(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();//call server for user info
        String role = auth.getAuthorities().toString(); //set Authentication to string
    	return role;
    }
    
    //Get the user name
    public String FindUserName(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();//call server for user info
        String username = auth.getName(); //set Authentication to string
    	return username;
    }
    
    //find user token
    public PasswordResetToken passToken(String token) {
    	return passwordTokenRepository.findByToken(token);
    }
    
    //a validation method that checks the token for errors
    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passToken(token);
        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : isTokenused(passToken) ? "Used"
                : "validToken";//if token is good return flag
    }
    
    //check to see if token is real
    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }
    
    //check to see if token has expired
    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
    
    //check to see if token has already been used
    private boolean isTokenused(PasswordResetToken passToken) {
    	return passToken.getIsused()!='0';
    }
    
    public void setToken(String Token) {
    	final PasswordResetToken passToken = passToken(Token);
    	passToken.setIsused('1');//if the token is not used set it to used
    	passwordTokenRepository.save(passToken);
    }
    
}
