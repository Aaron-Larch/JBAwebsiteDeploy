package com.webbuild.javabrains.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webbuild.javabrains.Store;
import com.webbuild.javabrains.model.Shippers;
import com.webbuild.javabrains.repository.ShippersRepository;

@Controller
public class HomePageController {

	@Autowired //call data table and all stored functions
	ShippersRepository shippersservice;
	
	//Create objects required for the home page
	@RequestMapping("/HomePage")
    public ModelAndView  HomeLab() {
		ModelAndView model = new ModelAndView();//new server object
		double[] array={450, 414, 520, 460, 450, 500, 480, 480, 410, 500, 480, 510};//create data for chart
		List<String> imageUrlList = new ArrayList<>(Arrays.asList());
		File imageDir = new File("src/main/webapp/ImageAssets"); //create a file object from stored folder
		for(File imageFile : imageDir.listFiles()){  
			String imageFileName = imageFile.getName();//get file names 
			imageUrlList.add(imageFileName); // add this images name to the list we are building up  
		}  
		List<String> discript=Store.getSeviceDescp();//get descriptions for each image
		List<Shippers> Ship=shippersservice.findAll();//get all partner information
		
		//populate server object
		model.addObject("imageUrlList", imageUrlList);
		model.addObject("discript", discript);
		model.addObject("partners", Ship);
    	model.addObject("Data", array);
    	model.addObject("test", "Products and services we offer."); //create message
    	model.setViewName("Index");//declare page url
        return model;  //go to jsp page
    }
    
  //Workbench page to test ideas. delete for final project
	@RequestMapping("/TestPage") //a way to make two pages run off of the same method
  	public ModelAndView TestMail() {
  		ModelAndView model = new ModelAndView();
  		System.out.println("hello");
    	model.setViewName("NewFile");
        return model;  //go to jsp page 
  	}
}//This Is a work Bench Page that is used for testing code