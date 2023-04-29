package com.example.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobile.model.MobileLogin;
import com.example.mobile.repository.MobileLoginRepository;

@Service
public class MobileLoginService {
	@Autowired
	MobileLoginRepository ab;
public MobileLogin saveMobile(MobileLogin u)
{
	return ab.save(u);
}
public String validateMobile(String username,String password)
{
	String result="";
	MobileLogin u=ab.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";	
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
}
