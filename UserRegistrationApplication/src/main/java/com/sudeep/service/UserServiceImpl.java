package com.sudeep.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudeep.entity.CityEntity;
import com.sudeep.entity.CountryEntity;
import com.sudeep.entity.StateEntity;
import com.sudeep.entity.UserEntity;
import com.sudeep.model.User;
import com.sudeep.model.UserLogin;
import com.sudeep.repository.CityRepository;
import com.sudeep.repository.CountryRepository;
import com.sudeep.repository.StateRepository;
import com.sudeep.repository.UserLoginRepository;
import com.sudeep.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserLoginRepository loginRepo;
	private CountryRepository countryRepository;
	private StateRepository stateRepository;
	private CityRepository cityRepository;

	@Override
	public boolean saveUser(User user) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		if (user != null)
			entity.setAccountStatus("locked");
		entity.setPassword(RandomStringUtils.randomAlphanumeric(6));
		UserEntity savedEntity = userRepository.save(entity);
		return (savedEntity != null);
	}

	@Override
	public String sendMail() {
		return null;
	}

	@Override
	public String validateEmail(String emailId) {
		UserEntity entity = userRepository.findByEmail(emailId);
		return (entity == null) ? "Unique" : "Duplicate";
	}

	@Override
	public Map<Integer, String> getAllCountries() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		List<CountryEntity> countriesList = countryRepository.findAll();
		countriesList.forEach(countryEntity -> {
			map.put(countryEntity.getCountryId(), countryEntity.getCountryName());
		});

		return map;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		List<StateEntity> states = stateRepository.findAllByCountryId(countryId);

		states.forEach(state -> {
			statesMap.put(state.getStateId(), state.getStateName());
		});

		return statesMap;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {

		Map<Integer, String> citiesMap = new LinkedHashMap<Integer, String>();

		List<CityEntity> entitiesList = cityRepository.findAllByStateId(stateId);

		entitiesList.forEach(entity -> {
			citiesMap.put(entity.getCityId(), entity.getCityName());
		});

		return citiesMap;
	}

	@Override
	public UserLogin checkEmail(String email) {
		UserEntity entity = loginRepo.findByEmail(email);
		UserLogin userLogin = new UserLogin();
		BeanUtils.copyProperties(entity, userLogin);
		return userLogin;
	}

}
