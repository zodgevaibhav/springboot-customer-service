package org.dnyanyog.security;

import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByMobileNo(username);
		return new User(user.getMobileNo(), user.getPassword(), getAuthority());
	}

	private List<GrantedAuthority> getAuthority()
	{
		ArrayList<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(new SimpleGrantedAuthority("GROUP_OWNER"));
		
		return roleList;
		
	}
	
}
