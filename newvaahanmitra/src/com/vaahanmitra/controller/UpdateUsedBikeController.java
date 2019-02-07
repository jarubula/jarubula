package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class UpdateUsedBikeController
 */
public class UpdateUsedBikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsedBikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		String page = null;
		String bikeId = request.getParameter("bikeId");
		UsedBike usedBike = new UsedBike();
		String bikeNumber = request.getParameter("bikeNo");
		String bikeUpdate = request.getParameter("bikeUpdate");
		
		usedBike.setBIKE_NUMBER(request.getParameter("bikeNo").toUpperCase());
		usedBike.setBIKE_BRAND(request.getParameter("bikeBrand").toUpperCase());
		usedBike.setBIKE_MODEL(request.getParameter("bikeModel").toUpperCase());
		usedBike.setCURRENT_MILEAGE(request.getParameter("currentMileage"));
		usedBike.setSTARTING_SYSTEM(request.getParameter("startingSystem"));
		usedBike.setFUELTANK_CAPACITY(request.getParameter("fueltankCapacity"));
		usedBike.setKMS_DRIVEN(request.getParameter("kmsDriven"));
		usedBike.setCOLOR(request.getParameter("color").toUpperCase());

		usedBike.setREGISTERED_YEAR(request.getParameter("year"));
/*		usedBike.setMODEL_YEAR(request.getParameter("year1"));*/
		usedBike.setREGISTERED_STATE(request.getParameter("tstate").toUpperCase());
		usedBike.setREGISTERED_CITY(request.getParameter("tcity").toUpperCase());
		/*String address = request.getParameter("contactAddress");*/
		usedBike.setBIKE_OWNER_NAME(request.getParameter("ownerName"));
		usedBike.setUSED_BY(request.getParameter("usedBy"));
		usedBike.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners")));
		usedBike.setEMAIL_ID(request.getParameter("emailId"));
		usedBike.setMOBILE_NO(request.getParameter("mobileNo"));
		usedBike.setADDRESS(request.getParameter("address").toUpperCase());
		usedBike.setCITY(request.getParameter("city").toUpperCase());
		usedBike.setSTATE(request.getParameter("country2").toUpperCase());
		usedBike.setDISTRICT(request.getParameter("state").toUpperCase());
		usedBike.setPINCODE(request.getParameter("pincode"));
		usedBike.setOFFER_PRICE(request.getParameter("price"));

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
		UsedBikeDao dao = new UsedBikeDaoImpl();
		String message = dao.updateUsedBike(usedBike, bikeId,bikeNumber, user_name);
		if (message.equals("success")) {
			message = "BIKE UPDATED SUCCESSFULLY...";
			if(bikeUpdate.equals("IO")){
				page = "./updateUsedBike.jsp";
			}else if(bikeUpdate.equals("UD")){
				page = "./updateUDUsedBike.jsp";
			}else if(bikeUpdate.equals("SC")){
				page = "./updateSCUsedBike.jsp";
			}
		} else {
			message = "Bike not Updated! Please Try again!";
			if(bikeUpdate.equals("IO")){
				page = "./updateUsedBike.jsp";
			}else if(bikeUpdate.equals("UD")){
				page = "./updateUDUsedBike.jsp";
			}else if(bikeUpdate.equals("SC")){
				page = "./updateSCUsedBike.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		request.setAttribute("bikeId", bikeId);
		request.setAttribute("bikeNumber", bikeNumber);
		rd.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
