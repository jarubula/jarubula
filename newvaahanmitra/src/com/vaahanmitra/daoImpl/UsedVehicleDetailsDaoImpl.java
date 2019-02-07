package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.vaahanmitra.dao.UsedVehicleDetailsDao;
import com.vaahanmitra.dbutil.DBConnection;

public class UsedVehicleDetailsDaoImpl implements UsedVehicleDetailsDao {
	private java.sql.Connection con =null;

	@Override
	public Map<String,Set<String>> getVehicleBrand(String vehicleType) {
		
		Map<String,Set<String>> map = new TreeMap<String,Set<String>>();
		Set<String> brand = new TreeSet<String>();
		Set<String> city = new TreeSet<String>();
		
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			if( vehicleType.equals("4,")){
			query="select CAR_BRAND,city from used_car where CAR_BRAND!='' and city!=''";
			}else if(vehicleType.equals("2,")){
				System.out.println("hai"+vehicleType);
				query="select BIKE_BRAND,city from used_bike where BIKE_BRAND!='' and city!=''";
			}else if(vehicleType.equals("4,2,")){
				query="SELECT used_car.CAR_BRAND,used_bike.BIKE_BRAND from used_car,used_bike where CAR_BRAND!='' and BIKE_BRAND!=''";
			}
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				if (vehicleType.equals("4,")) {
					brand.add(rs.getString("CAR_BRAND"));
					city.add(rs.getString("CITY"));
				} else if (vehicleType.equals("2,")) {
					brand.add(rs.getString("BIKE_BRAND"));
					city.add(rs.getString("CITY"));
				} /*else {
					brand.add(rs.getString("CAR_BRAND"));
					brand.add(rs.getString("BIKE_BRAND"));
				}*/
			}
			map.put("vBrand", brand);
			map.put("vCity", city);
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Set<String> getVehicleModel(String brand, String vType) {
		Set<String> models = new TreeSet<String>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			if( vType.equals("4,")){
			query="select car_model from used_car where car_brand='"+brand+"' and CAR_MODEL!='' group by car_model";
			}else if(vType.equals("2,")){
				query="select bike_model from used_bike where bike_brand='"+brand+"' and BIKE_MODEL!='' group by bike_model";
			}
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				if (vType.equals("4,")) {
					models.add(rs.getString("CAR_MODEL"));
				} else if (vType.equals("2,")) {
					models.add(rs.getString("BIKE_MODEL"));
				}
			}
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return models;
	}

	@Override
	public Set<String> getVehicleCity() {
		Set<String> brand = new TreeSet<String>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			query="select used_car.CITY as carCity,used_bike.CITY as bikeCity from used_car,used_bike";
			con=DBConnection.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				brand.add(rs.getString("carCity"));
				brand.add(rs.getString("bikeCity"));
			}
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return brand;
	}

	@Override
	public Set<String> getUsedVehicleBrand(String vType) {
		Set<String> models = new TreeSet<String>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			if( vType.equals("4,")){
				query="select CAR_BRAND from used_car where CAR_BRAND!='' and city!=''";
				}else if(vType.equals("2,")){
					query="select BIKE_BRAND from used_bike where BIKE_BRAND!='' and city!=''";
				}
				con=DBConnection.getConnection();
				st=con.createStatement();
				rs=st.executeQuery(query);
				while (rs.next()) {
					if (vType.equals("4,")) {
					models.add(rs.getString("CAR_BRAND"));
				} else if (vType.equals("2,")) {
					models.add(rs.getString("BIKE_BRAND"));
				} 
			}
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return models;
	}

	@Override
	public Set<String> getNewVehicleBrand(String vType) {
		Set<String> models = new TreeSet<String>();
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		try{
			if( vType.equals("4,")){
				query="select CAR_BRAND from add_car where CAR_BRAND!='' and CAR_BRAND is not null";
				}else if(vType.equals("2,")){
					query="select BIKE_BRAND from add_bike where BIKE_BRAND!='' and BIKE_BRAND is not null";
				}
				con=DBConnection.getConnection();
				st=con.createStatement();
				rs=st.executeQuery(query);
				while (rs.next()) {
					if (vType.equals("4,")) {
					models.add(rs.getString("CAR_BRAND"));
				} else if (vType.equals("2,")) {
					models.add(rs.getString("BIKE_BRAND"));
				} 
			}
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return models;
	}

	@Override
	public Set<String> getNewVehicleModel(String brand, String vType) {
		Set<String> models = new TreeSet<String>();
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			if (vType.equals("4,")) {
				query = "select CAR_MODEL from add_car where car_brand='"+brand+"' and CAR_MODEL!='' and CAR_MODEL is not null group by car_model";
			} else if (vType.equals("2,")) {
				query = "select BIKE_MODEL from add_bike where bike_brand='"+brand+"' and BIKE_MODEL!='' and BIKE_MODEL is not null group by bike_model";
			}
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (vType.equals("4,")) {
					models.add(rs.getString("CAR_MODEL"));
				} else if (vType.equals("2,")) {
					models.add(rs.getString("BIKE_MODEL"));
				}
			}
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return models;
	}
	
	public Set<String> getNewVehicleVariant(String brand,String model, String vType) {
		Set<String> variant = new TreeSet<String>();
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			if (vType.equals("4,")) {
			 query = "select VARIANT_NAME from add_car where car_brand='"+brand+"' and car_model='"+model+"' and VARIANT_NAME is not null group by VARIANT_NAME";
			} else if (vType.equals("2,")) {
			 query = "select VARIANT_NAME from add_bike where bike_brand='"+brand+"' and bike_model='"+model+"' and VARIANT_NAME is not null group by VARIANT_NAME";
			}
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (vType.equals("4,")) {
					variant.add(rs.getString("VARIANT_NAME"));
				} else if (vType.equals("2,")) {
					variant.add(rs.getString("VARIANT_NAME"));
				}
			}
			System.out.println(query);
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return variant;
	}

}
