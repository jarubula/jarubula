package com.vaahanmitra.model;

public class ServiceType {
	private String SERVICE_ID,SERVICE_TYPE,SERVICE_DESCRIPTION;
	private int SEQ_SERVICE_ID;
	private String VEHICLE_TYPE,VEHICLE_BRAND,PRICE,DISCOUNT,FINAL_PRICE,SERVICE_CENTER_ID;

	public String getSERVICE_DESCRIPTION() {
		return SERVICE_DESCRIPTION;
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


	public void setSERVICE_DESCRIPTION(String sERVICE_DESCRIPTION) {
		SERVICE_DESCRIPTION = sERVICE_DESCRIPTION;
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


	public int getSEQ_SERVICE_ID() {
		return SEQ_SERVICE_ID;
	}

	public void setSEQ_SERVICE_ID(int sEQ_SERVICE_ID) {
		SEQ_SERVICE_ID = sEQ_SERVICE_ID;
	}


	@Override
	public String toString() {
		return "ServiceType [SERVICE_ID=" + SERVICE_ID + ", SERVICE_TYPE=" + SERVICE_TYPE + ", SERVICE_DESCRIPTION="
				+ SERVICE_DESCRIPTION + ", SEQ_SERVICE_ID=" + SEQ_SERVICE_ID + ", VEHICLE_TYPE=" + VEHICLE_TYPE
				+ ", VEHICLE_BRAND=" + VEHICLE_BRAND + "]";
	}

	public String getSERVICE_CENTER_ID() {
		return SERVICE_CENTER_ID;
	}

	public void setSERVICE_CENTER_ID(String sERVICE_CENTER_ID) {
		SERVICE_CENTER_ID = sERVICE_CENTER_ID;
	}

}
