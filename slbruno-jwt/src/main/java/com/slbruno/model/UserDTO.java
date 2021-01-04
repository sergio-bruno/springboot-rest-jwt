package com.slbruno.model;

import java.util.List;

public class UserDTO {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private List<DAOPhone> daoPhones;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DAOPhone> getDaoPhones() {
		return daoPhones;
	}

	public void setDaoPhones(List<DAOPhone> daoPhones) {
		this.daoPhones = daoPhones;
	}

}