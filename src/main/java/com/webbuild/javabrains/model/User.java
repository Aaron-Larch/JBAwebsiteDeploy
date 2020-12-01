package com.webbuild.javabrains.model;

import javax.persistence.*;

import java.util.Set;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//Define all relevant user data
@Entity
@Table(name = "USERS") //Table Reference in database
public class User {
    
	@Id //identify primary key
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //Set Value to auto populate in database
    @SequenceGenerator(name = "id_Sequence", sequenceName = "roleid_SEQ", allocationSize = 50) //Declare Database Sequence you want to use
    private int PersonID;
    private String username;
    private String password;
    private String email;
    private byte[] storfile; //make sure types match for zip file
    private String keyquestion;
    private String keyanswer;
    private long roleid;

	@Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY) //Declare value as receiving value from other table
    @JoinColumn(name = "DIVISIONID", nullable = false, insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
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

    public long getRoleid() {
		return roleid; //Retrieve a value
	}

	public void setRoleid(long roleid) {
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
