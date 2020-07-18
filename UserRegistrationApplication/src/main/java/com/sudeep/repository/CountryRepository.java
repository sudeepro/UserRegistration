package com.sudeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudeep.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
