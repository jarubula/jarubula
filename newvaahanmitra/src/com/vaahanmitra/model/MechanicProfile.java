package com.vaahanmitra.model;

public class MechanicProfile {
	private String PINCODE;
	private String MECHANIC_SEQ_ID;
	private String NAME,EMAIL, MOBILE_NO, QUALIFICATION, ADDRESS, CITY, DISTRICT, STATE, EXPERIENCE, SPECIALIZED_IN , BRAND_NAME, EXPERIENCE_WITH_COMPANIES, WORKED_IN_COMPANIES;
	public String getMECHANIC_SEQ_ID() {
		return MECHANIC_SEQ_ID;
	}
	public void setMECHANIC_SEQ_ID(String mECHANIC_SEQ_ID) {
		MECHANIC_SEQ_ID = mECHANIC_SEQ_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getQUALIFICATION() {
		return QUALIFICATION;
	}
	public void setQUALIFICATION(String qUALIFICATION) {
		QUALIFICATION = qUALIFICATION;
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
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getEXPERIENCE() {
		return EXPERIENCE;
	}
	public void setEXPERIENCE(String eXPERIENCE) {
		EXPERIENCE = eXPERIENCE;
	}
	public String getSPECIALIZED_IN() {
		return SPECIALIZED_IN;
	}
	public void setSPECIALIZED_IN(String sPECIALIZED_IN) {
		SPECIALIZED_IN = sPECIALIZED_IN;
	}
	public String getBRAND_NAME() {
		return BRAND_NAME;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		BRAND_NAME = bRAND_NAME;
	}
	public String getEXPERIENCE_WITH_COMPANIES() {
		return EXPERIENCE_WITH_COMPANIES;
	}
	public void setEXPERIENCE_WITH_COMPANIES(String eXPERIENCE_WITH_COMPANIES) {
		EXPERIENCE_WITH_COMPANIES = eXPERIENCE_WITH_COMPANIES;
	}
	public String getWORKED_IN_COMPANIES() {
		return WORKED_IN_COMPANIES;
	}
	public void setWORKED_IN_COMPANIES(String wORKED_IN_COMPANIES) {
		WORKED_IN_COMPANIES = wORKED_IN_COMPANIES;
	}
	public String getPINCODE() {
		return PINCODE;
	}
	public void setPINCODE(String pINCODE) {
		PINCODE = pINCODE;
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
	@Override
	public String toString() {
		return "MechanicProfile [PINCODE=" + PINCODE + ", MECHANIC_SEQ_ID="
				+ MECHANIC_SEQ_ID + ", NAME=" + NAME + ", EMAIL=" + EMAIL
				+ ", MOBILE_NO=" + MOBILE_NO + ", QUALIFICATION="
				+ QUALIFICATION + ", ADDRESS=" + ADDRESS + ", CITY=" + CITY
				+ ", DISTRICT=" + DISTRICT + ", STATE=" + STATE
				+ ", EXPERIENCE=" + EXPERIENCE + ", SPECIALIZED_IN="
				+ SPECIALIZED_IN + ", BRAND_NAME=" + BRAND_NAME
				+ ", EXPERIENCE_WITH_COMPANIES=" + EXPERIENCE_WITH_COMPANIES
				+ ", WORKED_IN_COMPANIES=" + WORKED_IN_COMPANIES + "]";
	}
}
