package com.sudeep.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private long phNo;
	private LocalDate dob;
	private String gender;
	private String country;
	private String State;
	private String city;
}
