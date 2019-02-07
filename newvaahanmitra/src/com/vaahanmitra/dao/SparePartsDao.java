package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.SpareParts;

public interface SparePartsDao {
	public String addSpareParts(SpareParts spareParts, String user_name, InputStream is);

	public String checkSKU(String sku);

	public ArrayList<SpareParts> getSparePartSKU(String email);

	public ArrayList<SpareParts> getSPDetails(String sku, String user_name);

	public SpareParts getSparePartDetails(String sku);

	public String updateSPPrice(List<SpareParts> list, String user_name);

	public ArrayList<SpareParts> getCarBrand(String email);

//	public ArrayList<SpareParts> getCarModel(String carModel);

	public ArrayList<SpareParts> searchSPDetails(SpareParts sp, String user_name, int i, int maxrowsperpage);

	public ArrayList<SpareParts> getSparePartsNames(String email);

	public ArrayList<BusinessOwnerRegister> getCity();

	public ArrayList<SpareParts> getVehicleBrand(String vehicleType);

	public ArrayList<SpareParts> getVehicleModel(String carModel);

	public ArrayList<SpareParts> getSpCategory();

	public ArrayList<SpareParts> searchSpareParts(SpareParts sp);

	public ArrayList<SpareParts> getSpBrand(String vehicleType, String user_name);

	public ArrayList<SpareParts> getSpModel(String carModel, String user_name);

	public ArrayList<SpareParts> getSpPartNo();

	public ArrayList<SpareParts> getCompanyName();

	public ArrayList<SpareParts> getModelYear();
	
	public ArrayList<SpareParts> getSparePartName();

	public ArrayList<SpareParts> getSubCategory(String subCategory);
	
	public int getNoOfRecords();
	
	public String updateSpareParts(SpareParts spareParts, String user_name, InputStream is);

	public String setStatus(String sku, String status, String user_name);

}
