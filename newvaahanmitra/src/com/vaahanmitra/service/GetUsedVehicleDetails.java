package com.vaahanmitra.service;

import java.util.Map;
import java.util.Set;

import com.vaahanmitra.dao.UsedVehicleDetailsDao;
import com.vaahanmitra.daoImpl.UsedVehicleDetailsDaoImpl;

public class GetUsedVehicleDetails {

	public Map<String,Set<String>> getVehicleBrands(String vehicleType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Map<String,Set<String>> vehicleBrand = mdao.getVehicleBrand(vehicleType);
		return vehicleBrand;
	}
	public Set<String> getUsedVehicleBrands(String vehicleType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String>  vehicleBrand = mdao.getUsedVehicleBrand(vehicleType);
		return vehicleBrand;
	}
	
	public Set<String> getVehicleModels(String brand,String vType) {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String> vehicleBrand = mdao.getVehicleModel(brand,vType);
		return vehicleBrand;
	}
	
	public Set<String> getVehicleCity() {
		UsedVehicleDetailsDao mdao = new UsedVehicleDetailsDaoImpl();
		Set<String> vehicleCity = mdao.getVehicleCity();
		return vehicleCity;
	}
}
