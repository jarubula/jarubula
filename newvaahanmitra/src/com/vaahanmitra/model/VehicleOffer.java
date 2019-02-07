package com.vaahanmitra.model;

public class VehicleOffer {
	
	private int SEQ_ID;
	private String	OFFER_NAME,	DESCRIPTION,	PRICE,	USER_ID,	NEW_VEHICLE_ID, STATUS;
	public int getSEQ_ID() {
		return SEQ_ID;
	}
	public void setSEQ_ID(int sEQ_ID) {
		SEQ_ID = sEQ_ID;
	}
	public String getOFFER_NAME() {
		return OFFER_NAME;
	}
	public void setOFFER_NAME(String oFFER_NAME) {
		OFFER_NAME = oFFER_NAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getNEW_VEHICLE_ID() {
		return NEW_VEHICLE_ID;
	}
	public void setNEW_VEHICLE_ID(String nEW_VEHICLE_ID) {
		NEW_VEHICLE_ID = nEW_VEHICLE_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
}
