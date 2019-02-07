package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Map;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

public class AdminService {

	public ArrayList<AddCar> getNewCarId(){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> newCarAl=cdao.getNewCarId();
		return newCarAl;
	}
	public Map<String,String> getAdminNewVehicleBrands(String carId) {
		AddCarDao mdao = new AddCarDaoImpl();
		Map<String,String>  vehicleBrand = mdao.getNewVehicleBrand(carId);
		return vehicleBrand;
	}
}
