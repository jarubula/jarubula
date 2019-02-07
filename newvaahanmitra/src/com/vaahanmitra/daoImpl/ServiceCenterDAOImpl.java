package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.utilities.SQLDate;
import com.vaahanmitra.utilities.ServiceAppointmentId;

public class ServiceCenterDAOImpl implements ServiceCenterDAO {

	private   Connection con=null;
	private int noOfRecords=0;

@Override
public Set<String> getCarApptId(String email) {
	// TODO Auto-generated method stub
	Set<String> apptId=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select APPOINTMENT_ID from book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES' and APPOINTMENT_ID is not null ";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			apptId.add(rs.getString("APPOINTMENT_ID"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return apptId;
}

@Override
public Set<String> getCarNo(String email) {
	// TODO Auto-generated method stub
	Set<String> carNo=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select VEHICLE_NO from book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES' and VEHICLE_NO is not null";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			carNo.add(rs.getString("VEHICLE_NO"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return carNo;
}

@Override
public List<ServiceEndUser> getServiceDetails(String query) {
	// TODO Auto-generated method stub
	List<ServiceEndUser> serviceEndUserAl=new ArrayList<ServiceEndUser>();
	Statement st=null;
	ResultSet rs=null;
	try{
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			ServiceEndUser serviceEndUser=new ServiceEndUser();
			serviceEndUser.setNAME(rs.getString("NAME"));
			serviceEndUser.setEMAIL(rs.getString("EMAIL"));
			serviceEndUser.setMOBILE_NO(rs.getString("MOBILE_NO"));
			serviceEndUser.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
			serviceEndUser.setCONFIRM_DATE(rs.getString("CONFIRM_DATE"));
			serviceEndUser.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
			serviceEndUser.setCAR_NO(rs.getString("VEHICLE_NO"));
			serviceEndUser.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
			serviceEndUserAl.add(serviceEndUser);
	}

		rs.close();
		rs = st.executeQuery("SELECT FOUND_ROWS()");
		if(rs.next()){
			this.noOfRecords = rs.getInt(1);
     
  }
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return serviceEndUserAl;
}

@Override
public List<ServiceEndUser> getServiceDetailsWithPage(String query) {
	// TODO Auto-generated method stub
	List<ServiceEndUser> serviceEndUserAl=new ArrayList<ServiceEndUser>();
	Statement st=null;
	ResultSet rs=null;
	try{
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			ServiceEndUser serviceEndUser=new ServiceEndUser();
			serviceEndUser.setNAME(rs.getString("NAME"));
			serviceEndUser.setEMAIL(rs.getString("EMAIL"));
			serviceEndUser.setMOBILE_NO(rs.getString("MOBILE_NO"));
			serviceEndUser.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
			serviceEndUser.setCONFIRM_DATE(rs.getString("CONFIRM_DATE"));
			serviceEndUser.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
			serviceEndUser.setCAR_NO(rs.getString("VEHICLE_NO"));
			serviceEndUser.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
			serviceEndUserAl.add(serviceEndUser);
	}

		rs.close();
		rs = st.executeQuery("SELECT FOUND_ROWS()");
		if(rs.next()){
			this.noOfRecords = rs.getInt(1);
     
  } 
		
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return serviceEndUserAl;
}

@Override
public List<ServiceEndUser> searchCarService(String apptId,String carNo,String email) {
	// TODO Auto-generated method stub
	String query=null;
	
	if(apptId.equals("All") || carNo.equals("All") || (apptId.equals("All") && carNo.equals("All"))){
		
		query="SELECT * FROM book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES'";
		
	}else if(!apptId.equals("") && (carNo.equals("") || carNo.equals("All"))){
		
		query="SELECT * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES'";
		
	}else if((apptId.equals("") || apptId.equals("All")) && !carNo.equals("")){
		
		query="SELECT * FROM book_service_appointment where VEHICLE_NO='"+carNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES'";
	
	}else if(!apptId.equals("") && !carNo.equals("")){
		
		query="SELECT * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and  VEHICLE_NO='"+carNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES'";

		
	}else{
		
		query="SELECT * FROM book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES'";

	}
	List<ServiceEndUser> serviceEndUser=getServiceDetails(query);
	return serviceEndUser;
}

@Override
public List<ServiceEndUser> searchCarServiceWithPage(String apptId,String carNo,String email,int offset,int noOfRecords) {
	// TODO Auto-generated method stub
	String query=null;
	
	if(apptId.equals("All") || carNo.equals("All") || (apptId.equals("All") && carNo.equals("All"))){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
		
	}else if(!apptId.equals("") && (carNo.equals("") || carNo.equals("All"))){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
		
	}else if((apptId.equals("") || apptId.equals("All")) && !carNo.equals("")){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where VEHICLE_NO='"+carNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
	
	}else if(!apptId.equals("") && !carNo.equals("")){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and  VEHICLE_NO='"+carNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;

		
	}else{
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='4,' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;

	}
	List<ServiceEndUser> serviceEndUser=getServiceDetailsWithPage(query);
	return serviceEndUser;
}

@Override
public Set<String> getServiceType(String userId) {
	// TODO Auto-generated method stub
	Set<String> serviceType=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="SELECT service_type FROM service_type where EMAIL_ID='"+userId+"' and service_type is not null";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			serviceType.add(rs.getString("SERVICE_TYPE"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return serviceType;
}

@Override
public Set<CarService> getSpareParts(String userId) {
	// TODO Auto-generated method stub
	Set<CarService> spareParts=new HashSet<CarService>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="SELECT SP_NAME,SKU,PRICE FROM spareparts_details where USER_NAME='"+userId+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			CarService carService=new CarService();
			
			carService.setSPAREPARTS(rs.getString("SP_NAME")+"-"+rs.getString("SKU"));
			carService.setPRICE(rs.getString("PRICE"));
			spareParts.add(carService);
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return spareParts;
}

@Override
public String insertCarService(List<CarService> carServiceList,String mechanicName,String vehicleType) {
	// TODO Auto-generated method stub
	Iterator it= carServiceList.iterator();
	PreparedStatement pst=null;
	String message=null;
	int i=0;
	String carBill=null;
	try{
		
		String id1=new IdGen().getId("GEN_CARBILL_ID");
		ServiceAppointmentId apptId=new ServiceAppointmentId();
		carBill=apptId.getCarBillId(id1);
		
		
		String query="insert into car_service values(?,?,?,?,?,?,?,?,?,?,CURDATE(),?,?,?)";
		con=DBConnection.getConnection();
		
		while(it.hasNext()){
			
			CarService carService=(CarService)it.next();
		pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		
		pst.setInt(1, carService.getCAR_SERVICE_ID());
		pst.setString(2, carService.getSERVICE_TYPE());
		pst.setString(3, carService.getDESCRIPTION());
		pst.setString(4, carService.getAMOUNT());
		pst.setString(5, carService.getDESCOUNT());
		pst.setString(6, carService.getFINAL_PRICE());
		pst.setString(7, carService.getAPPOINTMENT_ID());
		pst.setString(8, carService.getSERVICE_CENTER_ID());
		pst.setString(9, carService.getSPAREPARTS());
		pst.setString(10, carBill);
		pst.setString(11, carService.getTAX());
		pst.setString(12, mechanicName);
		pst.setString(13, vehicleType);
		
		i=pst.executeUpdate();
		
		}
		
		if(i>0){
			message="billing completed successfully.....";
		}else{
			
		}
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		pst.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return carBill;
}

@Override
public List<ServiceEndUser> getServiceEndUserById(String apptId) {
	// TODO Auto-generated method stub
String query=null;
	
		
		query="SELECT * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"'";
		
	
	List<ServiceEndUser> serviceEndUser=getServiceDetails(query);
	return serviceEndUser;
}

@Override
public List<BusinessOwnerRegister> getSeviceCenterDetails(String query) {
	// TODO Auto-generated method stub
	List<BusinessOwnerRegister> serviceCenterAl=new ArrayList<BusinessOwnerRegister>();
	Statement st=null;
	ResultSet rs=null;
	try{
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			BusinessOwnerRegister mBean=new BusinessOwnerRegister();
			mBean.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
			mBean.setADDRESS(rs.getString("ADDRESS"));
			mBean.setB_CITY(rs.getString("CITY"));
			mBean.setDISTRICT(rs.getString("DISTRICT"));
			mBean.setSTATE(rs.getString("STATE"));
			mBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
			
			serviceCenterAl.add(mBean);
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
	return serviceCenterAl;
}

@Override
public List<BusinessOwnerRegister> getServiceCenterByEmail(String email) {
	// TODO Auto-generated method stub
	String query=null;
	
	
	query="SELECT * FROM business_owner_register where EMAIL_ID='"+email+"'";
	

List<BusinessOwnerRegister> serviceCenter=getSeviceCenterDetails(query);
return serviceCenter;
}

@Override
public List<CarService> getCarServiceDetails(String apptId, String billId, String email) {
	// TODO Auto-generated method stub
	List<CarService> carServiceList=new ArrayList<CarService>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="SELECT * FROM car_service where APPOINTMENT_ID='"+apptId+"' and BILL_ID='"+billId+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			CarService carService=new CarService();
			
			carService.setSERVICE_TYPE(rs.getString("SERVICE_TYPE"));
			carService.setDESCRIPTION(rs.getString("DESCRIPTION"));
			carService.setAMOUNT(rs.getString("AMOUNT"));
			carService.setDESCOUNT(rs.getString("DISCOUNT"));
			carService.setFINAL_PRICE(rs.getString("FINAL_PRICE"));
			carService.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
			carService.setSERVICE_CENTER_ID(rs.getString("SERVICE_CENTER_ID"));
			carService.setSPAREPARTS(rs.getString("SPAREPARTS"));
			carService.setBILL_ID(rs.getString("BILL_ID"));
			String bdate=rs.getString("BILL_DATE");
			
			SQLDate sdate=new SQLDate();
			String billDate=sdate.getInDate(bdate);
			
			carService.setBILL_DATE(billDate);
			carService.setTAX(rs.getString("TAX"));
			carService.setMECHANIC_NAME(rs.getString("MECHANIC_NAME"));
			carServiceList.add(carService);
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return carServiceList;
}

@Override
public List<CarService> getCarServiceDetailsById(String apptId) {
	// TODO Auto-generated method stub
	List<CarService> carServiceList=new ArrayList<CarService>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="SELECT * FROM car_service where APPOINTMENT_ID='"+apptId+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			CarService carService=new CarService();
			
			carService.setSERVICE_TYPE(rs.getString("SERVICE_TYPE"));
			carService.setDESCRIPTION(rs.getString("DESCRIPTION"));
			carService.setAMOUNT(rs.getString("AMOUNT"));
			carService.setDESCOUNT(rs.getString("DISCOUNT"));
			carService.setFINAL_PRICE(rs.getString("FINAL_PRICE"));
			carService.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
			carService.setSERVICE_CENTER_ID(rs.getString("SERVICE_CENTER_ID"));
			carService.setSPAREPARTS(rs.getString("SPAREPARTS"));
			carService.setBILL_ID(rs.getString("BILL_ID"));
			String bdate=rs.getString("BILL_DATE");
			
			SQLDate sdate=new SQLDate();
			String billDate=sdate.getInDate(bdate);
			
			carService.setBILL_DATE(billDate);
			carService.setTAX(rs.getString("TAX"));
			carService.setMECHANIC_NAME(rs.getString("MECHANIC_NAME"));
			carServiceList.add(carService);
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return carServiceList;
}

@Override
public Set<String> getBikeApptId(String email) {
	// TODO Auto-generated method stub
	Set<String> apptId=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select APPOINTMENT_ID from book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='2,' and EMAIL_VERIFICATION='YES' and APPOINTMENT_ID is not null ";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			apptId.add(rs.getString("APPOINTMENT_ID"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return apptId;
}

@Override
public Set<String> getBikeNo(String email) {
	// TODO Auto-generated method stub
	Set<String> bikeNo=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select VEHICLE_NO from book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='2,' and EMAIL_VERIFICATION='YES' and VEHICLE_NO is not null";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			bikeNo.add(rs.getString("VEHICLE_NO"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return bikeNo;
}

@Override
public List<ServiceEndUser> searchBikeService(String apptId, String bikeNo, String email,int offset,int noOfRecords) {
	// TODO Auto-generated method stub
String query=null;
	
	if(apptId.equals("All") || bikeNo.equals("All") || (apptId.equals("All") && bikeNo.equals("All"))){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where SERVICE_CENTER='"+email+"' and VEHICLE_TYPE='2,' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
		
	}else if(!apptId.equals("") && (bikeNo.equals("") || bikeNo.equals("All"))){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
		
	}else if((apptId.equals("") || apptId.equals("All")) && !bikeNo.equals("")){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where VEHICLE_NO='"+bikeNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;
	
	}else if(!apptId.equals("") && !bikeNo.equals("")){
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where APPOINTMENT_ID='"+apptId+"' and  VEHICLE_NO='"+bikeNo+"' and SERVICE_CENTER='"+email+"' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;

		
	}else{
		
		query="SELECT SQL_CALC_FOUND_ROWS * FROM book_service_appointment where SERVICE_CENTER='"+email+"'and VEHICLE_TYPE='2,' and EMAIL_VERIFICATION='YES' limit " + offset + ", " + noOfRecords;

	}
	List<ServiceEndUser> serviceEndUser=getServiceDetails(query);
	return serviceEndUser;
}

@Override
public Set<String> getBillId(String email) {
	// TODO Auto-generated method stub
	Set<String> billId=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select BILL_ID from car_service where SERVICE_CENTER_ID='"+email+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			
			billId.add(rs.getString("BILL_ID"));
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		
		rs.close();
		st.close();
		con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
	return billId;
}

@Override
public int getNoOfRecords() {
	// TODO Auto-generated method stub
	return noOfRecords;
}

}
