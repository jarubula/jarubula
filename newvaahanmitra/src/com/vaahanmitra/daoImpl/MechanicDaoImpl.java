package com.vaahanmitra.daoImpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.AddMechanic;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.MechanicProfile;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.model.ServiceMechanic;
import com.vaahanmitra.service.SendEmailToUser;
import com.vaahanmitra.service.SendMailToUser;
import com.vaahanmitra.utilities.SQLDate;
import com.vaahanmitra.utilities.ServiceAppointmentId;

public class MechanicDaoImpl implements MechanicDao {
	private Connection con = null;
	private int noOfRecords=0;

	public  String addMechanic(AddMechanic mechanic) {
		String message=null;
		try {
			con=DBConnection.getConnection();
			String query = "insert into add_mechanic values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, mechanic.getMECHANIC_ID()); 
			preparedStatement.setString(2, mechanic.getFIRST_NAME());
			preparedStatement.setString(3, mechanic.getLAST_NAME());
			preparedStatement.setString(4, mechanic.getBUSINESS_NAME());
			preparedStatement.setString(5, mechanic.getPANCARD_NO());
			preparedStatement.setString(6, mechanic.getEMAIL_ID());
			preparedStatement.setString(7, mechanic.getPHONE_NO());
			preparedStatement.setString(8, mechanic.getADDRESS());
			preparedStatement.setString(9, mechanic.getCITY());
			preparedStatement.setString(10, mechanic.getSTATE());
			preparedStatement.setString(11, mechanic.getDISTRICT());
			preparedStatement.setString(12, mechanic.getPINCODE_NO());
			preparedStatement.setString(13, mechanic.getBUSI_ADDRESS());
			preparedStatement.setString(14, mechanic.getBUSI_CITY());
			preparedStatement.setString(15, mechanic.getBUSI_STATE());
			preparedStatement.setString(16, mechanic.getBUSI_DISTRICT());
			preparedStatement.setString(17, mechanic.getOFFICE_NO());
			preparedStatement.setString(18, mechanic.getBPINCODE_NO());
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			if(i>0)
			{
				message="Mechanic added successfully...";
			}
			else
			{
				message="data not inserted please try again";
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return message;
	}


	public ArrayList<BusinessOwnerRegister> getCity() {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> mechanicAl=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select b_city from business_owner_register where USER_TYPE='SC' and b_city is not null group by b_city";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				BusinessOwnerRegister mBean=new BusinessOwnerRegister();
				mBean.setB_CITY(rs.getString("B_CITY"));
				mechanicAl.add(mBean);
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
	return mechanicAl;
	}
	public ArrayList<ServiceMechanic> getVehicleType() {
		// TODO Auto-generated method stub
		ArrayList<ServiceMechanic> mechanicAl=new ArrayList<ServiceMechanic>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select vehicle_type from service_type group by vehicle_type";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				ServiceMechanic mBean=new ServiceMechanic();
				mBean.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				mechanicAl.add(mBean);
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
		return mechanicAl;
	}
	public ArrayList<ServiceMechanic> getVehicleBrand(String vehicleType) {
		// TODO Auto-generated method stub
		ArrayList<ServiceMechanic> mechanicAl=new ArrayList<ServiceMechanic>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			if(vehicleType.equals("2,") || vehicleType.equals("4,")){
			query="select VEHICLE_BRAND from service_type where VEHICLE_TYPE='"+vehicleType+"' and VEHICLE_BRAND is not null group by VEHICLE_BRAND";
				//query="select VEHICLE_BRAND from service_type WHERE VEHICLE_BRAND is not null and VEHICLE_TYPE = '"+vehicleType+"' AND EMAIL_ID IN (select EMAIL_ID from business_owner_register where USER_TYPE='SC' AND B_CITY = '"+city+"')";
			}else if(vehicleType.equals("4,2,")){
				//query="select VEHICLE_BRAND from service_type WHERE VEHICLE_BRAND is not null and EMAIL_ID IN (select EMAIL_ID from business_owner_register where USER_TYPE='SC' AND B_CITY = '"+city+"')";

				query="select VEHICLE_BRAND from service_type where VEHICLE_BRAND is not null group by VEHICLE_BRAND";

			}
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			
			rs=st.executeQuery(query);
			
			while(rs.next()){
				ServiceMechanic mBean=new ServiceMechanic();
				mBean.setBRAND(rs.getString("VEHICLE_BRAND"));
				mechanicAl.add(mBean);
		
			}
	}catch(Exception e){
//		e.printStackTrace();
	}finally{
		try{
			
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e){
//			e.printStackTrace();
		}
	}
		return mechanicAl;
	}

	public ArrayList<BusinessOwnerRegister> getMechanicDetails(String query) {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> mechanicAl=new ArrayList<BusinessOwnerRegister>();
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
				
				mechanicAl.add(mBean);
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
		return mechanicAl;
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Object> searchHMechanic(ServiceMechanic mbean,String city,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		ArrayList<Object> mechanicAl=new ArrayList<Object>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;

		try{
if(city==null && mbean.getSELECTED_VEHICLE_TYPE()==null && mbean.getADDRESS().equals("SELECT") &&  mbean.getBRAND()==null){
				
				query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

				
			}
else if(city.equals("All") || (city.equals("All") && mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")) || (city.equals("All") && mbean.getADDRESS().equals("All") && mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,"))|| (city.equals("All") && mbean.getADDRESS().equals("All")) || (city.equals("All") && mbean.getADDRESS().equals("All") && mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,") && mbean.getBRAND().equals("All")) || (city.equals("All") && mbean.getSELECTED_VEHICLE_TYPE().equals("All") && mbean.getBRAND().equals("All")) || (city.equals("All") && mbean.getSELECTED_VEHICLE_TYPE().equals("All"))){
				
				query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

	}else if(!city.equals("SELECT") && (mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") || mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")) && (mbean.getBRAND().equals("SELECT") || mbean.getBRAND().equals("All")) && (mbean.getADDRESS().equals("SELECT") || mbean.getADDRESS().equals("All"))){

			query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),GROUP_CONCAT(service_type.VEHICLE_BRAND),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where b_city='"+city+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
			
			}else if((city.equals("SELECT") || city.equals("All")) && !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && (mbean.getBRAND().equals("SELECT") || mbean.getBRAND().equals("All")) && mbean.getADDRESS().equals("SELECT")){
				
				if(mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")){
					
					query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where  USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
				
				}else{

					query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register  left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where (business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%') and (service_type.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%'  or service_type.VEHICLE_TYPE is null)  and USER_TYPE='SC'   group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

				}
				}else if(!city.equals("SELECT") && !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && (mbean.getBRAND().equals("SELECT") || mbean.getBRAND().equals("All")) && mbean.getADDRESS().equals("SELECT")){
					
					if(mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")){
						
						query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register  left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where b_city='"+city+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
						
					}else{
				
						query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where b_city='"+city+"' and business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%' and (service_type.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%'  or service_type.VEHICLE_TYPE is null) and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

					
					}
					}else if(city.equals("SELECT") && !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && !mbean.getBRAND().equals("SELECT") && mbean.getADDRESS().equals("SELECT")){
						
						if(mbean.getSELECTED_VEHICLE_TYPE().equals("2,") || mbean.getSELECTED_VEHICLE_TYPE().equals("4,") ){
							
							
						query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%' and VEHICLE_BRAND='"+mbean.getBRAND()+"' and (service_type.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%'  or service_type.VEHICLE_TYPE is null) and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
						
						}else{

			
						query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where  and VEHICLE_BRAND='"+mbean.getBRAND()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
						
						}
						}else if(!city.equals("SELECT") && !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && !mbean.getBRAND().equals("SELECT") && mbean.getADDRESS().equals("SELECT")){
							
							if(mbean.getSELECTED_VEHICLE_TYPE().equals("2,") || mbean.getSELECTED_VEHICLE_TYPE().equals("4,") ){
								
								
							query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"' and business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%' and VEHICLE_BRAND='"+mbean.getBRAND()+"' and (service_type.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%'  or service_type.VEHICLE_TYPE is null) and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
							
							}else{
				
			
							query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"'  and VEHICLE_BRAND='"+mbean.getBRAND()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
							
							}
							}else if(!city.equals("SELECT")&& mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && mbean.getBRAND().equals("SELECT") && !mbean.getADDRESS().equals("SELECT")){
								
								query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"' and location='"+mbean.getADDRESS()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

							}else if(!city.equals("SELECT")&& !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && mbean.getBRAND().equals("SELECT") && !mbean.getADDRESS().equals("SELECT")){
								if(mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")){
								
								query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"' and location='"+mbean.getADDRESS()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

								}else{
									
									query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"' and business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%' and location='"+mbean.getADDRESS()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

								}
							}else if(!city.equals("SELECT")&& !mbean.getSELECTED_VEHICLE_TYPE().equals("SELECT") && !mbean.getBRAND().equals("SELECT") && !mbean.getADDRESS().equals("SELECT")){
								
								if(mbean.getSELECTED_VEHICLE_TYPE().equals("4,2,")){
									
									query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"'  and VEHICLE_BRAND='"+mbean.getBRAND()+"' and location='"+mbean.getADDRESS()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

									}else{
										
										query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where B_CITY='"+city+"' and business_owner_register.VEHICLE_TYPE like '%"+mbean.getSELECTED_VEHICLE_TYPE()+"%' and VEHICLE_BRAND='"+mbean.getBRAND()+"' and location='"+mbean.getADDRESS()+"' and USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;

									}
							}else{

								query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,service_type.SERVICE_CENTER_ID,GROUP_CONCAT(service_type.SERVICE_TYPE),GROUP_CONCAT(service_type.VEHICLE_BRAND),GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|'),update_service_price.SERVICE_CENTER_ID,GROUP_CONCAT(update_service_price.PRICE),GROUP_CONCAT(update_service_price.DISCOUNT),GROUP_CONCAT(update_service_price.FINAL_PRICE) from business_owner_register left join service_type on business_owner_register.EMAIL_ID=service_type.EMAIL_ID left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where USER_TYPE='SC' group by SEQUENTIAL_NO limit " + offset + ", " + noOfRecords;
							}
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			String vehicleType=null;
			byte photo[];
	        Blob blob;
			while(rs.next()){
				BusinessOwnerRegister mBean=new BusinessOwnerRegister();
				ServiceMechanic smechanic=new ServiceMechanic();
				mBean.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				mBean.setADDRESS(rs.getString("ADDRESS"));
				mBean.setB_CITY(rs.getString("B_CITY"));
				mBean.setDISTRICT(rs.getString("DISTRICT"));
				mBean.setSTATE(rs.getString("STATE"));
				mBean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				mBean.setOFFICE_PHONE_NO(rs.getString("OFFICE_PHONE_NO"));
				mBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				smechanic.setSERVICE_TYPE(rs.getString("GROUP_CONCAT(service_type.SERVICE_TYPE)"));
				smechanic.setSERVICE_DESCRIPTION(rs.getString("GROUP_CONCAT(service_type.SERVICE_DESCRIPTION SEPARATOR '|')"));
				smechanic.setPRICE(rs.getString("GROUP_CONCAT(update_service_price.PRICE)"));
				smechanic.setDISCOUNT(rs.getString("GROUP_CONCAT(update_service_price.DISCOUNT)"));
				smechanic.setFINAL_PRICE(rs.getString("GROUP_CONCAT(update_service_price.FINAL_PRICE)"));
				smechanic.setVEHICLE_BRAND(rs.getString("GROUP_CONCAT(service_type.VEHICLE_BRAND)"));
				mBean.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				mBean.setVERIFIED(rs.getString("VERIFIED"));
				mBean.setLOCATION(rs.getString("LOCATION"));
				blob=rs.getBlob("PHOTO");
				if(blob!=null){
				photo=blob.getBytes(1, (int)blob.length());
				String photo1 = Base64.encode(photo);
				mBean.setPHOTO(photo1);
				}


				mechanicAl.add(mBean);
				mechanicAl.add(smechanic);
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
		return mechanicAl;
	}
	
	public ArrayList<String> getServiceModal(String brand,String email) {
		// TODO Auto-generated method stub
		ArrayList<String> modal=new ArrayList<String>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			query="select MODEL from selected_vehicle_type_details where BRAND='"+brand+"' and REFERENCE_ID='"+email+"' and MODEL is not null group by MODEL";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				String model=rs.getString(1);
				modal.add(model);
				System.out.println(model);
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
		return modal;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public String InsertServiceEndUser(ServiceEndUser serviceEndUser) {
			// TODO Auto-generated method stub
			String message=null;
			String IOemail=null;
			PreparedStatement pst=null;
			PreparedStatement pst1=null;
			PreparedStatement pst2=null;
			
			IndividualOwnerRegister inregister=new IndividualOwnerRegister();
			
			String id1=new IdGen().getId("GEN_APPOINTMENT_ID");

			ServiceAppointmentId id=new ServiceAppointmentId();
			String genId=id.genAppointmentId(id1);
			
			String status=getLoginDetails(serviceEndUser.getEMAIL());
		    
		    
			try{
				String query="insert into book_service_appointment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE())";
				String query1="insert into individual_owner_rigister values(?,?,?,?,?,?,?,?,?,?,?,CURDATE())";
				String query2="select email_id from individual_owner_rigister where email_id='"+serviceEndUser.getEMAIL()+"'";
				
				con=DBConnection.getConnection();
				pst2=con.prepareStatement(query2);
				ResultSet rs=pst2.executeQuery();
				
				while(rs.next()){
					
					IOemail=rs.getString("EMAIL_ID");
					
				}

				
			    pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
			    
			    pst.setInt(1, serviceEndUser.getSEQ_USER_ID());
			    pst.setString(2, serviceEndUser.getNAME());
			    pst.setString(3, serviceEndUser.getEMAIL());
			    pst.setString(4, serviceEndUser.getMOBILE_NO());
			    pst.setString(5, serviceEndUser.getAPPOINTMENT_DATE());
			    pst.setString(6, serviceEndUser.getVEHICLE_BRAND());
			    pst.setString(7, serviceEndUser.getVEHICLE_TYPE());
			    pst.setString(8, serviceEndUser.getMODEL());
			    pst.setString(9, serviceEndUser.getCAR_NO());
			    pst.setString(10, serviceEndUser.getRATING());
			    pst.setString(11, serviceEndUser.getSERVICE_CENTER());
			    pst.setString(12, genId);
			    if(status!=null && status.equals("ACTIVE")){
			    pst.setString(13, "YES");
			    }else{
			    	pst.setString(13, "NO");
			    }
			    pst.setString(14, "Confirm");
			    pst.setString(15, serviceEndUser.getAPPOINTMENT_DATE());
			    int i=pst.executeUpdate();
			    int j=0;
			    if(IOemail==null){
			    
			    pst1=con.prepareStatement(query1,pst.RETURN_GENERATED_KEYS);
			    pst1.setInt(1,inregister.getSEQUENTIAL_NO());
			    pst1.setString(2, "IO");
			    pst1.setString(3, inregister.getPANCARD_NO());
			    pst1.setString(4, inregister.getCITY());
			    pst1.setString(5, inregister.getPINCODE_NO());
			    pst1.setString(6, serviceEndUser.getVEHICLE_TYPE());
			    pst1.setString(7, serviceEndUser.getNAME());
			    pst1.setString(8, serviceEndUser.getMOBILE_NO());
			    pst1.setString(9, serviceEndUser.getEMAIL());
			    pst1.setString(10, "INACTIVE");
			    pst1.setString(11, "YES");
			    j=pst1.executeUpdate();
			    
			    String message1= getAndSetBookApptPsw(serviceEndUser.getEMAIL(), serviceEndUser.getPASSWORD());
			    }

			    serviceEndUser.setAPPOINTMENT_ID(genId);
			    String serviceCenterName=getServiceCenterName(serviceEndUser);
			    
			    
			    if(status==null){
			    	
			    	SendMailToUser mail=new SendMailToUser();
					mail.send(serviceEndUser.getEMAIL(),genId,serviceCenterName,serviceEndUser.getAPPOINTMENT_DATE());
			    	
			    }else if(status!=null && status.equals("INACTIVE")){
			    	
			    	SendMailToUser mail=new SendMailToUser();
					mail.send(serviceEndUser.getEMAIL(),genId,serviceCenterName,serviceEndUser.getAPPOINTMENT_DATE());
			    	
			    }else{
			    	SendEmailToUser sendMail=new SendEmailToUser();
					sendMail.sendApptIdToEndUser(serviceEndUser.getEMAIL(),genId,serviceCenterName,serviceEndUser.getAPPOINTMENT_DATE());
			    }
			    
			    if(i>0 && j>0){
			    	
					message="Your Appointment Id has been sent to your mail,your request Appointment will not accept until you verify your email ......";

			    }else if(i>0){
			    	
					message="Your request has been sent to the service center,service center will reach you soon and Appointment Id has been sent to your registered mail......";
					
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
			return message;
			
		}
	
	public String updateServiceEndUserRate(ServiceEndUser serviceEndUser){
		String message=null;
		PreparedStatement pst=null;
		try{
			String query="update book_service_appointment set RATING='"+serviceEndUser.getRATING()+"' where VEHICLE_NO='"+serviceEndUser.getCAR_NO()+"' and APPOINTMENT_ID='"+serviceEndUser.getAPPOINTMENT_ID()+"'";
			con=DBConnection.getConnection();
			
		    pst=con.prepareStatement(query);
		    int i=pst.executeUpdate();
			
			if(i>0){
				message="Thanks for your feedback for this service center......";
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
		return message;
		
	}
	public String getServiceEndUserDetails(ServiceEndUser serviceEndUser){
		String message=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String vehicleNo=null;
		String email=null;
		String apptId=null;
		try{
			String query="select VEHICLE_NO,APPOINTMENT_ID,EMAIL from book_service_appointment where APPOINTMENT_ID='"+serviceEndUser.getAPPOINTMENT_ID()+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				vehicleNo=rs.getString("VEHICLE_NO");
				email=rs.getString("EMAIL");
				apptId=rs.getString("APPOINTMENT_ID");

			}
			
			if(apptId==null){
				message="please enter correct appointment id.";
			}else if(vehicleNo!=null && !email.equals(serviceEndUser.getEMAIL())){
				message="please enter verified mail id";	
			}else if(vehicleNo!=null && !vehicleNo.equals(serviceEndUser.getCAR_NO())){
				message="This vehicle number has not been serviced with this service center,You are not allowed to rate it......";
			}
			else{
				
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
		return message;
		
	}
	public ArrayList<String> getRate(String email){
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		String rating=null;
		
		ArrayList<String> rate=new ArrayList<String>();
		try{
			String query="select RATING from book_service_appointment where SERVICE_CENTER='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				rating=rs.getString("RATING");
				rate.add(rating);
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
		return rate;	
	}
	@Override
	public String verifyBookApptEmail(String email) {
		// TODO Auto-generated method stub
		String message=null;
		PreparedStatement pst=null;
		try{
			String query="update book_service_appointment set EMAIL_VERIFICATION='YES' where EMAIL='"+email+"'";
			con=DBConnection.getConnection();
			
		    pst=con.prepareStatement(query);
		    int i=pst.executeUpdate();
			
			if(i>0){
				message="Thanks for your mail verification......";
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
		return message;
	}
	@Override
	public ArrayList<ServiceEndUser> getServiceAppointment(String date1,String date2,String email,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
			PreparedStatement pst=null;
			ResultSet rs=null;
			String query=null;
			if(!date1.isEmpty() && date2.isEmpty()){
				
				query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where appointment_date='"+date1+"' and service_center='"+email+"' and email_verification='YES' limit " + offset + ", " + noOfRecords;
				
			}else if(!date2.isEmpty() && date1.isEmpty()){
				
				query="select SQL_CALC_FOUND_ROWS  * from book_service_appointment where appointment_date='"+date2+"' and service_center='"+email+"' and email_verification='YES' limit " + offset + ", " + noOfRecords;
				
			}else if(!date1.isEmpty() && !date2.isEmpty()){
				
				query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where appointment_date between '"+date1+"' and '"+date2+"' and service_center='"+email+"' and email_verification='YES' limit " + offset + ", " + noOfRecords;
				
			}else{
				
				query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where service_center='"+email+"' and email_verification='YES' limit " + offset + ", " + noOfRecords;

				
			}
			ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetailsWithPage(query);
			
			return serviceAl;
			
	
	}
	@Override
	public String confirmServiceReqAndChangeDate(String apptId, String mdate,String email) {
		// TODO Auto-generated method stub
		String message=null;
		PreparedStatement pst=null;
		String query=null;
		String query1=null;
		int i=0;
		int j=0;
		try{
			
			con=DBConnection.getConnection();
			
			if(mdate==null){
				
			query="update book_service_appointment set STATUS='Confirmed' where appointment_id='"+apptId+"'";
			 pst=con.prepareStatement(query);
			 i=pst.executeUpdate();
			
			}else if(mdate!=null){
				
				query1="update book_service_appointment set CONFIRM_DATE='"+mdate+"' where APPOINTMENT_ID='"+apptId+"'";
				 pst=con.prepareStatement(query1);
				 j=pst.executeUpdate();
				
			}

			SendEmailToUser mail=new SendEmailToUser();
			mail.ConfirmServiceDate(email, apptId, mdate);
			
			if(i>0){
				message="Appointment is confirmed......";
			}
			
			else if(j>0){

				message="Confirm date is changed......";
			}else{
				message="Please enter correct Appointment Id......";
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
		return message;
	}
	@Override
	public int getNoOfRecords(){
		// TODO Auto-generated method stub
		return noOfRecords;
	}
	@Override
	public Set<String> getServiceStreet(String city) {
		// TODO Auto-generated method stub
		Set<String> mechanicAl=new HashSet<String>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select location from business_owner_register where b_city='"+city+"' and USER_TYPE='SC' and location is not null";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				mechanicAl.add(rs.getString("LOCATION"));
		}

		System.out.println(query);
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
	return mechanicAl;
	}
	
public String getServiceCenterName(ServiceEndUser serviceEndUser){
		
		String query=null;
		
			
			query="select * from book_service_appointment where APPOINTMENT_ID='"+serviceEndUser.getAPPOINTMENT_ID()+"'";
	
	
		ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetails(query);
		System.out.println(serviceAl);
		System.out.println(query);
		ServiceEndUser Servicename=serviceAl.get(0);
		
		String name=Servicename.getSERVICE_CENTER();
		String query1="select * from business_owner_register where email_id='"+name+"'";
		
		ArrayList<BusinessOwnerRegister> serviceCenter=getMechanicDetails(query1);
		
		BusinessOwnerRegister serviceName=serviceCenter.get(0);
		
		String name1=serviceName.getBUSINESS_NAME();
		
		return name1;
		
	}
	
public ArrayList<ServiceEndUser> getVerifiedDetails(String apptId){
	
	String query=null;
	
		
		query="select * from book_service_appointment where APPOINTMENT_ID='"+apptId+"'";

	ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetails(query);
	
	ServiceEndUser Servicename=serviceAl.get(0);
	
	String name=Servicename.getSERVICE_CENTER();
	
	String query1="select * from business_owner_register where email_id='"+name+"'";
	
	ArrayList<BusinessOwnerRegister> serviceCenter=getMechanicDetails(query1);
	
	BusinessOwnerRegister serviceName=serviceCenter.get(0);
	
	String name1=serviceName.getBUSINESS_NAME();
	
	Servicename.setSERVICE_CENTER(name1);
	
	return serviceAl;
	
}
	
	public String getLoginDetails(String email){
		
		Statement st=null;
		ResultSet rs=null;
		String status=null;
		try{
			String query="select status from user_login where status='ACTIVE' and email_id='"+email+"'";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				
			status=rs.getString("STATUS");	
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
	return status;	
		
	}

	@Override
	public ArrayList<ServiceEndUser> getServiceAppointmentDetails(String query){
		ArrayList<ServiceEndUser> serviceAl=new ArrayList<ServiceEndUser>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try{
			SQLDate formatDate=new SQLDate();
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				ServiceEndUser serviceEndUser=new ServiceEndUser();
				serviceEndUser.setNAME(rs.getString("NAME"));
				serviceEndUser.setEMAIL(rs.getString("EMAIL"));
				serviceEndUser.setMOBILE_NO(rs.getString("MOBILE_NO"));
				String date=rs.getString("APPOINTMENT_DATE");
				String fordate=formatDate.getInDate(date);
				serviceEndUser.setAPPOINTMENT_DATE(fordate);
				serviceEndUser.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				serviceEndUser.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				serviceEndUser.setCAR_NO(rs.getString("VEHICLE_NO"));
				serviceEndUser.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				serviceEndUser.setSTATUS(rs.getString("STATUS"));
				String cdate=rs.getString("CONFIRM_DATE");
				String condate=null;
				if(cdate!=null)
				{
					condate=formatDate.getInDate(cdate);
				}
				serviceEndUser.setCONFIRM_DATE(condate);
				serviceEndUser.setSERVICE_CENTER(rs.getString("SERVICE_CENTER"));
				serviceAl.add(serviceEndUser);

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
		return serviceAl;
	}
	
	@Override
	public ArrayList<ServiceEndUser> getServiceAppointmentDetailsWithPage(String query){
		ArrayList<ServiceEndUser> serviceAl=new ArrayList<ServiceEndUser>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try{
			SQLDate formatDate=new SQLDate();
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				ServiceEndUser serviceEndUser=new ServiceEndUser();
				serviceEndUser.setNAME(rs.getString("NAME"));
				serviceEndUser.setEMAIL(rs.getString("EMAIL"));
				serviceEndUser.setMOBILE_NO(rs.getString("MOBILE_NO"));
				String date=rs.getString("APPOINTMENT_DATE");
				String fordate=formatDate.getInDate(date);
				serviceEndUser.setAPPOINTMENT_DATE(fordate);
				serviceEndUser.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				serviceEndUser.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				serviceEndUser.setCAR_NO(rs.getString("VEHICLE_NO"));
				serviceEndUser.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				serviceEndUser.setSTATUS(rs.getString("STATUS"));
				String cdate=rs.getString("CONFIRM_DATE");
				String condate=formatDate.getInDate(cdate);
				serviceEndUser.setCONFIRM_DATE(condate);
				serviceEndUser.setSERVICE_CENTER(rs.getString("SERVICE_CENTER"));
				serviceAl.add(serviceEndUser);

			}
			rs.close();
			rs = pst.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next()){
				this.noOfRecords = rs.getInt(1);
         
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
		return serviceAl;
	}
	
	@Override
	public ArrayList<ServiceEndUser> viewINOServiceReq(String email) {
		// TODO Auto-generated method stub
		String query=null;
		
			
			query="select * from book_service_appointment where email='"+email+"'";
	
	
		ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetails(query);
		
		return serviceAl;
	}
	@Override
	public String getAndSetBookApptPsw(String email, String psw) {
		// TODO Auto-generated method stub
		String message=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String email_id=null;
		String logEmail=null;
		int sequential_no=0;
		try{
			String query2="select email_id from user_login where email_id='"+email+"'";
			String query="select email_id from individual_owner_rigister where email_id='"+email+"'";
			String query1="insert into user_login values(?,?,?,?,?,?)";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query2);
			rs=pst.executeQuery();
			while(rs.next()){
				
				logEmail=rs.getString("EMAIL_ID");
				
			}
			
			if(logEmail==null){
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				email_id=rs.getString("EMAIL_ID");
				
			}
		
			if(email_id!=null){
				
				pst=con.prepareStatement(query1,pst.RETURN_GENERATED_KEYS);
				
				pst.setInt(1, sequential_no);
				pst.setString(2, email);
				pst.setString(3, psw);
				pst.setString(4, "IO");
				pst.setString(5, "0");
				pst.setString(6, "INACTIVE");
				
				int i=pst.executeUpdate();
				if(i>0){
					
				}else{
					message="Request failed please try once again..";
				}
				
			}else{
				message="please enter your verified email....";
			}
			}else{
				message="your password is already available in our system...";
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
		return message;
		
	}
public String getLoginDetail(String email,String psw){
		
		Statement st=null;
		ResultSet rs=null;
		String useremail=null;
		String password=null;
		String message=null;
		try{
			String query="select * from user_login where email_id='"+email+"'";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				
			useremail=rs.getString("EMAIL_ID");	
			password=rs.getString("PASSWORD");
		}
			
			if(useremail!=null && !useremail.equals(email)){
				
				message="Please Enter Correct Email";
				
			}else if(useremail!=null && !password.equals(psw)){
				
				message="Please enter correct password";
				
			}else{
				
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
	return message;	
		
	}
	
public List<String> LoginDetails(String email){
		
		Statement st=null;
		ResultSet rs=null;
		List<String> al=new ArrayList<String>();
		try{
			String query="select * from user_login where status='ACTIVE' and email_id='"+email+"'";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				al.add(rs.getString("EMAIL_ID"));
				al.add(rs.getString("PASSWORD"));
				al.add(rs.getString("USER_TYPE"));
				al.add(rs.getString("STATUS"));
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
	return al;	
		
	}

public BusinessOwnerRegister getBookedServiceDetails(String apptId){
	
	String query=null;
	
		
		query="select * from book_service_appointment where APPOINTMENT_ID='"+apptId+"'";

	ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetails(query);
	
	ServiceEndUser Servicename=serviceAl.get(0);
	
	String name=Servicename.getSERVICE_CENTER();
	
	String query1="select * from business_owner_register where email_id='"+name+"'";
	
	ArrayList<BusinessOwnerRegister> serviceCenter=getMechanicDetails(query1);
	
	BusinessOwnerRegister serviceName=serviceCenter.get(0);
	
	SendEmailToUser serviceCenterMail=new SendEmailToUser();
	serviceCenterMail.sendMailToServiceCenter(name, Servicename);
	
	return serviceName;
	
}
public String checkRegisteredDate(String email,String vehicleNo,String semail){
	
	String message=null;
	String Registered=null;
	Statement st=null;
	ResultSet rs=null;
	List<String> al=new ArrayList<String>();
	try{
		String query="select * from book_service_appointment where EMAIL='"+email+"' and VEHICLE_NO='"+vehicleNo+"' and SERVICE_CENTER='"+semail+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
		
			Registered=rs.getString("REGISTERED_DATE");
		
		
	}
		SQLDate sdate=new SQLDate();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		  Date date=new Date();
		  String sysDate=dateFormat.format(date);
		 String sqlDate= sdate.getSQLDate(sysDate);
		  
		if(Registered!=null && Registered.equals(sqlDate)){
			
			message="You are already booked on this vehicle type.";
			
		}else{
			
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
	
	return message;
}
@Override
public ArrayList<ServiceEndUser> viewBookAppt(String email) {
	// TODO Auto-generated method stub
	String query=null;
	
		
		query="select * from book_service_appointment where email='"+email+"' ORDER BY SEQ_USER_ID desc LIMIT 1";

	ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetails(query);
	
	return serviceAl;
}

@Override
public ArrayList<ServiceEndUser> showServiceEndUserToAllDsb(String date1, String date2, String email,int offset,int noOfRecords) {
	// TODO Auto-generated method stub
	PreparedStatement pst=null;
	ResultSet rs=null;
	String query=null;
	if(!date1.isEmpty() && date2.isEmpty()){
		
		query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where appointment_date='"+date1+"' and email='"+email+"' limit " + offset + ", " + noOfRecords;
		
	}else if(!date2.isEmpty() && date1.isEmpty()){
		
		query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where appointment_date='"+date2+"' and email='"+email+"' limit " + offset + ", " + noOfRecords;
		
	}else if(!date1.isEmpty() && !date2.isEmpty()){
		
		query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where appointment_date between '"+date1+"' and '"+date2+"' and email='"+email+"' limit " + offset + ", " + noOfRecords;
		
	}else{
		
		query="select SQL_CALC_FOUND_ROWS * from book_service_appointment where email='"+email+"' limit " + offset + ", " + noOfRecords;

		
	}
	ArrayList<ServiceEndUser> serviceAl=getServiceAppointmentDetailsWithPage(query);
	
	return serviceAl;
}

@Override
public List<BusinessOwnerRegister> showServiceCenterToAllDsb(String email) {
	// TODO Auto-generated method stub
	List<BusinessOwnerRegister> mechanicAl=new ArrayList<BusinessOwnerRegister>();
	Statement st=null;
	ResultSet rs=null;
	try{
		String query="select * from business_owner_register where email_id='"+email+"'";
		con=DBConnection.getConnection();
		st=con.createStatement();
		rs=st.executeQuery(query);
		while(rs.next()){
			BusinessOwnerRegister mBean=new BusinessOwnerRegister();
			mBean.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
			mBean.setEMAIL_ID(rs.getString("EMAIL_ID"));
			mBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
			
			mechanicAl.add(mBean);
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
	return mechanicAl;
}


@Override
public Set<String> displayHBrand(String mail){
	Set<String> brand=new HashSet<String>();
	Statement st=null;
	ResultSet rs=null;
	String query="SELECT VEHICLE_BRAND FROM service_type where EMAIL_ID='"+mail+"' and VEHICLE_BRAND is not null";
	try{
	con=DBConnection.getConnection();
	st=con.createStatement();
	rs=st.executeQuery(query);
	while(rs.next()){
		brand.add(rs.getString("VEHICLE_BRAND"));

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
return brand;
	
}



}
