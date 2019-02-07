package com.vaahanmitra.model;

public class UserInterestedVehicles {

	
	private int SEQ_NO;
	
	private String USER_EMAIL_ID,VEHICLES_SEQ_ID,VEHICLE_TYPE,DATE_CHOOSEN,PREFERRED_CITY;

	public int getSEQ_NO() {
		return SEQ_NO;
	}

	public void setSEQ_NO(int sEQ_NO) {
		SEQ_NO = sEQ_NO;
	}

	public String getUSER_EMAIL_ID() {
		return USER_EMAIL_ID;
	}

	public void setUSER_EMAIL_ID(String uSER_EMAIL_ID) {
		USER_EMAIL_ID = uSER_EMAIL_ID;
	}

	public String getVEHICLES_SEQ_ID() {
		return VEHICLES_SEQ_ID;
	}

	public void setVEHICLES_SEQ_ID(String vEHICLES_SEQ_ID) {
		VEHICLES_SEQ_ID = vEHICLES_SEQ_ID;
	}

	public String getVEHICLE_TYPE() {
		return VEHICLE_TYPE;
	}

	public void setVEHICLE_TYPE(String vEHICLE_TYPE) {
		VEHICLE_TYPE = vEHICLE_TYPE;
	}

	public String getDATE_CHOOSEN() {
		return DATE_CHOOSEN;
	}

	public void setDATE_CHOOSEN(String dATE_CHOOSEN) {
		DATE_CHOOSEN = dATE_CHOOSEN;
	}

	public String getPREFERRED_CITY() {
		return PREFERRED_CITY;
	}

	public void setPREFERRED_CITY(String pREFERRED_CITY) {
		PREFERRED_CITY = pREFERRED_CITY;
	}
	
	
}
