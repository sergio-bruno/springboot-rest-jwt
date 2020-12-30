package com.slbruno.model;

public class PhonesDTO {
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
	private long number;
	private long area_code;
	private String country_code;

}
