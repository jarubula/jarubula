package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.dao.MechanicProfileDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.daoImpl.MechanicProfileDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.MechanicProfile;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.model.ServiceMechanic;

public class GetMechanicDetails {

	/*
	 * public ArrayList<MechanicBean> getCity(){
	 * 
	 * MechanicDao mdao=new MechanicDaoImpl(); ArrayList<MechanicBean>
	 * city=mdao.getCity();
	 * 
	 * return city; }
	 */
	public ArrayList<BusinessOwnerRegister> getCity() {

		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<BusinessOwnerRegister> city = mdao.getCity();

		return city;
	}

	public ArrayList<ServiceMechanic> getVehicleType() {
		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<ServiceMechanic> vehicleType = mdao.getVehicleType();

		return vehicleType;
	}

	public ArrayList<ServiceMechanic> getVehicleBrand(String vehicleType) {
		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<ServiceMechanic> vehicleBrand = mdao.getVehicleBrand(vehicleType);

		return vehicleBrand;
	}

	public ArrayList<String> getBCity() {

		BusinessOwnerRegisterDao mdao = new BusinessOwnerRegisterDaoImpl();
		ArrayList<String> city = new ArrayList<String>();
		try {
			city = mdao.getBusinessOwnerLocations("SERVICEMECHANIC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return city;
	}

	public ArrayList<String> getServiceModel(String brand, String email) {
		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<String> model = new ArrayList<String>();
		model = mdao.getServiceModal(brand, email);
		System.out.println("Size in mde service :: " + model.size());
		return model;
	}

	public float getRate(String email) {
		int rate1 = 0, sum = 0;
		float avg = 0;
		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<String> rate = mdao.getRate(email);
		rate.removeAll(Collections.singleton(null));

		for (int i = 0; i < rate.size(); i++) {
			rate1 = Integer.parseInt(rate.get(i));
			sum = sum + rate1;
		}
		if (rate.size() > 0) {
			avg = (float) sum / rate.size();
		}
		return avg;
	}

	/*
	 * public ArrayList<ServiceEndUser> getEndUserDetails(String email){
	 * 
	 * MechanicDao mdao=new MechanicDaoImpl(); ArrayList<ServiceEndUser>
	 * serviceEndUser=mdao.viewINOServiceReq(email);
	 * 
	 * return serviceEndUser;
	 * 
	 * }
	 */
	public Set<String> getServiceStreet(String city) {
		MechanicDao mdao = new MechanicDaoImpl();
		Set<String> street = mdao.getServiceStreet(city);
		return street;
	}

	public ArrayList<ServiceEndUser> getEndUserDetails(String email) {

		MechanicDao mdao = new MechanicDaoImpl();
		ArrayList<ServiceEndUser> serviceEndUser = mdao.viewBookAppt(email);
		return serviceEndUser;

	}
	public MechanicProfile getMechanicDetails(String email) {

		MechanicProfileDao mdao = new MechanicProfileDaoImpl();
		MechanicProfile mechanic = mdao.getMechanicProfile(email);
		return mechanic;

	}
	public Set<String> displayHBrand(String email){
		MechanicDao mdao=new MechanicDaoImpl();
		Set<String> brand=mdao.displayHBrand(email);
	return brand;	
	}
}
