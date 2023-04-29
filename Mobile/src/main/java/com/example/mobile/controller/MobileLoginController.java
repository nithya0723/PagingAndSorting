package com.example.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.model.MobileLogin;
import com.example.mobile.service.MobileLoginService;
@RestController
public class MobileLoginController {
	@Autowired
	MobileLoginService hj;
	@PostMapping("/checkLogin")
		public String validateMobile(@RequestBody MobileLogin u)
		{
		System.out.println(u.getUsername());
			return hj.validateMobile(u.getUsername(),u.getPassword());
		}
	@PostMapping("/add")
	public void MobileLogin(@RequestBody MobileLogin u)
	{
		hj.saveMobile(u);
	}
}
