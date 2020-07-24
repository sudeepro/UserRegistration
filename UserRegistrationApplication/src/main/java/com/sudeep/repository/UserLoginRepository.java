package com.sudeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudeep.entity.UserEntity;

public interface UserLoginRepository extends JpaRepository<UserEntity, String> {

	@Query("select u from UserEntity u where u.email=?1")
	public UserEntity findByEmail(String email);

}
