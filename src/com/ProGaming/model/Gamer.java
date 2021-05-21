package com.ProGaming.model;

public class Gamer {
	
	//	CUstomer fields
	private Integer Id;
	private String fname;
	private String lname;
	private String username;
	private String pass;
	private String email;
	private String dob;
	private String country;
	
	//Setters and Getters
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
//	toString method
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", pass="
				+ pass + ", email=" + email + ", dob=" + dob + ", country=" + country + "]";
	}
}
