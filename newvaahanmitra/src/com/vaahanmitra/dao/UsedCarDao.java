package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Part;

import com.vaahanmitra.model.UsedCar;

public interface UsedCarDao {
	public UsedCar getUsedCarDetails(String id);
	public String updateUsedCar(UsedCar usedCar, /*InputStream is, ArrayList<InputStream> al,*/ String carId,
			String carNumber, String user_name);
	public String showStatus(String carId, String status, String user_name);
	public ArrayList<UsedCar> showDetails(String city, String brand, String model, String user_name, int offset,int noOfRecords);
	public String addUsedCar(UsedCar usedCar, ArrayList<InputStream> al,String user_name);	
//	public String addUsedCar(UsedCar usedCar, InputStream is, ArrayList<InputStream> al, String user_name);
	public HashMap<String,String> addUsedCar(UsedCar usedCar, InputStream is, ArrayList<InputStream> al, String user_name);
	public Boolean getCarNumber(String carNumber) ;
	public UsedCar getCarImages(String car_number);
	/*public ArrayList<UsedCar> getCarBrand();*/
	public ArrayList<UsedCar> getCarModel(String carModel);
	public ArrayList<UsedCar> getusedCarVariant(String brand,String model);
	public ArrayList<UsedCar> getUsedCarCity();
	public ArrayList<String> getUsedCarCity(String brand,String model,String email);
	public ArrayList<UsedCar> getCarId(String email);
	public UsedCar getCarDetails(String carId);
	public UsedCar getCarOwnerDetails(String carId);
	public ArrayList<UsedCar> getCarBrand(String email);
	public int getNoOfRecords();
	public ArrayList<UsedCar> getCarModel(String carModel, String email);
	public int[] getCarCountValue(String emailId, String vehicleType);
	public String getVehicleEmailId(String carId,String vehicleType);
	public HashMap<String,String> addDelaerUsedCar(UsedCar usedCar, InputStream is, ArrayList<InputStream> al, String user_name);
	public ArrayList<UsedCar> getCarNo(String email);
	public String updateCarPhotos(String carNo, InputStream is, ArrayList<InputStream> al);
}
