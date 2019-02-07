package com.vaahanmitra.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaahanmitra.model.AddBike;

import com.vaahanmitra.model.BikePrice;
import com.vaahanmitra.model.NewBike;
import com.vaahanmitra.model.VehicleOffer;

public interface AddBikeDao {
	public String addBike(AddBike addBike, String user_name, InputStream is);
	public ArrayList<AddBike> getBikeBrand(String email);
	public ArrayList<AddBike> getBikeModel(String bikeModel);
	public ArrayList<AddBike> getBikeBrand();
	public ArrayList<AddBike> getBikeBrands(String bikeBrand);
	public ArrayList<AddBike> getNewBike(String vBrand,String bModel,String vvariant,String madeyear,int i, int maxrowsperpage);
	public ArrayList<AddBike> getNewBikewithAdvanceFilter(String brand,String vModel,String vVariant,String madeyear,String bodytype,String fueltype,String transmission,String color,String budget, int i, int maxrowsperpage);
	public int getNoOfRecords();
	public ArrayList<AddBike> getBikeId(String model,String brand);
	public String updateBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al);
	public String addNewBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al);
	public ArrayList<AddBike> getBikeDetails(String bikeId);
	public Set<AddBike> getNewBikeVariantName(String brand, String model);
	public String updateNewBike(AddBike addBike, String user_name);
	public ArrayList<AddBike> getBikeDetailsByVariantName(String var_name);
	public ArrayList<AddBike> getBikeDetailsByVariantNamewithoutimage(String variant_name) ;
	
	public boolean addNewBikePrice(ArrayList<BikePrice> al);
	public ArrayList<BikePrice> checkNewBikePrice(ArrayList<BikePrice> al);
	public String getNewBikeId(String brand, String model,String variant,String makeYear);
	public boolean addNewBikeOffer(ArrayList<VehicleOffer> al);
	public ArrayList<VehicleOffer> checkNewBikeOffer(ArrayList<VehicleOffer> al);
	public ArrayList<AddBike> getDealerAuthorisedBikeBrand(String userid);
	public ArrayList<AddBike> getBikeExshowRoomPriceList(String varient_id, int offset, int noOfRecords);
	public String aInsertBikeExShowroomPrice(String car_id, String place, String price);
	public AddBike getBrandModelVarientBybikeId(String bike_id);
	public String aupdateNBikeExShowroomPrice(String bike_id, String place, String price) ;
	public String getBikeExshowroomprice(String car_id, String place);
	public boolean addNewBikes(List<NewBike> bikesdetails);
	public Set<AddBike> getNewBikeYearByVariantName(String brand,String model, String variant);
	public boolean checkexshowroomprice(String id);
	public ArrayList<String> getcolors();
	
	//Mahesh Methods
	public AddBike getNewBikeCompleteDetails(String sequenceno);
}
