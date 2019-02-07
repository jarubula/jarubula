package com.vaahanmitra.model;

public class ServiceMechanic {

	private int SEQ_SERVICE_ID;
	private String SERVICE_ID;
	private String SERVICE_TYPE;
	private String SERVICE_DESCRIPTION;
	private String VEHICLE_TYPE;
	private String VEHICLE_BRAND;
	private int SEQUENCE_NO;
	private String PRICE;
	private String DISCOUNT;
	private String FINAL_PRICE;
	private int SEQ_SELECTED_VEHICLE_DETAILS;
	private String SELECTED_VEHICLE_TYPE;
	private String  REFERENCE_ID;
	private String BRAND;
	private String MODEL;
	private String ADDRESS;
	public int getSEQ_SERVICE_ID() {
		return SEQ_SERVICE_ID;
	}
	public void setSEQ_SERVICE_ID(int sEQ_SERVICE_ID) {
		SEQ_SERVICE_ID = sEQ_SERVICE_ID;
	}
	public String getSERVICE_ID() {
		return SERVICE_ID;
	}
	public void setSERVICE_ID(String sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
	}
	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}
	public void setSERVICE_TYPE(String sERVICE_TYPE) {
		SERVICE_TYPE = sERVICE_TYPE;
	}
	public String getSERVICE_DESCRIPTION() {
		return SERVICE_DESCRIPTION;
	}
	public void setSERVICE_DESCRIPTION(String sERVICE_DESCRIPTION) {
		SERVICE_DESCRIPTION = sERVICE_DESCRIPTION;
	}
	public String getVEHICLE_TYPE() {
		return VEHICLE_TYPE;
	}
	public void setVEHICLE_TYPE(String vEHICLE_TYPE) {
		VEHICLE_TYPE = vEHICLE_TYPE;
	}
	public String getVEHICLE_BRAND() {
		return VEHICLE_BRAND;
	}
	public void setVEHICLE_BRAND(String vEHICLE_BRAND) {
		VEHICLE_BRAND = vEHICLE_BRAND;
	}
	public int getSEQUENCE_NO() {
		return SEQUENCE_NO;
	}
	public void setSEQUENCE_NO(int sEQUENCE_NO) {
		SEQUENCE_NO = sEQUENCE_NO;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}
	public String getDISCOUNT() {
		return DISCOUNT;
	}
	public void setDISCOUNT(String dISCOUNT) {
		DISCOUNT = dISCOUNT;
	}
	public String getFINAL_PRICE() {
		return FINAL_PRICE;
	}
	public void setFINAL_PRICE(String fINAL_PRICE) {
		FINAL_PRICE = fINAL_PRICE;
	}
	public int getSEQ_SELECTED_VEHICLE_DETAILS() {
		return SEQ_SELECTED_VEHICLE_DETAILS;
	}
	public void setSEQ_SELECTED_VEHICLE_DETAILS(int sEQ_SELECTED_VEHICLE_DETAILS) {
		SEQ_SELECTED_VEHICLE_DETAILS = sEQ_SELECTED_VEHICLE_DETAILS;
	}
	public String getSELECTED_VEHICLE_TYPE() {
		return SELECTED_VEHICLE_TYPE;
	}
	public void setSELECTED_VEHICLE_TYPE(String sELECTED_VEHICLE_TYPE) {
		SELECTED_VEHICLE_TYPE = sELECTED_VEHICLE_TYPE;
	}
	public String getREFERENCE_ID() {
		return REFERENCE_ID;
	}
	public void setREFERENCE_ID(String rEFERENCE_ID) {
		REFERENCE_ID = rEFERENCE_ID;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}
	public String getMODEL() {
		return MODEL;
	}
	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	@Override
	public String toString() {
		return "ServiceMechanic [SEQ_SERVICE_ID=" + SEQ_SERVICE_ID + ", SERVICE_ID=" + SERVICE_ID + ", SERVICE_TYPE="
				+ SERVICE_TYPE + ", SERVICE_DESCRIPTION=" + SERVICE_DESCRIPTION + ", VEHICLE_TYPE=" + VEHICLE_TYPE
				+ ", VEHICLE_BRAND=" + VEHICLE_BRAND + ", SEQUENCE_NO=" + SEQUENCE_NO + ", PRICE=" + PRICE
				+ ", DISCOUNT=" + DISCOUNT + ", FINAL_PRICE=" + FINAL_PRICE + ", SEQ_SELECTED_VEHICLE_DETAILS="
				+ SEQ_SELECTED_VEHICLE_DETAILS + ", SELECTED_VEHICLE_TYPE=" + SELECTED_VEHICLE_TYPE + ", REFERENCE_ID="
				+ REFERENCE_ID + ", BRAND=" + BRAND + ", MODEL=" + MODEL + ", ADDRESS=" + ADDRESS + "]";
	}
	
}
