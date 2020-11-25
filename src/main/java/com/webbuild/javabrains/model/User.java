package com.webbuild.javabrains.model;

import javax.persistence.*;

import java.util.Set;

//Define all relevant user data
@Entity
@Table(name = "USERS") //Table Reference in database
public class User {
    
	@Id //identify primary key
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //Set Value to auto populate in database
    @SequenceGenerator(name = "id_Sequence", sequenceName = "roleid_SEQ") //Declare Database Sequence you want to use
    @Column(name="personid")
    private int PersonID;
   
    @Column(name="username")
    private String username;
	
    @Column(name="password")
    private String password;
	
    @Column(name="email")
    private String email;
	
    @Column(name="storfile")
    private byte[] storfile; //make sure types match for zip file
	
    @Column(name="keyquestion")
    private String keyquestion;
	
    @Column(name="keyanswer")
    private String keyanswer;
    
    @Column(name="roleid")
    private int roleid;

	@Transient
    private String passwordConfirm;

    @ManyToMany //Declare value as receiving value from other table
    private Set<Role> roles; //set a many to many relation with the Role table
    
    public int getId() {
        return PersonID; //Retrieve a value
    }

    public void setId(int id) {
        this.PersonID = id; // save a value
    }

    public String getUsername() {
        return username; //Retrieve a value
    }

    public void setUsername(String username) {
        this.username = username; // save a value
    }

    public String getPassword() {
        return password; //Retrieve a value
    }

    public void setPassword(String password) {
        this.password = password; // save a value
    }

    public String getPasswordConfirm() {
        return passwordConfirm; //Retrieve a value
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm; // save a value
    }

    public int getRoleid() {
		return roleid; //Retrieve a value
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid; // save a value
	}
	
	 public String getEmail() {
		return email; //Retrieve a value
	 }

	public void setEmail(String Email) {
		this.email = Email; // save a value
	}
	
	public Set<Role> getRoles() {
        return roles; //Retrieve a value
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles; // save a value
    }

	public byte[] getStorFile() {
		return storfile;
	}

	public void setStorFile(byte[] storfile) {
		this.storfile = storfile;
	}
	
	public String getKeyquestion() {
		return keyquestion;
	}

	public void setKeyquestion(String keyques) {
		keyquestion = keyques;
	}

	public String getKeyanswer() {
		return keyanswer;
	}

	public void setKeyanswer(String keyAns) {
		keyanswer = keyAns;
	}
}
