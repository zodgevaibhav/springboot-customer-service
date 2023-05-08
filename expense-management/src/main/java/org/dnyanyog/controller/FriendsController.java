package org.dnyanyog.controller;

import org.dnyanyog.dto.request.FriendsRequest;
import org.dnyanyog.dto.response.FriendsResponse;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {

	@Autowired
	UserService userService;

	@PreAuthorize("hasRole('ROLE_GROUP_OWNER')")
	@PostMapping(path ="api/v1/create")
	public FriendsResponse createFriend(@RequestBody FriendsRequest request) {
		System.out.println(request.getFullName());
		System.out.println(request.getEmail());
		System.out.println(request.getMobile());
		userService.createFriend(request);
		
		FriendsResponse lp = new FriendsResponse();
		lp.setStatus("Success");
		lp.setMessage("User Account Created Successfully");
		lp.setUserId(request.getUserId());
		lp.setFullName(request.getFullName());
		lp.setEmail(request.getEmail());
		lp.setMobile(request.getMobile());
		lp.setCurrency(request.getCurrency());
		lp.setCountry(request.getCountry());
		lp.setLanguage(request.getLanguage());
       return lp;
	}

}

