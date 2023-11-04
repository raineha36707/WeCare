package com.Infy.WeCare.DTO;

import com.Infy.WeCare.Entity.Coach;

public class CoachDTO {

	public CoachDTO() {}
	
	public CoachDTO(Coach coach) {
		this.coachId = coach.getCoachId();
		this.name = coach.getName();
		this.gender = coach.getGender();
		this.dateOfBirth = coach.getDateOfBirth().toString();
		this.password = coach.getPassword();
		this.mobileNumber = coach.getMobileNumber();
		this.speciality = coach.getSpeciality();
	}
	
	private int coachId;
	
	private String name;
	private String gender;
	private String dateOfBirth;
	private String password;
	private long mobileNumber;
	private String speciality;
	
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "CoachDTO [coachId=" + coachId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", speciality=" + speciality + "]";
	}
	
}
