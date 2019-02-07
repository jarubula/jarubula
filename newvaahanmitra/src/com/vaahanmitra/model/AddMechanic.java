package com.vaahanmitra.model;

public class AddMechanic {
	private int MECHANIC_ID;
	private String PHONE_NO,OFFICE_NO,PINCODE_NO,BPINCODE_NO;
	private String FIRST_NAME,LAST_NAME,BUSINESS_NAME,PANCARD_NO,EMAIL_ID,ADDRESS,CITY,STATE,DISTRICT,BUSI_ADDRESS,BUSI_CITY,BUSI_STATE,BUSI_DISTRICT;

	
	public String getPINCODE_NO() {
		return PINCODE_NO;
	}
	public void setPINCODE_NO(String pINCODE_NO) {
		PINCODE_NO = pINCODE_NO;
	}
	public String getBPINCODE_NO() {
		return BPINCODE_NO;
	}
	public void setBPINCODE_NO(String bPINCODE_NO) {
		BPINCODE_NO = bPINCODE_NO;
	}
	public int getMECHANIC_ID() {
		return MECHANIC_ID;
	}
	public void setMECHANIC_ID(int mECHANIC_ID) {
		MECHANIC_ID = mECHANIC_ID;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
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
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
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
	public String getBUSI_ADDRESS() {
		return BUSI_ADDRESS;
	}
	public void setBUSI_ADDRESS(String bUSI_ADDRESS) {
		BUSI_ADDRESS = bUSI_ADDRESS;
	}
	public String getBUSI_CITY() {
		return BUSI_CITY;
	}
	public void setBUSI_CITY(String bUSI_CITY) {
		BUSI_CITY = bUSI_CITY;
	}
	public String getBUSI_STATE() {
		return BUSI_STATE;
	}
	public void setBUSI_STATE(String bUSI_STATE) {
		BUSI_STATE = bUSI_STATE;
	}
	public String getBUSI_DISTRICT() {
		return BUSI_DISTRICT;
	}
	public void setBUSI_DISTRICT(String bUSI_DISTRICT) {
		BUSI_DISTRICT = bUSI_DISTRICT;
	}
	
	public String getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public String getOFFICE_NO() {
		return OFFICE_NO;
	}
	public void setOFFICE_NO(String oFFICE_NO) {
		OFFICE_NO = oFFICE_NO;
	}
	@Override
	public String toString() {
		return "AddMechanic [MECHANIC_ID=" + MECHANIC_ID + ", PHONE_NO=" + PHONE_NO + ", OFFICE_NO=" + OFFICE_NO
				+ ", PINCODE_NO=" + PINCODE_NO + ", BPINCODE_NO=" + BPINCODE_NO + ", FIRST_NAME=" + FIRST_NAME
				+ ", LAST_NAME=" + LAST_NAME + ", BUSINESS_NAME=" + BUSINESS_NAME + ", PANCARD_NO=" + PANCARD_NO
				+ ", EMAIL_ID=" + EMAIL_ID + ", ADDRESS=" + ADDRESS + ", CITY=" + CITY + ", STATE=" + STATE
				+ ", DISTRICT=" + DISTRICT + ", BUSI_ADDRESS=" + BUSI_ADDRESS + ", BUSI_CITY=" + BUSI_CITY
				+ ", BUSI_STATE=" + BUSI_STATE + ", BUSI_DISTRICT=" + BUSI_DISTRICT + "]";
	}
}
