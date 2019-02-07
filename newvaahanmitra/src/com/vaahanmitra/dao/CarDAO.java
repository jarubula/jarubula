package com.vaahanmitra.dao;

import java.util.ArrayList;
import java.util.List;

import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.UsedCar;

public interface CarDAO {
	
	public ArrayList<UsedCar> getUsedCarDetails(String query);
	/*public ArrayList<UsedCar> searchHUsedCar(UsedCar bean);*/
	public ArrayList<UsedCar> getCarBrand();
	public ArrayList<UsedCar> getCarModel(String carModel);
	public ArrayList<UsedCar> getUsedCarCity();
	public ArrayList<UsedCar> getUsedCarBudget(String budget);
	public String insertEndUserDetails(CarEndUser endUser,String carId);
	public ArrayList<UsedCar> compareUsedCar(ArrayList<UsedCar> carId);
	public ArrayList<UsedCar> getCarImage(String carNumber);
	/*public ArrayList<UsedCar> searchHDealerUsedCar(UsedCar bean);*/
	public ArrayList<UsedCar> searchHUsedCar(UsedCar bean,int offset,int noOfRecords);
	public String validateRequest(String carId,String name, String email, String mobileNo);
	public String updateEmailMobileNo(String carId, String name, String email, String mobileNo);
	public String getEmail(String carId);
	public String varifyEmailId(String carId, String email, String name, String mobileNo);
	public String updateMobileNo(String carId,String name, String email, String mobileNo);
	public ArrayList<UsedCar> searchHDealerUsedCar(UsedCar bean,int offset,int noOfRecords);
	public String insertUserRequest(CarEndUser endUser, String carId);
	public ArrayList<String> getRequesters(String email);
	public ArrayList<UsedCar> searchUsedCar(String brand);
	public int getNoOfRecords();
	public List<UsedCar> getUsedCarDetailsByCarNo(String carNo);
	public List<UsedCar> getUsedCarByCarNo(String brand,String price,String kmsDriven,String carNo);
	public List<UsedCar> getDealerUsedCar(String brand, String price, String kmsDriver, String carNo, String demail);
}
