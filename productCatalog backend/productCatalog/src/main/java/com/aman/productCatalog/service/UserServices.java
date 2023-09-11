package com.aman.productCatalog.service;

import com.aman.productCatalog.Dto.LoginDto;
import com.aman.productCatalog.Dto.UserDto;
import com.aman.productCatalog.payload.response.LoginResponse;

public interface UserServices {

	String addUser(UserDto userDto);
	
	LoginResponse loginUser(LoginDto loginDto);
	
}

