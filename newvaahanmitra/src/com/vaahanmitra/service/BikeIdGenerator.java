package com.vaahanmitra.service;

import java.util.Calendar;

import com.vaahanmitra.model.UsedBike;

public class BikeIdGenerator {

	public String generateBikeId(String state, String dbId) {

		String vm = "VMBK";
//		String state = bean.getREGISTERED_STATE();
		String state1 = null; 

		String id = dbId;
		// String id1 = id.substring(8);//VM2017AP0001000000000
		int i = Integer.parseInt(id);
		i++;
		String id2 = String.valueOf("000" + i);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String stryear = String.valueOf(year);

		switch (state.toLowerCase()) {

		case "andhra pradesh":
			state1 = "AP";
			break;
		case "arunachal pradesh":
			state1 = "AR";
			break;
		case "assam":
			state1 = "AS";
			break;
		case "bihar":
			state1 = "BR";
			break;
		case "chhattisgarh":
			state1 = "CG";
			break;
		case "goa":
			state1 = "GA";
			break;
		case "gujarat":
			state1 = "GJ";
			break;
		case "haryana":
			state1 = "HR";
			break;
		case "himachal Pradesh":
			state1 = "HP";
			break;
		case "jammu and Kashmir":
			state1 = "JK";
			break;
		case "jharkhand":
			state1 = "JH";
			break;
		case "karnataka":
			state1 = "KA";
			break;
		case "kerala":
			state1 = "KL";
			break;
		case "madhya Pradesh":
			state1 = "MP";
			break;
		case "maharashtra":
			state1 = "MH";
			break;
		case "manipur":
			state1 = "MN";
			break;
		case "meghalaya":
			state1 = "ML";
			break;
		case "mizoram":
			state1 = "MZ";
			break;
		case "nagaland":
			state1 = "NL";
			break;
		case "orissa":
			state1 = "OR";
			break;
		case "punjab":
			state1 = "PB";
			break;
		case "rajasthan":
			state1 = "RJ";
			break;
		case "sikkim":
			state1 = "SK";
			break;
		case "tamilnadu":
			state1 = "TN";
			break;
		case "tripura":
			state1 = "TR";
			break;
		case "telangana":
			state1 = "TS";
			break;
		case "uttarakhand":
			state1 = "UK";
			break;
		case "uttar Pradesh":
			state1 = "UP";
			break;
		case "west Bengal":
			state1 = "WB";
			break;
		case "andaman and Nicobar Islands":
			state1 = "AN";
			break;
		case "chandigarh":
			state1 = "CH";
			break;
		case "dadra and Nagar Haveli":
			state1 = "DH";
			break;
		case "daman and Diu":
			state1 = "DD";
			break;
		case "delhi":
			state1 = "DL";
			break;
		case "lakshadweep":
			state1 = "LD";
			break;
		case "pondicherry":
			state1 = "PY";
			break;
		default:
			state1 = "N";
		}
		String genId = vm + stryear + state1 + id2;
		return genId;
	}
}
