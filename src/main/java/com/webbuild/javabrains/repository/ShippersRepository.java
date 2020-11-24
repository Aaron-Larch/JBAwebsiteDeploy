package com.webbuild.javabrains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbuild.javabrains.model.Shippers;

//JPA database link
public interface ShippersRepository  extends JpaRepository<Shippers, Long>{
	List<Shippers> findAll();//simple stored query for quick access

}
