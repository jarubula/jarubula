package com.vaahanmitra.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Car implements Serializable
{
	
	private String SEQ_CARS_ID,CAR_BRAND,CAR_MODEL,ENGINE_CC,FUELTYPE,CITY_MILEAGE,HIGHWAY_MILEAGE,LENGTH_INCHES,WIDTH_INCHES,HEIGHT_INCHES,SEATING_CAPACITY,FUELTANK_CAPACITY,WHEEL_BASE,GROSS_VEHICLE_WEIGHT,TRANSMISSION_TYPE,NO_OF_GEARS;
	private BufferedImage PHOTO;
	public String getSEQ_CARS_ID() {
		return SEQ_CARS_ID;
	}
	public void setSEQ_CARS_ID(String sEQ_CARS_ID) {
		SEQ_CARS_ID = sEQ_CARS_ID;
	}
	public String getCAR_BRAND() {
		return CAR_BRAND;
	}
	public void setCAR_BRAND(String cAR_BRAND) {
		CAR_BRAND = cAR_BRAND;
	}
	public String getCAR_MODEL() {
		return CAR_MODEL;
	}
	public void setCAR_MODEL(String cAR_MODEL) {
		CAR_MODEL = cAR_MODEL;
	}
	public String getENGINE_CC() {
		return ENGINE_CC;
	}
	public void setENGINE_CC(String eNGINE_CC) {
		ENGINE_CC = eNGINE_CC;
	}
	public String getFUELTYPE() {
		return FUELTYPE;
	}
	public void setFUELTYPE(String fUELTYPE) {
		FUELTYPE = fUELTYPE;
	}
	public String getCITY_MILEAGE() {
		return CITY_MILEAGE;
	}
	public void setCITY_MILEAGE(String cITY_MILEAGE) {
		CITY_MILEAGE = cITY_MILEAGE;
	}
	public String getHIGHWAY_MILEAGE() {
		return HIGHWAY_MILEAGE;
	}
	public void setHIGHWAY_MILEAGE(String hIGHWAY_MILEAGE) {
		HIGHWAY_MILEAGE = hIGHWAY_MILEAGE;
	}
	public String getLENGTH_INCHES() {
		return LENGTH_INCHES;
	}
	public void setLENGTH_INCHES(String lENGTH_INCHES) {
		LENGTH_INCHES = lENGTH_INCHES;
	}
	public String getWIDTH_INCHES() {
		return WIDTH_INCHES;
	}
	public void setWIDTH_INCHES(String wIDTH_INCHES) {
		WIDTH_INCHES = wIDTH_INCHES;
	}
	public String getHEIGHT_INCHES() {
		return HEIGHT_INCHES;
	}
	public void setHEIGHT_INCHES(String hEIGHT_INCHES) {
		HEIGHT_INCHES = hEIGHT_INCHES;
	}
	public String getSEATING_CAPACITY() {
		return SEATING_CAPACITY;
	}
	public void setSEATING_CAPACITY(String sEATING_CAPACITY) {
		SEATING_CAPACITY = sEATING_CAPACITY;
	}
	public String getFUELTANK_CAPACITY() {
		return FUELTANK_CAPACITY;
	}
	public void setFUELTANK_CAPACITY(String fUELTANK_CAPACITY) {
		FUELTANK_CAPACITY = fUELTANK_CAPACITY;
	}
	public String getWHEEL_BASE() {
		return WHEEL_BASE;
	}
	public void setWHEEL_BASE(String wHEEL_BASE) {
		WHEEL_BASE = wHEEL_BASE;
	}
	public String getGROSS_VEHICLE_WEIGHT() {
		return GROSS_VEHICLE_WEIGHT;
	}
	public void setGROSS_VEHICLE_WEIGHT(String gROSS_VEHICLE_WEIGHT) {
		GROSS_VEHICLE_WEIGHT = gROSS_VEHICLE_WEIGHT;
	}
	public String getTRANSMISSION_TYPE() {
		return TRANSMISSION_TYPE;
	}
	public void setTRANSMISSION_TYPE(String tRANSMISSION_TYPE) {
		TRANSMISSION_TYPE = tRANSMISSION_TYPE;
	}
	public String getNO_OF_GEARS() {
		return NO_OF_GEARS;
	}
	public void setNO_OF_GEARS(String nO_OF_GEARS) {
		NO_OF_GEARS = nO_OF_GEARS;
	}
	public BufferedImage getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(BufferedImage pHOTO) {
		PHOTO = pHOTO;
	}
	@Override
	public String toString() {
		return "Car [SEQ_CARS_ID=" + SEQ_CARS_ID + ", CAR_BRAND=" + CAR_BRAND + ", CAR_MODEL=" + CAR_MODEL
				+ ", ENGINE_CC=" + ENGINE_CC + ", FUELTYPE=" + FUELTYPE + ", CITY_MILEAGE=" + CITY_MILEAGE
				+ ", HIGHWAY_MILEAGE=" + HIGHWAY_MILEAGE + ", LENGTH_INCHES=" + LENGTH_INCHES + ", WIDTH_INCHES="
				+ WIDTH_INCHES + ", HEIGHT_INCHES=" + HEIGHT_INCHES + ", SEATING_CAPACITY=" + SEATING_CAPACITY
				+ ", FUELTANK_CAPACITY=" + FUELTANK_CAPACITY + ", WHEEL_BASE=" + WHEEL_BASE + ", GROSS_VEHICLE_WEIGHT="
				+ GROSS_VEHICLE_WEIGHT + ", TRANSMISSION_TYPE=" + TRANSMISSION_TYPE + ", NO_OF_GEARS=" + NO_OF_GEARS
				+ ", PHOTO=" + PHOTO + "]";
	}
}