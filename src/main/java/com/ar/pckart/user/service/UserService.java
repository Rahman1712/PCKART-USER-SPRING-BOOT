package com.ar.pckart.user.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ar.pckart.user.User;
import com.ar.pckart.user.repo.UserRepository;

import jakarta.mail.MessagingException;

@Service
public class UserService {

	@Autowired	private UserRepository userRepo;
	@Autowired private MailService mailService;
	@Autowired private OTPService otpService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Optional<User> findUserById(Long id) {
		return userRepo.findById(id);
	}
	public Optional<User> findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public void updatePassword(String newPassword, User user) {
		String encodedPassword = encoder.encode(newPassword);
		user.setPassword(encodedPassword);
		userRepo.save(user);
	}
	
	public String sendOTP(String userEmail) throws UnsupportedEncodingException, MessagingException {
        // Retrieve the OTP data for the user
    	User user = findUserByEmail(userEmail)
        		.orElseThrow(() -> new RuntimeException("Not Valid Email Id"));
    	
    	String otp = otpService.generateOTP(user);
    	return mailService.sendOTPMail(user, otp);	
	}
	
	public boolean verifyOTP(String userEmail) {
        User user = findUserByEmail(userEmail)
        		.orElseThrow(() -> new RuntimeException("Not Valid Email Id"));
        
        return false;
	}
}
