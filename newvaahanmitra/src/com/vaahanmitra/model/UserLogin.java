package com.vaahanmitra.model;

public class UserLogin {
	
	private int SEQUENCE_NO;
	private String EMAIL_ID , PASSWORD, USER_TYPE,REFERENCE_ID,STATUS;
	
	
	public String getREFERENCE_ID() {
		return REFERENCE_ID;
	}
	public void setREFERENCE_ID(String rEFERENCE_ID) {
		REFERENCE_ID = rEFERENCE_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public int getSEQUENCE_NO() {
		return SEQUENCE_NO;
	}
	public void setSEQUENCE_NO(int sEQUENCE_NO) {
		SEQUENCE_NO = sEQUENCE_NO;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	@Override
	public String toString() {
		return "UserLogin [SEQUENCE_NO=" + SEQUENCE_NO + ", EMAIL_ID=" + EMAIL_ID + ", PASSWORD=" + PASSWORD
				+ ", USER_TYPE=" + USER_TYPE + ", REFERENCE_ID=" + REFERENCE_ID + ", STATUS=" + STATUS + "]";
	}
	
}
