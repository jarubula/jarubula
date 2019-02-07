package com.vaahanmitra.model;

public class UpdateServicePrice {
	
	private int SEQUENCE_NO;
	private String SERVICE_ID,SERVICE_TYPE;
	private String PRICE,DISCOUNT,FINAL_PRICE,SERVICE_CENTER_ID;
	
	
	public int getSEQUENCE_NO() {
		return SEQUENCE_NO;
	}
	public void setSEQUENCE_NO(int sEQUENCE_NO) {
		SEQUENCE_NO = sEQUENCE_NO;
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
	@Override
	public String toString() {
		return "UpdateServicePrice [SEQUENCE_NO=" + SEQUENCE_NO + ", SERVICE_ID=" + SERVICE_ID + ", SERVICE_TYPE="
				+ SERVICE_TYPE + ", PRICE=" + PRICE + ", DISCOUNT=" + DISCOUNT + ", FINAL_PRICE=" + FINAL_PRICE + "]";
	}
	public String getSERVICE_CENTER_ID() {
		return SERVICE_CENTER_ID;
	}
	public void setSERVICE_CENTER_ID(String sERVICE_CENTER_ID) {
		SERVICE_CENTER_ID = sERVICE_CENTER_ID;
	}
}
