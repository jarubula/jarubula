package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.utilities.VerifyFieldsUtil;

/**
 * Servlet implementation class AddBusinessOwner
 */
public class AddBusinessOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBusinessOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg=null, page=null,key=null;
		BusinessOwnerRegister bregistration = new BusinessOwnerRegister();
		key=request.getParameter("usertype");
		if(key.equals("SERVICEMECHANIC"))
		{
			page = "./AdAddServiceMechanic.jsp";
			bregistration.setUSER_TYPE("SC");
		}
		else
		if(key.equals("SPAREPARTSSHOP"))
		{
			page = "./AdAddSparePartsShop.jsp";
			bregistration.setUSER_TYPE("SP");
		}
		else
		if(key.equals("USEDVEHICLEDEALER"))
		{
			page = "./AdAddDealer.jsp";
			bregistration.setUSER_TYPE("UD");
		}
		
		UserLogin login = new UserLogin();
		String usertype=null;
		
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		VerifyFieldsUtil vf=new VerifyFieldsUtil();
		String pancardno=null;
		try {
			
				pancardno=vf.verifyInt(request.getParameter("pancardNo"));
			
				bregistration.setUSER_TYPE(usertype);
				bregistration.setBUSINESS_NAME(vf.verifyString(request.getParameter("businessName")));
				bregistration.setPANCARD_NO(pancardno);
				bregistration.setADDRESS(vf.verifyString(request.getParameter("address")));
				bregistration.setB_CITY(vf.verifyString(request.getParameter("bcity")));
				bregistration.setSTATE(vf.verifyString(request.getParameter("state")));
				bregistration.setDISTRICT(vf.verifyString(request.getParameter("district")));
				bregistration.setOFFICE_PHONE_NO(vf.verifyString(request.getParameter("phoneNo")));
				bregistration.setOFFICE_PINCODE_NO(Integer.parseInt(vf.verifyInt(request.getParameter("bpinNo"))));
				
				String vehicles="";
				String vehicleType[]=request.getParameterValues("vehicletype");
				for(int i=0;i<vehicleType.length;i++){
					vehicles+=vehicleType[i]+",";
				}
				bregistration.setVEHICLE_TYPE(vehicles);
				bregistration.setNAME(vf.verifyString(request.getParameter("name")));
				bregistration.setMOBILE_NO(vf.verifyString(request.getParameter("mobileNo")));
				bregistration.setCITY(vf.verifyString(request.getParameter("city")));
				bregistration.setPINCODE_NO(Integer.parseInt(vf.verifyInt(request.getParameter("pinNo"))));
				bregistration.setEMAIL_ID(vf.verifyString(request.getParameter("emailid")));
				bregistration.setPASSWORD(vf.verifyString(request.getParameter("password")));
				bregistration.setSTATUS("INACTIVE");
				bregistration.toString();

				/*login.setEMAIL_ID(request.getParameter("email"));
				login.setPASSWORD(request.getParameter("password"));
				login.setUSER_TYPE(request.getParameter("usertype"));
				login.setSTATUS("INACTIVE");*/
				msg = dao.addBusinessOwner(bregistration, login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("message", msg);
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
