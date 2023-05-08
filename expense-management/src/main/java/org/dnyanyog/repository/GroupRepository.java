package org.dnyanyog.repository;

import org.dnyanyog.entity.GroupInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupInformation,Long>
{

	GroupInformation findByGroupId(int GroupId);
	GroupInformation findByGroupName(String GroupName);
	
}
