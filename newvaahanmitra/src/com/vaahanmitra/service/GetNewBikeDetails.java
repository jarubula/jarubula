package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddBike;

public class GetNewBikeDetails {
	AddBikeDao bdao=new AddBikeDaoImpl();
	public ArrayList<AddBike> getNewBikeBrand(){
		AddBikeDao bdao=new AddBikeDaoImpl();
		ArrayList<AddBike> newBikeAl = bdao.getBikeBrand();
		return newBikeAl;
	}
	public ArrayList<AddBike> getNewBikeModel(String bikeModel){
		AddBikeDao cdao=new AddBikeDaoImpl();
		ArrayList<AddBike> bikeModelAl=cdao.getBikeModel(bikeModel);
		return bikeModelAl;
	}
	public ArrayList<AddBike> getAddBikeBrands(String bikeBrand){
		AddBikeDao bdao=new AddBikeDaoImpl();
		ArrayList<AddBike> addBikeAl = bdao.getBikeBrands(bikeBrand);
		return addBikeAl;
	}
	public ArrayList<AddBike> getBikeId(String model,String brand){
		  AddBikeDao bdao=new AddBikeDaoImpl();
		  ArrayList<AddBike> bikeModelAl=bdao.getBikeId(model,brand);
		  return bikeModelAl;
		 }
	public ArrayList<AddBike> getBikeDetails(String bikeId){
		AddBikeDao dao=new AddBikeDaoImpl();
		ArrayList<AddBike> bike=dao.getBikeDetails(bikeId);
		return bike;
	}
	
	public Set<AddBike> getNewBikeVariantName(String brand, String model) {
		AddBikeDao mdao = new AddBikeDaoImpl();
		Set<AddBike> varinatName = mdao.getNewBikeVariantName(brand,model);
		return varinatName;
	}
	
	public ArrayList<AddBike> getDealerAuthorisedNewBikeBrand(String userid){
		ArrayList<AddBike> newBikeAl = bdao.getDealerAuthorisedBikeBrand(userid);
		return newBikeAl;
	}
	public AddBike getBrandModelVarient(String bike_id){
		AddBike newBikeAl=bdao.getBrandModelVarientBybikeId(bike_id);
		return newBikeAl;
	}
	public String getExshowroompricebyplaceandId(String bike_id,String place){
	
		String price=bdao.getBikeExshowroomprice(bike_id, place);
		return price;
	}
	public Set<AddBike> getNewBikeYearByVariantName(String brand,String model, String variant){
	Set<AddBike> newBikeAl=bdao.getNewBikeYearByVariantName(brand, model, variant);
		return newBikeAl;
		
	}
	public Set<String> getcolor(){
		AddBikeDao cdao=new AddBikeDaoImpl();
		 ArrayList<String> colors=cdao.getcolors();
		 Set<String> a= new TreeSet<String>();
		for(String s:colors){
			String  arr[]=  s.split(",");
			for(String l:arr){
				a.add(l);
			}
		}
		return a;
	}
	
	//Mahesh Methods
	public AddBike getNewBikeCompleteDetails(String sequenceno){
		AddBikeDao dao=new AddBikeDaoImpl();
		AddBike bike=dao.getNewBikeCompleteDetails(sequenceno);
		return bike;
	}
}
