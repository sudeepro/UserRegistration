package com.sudeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudeep.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	List<CityEntity> findAllByStateId(Integer stateId);

}
