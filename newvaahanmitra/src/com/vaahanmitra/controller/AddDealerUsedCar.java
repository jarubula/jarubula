package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.vaahanmitra.service.SendMail;

@javax.servlet.annotation.MultipartConfig
public class AddDealerUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part photo1 = null, photo2=null;
		String page = null,emailId=null,ownerName=null,mobileNo=null;
		String VMEmailId = "info@vaahanmitra.com";
		String noOfOwners = null;
		UsedCar usedCar = new UsedCar();
		usedCar.setCAR_NUMBER(request.getParameter("carNumber").toUpperCase());
		usedCar.setCAR_BRAND(request.getParameter("brandid").toUpperCase());
		usedCar.setCAR_MODEL(request.getParameter("carModel").toUpperCase());
		usedCar.setVARIANT_NAME(request.getParameter("variantName"));
		usedCar.setCURRENT_MILEAGE(request.getParameter("currentMileage"));
		usedCar.setMODEL_YEAR(request.getParameter("year1"));
		usedCar.setFUEL_TYPE(request.getParameter("fuelType"));
		usedCar.setBODY_TYPE(request.getParameter("bodyType"));
		usedCar.setTRANSIMISSION(request.getParameter("transmission"));
		usedCar.setKMS_DRIVEN(request.getParameter("KMsDriven"));
		usedCar.setCOLOR(request.getParameter("color").toUpperCase());
		
		String insurance = request.getParameter("companyName");
		String cetrifiedCompanyName = request.getParameter("cetifiedCompanyName");
		if(insurance==null || cetrifiedCompanyName == null)
		{
			usedCar.setINSURANCE(request.getParameter("companyName").toUpperCase());
			usedCar.setCERTIFIED_COMPANY_NAME(request.getParameter("cetifiedCompanyName").toUpperCase());
		}else{
			usedCar.setINSURANCE(request.getParameter("companyName").toUpperCase());
			usedCar.setCERTIFIED_COMPANY_NAME(request.getParameter("cetifiedCompanyName").toUpperCase());
		}
		usedCar.setREGISTERED_YEAR(request.getParameter("year"));
		usedCar.setREGISTERED_STATE(request.getParameter("tstate").toUpperCase());
		
		String rCity = request.getParameter("tcity");
		if(rCity == null || rCity.equals("null")){
			usedCar.setREGISTERED_CITY(" ");
		}else{
			usedCar.setREGISTERED_CITY(rCity.toUpperCase());
		}
		String address = request.getParameter("contactAddress");
		if(address.equals("red"))
		{
			ownerName = request.getParameter("ownerName");
//			usedCar.setCAR_OWNER_NAME(request.getParameter("ownerName"));
			usedCar.setUSED_BY(request.getParameter("usedBy"));
			noOfOwners = request.getParameter("noOfOwners");
			if(noOfOwners.equals("")){
				usedCar.setNO_OF_OWNERS(0);
			}else{
				usedCar.setNO_OF_OWNERS(Integer.parseInt(noOfOwners));
			}
//			usedCar.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners")));
			emailId = request.getParameter("emailId");
			mobileNo = request.getParameter("mobileNo");
			usedCar.setADDRESS(request.getParameter("address").toUpperCase());
			usedCar.setCITY(request.getParameter("city").toUpperCase());
			usedCar.setSTATE(request.getParameter("country2").toUpperCase());
			usedCar.setDISTRICT(request.getParameter("state").toUpperCase());
			usedCar.setPINCODE(request.getParameter("pincode"));
			usedCar.setOFFER_PRICE(request.getParameter("price"));
			photo1 = request.getPart("photo1");
		}
		else{
			ownerName = request.getParameter("ownerName1");
			usedCar.setUSED_BY(request.getParameter("usedBy1"));
			noOfOwners = request.getParameter("noOfOwners1");
			if(noOfOwners.equals("")){
				usedCar.setNO_OF_OWNERS(0);
			}else{
				usedCar.setNO_OF_OWNERS(Integer.parseInt(noOfOwners));
			}
//			usedCar.setNO_OF_OWNERS(Integer.parseInt(request.getParameter("noOfOwners1")));
			emailId = request.getParameter("emailId1");
			mobileNo = request.getParameter("mobileNo1");
			
			usedCar.setADDRESS(request.getParameter("address1").toUpperCase());
			usedCar.setCITY(request.getParameter("city1").toUpperCase());
			usedCar.setSTATE(request.getParameter("country1").toUpperCase());
			usedCar.setDISTRICT(request.getParameter("state1").toUpperCase());
			usedCar.setPINCODE(request.getParameter("pincode1"));
			usedCar.setOFFER_PRICE(request.getParameter("price1"));
			photo2 = request.getPart("photo2");
		}
		usedCar.setEMAIL_ID(emailId);
		usedCar.setMOBILE_NO(mobileNo);
		usedCar.setCAR_OWNER_NAME(ownerName);
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		InputStream is = null;
		ArrayList<InputStream> al = new ArrayList<InputStream>();

		if(photo1!=null)
		{
	    	is = photo1.getInputStream();
	    	al.add(is);
		}if(photo2!=null)
		{
	    	is = photo2.getInputStream();
	    	al.add(is);
		}
		String carNumber = request.getParameter("carNumber");
		UsedCarDao dao = new UsedCarDaoImpl();
		Boolean carNo = dao.getCarNumber(carNumber);
		String message = null;
		if (carNo == true) {
			message = "Car number already available with Us!";
			page = "./addUDUsedCar.jsp";
		} else {
			HashMap<String,String> msge = dao.addDelaerUsedCar(usedCar, is, al, user_name);
			String msg = msge.get("message");
			String carId = msge.get("carId");
			if (msg.equals("success")) {
				message = "CAR ADDED SUCCESSFULLY...";
				String url = "http://localhost:8080/Vaahanmitra1.0/showCarDetails.jsp?cid="+carId+"";
				String toMsg = "your car added in Vaahanmitra.Thank you for using. Your car id= <a href='" + url + "'> (" + carId + ") </a>";
				String fromMsg = "One Car added to VaahanMitra  <a href='" + url + "'> (" + carId + ") </a> <br>" + "Owner Name :"
						+ ownerName + " <br>" + "Mobile No   :" + mobileNo+ " <br>" + "Email Id    :"
						+ emailId + "";
				SendMail.sendMail(emailId, VMEmailId, toMsg, fromMsg);
				page = "./successUDUsedCar.jsp";
			}else{
				message = "Car not added! Please Try again!";
				page = "./addUDUsedCar.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
