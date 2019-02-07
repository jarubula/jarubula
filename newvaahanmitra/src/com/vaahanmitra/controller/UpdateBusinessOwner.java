package com.vaahanmitra.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class UpdateBusinessOwner
 */
@javax.servlet.annotation.MultipartConfig
public class UpdateBusinessOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBusinessOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BusinessOwnerRegister bo=new BusinessOwnerRegister();
		bo.setSEQUENTIAL_NO(Integer.parseInt(request.getParameter("boid")));
		bo.setBUSINESS_NAME(request.getParameter("businessName"));
		bo.setPANCARD_NO(request.getParameter("pancardNo"));
		bo.setVEHICLE_TYPE(request.getParameter("vehicletype"));
		bo.setADDRESS(request.getParameter("address"));
		bo.setB_CITY(request.getParameter("bcity"));
		bo.setSTATE(request.getParameter("state"));
		bo.setDISTRICT(request.getParameter("district"));
		bo.setOFFICE_PINCODE_NO(Integer.parseInt(request.getParameter("bpinNo")));
		bo.setOFFICE_PHONE_NO(request.getParameter("phoneNo"));
		bo.setNAME(request.getParameter("name"));
		bo.setMOBILE_NO(request.getParameter("mobileNo"));
		bo.setCITY(request.getParameter("city"));
		bo.setPINCODE_NO(Integer.parseInt(request.getParameter("pinNo")));
		bo.setEMAIL_ID(request.getParameter("email"));
		bo.setVERIFIED(request.getParameter("verified"));
		InputStream is = null;
		String pic = request.getParameter("image");
		Part pic1=request.getPart("photo");
		  if(pic1.getSize()>0){
		   
			  is = pic1.getInputStream(); 
		  System.out.println("ssss"+is);
		  
		  }else{
		   
		      BASE64Decoder decoder = new BASE64Decoder();
		      byte[] decodedBytes = decoder.decodeBuffer(pic);
		      is = new ByteArrayInputStream(decodedBytes);
		  }
		  BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
			String message = dao.updateProfile(bo,is);
				message = "UPDATED SUCCESSFULLY...";
				request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("./AdUpdateBusinessOwnerMess.jsp");
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
