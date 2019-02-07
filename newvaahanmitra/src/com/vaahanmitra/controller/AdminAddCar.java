package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class AdminAddCar
 */
@javax.servlet.annotation.MultipartConfig
public class AdminAddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminAddCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=null;
		AddCar addCar = new AddCar();
		addCar.setCAR_BRAND(request.getParameter("carBrand"));
		addCar.setCAR_MODEL(request.getParameter("carModel"));
		addCar.setVARIANT_NAME(request.getParameter("variantName"));
		addCar.setNO_OF_GEARS(request.getParameter("gears"));
		addCar.setCAR_MAKE_YEAR(request.getParameter("makeYear"));
		addCar.setENGINE_TYPE(request.getParameter("engineType"));
		addCar.setENGINE_DISPLACEMENT(request.getParameter("displacement"));
		addCar.setNO_OF_CYLINDERS(request.getParameter("cylinders"));
		addCar.setVALVES_PER_CYLINDERS(request.getParameter("vpCylinders"));
		addCar.setMAX_POWER(request.getParameter("maxPower"));
		addCar.setMAX_TORQUE(request.getParameter("maxTorque"));
		addCar.setFUEL_SUPPLY_SYSTEM(request.getParameter("fuelSupplySystem"));
		addCar.setTRANSMISSION_TYPE(request.getParameter("transmissionType"));
		addCar.setGEAR_BOX(request.getParameter("gearBox"));
		addCar.setWHEEL_DRIVE(request.getParameter("wDrive"));
		addCar.setBODY_TYPE(request.getParameter("b_type"));
		addCar.setFRONT_SUSPENSION(request.getParameter("frontSuspension"));
		addCar.setREAR_SUSPENSION(request.getParameter("rearSuspension"));
		addCar.setSTEERING_TYPE(request.getParameter("steeringType"));
		addCar.setTURNING_RADIONS(request.getParameter("turningRadions"));
		addCar.setMILEAGE(request.getParameter("mileage"));
		addCar.setFUEL_TYPE(request.getParameter("fuelType"));
		addCar.setFUELTANK_CAPACITY(request.getParameter("tankCapacity"));
		addCar.setTOP_SPEED(request.getParameter("topSpeed"));
		addCar.setACCELERATION(request.getParameter("acceleration"));
		addCar.setFRONT_BRAKE_TYPE(request.getParameter("frontBrakeType"));
		addCar.setRARE_BRAKE_TYPE(request.getParameter("rareBrakeType"));
		addCar.setANTI_LOCK_BRAKING_SYSTEM(request.getParameter("brakingSystem"));
		addCar.setTYRE_TYPE(request.getParameter("t_type"));
		addCar.setTYRE_SIZE(request.getParameter("tyreSize"));
		addCar.setWHEEL_SIZE(request.getParameter("wheelSize"));
		addCar.setPOWER_STEERING(request.getParameter("powerSteering"));
		addCar.setAIR_CONDITIONER(request.getParameter("airConditioner"));
		addCar.setREAR_AC(request.getParameter("rearAC"));
		addCar.setSTEERING_ADJUSTMENT(request.getParameter("steeringAdjustment"));
		addCar.setKEYLESS_START(request.getParameter("keylessStart"));
		addCar.setPARKING_SENSORS(request.getParameter("parkingSensors"));
		addCar.setPARKING_ASSIST(request.getParameter("parkingAssist"));
		addCar.setAIR_BAGS(request.getParameter("airBags"));
		addCar.setSEAT_BELT_WARNING(request.getParameter("seatBeltWarning"));
	    addCar.setCOLOR(request.getParameter("color"));
		Part photo = request.getPart("photo");
	
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");

		InputStream is = null;
		if(photo!=null)
		{
			is = photo.getInputStream();	
		}
		AddCarDao dao=new AddCarDaoImpl();
		String message = dao.addCar(addCar,user_name,is);
		
		if(message!=null&&message.equals("success")){
			request.setAttribute("success", "Car Added successfully. Please Add More fields...");
			page = "./addNewCar.jsp";
		}else if(message!=null&&message.equals("Alerdy Exits")){
			request.setAttribute("success", "Details with This Variant Already Exits...");
			page = "./addNewCar.jsp";
		}else{
			request.setAttribute("success", "Car not added try again...");
			page = "./addNewCar.jsp";
		}
		RequestDispatcher rd= request.getRequestDispatcher(page);
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
