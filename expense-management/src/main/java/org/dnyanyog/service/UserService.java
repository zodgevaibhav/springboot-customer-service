package org.dnyanyog.service;

import org.dnyanyog.dto.request.FriendsRequest;
import org.dnyanyog.dto.request.GroupRequest;
import org.dnyanyog.dto.request.LoginRequest;
import org.dnyanyog.dto.request.SignUpRequest;
import org.dnyanyog.dto.response.GroupResponse;
import org.dnyanyog.dto.response.LoginResponse;
import org.dnyanyog.dto.response.SignUpResponse;
import org.dnyanyog.dto.response.UserFails;
import org.dnyanyog.entity.GroupInformation;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.GroupRepository;
import org.dnyanyog.repository.UserRepository;
import org.dnyanyog.security.JwtUtil;
import org.dnyanyog.security.UserDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final Logger logger =  LoggerFactory.getLogger(UserService.class);


	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Users user;

	@Autowired
	UserDetailServiceImpl userDetailService;
	@Autowired
	LoginResponse loginResponse;
	
	@Autowired
	LoginResponse loginResponseFails;
	@Autowired
	UserFails fails;
	@Autowired
	GroupResponse groupResponse;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	GroupInformation groupInformation;
	
	@Autowired
	JwtUtil jwtUtil;
   
/**
 * Req-1: If no email and no mobile present in db then create new user
 * Req-2: If email or mobile already present and password is empty then create new user (Friend must have already created, allow him to signUp)
 * Req-3: If email or mobile already present and password also present then do not allow to create user
 */
public ResponseEntity<SignUpResponse> saveData(final SignUpRequest request) {
	System.out.println("****************************");
	System.out.println("****************************");
	System.out.println("****************************");
	System.out.println("****************************");
		
//	SignUpResponse response = new SignUpResponse();
	
	SignUpResponse response = SignUpResponse.getSignUpObject(); // Factory design pattern
	
	
	//SignUpResponse response = SignUpResponse.getSignUpObject();
		
//	response.setData(new UserData());	
		
		//Req-1
			user = new Users();
			// Req-3
			if(null != userRepository.findByEmail(request.getEmail()) && null != userRepository.findByEmail(request.getEmail()).getPassword())
				return 	getConflictSignUpResponse();
			// Req-3
			if(null != userRepository.findByMobileNo(request.getMobile()) && null != userRepository.findByMobileNo(request.getMobile()).getPassword())
				return 	getConflictSignUpResponse();
			
			//Req-2: for email id is present but password not set (friend created using email id)
			if(null != userRepository.findByEmail(request.getEmail()) && null == userRepository.findByEmail(request.getEmail()).getPassword())
			{
				user = userRepository.findByEmail(request.getEmail());
			}		
			//Req-2: for mobile is present but password not set (friend created using mobile)
			if(null != userRepository.findByMobileNo(request.getMobile()) && null == userRepository.findByMobileNo(request.getMobile()).getPassword())
			{
				user = userRepository.findByMobileNo(request.getMobile());
			}
		user.setCurrency(request.getCurrency());
		user.setCountry(request.getCountry());
		user.setFullName(request.getFullName());
		user.setEmail(request.getEmail());
		user.setLanguage(request.getLanguage());
		user.setMobileNo(request.getMobile());
		user.setPassword(request.getPassword());

		user = userRepository.save(user);		
		
		response.setStatus("success");
		response.setMessage("User account created successfully");
		response.getData().setCountry(user.getCountry());
		response.getData().setCurrency(user.getCurrency());
		response.getData().setEmail(user.getEmail());
		response.getData().setFullName(user.getFullName());
		response.getData().setLanguage(user.getLanguage());
		response.getData().setMobile(user.getMobileNo());
		response.getData().setUserId(user.getUserId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

public LoginResponse login(LoginRequest request) {
	if (null != userRepository.findByEmail(request.getEmail())&& null != userRepository.findByMobileNo(request.getMobile())) {

		user.setEmail(request.getEmail());
		user.setMobileNo(request.getMobile());
		user.setPassword(request.getPassword());

		user = userRepository.findByEmail(request.getEmail());
		user = userRepository.findByMobileNo(request.getMobile());
		user = userRepository.findByPassword(request.getPassword());
		loginResponse.setStatus("success");
		loginResponse.setMessage("Validation successfull");
		loginResponse.getData().setCountry(user.getCountry());
		loginResponse.getData().setCurrency(user.getCurrency());
		loginResponse.getData().setEmail(user.getEmail());
		loginResponse.getData().setFullName(user.getFullName());
		loginResponse.getData().setLanguage(user.getLanguage());
		loginResponse.getData().setMobile(user.getMobileNo());
		//loginResponse.getData().setUserId(user.getUserId());
		loginResponse.setErrors(null);
		
		loginResponse.setJwt(jwtUtil.generateToken(userDetailService.loadUserByUsername(user.getMobileNo())));
		
		return loginResponse;
		
		
	}
	loginResponseFails.setStatus("error");
	loginResponseFails.setMessage("Validation failed");
	loginResponseFails.setData(null);
   
	loginResponseFails.getErrors().setField("email");
	loginResponseFails.getErrors().setMessage("Email is not valid");
	loginResponseFails.getErrors().setMessage("mobile");
	loginResponseFails.getErrors().setMessage("Mobile number is required");
	

	return loginResponseFails;
	
}

  public void createFriend(FriendsRequest request) {
	user.setFullName(request.getFullName());
	user.setEmail(request.getEmail());
	user.setMobileNo(request.getMobile());
	userRepository.save(user);
}
  
  public void createGroup(GroupRequest request) {
	 groupResponse.setGroupId(request.getGroupId());
	 groupResponse.setGroupName(request.getGroupName());
	 groupResponse.setGroupType(request.getGroupType());
	 groupRepository.save(groupInformation);

  }
  
  private ResponseEntity<SignUpResponse> getConflictSignUpResponse()
  {
	  SignUpResponse response = new SignUpResponse();
		response.setStatus("error");
		response.setMessage("Email or mobile number already registered");
		response.setData(null);
	
		return 	ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }
  

}
