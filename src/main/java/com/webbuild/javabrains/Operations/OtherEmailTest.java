package com.webbuild.javabrains.Operations;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.SimpleMailMessage;

import com.webbuild.javabrains.model.User;

public class OtherEmailTest {
	public static SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user) {
		Resource resource = new ClassPathResource("/validation.properties");
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String url = contextPath + "/Account/user/changePassword?token=" + token;
			String message = props.getProperty("message.resetPassword");
			System.out.println(message + " \r\n" + url);
			return constructEmail("Reset Password", message + " \r\n" + url, user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
			 
			private static SimpleMailMessage constructEmail(String subject, String body, 
			  User user) {
			    SimpleMailMessage email = new SimpleMailMessage();
			    email.setSubject(subject);
			    email.setText(body);
			    email.setTo(user.getEmail());
			    email.setFrom("no_reply@gce.com");
			    System.out.println("Email sent");
			    return email;
			}
}
