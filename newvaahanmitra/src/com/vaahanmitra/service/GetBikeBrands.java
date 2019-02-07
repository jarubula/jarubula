package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.AddBike;
import com.vaahanmitra.model.UsedBike;

public class GetBikeBrands {
	public ArrayList<AddBike> getBikeDetails(String email){
		AddBikeDao cdao=new AddBikeDaoImpl();
		ArrayList<AddBike> addBikeAl=cdao.getBikeBrand(email);
		return addBikeAl;
	}
	public ArrayList<UsedBike> getAddBikeBrands(String bikeBrand){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> addBikeAl = bdao.getBikeBrands(bikeBrand);
		return addBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeBrand(){
		UsedBikeDao cdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> usedBikeAl=cdao.getBikeBrand();
		return usedBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeModel(String bikeModel){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> bikeModelAl = bdao.getBikeModel(bikeModel);
		return bikeModelAl;
	}
	public ArrayList<String> getUsedBikeBrand(String brand,String model,String email){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<String> usedBikeAl = bdao.getUsedBikeCity(brand,model,email);
		return usedBikeAl;
	}
	public UsedBike getUsedBikeDetails(String bikeId){
		  UsedBikeDao cdao=new UsedBikeDaoImpl();
		  UsedBike usedBikeAl = cdao.getBikeDetails(bikeId);
		  return usedBikeAl;
		 }
	public ArrayList<UsedBike> getUsedBikeId(String email){
		UsedBikeDao cdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> usedBikeAl=cdao.getBikeId(email);
		return usedBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeBrands(String email){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> addBikeAl = bdao.getBikeBrands(email);
		return addBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeModel(String bikeModel,String email){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> bikeModelAl = bdao.getBikeModel(bikeModel,email);
		return bikeModelAl;
	}
}
