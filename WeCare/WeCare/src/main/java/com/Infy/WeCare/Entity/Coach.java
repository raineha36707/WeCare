package com.Infy.WeCare.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Infy.WeCare.DTO.CoachDTO;

@Entity
@Table(name = "coachtable")
public class Coach {
	
	public Coach() {}
	
	public Coach(CoachDTO coach) {
		this.coachId = coach.getCoachId();
		this.name = coach.getName();
		this.gender = coach.getGender();
		// YYYY-MM-DD
		this.dateOfBirth = LocalDate.parse(coach.getDateOfBirth());
		this.password = coach.getPassword();
		this.mobileNumber = coach.getMobileNumber();
		this.speciality = coach.getSpeciality();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coachId;
	
	private String name;
	private String gender;
	private LocalDate dateOfBirth;
	private String password;
	@Column(unique = true)
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
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
		return "Coach [coachId=" + coachId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", speciality=" + speciality + "]";
	}
	
	
}
