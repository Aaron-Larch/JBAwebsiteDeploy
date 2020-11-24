package com.webbuild.javabrains.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webbuild.javabrains.Store;
import com.webbuild.javabrains.Operations.EmailEngine;
import com.webbuild.javabrains.model.User;
import com.webbuild.javabrains.repository.UserRepository;
import com.webbuild.javabrains.service.SecurityService;
import com.webbuild.javabrains.service.UserService;

@Controller
@RequestMapping(value = "/Account")
public class AdminController {
	
	@Autowired //call data table and all stored functions
	UserRepository userservice;
	
	@Autowired //call data table and all stored functions
	UserService GenerateToken;
	
	@Autowired //call data table and all stored functions
	SecurityService securityservice;
	
    @Autowired //call the validation methods
    private UserValidator userValidator; 
	
	Resource resource = new ClassPathResource("/validation.properties"); //create a global resource object
	Properties props;
	
	//create admin page
	@RequestMapping(value = { "/ResetPassword"}, method=RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("Email") String UserEmail, HttpServletRequest request){
		ModelAndView model = new ModelAndView();// create model web object
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);//load object with the correct properties file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = userservice.findUserByEmail(UserEmail);//get proper user
		//check for real user
		if (user != null) {
			String token = UUID.randomUUID().toString();//generate unique token string
			GenerateToken.createPasswordResetTokenForUser(user, token);//save token to database
			String appUrl = "https://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();//generate URL
			EmailEngine.constructResetTokenEmail(appUrl, request.getLocale(), token, user);//send information to email generator method
			String test=props.getProperty("message.resetPasswordEmail");//Confirmation message
			model.addObject("message", test); //send message to client server
		}else {
			model.addObject("message", props.getProperty("message.userNotFound"));// error handling
	    }
	    model.addObject("UserTable", userservice.findAll());//get user table for client server
	    return new ModelAndView("redirect:/Shipping/Pacific");//declare url for page set up
	}
	
	//validate token and populate password reset page
	@GetMapping("/user/changePassword")
	public String showChangePasswordPage(RedirectAttributes ra, final Model model, @RequestParam("token") final String token) {
		try {
			props = PropertiesLoaderUtils.loadProperties(resource); //load object with the correct properties file
			String result = securityservice.validatePasswordResetToken(token);//confirm the validity of any given token
			//check flag value
			if(result != "validToken") {
				String message = props.getProperty("auth.message." + result);//set invalid token message
				ra.addAttribute("attr", message);
				return "redirect:/login?resettoken";//go to url
			} else {
				User usr=securityservice.passToken(token).getUser();//generate user
				model.addAttribute("token", token); //send token to client
				model.addAttribute("PasswordForm", usr);//send user info to client
				model.addAttribute("questionsList", Store.getQuestions()); //get a list of security questions
				return "UserInterFace/updatePassword";//go to url
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/login";//error handling
		}
	}

	//take information from client server and update database
    @PostMapping("/user/changePassword")
    public String savePassword(@ModelAttribute("PasswordForm") User userForm, BindingResult bindingResult, 
    		@RequestParam("token") final String token, final Model model) {
    	userValidator.validateToken(userForm, bindingResult); //Check Object for errors
    	
        if (bindingResult.hasErrors()) {
        	model.addAttribute("questionsList", Store.getQuestions()); //get a list of security questions)
            return "UserInterFace/updatePassword"; //If errors found retun to page with error message
        }
        securityservice.setToken(token);
        GenerateToken.changeUserPassword(userForm, userForm.getPasswordConfirm()); //if no errors found save
        securityservice.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm()); //Auto login after successful save

        return "redirect:/welcome";  //go to jsp page
    }
	
}
