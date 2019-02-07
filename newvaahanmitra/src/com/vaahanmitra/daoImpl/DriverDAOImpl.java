package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.DriverEndUser;
import com.vaahanmitra.model.DriverFeedBack;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.InsertDriverPreRtsAndSal;
import com.vaahanmitra.model.OnDemandDriverRoutes;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendEmailToUser;
import com.vaahanmitra.utilities.DriverId;
import com.vaahanmitra.utilities.SQLDate;

	public class DriverDAOImpl implements DriverDAO{
		private   Connection con=null;
		private int noOfRecords=0;
		
		public String insertLoginDetails(UserLogin bean){
			String message="";
			PreparedStatement pst=null;
			try{
				
				con=DBConnection.getConnection();
			    pst=con.prepareStatement("insert into user_login values(?,?,?,?,?,?)",pst.RETURN_GENERATED_KEYS);
			    pst.setInt(1, bean.getSEQUENCE_NO());
			    pst.setString(2, bean.getEMAIL_ID());
			    pst.setString(3, bean.getPASSWORD());
			    pst.setString(4, bean.getUSER_TYPE());
			    pst.setString(5, bean.getREFERENCE_ID());
			    pst.setString(6, "ACTIVE");
			    int i=pst.executeUpdate();
				
				if(i>0){
					message="Your Details Are Added SuccessFully......";
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
				
		public boolean getEmail(String email) {
			  String existEmail="";
			  boolean success=false;
			  try {
			   String query = "select * from user_login where EMAIL_ID='"+email+"'";
			   con=DBConnection.getConnection();
			   PreparedStatement preparedStatement = con.prepareStatement(query);
			   ResultSet rs = preparedStatement.executeQuery();
			   while(rs.next()){
			    existEmail = rs.getString("EMAIL_ID");
			   }
			   if(email.equals(existEmail)){
			    success = true;
			   }else{
			    success = false;
			   }
			   preparedStatement.close();
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }finally {
					try {
						
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			  return success;
			 }
								

		public String insertDriverDetails(DriverBean addDriver,InputStream inputStream,InputStream inputStream1){
			
			//ArrayList<AddDriverBean> addDriverAl=new ArrayList<AddDriverBean>();
			
			PreparedStatement pst=null;
			PreparedStatement pst1=null;
			String message="";
			
			SQLDate date=new SQLDate();
			String date1=date.getSQLDate(addDriver.getDOB());
			String date2=date.getSQLDate(addDriver.getEXPIRY_DATE());
			
			try{ 
				String id1=new IdGen().getId("SEQ_DRIVER_ID");
				DriverId did=new DriverId();
				String driverId=did.driverId(id1);
				con=DBConnection.getConnection();
			    pst=con.prepareStatement("insert into add_driver values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE())");
			    pst.setString(1, id1);
			    pst.setString(2, addDriver.getFIRST_NAME());
			    pst.setString(3, addDriver.getLAST_NAME());
			    pst.setString(4, addDriver.getEMAIL());
			    pst.setString(5, addDriver.getMOBILE_NO());
			    pst.setString(6, date1);
			    pst.setString(7, addDriver.getADDRESS());
			    pst.setString(8, addDriver.getSTREET());
			    pst.setString(9, addDriver.getCITY());
			    pst.setString(10, addDriver.getSTATE());
			    pst.setString(11, addDriver.getDISTRICT());
			    pst.setString(12, addDriver.getMANDAL());
			    pst.setString(13, addDriver.getREGISTERED_STATE());
			    pst.setString(14, addDriver.getLICENSE_NO());
			    pst.setString(15, addDriver.getLICENSE_TYPE());
			    pst.setString(16, date2);
			    pst.setString(17, addDriver.getDRIVING_EXP());
			    pst.setString(18, addDriver.getPERMIT_TYPE());
			    pst.setString(19, addDriver.getWITHIN_RANGE());
			    pst.setString(20, addDriver.getADHAR_NO());
			    pst.setString(21, addDriver.getPAN_NO());
			    pst.setBlob(22, inputStream);
			    pst.setBlob(23, inputStream1);
			    pst.setString(24,addDriver.getEMAIL());
			    pst.setString(25, "AVAILABLE");
			    pst.setString(26, driverId);
			    pst.setString(27, "INACTIVE");
			    pst.setString(28, addDriver.getJOB_TYPE());
			    
			    pst1=con.prepareStatement("insert into user_login values(?,?,?,?,?,?)",pst.RETURN_GENERATED_KEYS);
			    pst1.setString(1, addDriver.getSEQUENCE_NO());
			    pst1.setString(2, addDriver.getEMAIL());
			    pst1.setString(3, addDriver.getPASSWORD());
			    pst1.setString(4, addDriver.getUSERTYPE());
			    pst1.setString(5,id1);
			    pst1.setString(6, "INACTIVE");
			    int i=pst.executeUpdate();
			    int j=pst1.executeUpdate();
			    if(i>0 && j>0){
			    	
			    	String status=driverEmailVerification(addDriver.getEMAIL());
			    	if(status.equals("INACTIVE")){
			    	SendEmailToUser userMsg=new SendEmailToUser();
			    	userMsg.driverRegisterMsg(addDriver.getEMAIL());
			    	}
					message="Your Details Are Added SuccessFully......";
				}else{
					
				}
				
			}catch(Exception e){ 
				e.printStackTrace();
			}	
			finally {
		           try {
		        	   pst.close();
					   con.close();
				} catch (Exception e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        } 
			
			return message;
		}

	public ArrayList<DriverBean> displayDriver(String userId,String country){
		ArrayList<DriverBean> beanAl=new ArrayList<DriverBean>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			
			if(userId!=null && country==""){
				
				query="select seq_driver_id,state,district,permit_type,within_range from add_driver where m_user_id='"+userId+"' group by state";
				
			}else if(userId!=null && country!=""){
				
				 query="select seq_driver_id,state,district,permit_type,within_range from add_driver where m_user_id='"+userId+"' and state='"+country+"' group by district";
				
			}else if(userId==null && country==""){
				
				query="select seq_driver_id,state,district,permit_type,within_range from add_driver group by state";
				
			}else if(userId==null && country!=""){

				query="select seq_driver_id,state,district,permit_type,within_range from add_driver where state='"+country+"' group by district";
				
			}
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				DriverBean bean=new DriverBean();
				bean.setSEQ_DRIVER_ID(rs.getInt("SEQ_DRIVER_ID"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				beanAl.add(bean);
		}
		}catch(Exception e){
			
		}
		
		finally{
			
		try{
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
		}
		
		return beanAl;
	}

	@SuppressWarnings("finally")
	public ArrayList<DriverBean> displayHomePageDriverDetails(String state,String dist,String permitType,String range,String licenseType){
		ArrayList hdriver=new ArrayList();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		
		try{
 if(!state.equals("SELECT") && dist.equals("All") || permitType.equals("All") && range=="" || licenseType.equals("All")){

				query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'  order by SEQ_DRIVER_ID ASC";
				
				}
			else  if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && range=="" && licenseType.equals("SELECT")){
				
				query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE!='OTHER STATE' order by SEQ_DRIVER_ID ASC";
				
			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && permitType.equals("SELECT") && range=="" && licenseType.equals("SELECT")){
				
				query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and PERMIT_TYPE!='OTHER STATE' order by SEQ_DRIVER_ID ASC";
				
			}else if(!state.equals("SELECT") && dist.equals("SELECT") && !permitType.equals("SELECT") && range=="" && licenseType.equals("SELECT")){

					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and  PERMIT_TYPE='"+permitType+"'  order by SEQ_DRIVER_ID ASC";
			}
			else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && range=="" && licenseType.equals("SELECT")){
				
				
					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and PERMIT_TYPE='"+permitType+"' order by SEQ_DRIVER_ID ASC";
				
			}else if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				
				query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and WITHIN_RANGE='"+range+"' and PERMIT_TYPE!='OTHER STATE' order by SEQ_DRIVER_ID ASC";
				
			}else if(!state.equals("SELECT") && dist.equals("SELECT") && !permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				

					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE='"+permitType+"' and WITHIN_RANGE='"+range+"' order by SEQ_DRIVER_ID ASC";

			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				
				
					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and PERMIT_TYPE='"+permitType+"' and WITHIN_RANGE='"+range+"' order by SEQ_DRIVER_ID ASC";

			}else if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && range=="" && !licenseType.equals("SELECT")){
					
						query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and LICENSE_TYPE='"+licenseType+"' and PERMIT_TYPE!='OTHER STATE' order by SEQ_DRIVER_ID ASC";

			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && permitType.equals("SELECT") && range=="" && !licenseType.equals("SELECT")){
					
					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and PERMIT_TYPE!='OTHER STATE' order by SEQ_DRIVER_ID ASC";

		}else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && range=="" && !licenseType.equals("SELECT")){
				
				query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and PERMIT_TYPE='"+permitType+"' order by SEQ_DRIVER_ID ASC";

			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && range!="" && !licenseType.equals("SELECT")){
					
					query="select add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE='"+permitType+"' and DISTRICT='"+dist+"' and WITHIN_RANGE='"+range+"' and LICENSE_TYPE='"+licenseType+"' order by SEQ_DRIVER_ID ASC";
					
			}
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			if(query!=null){
			rs=st.executeQuery(query);
			byte licenseDoc[];
			byte photo[];
	        Blob blob1;
	        Blob blob2;
			while(rs.next()){
				DriverBean bean=new DriverBean();
				InsertDriverPreRtsAndSal driverRtsSal=new InsertDriverPreRtsAndSal();
				bean.setSEQ_DRIVER_ID(rs.getInt("SEQ_DRIVER_ID"));
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setDOB(rs.getString("DOB"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				bean.setEXPIRY_DATE(rs.getString("EXPIRY_DATE"));
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				bean.setDRIVER_AVAILABILITY(rs.getString("STATUS"));
				bean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				blob1=rs.getBlob("LICENSE_DOC");
				licenseDoc=blob1.getBytes(1, (int)blob1.length());
				String licenseDoc1 = Base64.encode(licenseDoc);
				bean.setLICENSE_DOC(licenseDoc1);
				blob2=rs.getBlob("PHOTO");
				photo=blob2.getBytes(1, (int)blob2.length());
				String photo1 = Base64.encode(photo);
				bean.setPHOTO(photo1);
				driverRtsSal.setFROM_LOCATION(rs.getString("FROM_LOCATION"));
				driverRtsSal.setTO_LOCATION(rs.getString("TO_LOCATION"));
				driverRtsSal.setDEXPECTED_SAL(rs.getString("DEXPECTED_SAL"));
				hdriver.add(bean);
				hdriver.add(driverRtsSal);
			}rs.close();}else{
			}

			System.out.println(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{			
				st.close();
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return hdriver;
		}
	} 

	public String updateDriverAvailability(String[] driverId, String userId){
		Statement st=null;
		String message="";
		int j=0;
		try{
			con=DBConnection.getConnection();
			st=con.createStatement();
			for(int i=0;driverId.length>i;i++){
				String query="update add_driver set AVAILABILITY='NOT AVAILABILE' where  M_USER_ID='"+userId+"' and  SEQ_DRIVER_ID='"+driverId[i]+"'";
				j=st.executeUpdate(query);
			}if(j>0){
				message="Your Data Is Updated Successfully...";
			}else{
				message="Your Data Is Not Updated Please Try Once Again..";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return message;
	}
	

	@Override
	public String InsertDPreferredRts(InsertDriverPreRtsAndSal driverRts) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String message="";
		try{
			String query="insert into driver_preferred_routes values(?,?,?,?,?)";
			con=DBConnection.getConnection();
		    pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, driverRts.getSEQ_DROUTE_ID());
		   pst.setString(2, driverRts.getFROM_LOCATION());
		   pst.setString(3, driverRts.getTO_LOCATION());
		   pst.setString(4, driverRts.getD_USER_ID());
		   pst.setString(5, "ACTIVE");
		   
		   int i= pst.executeUpdate();
		    if(i>0){
		    	message="Your Routes Added Successfulle....";
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
	public String InsertExpctedSal(InsertDriverPreRtsAndSal driverSal) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String message=null;
		String sal=null;
		try{
			String query1="select * from driver_expected_sal where DR_USER_ID='"+driverSal.getDR_USER_ID()+"'";
			String query2="insert into driver_expected_sal values(?,?,?)";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			sal=rs.getString("DEXPECTED_SAL");
			System.out.println(sal);
			}
			if(sal!=null){
				
			}else{
		   pst=con.prepareStatement(query2,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, driverSal.getSEQ_DSAL_ID());
		   pst.setString(2, driverSal.getDEXPECTED_SAL());
		   pst.setString(3, driverSal.getDR_USER_ID());
		   int i= pst.executeUpdate();
		    if(i>0){
		    	message="Your Salary Added Successfulle....";
		    }else{
		    	
		    }
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

	public ArrayList<InsertDriverPreRtsAndSal> getDriverSal(String userId){
		ArrayList<InsertDriverPreRtsAndSal> driverSal=new	ArrayList<InsertDriverPreRtsAndSal>();
		PreparedStatement pst=null;
		try{
			String query="select * from driver_expected_sal where DR_USER_ID='"+userId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				InsertDriverPreRtsAndSal driverSalB=new InsertDriverPreRtsAndSal();
				driverSalB.setSEQ_DSAL_ID(rs.getInt("SEQ_DSAL_ID"));
				driverSalB.setDEXPECTED_SAL(rs.getString("DEXPECTED_SAL"));
				driverSal.add(driverSalB);
			}
			rs.close();
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
		return driverSal;
	}

	@Override
	public String updateDriverSal(InsertDriverPreRtsAndSal driverSal) {
		String message1="";
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update driver_expected_sal set DEXPECTED_SAL='"+driverSal.getDEXPECTED_SAL()+"' where  DR_USER_ID='"+driverSal.getDR_USER_ID()+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				message1="Salary Updated Successfully....";
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
		return message1;
	}

	@Override
	public ArrayList<DriverBean> getDriverDetails(String userId) {
		// TODO Auto-generated method stub
		ArrayList<DriverBean> driverAl=new	ArrayList<DriverBean>();
		PreparedStatement pst=null;
		try{
			String query="select * from add_driver where M_USER_ID='"+userId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverBean driverB=new DriverBean();
				driverB.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));;
				driverAl.add(driverB);
			}
			rs.close();
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
		return driverAl;
	}

	@Override
	public String updateDriver(DriverBean bean) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update add_driver set PERMIT_TYPE='"+bean.getPERMIT_TYPE()+"' where  M_USER_ID='"+bean.getM_USER_ID()+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}

	@Override
	public ArrayList<InsertDriverPreRtsAndSal> getDriverRoutes(String userId) {
		// TODO Auto-generated method stub
		ArrayList<InsertDriverPreRtsAndSal> driverRt=new	ArrayList<InsertDriverPreRtsAndSal>();
		PreparedStatement pst=null;
		try{
			String query="select * from driver_preferred_routes where D_USER_ID='"+userId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				InsertDriverPreRtsAndSal driverB=new InsertDriverPreRtsAndSal();
				driverB.setFROM_LOCATION(rs.getString("FROM_LOCATION"));
				driverB.setTO_LOCATION(rs.getString("TO_LOCATION"));
				driverB.setSEQ_DROUTE_ID(rs.getInt("SEQ_DROUTE_ID"));
				driverB.setSTATUS(rs.getString("STATUS"));
				driverRt.add(driverB);
			}
			rs.close();
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
		return driverRt;
	}

	@Override
	 public String updateDriverRoutes(String status,String userId,String routeId) {
	  // TODO Auto-generated method stub
	  Statement st=null;
	  String message="";
	  int j=0;
	  
	  if(status!=null && status.equals("ACTIVE")){
	   
	   status="INACTIVE";
	   
	  }else if(status!=null && status.equals("INACTIVE")){
	   
	   status="ACTIVE";
	   
	  }
	  
	  try{
	   con=DBConnection.getConnection();
	   st=con.createStatement();
	   
	    String query="update driver_preferred_routes set STATUS='"+status+"' where  D_USER_ID='"+userId+"' and SEQ_DROUTE_ID='"+routeId+"'";
	    j=st.executeUpdate(query);
	    
	   if(j>0){
	    message="Your Data Is Updated Successfully...";
	   }else{
	    message="Your Data Is Not Updated Please Try Once Again..";
	   }
	   
	  }catch(Exception e){
	   e.printStackTrace();
	  }finally{
	   try{
	    
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	  }
	  
	  return message;
	 }

	@Override
	public ArrayList<DriverBean> viewDriverProfile(String userId) {
		// TODO Auto-generated method stub
		ArrayList<DriverBean> driverAl=new	ArrayList<DriverBean>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select * from add_driver where M_USER_ID='"+userId+"'";
			SQLDate date=new SQLDate();
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			byte licenseDoc[];
			byte photo[];
	        Blob blob1;
	        Blob blob2;
			while(rs.next()){
				DriverBean bean=new DriverBean();
				bean.setSEQ_DRIVER_ID(rs.getInt("SEQ_DRIVER_ID"));
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				String date1=date.getInDate(rs.getString("DOB"));
				bean.setDOB(date1);
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				String date2=date.getInDate(rs.getString("EXPIRY_DATE"));
				bean.setEXPIRY_DATE(date2);
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				blob1=rs.getBlob("LICENSE_DOC");
				licenseDoc=blob1.getBytes(1, (int)blob1.length());
				String licenseDoc1 = Base64.encode(licenseDoc);
				bean.setLICENSE_DOC(licenseDoc1);
				blob2=rs.getBlob("PHOTO");
				photo=blob2.getBytes(1, (int)blob2.length());
				String photo1 = Base64.encode(photo);
				bean.setPHOTO(photo1);
				bean.setDRIVER_AVAILABILITY(rs.getString("STATUS"));
				bean.setJOB_TYPE(rs.getString("JOB_TYPE"));
//				bean.setPHOTO(rs.getString("PHOTO"));
				driverAl.add(bean);
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				st.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return driverAl;
	}

	@Override
	public String updateDriverProfile(DriverBean bean) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update add_driver set PERMIT_TYPE='"+bean.getPERMIT_TYPE()+"' where  M_USER_ID='"+bean.getM_USER_ID()+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}

	public String updateDriverProfile1(DriverBean bean,InputStream inputStream) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			SQLDate date=new SQLDate();
			String date1=date.getSQLDate(bean.getDOB());
			String date2=date.getSQLDate(bean.getEXPIRY_DATE());
			/*set SQL_SAFE_UPDATES=0; */
			String query="update add_driver set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,MOBILE_NO=?,DOB=?,ADDRESS=?,STREET=?,CITY=?,STATE=?,DISTRICT=?,MANDAL=?,REGISTERED_STATE=?,LICENSE_NO=?,LICENSE_TYPE=?,EXPIRY_DATE=?,DRIVING_EXP=?,PERMIT_TYPE=?,WITHIN_RANGE=?,ADHAR_NO=?,PAN_NO=?,PHOTO=?,JOB_TYPE=? where  M_USER_ID=?";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			pst.setString(1, bean.getFIRST_NAME());
			pst.setString(2, bean.getLAST_NAME());
			pst.setString(3, bean.getEMAIL());
			pst.setString(4, bean.getMOBILE_NO());
			pst.setString(5, date1);
			pst.setString(6, bean.getADDRESS());
			pst.setString(7, bean.getSTREET());
			pst.setString(8, bean.getCITY());
			pst.setString(9, bean.getSTATE());
			pst.setString(10, bean.getDISTRICT());
			pst.setString(11, bean.getMANDAL());
			pst.setString(12, bean.getREGISTERED_STATE());
			pst.setString(13, bean.getLICENSE_NO());
			pst.setString(14, bean.getLICENSE_TYPE());
			pst.setString(15, date2);
			pst.setString(16, bean.getDRIVING_EXP());
			pst.setString(17, bean.getPERMIT_TYPE());
			pst.setString(18, bean.getWITHIN_RANGE());
			pst.setString(19, bean.getADHAR_NO());
			pst.setString(20, bean.getPAN_NO());
			pst.setBlob(21, inputStream);
			pst.setString(22, bean.getJOB_TYPE());
			pst.setString(23, bean.getM_USER_ID());
			
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}

	@Override
	public String driverChangePassword(String psw1,String psw2,String psw3,String userId) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update user_login set password='"+psw2+"' where  password='"+psw1+"' and EMAIL_ID='"+userId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}
	public String driverEmailVerification(String email) {
		  String vemail="";
		  String status=null;
		  try {
		   String query = "select * from user_login where EMAIL_ID='"+email+"'";
		   con=DBConnection.getConnection();
		   PreparedStatement preparedStatement = con.prepareStatement(query);
		   ResultSet rs = preparedStatement.executeQuery();
		   while(rs.next()){
			   vemail = rs.getString("EMAIL_ID");
			   status = rs.getString("STATUS");
		   }
		   if(status.equals("INACTIVE")){
			   status="INACTIVE";
		   }else{
			   status="ACTIVE";
		   }
		   preparedStatement.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }finally {
				try {
					
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		  return status;
		 }
	public String updateStatus(String email) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update add_driver set STATUS='ACTIVE' where  STATUS='INACTIVE'";
			String query1="update user_login set STATUS='ACTIVE' where  STATUS='INACTIVE'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			pst1=con.prepareStatement(query1);
			int i=pst.executeUpdate();
			int j=pst1.executeUpdate();
			if(i>0 && j>0){
				driverMessage=" Verified Successfully,login here...";
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
		return driverMessage;
	}
	@Override
	public String InsertOnDemandDriverRoutes(OnDemandDriverRoutes driverRts) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String message="";
		try{
			
			SQLDate sqlDate=new SQLDate();
			String date=sqlDate.getInDate(driverRts.getDATE());
			
			String query="insert into on_demand_preferred_routes values(?,?,?,?,?,?,?)";
			con=DBConnection.getConnection();
		    pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, driverRts.getON_DEMAND_ROUTE_ID());
		   pst.setString(2, driverRts.getFROM_CITY());
		   pst.setString(3, driverRts.getTO_CITY());
		   pst.setString(4, date);
		   pst.setString(5, driverRts.getTIME());
		   pst.setString(6, driverRts.getONDEMAND_ID());
		   pst.setString(7, "ACTIVE");
		   
		   int i= pst.executeUpdate();
		    if(i>0){
		    	message="Your Routes Added Successfulle....";
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
	public String updateOnDemandDriverRoutes(String email,String status,String id) {
		// TODO Auto-generated method stub
		
		if(status!=null && status.equals("ACTIVE")){
			status="INACTIVE";	
			}else{
				status="ACTIVE";	
			}
			
			Statement st=null;
			String message="";
			int j=0;
			try{
				con=DBConnection.getConnection();
				st=con.createStatement();
					String query="update on_demand_preferred_routes set STATUS='"+status+"' where  ONDEMAND_ID='"+email+"' and ON_DEMAND_ROUTE_ID='"+id+"'";
					j=st.executeUpdate(query);
				if(j>0){
					message="Your Data Is Updated Successfully...";
				}else{
					message="Your Data Is Not Updated Please Try Once Again..";
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			return message;
	}
	@Override
	public ArrayList<OnDemandDriverRoutes> getOnDemandDriverRoutes(String userId) {
		// TODO Auto-generated method stub
		ArrayList<OnDemandDriverRoutes> driverRt=new	ArrayList<OnDemandDriverRoutes>();
		PreparedStatement pst=null;
		try{
			String query="select * from on_demand_preferred_routes where ONDEMAND_ID='"+userId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				OnDemandDriverRoutes driverB=new OnDemandDriverRoutes();
				
				driverB.setON_DEMAND_ROUTE_ID(rs.getInt("ON_DEMAND_ROUTE_ID"));
				driverB.setFROM_CITY(rs.getString("FROM_CITY"));
				driverB.setTO_CITY(rs.getString("TO_CITY"));
				driverB.setDATE(rs.getString("AVL_DATE"));
				driverB.setTIME(rs.getString("TIME"));
				driverB.setSTATUS(rs.getString("STATUS"));
				
				driverRt.add(driverB);
				
			}
			rs.close();
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
		return driverRt;
	}
	@Override
	public Set<String> getOnDemandDriverLocation() {
		// TODO Auto-generated method stub
		Set<String> location=new	HashSet<String>();
		PreparedStatement pst=null;
		try{
			String query="select * from on_demand_preferred_routes";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				location.add(rs.getString("FROM_CITY"));
				location.add(rs.getString("TO_CITY"));
				
			}
			rs.close();
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
		return location;
	}
	public String driverJobType(String email) {
		  String jobType=null;
		  try {
		   String query = "select * from add_driver where EMAIL='"+email+"'";
		   con=DBConnection.getConnection();
		   PreparedStatement preparedStatement = con.prepareStatement(query);
		   ResultSet rs = preparedStatement.executeQuery();
		   while(rs.next()){
			   
			   jobType = rs.getString("JOB_TYPE");
		   }
		   
		   preparedStatement.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }finally {
				try {
					
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		  return jobType;
		 }
	@SuppressWarnings("finally")
	public ArrayList<DriverBean> displayHomePageDriverDetails(String state,String dist,String permitType,String range,String licenseType,int offset,int noOfRecords){
		ArrayList hdriver=new ArrayList();
		Statement st=null;
		ResultSet rs=null;
		String query=null;


		try{
			if(state==null && dist==null && permitType==null && licenseType==null){
				
//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				
			}else if(state.equals("All")|| ( state.equals("All") && permitType.equals("All") && licenseType.equals("All"))){

//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
			
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				
			}
			else if(!state.equals("SELECT") && dist.equals("All") || permitType.equals("All") || licenseType.equals("All")){

//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE')  order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				
				}
			else  if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && licenseType.equals("SELECT")){
				
//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && permitType.equals("SELECT") && licenseType.equals("SELECT")){
				
//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else if(!state.equals("SELECT") && dist.equals("SELECT") && !permitType.equals("SELECT") && licenseType.equals("SELECT")){

//					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and  PERMIT_TYPE='"+permitType+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE')  order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and  PERMIT_TYPE='"+permitType+"' and JOB_TYPE='Full Time'  order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}
			else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && licenseType.equals("SELECT")){
				
				
					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and PERMIT_TYPE='"+permitType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
			}/*else if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and WITHIN_RANGE='"+range+"' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
				
			}*//*else if(!state.equals("SELECT") && dist.equals("SELECT") && !permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				

					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE='"+permitType+"' and WITHIN_RANGE='"+range+"' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			}*//*else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && range!="" && licenseType.equals("SELECT")){
				
				
					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.FROM_LOCATION,driver_preferred_routes.TO_LOCATION,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and DISTRICT='"+dist+"' and PERMIT_TYPE='"+permitType+"' and WITHIN_RANGE='"+range+"' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			}*/else if(!state.equals("SELECT") && dist.equals("SELECT") && permitType.equals("SELECT") && !licenseType.equals("SELECT")){
					
//						query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver  left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && permitType.equals("SELECT") && !licenseType.equals("SELECT")){
					
//					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && !licenseType.equals("SELECT")){
				
//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and PERMIT_TYPE='"+permitType+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"'and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and PERMIT_TYPE='"+permitType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else if(!state.equals("SELECT") && !dist.equals("SELECT") && !permitType.equals("SELECT") && !licenseType.equals("SELECT")){
					
//					query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE='"+permitType+"' and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;
					
				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where STATE='"+state+"' and PERMIT_TYPE='"+permitType+"' and DISTRICT='"+dist+"' and LICENSE_TYPE='"+licenseType+"' and JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}else{
				
//				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_preferred_routes.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_preferred_routes on add_driver.M_USER_ID=driver_preferred_routes.D_USER_ID left join driver_expected_sal on driver_preferred_routes.D_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' and (driver_preferred_routes.STATUS is null || driver_preferred_routes.STATUS!='INACTIVE') order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

				query="select SQL_CALC_FOUND_ROWS add_driver.*,driver_expected_sal.DEXPECTED_SAL from add_driver left join driver_expected_sal on add_driver.M_USER_ID=driver_expected_sal.DR_USER_ID where JOB_TYPE='Full Time' order by SEQ_DRIVER_ID ASC limit " + offset + ", " + noOfRecords;

			
			}
			con=DBConnection.getConnection();
			st=con.createStatement();
			if(query!=null){
			rs=st.executeQuery(query);
			byte licenseDoc[];
			byte photo[];
	        Blob blob1;
	        Blob blob2;
			while(rs.next()){
				DriverBean bean=new DriverBean();
				InsertDriverPreRtsAndSal driverRtsSal=new InsertDriverPreRtsAndSal();
				bean.setSEQ_DRIVER_ID(rs.getInt("SEQ_DRIVER_ID"));
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setDOB(rs.getString("DOB"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				bean.setEXPIRY_DATE(rs.getString("EXPIRY_DATE"));
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				bean.setDRIVER_AVAILABILITY(rs.getString("AVAILABILITY"));
				bean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				blob1=rs.getBlob("LICENSE_DOC");
				licenseDoc=blob1.getBytes(1, (int)blob1.length());
				String licenseDoc1 = Base64.encode(licenseDoc);
				bean.setLICENSE_DOC(licenseDoc1);
				blob2=rs.getBlob("PHOTO");
				photo=blob2.getBytes(1, (int)blob2.length());
				String photo1 = Base64.encode(photo);
				bean.setPHOTO(photo1);
//				driverRtsSal.setFROM_LOCATION(rs.getString("FROM_LOCATION"));
//				driverRtsSal.setTO_LOCATION(rs.getString("TO_LOCATION"));
				driverRtsSal.setDEXPECTED_SAL(rs.getString("DEXPECTED_SAL"));
				hdriver.add(bean);
				hdriver.add(driverRtsSal);
			}
			rs.close();
			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next()){
				this.noOfRecords = rs.getInt(1);
         
      } 
			
			}else{
			}

			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{			
				st.close();
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return hdriver;
		}
	} 
	
	@Override
	public String driverEndUserVerification(String apptId) {
		// TODO Auto-generated method stub
		
			
		Statement st=null;
		Statement st1=null;
		Statement st2=null;
		String message="";
		
		try{
			String squery="SELECT * FROM driver_end_user where APPOINTMENT_ID='"+apptId+"'";
			
			List<DriverEndUser> driver= getDriverEndUserDetails(squery);
			Iterator it=driver.iterator();
			DriverEndUser email=null;
			while(it.hasNext()){
				
				email=(DriverEndUser)it.next();
			}
			String query="update driver_end_user set STATUS='ACTIVE' and EMAIL_VERIFICATION='YES' where  APPOINTMENT_ID='"+apptId+"'";
			String query1="update individual_owner_rigister set STATUS='ACTIVE' where  EMAIL_ID='"+email.getEMAIL()+"'";
			String query2="update user_login set STATUS='ACTIVE' where  EMAIL_ID='"+email.getEMAIL()+"'";
			
			con=DBConnection.getConnection();
			st=con.createStatement();
			st1=con.createStatement();
			st2=con.createStatement();

			int i=st.executeUpdate(query);
			int j=st1.executeUpdate(query1);
			int k=st2.executeUpdate(query2);
			
			if(i>0 && j>0 && k>0){
				message="Your Email Is Verified Successfully...";
			}else{
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return message;
		
	}
	@Override
	public List<DriverEndUser> getDriverEndUserById(String apptId) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM driver_end_user where APPOINTMENT_ID='"+apptId+"'";
		
		List<DriverEndUser> driver= getDriverEndUserDetails(query);
		
				return driver;
	}

	@Override
	public List<DriverEndUser> getDriverEndUserDetails(String query) {
		// TODO Auto-generated method stub
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		try{
			SQLDate sqlDate=new SQLDate();
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverEndUser driver=new DriverEndUser();
				
				driver.setNAME(rs.getString("NAME"));
				driver.setEMAIL(rs.getString("EMAIL"));
				driver.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driver.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
				driver.setAPPOINTMENT_TIME(rs.getString("APPOINTMENT_TIME"));
				driver.setEMAIL_VERIFICATION(rs.getString("EMAIL_VERIFICATION"));
				driver.setSTATUS(rs.getString("STATUS"));
				driver.setDRIVER_EMAIL(rs.getString("DRIVER_EMAIL"));
				driver.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				driver.setACCEPTANCE(rs.getString("ACCEPTANCE"));
				driver.setADDRESS(rs.getString("ADDRESS"));
				driver.setDRIVER_CHARGES(rs.getString("DRIVER_CHARGES"));
				driver.setDRIVER_WAITING_CHARGES(rs.getString("DRIVER_WAITING_CHARGES"));
				driver.setDESTINATION(rs.getString("DESTINATION"));
				driverAl.add(driver);
			}
			rs.close();
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
		return driverAl;
	}
	
	@Override
	public List<DriverEndUser> getDriverEndUserDetailsWithPage(String query) {
		// TODO Auto-generated method stub
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		try{
			SQLDate sqlDate=new SQLDate();
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverEndUser driver=new DriverEndUser();
				
				driver.setNAME(rs.getString("NAME"));
				driver.setEMAIL(rs.getString("EMAIL"));
				driver.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driver.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
				driver.setAPPOINTMENT_TIME(rs.getString("APPOINTMENT_TIME"));
				driver.setEMAIL_VERIFICATION(rs.getString("EMAIL_VERIFICATION"));
				driver.setSTATUS(rs.getString("STATUS"));
				driver.setDRIVER_EMAIL(rs.getString("DRIVER_EMAIL"));
				driver.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				driver.setACCEPTANCE(rs.getString("ACCEPTANCE"));
				driver.setADDRESS(rs.getString("ADDRESS"));
				driver.setDRIVER_CHARGES(rs.getString("DRIVER_CHARGES"));
				driver.setDRIVER_WAITING_CHARGES(rs.getString("DRIVER_WAITING_CHARGES"));
				driver.setDESTINATION(rs.getString("DESTINATION"));
				
				driverAl.add(driver);
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
		return driverAl;
	}
	
	@Override
	public List<String> getDriverByEmail(String email) {
		// TODO Auto-generated method stub
		List<String> driverAl=new	ArrayList<String>();
		PreparedStatement pst=null;
		try{
			String query="select * from add_driver where M_USER_ID='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				driverAl.add(rs.getString("FIRST_NAME"));
				driverAl.add(rs.getString("LAST_NAME"));
				driverAl.add(rs.getString("EMAIL"));
				driverAl.add(rs.getString("MOBILE_NO"));
				driverAl.add(rs.getString("DRIVER_ID"));
			}
			rs.close();
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
		return driverAl;
	}
	@SuppressWarnings({ "finally", "unused" })
	public ArrayList searchHOnDemandDriver(String from,String to,String date,String time,int offset,int noOfRecords){
		ArrayList hdriver=new ArrayList();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		
		if(!from.equals("") && to.equals("AnyCity") && date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;
	
		}else if(!from.equals("") && to.equals("AnyCity") && !date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and AVL_DATE='"+date+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;
			
		}else if(!from.equals("") && to.equals("AnyCity") && !date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and AVL_DATE='"+date+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;
			
		}else if(!from.equals("") && to.equals("") && date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE'";
			
		}else if(!from.equals("") && !to.equals("") && date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and (TO_CITY='"+to+"' || TO_CITY='Any City') and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(!from.equals("") && !to.equals("") && !date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and (TO_CITY='"+to+"' || TO_CITY='Any City') and AVL_DATE='"+date+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(!from.equals("") && !to.equals("") && !date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and (TO_CITY='"+to+"' || TO_CITY='Any City') and AVL_DATE='"+date+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(!from.equals("") && to.equals("") && !date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and AVL_DATE='"+date+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(!from.equals("") && to.equals("") && !date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and AVL_DATE='"+date+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(!from.equals("") && to.equals("") && date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and FROM_CITY='"+from+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && !to.equals("") && !date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and (TO_CITY='"+to+"' || TO_CITY='Any City') and AVL_DATE='"+date+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && !to.equals("") && !date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and (TO_CITY='"+to+"' || TO_CITY='Any City') and AVL_DATE='"+date+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && !to.equals("") && date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and (TO_CITY='"+to+"' || TO_CITY='Any City') and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && to.equals("") && !date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and AVL_DATE='"+date+"' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && !to.equals("") && date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and (TO_CITY='"+to+"' || TO_CITY='Any City') and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && to.equals("") && !date.equals("") && time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and AVL_DATE='"+date+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else if(from.equals("") && to.equals("") && date.equals("") && !time.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and TIME='"+time+"' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;

			
		}else{
			query="select SQL_CALC_FOUND_ROWS add_driver.*,on_demand_preferred_routes.*,ondemand_expected_amount.* from add_driver left join on_demand_preferred_routes on add_driver.M_USER_ID=on_demand_preferred_routes.ONDEMAND_ID left join ondemand_expected_amount on on_demand_preferred_routes.ONDEMAND_ID=ondemand_expected_amount.ONDEMAND_DRIVER_ID where JOB_TYPE='On Demand' and add_driver.STATUS='ACTIVE' and on_demand_preferred_routes.STATUS='ACTIVE' limit " + offset + ", " + noOfRecords;
		}
		try{
			con=DBConnection.getConnection();
			st=con.createStatement();
			if(query!=null){
			rs=st.executeQuery(query);
			byte licenseDoc[];
			byte photo[];
	        Blob blob1;
	        Blob blob2;
			while(rs.next()){
				DriverBean bean=new DriverBean();
				OnDemandDriverRoutes preRtSal=new OnDemandDriverRoutes();
				bean.setSEQ_DRIVER_ID(rs.getInt("SEQ_DRIVER_ID"));
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setDOB(rs.getString("DOB"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				bean.setEXPIRY_DATE(rs.getString("EXPIRY_DATE"));
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				bean.setDRIVER_AVAILABILITY(rs.getString("AVAILABILITY"));
				bean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				blob1=rs.getBlob("LICENSE_DOC");
				licenseDoc=blob1.getBytes(1, (int)blob1.length());
				String licenseDoc1 = Base64.encode(licenseDoc);
				bean.setLICENSE_DOC(licenseDoc1);
				blob2=rs.getBlob("PHOTO");
				photo=blob2.getBytes(1, (int)blob2.length());
				String photo1 = Base64.encode(photo);
				bean.setPHOTO(photo1);
				
				preRtSal.setFROM_CITY(rs.getString("FROM_CITY"));
				preRtSal.setTO_CITY(rs.getString("TO_CITY"));
				preRtSal.setON_DEMAND_ROUTE_ID(rs.getInt("ON_DEMAND_ROUTE_ID"));
				
				preRtSal.setDATE(rs.getString("AVL_DATE"));
				preRtSal.setTIME(rs.getString("TIME"));
				preRtSal.setEXPECTED_CHARGES(rs.getString("EXPECTED_CHARGES"));
				preRtSal.setWAITING_CHARGES(rs.getString("WAITING_CHARGES"));
				hdriver.add(bean);
				hdriver.add(preRtSal);
			}
			rs.close();
			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next()){
				this.noOfRecords = rs.getInt(1);
         
      } 
			}else{
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{			
				st.close();
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return hdriver;
		}
	}
	@Override
	public List<String> getLoginDetails(String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		List<String> loginList=new ArrayList<String>();
		try{
			String query="select * from user_login where email_id='"+email+"'";
			
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				
				loginList.add(rs.getString("EMAIL_ID"));
				loginList.add(rs.getString("PASSWORD"));
				loginList.add(rs.getString("STATUS"));
				
			}
			rs.close();
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
		return loginList;
	}
	@Override
	public String insertDriverRating(String apptId, String rate) {
		// TODO Auto-generated method stub
		Statement st=null;
		String message=null;
		
		try{
			
			String query="update driver_end_user set RATING='"+rate+"' where  APPOINTMENT_ID='"+apptId+"'";
			
			con=DBConnection.getConnection();
			st=con.createStatement();

			int i=st.executeUpdate(query);
			
			if(i>0){
				message="Thank your for your feedback...";
			}else{
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return message;
	}
	@Override
	public String InsertDriverEndUser(DriverEndUser driverEndUser,UserLogin login) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		String message="";
		int j=0;
		int k=0;
		try{
			
			String id1=new IdGen().getId("DRIVER_APPT_ID");
			DriverId did=new DriverId();
			String driverEndUserId=did.driverEndUserId(id1);
			String IoEmail=getIndividualOwnerEmail(driverEndUser.getEMAIL());
			
			List<String> list=getLoginDetails(driverEndUser.getEMAIL());
			String status=null;
			if(list!=null && list.size()>0){
		    status= list.get(2);
			}
			
		   String query="insert into driver_end_user values(?,?,?,?,?,?,?,?,?,CURDATE(),?,?,?,?,?,?,?,?)";
		   String query1="insert into individual_owner_rigister values(?,?,?,?,?,?,?,?,?,?,?,CURDATE())";
		   String query2="insert into user_login values(?,?,?,?,?,?)";
		   
		   con=DBConnection.getConnection();
		   pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, driverEndUser.getDRIVER_END_USER_ID());
		   pst.setString(2, driverEndUser.getNAME());
		   pst.setString(3, driverEndUser.getEMAIL());
		   pst.setString(4, driverEndUser.getMOBILE_NO());
		   pst.setString(5, driverEndUser.getAPPOINTMENT_DATE());
		   pst.setString(6, driverEndUser.getAPPOINTMENT_TIME());
		   pst.setString(7, driverEndUser.getRATING());
		   if(status!=null && status.equals("ACTIVE")){
		   pst.setString(8, "YES");
		   }else{
			   pst.setString(8, "NO"); 
		   }
		   if(status!=null && status.equals("ACTIVE")){
		   pst.setString(9, "ACTIVE");
		   }else{
			   pst.setString(9, "INACTIVE"); 
		   }
		   pst.setString(10, driverEndUser.getDRIVER_EMAIL());
		   pst.setString(11, driverEndUserId);
		   pst.setString(12, driverEndUser.getADDRESS());
//		   pst.setString(13, login.getREFERENCE_ID());
		   pst.setString(13, "YES");
		   pst.setString(14, driverEndUser.getDESTINATION());
		   pst.setString(15, driverEndUser.getDRIVER_CHARGES());
		   pst.setString(16, driverEndUser.getDRIVER_WAITING_CHARGES());
		   pst.setString(17, "NO");
		   int i=pst.executeUpdate();

		   	if(IoEmail==null){
		   		
		   	IndividualOwnerRegister inregister=new IndividualOwnerRegister();
		   	pst1=con.prepareStatement(query1,pst1.RETURN_GENERATED_KEYS);
		    pst1.setInt(1,inregister.getSEQUENTIAL_NO());
		    pst1.setString(2, "IO");
		    pst1.setString(3, inregister.getPANCARD_NO());
		    pst1.setString(4, inregister.getCITY());
		    pst1.setString(5, inregister.getPINCODE_NO());
		    pst1.setString(6, null);
		    pst1.setString(7, driverEndUser.getNAME());
		    pst1.setString(8, driverEndUser.getMOBILE_NO());
		    pst1.setString(9, driverEndUser.getEMAIL());
		    pst1.setString(10, "INACTIVE");
		    pst1.setString(11, "YES");
		    j=pst1.executeUpdate();
		    
		    pst2=con.prepareStatement(query2,pst2.RETURN_GENERATED_KEYS);
			pst2.setInt(1, login.getSEQUENCE_NO());
			pst2.setString(2, login.getEMAIL_ID());
			pst2.setString(3, login.getPASSWORD());
			pst2.setString(4, "IO");
			pst2.setString(5, "0");
			pst2.setString(6, "INACTIVE");
			
			k=pst2.executeUpdate();
		   	}

		    List<String> list1=getDriverByEmail(driverEndUser.getDRIVER_EMAIL());
		    
		   	SendEmailToUser sentMail=new SendEmailToUser();
		   	
		   	if(status!=null && status.equals("INACTIVE")){
		   		
		   		sentMail.sendVerificationMailToDriverEndUser(driverEndUser,list1,driverEndUserId);	
		   		
		   	}else if(status!=null && status.equals("ACTIVE")){
		   		
		   		sentMail.bookedMailToDriverEndUser(driverEndUser,list1,driverEndUserId);
		   		
		   	}
		   	
		    if(i>0){
		    	
		    	message="Your Appointment is  Added Successfulle and Appointment Id is sent to your mail";
		    	
		    } if(i>0 && j>0 && k>0){
		    	
		    	message="Your Appointment Id is sent to your mail,your request Appointment will not accept until you verify your email";
		    	
		    	
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
public List<String> getDriverRating(String email){
		
		

	PreparedStatement pst=null;
	ResultSet rs=null;
	String rating=null;
	
	List<String> rate=new ArrayList<String>();
	try{
		String query="select RATING from driver_end_user where DRIVER_EMAIL='"+email+"'";
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
	public String getIndividualOwnerEmail(String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String IOemail=null;
		try{
			String query="select email_id from individual_owner_rigister where email_id='"+email+"'";
			
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				
				IOemail=rs.getString("EMAIL_ID");
				
			}
			rs.close();
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
		return IOemail;
	}
	@Override
	public int getNoOfRecords(){
		// TODO Auto-generated method stub
		return noOfRecords;
	}
	@Override
	public List<DriverEndUser> getDriverEndUser(String date,String email,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		
		
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		
		String query=null;
		if(date!=null && date.equals("N")){
			
			query="select SQL_CALC_FOUND_ROWS * from driver_end_user where DRIVER_EMAIL='"+email+"' and STATUS='ACTIVE' and NOTIFICATION_SEEN_BY_DRIVER='NO' order by DRIVER_END_USER_ID desc limit " + offset + ", " + noOfRecords;
			
		}else if(date!=null && !date.equals("null") && !date.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS * from driver_end_user where APPOINTMENT_DATE='"+date+"' and DRIVER_EMAIL='"+email+"' and STATUS='ACTIVE' order by DRIVER_END_USER_ID desc limit " + offset + ", " + noOfRecords;
			
		}else{
			
			query="select SQL_CALC_FOUND_ROWS * from driver_end_user where DRIVER_EMAIL='"+email+"' and STATUS='ACTIVE' order by DRIVER_END_USER_ID desc limit " + offset + ", " + noOfRecords;
			
		}
	
		List<DriverEndUser> endUser= getDriverEndUserDetailsWithPage(query);
		return endUser;
		
	}
	@Override
	public String updateDriverRequester(String apptId,String status) {
		// TODO Auto-generated method stub
		Statement st=null;
		String message=null;
		
		if(status!=null && status.equals("NO")){
			
			status="NO";
			
		}else if(status!=null && status.equals("YES")){
			
			status="NO";
			
		}
		
		try{
			
			String query="update driver_end_user set ACCEPTANCE='"+status+"' where  APPOINTMENT_ID='"+apptId+"'";
			
			con=DBConnection.getConnection();
			st=con.createStatement();

			int i=st.executeUpdate(query);
			
			if(i>0){
				
				message="Accepeted Requester Request....";
				
			}else{
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return message;
	}
	@Override
	public List<DriverBean> getDriverName(String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		ResultSet rs=null;
		String rating=null;
		
		List<DriverBean> driverAl=new ArrayList<DriverBean>();
		try{
			String query="select * from add_driver where EMAIL='"+email+"'";		
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				DriverBean driverBean=new DriverBean();
				driverBean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				driverBean.setLAST_NAME(rs.getString("LAST_NAME"));
				driverBean.setEMAIL(rs.getString("EMAIL"));
				driverBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driverBean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				
				driverAl.add(driverBean);
				
				
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
		
				return driverAl;
	}
	@Override
	public List<DriverEndUser> showDriverEndUserToAllDsb(String date,String email,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		
		String query=null;
		
		if(date!=null && !date.equals("")){
			
			query="select SQL_CALC_FOUND_ROWS * from driver_end_user where APPOINTMENT_DATE='"+date+"' and EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;
			
		}else{
			
			query="select SQL_CALC_FOUND_ROWS * from driver_end_user where EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;
			
		}
	
		List<DriverEndUser> endUser= getDriverEndUserDetailsWithPage(query);

		return endUser;
	}
	

	@Override
	public DriverBean getDriverDetailsById(String driverId) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		ResultSet rs=null;
		String rating=null;
		
		DriverBean driverBean=null;
		
		try{
			String query="select * from add_driver where DRIVER_ID='"+driverId+"'";		
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
				
				driverBean=new DriverBean();
				driverBean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				driverBean.setLAST_NAME(rs.getString("LAST_NAME"));
				driverBean.setEMAIL(rs.getString("EMAIL"));
				driverBean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driverBean.setADDRESS(rs.getString("ADDRESS"));
				
				driverBean.setDRIVER_ID(rs.getString("DRIVER_ID"));
								
				
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
		
				return driverBean;
	}
	
	@Override
	public String insertMultiDriverRequest(DriverEndUser driverEndUser, UserLogin login, List<String> driverList) {
		// TODO Auto-generated method stub
		SendEmailToUser sentMail=new SendEmailToUser();
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		String message="";
		int j=0;
		int k=0;
		try{
			
			String id1=new IdGen().getId("DRIVER_APPT_ID");
			DriverId did=new DriverId();
			String driverEndUserId=did.driverEndUserId(id1);
			String IoEmail=getIndividualOwnerEmail(driverEndUser.getEMAIL());
			
			List<String> list=getLoginDetails(driverEndUser.getEMAIL());
			String status=null;
			if(list!=null && list.size()>0){
		    status= list.get(2);
			}
			
		   String query="insert into driver_end_user values(?,?,?,?,?,?,?,?,?,CURDATE(),?,?,?,?,?,?,?,?)";
		   String query1="insert into individual_owner_rigister values(?,?,?,?,?,?,?,?,?,?,?,CURDATE())";
		   String query2="insert into user_login values(?,?,?,?,?,?)";
		   
		   int i=0;
		   for(int m=0;m<driverList.size();m++){
			   
			List<OnDemandDriverRoutes> charges=getOnDemandAmount(driverList.get(m));
			Iterator it=charges.iterator();
			
			OnDemandDriverRoutes driverCharges=null;
			while(it.hasNext()){
				driverCharges=(OnDemandDriverRoutes)it.next();	
			}
			   
		   con=DBConnection.getConnection();
		   pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, driverEndUser.getDRIVER_END_USER_ID());
		   pst.setString(2, driverEndUser.getNAME());
		   pst.setString(3, driverEndUser.getEMAIL());
		   pst.setString(4, driverEndUser.getMOBILE_NO());
		   pst.setString(5, driverEndUser.getAPPOINTMENT_DATE());
		   pst.setString(6, driverEndUser.getAPPOINTMENT_TIME());
		   pst.setString(7, driverEndUser.getRATING());
		   if(status!=null && status.equals("ACTIVE")){
		   pst.setString(8, "YES");
		   }else{
			   pst.setString(8, "NO"); 
		   }
		   if(status!=null && status.equals("ACTIVE")){
		   pst.setString(9, "ACTIVE");
		   }else{
			   pst.setString(9, "INACTIVE"); 
		   }
		   pst.setString(10, driverList.get(m));
		   pst.setString(11, driverEndUserId);
		   pst.setString(12, driverEndUser.getADDRESS());
//		   pst.setString(13, login.getREFERENCE_ID());
		   pst.setString(13, "YES");
		   pst.setString(14, driverEndUser.getDESTINATION());
		   
		   if(driverCharges!=null){
		   pst.setString(15, driverCharges.getEXPECTED_CHARGES());
		   pst.setString(16, driverCharges.getWAITING_CHARGES());
		   }else{
			   pst.setString(15, null);
			   pst.setString(16, null); 
		   }
		   pst.setString(17, "NO");
		   i=pst.executeUpdate();
           
		   if(i>0 && status!=null && status.equals("ACTIVE")){
			 
			   sentMail.sendEndUserDetailsToDriverMail(driverEndUser,  driverList.get(m),driverEndUserId);
			   
		   }
		   
		   
		   }
		   
		   	if(IoEmail==null){
		   		
		   	IndividualOwnerRegister inregister=new IndividualOwnerRegister();
		   	pst1=con.prepareStatement(query1,pst1.RETURN_GENERATED_KEYS);
		    pst1.setInt(1,inregister.getSEQUENTIAL_NO());
		    pst1.setString(2, "IO");
		    pst1.setString(3, inregister.getPANCARD_NO());
		    pst1.setString(4, inregister.getCITY());
		    pst1.setString(5, inregister.getPINCODE_NO());
		    pst1.setString(6, null);
		    pst1.setString(7, driverEndUser.getNAME());
		    pst1.setString(8, driverEndUser.getMOBILE_NO());
		    pst1.setString(9, driverEndUser.getEMAIL());
		    pst1.setString(10, "INACTIVE");
		    pst1.setString(11, "YES");
		    j=pst1.executeUpdate();
		    
		    pst2=con.prepareStatement(query2,pst2.RETURN_GENERATED_KEYS);
			pst2.setInt(1, login.getSEQUENCE_NO());
			pst2.setString(2, login.getEMAIL_ID());
			pst2.setString(3, login.getPASSWORD());
			pst2.setString(4, "IO");
			pst2.setString(5, "0");
			pst2.setString(6, "INACTIVE");
			
			k=pst2.executeUpdate();
		   	}

		   	List<DriverBean> list1=new ArrayList<DriverBean>();
		   	for(int n=0;n<driverList.size();n++){
		   	List<String> list2=getDriverByEmail(driverList.get(n));
		   
		   	DriverBean bean=new DriverBean();
		   	bean.setFIRST_NAME(list2.get(0));
		   	bean.setDRIVER_ID(list2.get(4));
		   	bean.setMOBILE_NO(list2.get(3));
		   	list1.add(bean);
		   	
		   	}
		   	
		   	if(status!=null && status.equals("INACTIVE")){
		   		
		   		sentMail.multiDriverRequestVerificationMailToDriverEndUser(driverEndUser,list1,driverEndUserId);	
		   		
		   	}else if(status!=null && status.equals("ACTIVE")){
		   		
		   		sentMail.bookedMultiDriverMailToDriverEndUser(driverEndUser,list1,driverEndUserId);
		   		
		   	}
		   	
		    if(i>0){
		    	
		    	message="Your Appointment is  Added Successfulle and Appointment Id is sent to your mail";
		    	
		    } if(i>0 && j>0 && k>0){
		    	
		    	message="Your Appointment Id is sent to your mail,your request Appointment will not accept until you verify your email";
		    	
		    	
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
	public String insertOndemandAmount(String expCharges, String waitingCharges, String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		String message=null;
		String sal=null;
		try{
			String query1="select * from ondemand_expected_amount where ONDEMAND_DRIVER_ID='"+email+"'";
			String query2="insert into ondemand_expected_amount values(?,?,?,?)";
			String query3="insert into update_driver_amount values(?,?,?,CURDATE(),CURRENT_TIME(),?)";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query1);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			sal=rs.getString("EXPECTED_CHARGES");
			}
			if(sal!=null){
				
			}else{
		   pst=con.prepareStatement(query2,pst.RETURN_GENERATED_KEYS);
		   pst.setInt(1, 0);
		   pst.setString(2, expCharges);
		   pst.setString(3, waitingCharges);
		   pst.setString(4, email);
		   int i= pst.executeUpdate();
		   
		   pst1=con.prepareStatement(query3,pst.RETURN_GENERATED_KEYS);
		   pst1.setInt(1, 0);
		   pst1.setString(2, expCharges);
		   pst1.setString(3, waitingCharges);
		   pst1.setString(4, email);
		   int j= pst1.executeUpdate();
		   
		    if(i>0 && j>0){
		    	message="Your Amount Added Successfulle....";
		    }else{
		    	
		    }
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
	public List<OnDemandDriverRoutes> getOnDemandAmount(String email) {
		// TODO Auto-generated method stub
		List<OnDemandDriverRoutes> driverSal=new	ArrayList<OnDemandDriverRoutes>();
		PreparedStatement pst=null;
		try{
			String query="select * from ondemand_expected_amount where ONDEMAND_DRIVER_ID='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				OnDemandDriverRoutes driverSalB=new OnDemandDriverRoutes();
//				driverSalB.setONDEMAND_AMOUNT_ID(rs.getInt("ONDEMAND_AMOUNT_ID"));
				driverSalB.setEXPECTED_CHARGES(rs.getString("EXPECTED_CHARGES"));
				driverSalB.setWAITING_CHARGES(rs.getString("WAITING_CHARGES"));
				driverSal.add(driverSalB);
			}
			System.out.println(query);
			rs.close();
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
		return driverSal;
	}
	

	@Override
	public String UpdateOnDemandAmount(String expCharges, String waitingCharges, String email) {
		// TODO Auto-generated method stub
		String message1="";
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query1="update ondemand_expected_amount set EXPECTED_CHARGES='"+expCharges+"' , WAITING_CHARGES='"+waitingCharges+"' where  ONDEMAND_DRIVER_ID='"+email+"'";
			String query="insert into update_driver_amount values(?,?,?,CURDATE(),CURRENT_TIME(),?)";
			
			   con=DBConnection.getConnection();
			   pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
			   pst.setInt(1, 0);
			   pst.setString(2, expCharges);
			   pst.setString(3, waitingCharges);
			   pst.setString(4, email);
			   int i= pst.executeUpdate();
			   
			   pst1=con.prepareStatement(query1);
			   int j=pst1.executeUpdate();
			   
			   if(i>0 && j>0){
				  
				   message1="Amount Updated Successfully....";
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
		return message1;
	}
	

	@Override
	public String updateDriverJobType(String jobType, String email) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update add_driver set JOB_TYPE='"+jobType+"' where  M_USER_ID='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}
	
	@Override
	public String getDriverRequesterNotification(String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String count=null;
		try{
			String query="SELECT count(*) FROM driver_end_user where NOTIFICATION_SEEN_BY_DRIVER='NO' and status='ACTIVE' and DRIVER_EMAIL='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			count=rs.getString("count(*)");
			}
			rs.close();
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
		return count;
	}
	
	@Override
	public String updateRequesterNotification(String email) {
		// TODO Auto-generated method stub
		String driverMessage=null;
		PreparedStatement pst=null;
		try{
			/*set SQL_SAFE_UPDATES=0; */
			String query="update driver_end_user set NOTIFICATION_SEEN_BY_DRIVER='YES' where  DRIVER_EMAIL='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				driverMessage=" Updated Successfully....";
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
		return driverMessage;
	}
	
	@Override
	public String insertDriverTripId(String email, String apptId) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String message="";
		String tripId=null;
		try{
			String id1=new IdGen().getId("DRIVER_TRIP_ID");
			DriverId did=new DriverId();
			tripId=did.driverTripId(id1);
			String query="insert into driver_acceptance values(?,?,?,?)";
			con=DBConnection.getConnection();
		    pst=con.prepareStatement(query,pst.RETURN_GENERATED_KEYS);
		    pst.setInt(1, 0);
		    pst.setString(2, tripId);
		    pst.setString(3, email);
		    pst.setString(4, apptId);
		   
		    int i= pst.executeUpdate();
		    if(i>0){
		    	message="Generated Your Trip Id....";
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
		return tripId;
	}
	
	@Override
	public Set<String> getDriverTripId(String email) {
		// TODO Auto-generated method stub
		Set<String> location=new	HashSet<String>();
		PreparedStatement pst=null;
		try{
			String query="select DRIVER_TRIP_ID from driver_acceptance where DRIVER_EMAIL='"+email+"' and DRIVER_TRIP_ID is not null";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				location.add(rs.getString("DRIVER_TRIP_ID"));
				
				
			}
			rs.close();
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
		return location;
	}
	
	@Override
	public List<DriverEndUser> getDriverReports(String date, String tripId , String email,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		String query=null;
		
		if(date!=null && !date.equals("") && tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join  driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where APPOINTMENT_DATE='"+date+"' and driver_end_user.DRIVER_EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;
			
		}else if(date!=null && date.equals("") && !tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join  driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where DRIVER_TRIP_ID='"+tripId+"' and driver_end_user.DRIVER_EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;

			
		}else if(date!=null  && !date.equals("") && !tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join  driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where APPOINTMENT_DATE='"+date+"' and DRIVER_TRIP_ID='"+tripId+"' and driver_end_user.DRIVER_EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;

			
		}else{
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join  driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where driver_end_user.DRIVER_EMAIL='"+email+"' limit " + offset + ", " + noOfRecords;

			
		}
		
		try{
			SQLDate sqlDate=new SQLDate();
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverEndUser driver=new DriverEndUser();
				
				driver.setNAME(rs.getString("NAME"));
				driver.setEMAIL(rs.getString("EMAIL"));
				driver.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driver.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
				driver.setAPPOINTMENT_TIME(rs.getString("APPOINTMENT_TIME"));
				driver.setEMAIL_VERIFICATION(rs.getString("EMAIL_VERIFICATION"));
				driver.setSTATUS(rs.getString("STATUS"));
				driver.setDRIVER_EMAIL(rs.getString("DRIVER_EMAIL"));
				driver.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				driver.setACCEPTANCE(rs.getString("ACCEPTANCE"));
				driver.setADDRESS(rs.getString("ADDRESS"));
				driver.setDRIVER_CHARGES(rs.getString("DRIVER_CHARGES"));
				driver.setDRIVER_WAITING_CHARGES(rs.getString("DRIVER_WAITING_CHARGES"));
				driver.setDRIVER_TRIP_ID(rs.getString("DRIVER_TRIP_ID"));
				driver.setDESTINATION(rs.getString("DESTINATION"));
				
				driverAl.add(driver);
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
		return driverAl;
	}

	@Override
	public String insertDriverFeedBack(String apptId, String tripId, String noOfHours, String waitingHours,
			String email) {
		// TODO Auto-generated method stub
		String message="";
		PreparedStatement pst=null;
		try{
			
			String id1=new IdGen().getId("DRIVER_BILL_ID");
			DriverId did=new DriverId();
			String billId=did.driverBillId(id1);
			
			con=DBConnection.getConnection();
		    pst=con.prepareStatement("insert into driver_feedback values(?,?,?,?,?,?,?,CURDATE())",pst.RETURN_GENERATED_KEYS);
		    
		    pst.setInt(1, 0);
		    pst.setString(2, noOfHours);
		    pst.setString(3, waitingHours);
		    pst.setString(4, apptId);
		    pst.setString(5, tripId);
		    pst.setString(6, email);
		    pst.setString(7, billId);
		
		    int i=pst.executeUpdate();
			
			if(i>0){
				message="Your Bill Has Generated SuccessFully......";
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
	public List<DriverFeedBack> getDriverBill(String apptId, String tripId) {
		// TODO Auto-generated method stub
		List<DriverFeedBack> driverBill=new	ArrayList<DriverFeedBack>();
		PreparedStatement pst=null;
		try{
			String query="select * from driver_feedback where USER_REQUEST_ID='"+apptId+"' and TRIP_ID='"+tripId+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverFeedBack driverFeedBack=new DriverFeedBack();
				driverFeedBack.setDRIVER_BILL_DATE(rs.getString("DRIVER_BILL_DATE"));
				driverFeedBack.setDRIVER_EMAIL(rs.getString("DRIVER_EMAIL"));
				driverFeedBack.setTRAVELLING_HOUR(rs.getString("TRAVELLING_HOUR"));
				driverFeedBack.setWAITING_HOUR(rs.getString("WAITING_HOUR"));
				driverFeedBack.setDRIVER_BILL_ID(rs.getString("DRIVER_BILL_ID"));
				driverFeedBack.setTRIP_ID(rs.getString("TRIP_ID"));
				driverBill.add(driverFeedBack);
			}
			rs.close();
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
		return driverBill;
	}

	@Override
	public String getDriverBillId(String apptId, String tripId, String email) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		String billId=null;
		try{
			String query="select * from driver_feedback where USER_REQUEST_ID='"+apptId+"' and TRIP_ID='"+tripId+"' and DRIVER_EMAIL='"+email+"'";
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				billId=rs.getString("DRIVER_BILL_ID");
			
			}
			rs.close();
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
		return billId;
	}

	@Override
	public List<DriverEndUser> getDriverEndUserReports(String date, String tripId, String userMail,int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		List<DriverEndUser> driverAl=new ArrayList<DriverEndUser>();
		PreparedStatement pst=null;
		String query=null;
		
		
		if(date!=null && !date.equals("") && tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where APPOINTMENT_DATE='"+date+"' and EMAIL='"+userMail+"' limit " + offset + ", " + noOfRecords;
			
		}else if(date!=null && date.equals("") && !tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where DRIVER_TRIP_ID='"+tripId+"' and EMAIL='"+userMail+"' limit " + offset + ", " + noOfRecords;

			
		}else if(date!=null  && !date.equals("") && !tripId.equals("")){
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where APPOINTMENT_DATE='"+date+"' and DRIVER_TRIP_ID='"+tripId+"' and EMAIL='"+userMail+"' limit " + offset + ", " + noOfRecords;

			
		}else{
			
			query="SELECT SQL_CALC_FOUND_ROWS driver_end_user.*,driver_acceptance.* from driver_end_user inner join driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where EMAIL='"+userMail+"' limit " + offset + ", " + noOfRecords;

			
		}
		try{
			con=DBConnection.getConnection();
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				DriverEndUser driver=new DriverEndUser();
				
				driver.setNAME(rs.getString("NAME"));
				driver.setEMAIL(rs.getString("EMAIL"));
				driver.setMOBILE_NO(rs.getString("MOBILE_NO"));
				driver.setAPPOINTMENT_DATE(rs.getString("APPOINTMENT_DATE"));
				driver.setAPPOINTMENT_TIME(rs.getString("APPOINTMENT_TIME"));
				driver.setEMAIL_VERIFICATION(rs.getString("EMAIL_VERIFICATION"));
				driver.setSTATUS(rs.getString("STATUS"));
				driver.setDRIVER_EMAIL(rs.getString("DRIVER_EMAIL"));
				driver.setAPPOINTMENT_ID(rs.getString("APPOINTMENT_ID"));
				driver.setACCEPTANCE(rs.getString("ACCEPTANCE"));
				driver.setADDRESS(rs.getString("ADDRESS"));
				driver.setDRIVER_TRIP_ID(rs.getString("DRIVER_TRIP_ID"));
				driver.setDESTINATION(rs.getString("DESTINATION"));
				driver.setDRIVER_CHARGES(rs.getString("DRIVER_CHARGES"));
				driver.setDRIVER_WAITING_CHARGES(rs.getString("DRIVER_WAITING_CHARGES"));
				
				driverAl.add(driver);
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
		return driverAl;
	}

	@Override
	public Set<String> getEndUserTripId(String email) {
		// TODO Auto-generated method stub
		Set<String> userTripId = new HashSet<String>();
		PreparedStatement pst = null;
		try {
			String query = "SELECT driver_end_user.EMAIL,driver_acceptance.DRIVER_TRIP_ID from driver_end_user inner join driver_acceptance on driver_end_user.APPOINTMENT_ID=driver_acceptance.DRIVER_END_USER_ID where driver_end_user.EMAIL='"+ email + "'";
			con = DBConnection.getConnection();
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				userTripId.add(rs.getString("DRIVER_TRIP_ID"));

			}
			rs.close();
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
		return userTripId;
	}
}
		



