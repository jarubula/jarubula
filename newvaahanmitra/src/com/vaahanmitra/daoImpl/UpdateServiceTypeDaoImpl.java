package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.vaahanmitra.dao.UpdateServieTypePriceDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.SpareParts;
import com.vaahanmitra.model.UpdateServicePrice;

public class UpdateServiceTypeDaoImpl implements UpdateServieTypePriceDao{
	
 	private Connection conn = DBConnection.getConnection();
	/*public String addServicetypePrice(UpdateServicePrice updateServicePrice) {
		String message=null;
		try {
			String query = "insert into update_service_price values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, updateServicePrice.getSEQUENCE_NO());
			preparedStatement.setString(2, updateServicePrice.getSERVICE_ID());
			preparedStatement.setString(3, updateServicePrice.getSERVICE_TYPE());
			preparedStatement.setString(4, updateServicePrice.getPRICE());
			preparedStatement.setString(5, updateServicePrice.getDISCOUNT());
			preparedStatement.setString(6, updateServicePrice.getFINAL_PRICE());
			
			int i = preparedStatement.executeUpdate();
			if(i>0)
			{
				message="Service Price Successfully updated...";
			}
			else
			{
				message="data not inserted please try again";
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return message;
	}*/
	@Override
	public String addServicetypePrice(List<UpdateServicePrice> list, String user_name) {
		String message = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		int i = 0;
		System.out.println(list.get(0));
		try {
			String sql = "UPDATE update_service_price SET PRICE=?, DISCOUNT=? WHERE SERVICE_CENTER_ID =?";
			conn = DBConnection.getConnection();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				UpdateServicePrice usp = (UpdateServicePrice) it.next();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, usp.getPRICE());
				preparedStatement.setString(2, usp.getDISCOUNT());
				preparedStatement.setString(3, usp.getSERVICE_CENTER_ID());
				i = preparedStatement.executeUpdate();
			}
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
