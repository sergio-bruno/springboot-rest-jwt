package com.slbruno.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class DAOPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long number;
	@Column
	private long area_code;
	@Column
	private String country_code;

	@ManyToMany(mappedBy="daoPhones")
	private List<DAOUser> daoUsers = new ArrayList<>();	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public long getArea_code() {
		return area_code;
	}
	
	public void setArea_code(long area_code) {
		this.area_code = area_code;
	}
	
	public String getCountry_code() {
		return country_code;
	}
	
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public List<DAOUser> getDaoUsers() {
		return daoUsers;
	}

	public void setDaoUsers(List<DAOUser> daoUsers) {
		this.daoUsers = daoUsers;
	}


}
