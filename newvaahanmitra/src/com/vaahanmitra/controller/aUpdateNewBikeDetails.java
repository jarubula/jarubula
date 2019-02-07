package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.model.AddBike;

/**
 * Servlet implementation class aUpdateNewBikeDetails
 */
public class aUpdateNewBikeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public aUpdateNewBikeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		AddBike addBike = new AddBike();
		addBike.setBIKE_BRAND(request.getParameter("brand"));
		addBike.setBIKE_MODEL(request.getParameter("model"));
		addBike.setVARIANT_NAME(request.getParameter("variantname"));
		addBike.setCOLOR(request.getParameter("color"));
		addBike.setBIKE_PRODUCTION_YEAR(request.getParameter("productionYear"));
		addBike.setENGINE_TYPE(request.getParameter("engineType"));
	/*	addBike.setENGINE_CAPACITY(request.getParameter("engineCapacity"));*/
	    addBike.setDISPLACEMENT_CC(request.getParameter("displacement"));
	    addBike.setMAX_POWER(request.getParameter("power"));
	    addBike.setMAX_TORQUE(request.getParameter("torque"));
	    addBike.setBORE(request.getParameter("bore"));
		addBike.setSTROKE(request.getParameter("stroke"));
		addBike.setFUEL_SYSTEM(request.getParameter("fuel_system"));
		addBike.setFUEL_TYPE(request.getParameter("fuel_type"));
		addBike.setIGNITION(request.getParameter("ignition"));
		addBike.setDIGITAL_FUEL_INDICATOR(request.getParameter("digital_fuel_indicator"));
		addBike.setENGINE_STARTING(request.getParameter("electric_start"));
		addBike.setNO_OF_GEARS(request.getParameter("no_of_gears"));
		addBike.setFRONT_BRAKE(request.getParameter("brakes_front"));
		addBike.setREAR_BRAKE(request.getParameter("brakes_rear"));
		addBike.setMILEAGE(request.getParameter("milleage"));
		addBike.setTOP_SPEED(request.getParameter("top_speed"));
		addBike.setCHASSIS_TYPE(request.getParameter("chassis_type"));
		addBike.setFRONT_SUSPENSION(request.getParameter("suspension_front"));
		addBike.setREAR_SUSPENSION(request.getParameter("suspension_rear"));
		addBike.setTYRE_TYPE(request.getParameter("tyre_type"));
		addBike.setFRONT_TYRE(request.getParameter("tyre_size_front"));
		addBike.setREAR_TYRE(request.getParameter("tyre_size_rear"));
		addBike.setWHEEL_SIZE(request.getParameter("wheel_size"));
	    addBike.setWHEEL_TYPE(request.getParameter("wheel_type"));
		addBike.setLENGTH(request.getParameter("length"));
		addBike.setWIDTH(request.getParameter("width"));
		addBike.setHEIGHT(request.getParameter("height"));
		addBike.setWHEEL_BASE(request.getParameter("wheel_base"));
		addBike.setGROUND_CLEARANCE(request.getParameter("ground_clearance"));
		addBike.setFUEL_CAPACITY(request.getParameter("fuel_capacity"));
		addBike.setKERBWEIGHT(request.getParameter("kerb_weight"));
		addBike.setBATTERY_CAPACITY(request.getParameter("battery"));
		addBike.setHEAD_LAMP(request.getParameter("head_lamp"));
		addBike.setSTANDARD_WARRANTY_YEARS(request.getParameter("standard_warranty_years"));
		addBike.setSTANDARD_WARRANTY_KMS(request.getParameter("standard_warranty_kms"));
		addBike.setNEW_BIKE_ID(request.getParameter("bike_id"));
		
		addBike.toString();
	
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");

		
		AddBikeDao dao=new AddBikeDaoImpl(); 
		String message = dao.updateNewBike(addBike, user_name);

		if(message.equals("success")){
			request.setAttribute("success", "Bike Updated successfully...");
			request.setAttribute("vehicleVariant", addBike.getNEW_BIKE_ID());
			page = "./aGetNewBikedetailsForUpdate";
		}
		else if(message.equals("Already Exits")){
			request.setAttribute("success", "Cannot Update this Data This Variant Name Already Exists For other Model...");
			request.setAttribute("vehicleVariant", addBike.getNEW_BIKE_ID());

			page = "./aGetNewBikedetailsForUpdate";
		}
		else{
			request.setAttribute("success", "Bike not Updated try again...");
			request.setAttribute("vehicleVariant", addBike.getNEW_BIKE_ID());

			page = "./aGetNewBikedetailsForUpdate";
		}
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
