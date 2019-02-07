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

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class IndividualUsedBikeController
 */
@javax.servlet.annotation.MultipartConfig
public class IndividualUsedBikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualUsedBikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsedBike usedBike = new UsedBike();
		usedBike.setBIKE_NUMBER(request.getParameter("bikeNumber").toUpperCase());
		usedBike.setBIKE_BRAND(request.getParameter("bikeBrand").toUpperCase());
		usedBike.setBIKE_MODEL(request.getParameter("bikeModel").toUpperCase());
		usedBike.setCURRENT_MILEAGE(request.getParameter("currentMileage"));
		usedBike.setSTARTING_SYSTEM(request.getParameter("startingSystem"));
		usedBike.setFUELTANK_CAPACITY(request.getParameter("fueltankCapacity"));
		usedBike.setCOLOR(request.getParameter("color").toUpperCase());
		usedBike.setINSURANCE_COMPANY_NAME(request.getParameter("companyName").toUpperCase());
		usedBike.setKMS_DRIVEN(request.getParameter("kmsDriven"));
		Part photo = request.getPart("photo");
		usedBike.setHYPOTHECATION(request.getParameter("loanCompanyName").toUpperCase());
		usedBike.setREGISTERED_YEAR(request.getParameter("year"));
		usedBike.setREGISTERED_STATE(request.getParameter("tstate").toUpperCase());
		usedBike.setREGISTERED_CITY(request.getParameter("tcity").toUpperCase());

		String address = request.getParameter("contactAddress");
		System.out.println("ADDRESS" + address);
		if (address.equals("red")) {
			usedBike.setBIKE_OWNER_NAME(request.getParameter("ownerName").toUpperCase());
			usedBike.setUSED_BY(request.getParameter("usedBy").toUpperCase());
			usedBike.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners")));
			usedBike.setEMAIL_ID(request.getParameter("emailId"));
			usedBike.setMOBILE_NO(request.getParameter("mobileNo"));
			usedBike.setADDRESS(request.getParameter("address").toUpperCase());
			usedBike.setCITY(request.getParameter("city").toUpperCase());
			usedBike.setSTATE(request.getParameter("country2").toUpperCase());
			usedBike.setDISTRICT(request.getParameter("state").toUpperCase());
			usedBike.setPINCODE(request.getParameter("pincode"));
			usedBike.setOFFER_PRICE(request.getParameter("price"));
			String description = request.getParameter("bikeDescription");
			if(description == null){
				usedBike.setBIKE_DISCRIPTION(description);
			}else{
				usedBike.setBIKE_DISCRIPTION(description);
			}
			
		} else {
			usedBike.setBIKE_OWNER_NAME(request.getParameter("ownerName1").toUpperCase());
			usedBike.setUSED_BY(request.getParameter("usedBy1").toUpperCase());
			usedBike.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners1")));
			usedBike.setEMAIL_ID(request.getParameter("emailId1"));
			usedBike.setMOBILE_NO(request.getParameter("mobileNo1"));
			usedBike.setADDRESS(request.getParameter("address1").toUpperCase());
			usedBike.setCITY(request.getParameter("city1").toUpperCase());
			usedBike.setSTATE(request.getParameter("country1").toUpperCase());
			usedBike.setDISTRICT(request.getParameter("state1").toUpperCase());
			usedBike.setPINCODE(request.getParameter("pincode1"));
			usedBike.setOFFER_PRICE(request.getParameter("price1"));
			String description = request.getParameter("bikeDescription1");
			
			if(description == null){
				usedBike.setBIKE_DISCRIPTION(description);
			}else{
				usedBike.setBIKE_DISCRIPTION(description);
			}
		}
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		InputStream is = null;
		System.out.println(request.getParameter("counter"));
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
		}
		String page=null;
		String bikeNumber = request.getParameter("bikeNumber");
		UsedBikeDao dao = new UsedBikeDaoImpl();
		Boolean bikeNo = dao.getBikeNumber(bikeNumber);
		String message = null;
		if (bikeNo == true) {
			message = "Bike number already available with Us!";
			page = "./individualUsedBike.jsp";
		} else {
			String msge = dao.addUsedBike(usedBike, is, al, user_name);
			if (msge.equals("success")) {
				message = "BIKE ADDED SUCCESSFULLY...";
				page = "./successIndividualUsedBike.jsp";
			} else {
				message = "Bike not added! Please Try again!";
				page = "./individualUsedBike.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
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
