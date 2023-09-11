package com.aman.productCatalog.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aman.productCatalog.Dto.LoginDto;
import com.aman.productCatalog.Dto.UserDto;
import com.aman.productCatalog.Entity.User;
import com.aman.productCatalog.Repo.UserRepo;
import com.aman.productCatalog.payload.response.LoginResponse;
import com.aman.productCatalog.service.UserServices;


@Service
public class userServiceImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=new User(
			userDto.getUserId(),
			userDto.getName(),
			userDto.getEmail(),
			this.passwordEncoder.encode(userDto.getPassword())
		);
				
		userRepo.save(user);
				
				
		return user.getName();
	}

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {
		// TODO Auto-generated method stub
		String msg = "";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                	 return new LoginResponse("Login Success", true);
                }else {
                	return new LoginResponse("Login Failed", false);
                }

            }else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
	}
	
	
	
}
