package com.vaahanmitra.model;

public class CarEndUser {
	private int ENDUSER_SEQ_ID;
	private String NAME;
	private String EMAIL;
	private String MOBILE_NO;
	private String VEHICLE_TYPE;
	private String PASSWORD;
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getVEHICLE_TYPE() {
		return VEHICLE_TYPE;
	}
	public void setVEHICLE_TYPE(String vEHICLE_TYPE) {
		VEHICLE_TYPE = vEHICLE_TYPE;
	}
	public int getENDUSER_SEQ_ID() {
		return ENDUSER_SEQ_ID;
	}
	public void setENDUSER_SEQ_ID(int eNDUSER_SEQ_ID) {
		ENDUSER_SEQ_ID = eNDUSER_SEQ_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getMOBILE_NO() {
		return MOBILE_NO;
	}
	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
	
	
}
