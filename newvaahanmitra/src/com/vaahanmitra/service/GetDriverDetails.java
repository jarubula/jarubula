package com.vaahanmitra.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.DriverFeedBack;
import com.vaahanmitra.model.InsertDriverPreRtsAndSal;
import com.vaahanmitra.model.OnDemandDriverRoutes;

public class GetDriverDetails {

	public InsertDriverPreRtsAndSal getDriverSalary(String userId){
		DriverDAO sdao=new DriverDAOImpl();
		ArrayList<InsertDriverPreRtsAndSal> al=sdao.getDriverSal(userId);
		Iterator it=al.iterator();
		InsertDriverPreRtsAndSal ad=null;
		while(it.hasNext()){
			ad=(InsertDriverPreRtsAndSal)it.next();
			
		}
		return ad;
	}
	
	public String getDriverJobType(String email){
		
		DriverDAO ddo=new DriverDAOImpl();
		
		String jobType=ddo.driverJobType(email);
		
		return jobType;
	}
	
	public ArrayList<DriverBean> getDriverPermitType(String email){
		
		DriverDAO ddo=new DriverDAOImpl();
		
		ArrayList<DriverBean> permitTypeal=ddo.getDriverDetails(email);
		
		return permitTypeal;
		
	}
	
	public Set<String> getOnDemandDriverLocation(){
		DriverDAO ddo=new DriverDAOImpl();
		Set<String> location=ddo.getOnDemandDriverLocation();
		return location;
	}
	
	
	public float getDriverRate(String email){
		int rate1=0,sum=0;
		float avg=0;
		DriverDAO ddao=new DriverDAOImpl();
		List<String> rate=ddao.getDriverRating(email);
		rate.removeAll(Collections.singleton(null));
		
		for(int i=0;i<rate.size();i++){
		rate1=Integer.parseInt(rate.get(i));
		sum=sum+rate1;
		}
		if(rate.size()>0){
		avg=(float)sum/rate.size();
		}
		return avg;
	}
	
	public List<DriverBean> getDriverName(String email){
		
		DriverDAO ddo=new DriverDAOImpl();
		List<DriverBean> driverAl= ddo.getDriverName(email);
		
		return driverAl;
		
	}
	
	public String getDriverStatus(String email){
		
		DriverDAO ddo=new DriverDAOImpl();
		List<String> statusAl=ddo.getLoginDetails(email);
		
		String status=null;
		if(statusAl!=null && statusAl.size()>0){
			
		status=statusAl.get(2);
		
		}
		
		return status;
	}
	
	public List<DriverBean> getDriverById(String driverId){
		
		
		
		
		String[] id=driverId.split(",");
		
		
		List<DriverBean> driverAl=new ArrayList<DriverBean>();
		
		
		DriverDAO ddo=new DriverDAOImpl();
		
		for(int i=0;i<id.length;i++){
		DriverBean driverBean=ddo.getDriverDetailsById(id[i]);
		driverAl.add(driverBean);
		}
		
		
		return driverAl;
		
	}
	
	public OnDemandDriverRoutes getOnDemandAmount(String userId){
		DriverDAOImpl sdao=new DriverDAOImpl();
		List<OnDemandDriverRoutes> al=sdao.getOnDemandAmount(userId);
		Iterator it=al.iterator();
		OnDemandDriverRoutes ad=null;
		while(it.hasNext()){
			ad=(OnDemandDriverRoutes)it.next();
			
		}
		return ad;
	}
	
	public String getDriverRequesterNotification(String userId){
		
		DriverDAO ddo=new DriverDAOImpl();
		String count=ddo.getDriverRequesterNotification(userId);
		
		return count;
	}

	public Set<String> getDriverTripId(String email){
		
		DriverDAO ddo=new DriverDAOImpl();
		Set<String> tripId=ddo.getDriverTripId(email);
		
		return tripId;
		
	}

public String getDriverBillId(String apptId,String tripId,String driverEmail){
		
		DriverDAO ddo=new DriverDAOImpl();
		String billId=ddo.getDriverBillId(apptId,tripId,driverEmail);
		
		return billId;
		
	}

public List<DriverFeedBack> getDriverFeedBack(String apptId,String tripId){
	
	DriverDAO ddo=new DriverDAOImpl();
	List<DriverFeedBack> driverFD=ddo.getDriverBill(apptId, tripId);
	
	return driverFD;
	
}
public Set<String> getUserTripId(String email){
	 
	 DriverDAO ddo=new DriverDAOImpl();
	 Set<String> tripId=ddo.getEndUserTripId(email);
	 
	 return tripId;
	 
	}
}
