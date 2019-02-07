package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.vaahanmitra.dao.AssignBrandsToDealerDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.DealerAssignBrands;

public class AssignBrandsToDealerDaoImpl implements AssignBrandsToDealerDao{

	private Connection con = null;
	@Override
	public String assignBrandsToDealer(DealerAssignBrands bean) {
		PreparedStatement pst = null;
		String message = null;
		try {
			String query = "insert into dealer_assigned_brands values(?,?,?,?,?,?)";
			con = DBConnection.getConnection();
			pst = con.prepareStatement(query, pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, bean.getSEQUENCE_NO());
			pst.setString(2, bean.getEmail());
			pst.setString(3, bean.getVehicleType());
			pst.setString(4, bean.getBrand());
			pst.setString(5, bean.getModel());
			pst.setString(6, bean.getCity());

			int i = pst.executeUpdate();
			if (i > 0) {
				message = "Models are asigned...";
			} else {
				message = "not asigned! try again!";
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
	public ArrayList<BusinessOwnerRegister> getDealerList(String city, String brand, String model, String vType) {
		BusinessOwnerRegisterDaoImpl dao = new BusinessOwnerRegisterDaoImpl();
		String query = "select business_owner_register.* from business_owner_register left join dealer_assigned_brands on business_owner_register.EMAIL_ID=dealer_assigned_brands.EMAIL where business_owner_register.B_CITY='"+city+"' and brand='"+brand+"' and dealer_assigned_brands.VEHICLE_TYPE='"+vType+"'";
		ArrayList<BusinessOwnerRegister> bosAl =  dao.getQueriedOwnerDetails(query);
		return bosAl;
	}
}
