package com.Infy.WeCare.DTO;

import com.Infy.WeCare.Entity.User;

public class UserDTO {
	
	public UserDTO() {}
	
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.gender = user.getGender();
		this.dateOfBirth = user.getDateOfBirth().toString();
		this.password = user.getPassword();
		this.mobileNumber = user.getMobileNumber();
		this.email = user.getEmail();
		this.pincode = user.getPincode();
		this.city = user.getCity();
		this.state = user.getState();
		this.country = user.getCountry();
	}
	
	private int userId;
	private String name;
	private String gender;
	private String dateOfBirth;
	private String password;
	private long mobileNumber;
	private String email;
	private int pincode;
	private String city;
	private String state;
	private String country;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", email=" + email + ", pincode="
				+ pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

	
}
