package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.BikePrice;

public class VehicleService {
	AddCarDao carDao=new AddCarDaoImpl();
	AddBikeDao bikeDao=new AddBikeDaoImpl();
	
	public ArrayList<BikePrice> getCarPricedetails(String b_id,String md,String vt,String mk,String vp,String em) {
		String newid=null;
		if(vp.equals("4,")){
		newid=carDao.getNewCarId(b_id,md,vt,mk);
		}
		else{
			newid=bikeDao.getNewBikeId(b_id,md,vt,mk);
		}
		ArrayList<BikePrice> pd=new ArrayList<BikePrice>();
		pd=carDao.getVehiclePricedetails(newid,em);
	
		return pd;
		
		
	}
	
	public ArrayList<BikePrice> getCardetailsValues(String seq_id) {
		ArrayList<BikePrice> pd=new ArrayList<BikePrice>();
		pd=carDao.getVehiclePricedetailsValues(seq_id);
		return pd;
		
	}

}
