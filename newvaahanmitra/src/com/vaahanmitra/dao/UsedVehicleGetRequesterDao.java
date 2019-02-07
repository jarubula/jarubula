package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UsedVehicleGetRequester;

public interface UsedVehicleGetRequesterDao {
	public ArrayList<UsedVehicleGetRequester>  getCarId(String carId,String user_name);

//	public ArrayList<UsedVehicleGetRequester> searchByDate(String carId, Date fdate, Date tdate);

	public ArrayList<UsedVehicleGetRequester> searchByDate(String carId, String fdate, String tdate,String user_name);

	public ArrayList<UsedVehicleGetRequester> getBikeRequest(String bikeId,String user_name);

	public ArrayList<UsedVehicleGetRequester> searchBikeByDate(String bikeId, String fdate, String tdate, String user_name);

	public String getCarCount(String carId, String fdate, String tdate, String user_name);

	public String getCarCount(String carId, String user_name);

	public String getBikesCount(String bikeId, String user_name);

	public String getBikeCount(String bikeId, String fdate, String tdate, String user_name);
	
	public String getBikeRequestCount(String bikeId, String user_name);

	public ArrayList<UsedCar> searchCarRequester(String fdate, String tdate, String vehicleType,
			String user_name);
	public int getCarVisitors(String carId, char vehicleType);

	public ArrayList<UsedVehicleGetRequester> getCarIds(String email,String vehicleType);

	public ArrayList<UsedBike> searchBikeRequester(String fdate, String tdate, String bikeId, String user_name);

}
