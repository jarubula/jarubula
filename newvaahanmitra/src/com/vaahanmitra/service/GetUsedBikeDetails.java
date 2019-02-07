package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.dao.UsedVehicleGetRequesterDao;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.daoImpl.UsedVehicleGetRequesterDaoImpl;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;

public class GetUsedBikeDetails {

	public ArrayList<UsedBike> getUsedBikeBrand(){
		SearchHUsedBikeDAO bdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> usedBikeAl=bdao.getBikeBrand();
		return usedBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeModel(String bikeModel){
		SearchHUsedBikeDAO bdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> bikeModelAl=bdao.getBikeModel(bikeModel);
		return bikeModelAl;
	}
	public ArrayList<UsedBike> getUsedBikeVariant(String bikeBrand, String bikeModel){
		SearchHUsedBikeDAO bdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> bikeVariantAl=bdao.getBikeVariant(bikeBrand, bikeModel);
		return bikeVariantAl;
	}
	public ArrayList<UsedBike> getUsedBikeBudget(String model){
		SearchHUsedBikeDAO bdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> usedBikeAl=bdao.getUsedBikeBudget(model);
		return usedBikeAl;
	}
	public ArrayList<UsedBike> getUsedBikeCity(){
		SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> usedBikeAl=cdao.getUsedBikeCity();
		return usedBikeAl;
	}
	public ArrayList<UsedBike> getBikeImages(String bikeNumber){
		
		SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> bikeAl= cdao.getBikeImage(bikeNumber);
		return bikeAl;
		
	}
	public int getBikeVisitors(String bikeId, char vehicleType){
		UsedVehicleGetRequesterDao car = new UsedVehicleGetRequesterDaoImpl();
		int visitorValue = car.getCarVisitors(bikeId,vehicleType);
		return visitorValue;
	}
	public UsedBike getUsedBikeByBikeNo(String bikeNo){
		
		SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();
		List<UsedBike> bikeAl=cdao.getUsedBikeDetailsByCarNo(bikeNo);
		Iterator bikeIt=bikeAl.iterator();
		
		UsedBike bikeDetails=null;
		while(bikeIt.hasNext()){
			bikeDetails=(UsedBike)bikeIt.next();	
		}
		
		return bikeDetails;
	}
	public List<UsedBike> getUsedBikeWithPhotoByBikeNo(String brand,String price,String kmsDriver,String bikeNo){
		
		SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();		
		List<UsedBike> bikeAl=cdao.getUsedBikeByBikeNo(brand,price,kmsDriver,bikeNo);
		
		return bikeAl;
	}
	public List<UsedBike> getDealerUsedBike(String brand,String price,String kmsDriver,String bikeNo,String demail){
		
		SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();		
		List<UsedBike> bikeAl=cdao.getDealerUsedBike(brand,price,kmsDriver,bikeNo,demail);
		
		return bikeAl;
	}
	public ArrayList<String> getRequesters(String email){
		SearchHUsedBikeDAO dao = new SearchHUsedBikeDAOImpl();
		ArrayList<String> bk = dao.getRequesters(email);
		return bk;
	}
	public ArrayList<UsedBike> getUsedBikeNo(String email){
		UsedBikeDao bdao=new UsedBikeDaoImpl();
		ArrayList<UsedBike> usedBikeAl=bdao.getBikeNo(email);
		return usedBikeAl;
	}
	
}
