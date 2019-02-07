package com.vaahanmitra.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

import Decoder.BASE64Decoder;

@javax.servlet.annotation.MultipartConfig
public class UpdateServiceCenterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String page=null;
		BusinessOwnerRegister registration = new BusinessOwnerRegister();
		
		
//		String vehicles="";
//		String vehicleType[]=request.getParameterValues("vehicleType");
//		for(int i=0;i<vehicleType.length;i++){
//			vehicles+=vehicleType[i]+" , ";
//		}
//		registration.setVEHICAL_TYPE(vehicles);
//		registration.setEMAIL_ID(request.getParameter("emailId"));
		registration.setPANCARD_NO(request.getParameter("panno").toUpperCase());
		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("phoneNo"));
		registration.setCITY(request.getParameter("city"));
		registration.setPINCODE_NO(Integer.parseInt(request.getParameter("pinNo")));
		registration.setBUSINESS_NAME(request.getParameter("bName").toUpperCase());
		registration.setADDRESS(request.getParameter("businessAddress"));
		registration.setB_CITY(request.getParameter("bcity"));
		registration.setSTATE(request.getParameter("state1"));
		registration.setDISTRICT(request.getParameter("district1"));
		registration.setOFFICE_PHONE_NO(request.getParameter("bPhoneNo"));
		registration.setOFFICE_PINCODE_NO(Integer.parseInt(request.getParameter("bpincodeNo")));
		
		InputStream is = null;
		String pic = request.getParameter("image");	
		Part pic1=request.getPart("photo");
		  if(pic1.getSize()>0){
		   
			  is = pic1.getInputStream(); 
		  }else{
		   
		      BASE64Decoder decoder = new BASE64Decoder();
		      byte[] decodedBytes = decoder.decodeBuffer(pic);
		      is = new ByteArrayInputStream(decodedBytes);
		  }
		
		HttpSession session1 = request.getSession(false);
		String user_name = (String) session1.getAttribute("user");
		
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		String message = dao.updateProfile(user_name,registration,is);

		if(message.equals("success"))
		{
			message = "YOUR PROFILE UPDATED SUCCESSFULLY...";
			page= "./addServiceMechanic.jsp";
		} else {
			message = "PROFILE NOT UPDATED! PLEASE TRY AGAIN!";
			page ="./addServiceMechanic.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		rd.forward(request, response);
	}
}
