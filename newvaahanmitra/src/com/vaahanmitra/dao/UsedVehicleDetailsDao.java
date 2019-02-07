package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public interface UsedVehicleDetailsDao {

	Map<String,Set<String>> getVehicleBrand(String vehicleType);
	
	Set<String> getUsedVehicleBrand(String vType);

	Set<String> getVehicleModel(String brand, String vType);

	Set<String> getVehicleCity();

	Set<String> getNewVehicleBrand(String vehicleType);

	Set<String> getNewVehicleModel(String brand, String vType);
	 Set<String> getNewVehicleVariant(String brand,String model, String vType);

}
