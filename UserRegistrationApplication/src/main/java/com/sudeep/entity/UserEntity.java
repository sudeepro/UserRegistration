package com.sudeep.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name = "USER_MASTER")
@Data
public class UserEntity {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "FIRST_NAME")
	@NotBlank(message = "Required")
	@Size(min = 3, max = 20, message = "Size must be between 3-20")
	private String firstName;

	@Size(min = 3, max = 20, message = "Size must be between 3-20")
	@NotBlank(message = "Required")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "Email")
	@Email(message = "Enter your Email")
	@NotBlank(message = "Required")
	private String email;

	@Column(name = "PHONE_NUMBER")
	@NotBlank(message = "Required")
	@Size(min = 10, max = 10, message = "Enter 10 Digits Number")
	private Long phoneNo;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "COUNTRY")
	private Integer countryId;

	@Column(name = "STATE")
	private Integer StateId;

	@Column(name = "CITY")
	private Integer cityId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
