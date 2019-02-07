package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;

import com.vaahanmitra.model.BusinessOwnerRegister;

public interface SearchHUsedVehicleDealerDAO {
	
	public ArrayList<BusinessOwnerRegister> getCity();
	public ArrayList<BusinessOwnerRegister> getDealerName(String city);
	public ArrayList<BusinessOwnerRegister> getUsedVehicleDealerDetails(String query);
	public ArrayList<BusinessOwnerRegister> searchHUsedVehicleDealer(BusinessOwnerRegister bean);
	public ArrayList<BusinessOwnerRegister> searchHUsedVehicleDealer(BusinessOwnerRegister bean,int offset,int noOfRecords);
	public int getNoOfRecords();
	
	String addDocument(String user_name, String brand, String documentName,String v_type, InputStream is);
	 public boolean checkbranddoc(String user_id,String brand,String v_type);
}
