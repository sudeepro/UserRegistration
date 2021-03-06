package com.sudeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudeep.entity.StateEntity;
import com.sudeep.entity.UserEntity;

public interface StateRepository extends JpaRepository<UserEntity, Integer> {

	
	List<StateEntity> findAllByCountryId(Integer countryId);

}
