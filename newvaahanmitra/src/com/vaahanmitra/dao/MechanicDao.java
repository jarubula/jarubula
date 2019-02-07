package com.vaahanmitra.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaahanmitra.model.AddMechanic;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.MechanicProfile;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.model.ServiceMechanic;

public interface MechanicDao {
	public String addMechanic(AddMechanic mechanic );
	public ArrayList<BusinessOwnerRegister> getCity();
	public ArrayList<ServiceMechanic> getVehicleType();
	public ArrayList<ServiceMechanic> getVehicleBrand(String vehicleType);
	public ArrayList<BusinessOwnerRegister> getMechanicDetails(String query);
	public ArrayList searchHMechanic(ServiceMechanic mbean,String city,int offset,int noOfRecords);
	public int getNoOfRecords();
	
	public String InsertServiceEndUser(ServiceEndUser serviceEndUser);
	public ArrayList<String> getServiceModal(String brand,String email);
	public String getServiceEndUserDetails(ServiceEndUser serviceEndUser);
	public ArrayList<ServiceEndUser> getServiceAppointmentDetails(String query);
	public String updateServiceEndUserRate(ServiceEndUser serviceEndUser);
	public ArrayList<String> getRate(String email);
	public String getAndSetBookApptPsw(String email,String psw);
	public String verifyBookApptEmail(String email);
	public ArrayList<ServiceEndUser> getServiceAppointment(String date1,String date2,String emailgetServiceAppointment,int offset,int noOfRecords);
	public String confirmServiceReqAndChangeDate(String apptId,String mdate,String email);
	public ArrayList<ServiceEndUser> viewINOServiceReq(String email);

	public Set<String> getServiceStreet(String city);
	public String getServiceCenterName(ServiceEndUser serviceEndUser);
	public ArrayList<ServiceEndUser> getVerifiedDetails(String email);
	public String getLoginDetails(String email);
	public String getLoginDetail(String email,String psw);
	public List<String> LoginDetails(String email);
	public BusinessOwnerRegister getBookedServiceDetails(String apptId);
	public String checkRegisteredDate(String email,String vehicleNo,String semail);
	public ArrayList<ServiceEndUser> viewBookAppt(String email);
	public ArrayList<ServiceEndUser> showServiceEndUserToAllDsb(String date1, String date2, String email,int offset,int noOfRecords);
	public List<BusinessOwnerRegister> showServiceCenterToAllDsb(String email);
	public ArrayList<ServiceEndUser> getServiceAppointmentDetailsWithPage(String query);
	public Set<String> displayHBrand(String email);

}
