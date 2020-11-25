package com.webbuild.javabrains.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webbuild.javabrains.Store;
import com.webbuild.javabrains.controller.SpainShippingController;
import com.webbuild.javabrains.model.PasswordResetToken;
import com.webbuild.javabrains.model.Role;
import com.webbuild.javabrains.model.User;
import com.webbuild.javabrains.repository.PasswordResetTokenRepository;
import com.webbuild.javabrains.repository.RoleRepository;
import com.webbuild.javabrains.repository.ShippingRepository;
import com.webbuild.javabrains.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	@Autowired //call the user table in the database
    private UserRepository userRepository;
    
	@Autowired //call the role table in the database
    private RoleRepository roleRepository;
    
    @Autowired //create a new encryption token
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired //call data table and all stored functions
	ShippingRepository shippingservice;
    
    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;
    
    Set<Role> Security= new HashSet<Role>(); //Create a new role list
    private static AnaliticService Dataprep = new AnaliticService();

    @Override //Create a new user and role pair
    public void save(User user) {
	user.setId(userRepository.getNextUserId());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setKeyanswer(bCryptPasswordEncoder.encode(user.getKeyanswer()));
        Security.add(roleRepository.findById(user.getRoleid()).get()); //call a single role that matches the user input 
        user.setRoles(Security);
        userRepository.save(user);
    }
    
    //Save data and Release all used resources
    public User saveRecord(User user) {
    	//check user permissions
    	if(user.getRoleid()==2) {
    		if(AnaliticService.getFile()!=null) {
    			try {
    				//check to see if there is and object to save
    				byte[] compressed = Store.compress(Dataprep.SavedData());//change java object to a .zip file
    				user.setStorFile(compressed);//set file to user object
    				userRepository.save(user); //save user object
    			} catch (IOException e) {e.printStackTrace();}
    			Dataprep.releaseresources();//reset counters
    		}
    	}
    	//reset all stored variables for security and resource management
    	SpainShippingController.ResetValues();
        return null;
    }
    
    //Load a saved object from the SQL table
    public void LoadRecord(User user) {
    	//check to see if there is a blob object on the database
    	if(user.getStorFile() != null) {
    		byte[] compressed=user.getStorFile();//get blob compressed object
			try {
				String decomp = Store.decompress(compressed);//convert .zip to java
				Dataprep.LoadSavedData(decomp);//set counters to appropriate values
			} catch (IOException e) {e.printStackTrace();}		
    	}
    }

    //SELCET * FROM USER WHERE username= 'input'
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
  //SELCET * FROM Roles
    @Override
    public List<Role> GetRolls(){
    	return roleRepository.findAll();
    }
    
	//SELCET * FROM USER
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    //SELCET * FROM USER WHERE Email= 'input'
    @Override
    public User findUserByEmail(String Email) {
        return userRepository.findByUsername(Email);
    }
    
    //generate token security information and Store token in Database
    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
    	PasswordResetToken myToken = new PasswordResetToken(token, user);
    	passwordTokenRepository.save(myToken);
    }
    
    //update user password
    public void changeUserPassword(User user, String password) {
    	User update= userRepository.findByUsername(user.getUsername());//find user object
        update.setUsername(user.getUsername());// set username
        update.setPassword(bCryptPasswordEncoder.encode(password));//encrypt new password
        userRepository.save(update);//update
        
    }
}
