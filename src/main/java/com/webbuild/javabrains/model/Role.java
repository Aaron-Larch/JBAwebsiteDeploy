package com.webbuild.javabrains.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

//Call a table in a remote Data base that stores roll names and permissions

@Entity
@Table(name = "DIVISIONS") //Table Reference in database
public class Role implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	
    @Id //identify primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long DIVISIONID;

    private String DIVISIONNAME;

    @OneToMany(fetch = FetchType.LAZY, optional = false)//Declare reference table
    @JoinColumn(name = "users_roleid", nullable = false)
    @JsonIgnore 
    private Set<User> users; //set a many to many relation with the user table

    public long getDIVISIONID() {
        return DIVISIONID; //Retrieve a value
    }

    public void setDIVISIONID(long id) {
        this.DIVISIONID = id; // save a value
    }

    public String getDIVISIONNAME() {
        return DIVISIONNAME; //Retrieve a value
    }

    public void setDIVISIONNAME(String name) {
        this.DIVISIONNAME = name; // save a value
    }

    public Set<User> getUsers() {
        return users; //Retrieve a value
    }

    public void setUsers(Set<User> users) {
        this.users = users; // save a value
    }
}