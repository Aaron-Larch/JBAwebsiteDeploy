package com.webbuild.javabrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webbuild.javabrains.model.User;

//connect to the user table In the Database
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findUserByEmail(String Email);

    @Query(value = "SELECT nextval('roleid_SEQ')", nativeQuery =true)
    int getNextUserId();
}
