package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vaahanmitra.model.AddCar;
import com.vaahanmitra.model.BikePrice;
import com.vaahanmitra.model.NewCar;
import com.vaahanmitra.model.VehicleOffer;

public interface AddCarDao {
	public String addCar(AddCar addCar,String user_name, InputStream is);
	public ArrayList<AddCar> getCarBrands(String carBrand);
	public ArrayList<AddCar> getCarBrand();
	public ArrayList<AddCar> getCarBrandDetails(String brand, String user_name);
	public ArrayList<AddCar> getCarModel(String carModel);
	public ArrayList<AddCar> getNewCar(String brand,String vModel,String vVariant,String madeyear, int i, int maxrowsperpage);
	public ArrayList<AddCar> getNewCarwithAdvanceFilter(String brand,String vModel,String vVariant,String madeyear,String bodytype,String fueltype,String transmission,String color,String budget, int i, int maxrowsperpage);
	public int getNoOfRecords();
	public ArrayList<AddCar> getCarId(String email);
	public String updateCarPhotos(String carNo, InputStream is, ArrayList<InputStream> al);
	public String addNewCarPhotos(String carNo, InputStream is, ArrayList<InputStream> al);
	public ArrayList<AddCar> getCarDetails(String carId);
	public Set<AddCar> getNewCarVariantName(String brand, String model);
	public Set<AddCar> getNewCarYearByVariantName (String brand,String model,String  variant);
	public String addCarSpecifications(AddCar addCar);
	public ArrayList<AddCar> getNewCarId();
	public Map<String,String> getNewVehicleBrand(String vehicleType);
	
	public ArrayList<AddCar> getNewCarVariantNameForUpdate(String model,String brand);
	
	
	public ArrayList<AddCar> getCarDetailsByVariantName(String variant_name);
	public ArrayList<AddCar> getCarDetailswithoutimageVariantName(String variant_name);
	public String updateNewCarbasicdetails(AddCar addCar, String user_name);
	
	public boolean addNewCarPrice(ArrayList<BikePrice> al);
	public ArrayList<BikePrice> checkNewCarPrice(ArrayList<BikePrice> al);
	public String getNewCarId(String brand, String model,String variant,String makeYear);
	public boolean addNewCarOffer(ArrayList<VehicleOffer> al);
	 public ArrayList<VehicleOffer> checkNewCarOffer(ArrayList<VehicleOffer> al);
	public ArrayList<AddCar> getDealerAuthorisedCarBrand(String userid);
	
	public String updateNewCarMoredetails(AddCar addCar,String user_name);
	
	public ArrayList<AddCar> getExshowRoomPriceList(String varient_id, int offset, int noOfRecords);
	
	public String  aInsertExShowroomPrice(String car_id,String place,String price);
	
	public String  aupdateExShowroomPrice(String car_id,String place,String price);
	
	public AddCar getBrandModelVarientBycarId(String car_id);
	
	public String getExshowroomprice(String car_id,String place);
	
	
	public boolean addNewCars(List<NewCar> cardetails);
	
    public ArrayList<BikePrice> getVehiclePricedetails(String vehicle_id,String email);
    
    public ArrayList<BikePrice> getVehiclePricedetailsValues(String seq_id);
    
    public String updatePrice(String seq_id,String price,String item,String vch_id);
    
    public HashMap<String, String> getPriceitem(String vch_id,String e_id);
   
    public boolean checkexshowroomprice(String id);

    public ArrayList<String> getcolors();
    
    public Set<String> getbodytypeforCars();
    
  
    
    
}
