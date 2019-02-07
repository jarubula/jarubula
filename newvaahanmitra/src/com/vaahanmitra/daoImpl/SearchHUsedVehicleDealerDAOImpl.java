package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.SearchHUsedVehicleDealerDAO;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.BusinessOwnerRegister;

public class SearchHUsedVehicleDealerDAOImpl implements SearchHUsedVehicleDealerDAO{

	private   Connection con=null;
	private int noOfRecords=0;
	
	@Override
	public ArrayList<BusinessOwnerRegister> getCity() {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select b_city from business_owner_register where user_type='UD' and b_city is not null group by b_city";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				BusinessOwnerRegister usedCar=new BusinessOwnerRegister();
				usedCar.setB_CITY(rs.getString("B_CITY"));
				dealerAl.add(usedCar);
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
	return dealerAl;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getDealerName(String city) {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select business_name from business_owner_register where user_type='UD' and b_city='"+city+"' and business_name is not null group by business_name";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				BusinessOwnerRegister usedCar=new BusinessOwnerRegister();
				usedCar.setNAME(rs.getString("BUSINESS_NAME"));
				dealerAl.add(usedCar);
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
	return dealerAl;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getUsedVehicleDealerDetails(String query) {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		byte photo[];
        Blob blob;
		try{
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next()){
				BusinessOwnerRegister dBean=new BusinessOwnerRegister();
				dBean.setNAME(rs.getString("BUSINESS_NAME"));
				dBean.setADDRESS(rs.getString("ADDRESS"));
				dBean.setB_CITY(rs.getString("B_CITY"));
				dBean.setDISTRICT(rs.getString("DISTRICT"));
				dBean.setSTATE(rs.getString("STATE"));
				dBean.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				dBean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				dBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				dBean.setVERIFIED(rs.getString("VERIFIED"));
				dBean.setSTATUS(rs.getString("STATUS"));
				blob=rs.getBlob("PHOTO");
				if(blob!=null){
				photo=blob.getBytes(1, (int)blob.length());
				String photo1 = Base64.encode(photo);
				dBean.setPHOTO(photo1);
				}
				dealerAl.add(dBean);
				
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
		return dealerAl;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> searchHUsedVehicleDealer(BusinessOwnerRegister bean) {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		
		String query=null;

		try{
			
			 if(bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY()!=null && bean.getNAME().equals("SELECT")){
				
				
				 query="select * from business_owner_register where user_type='UD' and b_city='"+bean.getB_CITY()+"'";

				
			}	
				
			 else if(bean.getVEHICLE_TYPE()!=null && bean.getB_CITY().equals("SELECT") && bean.getNAME().equals("SELECT")){
				 
				 if(bean.getVEHICLE_TYPE().equals("4,2,")){
					 
					 query="select * from business_owner_register where user_type='UD'";

					 
				 }else{
				 
				 query="select * from business_owner_register where user_type='UD' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%'";

				 }
				 }else if(bean.getVEHICLE_TYPE()!=null && bean.getB_CITY()!=null && bean.getNAME().equals("SELECT")){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					 query="select * from business_owner_register where user_type='UD' and  b_city='"+bean.getB_CITY()+"'";

				}else{
					 query="select * from business_owner_register where user_type='UD' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%' and b_city='"+bean.getB_CITY()+"'";
				}
			}else if(bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY().equals("SELECT") && bean.getNAME()!=null){
				
				
				query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"'";
				
			}else if(bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY()!=null && bean.getNAME()!=null){
				
				
				query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"'";
				
			}else if(bean.getVEHICLE_TYPE()!=null && bean.getB_CITY().equals("SELECT") && bean.getNAME()!=null){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"'";

				}else{
				
				query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%'";
				}
			}else if(bean.getVEHICLE_TYPE()!=null && bean.getB_CITY()!=null && bean.getNAME()!=null){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"'";

				}else{
				
				query="select * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%'";
				}	
			}
			
			dealerAl=getUsedVehicleDealerDetails(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dealerAl;
	}
	@Override
	public ArrayList<BusinessOwnerRegister> searchHUsedVehicleDealer(BusinessOwnerRegister bean,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		
		String query=null;

		try{
			if(bean.getVEHICLE_TYPE()==null && bean.getB_CITY()==null && bean.getNAME()==null){
				
				 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' limit " + offset + ", " + noOfRecords;

				
			}
			else if((bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY().equals("All")) || (bean.getB_CITY().equals("All") && bean.getVEHICLE_TYPE().equals("All")) || (bean.getB_CITY().equals("All") && bean.getNAME().equals("All")) || (bean.getB_CITY().equals("All") && bean.getVEHICLE_TYPE().equals("All") && bean.getNAME().equals("All"))){
					
					
				 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' limit " + offset + ", " + noOfRecords;

				
			}	
			
			 else if((bean.getVEHICLE_TYPE().equals("SELECT") || bean.getVEHICLE_TYPE().equals("4,2,")) && !bean.getB_CITY().equals("SELECT") && (bean.getNAME().equals("SELECT") || bean.getNAME().equals("All"))){
				
				
				 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and b_city='"+bean.getB_CITY()+"' limit " + offset + ", " + noOfRecords;

				
			}	
				
			 else if(!bean.getVEHICLE_TYPE().equals("SELECT") && (bean.getB_CITY().equals("SELECT") || bean.getB_CITY().equals("All")) && bean.getNAME().equals("SELECT")){
				 
				 if(bean.getVEHICLE_TYPE().equals("4,2,")){
					 
					 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' limit " + offset + ", " + noOfRecords;

					 
				 }else{
				 
				 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%' limit " + offset + ", " + noOfRecords;

				 }
				 }else if(!bean.getVEHICLE_TYPE().equals("SELECT") && !bean.getB_CITY().equals("SELECT") && bean.getNAME().equals("SELECT")){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and  b_city='"+bean.getB_CITY()+"' limit " + offset + ", " + noOfRecords;

				}else{
					 query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%' and b_city='"+bean.getB_CITY()+"' limit " + offset + ", " + noOfRecords;
				}
			}else if(bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY().equals("SELECT") && !bean.getNAME().equals("SELECT")){
				
				
				query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' limit " + offset + ", " + noOfRecords;
				
			}else if(bean.getVEHICLE_TYPE().equals("SELECT") && !bean.getB_CITY().equals("SELECT") && !bean.getNAME().equals("SELECT")){
				
				
				query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"' limit " + offset + ", " + noOfRecords;
				
			}else if(!bean.getVEHICLE_TYPE().equals("SELECT") && bean.getB_CITY().equals("SELECT") && !bean.getNAME().equals("SELECT")){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' limit " + offset + ", " + noOfRecords;

				}else{
				
				query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%' limit " + offset + ", " + noOfRecords;
				}
			}else if(!bean.getVEHICLE_TYPE().equals("SELECT") && !bean.getB_CITY().equals("SELECT") && !bean.getNAME().equals("SELECT")){
				
				if(bean.getVEHICLE_TYPE().equals("4,2,")){
					
					query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"' limit " + offset + ", " + noOfRecords;

				}else{
				
				query="select SQL_CALC_FOUND_ROWS * from business_owner_register where user_type='UD' and business_name='"+bean.getNAME()+"' and b_city='"+bean.getB_CITY()+"' and vehicle_type like '%"+bean.getVEHICLE_TYPE()+"%' limit " + offset + ", " + noOfRecords;
				}	
			}
			dealerAl=getUsedVehicleDealerDetails(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dealerAl;
	}
	
	@Override
	public int getNoOfRecords(){
		// TODO Auto-generated method stub
		return noOfRecords;
	}

	@Override
	public String addDocument(String user_name, String brand, String documentName,String v_type, InputStream is) {
		 String message = null;
		  try {
			con = DBConnection.getConnection();
			/*String checkUser = searchDealer(user_name);*/
			String query = "insert into dealer_authentication values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, 0);
			pstmt.setString(2, user_name);
			pstmt.setString(3, brand);
			pstmt.setString(4, documentName);
			pstmt.setBinaryStream(5, is);
			pstmt.setString(6, "P");
			pstmt.setString(7, "NO");
			pstmt.setString(8, v_type);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "Documents not added! Please try again!";
			}
			pstmt.close();
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

	public String searchDealer(String user_name){
		
		return user_name;
	}
	@Override
	public boolean checkbranddoc(String user_id, String brand, String v_type) {
		// TODO Auto-generated method stub
		 Statement st = null;
		  ResultSet rs = null;
		  
		 boolean flag=false;
		  int count=0;
		  try {
			  con = DBConnection.getConnection();
			   st = con.createStatement();
			   rs = st.executeQuery("select count(*) from dealer_authentication where DEALER_NAME='"+user_id+"' and BRAND_NAME='"+brand+"' and VEHICLE_TYPE='"+v_type+"'");
			 
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }
			if (count > 0) {
				flag=true;
			}
			else{
				flag=false;
			}
		  
		
			rs.close();
			  st.close();
		  
		  } 
		  catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return flag;
	}
}
