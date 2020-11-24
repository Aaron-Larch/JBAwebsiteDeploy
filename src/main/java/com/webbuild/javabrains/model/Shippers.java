package com.webbuild.javabrains.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPERS") //Table Reference in database
public class Shippers {
	
	//Primary key foreign key link to products table
    @Id //identify primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipperID;
	
	@Column(name="COMPANYNAME")
    private String companyName;
	
    @Column(name="PHONE")
	private String address;
	

    //Getters and setters
    public int getShipperID() {
		return shipperID;
	}

	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
