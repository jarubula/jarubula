package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Set;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.dao.UsedVehicleDetailsDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.daoImpl.UsedVehicleDetailsDaoImpl;
import com.vaahanmitra.model.AddCar;

public class GetCarBrands {
	
	public ArrayList<AddCar> getAddCarBrands(String carBrand){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> addCarAl=cdao.getCarBrands(carBrand);
		return addCarAl;
	}
	public ArrayList<AddCar> getCarDetails(){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> addCarAl=cdao.getCarBrand();
		return addCarAl;
	}
	public ArrayList<AddCar> getBrands(){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> addCarAl=cdao.getCarBrand();
		return addCarAl;
	}
	public Set<String> getNewVehicleBrands(String vehicleType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String>  vehicleBrand = mdao.getNewVehicleBrand(vehicleType);
		return vehicleBrand;
	}
	public Set<String> getNewVehicleModels(String brand,String vType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String> vehicleBrand = mdao.getNewVehicleModel(brand,vType);
		return vehicleBrand;
	}
	
	public Set<String> getNewVehicleVariant(String brand,String model,String vType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String> vehiclevariant = mdao.getNewVehicleVariant(brand, model, vType);
		return vehiclevariant;
	}
}
