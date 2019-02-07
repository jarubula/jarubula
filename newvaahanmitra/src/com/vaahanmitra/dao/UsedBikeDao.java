package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;

public interface UsedBikeDao {
	
	public String addUsedBike(UsedBike usedBike, InputStream is, ArrayList<InputStream> al, String user_name);
	public ArrayList<UsedBike>showDetails(String city, String brand, String model, String user_name,int offset, int noOfRecords);
	public UsedBike getUsedBikeDetails(String id);
	public String updateUsedBike(UsedBike usedBike,String id, String bikeId, String user_name);
	public Boolean getBikeNumber(String bikeNumber);
	public ArrayList<UsedBike> getBikeBrand();
	public ArrayList<UsedBike> getBikeModel(String bikeModel);
	public ArrayList<String> getUsedBikeCity(String brand, String model,String email);
	public UsedBike getBikeImages(String bike_number);
	public UsedBike getBikeDetails(String bikeId);
	public UsedBike getBikeOwnerDetails(String bikeId);
	public ArrayList<UsedBike> getBikeId(String email);
	public int getNoOfRecords();
	public ArrayList<UsedBike> getBikeBrands(String bikeBrand);
	public String showStatus(String bikeId, String status, String user_name);
	public ArrayList<UsedBike> getBikeModel(String bikeModel,String email);
	public HashMap<String, String> addDelaerUsedBike(UsedBike usedBike, InputStream is, ArrayList<InputStream> al,
			String user_name);
	public ArrayList<UsedBike> getBikeNo(String email);
	public String updateBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al);
}
