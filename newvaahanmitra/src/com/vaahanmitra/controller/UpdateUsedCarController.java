package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.model.UsedCar;
/**
 * Servlet implementation class UpdateUsedCarController
 */
public class UpdateUsedCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsedCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		String carId = request.getParameter("carId");
		UsedCar usedCar = new UsedCar();
		String carNumber = request.getParameter("carNo");
		String carUpdate = request.getParameter("carUpdate");
		
		usedCar.setCAR_NUMBER(request.getParameter("carNo").toUpperCase());
		usedCar.setCAR_BRAND(request.getParameter("brandid").toUpperCase());
		usedCar.setCAR_MODEL(request.getParameter("carModel").toUpperCase());
		usedCar.setCURRENT_MILEAGE(request.getParameter("currentMileage"));
		usedCar.setFUEL_TYPE(request.getParameter("fuelType"));
		usedCar.setTRANSIMISSION(request.getParameter("transmission"));
		usedCar.setKMS_DRIVEN(request.getParameter("KMsDriven"));
		usedCar.setCOLOR(request.getParameter("color").toUpperCase());
		usedCar.setBODY_TYPE(request.getParameter("bodyType"));

		usedCar.setINSURANCE(request.getParameter("companyName").toUpperCase());
//		for update car photos UpdateServiceCenterProfileController
//		usedCar.setCERTIFIED_COMPANY_NAME(request.getParameter("cetifiedCompanyName").toUpperCase());
		usedCar.setREGISTERED_YEAR(request.getParameter("year"));
		usedCar.setMODEL_YEAR(request.getParameter("year1"));
		usedCar.setREGISTERED_STATE(request.getParameter("tstate").toUpperCase());
		usedCar.setREGISTERED_CITY(request.getParameter("tcity").toUpperCase());
		/*String address = request.getParameter("contactAddress");*/
		usedCar.setCAR_OWNER_NAME(request.getParameter("ownerName"));
		usedCar.setUSED_BY(request.getParameter("usedBy"));
//		usedCar.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners")));
		usedCar.setEMAIL_ID(request.getParameter("emailId"));
		usedCar.setMOBILE_NO(request.getParameter("mobileNo"));
		usedCar.setADDRESS(request.getParameter("address").toUpperCase());
		usedCar.setCITY(request.getParameter("city").toUpperCase());
		usedCar.setSTATE(request.getParameter("country2").toUpperCase());
		usedCar.setDISTRICT(request.getParameter("state").toUpperCase());
		usedCar.setPINCODE(request.getParameter("pincode"));
		usedCar.setOFFER_PRICE(request.getParameter("price"));

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		/*InputStream is = null;
		int counter = Integer.parseInt(request.getParameter("counter"));
		ArrayList<InputStream> al = new ArrayList<InputStream>();
		if (photo != null) {
			is = photo.getInputStream();
		}
		al.add(is);
		for (int i = 1; i <= counter; i++) {
			Part pht = request.getPart("photo" + i);
			if (pht != null) {
				is = pht.getInputStream();
				al.add(is);
			}
		}*/
		UsedCarDao dao = new UsedCarDaoImpl();
		String message = dao.updateUsedCar(usedCar,/*is,al,*/carId,carNumber,user_name);
		if (message.equals("success")) {
			message = "CAR UPDATED SUCCESSFULLY...";
			if(carUpdate.equals("IO")){
				page = "./updateUsedCar2.jsp";
			}else if(carUpdate.equals("UD")){
				page = "./updateUDUsedCar.jsp";
			}else if(carUpdate.equals("SC")){
				page = "./updateSCUsedCar.jsp";
			}
		} else {
			message = "Car not Updated! Please Try again!";
			if(carUpdate.equals("IO")){
				page = "./updateUsedCar2.jsp";
			}else if(carUpdate.equals("UD")){
				page = "./updateUDUsedCar.jsp";
			}else if(carUpdate.equals("SC")){
				page = "./updateSCUsedCar.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		request.setAttribute("carId", carId);
		request.setAttribute("carNumber", carNumber);
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
