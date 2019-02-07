package com.vaahanmitra.model;

public class UsedVehicleGetRequester {
	
	private String VEHICLE_ID,NAME,EMAIL,MOBILE_NO,REQUESTER_DATE,COUNT;

	
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
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

	public String getREQUESTER_DATE() {
		return REQUESTER_DATE;
	}

	public void setREQUESTER_DATE(String rEQUESTER_DATE) {
		REQUESTER_DATE = rEQUESTER_DATE;
	}

	public String getVEHICLE_ID() {
		return VEHICLE_ID;
	}
	public void setVEHICLE_ID(String vEHICLE_ID) {
		VEHICLE_ID = vEHICLE_ID;
	}
	@Override
	public String toString() {
		return "UsedVehicleGetRequester [VEHICLE_ID=" + VEHICLE_ID + ", NAME=" + NAME + ", EMAIL=" + EMAIL
				+ ", MOBILE_NO=" + MOBILE_NO + ", REQUESTER_DATE=" + REQUESTER_DATE + ", COUNT=" + COUNT + "]";
	}
}
