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

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.SendMail;

@javax.servlet.annotation.MultipartConfig
public class AddDealerUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part photo1 = null, photo2=null;
		String page = null,emailId=null,ownerName=null,mobileNo=null;
		String VMEmailId = "info@vaahanmitra.com";
		String noOfOwners = null;
		UsedBike usedBike = new UsedBike();
		usedBike.setBIKE_NUMBER(request.getParameter("bikeNumber").toUpperCase());
		usedBike.setBIKE_BRAND(request.getParameter("bikeBrand").toUpperCase());
		usedBike.setBIKE_MODEL(request.getParameter("bikeModel").toUpperCase());
		usedBike.setVARIANT_NAME(request.getParameter("variantName"));
		usedBike.setSTARTING_SYSTEM(request.getParameter("startingSystem"));
		usedBike.setFUELTANK_CAPACITY(request.getParameter("fueltankCapacity"));
		usedBike.setCOLOR(request.getParameter("color").toUpperCase());
		usedBike.setREGISTERED_YEAR(request.getParameter("year"));

		String currentMileage = request.getParameter("currentMileage");
		String companyName =  request.getParameter("companyName");
		String kmsDriven = request.getParameter("kmsDriven");
		String loanCompanyName = request.getParameter("loanCompanyName");
		String tstate = request.getParameter("tstate");
		String tcity = request.getParameter("tcity");
		
		if(currentMileage == null || companyName == null || kmsDriven == null || loanCompanyName == null || tstate == null || tcity==null){
			usedBike.setCURRENT_MILEAGE("");
			usedBike.setINSURANCE_COMPANY_NAME("");
			usedBike.setKMS_DRIVEN("");
			usedBike.setHYPOTHECATION("");
			usedBike.setREGISTERED_STATE("");
			usedBike.setREGISTERED_CITY("");
		}else{
			usedBike.setCURRENT_MILEAGE(request.getParameter("currentMileage"));
			usedBike.setINSURANCE_COMPANY_NAME(request.getParameter("companyName").toUpperCase());
			usedBike.setKMS_DRIVEN(request.getParameter("kmsDriven"));
			usedBike.setHYPOTHECATION(request.getParameter("loanCompanyName").toUpperCase());
			usedBike.setREGISTERED_STATE(request.getParameter("tstate").toUpperCase());
			usedBike.setREGISTERED_CITY(request.getParameter("tcity").toUpperCase());
		}
		
		String address = request.getParameter("contactAddress");
		if (address.equals("red")) {
			ownerName = request.getParameter("ownerName").toUpperCase();
			usedBike.setUSED_BY(request.getParameter("usedBy").toUpperCase());
			noOfOwners = request.getParameter("noOfOwners");
			if(noOfOwners.equals("")){
				usedBike.setNO_OF_OWNERS(0);
			}else{
				usedBike.setNO_OF_OWNERS(Integer.parseInt(noOfOwners));
			}
			emailId = request.getParameter("emailId");
			mobileNo = request.getParameter("mobileNo");
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
			photo1 = request.getPart("photo1");
		} else {
			ownerName = request.getParameter("ownerName1").toUpperCase();
			usedBike.setUSED_BY(request.getParameter("usedBy1").toUpperCase());
			noOfOwners = request.getParameter("noOfOwners1");
			if(noOfOwners.equals("")){
				usedBike.setNO_OF_OWNERS(0);
			}else{
				usedBike.setNO_OF_OWNERS(Integer.parseInt(noOfOwners));
			}
			emailId = request.getParameter("emailId1");
			mobileNo = request.getParameter("mobileNo1");
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
			photo2 = request.getPart("photo2");
		}
		usedBike.setEMAIL_ID(emailId);
		usedBike.setMOBILE_NO(mobileNo);
		usedBike.setBIKE_OWNER_NAME(ownerName);
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

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
		String bikeNumber = request.getParameter("bikeNumber");
		UsedBikeDao dao = new UsedBikeDaoImpl();
		Boolean bikeNo = dao.getBikeNumber(bikeNumber);
		String message = null;
		if (bikeNo == true) {
			message = "Bike number already available with Us!";
			page = "./addUDUsedBike.jsp";
		} else {
			HashMap<String,String> msge = dao.addDelaerUsedBike(usedBike,is,al,user_name);
			String msg = msge.get("message");
			String bikeId = msge.get("bikeId");
			if (msg.equals("success")) {
				message = "BIKE ADDED SUCCESSFULLY...";
				String url = "http://localhost:8080/Vaahanmitra1.0/showBikeDetails.jsp?bid="+bikeId+"";
				String toMsg = "Your Bike added in Vaahanmitra.Thank you for using. Your Bike id= <a href='" + url + "'> (" + bikeId + ") </a>";
				String fromMsg = "One Bike added to VaahanMitra  <a href='" + url + "'> (" + bikeId + ") </a> <br>" + "Owner Name :"
						+ ownerName + " <br>" + "Mobile No   :" + mobileNo+ " <br>" + "Email Id    :"
						+ emailId + "";
				SendMail.sendMail(emailId, VMEmailId, toMsg, fromMsg);
				page = "./successUDUsedBike.jsp";
			}else{
				message = "Bike not added! Please Try again!";
				page = "./addUDUsedBike.jsp";
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
