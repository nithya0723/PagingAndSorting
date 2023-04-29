package com.example.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mobile.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile,Integer>{
	public List<Mobile>findByBrandStartingWith(String prefix);
	public List<Mobile>findByBrandEndingWith(String suffix);
	public List<Mobile>findByModel(String prefix);
	
//	//positional parameter
//	@Query("select u from Mobile u where u.brand=?1 and u.colour=?2")
//	public List<Mobile> fetchPositionalParameter(String brand,String colour);
//	
//	//named parameter
//		@Query("select u from Mobile u where u.brand=?1")
//		public List<Mobile> fetchNamedParameter(String brand);	
//		
//	//DML Delete Query
//		@Modifying
//		@Query("select u from Mobile u where u.model=?1")
//		public List<Mobile> deleteCarByModel(String model);
}
 