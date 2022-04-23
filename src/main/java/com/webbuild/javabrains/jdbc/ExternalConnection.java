package com.webbuild.javabrains.jdbc;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.webbuild.javabrains.model.Shippers;
import com.webbuild.javabrains.model.TableObjects;



public class ExternalConnection{
	//Static Server connection Data Source
	private static String DATABASE_URL = "postgres://hdbmcmpbanzxib:25c89265145e7b8c6ade73cbd530502300a7ac140b1c1e68d45d84fa4b86eab7@ec2-54-157-88-70.compute-1.amazonaws.com:5432/d8ajqksjp4lbaj";
	private static Connection conn; //stored connection veriabule to save on connections
	static List<TableObjects>Topics;

	//connect to a remote web server
	public static Connection dbConnect() {
		//check to see if connection is astablished
		if (conn == null) {
			try {
				// create a handshake connection between java and the desired SQL server. 
				URI dbUri = new URI(DATABASE_URL);
				
		        //Separate key items from URI 
		        String username = dbUri.getUserInfo().split(":")[0];
		        String password = dbUri.getUserInfo().split(":")[1];
					
		        //Recombine Uri information into a url connection statement
		        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		        conn = DriverManager.getConnection(dbUrl, username, password);//establish connection
		        System.out.println("Opened database successfully");		
			}catch(Exception e){
		        //error handling
		        System.err.println("Got an exception! ");
		        System.err.println(e.getClass().getName()+": "+e.getMessage());
		        System.exit(0); 
			}
		    return conn; //create new connection
		}
		return conn; //return old connection
	}
		
		//populate data layer
		public static List<TableObjects> Shipping(String field, String role) {
			try {
				// create the java statement to connect to a specific database 
				Statement sta = dbConnect().createStatement();
				ResultSet rs;
				Topics = new ArrayList<>(Arrays.asList());
				
				// execute the query just like any normal SQL , and get a java result set
				String Managerquery = "SELECT * FROM ORDERS WHERE SHIPCOUNTRY='"+field+"'"; //manager Query 
				String Customerquery= "SELECT * FROM ORDERS WHERE CUSTOMERID='"+field+"'"; //user Query
				
				
				if(role.equalsIgnoreCase("All")) {rs = sta.executeQuery(Managerquery);}
				else {rs = sta.executeQuery(Customerquery);}

				
				//populate the object with the returned results
				while (rs.next()) {
					Topics.add(new TableObjects(
							rs.getString("ORDERID"),
							rs.getString("CUSTOMERID"),
							rs.getString("EMPLOYEEID"),
							rs.getString("SHIPVIA"),
							rs.getString("FREIGHT"),
							rs.getString("SHIPNAME"),
							rs.getString("SHIPCOUNTRY")
					));
				}
				sta.close();//close off server connection. release use resources 
				return Topics;
				
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		//update a table with the information on the data layer
		public static void UpdateLine(TableObjects TableData) {
			try {
				// create the java statement
				Statement sta = dbConnect().createStatement();

				//build a check statement to see if the object needs to be updated or inserted
				String checkstatement = "select COUNT(*) from orders where ORDERID = '"+TableData.getORDERID()+"'";
				
				//update statement
				String updateStatement = "UPDATE ORDERS SET "+
						"CUSTOMERID = '" + TableData.getCUSTOMERID()+"', "+
						"EMPLOYEEID = '" + TableData.getEMPLOYEEID()+"', "+
						"SHIPVIA = '" + TableData.getSHIPVIA()+"', "+ 
						"FREIGHT = '" + TableData.getFREIGHT()+"', "+ 
						"SHIPNAME = '" + TableData.getSHIPNAME()+"', "+
						"SHIPCOUNTRY = '" + TableData.getSHIPCOUNTRY()+
					"' WHERE ORDERID = '"+ TableData.getORDERID()+"'";
			
				//insert statement
				String insertStatement = "insert into orders "+
				"(ORDERID, CUSTOMERID, EMPLOYEEID, SHIPVIA, FREIGHT, SHIPNAME, SHIPCOUNTRY)"+
							  "values ('"+TableData.getORDERID()+"', '"+
							   	TableData.getCUSTOMERID()+"', '"+
							   	TableData.getEMPLOYEEID()+"', '"+
							   	TableData.getSHIPVIA()+"', '"+
							   	TableData.getFREIGHT()+"', '"+
							   	TableData.getSHIPNAME()+"', '"+
							   	TableData.getSHIPCOUNTRY()+"')";
					
				//if exists (select * from table with (uplock,serializable) where key = @key)
				ResultSet rs = sta.executeQuery(checkstatement);
				while (rs.next()) {
				if(rs.getInt("COUNT(*)")==1) { //if rowcount = 1 then
					System.out.println(rs.getInt("COUNT(*)"));
					sta.executeUpdate(updateStatement);
				}else { //if rowcount = 0 then
					System.out.println(rs.getInt("COUNT(*)"));
					sta.executeUpdate(insertStatement);
				}//if rowcount = 2 then this isn't a primary key
				}
				//commit changes
				sta.executeQuery("COMMIT");
				System.out.println("Commit Executed");
				sta.close();//close off server connection. release use resources 
				System.out.println("Database updated");
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
		
		//delete a table row
		public static void DeleteRow(List<TableObjects> TableData, String Orderid) {
			try {
				// create the java statement to connect to a specific database 
				Statement sta = dbConnect().createStatement();
				for (int i = 0; i < TableData.size(); i++) {
					if(TableData.get(i).getORDERID().equalsIgnoreCase(Orderid)) {
						// execute the query just like any normal SQL , and get a java result set
						String query = "DELETE FROM orders WHERE ORDERID = '"+Orderid+"'";
						sta.executeUpdate(query);
					}
				}
				//commit changes
				sta.executeQuery("COMMIT");
				System.out.println("Commit Executed");
				sta.close();//close off server connection. release use resources 	
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
		
		//Determine method by which to organize large amounts of data to save on memory space
		public static String[] SetSortParamiters() {
			try {
				// create the java statement to connect to a specific database 
				Statement sta = dbConnect().createStatement();
				
				//get the size of the array needed to sort all objects
				List<String> Country = new ArrayList<String>();
				//Create list of Search Terms
				String CollectCountery = "select DISTINCT SHIPCOUNTRY from Orders";
				ResultSet list = sta.executeQuery(CollectCountery);
				while(list.next()){
					Country.add(list.getString("SHIPCOUNTRY"));
				}
				sta.close();//close off server connection. release use resources 
				return Country.toArray(new String[Country.size()]);
				
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		public static int getOrderId() {
			try {
				// create the java statement to connect to a specific database 
				Statement sta = dbConnect().createStatement();
				
				//get the last Order id to ensure all new orders are added to the current number system 
				String StartingQuery= "select Max(ORDERID) AS \"Current\" from Orders";
				ResultSet storedValue = sta.executeQuery(StartingQuery);
				storedValue.next();
				int currentOrder=storedValue.getInt("Current");
				sta.close();//close off server connection. release use resources 
				return currentOrder;
				
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
				return 0;
			}
		}
		
		@SuppressWarnings("unchecked") //Create a catalog of tables sorting Data by the populate and sort methods
		public static ArrayList<TableObjects>[] SortedShipping() {
			try {
				String[] SortList = SetSortParamiters(); //collect parameters
				ArrayList<TableObjects>[] SortDatabase = new ArrayList[SortList.length];
		        
				for(int i=0; i < SortList.length; i++) {
					SortDatabase[i] = new ArrayList<TableObjects>(); 
					SortDatabase[i].addAll(Shipping(SortList[i], "All")); //populate table
				}
				return SortDatabase;
				
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
				return null;
			}	
		}
		
		//Insert a new line into the Shippers table with the information on the data layer
		public static void addPartner(Shippers TableData) {
			try {
				// create the java statement
				Statement sta = dbConnect().createStatement();
				ResultSet rs;
				int storage=0;
				//create a dynamic ID query
				String IdCountQuery = "SELECT shipperid FROM shippers WHERE shipperid = (SELECT MAX(shipperid) FROM shippers)";
				rs = sta.executeQuery(IdCountQuery);//fetch the latest ID value
				
				while (rs.next()) {
				storage=rs.getInt("shipperid"); //set to int value
				storage++; //Increment it by 1
				
				System.out.println(TableData.getCompanyName()+", "+ TableData.getAddress()+", "+storage);
				
				//insert statement
				String insertStatement = "insert into Shippers "+
				"(COMPANYNAME, PHONE, SHIPPERID)"+
							  "values ('"+TableData.getCompanyName()+"', '"+
							   	TableData.getAddress()+"', '"+
							   	storage+"')";
					
				//Insert new Shipper
				sta.executeUpdate(insertStatement);
				}
				//commit changes
				sta.executeQuery("COMMIT");
				System.out.println("Commit Executed");
				sta.close();//close off server connection. release use resources 
				System.out.println("Database updated");
			}catch(Exception e){
				//error handling
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
		
		//test lab method for ease of debugging
		/*public static void main(String[] args) {
			String[] PrintOut=SetSortParamiters();
			for(int i=0; i < PrintOut.length; i++) {
				System.out.println(PrintOut[i]);
			}
			
			ArrayList<TableObjects>[] shipping = SortedShipping();
			for(int i=0; i < shipping.length; i++) {
				for(int ii=0; ii < shipping[i].size(); ii++) {
					System.out.println(shipping[i].get(ii).getORDERID()+" "+shipping[i].get(ii).getSHIPCOUNTRY());
			     }
				System.out.println("New country"+ i);
			}
		   //ShippingUpdate(shipSpain);
			//int test= getOrderId();
			//System.out.println(test);
		}*/
}
