package com.webbuild.javabrains.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbuild.javabrains.Store;
import com.webbuild.javabrains.model.Shippers;
import com.webbuild.javabrains.repository.ShippersRepository;
import com.webbuild.javabrains.repository.ShippingRepository;

@Controller
public class HomePageController {

	@Autowired //call data table and all stored functions
	ShippersRepository shippersservice;
	
	@Autowired //call data table and all stored functions
	private ShippingRepository shippingservice;
	
	//Create objects required for the home page
	@RequestMapping("/HomeLab")
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
    	model.setViewName("HomePageTest");//declare page url
        return model;  //go to jsp page
    }
	

	@GetMapping("/AboutUs") public String AboutUs() { return "Itd110project/AboutUs";}
	@GetMapping("/HomePage") public String StartPoint() { return "Itd110project/HomePage";}
	
	@GetMapping("/SignUpForm") public ModelAndView  Form() {
		ModelAndView model = new ModelAndView();//new server object
		model.addObject("input", new Shippers());
		model.setViewName("Itd110project/SignUpForm");
		return model;
	}
	
	@RequestMapping("/Partners")
    public ModelAndView  DynamicTable() {
		ModelAndView model = new ModelAndView();//new server object
		List<Shippers> Ship=shippersservice.findAll();//get all partner information
		model.addObject("partners", Ship);
		model.setViewName("Itd110project/Partners");//declare page url
        return model;  //go to jsp page
	}
	
	//Update Table Shippers
	@RequestMapping(value = { "/newPartner"}, method=RequestMethod.POST)
	public String updatepartners(@ModelAttribute("input") Shippers partnerForm) { //Declare a new partner
		shippingservice.addPartner(partnerForm); //add new partner to data base
		return "redirect:/Partners"; //go back to partner webpage
	}
	
	@RequestMapping("/Products")
	public ModelAndView Products() {
		ModelAndView model = new ModelAndView();//new server object
		double[] array={450, 414, 520, 460, 450, 500, 480, 480, 410, 500, 480, 510};//create data for chart
		List<String> imageUrlList = new ArrayList<>(Arrays.asList());
		File imageDir = new File("src/main/webapp/ImageAssets"); //create a file object from stored folder
		for(File imageFile : imageDir.listFiles()){  
			String imageFileName = imageFile.getName();//get file names 
			imageUrlList.add(imageFileName); // add this images name to the list we are building up  
		}
		
		//populate server object
		model.addObject("imageUrlList", imageUrlList);
		model.addObject("Sample", array);
		model.addObject("test", "Products and services we offer."); //create message
		model.setViewName("Itd110project/Products");//declare page url
		return model;
	}
	
	@RequestMapping("/ProdutIntercation")
    public ModelAndView  UserInteraction() {
		ModelAndView model = new ModelAndView();//new server object
		double[] array={450, 414, 520, 460, 450, 500, 480, 480, 410, 500, 480, 510};//create data for chart
		List<String> imageUrlList = new ArrayList<>(Arrays.asList());
		File imageDir = new File("src/main/webapp/ImageAssets"); //create a file object from stored folder
		for(File imageFile : imageDir.listFiles()){  
			String imageFileName = imageFile.getName();//get file names 
			imageUrlList.add(imageFileName); // add this images name to the list we are building up  
		}  
		List<String> discript=Store.getSeviceDescp();//get descriptions for each image
		
		//populate server object
		model.addObject("imageUrlList", imageUrlList);
		model.addObject("discript", discript);
    	model.addObject("Sample", array);
    	model.setViewName("Itd110project/ProductIntercation");//declare page url
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