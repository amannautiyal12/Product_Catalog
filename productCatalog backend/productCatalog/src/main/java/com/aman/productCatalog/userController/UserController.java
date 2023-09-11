package com.aman.productCatalog.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.productCatalog.Dto.LoginDto;
import com.aman.productCatalog.Dto.UserDto;
import com.aman.productCatalog.payload.response.LoginResponse;
import com.aman.productCatalog.service.UserServices;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserServices userService;
	
	
	@PostMapping(path= "/save")
	public String saveUser(@RequestBody UserDto userDto) {
		String id=userService.addUser(userDto);
		return id;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Welcome to backend api of Examportal";
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
		LoginResponse loginResponse=userService.loginUser(loginDto);
		return  ResponseEntity.ok(loginResponse);
	}
	
}
