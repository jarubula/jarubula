package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.daoImpl.SparePartsDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.SpareParts;

public class GetSparePartsDetails {
	
	public ArrayList<SpareParts> getSparePartSku(String email){
		SparePartsDao sdao=new SparePartsDaoImpl();
		ArrayList<SpareParts> spareParts = sdao.getSparePartSKU(email);
		return spareParts;
	}
	public SpareParts getSparePartDetails(String sku){
		SparePartsDao sdao=new SparePartsDaoImpl();
		SpareParts sp = sdao.getSparePartDetails(sku);
		return sp;
	}
	public ArrayList<SpareParts> getUsedCarBrand(String email){
		SparePartsDao cdao=new SparePartsDaoImpl();
		ArrayList<SpareParts> usedCarAl=cdao.getCarBrand(email);
		return usedCarAl;
	}
	public ArrayList<SpareParts> getSparePartsNames(String email){
		SparePartsDao sdao=new SparePartsDaoImpl();
		ArrayList<SpareParts> spareParts = sdao.getSparePartsNames(email);
		return spareParts;
	}
	public ArrayList<BusinessOwnerRegister> getCity(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<BusinessOwnerRegister> dealerAl = dDAO.getCity();
		return dealerAl;
	}
	public ArrayList<SpareParts> getVehicleBrand(String vehicleType){
		SparePartsDao dao=new SparePartsDaoImpl();
		ArrayList<SpareParts> vehicleBrand = dao.getVehicleBrand(vehicleType);
		return vehicleBrand;	
	}
	public ArrayList<SpareParts> getVehicleModel(String carModel){
		SparePartsDao cdao = new SparePartsDaoImpl();
		ArrayList<SpareParts> carModelAl = cdao.getVehicleModel(carModel);
		return carModelAl;
	}
	public ArrayList<SpareParts> getSpBrand(String vehicleType,String user_name){
		SparePartsDao dao=new SparePartsDaoImpl();
		ArrayList<SpareParts> vehicleBrand = dao.getSpBrand(vehicleType,user_name);
		return vehicleBrand;	
	}
	public ArrayList<SpareParts> getSpModel(String carModel,String user_name){
		SparePartsDao cdao = new SparePartsDaoImpl();
		ArrayList<SpareParts> carModelAl = cdao.getSpModel(carModel,user_name);
		return carModelAl;
	}
	public ArrayList<SpareParts> getCategory(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<SpareParts> spCAl = dDAO.getSpCategory();
		return spCAl;
	}
	public ArrayList<SpareParts> getPartNo(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<SpareParts> spp = dDAO.getSpPartNo();
		return spp;
	}
	public ArrayList<SpareParts> getCompanyName(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<SpareParts> spp = dDAO.getCompanyName();
		return spp;
	}
	public ArrayList<SpareParts> getModelYear(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<SpareParts> spp = dDAO.getModelYear();
		return spp;
	}
	public ArrayList<SpareParts> getSparePartName(){
		SparePartsDao dDAO = new SparePartsDaoImpl();
		ArrayList<SpareParts> spp = dDAO.getSparePartName();
		return spp;
	}
	public ArrayList<SpareParts> getSubCategory(String subCategory){
		SparePartsDao cdao = new SparePartsDaoImpl();
		ArrayList<SpareParts> carModelAl = cdao.getSubCategory(subCategory);
		return carModelAl;
	}
}
