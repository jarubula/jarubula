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
 * Servlet implementation class AdNewCar
 */
public class NewCarSpecifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewCarSpecifications() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page=null;
		AddCar addCar = new AddCar();
		addCar.setNEW_CAR_ID(request.getParameter("carId"));
		
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
		addCar.setWARRANTY_YEAR(request.getParameter("warranty(Years)"));
		addCar.setWARRANTY_KMS(request.getParameter("warranty(Kms)"));
		addCar.setCLOCK(request.getParameter("clock"));
		addCar.setLOW_FUEL_LEVEL_WARNING(request.getParameter("lowFuellevelWaring"));
		addCar.setDOOR_CLOSE_WARNING(request.getParameter("doorCloseWaring"));
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
		addCar.setGROUND_CLEARANCE(request.getParameter("groundClearance"));
		addCar.setBLUETOOTH(request.getParameter("bluetooth"));
		addCar.setTRIP_METER(request.getParameter("trip_meter"));
		addCar.setKRAB_WEIGHT(request.getParameter("Krab_weight"));
		addCar.setBOOT_SPACE(request.getParameter("boot_space"));
		addCar.setGEAR_SHIFT_INDICATOR(request.getParameter("gear_shift_indicator"));
		
		AddCarDao dao=new AddCarDaoImpl();
		String message = dao.addCarSpecifications(addCar);
		
		if(message.equals("success")){
			request.setAttribute("success", "Car Added successfully. Please Add More fields...");
			page = "./addNewCar.jsp";
		}
		else{
			request.setAttribute("success", "Car not added try again...");
			page = "./addNewCar.jsp";
		}
		RequestDispatcher rd= request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
