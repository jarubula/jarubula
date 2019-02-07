package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.SearchHUsedVehicleDealerDAO;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedVehicleDealerDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

public class GetUsedVehicleDealerServices {
	
	public ArrayList<BusinessOwnerRegister> getCity(){
		
		SearchHUsedVehicleDealerDAO dDAO=new SearchHUsedVehicleDealerDAOImpl();
		
		ArrayList<BusinessOwnerRegister> dealerAl=dDAO.getCity();
		
		return dealerAl;
	}
	
public ArrayList<BusinessOwnerRegister> getDealerName(String city){
		
		SearchHUsedVehicleDealerDAO dDAO=new SearchHUsedVehicleDealerDAOImpl();
		
		ArrayList<BusinessOwnerRegister> dealerAl=dDAO.getDealerName(city);
		
		return dealerAl;
	}
public ArrayList<String> getDealerBusinessName(String city){
	
	BusinessOwnerRegisterDao bodao=new BusinessOwnerRegisterDaoImpl();
	
	ArrayList<String> dealerAl=new ArrayList<String>();
	try {
		dealerAl = bodao.getBusinessOwnerBusinessNames(city, "UD");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return dealerAl;
}
}
