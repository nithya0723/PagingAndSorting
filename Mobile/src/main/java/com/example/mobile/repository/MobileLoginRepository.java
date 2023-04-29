package com.example.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mobile.model.MobileLogin;

@Repository
public interface MobileLoginRepository extends JpaRepository<MobileLogin,Integer>{
	MobileLogin findByUsername(String username);
}
