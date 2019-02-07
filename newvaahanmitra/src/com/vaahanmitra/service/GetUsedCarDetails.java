package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.dao.UsedVehicleGetRequesterDao;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.daoImpl.UsedVehicleGetRequesterDaoImpl;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UsedVehicleGetRequester;

public class GetUsedCarDetails {
	
	public ArrayList<UsedCar> getUsedCarBrand(){
		CarDAO cdao=new CarDAOImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getCarBrand();
		return usedCarAl;
	}
	public ArrayList<UsedCar> getUsedCarBrand(String email){
		UsedCarDao cdao=new UsedCarDaoImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getCarBrand(email);
		return usedCarAl;
	}
	public ArrayList<UsedCar> getUsedCarModel(String carModel){
		  UsedCarDao cdao=new UsedCarDaoImpl();
		  ArrayList<UsedCar> carModelAl=cdao.getCarModel(carModel);
		  return carModelAl;
		 }
	public ArrayList<UsedCar> getUsedCarVariant(String carBrand,String carModel){
		  UsedCarDao cdao=new UsedCarDaoImpl();
		  ArrayList<UsedCar> carVariantAl=cdao.getusedCarVariant(carBrand, carModel);
		  return carVariantAl;
		 }
	public ArrayList<UsedCar> getUsedCarBudget(String model){
		CarDAO cdao=new CarDAOImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getUsedCarBudget(model);
		return usedCarAl;
	}
	public ArrayList<UsedCar> getUsedCarCity(){
		CarDAO cdao=new CarDAOImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getUsedCarCity();
		return usedCarAl;
	}
	
	public ArrayList<String> getUsedCarBrand(String brand,String model,String email){
		UsedCarDao cdao=new UsedCarDaoImpl();
		ArrayList<String> usedCarAl=cdao.getUsedCarCity(brand, model,email);
		return usedCarAl;
	}
	public ArrayList<UsedCar> getUsedCarId(String email){
		UsedCarDao cdao=new UsedCarDaoImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getCarId(email);
		return usedCarAl;
	}
	public UsedCar getUsedCarDetails(String carId){
		UsedCarDao cdao=new UsedCarDaoImpl();
		UsedCar usedCarAl = cdao.getCarDetails(carId);
		return usedCarAl;
	}
	public ArrayList<UsedCar> getCarModel(String brand,String email){
		  UsedCarDao cdao=new UsedCarDaoImpl();
		  ArrayList<UsedCar> carModelAl=cdao.getCarModel(brand,email);
		  return carModelAl;
	}
	public ArrayList<UsedCar> getCarImage(String carNumber){
		
		CarDAO cdao=new CarDAOImpl();
		ArrayList<UsedCar> carAl= cdao.getCarImage(carNumber);
		return carAl;
		
	}
	public UsedCar getUsedCarByCarNo(String carNo){
	
		CarDAO cdao=new CarDAOImpl();
		List<UsedCar> carAl=cdao.getUsedCarDetailsByCarNo(carNo);
		Iterator carIt=carAl.iterator();
		UsedCar carDetails=null;
		while(carIt.hasNext()){
			carDetails=(UsedCar)carIt.next();	
		}
		return carDetails;
	}
	public List<UsedCar> getUsedCarWithPhotoByCarNo(String brand,String price,String kmsDriver,String carNo){
		CarDAO cdao=new CarDAOImpl();
		List<UsedCar> carAl=cdao.getUsedCarByCarNo(brand,price,kmsDriver,carNo);
		return carAl;
	}
	public int getCarVisitors(String carId, char vehicleType){
		UsedVehicleGetRequesterDao car = new UsedVehicleGetRequesterDaoImpl();
		int visitorValue = car.getCarVisitors(carId,vehicleType);
		return visitorValue;
	}
	public ArrayList<String> getRequesters(String email){
		CarDAO dao = new CarDAOImpl();
		ArrayList<String> cr = dao.getRequesters(email);
		return cr;
	}
	public List<UsedCar> getDealerUsedCar(String brand,String price,String kmsDriver,String carNo,String demail){
		
		CarDAO cdao=new CarDAOImpl();
		List<UsedCar> carAl=cdao.getDealerUsedCar(brand,price,kmsDriver,carNo,demail);
		
		return carAl;
	}
	public ArrayList<UsedVehicleGetRequester> getCarIds(String email,String vehicleType){
		UsedVehicleGetRequesterDao cdao=new UsedVehicleGetRequesterDaoImpl();
		ArrayList<UsedVehicleGetRequester> usedCarAl=cdao.getCarIds(email,vehicleType);
		return usedCarAl;
	}
	public String getVehicleEmailId(String carId,String vehicleType){
		UsedCarDao cdao=new UsedCarDaoImpl();
		String emailId = cdao.getVehicleEmailId(carId,vehicleType);
		return emailId;
	}
	public ArrayList<UsedCar> getUsedCarNo(String email){
		UsedCarDao cdao=new UsedCarDaoImpl();
		ArrayList<UsedCar> usedCarAl=cdao.getCarNo(email);
		return usedCarAl;
	}
}
