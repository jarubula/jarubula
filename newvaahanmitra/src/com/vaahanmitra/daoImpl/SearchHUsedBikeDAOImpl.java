package com.vaahanmitra.daoImpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.CarAge;
import com.vaahanmitra.utilities.SQLDate;

public class SearchHUsedBikeDAOImpl implements SearchHUsedBikeDAO{

	private   Connection con=null;
	private int noOfRecords=0;
	
	@Override
	public ArrayList<UsedBike> getUsedBikeDetails(String query) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte photo1[];
	        Blob blob1;
			while(rs.next()){
				UsedBike bean=new UsedBike();
				bean.setSEQUENCE_NO(rs.getInt("SEQUENCE_NO"));
				bean.setUSER_NAME(rs.getString("USER_NAME"));
				bean.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bean.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bean.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				bean.setCOLOR(rs.getString("COLOR"));
				bean.setSTARTING_SYSTEM(rs.getString("STARTING_SYSTEM"));
				bean.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				bean.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				blob1=rs.getBlob("PHOTO1");
				if (blob1 != null) {
					photo1 = blob1.getBytes(1, (int) blob1.length());
					String fphoto = Base64.encode(photo1);
					bean.setPHOTO1(fphoto);
				}
				bean.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				bean.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				bean.setUSED_BY(rs.getString("USED_BY"));
				bean.setNO_OF_OWNERS(rs.getInt("NO_OF_OWNERS"));
				bean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				bean.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
//				bean.setSELLER_TYPE(rs.getString("SELLER_TYPE"));
				bean.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				bean.setUPDATED_DATE(new SQLDate().getInDate(rs.getString("UPDATED_DATE")));
				bean.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				bikeAl.add(bean);
				
			}
			rs.close();
			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
				this.noOfRecords = rs.getInt(1);
			
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
		return bikeAl;
	}
	@Override
	public ArrayList<UsedBike> searchHUsedBike(UsedBike bean, int offset, int noOfRecords) {
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		String query = null;
		String year1 = null;
		String year2 = null;
		String price1 = null;
		String price2 = null;
		CarAge carAge = new CarAge();
		// if (bean.getREGISTERED_YEAR()!=null) {
		// CarAge carAge = new CarAge();
		// ArrayList bikeAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());
		//
		// year1 = (String) bikeAl1.get(0);
		// year2 = (String) bikeAl1.get(1);
		// }
		if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("null")) {
			if (!bean.getREGISTERED_YEAR().isEmpty()) {
				// CarAge carAge=new CarAge();
				ArrayList bikeAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());
				year1 = (String) bikeAl1.get(0);
				year2 = (String) bikeAl1.get(1);
			}
		}
		/*
		 * if (temp!=null && !temp.equals("null")) {
		 * 
		 * } else {
		 * 
		 * ArrayList bikeAll = carAge.getCarAge(bean.getREGISTERED_YEAR());
		 * year1 = (String) bikeAll.get(0); year2 = (String) bikeAll.get(1); }
		 */
		if (bean.getOFFER_PRICE() != null && !bean.getOFFER_PRICE().equals("null")) {
			if (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) {

			} else {
				ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}
		String carBrand = bean.getBIKE_BRAND(), city = bean.getCITY(), color = bean.getCOLOR(),
				mileage = bean.getCURRENT_MILEAGE();
		int owners = bean.getNO_OF_OWNERS();

		try {
			
System.out.println(bean.getBIKE_BRAND()+bean.getBIKE_MODEL()+bean.getVARIANT_NAME()+bean.getOFFER_PRICE()+bean.getCITY());			
			
if(bean.getBIKE_BRAND()==null && bean.getBIKE_MODEL()==null && bean.getVARIANT_NAME()==null && bean.getOFFER_PRICE()==null && bean.getCITY()==null){
				
				query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				
			}
			else if((bean.getBIKE_BRAND().equals("All") && bean.getBIKE_MODEL().equals("SELECT")) || (bean.getBIKE_BRAND().equals("All") && bean.getBIKE_MODEL().equals("All")) || (bean.getBIKE_BRAND().equals("All") && bean.getBIKE_MODEL().equals("All") && bean.getOFFER_PRICE().equals("Any")) || (bean.getBIKE_BRAND().equals("All") && bean.getBIKE_MODEL().equals("All") && bean.getOFFER_PRICE().equals("Any") && bean.getCITY().equals("All")) || 
				     (bean.getBIKE_BRAND().equals("All") && bean.getCITY().equals("All")) || (bean.getBIKE_BRAND().equals("All") && bean.getOFFER_PRICE().equals("Any")) || (bean.getBIKE_BRAND().equals("All") && bean.getOFFER_PRICE().equals("Any") && bean.getCITY().equals("All")) || (bean.getBIKE_MODEL().equals("SELECT") && bean.getOFFER_PRICE().equals("Any")) || (bean.getBIKE_MODEL().equals("SELECT") && bean.getCITY().equals("All"))){
				     
				    query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				     
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && (bean.getBIKE_MODEL().equals("SELECT") || bean.getBIKE_MODEL().equals("All")) && (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) && (bean.getCITY().equals("SELECT") || bean.getCITY().equals("All"))){
				    
				     
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
				    
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT")&& (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT")&& ! bean.getVARIANT_NAME().equals("SELECT") && bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
			    
			    
			     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and VARIANT_NAME = '"+bean.getVARIANT_NAME()+"'  and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

			    
			   }
				
			else if((bean.getBIKE_BRAND().equals("SELECT")  || bean.getBIKE_BRAND().equals("All")) && bean.getBIKE_MODEL().equals("SELECT") && (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && !bean.getOFFER_PRICE().equals("SELECT") && (bean.getCITY().equals("SELECT") || bean.getCITY().equals("All"))){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			else if(!bean.getBIKE_BRAND().equals("SELECT") && (bean.getBIKE_MODEL().equals("SELECT")||bean.getBIKE_MODEL().equals("All"))&& (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
			    
			    
			     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"'  and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

			    
			   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT") && (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT") && !bean.getVARIANT_NAME().equals("SELECT")  && !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
			    
			    
			     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

			    
			   }
			
			else if((bean.getBIKE_BRAND().equals("SELECT") || bean.getBIKE_BRAND().equals("All")) && (bean.getBIKE_MODEL().equals("SELECT") || bean.getBIKE_MODEL().equals("All")) && (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) && !bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT") && !bean.getOFFER_PRICE().equals("SELECT")&& (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && !bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && bean.getBIKE_MODEL().equals("SELECT") && !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && bean.getBIKE_MODEL().equals("SELECT") && (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All"))&& bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			
			else if(bean.getBIKE_BRAND().equals("SELECT") && bean.getBIKE_MODEL().equals("SELECT")&& bean.getVARIANT_NAME().equals("SELECT") && !bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  CITY='"+bean.getCITY()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   }
			
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT")&& (bean.getVARIANT_NAME().equals("SELECT") || bean.getVARIANT_NAME().equals("All")) && bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
				    
				    
				     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

				    
				   } 
			else if(!bean.getBIKE_BRAND().equals("SELECT") && !bean.getBIKE_MODEL().equals("SELECT")&& !bean.getVARIANT_NAME().equals("SELECT") && bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
			    
			    
			     query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+bean.getBIKE_BRAND()+"' and BIKE_MODEL='"+bean.getBIKE_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;

			    
			   } 
		
			
			else if (color != null && !color.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  color='"
						+ bean.getCOLOR() + "' and status='ACTIVE' and available='Y' limit " + offset + ", "
						+ noOfRecords;

			} else if (mileage != null && !mileage.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  current_mileage between '"
						+ bean.getCURRENT_MILEAGE() + "' and '80000' and status='ACTIVE' and available='Y' limit "
						+ offset + ", " + noOfRecords;

			} else if (owners != 0) {

				if (owners == 1 || owners == 2) {

					query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  no_of_owners='"
							+ bean.getNO_OF_OWNERS() + "' and status='ACTIVE' and available='Y' limit " + offset + ", "
							+ noOfRecords;

				} else if (owners == 3) {

					query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  no_of_owners>'2' and status='ACTIVE' and available='Y' limit "
							+ offset + ", " + noOfRecords;

				}

			} else if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where REGISTERED_YEAR between '"
						+ year2 + "' and '" + year1 + "' and status='ACTIVE' and available='Y' limit " + offset + ", "
						+ noOfRecords;

			} else if (bean.getPRICE() != null && bean.getPRICE().equals("0")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where status='ACTIVE' and available='Y' order by OFFER_PRICE ASC limit "
						+ offset + ", " + noOfRecords;

			} else if (bean.getPRICE() != null && bean.getPRICE().equals("1")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where status='ACTIVE' and available='Y' order by OFFER_PRICE ASC limit "
						+ offset + ", " + noOfRecords;

			} else {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where status='ACTIVE' and available='Y' limit "
						+ offset + ", " + noOfRecords;

			}
			bikeAl = getUsedBikeDetails(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bikeAl;
	}
	

	@Override
	public ArrayList<UsedBike> getBikeBrand() {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select bike_brand from used_bike where bike_brand is not null group by bike_brand";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedBike usedBike=new UsedBike();
				usedBike.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bikeAl.add(usedBike);
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
	return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getBikeModel(String bikeModel) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select bike_model from used_bike where bike_brand='"+bikeModel+"' group by bike_model";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedBike usedBike=new UsedBike();
				usedBike.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bikeAl.add(usedBike);
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
	return bikeAl;
	}
	
	@Override
	public ArrayList<UsedBike> getBikeVariant(String bikeBrand,String bikeModel) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select VARIANT_NAME from used_bike where bike_brand='"+bikeBrand+"' and bike_model = '"+bikeModel+"' group by VARIANT_NAME";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedBike usedBike=new UsedBike();
				usedBike.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				bikeAl.add(usedBike);
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
	return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getUsedBikeCity() {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select city FROM used_bike where city is not null group by city";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedBike usedBike=new UsedBike();
				usedBike.setCITY(rs.getString("CITY"));;
				bikeAl.add(usedBike);
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
	return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getUsedBikeBudget(String budget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertEndUserDetails(BikeEndUser endUser, String bikeId) {
		// TODO Auto-generated method stub
		String message=null;
		PreparedStatement pst=null;
		try{
			
			con=DBConnection.getConnection();
		    pst=con.prepareStatement("insert into end_user_details values(?,?,?,?,?,CURDATE(),?,?)",pst.RETURN_GENERATED_KEYS);
		    pst.setInt(1, endUser.getENDUSER_SEQ_ID());
		    pst.setString(2, endUser.getNAME());
		    pst.setString(3, endUser.getEMAIL());
		    pst.setString(4, endUser.getMOBILE_NO());
		    pst.setString(5, bikeId);
		    pst.setString(6, endUser.getVEHICLE_TYPE());
		    pst.setString(7, "N");
		    int i=pst.executeUpdate();
			
			if(i>0){
				message="Your Details are added SuccessFully......";
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
	public ArrayList<UsedBike> compareUsedBike(ArrayList bikeId) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		String query=null;
		String query1=null;
		
		try{
			for(int i=0;bikeId.size()>i;i++){
				
				if(i==0){
					
				//query="select * FROM used_car where gen_car_id='"+carId.get(i)+"' union all"+" ";
					
					query="select used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where gen_bike_id='"+bikeId.get(i)+"' union all"+" ";

				
				}else if(bikeId.size()-1>i){
					
					query= query+"select used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where gen_bike_id='"+bikeId.get(i)+"' union all"+" ";
					
					query1= query;
					
				}else if(bikeId.size()>i){
					
					query=query+"select used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where gen_bike_id='"+bikeId.get(i)+"'";
					
					query1= query;
				}
				
			}
bikeAl=getUsedBikeDetails(query1);	
			
			
	}catch(Exception e){
		e.printStackTrace();
	}
	return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getBikeImage(String bikeNumber) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select * from bike_photos where bike_number='"+bikeNumber+"'";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte photo1[],photo2[],photo3[],photo4[],photo5[],photo6[],photo7[],photo8[],photo9[],photo10[],photo11[],photo12[];
	        Blob blob1,blob2,blob3,blob4,blob5,blob6,blob7,blob8,blob9,blob10,blob11,blob12;
			while(rs.next()){
				UsedBike bean=new UsedBike();

				blob1=rs.getBlob("PHOTO1");
				blob2=rs.getBlob("PHOTO2");
				blob3=rs.getBlob("PHOTO3");
				blob4=rs.getBlob("PHOTO4");
				blob5=rs.getBlob("PHOTO5");
				blob6=rs.getBlob("PHOTO6");
				blob7=rs.getBlob("PHOTO7");
				blob8=rs.getBlob("PHOTO8");
				blob9=rs.getBlob("PHOTO9");
				blob10=rs.getBlob("PHOTO10");
				blob11=rs.getBlob("PHOTO11");
				blob12=rs.getBlob("PHOTO12");
				
				if(blob1!=null){
					
				photo1=blob1.getBytes(1, (int)blob1.length());
				String fphoto = Base64.encode(photo1);
				bean.setPHOTO1(fphoto);
				
				}if(blob2!=null){
					
				photo2=blob2.getBytes(1, (int)blob2.length());
				String sphoto = Base64.encode(photo2);
				bean.setPHOTO2(sphoto);
				}if(blob3!=null){
					
				photo3=blob3.getBytes(1, (int)blob3.length());
				String tphoto = Base64.encode(photo3);
				bean.setPHOTO3(tphoto);
				
				}if(blob4!=null){
					
				photo4=blob4.getBytes(1, (int)blob4.length());
				String fophoto = Base64.encode(photo4);
				bean.setPHOTO4(fophoto);
				
				}if(blob5!=null){
				photo5=blob5.getBytes(1, (int)blob5.length());
				String fiphoto = Base64.encode(photo5);
				bean.setPHOTO5(fiphoto);
				}if(blob6!=null){
					
				photo6=blob6.getBytes(1, (int)blob6.length());
				String siphoto = Base64.encode(photo6);
				bean.setPHOTO6(siphoto);
				
				}if(blob7!=null){
					
				photo7=blob7.getBytes(1, (int)blob7.length());
				String sephoto = Base64.encode(photo7);
				bean.setPHOTO7(sephoto);
				
				}if(blob8!=null){
					
				photo8=blob8.getBytes(1, (int)blob8.length());
				String eiphoto = Base64.encode(photo8);
				bean.setPHOTO8(eiphoto);
				
				}if(blob9!=null){
					
				photo9=blob9.getBytes(1, (int)blob9.length());
				String niphoto = Base64.encode(photo9);
				bean.setPHOTO9(niphoto);
				
				}if(blob10!=null){
					
				photo10=blob10.getBytes(1, (int)blob10.length());
				String tephoto = Base64.encode(photo10);
				bean.setPHOTO10(tephoto);
				
				}if(blob11!=null){
					
				photo11=blob11.getBytes(1, (int)blob11.length());
				String elephoto = Base64.encode(photo11);
				bean.setPHOTO11(elephoto);
				
				}if(blob12!=null){
					
				photo12=blob12.getBytes(1, (int)blob12.length());
				String twephoto = Base64.encode(photo12);
				bean.setPHOTO12(twephoto);
				
				}
				bikeAl.add(bean);
				System.out.println("ssssssss");
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
		return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> searchHDealerUsedBike(UsedBike bean, int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		String query = null;
		String year1 = null;
		String year2 = null;
		String price1 = null;
		String price2 = null;

		System.out.println("year" + bean.getEMAIL_ID());
		if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("null")) {
			CarAge carAge = new CarAge();
			ArrayList bikeAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());

			year1 = (String) bikeAl1.get(0);
			year2 = (String) bikeAl1.get(1);
		}
		if (bean.getOFFER_PRICE() != null && !bean.getOFFER_PRICE().equals("null") ) {
			if (bean.getOFFER_PRICE().equals("") || bean.getOFFER_PRICE().equals("Any") ) {

			} else {
				CarAge carAge = new CarAge();
				ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}
		/*
		 * System.out.println("BIKE AGE :: " + bean.getREGISTERED_YEAR());
		 * String temp = bean.getREGISTERED_YEAR(); CarAge carAge = new
		 * CarAge(); if (temp.equals("")) {
		 * 
		 * } else { ArrayList bikeAll =
		 * carAge.getCarAge(bean.getREGISTERED_YEAR()); year1 = (String)
		 * bikeAll.get(0); year2 = (String) bikeAll.get(1); }
		 * 
		 * if (temp.equals("")) {
		 * System.out.println("price"+bean.getOFFER_PRICE()); if
		 * (bean.getOFFER_PRICE().equals("SELECT") && bean.getOFFER_PRICE() ==
		 * null) {
		 * 
		 * } else { ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
		 * price1 = (String) carAl1.get(0); price2 = (String) carAl1.get(1); } }
		 */

		String bikeBrand = bean.getBIKE_BRAND(), city = bean.getCITY(), color = bean.getCOLOR(),
				mileage = bean.getCURRENT_MILEAGE();
		int owners = bean.getNO_OF_OWNERS();

		try {
			if((bikeBrand!=null && !bikeBrand.equals("null") && bikeBrand.equals("All")) || (bean.getOFFER_PRICE()!=null && !bean.getOFFER_PRICE().equals("null") && bean.getOFFER_PRICE().equals("Any"))){
			    
			    
			    query="SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where user_name='"+bean.getEMAIL_ID()+"' limit " + offset + ", " + noOfRecords;
			    
			   }

			else if (city != null && !city.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  CITY='"
						+ bean.getCITY() + "' and user_name='" + bean.getEMAIL_ID() + "' limit " + offset + ", "
						+ noOfRecords;

			} else if (bikeBrand != null && !bikeBrand.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  bike_brand='"
						+ bean.getBIKE_BRAND() + "' and user_name='" + bean.getEMAIL_ID() + "' limit " + offset + ", "
						+ noOfRecords;

			} else if (color != null && !color.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  color='"
						+ bean.getCOLOR() + "' and user_name='" + bean.getEMAIL_ID() + "' limit " + offset + ", "
						+ noOfRecords;

			} /*
				 * else if(fuelType!=null){
				 * 
				 * 
				 * query=
				 * "SELECT used_car.*,car_photos.* from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  fuel_type='"
				 * +bean.getFUEL_TYPE()+"'";
				 */
			/* } */else if (mileage != null && !mileage.equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  current_mileage between '"
						+ bean.getCURRENT_MILEAGE() + "' and '80000' and user_name='" + bean.getEMAIL_ID() + "' limit "
						+ offset + ", " + noOfRecords;

			} else if (owners != 0) {

				if (owners == 1 || owners == 2) {

					query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  no_of_owners='"
							+ bean.getNO_OF_OWNERS() + "' and user_name='" + bean.getEMAIL_ID() + "' limit " + offset
							+ ", " + noOfRecords;

				} else if (owners == 3) {

					query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  no_of_owners>'2' and user_name='"
							+ bean.getEMAIL_ID() + "' limit " + offset + ", " + noOfRecords;

				}

			} /*
				 * else if(bean.getTRANSIMISSION()!=null){
				 * 
				 * 
				 * query=
				 * "SELECT used_car.*,car_photos.* from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"
				 * +bean.getTRANSIMISSION()+"'";
				 * 
				 * }
				 *//*
				 * else if(bean.getSELLER_TYPE()!=null){
				 * 
				 * 
				 * query=
				 * "SELECT used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  seller_type='"
				 * +bean.getSELLER_TYPE()+"'";
				 * 
				 * }
				 */else if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where REGISTERED_YEAR between '"
						+ year2 + "' and '" + year1 + "' and user_name='" + bean.getEMAIL_ID() + "' limit " + offset
						+ ", " + noOfRecords;

			} else if (bean.getOFFER_PRICE() != null && !bean.getOFFER_PRICE().equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.* from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where OFFER_PRICE>'"
						+ price1 + "' and OFFER_PRICE<'" + price2 + "' and user_name='" + bean.getEMAIL_ID()
						+ "' limit " + offset + ", " + noOfRecords;

			} else if (bean.getPRICE() != null && bean.getPRICE().equals("0")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,bike_photos.* from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  user_name='"
						+ bean.getEMAIL_ID() + "' order by OFFER_PRICE ASC limit " + offset + ", " + noOfRecords;

			} else if (bean.getPRICE() != null && bean.getPRICE().equals("1")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,bike_photos.* from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  user_name='"
						+ bean.getEMAIL_ID() + "' order by OFFER_PRICE DESC limit " + offset + ", " + noOfRecords;

			} else if (bean.getEMAIL_ID() != null && !bean.getEMAIL_ID().equals("null")) {

				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.* from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  user_name='"
						+ bean.getEMAIL_ID() + "' limit " + offset + ", " + noOfRecords;

			}

			bikeAl = getUsedBikeDetails(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bikeAl;
	}
	@Override
	public String varifyEmailId(String bikeId, String email, String mobileNo) {
		String message = "";
		con = DBConnection.getConnection();
		String userType= null;
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		try {
			dao.updateStatus(email, userType);
		} catch (IndividualOwnerException e1) {
			e1.printStackTrace();
		}
		try {
			String query = "UPDATE end_user_details SET EMAIL_VERIFICATION='Y' WHERE MOBILE_NO='" + mobileNo
					+ "' and VEHICLE_ID='" + bikeId + "' and EMAIL='" + email + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			int j = preparedStatement.executeUpdate();
			if (j > 0) {
				message = "YOUR EMAIL ID SUCCESSFULLY VERIFIED";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@Override
	public ArrayList<UsedBike> searchUsedBike(String brand) {
		ArrayList<UsedBike> al = new ArrayList<UsedBike>();
		try {
			String query = null;
			con = DBConnection.getConnection();
			query = "SELECT used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  bike_BRAND='"+brand+"'";
			System.out.println(query);
			PreparedStatement preparedStatement = con.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedBike ub = new UsedBike();
				ub.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				ub.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				ub.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ub.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ub.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				ub.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				ub.setCOLOR(rs.getString("COLOR"));
				ub.setINSURANCE_COMPANY_NAME(rs.getString("iNSURANCE_COMPANY_NAME"));
				ub.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				ub.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				ub.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				ub.setUSED_BY(rs.getString("USED_BY"));
				ub.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setADDRESS(rs.getString("ADDRESS"));
				ub.setCITY(rs.getString("CITY"));
				ub.setSTATE(rs.getString("STATE"));
				ub.setDISTRICT(rs.getString("DISTRICT"));
				ub.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				ub.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
				ub.setSTATUS(rs.getString("STATUS"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				ub.setPHOTO1(photo10);
				al.add(ub);
			}
		} catch (Exception e) {
		}
		return al;
	}
	@Override
	public ArrayList<String> getRequesters(String email) {
		ArrayList<String> bikeAl = new ArrayList<String>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT VEHICLE_ID from end_user_details where EMAIL='"+email+"' and EMAIL_VERIFICATION='Y' and VEHICLE_TYPE='2'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				bikeAl.add(rs.getString("VEHICLE_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bikeAl;
	}
	@Override
	public String insertUserRequest(BikeEndUser endUser, String bikeId) {
		PreparedStatement pst = null;
		String message = null;
		try {

			con = DBConnection.getConnection();
			pst = con.prepareStatement("insert into end_user_details values(?,?,?,?,?,CURDATE(),?,?)",pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, endUser.getENDUSER_SEQ_ID());
			pst.setString(2, endUser.getNAME());
			pst.setString(3, endUser.getEMAIL());
			pst.setString(4, endUser.getMOBILE_NO());
			pst.setString(5, bikeId);
			pst.setString(6, "2");
			pst.setString(7, "Y");
			int i = pst.executeUpdate();
			if (i > 0) {
				message = "Your request has been sent! on bike id '"+bikeId+"'";
			} else {
				message = "You are Not registered! Please try again.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return message;
	}
	@Override
	public int getNoOfRecords() {
		// TODO Auto-generated method stub
		return noOfRecords;
	}
	@Override
	public List<UsedBike> getUsedBikeDetailsByCarNo(String bikeNo) {
		// TODO Auto-generated method stub
		ArrayList<UsedBike> bikeAl=new ArrayList<UsedBike>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="SELECT * from used_bike where BIKE_NUMBER='"+bikeNo+"' and status='ACTIVE' and available='Y'";

			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte photo1[];
	        Blob blob1;
			while(rs.next()){
				UsedBike bean=new UsedBike();
				/*bean.setSEQUENCE_NO(rs.getInt("SEQUENCE_NO"));
				bean.setUSER_NAME(rs.getString("USER_NAME"));*/
				bean.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bean.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bean.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				bean.setCOLOR(rs.getString("COLOR"));

				bean.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
			/*	bean.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				bean.setUSED_BY(rs.getString("USED_BY"));
				bean.setNO_OF_OWNERS(rs.getInt("NO_OF_OWNERS"));
				bean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));*/
				bean.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				bean.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
//				bean.setSELLER_TYPE(rs.getString("SELLER_TYPE"));
				bean.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				bean.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				bikeAl.add(bean);
				
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
		return bikeAl;
	}

	@Override
	public List<UsedBike> getUsedBikeByBikeNo(String brand, String price, String kmsDriven,String bikeNo) {
		String query="SELECT used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+brand+"' and OFFER_PRICE='"+price+"' and KMS_DRIVEN='"+kmsDriven+"' and used_bike.BIKE_NUMBER!='"+bikeNo+"' and status='ACTIVE' and available='Y'";
		ArrayList<UsedBike> bikeAl=getUsedBikeDetails(query);
		return bikeAl;
	}
	@Override
	public List<UsedBike> getDealerUsedBike(String brand, String price, String kmsDriven,String bikeNo,String demail) {
		String query="SELECT used_bike.*,bike_photos.photo1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where BIKE_BRAND='"+brand+"' and OFFER_PRICE='"+price+"' and KMS_DRIVEN='"+kmsDriven+"' and used_bike.BIKE_NUMBER!='"+bikeNo+"' and USER_NAME='"+demail+"' and status='ACTIVE' and available='Y'";
		System.out.println(query);
		ArrayList<UsedBike> bikeAl=getUsedBikeDetails(query);
		return bikeAl;
	}
}
