package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

public class GetNewCarDetails {
	
	public ArrayList<AddCar> getNewCarBrand(){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> newCarAl=cdao.getCarBrand();
		return newCarAl;
	}
	public ArrayList<AddCar> getAddCarModel(String carModel){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> carModelAl=cdao.getCarModel(carModel);
		return carModelAl;
	}
	public ArrayList<AddCar> getCarId(String email){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> carModelAl=cdao.getCarId(email);
		return carModelAl;
	}
	public ArrayList<AddCar> getCarDetails(String carId){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> car=cdao.getCarDetails(carId);
		return car;
	}
	
	public Set<AddCar> getNewCarVariantName(String brand, String model) {
		AddCarDao mdao = new AddCarDaoImpl();
		Set<AddCar> varinatName = mdao.getNewCarVariantName(brand,model);
		return varinatName;
	}
	public Set<AddCar> getNewCarYearByVariantName(String brand, String model,String variant) {
		AddCarDao mdao = new AddCarDaoImpl();
		Set<AddCar> varinatName = mdao.getNewCarYearByVariantName(brand, model, variant);
		return varinatName;
	}

	public ArrayList<AddCar> getNewCarVariantNameForUpdate(String model,String brand) {
		  AddCarDao mdao = new AddCarDaoImpl();
		  ArrayList<AddCar> varinatName = mdao.getNewCarVariantNameForUpdate(model,brand);
		  return varinatName;
		 }
	public ArrayList<AddCar> getDealerAuthorisedNewCarBrand(String userid){
		AddCarDao cdao=new AddCarDaoImpl();
		ArrayList<AddCar> newCarAl=cdao.getDealerAuthorisedCarBrand(userid);
		return newCarAl;
	}
	public AddCar getBrandModelVarient(String car_id){
		AddCarDao cdao=new AddCarDaoImpl();
		AddCar newCarAl=cdao.getBrandModelVarientBycarId(car_id);
		return newCarAl;
	}
	public String getExshowroompricebyplaceandId(String car_id,String place){
		AddCarDao cdao=new AddCarDaoImpl();
		String price=cdao.getExshowroomprice(car_id, place);
		return price;
	}
	
	public HashMap<String, String> getItemandPricebydealer_id(String vch_id,String e_id){
		HashMap<String, String> chm=new HashMap<String, String>();
		AddCarDao cdao=new AddCarDaoImpl();
		chm=cdao.getPriceitem(vch_id, e_id);
		return chm;
	}
	
	public Set<String> getcolor(){
		AddCarDao cdao=new AddCarDaoImpl();
 ArrayList<String> colors=cdao.getcolors();
 Set<String> a= new TreeSet<String>();
for(String s:colors){
	String  arr[]=  s.split(",");
	for(String l:arr){
		a.add(l);
	}
}
 
 /*String  arr[]= colors.split(",");*/
		
		
		
		return a;
	}
	
	public Set<String> getbodytype(){
		
		AddCarDao cdao=new AddCarDaoImpl();
		Set<String> a=cdao.getbodytypeforCars();
		
		return a;
	}
	
	
}
