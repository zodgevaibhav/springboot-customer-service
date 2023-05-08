package org.dnyanyog.controller;

import org.dnyanyog.dto.request.LoginRequest;
import org.dnyanyog.dto.request.SignUpRequest;
import org.dnyanyog.dto.response.LoginResponse;
import org.dnyanyog.dto.response.SignUpResponse;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectoryController {
	
		@Autowired
		UserService userService;
		
		@Autowired
		AuthenticationManager authenticationManager;

		@PostMapping(path ="api/v1/signup", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest request) {
			System.out.println("*********** In side signup controller");
			return userService.saveData(request);
		}
		
		@PostMapping(path ="api/v1/validate")
		public LoginResponse login(@RequestBody LoginRequest request) {
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getMobile(), request.getPassword()));
			
			
			return userService.login(request);

		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/")
		public String login()
		{
			return "hello world!!";
		}

}
