package org.dnyanyog.controller;

import org.dnyanyog.dto.request.GroupRequest;
import org.dnyanyog.dto.response.GroupResponse;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

	@Autowired
	UserService userService;
	
	@PostMapping(path ="api/v1/creategroup")
	public GroupResponse createFriend(@RequestBody GroupRequest request) {
		System.out.println(request.getGroupId());
		System.out.println(request.getGroupName());
		System.out.println(request.getGroupType());
		userService.createGroup(request);		
		GroupResponse lp = new GroupResponse();
		lp.setStatus("Success");
		lp.setMessage("Group Created Successfully");
		lp.setGroupId(request.getGroupId());
		lp.setGroupName(request.getGroupName());
		lp.setGroupType(request.getGroupType());
       return lp;
	}
	
	@PostMapping(path="api/v1/friends")
	public GroupResponse mappGroup(@RequestBody GroupRequest request)
	{
		System.out.println(request.getGroupId());
		System.out.println(request.getUserId());
		userService.createGroup(request);
		GroupResponse lp= new GroupResponse();
		lp.setGroupId(request.getGroupId());
	    lp.setUserId(request.getUserId());
		return lp;
	}
}
