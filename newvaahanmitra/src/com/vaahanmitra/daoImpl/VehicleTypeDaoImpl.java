package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.vaahanmitra.dao.VehicleTypeDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.VehicleType;

public class VehicleTypeDaoImpl implements VehicleTypeDao {

	private Connection conn = DBConnection.getConnection();
	@Override
	public String vehicleDetails(VehicleType type, String user_name) {
		String message = null;
		
		try {
			String query = "insert into selected_vehicle_type_details values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, type.getSEQ_SELECTED_VEHICLE_DETAILS());
			preparedStatement.setString(2, type.getSELECTED_VEHICLE_TYPE());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, type.getBRAND());
			preparedStatement.setString(5, type.getMODEL());
			int i = preparedStatement.executeUpdate();
//			System.out.println(i);
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
		return message;
	}

}
