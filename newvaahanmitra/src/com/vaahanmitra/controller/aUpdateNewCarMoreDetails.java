package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class aUpdateNewCarMoreDetails
 */
public class aUpdateNewCarMoreDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aUpdateNewCarMoreDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String page=null;
		AddCar addCar = new AddCar();
		addCar.setENGINE_IMMOBILIZER(request.getParameter("engineImmobilizer"));
		addCar.setCENTRAL_LOCKING_SYSTEM(request.getParameter("centralLockingSystem"));
		addCar.setCHILD_LOCKING_SYSTEM(request.getParameter("childlockingSystem"));
		addCar.setAUTOMATIC_HEAD_LAMPS(request.getParameter("headLamps"));
		addCar.setFOR_LAMPS(request.getParameter("forLamps"));
		addCar.setTAIL_LAMPS(request.getParameter("tailLamps"));
		addCar.setHEAD_LIGHT(request.getParameter("headLight"));
		addCar.setHEIGHT_ADJUSTER(request.getParameter("heightAdjuster"));
		addCar.setMUSIC_SYSTEM(request.getParameter("musicSystem"));
		addCar.setDISPLAY(request.getParameter("display"));
		addCar.setDISPLAY_SCREEN_REAR_PASSENGERS(request.getParameter("screenRearPassengers"));
		addCar.setGPS_NAVIGATION_SYSTEM(request.getParameter("navigationSystem"));
		addCar.setSPEAKERS(request.getParameter("speakers"));
		addCar.setUSB_COMPATIBILITY(request.getParameter("USBcompatibility"));
		addCar.setMP3_PLAYER(request.getParameter("MP3"));
		addCar.setCD_PLAYER(request.getParameter("CDPlayer"));
		addCar.setDVD_PLAYER(request.getParameter("DVDPlayer"));
		addCar.setFM_RADIO(request.getParameter("FMAMRadio"));
		addCar.setBLUETOOTH(request.getParameter("bluetooth"));
		addCar.setWARRANTY_YEAR(request.getParameter("warranty(Years)"));
		addCar.setWARRANTY_KMS(request.getParameter("warranty(Kms)"));
		addCar.setCLOCK(request.getParameter("clock"));
		addCar.setLOW_FUEL_LEVEL_WARNING(request.getParameter("lowFuellevelWaring"));
		addCar.setDOOR_CLOSE_WARNING(request.getParameter("doorCloseWaring"));
		addCar.setTRIP_METER(request.getParameter("trip_meter"));
		addCar.setGEAR_SHIFT_INDICATOR(request.getParameter("gear_shift_indicator"));
		addCar.setPOWER_WINDOWS(request.getParameter("powerWindows"));
		addCar.setREAR_DETOGGER(request.getParameter("rearDetogger"));
		addCar.setREAR_WIPER(request.getParameter("rearWiper"));
		addCar.setRAIN_SENSING_WIPER(request.getParameter("rainSensingWiper"));
		addCar.setNO_OF_DOORS(request.getParameter("noOfDoors"));
		addCar.setSEATING_CAPACITY(request.getParameter("seatingCapacity"));
		addCar.setADJUST_PASSENGER_SEAT(request.getParameter("passengerSeatAdjustment"));
		addCar.setFOLDING_REAR_SEAT(request.getParameter("foldingRearSeat"));
		addCar.setSPLIT_RARE_SEAT(request.getParameter("splitRearSeat"));
		addCar.setLENGTH(request.getParameter("length"));
		addCar.setWIDTH(request.getParameter("width"));
		addCar.setHEIGHT(request.getParameter("height"));
		addCar.setWHEEL_BASE(request.getParameter("wheelbase"));
		addCar.setBOOT_SPACE(request.getParameter("boot_space"));
		addCar.setKRAB_WEIGHT(request.getParameter("Krab_weight"));
		addCar.setGROUND_CLEARANCE(request.getParameter("groundClearance"));
		addCar.setNEW_CAR_ID(request.getParameter("car_id"));

		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");

		
		AddCarDao dao=new AddCarDaoImpl(); 
		String message = dao.addCarSpecifications(addCar);

		if(message.equals("success")){
			request.setAttribute("success", "Car Updated successfully...");
			request.setAttribute("vehicleVariant", addCar.getNEW_CAR_ID());
			page = "./aGetNewCardetailsForUpdate";
		}
		else if(message.equals("Already Exits")){
			request.setAttribute("success", "Cannot Update this Data This Variant Name Already Exists For other Model...");
			request.setAttribute("vehicleVariant", addCar.getNEW_CAR_ID());

			page = "./aGetNewCardetailsForUpdate";
		}
		else{
			request.setAttribute("success", "Car not Updated try again...");
			request.setAttribute("vehicleVariant", addCar.getNEW_CAR_ID());

			page = "./aGetNewCardetailsForUpdate";
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
