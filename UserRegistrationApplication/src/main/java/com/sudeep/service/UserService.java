package com.sudeep.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.sudeep.model.User;

@Service
public interface UserService {

	public boolean saveUser(User user);

	public String sendMail();

	public String validateEmail(String emailId);

	Map<Integer, String> getAllCountries();

	Map<Integer, String> getStatesByCountryId(Integer countryId);

	Map<Integer, String> getCitiesByStateId(Integer stateId);

}
