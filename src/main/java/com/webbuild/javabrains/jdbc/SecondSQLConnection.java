package com.webbuild.javabrains.jdbc;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.webbuild.javabrains.model.OrderDetails;
import com.webbuild.javabrains.model.Products;


public class SecondSQLConnection {
	//Static Server connection Data Source
	private static String DATABASE_URL = "postgres://hdbmcmpbanzxib:25c89265145e7b8c6ade73cbd530502300a7ac140b1c1e68d45d84fa4b86eab7@ec2-54-157-88-70.compute-1.amazonaws.com:5432/d8ajqksjp4lbaj";
	static List<OrderDetails> orderDe;
	static List<Products> items;

	//connect to a remote web server
	public static Connection dbConnect() {
		try {
			// create a handshake connection between java and the desired SQL server. 
			URI dbUri = new URI(DATABASE_URL);
			
			//Separate key items from URI 
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
				
			//Recombine Uri information into a url connection statement
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			Connection conn = DriverManager.getConnection(dbUrl, username, password);//establish connection
			System.out.println("Opened database successfully");
			return conn;		
		}catch(Exception e){
			//error handling
			System.err.println("Got an exception! ");
			System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
	        return null;
	      }
	}

	//Find each unique product and display generic user information
	public static List<Products> CollectProducts(int Category){
		try {
			Statement sta = dbConnect().createStatement();
			Statement state = dbConnect().createStatement();
			ResultSet rs, second;
			items = new ArrayList<>(Arrays.asList());
			// execute the query just like any normal SQL , and get a java result set
			String inputquery = "SELECT DISTINCT(PRODUCTNAME), PRODUCTID FROM PRODUCTS  Where CATEGORYID = "+Category;
			rs = sta.executeQuery(inputquery);
			
			while (rs.next()) {
				String Secondquery = "SELECT * FROM PRODUCTS Where PRODUCTID = "+rs.getInt("ProductID");
				second = state.executeQuery(Secondquery);
				Products temp =new Products();
				while(second.next()) {
					temp.setProductID(second.getInt("productID"));
					temp.setProductName(second.getString("productName"));
					temp.setSupplierID(second.getInt("supplierID"));
					temp.setCategoryID(second.getInt("categoryID"));
					temp.setQuantityPerUnit(second.getString("quantityPerUnit"));
					temp.setUnitsInStock(second.getInt("unitsInStock"));
					temp.setUnitsOnOrder(second.getInt("unitsOnOrder"));
					temp.setUnitprice(second.getDouble("unitprice"));
					items.add(temp);
				}
			}
			state.close();
			sta.close();//close off server connection. release use resources 
			return items;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//find the user the best discount.
	public static List<OrderDetails> order(int product){
		try {
			Statement sta = dbConnect().createStatement();
			ResultSet rs;
			orderDe = new ArrayList<>(Arrays.asList());
			// execute the query just like any normal SQL , and get a java result set
			String inputquery = "SELECT * FROM ORDERDETAILS Where productID = "+product
					+" And Discount =(SELECT Max(Discount) FROM ORDERDETAILS Where productID = "+product+")";
 
			rs = sta.executeQuery(inputquery);
			
			while (rs.next()) {
				orderDe.add(new OrderDetails(
						rs.getInt("OrderID"),
						rs.getInt("ProductID"),
						rs.getDouble("UnitPrice"),
						rs.getDouble("Discount")
				));
			}
			sta.close();//close off server connection. release use resources 
			return orderDe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
