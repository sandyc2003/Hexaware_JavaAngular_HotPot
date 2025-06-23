package com.hexaware.hotpot.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDto;
import com.hexaware.hotpot.dto.RegisterDto;
import com.hexaware.hotpot.dto.UserDto;
import com.hexaware.hotpot.entities.Role;
import com.hexaware.hotpot.entities.User;
import com.hexaware.hotpot.exceptions.BadRequestException;
import com.hexaware.hotpot.repository.RoleRepository;
import com.hexaware.hotpot.repository.UserRepository;
import com.hexaware.hotpot.security.JwtTokenProvider;


@Service
public class AuthServiceImpl implements AuthService{
	private AuthenticationManager authenticationManager;
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager,
			UserRepository userRepo, RoleRepository roleRepo,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Override
	public JWTAuthResponse login(LoginDto dto) {
	    System.out.println("Object received: " + dto);
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword())
	    );

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String token = jwtTokenProvider.generateToken(authentication);
	    System.out.println("Token generated: " + token);
	    User user = userRepo.findByUserName(dto.getUserName())
	        .orElseThrow(() -> new RuntimeException("User not found"));

	    System.out.println("User object found in repo: " + user);
	    UserDto userDto = new UserDto();
	    userDto.setName(user.getName());
	    userDto.setEmail(user.getEmail());
	    userDto.setUsername(user.getUserName());

	    String roleName = user.getRoles().iterator().next().getName();  
	    userDto.setRole(roleName);
	    return new JWTAuthResponse(token, userDto);
	}
	
	@Override
	public String register(RegisterDto dto) {
		if (userRepo.existsByUserName(dto.getUserName())) {
		    throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists");
		}

	    if (userRepo.existsByEmail(dto.getEmail())) {
	        throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exists");
	    }

	    User user = new User();
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setUserName(dto.getUserName());
	    user.setPassword(passwordEncoder.encode(dto.getPassword()));

	    Set<Role> roles = new HashSet<>();
	    for (String roleName : dto.getRoles()) {
	        Role role = roleRepo.findByName(roleName)
	                .orElseThrow(() -> new BadRequestException(HttpStatus.BAD_REQUEST, "Role not found: " + roleName));
	        roles.add(role);
	    }

	    user.setRoles(roles);
	    userRepo.save(user);

	    return "Registration successful!";
	}

}
