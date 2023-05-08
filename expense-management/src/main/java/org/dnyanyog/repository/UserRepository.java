package org.dnyanyog.repository;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>
{

		Users findByFullName(String fullName);
		
		Users findByEmail(String email);
		Users findByMobileNo(String mobileNo);
		Users findByPassword(String password);
	
	}
