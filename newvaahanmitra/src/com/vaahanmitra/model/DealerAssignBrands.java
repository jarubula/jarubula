package com.vaahanmitra.model;

public class DealerAssignBrands {

	private int SEQUENCE_NO;
	private String email;
	private String vehicleType;
	private String brand;
	private String model;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSEQUENCE_NO() {
		return SEQUENCE_NO;
	}
	public void setSEQUENCE_NO(int sEQUENCE_NO) {
		SEQUENCE_NO = sEQUENCE_NO;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
