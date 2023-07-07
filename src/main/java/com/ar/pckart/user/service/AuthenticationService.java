package com.ar.pckart.user.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ar.pckart.user.User;
import com.ar.pckart.user.Role;
import com.ar.pckart.user.config.JwtService;
import com.ar.pckart.user.dto.AuthenticationRequest;
import com.ar.pckart.user.dto.AuthenticationResponse;
import com.ar.pckart.user.dto.RegisterRequest;
import com.ar.pckart.user.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder()
				.fullname(request.getFullname())
				.email(request.getEmail())
				.mobile(request.getMobile())
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.isNonLocked(true) // at register not lock true
				.isEnable(false) // not enable at start
				.build();
	
		repository.findByUsername(request.getUsername()).ifPresent(
				u-> {
					throw new UserLoginException("username "+u.getUsername()+" already exist");
				});
		
		repository.save(user);
		
		var jwtToken = jwtService.generateToken(new UsersDetails(user));
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						 request.getUsername(),
						 request.getPassword()
						 )
				);
		
		var user = repository.findByUsername(request.getUsername())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(new UsersDetails(user));
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

}

