package com.vaahanmitra.model;

public class Registration {
	private int SERIAL_NO;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String GENDER;
	private String EMAIL;
	private String PHONE_NO;
	private String PANCARD_NO;
	private String ADDRESS;
	private String CITY;
	private String STATE;
	private String DISTRICT;
	private String PASSWORD;
	public int getSERIAL_NO() {
		return SERIAL_NO;
	}
	public void setSERIAL_NO(int sERIAL_NO) {
		SERIAL_NO = sERIAL_NO;
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
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public String getPANCARD_NO() {
		return PANCARD_NO;
	}
	public void setPANCARD_NO(String pANCARD_NO) {
		PANCARD_NO = pANCARD_NO;
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
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	@Override
	public String toString() {
		return "Registration [SERIAL_NO=" + SERIAL_NO + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", GENDER=" + GENDER + ", EMAIL=" + EMAIL + ", PHONE_NO=" + PHONE_NO + ", PANCARD_NO=" + PANCARD_NO
				+ ", ADDRESS=" + ADDRESS + ", CITY=" + CITY + ", STATE=" + STATE + ", DISTRICT=" + DISTRICT
				+ ", PASSWORD=" + PASSWORD + "]";
	}
}
