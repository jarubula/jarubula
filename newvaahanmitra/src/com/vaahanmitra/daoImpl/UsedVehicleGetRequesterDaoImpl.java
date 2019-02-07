package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vaahanmitra.dao.UsedVehicleGetRequesterDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UsedVehicleGetRequester;

public class UsedVehicleGetRequesterDaoImpl implements UsedVehicleGetRequesterDao {

	Connection conn = DBConnection.getConnection();

	@Override
	public ArrayList<UsedVehicleGetRequester> getCarId(String carId, String user_name) {
		ArrayList<UsedVehicleGetRequester> al = new ArrayList<UsedVehicleGetRequester>();
		String query = null;
		try {
			if (carId.equals("all")) {
				query = "SELECT end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "' and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "' and VEHICLE_ID= '" + carId
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedVehicleGetRequester ub = new UsedVehicleGetRequester();
				ub.setVEHICLE_ID(rs.getString("VEHICLE_ID"));
				ub.setEMAIL(rs.getString("EMAIL"));
				ub.setNAME(rs.getString("NAME"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<UsedVehicleGetRequester> searchByDate(String carId, String fdate, String tdate, String user_name) {

		ArrayList<UsedVehicleGetRequester> al = new ArrayList<UsedVehicleGetRequester>();
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (carId.equals("all") && fdate == "" && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId.equals("all") && fdate != null && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID WHERE REQUESTER_DATE='"
						+ fdate + "'  and end_user_details.VEHICLE_TYPE='4' and used_car.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";

			} else if (carId.equals("all") && fdate != null && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID WHERE  (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate
						+ "') and end_user_details.VEHICLE_TYPE='4' and used_car.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate == "" && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and VEHICLE_ID='"
						+ carId + "' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate != null && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and VEHICLE_ID='"
						+ carId + "' and REQUESTER_DATE= '" + fdate + "' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate != null && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + carId
						+ "' and VEHICLE_TYPE='4' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate == "" && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + carId
						+ "' and VEHICLE_TYPE='4' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedVehicleGetRequester ub = new UsedVehicleGetRequester();
				ub.setVEHICLE_ID(rs.getString("VEHICLE_ID"));
				ub.setEMAIL(rs.getString("EMAIL"));
				ub.setNAME(rs.getString("NAME"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<UsedVehicleGetRequester> getBikeRequest(String bikeId, String user_name) {
		ArrayList<UsedVehicleGetRequester> al = new ArrayList<UsedVehicleGetRequester>();
		conn = DBConnection.getConnection();
		try {
			String query = null;
			if (bikeId.equals("all")) {
				query = "SELECT end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and status='ACTIVE' AND AVAILABLE='Y'";
			} else {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and VEHICLE_ID= '" + bikeId + "'and status='ACTIVE' AND AVAILABLE='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
//			System.out.println(query);
			while (rs.next()) {
				UsedVehicleGetRequester ub = new UsedVehicleGetRequester();
				ub.setVEHICLE_ID(rs.getString("VEHICLE_ID"));
				ub.setEMAIL(rs.getString("EMAIL"));
				ub.setNAME(rs.getString("NAME"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ub);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<UsedVehicleGetRequester> searchBikeByDate(String bikeId, String fdate, String tdate,
			String user_name) {
		ArrayList<UsedVehicleGetRequester> al = new ArrayList<UsedVehicleGetRequester>();
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (bikeId.equals("all") && fdate == "" && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "'";
			} else if (bikeId.equals("all") && fdate != null && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID WHERE REQUESTER_DATE='"
						+ fdate + "'  and end_user_details.VEHICLE_TYPE='2' and used_bike.USER_NAME='" + user_name
						+ "'";
			} else if (bikeId.equals("all") && fdate != null && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID WHERE  (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate
						+ "') and end_user_details.VEHICLE_TYPE='2' and used_bike.USER_NAME='" + user_name + "'";
			} else if (bikeId != null && fdate == "" && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and VEHICLE_ID='"
						+ bikeId + "' and USER_NAME='" + user_name + "'";
			} else if (bikeId != null && fdate != null && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and VEHICLE_ID='"
						+ bikeId + "' and REQUESTER_DATE= '" + fdate + "' and USER_NAME='" + user_name + "'";
			} else if (bikeId != null && fdate != null && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + bikeId
						+ "' and VEHICLE_TYPE='2' and USER_NAME='" + user_name + "'";
			} else if (bikeId != null && fdate == "" && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + bikeId
						+ "' and VEHICLE_TYPE='2' and USER_NAME='" + user_name + "'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedVehicleGetRequester ub = new UsedVehicleGetRequester();
				ub.setVEHICLE_ID(rs.getString("VEHICLE_ID"));
				ub.setEMAIL(rs.getString("EMAIL"));
				ub.setNAME(rs.getString("NAME"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ub);
			}
//			System.out.println(query);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public String getCarCount(String carId, String user_name) {

		String count = null;
		String query = null;
		try {
			if (carId.equals("all")) {
				query = "SELECT used_car.*,end_user_details.*,count(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "' and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "' and VEHICLE_ID= '" + carId + "' and EMAIL_VERIFICATION='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String getCarCount(String carId, String fdate, String tdate, String user_name) {
		String count = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (carId.equals("all") && fdate == "" && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and USER_NAME='"
						+ user_name + "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId.equals("all") && fdate != null && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID WHERE REQUESTER_DATE='"
						+ fdate + "'  and end_user_details.VEHICLE_TYPE='4' and used_car.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId.equals("all") && fdate != null && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID WHERE  (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate
						+ "') and end_user_details.VEHICLE_TYPE='4' and used_car.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate == "" && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*, COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and VEHICLE_ID='"
						+ carId + "' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate != null && tdate == "") {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='4' and VEHICLE_ID='"
						+ carId + "' and REQUESTER_DATE= '" + fdate + "' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate != null && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + carId
						+ "' and VEHICLE_TYPE='4' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else if (carId != null && fdate == "" && tdate != null) {
				query = "SELECT used_car.GEN_CAR_ID,end_user_details.*,COUNT(*) from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + carId
						+ "' and VEHICLE_TYPE='4' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String getBikesCount(String bikeId, String user_name) {
		String count = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (bikeId.equals("all")) {
				query = "SELECT used_bike.*,end_user_details.*,count(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and status='ACTIVE' AND AVAILABLE='Y'";
			} else {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and VEHICLE_ID= '" + bikeId + "'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String getBikeCount(String bikeId, String fdate, String tdate, String user_name) {
		String count = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (bikeId.equals("all") && fdate == "" && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId.equals("all") && fdate != null && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID WHERE REQUESTER_DATE='"
						+ fdate + "'  and end_user_details.VEHICLE_TYPE='2' and used_bike.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId.equals("all") && fdate != null && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID WHERE  (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate
						+ "') and end_user_details.VEHICLE_TYPE='2' and used_bike.USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId != null && fdate == "" && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*, COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and VEHICLE_ID='"
						+ bikeId + "' and USER_NAME='" + user_name + "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId != null && fdate != null && tdate == "") {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and VEHICLE_ID='"
						+ bikeId + "' and REQUESTER_DATE= '" + fdate + "' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId != null && fdate != null && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + bikeId
						+ "' and VEHICLE_TYPE='2' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y'";
			} else if (bikeId != null && fdate == "" && tdate != null) {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where (REQUESTER_DATE BETWEEN '"
						+ fdate + "' AND '" + tdate + "') and VEHICLE_ID='" + bikeId
						+ "' and VEHICLE_TYPE='2' and USER_NAME='" + user_name
						+ "'and status='ACTIVE' AND AVAILABLE='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
//			System.out.println(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String getBikeRequestCount(String bikeId, String user_name) {

		String count = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (bikeId.equals("all")) {
				query = "SELECT used_bike.*,end_user_details.*,count(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and status='ACTIVE' AND AVAILABLE='Y' and EMAIL_VERIFICATION='Y'";
			} else {
				query = "SELECT used_bike.GEN_BIKE_ID,end_user_details.*,COUNT(*) from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where VEHICLE_TYPE='2' and USER_NAME='"
						+ user_name + "' and VEHICLE_ID= '" + bikeId + "' and EMAIL_VERIFICATION='Y'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getString("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ArrayList<UsedCar> searchCarRequester(String fdate, String tdate, String carId, String user_name) {
		ArrayList<UsedCar> al = new ArrayList<UsedCar>();
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (carId.equals("all") && fdate == "" && tdate == "") {
//				System.out.println("1");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y'";
			}else if (carId.equals("all") && fdate != null && tdate == "") {
//				System.out.println("2");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and REQUESTER_DATE='"+fdate+"'";
			}else if (carId.equals("all") && fdate != null && tdate != null) {
//				System.out.println("3");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+"')";
			}else if (carId != null && fdate == "" && tdate == "") {
//				System.out.println("4");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+carId+"'";
			}else if (carId != null && fdate != null && tdate == "") {
//				System.out.println("5");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+carId+"' and REQUESTER_DATE='"+fdate+"'";
			}else if (carId != null && fdate != null && tdate != null) {
//				System.out.println("6");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+carId+"' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+"')";
			}else if (carId != null && fdate == "" && tdate != null) {
//				System.out.println("7");
				query = "SELECT used_car.*,end_user_details.* from used_car left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+carId+"' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+ "')";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedCar ud = new UsedCar();
				ud.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
				ud.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ud.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				ud.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ud.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ud);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public int getCarVisitors(String vehicleId,char vehicleType) {
		int count = 0;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			query="SELECT COUNT(*) from end_user_details where VEHICLE_TYPE='"+vehicleType+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+vehicleId+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ArrayList<UsedVehicleGetRequester> getCarIds(String email,String vehicleType) {
		Connection conn = null;
		ArrayList<UsedVehicleGetRequester> uvgcAl = new ArrayList<UsedVehicleGetRequester>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT VEHICLE_ID from end_user_details where EMAIL='"+email+"' AND VEHICLE_TYPE='"+vehicleType+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedVehicleGetRequester uvgc = new UsedVehicleGetRequester();
				uvgc.setVEHICLE_ID(rs.getString("VEHICLE_ID"));
				uvgcAl.add(uvgc);
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
		return uvgcAl;
	}

	@Override
	public ArrayList<UsedBike> searchBikeRequester(String fdate, String tdate, String bikeId, String user_name) {
		ArrayList<UsedBike> al = new ArrayList<UsedBike>();
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (bikeId.equals("all") && fdate == "" && tdate == "") {
//				System.out.println("1");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y'";
			}else if (bikeId.equals("all") && fdate != null && tdate == "") {
//				System.out.println("2");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and REQUESTER_DATE='"+fdate+"'";
			}else if (bikeId.equals("all") && fdate != null && tdate != null) {
//				System.out.println("3");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+"')";
			}else if (bikeId != null && fdate == "" && tdate == "") {
//				System.out.println("4");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+bikeId+"'";
			}else if (bikeId != null && fdate != null && tdate == "") {
//				System.out.println("5");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+bikeId+"' and REQUESTER_DATE='"+fdate+"'";
			}else if (bikeId != null && fdate != null && tdate != null) {
//				System.out.println("6");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+bikeId+"' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+"')";
			}else if (bikeId != null && fdate == "" && tdate != null) {
//				System.out.println("7");
				query = "SELECT used_bike.*,end_user_details.* from used_bike left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where end_user_details.EMAIL='"+user_name+"' and EMAIL_VERIFICATION='Y' and VEHICLE_ID='"+bikeId+"' and (REQUESTER_DATE BETWEEN '"+fdate+ "' AND '" +tdate+ "')";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UsedBike ub = new UsedBike();
				ub.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
				ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setREQUESTER_DATE(rs.getString("REQUESTER_DATE"));
				al.add(ub);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
