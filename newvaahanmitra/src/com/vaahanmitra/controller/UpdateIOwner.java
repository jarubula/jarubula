package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;

public class UpdateIOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateIOwner() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		registration.setPANCARD_NO(request.getParameter("pancard"));
		registration.setCITY(request.getParameter("city"));
		registration.setPINCODE_NO(request.getParameter("pincode"));
		registration.setSEQUENTIAL_NO(Integer.parseInt(request.getParameter("sid")));
		String vehicles="";
		String vehicleType[]=request.getParameterValues("vehicleType");
		if(vehicleType!=null){
			for(int i=0;i<vehicleType.length;i++){
				vehicles+=vehicleType[i]+",";
				registration.setVEHICAL_TYPE(vehicles);
			}
		}else{
			registration.setVEHICAL_TYPE(vehicles);
		}
		
		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("mobileNo"));
		registration.setEMAIL_ID(request.getParameter("email"));
		/*registration.setPASSWORD(request.getParameter("password"));*/
//		registration.setSTATUS("INACTIVE");

		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
			String message = dao.updateProfile(registration);
				message = "UPDATED SUCCESSFULLY...";
				request.setAttribute("message", message);
				request.setAttribute("id", registration.getEMAIL_ID());
			RequestDispatcher rd = request.getRequestDispatcher("./emUpdateIOwner.jsp");
			rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
