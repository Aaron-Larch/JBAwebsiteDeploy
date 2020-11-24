/**
 * 
 */
package com.webbuild.javabrains;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Aaron Larch
 *
 */
public class Store {
	private static int i;
	private static boolean check;
	private static String Input;
	private static Random rand = new Random();
	
	
	/*A series of methods that emulate the functions or the scanner class in java. using system.in
	 * the following methods will collect keystrokes made by a user and convert them into one of the 4 primary data types
	 * Character
	 * Integer
	 * double
	 * float
	 * the methods also auto format number values and ignore any return/enter keystrokes until a keystroke has been saved.
	 */
	

	//store user input as a Character and then resetting the buffer to store a new value
	public char symbol() {
		try {
			i=System.in.read(); // get a char
			System.in.skip(i); //dump the buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (char)i;
		}
	
	//store user input as a String and then resetting the buffer to store a new value
	public String words(){
		//reset stored value to blank
		Input="";
		check=true;
		try {
			//by using a nested do loop the code can safely isolate a key as an invalid input preventing a null value from being entered
			do {
				//the askey value for the "enter/return" key is 10
				do { //do...While loop required to set the flag value after the return key is hit a second time
				 i =System.in.read();// get a char
				 if(Input.length()>0 && ((char)i == '\n' | (char)i == '\r')) { 
					 check=false; // set flag after return key is hit
				 }
				} while(((char)i == '\n' | (char)i == '\r') && check!=false); //Ignore the return key by constantly resetting the buffer
				
				Input+=(char)i; //store buffer in a variable
				
			}while(check != false);//exit input loop
			System.in.skip(i);//dump the buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Input.trim();
	}
	
	//store user input as a Integer and then resetting the buffer to store a new value
	public int number(){
		//reset stored value to blank
		Input="";
		check=true;
		try {
			//by using a nested do loop the code can safely isolate a key as an invalid input preventing a null value from being entered
			do {
				//the askey value for the "enter/return" key is 10
				do { //do...While loop required to set the flag value after the return key is hit a second time
				 i =System.in.read();// get a char
				 if(Input.length()>0 && ((char)i == '\n' | (char)i == '\r')) {
					 check=false; // set flag after return key is hit
				 }
				} while(((char)i == '\n' | (char)i == '\r') && check!=false); //Ignore the return key by constantly resetting the buffer
				
				if(i==' '|| i=='.') {break;} //user error handling integers do not have " " or "."
				Input+=(char)i; //store buffer in a variable
				
			}while(check != false); //exit input loop
			System.in.skip(i); //dump the buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int value = Integer.parseInt(Input.trim()); //turn string into an intager value
		return value;
	}
	
	//store user input as a double and then resetting the buffer to store a new value
	public double complex(){
		//reset stored value to blank
		Input="";
		check=true;
		try {
			//by using a nested do loop the code can safely isolate a key as an invalid input preventing a null value from being entered
			do { 
				//the askey value for the "enter/return" key is 10
				do { //do...While loop required to set the flag value after the return key is hit a second time
				 i =System.in.read();// get a char
				 if(Input.length()>0 && ((char)i == '\n' | (char)i == '\r')) {
					 check=false; // set flag after return key is hit
				 }
				} while(((char)i == '\n' | (char)i == '\r') && check!=false); //Ignore the return key by constantly resetting the buffer
				
				if(i==' ') {break;} //user error handling doubles do not have " " 
				Input+=(char)i; //store buffer in a variable
				
			}while(check != false); //exit input loop
			System.in.skip(i); //dump the buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double value = Double.parseDouble(Input.trim()); //turn string into an double value
		return value;
	}
	
	//store user input as a float and then resetting the buffer to store a new value
	public float value(){
		//reset stored value to blank
		Input="";
		check=true;
		try {
			//by using a nested do loop the code can safely isolate a key as an invalid input preventing a null value from being entered
			do {
				//the askey value for the "enter/return" key is 10
				do { //do...While loop required to set the flag value after the return key is hit a second time
				 i =System.in.read();// get a char
				 if(Input.length()>0 && ((char)i == '\n' | (char)i == '\r')) {
					 check=false; // set flag after return key is hit
				 }
				} while(((char)i == '\n' | (char)i == '\r') && check!=false); //Ignore the return key by constantly resetting the buffer
				
				if(i==' ') {break;} //user error handling float do not have " " 
				Input+=(char)i; //store buffer in a variable
				
			}while(check != false); //exit input loop
			System.in.skip(i); //dump the buffer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float value = Float.parseFloat(Input.trim()); //turn string into a float value
		return value;
	}
	
	//############################
	//Create Array Data
	//#############################
	
	//This method will build an array of any size and any configuration of random integer values
	public int[] rArrayInt(int size, int range) {
		// build an array of random integer values 
		int[] array = new int[Math.abs(size)]; //Use Math.abs() to prevent a negative array length
		for (i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(range);
		}
		return array;
	}
	
	//This method will build an array of any size and any configuration of random double values
	public double[] rArrayDouble(int size, int range) {
		// build an array of random double values
		double[] array = new double[Math.abs(size)]; //Use Math.abs() to prevent a negative array length
		for (i = 0; i < array.length; i++) {
			array[i] = rand.nextDouble()*range;	//rand.nextDouble() only produces a random value between 0 and 1 multiply by the range to get more diverse results
		}
		return array;
	}
	
	//This method will build an array of any size and any configuration of random float values
	public float[] rArrayFloat(int size, int range) {
		// build an array of random float values
		float[] array = new float[Math.abs(size)]; //Use Math.abs() to prevent a negative array length
		for (i = 0; i < array.length; i++) {
			array[i] = rand.nextFloat()*range; //rand.nextFloat() only produces a random value between 0 and 1 multiply by the range to get more diverse results
		}
		return array;
	}
	
	//This method is a prototype scanner build
	public String altstyle() throws IOException { //use throw instead of a try catch block
		Input="";  //buffer for input string
		// Read multiple characters 
		while((i=System.in.read())!='\n') {
			Input+=(char)i; //store value
		}
		System.in.skip(i); // dump buffer
		return Input.trim();
	}
	
	//############################
	//File Compression 
	//#############################
	
	//Compress a string into a byte array
	public static byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {return null;}  //check to see if input is populated
		
		//Create a stream to hold the output
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));// Tell Java to use your special stream
		//Close down stream and release resources used
		gzip.flush();
		gzip.close();
		return obj.toByteArray(); //return byte array
	}

	//Convert a Byte array into a string
	public static String decompress(final byte[] compressed) throws IOException {
		final StringBuilder outStr = new StringBuilder(); //create a stream variable
		if ((compressed == null) || (compressed.length == 0)) {return "";} //check to see if input is populated
		
		//check for recognized forms of compression
		if (isCompressed(compressed)) {
			//Create a stream to hold the output
			final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

			String line;
			//Populate stream variable
			while ((line = bufferedReader.readLine()) != null) {outStr.append(line);}
		} else {outStr.append(compressed);}//else print stored array
		
		//convert output back into string
		return outStr.toString();
	}

	//to prevent code trying to decompress a uncompressed("not a zip format") byte[]. to prevent "Not in GZIP format" exception message
	public static boolean isCompressed(final byte[] compressed) {
		return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
	}
	
	//############################
	//Store hard Coded data 
	//#############################
	
	public static List<String> getSeviceDescp() {
		//list object with picture information for the home page
		List<String> SeviceDescp=new ArrayList<String>();
		SeviceDescp.add("These are Drinkabule liquid products that we sell. Some of the products here are:\n"
				+ "Water, lemonaid, fruit juice, Gatoraid, coconut milk, and Soda");
		SeviceDescp.add("Condements are sauses and spreads that you can spred on your food.\n"
				+ "An alternate use for a condement is to use as a dipping souce.");
		SeviceDescp.add("Confections are small candies, cookies, and treats.\n"
				+"They are often seved in small portion sizes. You can ushaly fit many of them onto one hand.");
		SeviceDescp.add("Here at JBA Shipping we also pride ourselves with our wide veriety of softwere offerings.\n"
				+"Here is a sample picture of just one of our easy to understand user interfaces.");
		SeviceDescp.add("We have a veriety of milk based prdouts harvested from many different types of mamals.\n"
				+ "Our top sellers are our wide veriety of creams and cheeses.");
		SeviceDescp.add("we offer many healthy breakfast options here with a wide veriety of cerials and grains.");
		SeviceDescp.add("We serve top cuts of meat from a wide veriety of birds and livestock.");
		SeviceDescp.add("There Many plant based foods, like fruits and vegeatubles, that can be purchased form our store.\n"
				+"Our produce is shipped around the world and as such we offer many exotic delicacys.");
		SeviceDescp.add("There is a wide seletion of seafood availibule here. To list a few of our items we have:\n"
				+"Shefish, Fish, Octupus, Crustations, Kelp, and Molloscks");
		SeviceDescp.add("We also pride ourselves in our data tracking and Anilitic software. We make all our graphs and reports" 
				+" with the CartJS graphing software to make profeshinal looking reports that are fun to look at and easy to read.");
		return SeviceDescp;
	}
	
	public static List<String> getQuestions() {
		List<String> SecurityQuestions=new ArrayList<String>();
		SecurityQuestions.add("What is you first pets maiden Name?");
		SecurityQuestions.add("What is the astrological sign of you house plant?");
		SecurityQuestions.add("Your father's favrite thing to drink on a monday?");
		SecurityQuestions.add("What arcade game dose your local pizzaria have?");
		SecurityQuestions.add("your grandmother's cusin's friend former Roomate's name?");
		return SecurityQuestions;
	}
}
