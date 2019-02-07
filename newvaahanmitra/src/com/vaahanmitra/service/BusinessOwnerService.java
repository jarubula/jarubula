package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.MechanicProfileDao;
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.MechanicProfileDaoImpl;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.MechanicProfile;
import com.vaahanmitra.model.UsedCar;

public class BusinessOwnerService {
	
	public BusinessOwnerRegister getAddressDetails(String emailId) {
		BusinessOwnerRegister registration = new BusinessOwnerRegister();
		BusinessOwnerRegisterDao bdao=new BusinessOwnerRegisterDaoImpl();
		try {
			registration=bdao.getAddressDetails(emailId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registration;
	}
	
	public ArrayList<String> getBusinessOwnerLocations(String usertype)
	{
		BusinessOwnerRegisterDao bo=new BusinessOwnerRegisterDaoImpl();
		ArrayList<String> al=new ArrayList<String>();
		try
		{
			al=bo.getBusinessOwnerLocations(usertype);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	public ArrayList<String> getBusinessOwnerBusinessNames(String bcity,String usertype)
	{
		BusinessOwnerRegisterDao bo=new BusinessOwnerRegisterDaoImpl();
		ArrayList<String> al=new ArrayList<String>();
		try
		{
			al=bo.getBusinessOwnerBusinessNames(bcity,usertype);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	public BusinessOwnerRegister getProfileDetails(String email){
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		BusinessOwnerRegister al=new BusinessOwnerRegister();
		try {
			al = dao.getDetails(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;		
	}
	public BusinessOwnerRegister getBOProfileDetails(String boid){
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		BusinessOwnerRegister al=new BusinessOwnerRegister();
		try {
			al = dao.getBODetails(boid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;		
	}
	public MechanicProfile getMechanicDetails(String email){
		MechanicProfileDao dao = new MechanicProfileDaoImpl();
		MechanicProfile al = dao.getMechanicDetails(email);
		return al;		
	}
	public UsedCar getCarPhotos(String car_number){
		UsedCarDao cdao=new UsedCarDaoImpl();
		UsedCar imageAl = cdao.getCarImages(car_number);
		return imageAl;
	}
	public int[] countCars(String emailId, String vehicleType){
		UsedCarDao car = new UsedCarDaoImpl();
		int[] visitorValue = car.getCarCountValue(emailId,vehicleType);
		return visitorValue;
	}
	public String searchAuthentication(String email,String v_type){
		BusinessOwnerRegisterDao cdao=new BusinessOwnerRegisterDaoImpl();
		String status = cdao.searchAuthentication(email,v_type);
		return status;
	}
	public ArrayList<BusinessOwnerRegister> getCity() {
		BusinessOwnerRegisterDao bo = new BusinessOwnerRegisterDaoImpl();
		ArrayList<BusinessOwnerRegister> al = new ArrayList<BusinessOwnerRegister>();
		al = bo.getCity();
		return al;
	}
	public ArrayList<BusinessOwnerRegister> getDealers(String brand,String city,String v_type){
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		ArrayList<BusinessOwnerRegister> al = dao.getDealers(brand, city, v_type);
		return al;		
	}
	
	public ArrayList<BusinessOwnerRegister> getSparepartsDealers(String brand,String city,String v_type){
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		ArrayList<BusinessOwnerRegister> al = dao.getSparepartsDealers(brand, city, v_type);
		return al;		
	}
	
	public ArrayList<BusinessOwnerRegister> getServiceCenterDealers(String brand,String city,String v_type){
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		ArrayList<BusinessOwnerRegister> al = dao.getServiceCenterDealers(brand, city, v_type);
		return al;		
	}
	
	public int getonRoadPrice(String car_id,String dealer_id){
		int finalvalue=0;
		BusinessOwnerRegisterDao dao=new BusinessOwnerRegisterDaoImpl();
		ArrayList<String> price=dao.getOnRoadPriceofCar(car_id, dealer_id);
		for(int i=0;i<price.size();i++){
			
			finalvalue+=Integer.parseInt(price.get(i));
			
		}
		
		
		
		return finalvalue;
		
	}
	
}
