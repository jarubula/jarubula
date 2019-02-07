package com.vaahanmitra.dao;

import java.util.ArrayList;
import java.util.List;

import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.UsedBike;

public interface SearchHUsedBikeDAO {

	public ArrayList<UsedBike> getUsedBikeDetails(String query);
	public ArrayList<UsedBike> searchHUsedBike(UsedBike bean, int offset, int noOfRecords);
	public ArrayList<UsedBike> getBikeBrand();
	public ArrayList<UsedBike> getBikeModel(String bikeModel);
	public ArrayList<UsedBike> getBikeVariant(String bikeBrand,String bikeModel);
	public ArrayList<UsedBike> getUsedBikeCity();
	public ArrayList<UsedBike> getUsedBikeBudget(String budget);
	public String insertEndUserDetails(BikeEndUser endUser,String bikeId);
	public ArrayList<UsedBike> compareUsedBike(ArrayList bikeId);
	public ArrayList<UsedBike> getBikeImage(String bikeNumber);
	public ArrayList<UsedBike> searchHDealerUsedBike(UsedBike bean, int offset, int noOfRecords);
	public String varifyEmailId(String bikeId, String email, String mobileNo);
	public ArrayList<UsedBike> searchUsedBike(String brand);
	public ArrayList<String> getRequesters(String email);
	public String insertUserRequest(BikeEndUser endUser, String bikeId);
	public int getNoOfRecords();
	public List<UsedBike> getUsedBikeDetailsByCarNo(String bikeNo);
	public List<UsedBike> getUsedBikeByBikeNo(String brand, String price, String kmsDriver, String bikeNo);
	public List<UsedBike> getDealerUsedBike(String brand, String price, String kmsDriver, String bikeNo, String demail);
}
