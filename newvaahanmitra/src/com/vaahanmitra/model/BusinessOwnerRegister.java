package com.vaahanmitra.model;

public class BusinessOwnerRegister {
	private int SEQUENTIAL_NO,  OFFICE_PINCODE_NO, PINCODE_NO;
	private String USER_TYPE, BUSINESS_NAME, PANCARD_NO, CITY, ADDRESS, B_CITY, STATE, DISTRICT, OFFICE_PHONE_NO, NAME, MOBILE_NO, EMAIL_ID,PASSWORD;
	private String STATUS,VERIFIED,LOCATION;
	private String VEHICLE_TYPE,GSTNO;
	private String PHOTO;
	
	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getSTATUS() {
		return STATUS;
	}
	
	public String getVEHICLE_TYPE() {
		return VEHICLE_TYPE;
	}

	public void setVEHICLE_TYPE(String vEHICLE_TYPE) {
		VEHICLE_TYPE = vEHICLE_TYPE;
	}

	public String getPHOTO() {
		return PHOTO;
	}

	public void setPHOTO(String pHOTO) {
		PHOTO = pHOTO;
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
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getSEQUENTIAL_NO() {
		return SEQUENTIAL_NO;
	}
	public void setSEQUENTIAL_NO(int sEQUENTIAL_NO) {
		SEQUENTIAL_NO = sEQUENTIAL_NO;
	}
	public int getOFFICE_PINCODE_NO() {
		return OFFICE_PINCODE_NO;
	}
	public void setOFFICE_PINCODE_NO(int oFFICE_PINCODE_NO) {
		OFFICE_PINCODE_NO = oFFICE_PINCODE_NO;
	}
	public int getPINCODE_NO() {
		return PINCODE_NO;
	}
	public void setPINCODE_NO(int pINCODE_NO) {
		PINCODE_NO = pINCODE_NO;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	public String getBUSINESS_NAME() {
		return BUSINESS_NAME;
	}
	public void setBUSINESS_NAME(String bUSINESS_NAME) {
		BUSINESS_NAME = bUSINESS_NAME;
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
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getB_CITY() {
		return B_CITY;
	}
	public void setB_CITY(String b_CITY) {
		B_CITY = b_CITY;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getOFFICE_PHONE_NO() {
		return OFFICE_PHONE_NO;
	}
	public void setOFFICE_PHONE_NO(String oFFICE_PHONE_NO) {
		OFFICE_PHONE_NO = oFFICE_PHONE_NO;
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

	@Override
	public String toString() {
		return "BusinessOwnerRegister [SEQUENTIAL_NO=" + SEQUENTIAL_NO + ", OFFICE_PINCODE_NO=" + OFFICE_PINCODE_NO
				+ ", PINCODE_NO=" + PINCODE_NO + ", USER_TYPE=" + USER_TYPE + ", BUSINESS_NAME=" + BUSINESS_NAME
				+ ", PANCARD_NO=" + PANCARD_NO + ", CITY=" + CITY + ", ADDRESS=" + ADDRESS + ", B_CITY=" + B_CITY
				+ ", STATE=" + STATE + ", DISTRICT=" + DISTRICT + ", OFFICE_PHONE_NO=" + OFFICE_PHONE_NO + ", NAME="
				+ NAME + ", MOBILE_NO=" + MOBILE_NO + ", EMAIL_ID=" + EMAIL_ID + ", PASSWORD=" + PASSWORD + ", STATUS="
				+ STATUS + ", VERIFIED=" + VERIFIED + ", LOCATION=" + LOCATION + ", VEHICLE_TYPE=" + VEHICLE_TYPE
				+ ", PHOTO=" + PHOTO + "]";
	}

	public String getGSTNO() {
		return GSTNO;
	}

	public void setGSTNO(String gSTNO) {
		GSTNO = gSTNO;
	}
}
