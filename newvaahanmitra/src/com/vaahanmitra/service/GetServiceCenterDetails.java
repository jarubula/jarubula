package com.vaahanmitra.service;

import java.util.List;
import java.util.Set;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.dao.ServiceTypeDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.daoImpl.ServiceTypeDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceType;

public class GetServiceCenterDetails {
	
	public Set<String> getCarApptId(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> apptId=sdao.getCarApptId(id);
		
		return apptId;
		
	}
	public Set<String> getCarNo(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> carNo=sdao.getCarNo(id);
		
		return carNo;
		
	}
	
	public Set<String> getServiceType(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> serviceType=sdao.getServiceType(id);
		
		return serviceType;
		
	}
	
	public Set<CarService> getSpareParts(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<CarService> spareParts=sdao.getSpareParts(id);
		
		return spareParts;
		
	}
	
	public Set<String> getBikeApptId(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> apptId=sdao.getBikeApptId(id);
		
		return apptId;
		
	}

	public Set<String> getBikeNo(String id){
	
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> carNo=sdao.getBikeNo(id);
	
		return carNo;
	
	}

	public List<CarService> getCarService(String id){
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		List<CarService> carService=sdao.getCarServiceDetailsById(id);
	
		return carService;
	
	}

	public Set<String> getBillId(String id){
	
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		Set<String> billId=sdao.getBillId(id);
	
		return billId;
	
	}

	public List<BusinessOwnerRegister> showServiceCenterToAllDsb(String email){
	
		MechanicDao mdo=new MechanicDaoImpl();
		List<BusinessOwnerRegister> serviceCenter=mdo.showServiceCenterToAllDsb(email);
	
		return serviceCenter;
	
	}
	
	public Set<ServiceType> getServiceId(String email){
		ServiceTypeDao sdao=new ServiceTypeDaoImpl();
		Set<ServiceType> serviceId=sdao.getServiceId(email);
		return serviceId;
		
	}
	
}
