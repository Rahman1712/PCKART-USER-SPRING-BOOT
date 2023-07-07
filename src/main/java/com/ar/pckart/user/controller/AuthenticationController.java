package com.ar.pckart.user.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ar.pckart.user.dto.AuthenticationRequest;
import com.ar.pckart.user.dto.AuthenticationResponse;
import com.ar.pckart.user.dto.RegisterRequest;
import com.ar.pckart.user.service.AuthenticationService;
import com.ar.pckart.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;
	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest request) {
		return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

	@PostMapping("/check")
	public ResponseEntity<AuthenticationResponse> authenticate(HttpServletRequest req, HttpServletResponse res) {
		String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
		if (authHeader == null) {
			res.setStatus(401);
			return ResponseEntity.badRequest().build();
		}
		String token = authHeader.split(" ")[1];
		if (token == null) {
			res.setStatus(401);
			return ResponseEntity.badRequest().build();
		}
		AuthenticationResponse response =  new AuthenticationResponse();
		response.setToken(token);

		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/message")
	public ResponseEntity<String> message(@RequestParam String email) {
		try {
			return ResponseEntity.ok(userService.sendOTP(email));  
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error : Email Not Send ");
		}
	}
}

/*
 * @PostMapping("/register") public ResponseEntity<AuthenticationResponse>
 * register( //public ResponseEntity<Object> register(
 * 
 * @RequestBody @Valid RegisterRequest request //,BindingResult bindingResult ){
 * //if(bindingResult.hasErrors()) //return
 * ResponseEntity.badRequest().body(bindingResult.getFieldError()); //return
 * ResponseEntity.badRequest().build();
 * 
 * //return ResponseEntity.ok(service.register(request)); return new
 * ResponseEntity<>(service.register(request), HttpStatus.CREATED); }
 */
