package com.sudeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudeep.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	@Query(name="from UserEntity where email=:emailId")
	public UserEntity findByEmail(String emailId);

}
