package com.vaahanmitra.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Bike implements Serializable{

	private String BIKE_ID,BIKE_BRAND,BIKE_MODEL,ENGINE_CAPACITY,ENGINE_TYPE,COOLING_SYSTEM,MAX_POWER,MILEAGE,MAX_TORQUE,ENGINE_STARTING,TRANSMISSION,BATTERY_CAPACITY,HEAD_LAMP,FRONT_BRAKE,REAR_BRAKE,FRONT_SUSPENSION,REAR_SUSPENSION,FRAME,FRONT_TYRE,REAR_TYRE,TYRE_TYPE,LENGTH,WIDTH,HEIGHT,WEIGHT,GROUND_CLEARANCE,PETROLTANK_CAPACITY,BIKE_DISCRIPTION;
	private BufferedImage PHOTO;
	public String getBIKE_ID() {
		return BIKE_ID;
	}
	public void setBIKE_ID(String bIKE_ID) {
		BIKE_ID = bIKE_ID;
	}
	public String getBIKE_BRAND() {
		return BIKE_BRAND;
	}
	public void setBIKE_BRAND(String bIKE_BRAND) {
		BIKE_BRAND = bIKE_BRAND;
	}
	public String getBIKE_MODEL() {
		return BIKE_MODEL;
	}
	public void setBIKE_MODEL(String bIKE_MODEL) {
		BIKE_MODEL = bIKE_MODEL;
	}
	public String getENGINE_CAPACITY() {
		return ENGINE_CAPACITY;
	}
	public void setENGINE_CAPACITY(String eNGINE_CAPACITY) {
		ENGINE_CAPACITY = eNGINE_CAPACITY;
	}
	public String getENGINE_TYPE() {
		return ENGINE_TYPE;
	}
	public void setENGINE_TYPE(String eNGINE_TYPE) {
		ENGINE_TYPE = eNGINE_TYPE;
	}
	public String getCOOLING_SYSTEM() {
		return COOLING_SYSTEM;
	}
	public void setCOOLING_SYSTEM(String cOOLING_SYSTEM) {
		COOLING_SYSTEM = cOOLING_SYSTEM;
	}
	public String getMAX_POWER() {
		return MAX_POWER;
	}
	public void setMAX_POWER(String mAX_POWER) {
		MAX_POWER = mAX_POWER;
	}
	public String getMILEAGE() {
		return MILEAGE;
	}
	public void setMILEAGE(String mILEAGE) {
		MILEAGE = mILEAGE;
	}
	public String getMAX_TORQUE() {
		return MAX_TORQUE;
	}
	public void setMAX_TORQUE(String mAX_TORQUE) {
		MAX_TORQUE = mAX_TORQUE;
	}
	public String getENGINE_STARTING() {
		return ENGINE_STARTING;
	}
	public void setENGINE_STARTING(String eNGINE_STARTING) {
		ENGINE_STARTING = eNGINE_STARTING;
	}
	public String getTRANSMISSION() {
		return TRANSMISSION;
	}
	public void setTRANSMISSION(String tRANSMISSION) {
		TRANSMISSION = tRANSMISSION;
	}
	public String getBATTERY_CAPACITY() {
		return BATTERY_CAPACITY;
	}
	public void setBATTERY_CAPACITY(String bATTERY_CAPACITY) {
		BATTERY_CAPACITY = bATTERY_CAPACITY;
	}
	public String getHEAD_LAMP() {
		return HEAD_LAMP;
	}
	public void setHEAD_LAMP(String hEAD_LAMP) {
		HEAD_LAMP = hEAD_LAMP;
	}
	public String getFRONT_BRAKE() {
		return FRONT_BRAKE;
	}
	public void setFRONT_BRAKE(String fRONT_BRAKE) {
		FRONT_BRAKE = fRONT_BRAKE;
	}
	public String getREAR_BRAKE() {
		return REAR_BRAKE;
	}
	public void setREAR_BRAKE(String rEAR_BRAKE) {
		REAR_BRAKE = rEAR_BRAKE;
	}
	public String getFRONT_SUSPENSION() {
		return FRONT_SUSPENSION;
	}
	public void setFRONT_SUSPENSION(String fRONT_SUSPENSION) {
		FRONT_SUSPENSION = fRONT_SUSPENSION;
	}
	public String getREAR_SUSPENSION() {
		return REAR_SUSPENSION;
	}
	public void setREAR_SUSPENSION(String rEAR_SUSPENSION) {
		REAR_SUSPENSION = rEAR_SUSPENSION;
	}
	public String getFRAME() {
		return FRAME;
	}
	public void setFRAME(String fRAME) {
		FRAME = fRAME;
	}
	public String getFRONT_TYRE() {
		return FRONT_TYRE;
	}
	public void setFRONT_TYRE(String fRONT_TYRE) {
		FRONT_TYRE = fRONT_TYRE;
	}
	public String getREAR_TYRE() {
		return REAR_TYRE;
	}
	public void setREAR_TYRE(String rEAR_TYRE) {
		REAR_TYRE = rEAR_TYRE;
	}
	public String getTYRE_TYPE() {
		return TYRE_TYPE;
	}
	public void setTYRE_TYPE(String tYRE_TYPE) {
		TYRE_TYPE = tYRE_TYPE;
	}
	public String getLENGTH() {
		return LENGTH;
	}
	public void setLENGTH(String lENGTH) {
		LENGTH = lENGTH;
	}
	public String getWIDTH() {
		return WIDTH;
	}
	public void setWIDTH(String wIDTH) {
		WIDTH = wIDTH;
	}
	public String getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(String hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public String getWEIGHT() {
		return WEIGHT;
	}
	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}
	public String getGROUND_CLEARANCE() {
		return GROUND_CLEARANCE;
	}
	public void setGROUND_CLEARANCE(String gROUND_CLEARANCE) {
		GROUND_CLEARANCE = gROUND_CLEARANCE;
	}
	public String getPETROLTANK_CAPACITY() {
		return PETROLTANK_CAPACITY;
	}
	public void setPETROLTANK_CAPACITY(String pETROLTANK_CAPACITY) {
		PETROLTANK_CAPACITY = pETROLTANK_CAPACITY;
	}
	public String getBIKE_DISCRIPTION() {
		return BIKE_DISCRIPTION;
	}
	public void setBIKE_DISCRIPTION(String bIKE_DISCRIPTION) {
		BIKE_DISCRIPTION = bIKE_DISCRIPTION;
	}
	public BufferedImage getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(BufferedImage pHOTO) {
		PHOTO = pHOTO;
	}
	@Override
	public String toString() {
		return "Bike [BIKE_ID=" + BIKE_ID + ", BIKE_BRAND=" + BIKE_BRAND + ", BIKE_MODEL=" + BIKE_MODEL
				+ ", ENGINE_CAPACITY=" + ENGINE_CAPACITY + ", ENGINE_TYPE=" + ENGINE_TYPE + ", COOLING_SYSTEM="
				+ COOLING_SYSTEM + ", MAX_POWER=" + MAX_POWER + ", MILEAGE=" + MILEAGE + ", MAX_TORQUE=" + MAX_TORQUE
				+ ", ENGINE_STARTING=" + ENGINE_STARTING + ", TRANSMISSION=" + TRANSMISSION + ", BATTERY_CAPACITY="
				+ BATTERY_CAPACITY + ", HEAD_LAMP=" + HEAD_LAMP + ", FRONT_BRAKE=" + FRONT_BRAKE + ", REAR_BRAKE="
				+ REAR_BRAKE + ", FRONT_SUSPENSION=" + FRONT_SUSPENSION + ", REAR_SUSPENSION=" + REAR_SUSPENSION
				+ ", FRAME=" + FRAME + ", FRONT_TYRE=" + FRONT_TYRE + ", REAR_TYRE=" + REAR_TYRE + ", TYRE_TYPE="
				+ TYRE_TYPE + ", LENGTH=" + LENGTH + ", WIDTH=" + WIDTH + ", HEIGHT=" + HEIGHT + ", WEIGHT=" + WEIGHT
				+ ", GROUND_CLEARANCE=" + GROUND_CLEARANCE + ", PETROLTANK_CAPACITY=" + PETROLTANK_CAPACITY
				+ ", BIKE_DISCRIPTION=" + BIKE_DISCRIPTION + ", PHOTO=" + PHOTO + "]";
	}
}
