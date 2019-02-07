package com.vaahanmitra.model;

public class IndividualOwnerRegister {
	
	private int SEQUENTIAL_NO;
	private String USER_TYPE, PANCARD_NO, CITY, PINCODE_NO, VEHICAL_TYPE, NAME, MOBILE_NO, EMAIL_ID,REGISTRATION_DATE;
	private String STATUS,VERIFIED,PASSWORD;
	
	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public int getSEQUENTIAL_NO() {
		return SEQUENTIAL_NO;
	}
	
	public String getREGISTRATION_DATE() {
		return REGISTRATION_DATE;
	}

	public void setREGISTRATION_DATE(String rEGISTRATION_DATE) {
		REGISTRATION_DATE = rEGISTRATION_DATE;
	}

	public void setSEQUENTIAL_NO(int sEQUENTIAL_NO) {
		SEQUENTIAL_NO = sEQUENTIAL_NO;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	public String getPANCARD_NO() {
		return PANCARD_NO;
	}
	public void setPANCARD_NO(String pANCARD_NO) {
		PANCARD_NO = pANCARD_NO;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getPINCODE_NO() {
		return PINCODE_NO;
	}
	public void setPINCODE_NO(String pINCODE_NO) {
		PINCODE_NO = pINCODE_NO;
	}
	public String getVEHICAL_TYPE() {
		return VEHICAL_TYPE;
	}
	public void setVEHICAL_TYPE(String vEHICAL_TYPE) {
		VEHICAL_TYPE = vEHICAL_TYPE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getMOBILE_NO() {
		return MOBILE_NO;
	}
	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getVERIFIED() {
		return VERIFIED;
	}
	public void setVERIFIED(String vERIFIED) {
		VERIFIED = vERIFIED;
	}

	@Override
	public String toString() {
		return "IndividualOwnerRegister [SEQUENTIAL_NO=" + SEQUENTIAL_NO + ", USER_TYPE=" + USER_TYPE + ", PANCARD_NO="
				+ PANCARD_NO + ", CITY=" + CITY + ", PINCODE_NO=" + PINCODE_NO + ", VEHICAL_TYPE=" + VEHICAL_TYPE
				+ ", NAME=" + NAME + ", MOBILE_NO=" + MOBILE_NO + ", EMAIL_ID=" + EMAIL_ID + ", REGISTRATION_DATE="
				+ REGISTRATION_DATE + ", STATUS=" + STATUS + ", VERIFIED=" + VERIFIED + ", PASSWORD=" + PASSWORD + "]";
	}
}
