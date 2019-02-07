package com.vaahanmitra.daoImpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.CarAge;
import com.vaahanmitra.service.SendMail;
import com.vaahanmitra.utilities.SQLDate;

public class CarDAOImpl implements CarDAO{
	
	private   Connection con=null;
	private int noOfRecords=0;

	public ArrayList<UsedCar> getUsedCarDetails(String query) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte photo1[];
	        Blob blob1;
			while(rs.next()){
				UsedCar bean=new UsedCar();
				bean.setSEQUENCE_NO(rs.getInt("SEQUENCE_NO"));
				bean.setUSER_NAME(rs.getString("USER_NAME"));
				bean.setCAR_BRAND(rs.getString("CAR_BRAND"));
				bean.setCAR_MODEL(rs.getString("CAR_MODEL"));
				bean.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				bean.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				bean.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				bean.setCOLOR(rs.getString("COLOR"));
				bean.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				bean.setBODY_TYPE(rs.getString("BODY_TYPE"));
				bean.setMODEL_YEAR(rs.getString("MODEL_YEAR"));
				if(rs.getString("UPDATED_DATE")==null){
					
					bean.setUPDATED_DATE("-");
					
				}
				else{
					bean.setUPDATED_DATE(new SQLDate().getInDate( (rs.getString("UPDATED_DATE"))));
				}
				blob1=rs.getBlob("PHOTO1");
				
				
				if(blob1!=null){
					
				photo1=blob1.getBytes(1, (int)blob1.length());
				String fphoto = Base64.encode(photo1);
				bean.setPHOTO1(fphoto);
				
				}

				bean.setINSURANCE(rs.getString("INSURANCE"));
				bean.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				bean.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				bean.setUSED_BY(rs.getString("USED_BY"));
				bean.setNO_OF_OWNERS(rs.getInt("NO_OF_OWNERS"));
				bean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				bean.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
			//	bean.setSELLER_TYPE(rs.getString("SELLER_TYPE"));
				bean.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				bean.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				carAl.add(bean);
				
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
		return carAl;
	}

	/*@SuppressWarnings("unused")
	public ArrayList<UsedCar> searchHUsedCar(UsedCar bean) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		String query = null; //"SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER";
		String year1 = null;
		String year2 = null;
		String price1 = null;
		String price2 = null;
		System.out.println("b" + bean.getCAR_BRAND());
		System.out.println("m" + bean.getCAR_MODEL());
		System.out.println("p" + bean.getOFFER_PRICE());
		System.out.println("c" + bean.getCITY());

		if (bean.getREGISTERED_YEAR() != null) {
			CarAge carAge = new CarAge();
			ArrayList carAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());

			year1 = (String) carAl1.get(0);
			year2 = (String) carAl1.get(1);
		}
		if (bean.getOFFER_PRICE() != null) {
			if (bean.getOFFER_PRICE().equals("SELECT")) {

			} else {
				CarAge carAge = new CarAge();
				ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}

		String carBrand = bean.getCAR_BRAND(), city = bean.getCITY(), color = bean.getCOLOR(),
				fuelType = bean.getFUEL_TYPE(), mileage = bean.getCURRENT_MILEAGE();
		int owners = bean.getNO_OF_OWNERS();

		try {

			if (!bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and status='ACTIVE' and available='Y'";

			} else if (!"SELECT".equals(bean.getCAR_BRAND()) && !"SELECT".equals(bean.getCAR_MODEL())
					&& bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and CAR_MODEL='" + bean.getCAR_MODEL()
						+ "' and status='ACTIVE' and available='Y'";

			} else if (bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& !"SELECT".equals(bean.getOFFER_PRICE()) && bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where OFFER_PRICE>'"
						+ price1 + "' and OFFER_PRICE<'" + price2 + "' and status='ACTIVE' and available='Y'";

			} else if (!"SELECT".equals(bean.getCAR_BRAND()) && !bean.getCAR_MODEL().equals("SELECT")
					&& !"SELECT".equals(bean.getOFFER_PRICE()) && bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and CAR_MODEL='" + bean.getCAR_MODEL() + "' and OFFER_PRICE>'"
						+ price1 + "' and OFFER_PRICE<'" + price2 + "' and status='ACTIVE' and available='Y'";

			} else if (bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& bean.getOFFER_PRICE().equals("SELECT") && !"SELECT".equals(bean.getCITY())) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  REGISTERED_CITY='"
						+ bean.getCITY() + "' and status='ACTIVE' and available='Y'";

			} else if (bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& !"SELECT".equals(bean.getOFFER_PRICE()) && !"SELECT".equals(bean.getCITY())) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  REGISTERED_CITY='"
						+ bean.getCITY() + "' and OFFER_PRICE>'" + price1 + "' and OFFER_PRICE<'" + price2
						+ "' and status='ACTIVE' and available='Y'";

			} else if (!bean.getCAR_BRAND().equals("SELECT") && !bean.getCAR_MODEL().equals("SELECT")
					&& !bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and CAR_MODEL='" + bean.getCAR_MODEL() + "' and  REGISTERED_CITY='"
						+ bean.getCITY() + "' and OFFER_PRICE>'" + price1 + "' and OFFER_PRICE<'" + price2
						+ "' and status='ACTIVE' and available='Y'";

			} else if (!bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and OFFER_PRICE>'" + price1 + "' and OFFER_PRICE<'" + price2
						+ "' and status='ACTIVE' and available='Y'";

			} else if (!bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")
					&& bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"
						+ bean.getCAR_BRAND() + "' and REGISTERED_CITY='" + bean.getCITY()
						+ "' and status='ACTIVE' and available='Y'";

			} else if (color != null) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  color='"
						+ bean.getCOLOR() + "' and status='ACTIVE' and available='Y'";

			} else if (fuelType != null) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  fuel_type='"
						+ bean.getFUEL_TYPE() + "' and status='ACTIVE' and available='Y'";

			} else if (mileage != null) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  current_mileage between '"
						+ bean.getCURRENT_MILEAGE() + "' and '80000' and status='ACTIVE' and available='Y'";

			} else if (owners != 0) {

				if (owners == 1 || owners == 2) {

					query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners='"
							+ bean.getNO_OF_OWNERS() + "' and status='ACTIVE' and available='Y'";

				} else if (owners == 3) {

					query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners>'2' and status='ACTIVE' and available='Y'";

				}

			} else if (bean.getTRANSIMISSION() != null) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"
						+ bean.getTRANSIMISSION() + "' and status='ACTIVE' and available='Y'";

			} else if (bean.getREGISTERED_YEAR() != null) {

				query = "SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where REGISTERED_YEAR between '"
						+ year2 + "' and '" + year1 + "' and status='ACTIVE' and available='Y'";

			}
			System.out.println(query);
			carAl = getUsedCarDetails(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return carAl;
	}*/

	public ArrayList<UsedCar> getCarBrand() {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select car_brand from used_car group by car_brand";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedCar usedCar=new UsedCar();
				usedCar.setCAR_BRAND(rs.getString("CAR_BRAND").toUpperCase());
				carAl.add(usedCar);
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
	return carAl;
	}

	public ArrayList<UsedCar> getCarModel(String carModel) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select car_model from used_car where car_brand='"+carModel+"' group by car_model";
			System.out.println(query);
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedCar usedCar=new UsedCar();
				usedCar.setCAR_MODEL(rs.getString("CAR_MODEL"));
				carAl.add(usedCar);
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
	return carAl;
	}

	public ArrayList<UsedCar> getUsedCarCity() {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select REGISTERED_CITY FROM used_car where REGISTERED_CITY is not null group by REGISTERED_CITY";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedCar usedCar=new UsedCar();
				usedCar.setCITY(rs.getString("REGISTERED_CITY"));;
				carAl.add(usedCar);
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
	return carAl;
	}

	public ArrayList<UsedCar> getUsedCarBudget(String model) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select offer_price FROM used_car where car_model='"+model+"' group by offer_price";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				UsedCar usedCar=new UsedCar();
				usedCar.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				carAl.add(usedCar);
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
	return carAl;
	}

	public String insertEndUserDetails(CarEndUser endUser, String carId) {
		// TODO Auto-generated method stub
		String message = null;
		PreparedStatement pst = null, pstmtr = null, pstmt = null;
		UserLogin login = new UserLogin();
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("insert into end_user_details values(?,?,?,?,?,CURDATE(),?,?)",pst.RETURN_GENERATED_KEYS);
			pstmt = con.prepareStatement("insert into user_login values(?,?,?,?,?,?)", pstmt.RETURN_GENERATED_KEYS);
			pstmtr = con.prepareStatement("insert into individual_owner_rigister values (?,?,?,?,?,?,?,?,?,?,?,?)",pstmtr.RETURN_GENERATED_KEYS);
			pst.setInt(1, endUser.getENDUSER_SEQ_ID());
			pst.setString(2, endUser.getNAME());
			pst.setString(3, endUser.getEMAIL());
			pst.setString(4, endUser.getMOBILE_NO());
			pst.setString(5, carId);
			pst.setString(6, endUser.getVEHICLE_TYPE());
			pst.setString(7, "N");

			pstmt.setInt(1, login.getSEQUENCE_NO());
			pstmt.setString(2, endUser.getEMAIL());
			pstmt.setString(3, endUser.getPASSWORD());
			pstmt.setString(4, "IO");
			pstmt.setString(5, "0");
			pstmt.setString(6, "INACTIVE");

			pstmtr.setInt(1, registration.getSEQUENTIAL_NO());
			pstmtr.setString(2, "IO");
			pstmtr.setString(3, null);
			pstmtr.setString(4, null);
			pstmtr.setString(5, null);
			pstmtr.setString(6, null);
			pstmtr.setString(7, endUser.getNAME());
			pstmtr.setString(8, endUser.getMOBILE_NO());
			pstmtr.setString(9, endUser.getEMAIL());
			pstmtr.setString(10, "INACTIVE");
			pstmtr.setString(11, "NO");
			pstmtr.setString(12, new SQLDate().getSysDate());

			int i = pst.executeUpdate();
			int j = pstmt.executeUpdate();
			int k = pstmtr.executeUpdate();
			if (i > 0 && j > 0 && k > 0) {
				message = "Your request has been sent! Please Verify Your Email Id";
			} else {
				message = "You are Not registered! Please try again.";
				con.rollback();
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
	public ArrayList<UsedCar> compareUsedCar(ArrayList carId) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		String query=null;
		String query1=null;
		
		try{
			for(int i=0;carId.size()>i;i++){
				
				if(i==0){
					
				//query="select * FROM used_car where gen_car_id='"+carId.get(i)+"' union all"+" ";
					
					query="select used_car.*,car_photos.photo1 from used_car join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where gen_car_id='"+carId.get(i)+"' union all"+" ";

				
				}else if(carId.size()-1>i){
					
					query= query+"select used_car.*,car_photos.photo1 from used_car join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where gen_car_id='"+carId.get(i)+"' union all"+" ";
					
					query1= query;
					
				}else if(carId.size()>i){
					
					query=query+"select used_car.*,car_photos.photo1 from used_car join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where gen_car_id='"+carId.get(i)+"'";
					
					query1= query;
				}
				
			}
carAl=getUsedCarDetails(query1);	
			
			
	}catch(Exception e){
		e.printStackTrace();
	}
	return carAl;
	}
	
	public ArrayList<UsedCar> getCarImage(String carNumber) {
		// TODO Auto-generated method stub
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select * from car_photos where car_number='"+carNumber+"'";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte photo1[],photo2[],photo3[],photo4[],photo5[],photo6[],photo7[],photo8[],photo9[],photo10[],photo11[],photo12[];
	        Blob blob1,blob2,blob3,blob4,blob5,blob6,blob7,blob8,blob9,blob10,blob11,blob12;
			while(rs.next()){
				UsedCar bean=new UsedCar();

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
				carAl.add(bean);
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
		return carAl;
	}
	/*@Override
	public ArrayList<UsedCar> searchHDealerUsedCar(UsedCar bean) {
		// TODO Auto-generated method stub
		
		ArrayList<UsedCar> carAl=new ArrayList<UsedCar>();
		String query=null;
		String year1=null;
		String year2=null;
		String price1=null;
		String price2=null;
		System.out.println("ssss"+bean.getEMAIL_ID());
		if(bean.getREGISTERED_YEAR()!=null){
		CarAge carAge=new CarAge();
		ArrayList carAl1=carAge.getCarAge(bean.getREGISTERED_YEAR());
		
		year1=(String)carAl1.get(0);
		year2=(String)carAl1.get(1);
		}
		if(bean.getOFFER_PRICE()!=null){
			if(bean.getOFFER_PRICE().equals("SELECT")){
				
			}else{
			CarAge carAge=new CarAge();
			ArrayList carAl1=carAge.getPrice(bean.getOFFER_PRICE());
			price1=(String)carAl1.get(0);
			price2=(String)carAl1.get(1);
			}
			}

		String carBrand=bean.getCAR_BRAND(),city=bean.getCITY(),color=bean.getCOLOR(),fuelType=bean.getFUEL_TYPE(),mileage=bean.getCURRENT_MILEAGE();
		int owners=bean.getNO_OF_OWNERS();
		
		
		try{
		
				if(city!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CITY='"+bean.getCITY()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(carBrand!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  car_brand='"+bean.getCAR_BRAND()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(color!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  color='"+bean.getCOLOR()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(fuelType!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  fuel_type='"+bean.getFUEL_TYPE()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(mileage!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  current_mileage between '"+bean.getCURRENT_MILEAGE()+"' and '80000' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(owners!=0){
					
					if(owners==1 || owners==2){
					
						
						query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners='"+bean.getNO_OF_OWNERS()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
					}else if(owners==3){
						
						
						query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners>'2' and user_name='"+bean.getEMAIL_ID()+"'";
						
					}
					
				}else if(bean.getTRANSIMISSION()!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"+bean.getTRANSIMISSION()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(bean.getSELLER_TYPE()!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"+bean.getTRANSIMISSION()+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(bean.getREGISTERED_YEAR()!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where REGISTERED_YEAR between '"+year2+"' and '"+year1+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(bean.getOFFER_PRICE()!=null){
					
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and user_name='"+bean.getEMAIL_ID()+"'";
					
				}else if(bean.getEMAIL_ID()!=null){
					
					query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  user_name='"+bean.getEMAIL_ID()+"'";
			
						
					}
				
			
			carAl=getUsedCarDetails(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return carAl;
	}*/

	@Override
	public String validateRequest(String carId, String name, String email, String mobileNo) {
		String message = "no";
		con = DBConnection.getConnection();
		String existMobileNO = "", existEmailId = "", existVehicleId = "", emailVarification = "";
		  /*String url = "http://localhost:8887/Vaahanmitra/VerifyEmailController?cid="+carId+"&eid="+email+"&mno="+mobileNo+"";*/
		String url = "http://vaahanmitra.com/VerifyEmailController?cid="+carId+"&eid="+email+"&mno="+mobileNo+"";
		try {
			String query = "select * from end_user_details where (EMAIL='" + email + "' or MOBILE_NO='" + mobileNo
					+ "') and VEHICLE_ID='" + carId + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existMobileNO = rs.getString("MOBILE_NO");
				existEmailId = rs.getString("EMAIL");
				existVehicleId = rs.getString("VEHICLE_ID");
				emailVarification = rs.getString("EMAIL_VERIFICATION");

				if (existEmailId.equals(email) && existMobileNO.equals(mobileNo) && existVehicleId.equals(carId)
						&& emailVarification.equals("Y")) {
					message = "Already you sent request to this CAR(" + carId + ")";
				} else if (existEmailId.equals(email) && existMobileNO.equals(mobileNo) && existVehicleId.equals(carId)
						&& emailVarification.equals("N")) {
					message = "Email Id already registered on CAR ID (" + carId + ")! Please verify your Email Id";
					
					String textMsg = "Thank you for interest on CAR (id: " + carId + ")  Please "
							+ " <a href='"+url+"'> verify your EMAIL ID</a>";
					SendMail.send(email, textMsg);
					
				} else if (existEmailId.equals(email) && existMobileNO != mobileNo && existVehicleId.equals(carId)
						&& emailVarification.equals("N")) {
					updateEmailMobileNo(carId, name, email, mobileNo);
					String textMsg = "Thank you for interest on CAR (id: " + carId + ")  Please "
							+ " <a href='"+url+"'> verify your EMAIL ID</a>";
					SendMail.send(email, textMsg);
					message = "Email Id already registered on CAR ID (" + carId + ")! Please verify your Email Id ";
					
				} else if (existEmailId != email && existMobileNO.equals(mobileNo) && existVehicleId.equals(carId)
						&& emailVarification.equals("N")) {
					String textMsg = "Thank you for interest on CAR (id: " + carId + ")  Please "
							+ " <a href='"+url+"'> verify your EMAIL ID</a>";
					SendMail.send(email, textMsg);
					message = "Mobile No already registered on CAR ID (" + carId + ")!";
					
				} else if (existEmailId.equals(email) && existMobileNO != mobileNo && existVehicleId.equals(carId)
						&& emailVarification.equals("Y")) {
					message = "Email Id already registerd on CAR ID (" + carId
							+ ") if you want to update your MOBILE NO(" + mobileNo
							+ ") Click <a href='./UpdateMobileCar?cid=" + carId + "&nm="+name+"&mno=" + mobileNo + "&eid=" + email
							+ "' style='color:blue'> YES ";
				} else if (existMobileNO.equals(mobileNo) && existEmailId != email && existVehicleId.equals(carId)
						&& emailVarification.equals("Y")) {
					message = "MobileNo already registered on CAR ID(" + carId + ")";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String getEmail(String carId) {
		con = DBConnection.getConnection();
		String dbEmailId = null;
		try {
			String query = "select EMAIL_ID from used_car where GEN_CAR_ID='" + carId + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				dbEmailId = rs.getString("EMAIL_ID");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbEmailId;
	}
	
	@Override
	public String updateEmailMobileNo(String carId, String name, String email, String mobileNo) {
		con = DBConnection.getConnection();
		String message = "";
		try {
			String query = "UPDATE end_user_details SET MOBILE_NO=?,NAME=?,EMAIL_VERIFICATION=? WHERE EMAIL ='" + email
					+ "'and VEHICLE_ID='" + carId + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, mobileNo);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, "N");
			int j = preparedStatement.executeUpdate();
			if (j > 0) {
				message = "SUCCESS";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	@Override
	public String varifyEmailId(String carId, String email, String name, String mobileNo) {
		con = DBConnection.getConnection();
		String message = "";
		try {
			String query = "UPDATE end_user_details SET EMAIL_VERIFICATION='Y' WHERE MOBILE_NO='" + mobileNo
					+ "' and VEHICLE_ID='" + carId + "' and EMAIL='" + email + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			System.out.println("query" + query);
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
	public String updateMobileNo(String carId, String name, String email, String mobileNo) {
		con = DBConnection.getConnection();
		String message = "";
		try {
			String query = "UPDATE end_user_details SET MOBILE_NO=? , NAME=? WHERE EMAIL ='" + email
					+ "'and VEHICLE_ID='" + carId + "' and EMAIL_VERIFICATION='Y'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, mobileNo);
			preparedStatement.setString(2, name);
			System.out.println("query" + query);
			int j = preparedStatement.executeUpdate();
			if (j > 0) {
				message = "<b> YOUR MOBILE NO  (" + mobileNo + ")  SUCCESSFULLY UPDATED <b>";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@Override
	public String insertUserRequest(CarEndUser endUser, String carId) {
		PreparedStatement pst = null;
		String message = null;
		try {

			con = DBConnection.getConnection();
			pst = con.prepareStatement("insert into end_user_details values(?,?,?,?,?,CURDATE(),?,?)",
					pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, endUser.getENDUSER_SEQ_ID());
			pst.setString(2, endUser.getNAME());
			pst.setString(3, endUser.getEMAIL());
			pst.setString(4, endUser.getMOBILE_NO());
			pst.setString(5, carId);
			pst.setString(6, "4");
			pst.setString(7, "Y");
			int i = pst.executeUpdate();
			if (i > 0) {
				message = "Your request has been sent!";
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
	public ArrayList<String> getRequesters(String email) {
		ArrayList<String> carAl = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT VEHICLE_ID from end_user_details where EMAIL='"+email+"' and EMAIL_VERIFICATION='Y' and VEHICLE_TYPE='4'";
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				carAl.add(rs.getString("VEHICLE_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return carAl;
	}

	@Override
	public ArrayList<UsedCar> searchUsedCar(String brand) {
		ArrayList<UsedCar> al = new ArrayList<UsedCar>();
		try {
			String query = null;
			con = DBConnection.getConnection();

			query = "SELECT used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CAR_BRAND='"+brand+"'";
			System.out.println(query);
			PreparedStatement preparedStatement = con.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedCar uc = new UsedCar();
				uc.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				uc.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				uc.setCAR_BRAND(rs.getString("CAR_BRAND"));
				uc.setCAR_MODEL(rs.getString("CAR_MODEL"));
				uc.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				uc.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				uc.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				uc.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				uc.setCOLOR(rs.getString("COLOR"));
				uc.setINSURANCE(rs.getString("INSURANCE"));
				uc.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				uc.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				uc.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				uc.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				uc.setUSED_BY(rs.getString("USED_BY"));
				uc.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				uc.setEMAIL_ID(rs.getString("EMAIL_ID"));
				uc.setMOBILE_NO(rs.getString("MOBILE_NO"));
				uc.setADDRESS(rs.getString("ADDRESS"));
				uc.setCITY(rs.getString("CITY"));
				uc.setSTATE(rs.getString("STATE"));
				uc.setDISTRICT(rs.getString("DISTRICT"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				uc.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
				uc.setSTATUS(rs.getString("STATUS"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				uc.setPHOTO1(photo10);
				al.add(uc);
			}
		} catch (Exception e) {
		}
		return al;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unused")
	public ArrayList<UsedCar> searchHUsedCar(UsedCar bean,int offset,int noOfRecords) {
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		String query = null;
		String year1 = null;
		String year2 = null;
		String price1 = null;
		String price2 = null;
	

		if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("null")) {
			CarAge carAge = new CarAge();
			ArrayList carAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());

			year1 = (String) carAl1.get(0);
			year2 = (String) carAl1.get(1);
		}
		if (bean.getOFFER_PRICE() != null) {
			if (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any") ) {

			} else {
				CarAge carAge = new CarAge();
				ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}

		String carBrand = bean.getCAR_BRAND(), city = bean.getCITY(), color = bean.getCOLOR(),
				fuelType = bean.getFUEL_TYPE(), mileage = bean.getKMS_DRIVEN();
		int owners = bean.getNO_OF_OWNERS();
		  try{
			  if(bean.getCAR_BRAND()==null && bean.getCAR_MODEL()==null &&bean.getVARIANT_NAME()==null && bean.getOFFER_PRICE()==null && bean.getCITY()==null){
					
					 query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC  limit " + offset + ", " + noOfRecords;

					
				}
			  else if(bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT")  && bean.getOFFER_PRICE().equals("SELECT") &&  "SELECT".equals(bean.getCITY())){
				    
					 query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC  limit " + offset + ", " + noOfRecords;

				    
				   }
			  else if((bean.getCAR_BRAND().equals("SELECT") || bean.getCAR_BRAND().equals("All")) && (bean.getCAR_MODEL().equals("SELECT") || bean.getCAR_MODEL().equals("All"))  && (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) && (! "SELECT".equals(bean.getCITY())||! "All".equals(bean.getCITY()))){
				    
					query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE   limit " + offset + ", " + noOfRecords;

				    
				   }
			  else if((bean.getCAR_BRAND().equals("All")||bean.getCAR_BRAND().equals("All") && bean.getOFFER_PRICE().equals("SELECT") || (bean.getCAR_MODEL().equals("SELECT") && bean.getCAR_MODEL().equals("All"))||"SELECT".equals(bean.getVARIANT_NAME())&&"All".equals(bean.getVARIANT_NAME()) || (bean.getCAR_BRAND().equals("All") && bean.getCAR_MODEL().equals("All") && bean.getOFFER_PRICE().equals("Any"))|| (bean.getCAR_BRAND().equals("All") && bean.getCAR_MODEL().equals("All")&&bean.getVARIANT_NAME().equals("All") && bean.getOFFER_PRICE().equals("Any"))|| (bean.getCAR_BRAND().equals("All") && bean.getCAR_MODEL().equals("All") && bean.getOFFER_PRICE().equals("Any") && bean.getCITY().equals("All")) || 
					     (bean.getCAR_BRAND().equals("All") && bean.getCITY().equals("All")) || (bean.getCAR_BRAND().equals("All") && bean.getOFFER_PRICE().equals("Any")) || (bean.getCAR_BRAND().equals("All") && bean.getOFFER_PRICE().equals("Any") && bean.getCITY().equals("All")) || (bean.getCAR_MODEL().equals("SELECT") && bean.getOFFER_PRICE().equals("Any")) || (bean.getCAR_MODEL().equals("SELECT") && bean.getCITY().equals("All")))){

			
				  query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
					    
					   }
	
			  
			  else if(!bean.getCAR_BRAND().equals("SELECT") && (bean.getCAR_MODEL().equals("SELECT") || bean.getCAR_MODEL().equals("All")) &&("SELECT".equals(bean.getVARIANT_NAME())||"All".equals(bean.getVARIANT_NAME())) && (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) && (bean.getCITY().equals("SELECT") || bean.getCITY().equals("All")) ){
					    
					     
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;
					    
					   }
					   
					   

					   
					   else if(! "SELECT".equals(bean.getCAR_BRAND()) && ! "SELECT".equals(bean.getCAR_MODEL()) &&("SELECT".equals(bean.getVARIANT_NAME())||"All".equals(bean.getVARIANT_NAME())) && bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

					    
					   }
			           
			  
					   else if(! "SELECT".equals(bean.getCAR_BRAND()) && ! "SELECT".equals(bean.getCAR_MODEL()) &&! "SELECT".equals(bean.getVARIANT_NAME()) && bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

					    
					   }
			  
			  
			  
					else if((bean.getCAR_BRAND().equals("SELECT")||"All".equals(bean.getCAR_BRAND())) && (bean.getCAR_MODEL().equals("SELECT")||bean.getCAR_MODEL().equals("All"))&& ("All".equals(bean.getVARIANT_NAME()) || "SELECT".equals(bean.getVARIANT_NAME())) && (! "SELECT".equals(bean.getOFFER_PRICE())||!"All".equals(bean.getOFFER_PRICE())) && (bean.getCITY().equals("SELECT") || bean.getCITY().equals("All"))){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

				
					   }
			
					
					else if(! "SELECT".equals(bean.getCAR_BRAND()) && (bean.getCAR_MODEL().equals("SELECT")||!bean.getCAR_MODEL().equals("All") ) && ("SELECT".equals(bean.getVARIANT_NAME())||"All".equals(bean.getVARIANT_NAME())) && ! "SELECT".equals(bean.getOFFER_PRICE()) && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"'  and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;

					    
					   }
					
					else if(! "SELECT".equals(bean.getCAR_BRAND()) && !bean.getCAR_MODEL().equals("SELECT") && ("SELECT".equals(bean.getVARIANT_NAME())||"All".equals(bean.getVARIANT_NAME())) && ! "SELECT".equals(bean.getOFFER_PRICE()) && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;

					    
					   }
					else if(! "SELECT".equals(bean.getCAR_BRAND()) && !bean.getCAR_MODEL().equals("SELECT")&&! "SELECT".equals(bean.getVARIANT_NAME()) && ! "SELECT".equals(bean.getOFFER_PRICE()) && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;

					    
					   }
					
		
					else if(bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT") && ! "SELECT".equals(bean.getOFFER_PRICE()) && ! "SELECT".equals(bean.getCITY())){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CITY='"+bean.getCITY()+"' and OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;

					   }else if(!bean.getCAR_BRAND().equals("SELECT") && !bean.getCAR_MODEL().equals("SELECT")&&bean.getVARIANT_NAME().equals("SELECT") && !bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and  CITY='"+bean.getCITY()+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

					    
					   }else if(!bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT") && !bean.getOFFER_PRICE().equals("SELECT") && bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;

					    
					   }else if(!bean.getCAR_BRAND().equals("SELECT") && bean.getCAR_MODEL().equals("SELECT") && bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

					    
					   }else if(!bean.getCAR_BRAND().equals("SELECT") && !bean.getCAR_MODEL().equals("SELECT") && bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
					    
					    
					     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

					    
					   }
					   else if(!bean.getCAR_BRAND().equals("SELECT") && !bean.getCAR_MODEL().equals("SELECT")&& !bean.getVARIANT_NAME().equals("SELECT") && bean.getOFFER_PRICE().equals("SELECT") && !bean.getCITY().equals("SELECT")){
						    
						    
						     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

						    
						   }
					   else if(!bean.getCAR_BRAND().equals("SELECT") && !bean.getCAR_MODEL().equals("SELECT")&& !bean.getVARIANT_NAME().equals("SELECT") && (!bean.getOFFER_PRICE().equals("SELECT")||!bean.getOFFER_PRICE().equals("All")) && !bean.getCITY().equals("SELECT")){
						    
						    System.out.println("ALL FILED");
						     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+bean.getCAR_BRAND()+"' and CAR_MODEL='"+bean.getCAR_MODEL()+"' and VARIANT_NAME='"+bean.getVARIANT_NAME()+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and CITY='"+bean.getCITY()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;

						    
						   }
			
						  
			else if(color!=null && !color.equals("null")){
			     
			     query="SELECT SQL_CALC_FOUND_ROWS SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  color='"+bean.getCOLOR()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			     
			    }else if(fuelType!=null && !fuelType.equals("null")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  fuel_type='"+bean.getFUEL_TYPE()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit "  + offset + ", " + noOfRecords;
			     
			    }else if(mileage!=null && !mileage.equals("null")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  current_mileage between '"+bean.getCURRENT_MILEAGE()+"' and '80000' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			     
			    }else if(owners!=0){
			     
			     if(owners==1 || owners==2){
			     
			      
			      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners='"+bean.getNO_OF_OWNERS()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			     
			     }else if(owners==3){
			      
			      
			      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners>'2' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			      
			     }
			     
			    }else if(bean.getTRANSIMISSION()!=null && !bean.getTRANSIMISSION().equals("null")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"+bean.getTRANSIMISSION()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			     
			    }else if(bean.getREGISTERED_YEAR()!=null && !bean.getREGISTERED_YEAR().equals("null")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where REGISTERED_YEAR between '"+year2+"' and '"+year1+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;
			     
			    }else if(bean.getPRICE()!=null && bean.getPRICE().equals("0")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' order by OFFER_PRICE ASC limit " + offset + ", " + noOfRecords;
			     
			    }else if(bean.getPRICE()!=null && bean.getPRICE().equals("1")){
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' order by OFFER_PRICE DESC limit " + offset + ", " + noOfRecords;
			     
			    }else if(bean.getBODY_TYPE()!=null && !bean.getBODY_TYPE().equals("null")){
				     
			    	query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  BODY_TYPE='"+bean.getBODY_TYPE()+"' and status='ACTIVE' and available='Y' order by UPDATED_DATE  DESC limit " + offset + ", " + noOfRecords;
				     
				    }else{
					
					 query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' order by UPDATED_DATE DESC  limit " + offset + ", " + noOfRecords;


				}

			  System.out.println("CHECK"+query);
			    carAl=getUsedCarDetails(query);
			  

			  } catch (Exception e) {
			e.printStackTrace();
		}

		return carAl;
	}
	@Override
	public ArrayList<UsedCar> searchHDealerUsedCar(UsedCar bean,int offset,int noOfRecords) {
		// TODO Auto-generated method stub

		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		String query = null;
		String year1 = null;
		String year2 = null;
		String price1 = null;
		String price2 = null;
	
		if (bean.getREGISTERED_YEAR() != null && !bean.getREGISTERED_YEAR().equals("null")) {
			CarAge carAge = new CarAge();
			ArrayList carAl1 = carAge.getCarAge(bean.getREGISTERED_YEAR());

			year1 = (String) carAl1.get(0);
			year2 = (String) carAl1.get(1);
		}
		if (bean.getOFFER_PRICE() != null) {
			if (bean.getOFFER_PRICE().equals("SELECT") || bean.getOFFER_PRICE().equals("Any")) {

			} else {
				CarAge carAge = new CarAge();
				ArrayList carAl1 = carAge.getPrice(bean.getOFFER_PRICE());
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}

		String carBrand = bean.getCAR_BRAND(), city = bean.getCITY(), color = bean.getCOLOR(),
				fuelType = bean.getFUEL_TYPE(), mileage = bean.getCURRENT_MILEAGE();
		int owners = bean.getNO_OF_OWNERS();

		try{
			 
			if((carBrand!=null && !carBrand.equals("null") && carBrand.equals("All")) || (bean.getOFFER_PRICE()!=null && !bean.getOFFER_PRICE().equals("null") && bean.getOFFER_PRICE().equals("Any"))){
			    
			    
			    query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
			    
			   }
			
			else if(city!=null && !city.equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CITY='"+bean.getCITY()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(carBrand!=null && !carBrand.equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  car_brand='"+bean.getCAR_BRAND()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(color!=null && !color.equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  color='"+bean.getCOLOR()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(fuelType!=null && !fuelType.equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  fuel_type='"+bean.getFUEL_TYPE()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(mileage!=null && !mileage.equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  current_mileage between '"+bean.getCURRENT_MILEAGE()+"' and '80000' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(owners!=0){
		     
		     if(owners==1 || owners==2){
		     
		      
		      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners='"+bean.getNO_OF_OWNERS()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		     }else if(owners==3){
		      
		      
		      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  no_of_owners>'2' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		      
		     }
		     
		    }else if(bean.getTRANSIMISSION()!=null && !bean.getTRANSIMISSION().equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"+bean.getTRANSIMISSION()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(bean.getSELLER_TYPE()!=null && !bean.getSELLER_TYPE().equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  transmission='"+bean.getTRANSIMISSION()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(bean.getREGISTERED_YEAR()!=null && !bean.getREGISTERED_YEAR().equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where REGISTERED_YEAR between '"+year2+"' and '"+year1+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(bean.getOFFER_PRICE()!=null && !bean.getOFFER_PRICE().equals("null")){
		     
		     
		     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where OFFER_PRICE>'"+price1+"' and OFFER_PRICE<'"+price2+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		     
		    }else if(bean.getPRICE()!=null && bean.getPRICE().equals("0")){
		      
		      
		      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' and  user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' order by OFFER_PRICE ASC limit " + offset + ", " + noOfRecords;
		      
		     }else if(bean.getPRICE()!=null && bean.getPRICE().equals("1")){
		      
		      
		      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,CAST( OFFER_PRICE AS DECIMAL( 9, 2 ) ) AS OFFER_PRICE,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where status='ACTIVE' and available='Y' and  user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' order by OFFER_PRICE DESC limit " + offset + ", " + noOfRecords;
		      
		     }else if(bean.getBODY_TYPE()!=null && !bean.getBODY_TYPE().equals("null")){
			     
			     
			     query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  BODY_TYPE='"+bean.getBODY_TYPE()+"' and user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
			     
			    }else if(bean.getEMAIL_ID()!=null && !bean.getEMAIL_ID().equals("null")){
		      
		      query="SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  user_name='"+bean.getEMAIL_ID()+"' and status='ACTIVE' and available='Y' limit " + offset + ", " + noOfRecords;
		    
		       
		      }
		   System.out.println("main qurey"+query);
		   
		   carAl=getUsedCarDetails(query);
		   
		  } catch (Exception e) {
			e.printStackTrace();
		}

		return carAl;
	}
	
	@Override
	 public int getNoOfRecords(){
	  return noOfRecords;
	 }

	@Override
	public List<UsedCar> getUsedCarDetailsByCarNo(String carNo) {
			
		String query="SELECT * from used_car where CAR_NUMBER='"+carNo+"' and status='ACTIVE' and available='Y'";

		List<UsedCar> carAl=new ArrayList<UsedCar>();
		Statement st=null;
		ResultSet rs=null;
		try{
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			if(query!=null){
			rs=st.executeQuery(query);
			}
			byte photo1[];
	        Blob blob1;
			while(rs.next()){
				UsedCar bean=new UsedCar();
//				bean.setSEQUENCE_NO(rs.getInt("SEQUENCE_NO"));
//				bean.setUSER_NAME(rs.getString("USER_NAME"));
				bean.setCAR_BRAND(rs.getString("CAR_BRAND"));
				bean.setCAR_MODEL(rs.getString("CAR_MODEL"));
				bean.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				bean.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				bean.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				bean.setCOLOR(rs.getString("COLOR"));
			
				bean.setINSURANCE(rs.getString("INSURANCE"));
				bean.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
//				bean.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
//				bean.setUSED_BY(rs.getString("USED_BY"));
				bean.setNO_OF_OWNERS(rs.getInt("NO_OF_OWNERS"));
//				bean.setEMAIL_ID(rs.getString("EMAIL_ID"));
//				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
//				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setCITY(rs.getString("CITY"));
//				bean.setSTATE(rs.getString("STATE"));
//				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				bean.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
//				bean.setSELLER_TYPE(rs.getString("SELLER_TYPE"));
				bean.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				bean.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				bean.setBODY_TYPE(rs.getString("BODY_TYPE"));
				carAl.add(bean);
				
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
		return carAl;
	}

	@Override
	public List<UsedCar> getUsedCarByCarNo(String brand,String price,String kmsDriven,String carNo) {
		// TODO Auto-generated method stub
		
		String query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+brand+"' and OFFER_PRICE='"+price+"' and KMS_DRIVEN='"+kmsDriven+"' and used_car.CAR_NUMBER!='"+carNo+"' and status='ACTIVE' and available='Y'";
			ArrayList<UsedCar> carAl=getUsedCarDetails(query);
		System.out.println(query);
		return carAl;
	}
	@Override
	public List<UsedCar> getDealerUsedCar(String brand,String price,String kmsDriven,String carNo,String demail) {
		// TODO Auto-generated method stub
		
		String query="SELECT used_car.*,car_photos.photo1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CAR_BRAND='"+brand+"' and OFFER_PRICE='"+price+"' and KMS_DRIVEN='"+kmsDriven+"' and used_car.CAR_NUMBER!='"+carNo+"' and USER_NAME='"+demail+"' and status='ACTIVE' and available='Y'";
		ArrayList<UsedCar> carAl=getUsedCarDetails(query);
		return carAl;
	}
}
