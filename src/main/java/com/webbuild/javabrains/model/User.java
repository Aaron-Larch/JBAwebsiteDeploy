package com.webbuild.javabrains.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

//Define all relevant user data
@Entity
@Table(name = "USERS") //Table Reference in database
public class User implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
    
	@Id //identify primary key
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //Set Value to auto populate in database
    @SequenceGenerator(name = "id_Sequence", sequenceName = "roleid_SEQ") //Declare Database Sequence you want to use
    private int PersonID;
    private String username;
    private String password;
    private String email;
    private byte[] storfile; //make sure types match for zip file
    private String keyquestion;
	private String keyanswer;
    private Long roleid;

	@Transient
    private String passwordConfirm;

	
	@ManyToMany(cascade = CascadeType.ALL)
   
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) //Declare value as receiving value from other table
	@JoinTable(
			name = "users_role", //declare foren key name
			joinColumns = @JoinColumn(name = "users_roleid", referencedColumnName = "roleid"), //declare users table
			inverseJoinColumns = @JoinColumn(name = "role_DIVISIONID", referencedColumnName = "DIVISIONID")//declare divisions table 
			) 
    private Set<Role> role; //set a many to many relation with the Role table
    
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

    public Long getRoleid() {
		return roleid; //Retrieve a value
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid; // save a value
	}
	
	 public String getEmail() {
		return email; //Retrieve a value
	 }

	public void setEmail(String Email) {
		this.email = Email; // save a value
	}
	
	public Set<Role> getRoles() {
        return role; //Retrieve a value
    }

    public void setRoles(Set<Role> roles) {
        this.role = roles; // save a value
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
