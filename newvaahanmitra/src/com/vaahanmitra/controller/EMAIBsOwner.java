package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.SpareParts;
import com.vaahanmitra.utilities.VerifyFieldsUtil;

/**
 * Servlet implementation class EMAIBsOwner
 */
public class EMAIBsOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EMAIBsOwner() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		String pagename=null, msgColor=null,user=null;
		String userType = request.getParameter("userType");
		
		if (userType.equals("UD")) {
			user = "Dealer";
		} else if (userType.equals("SC")) {
			user = "Service Center";
		} else if (userType.equals("SP")) {
			user = "Spare Parts Shop";
		}
		
		String status = request.getParameter("status");
		String emailId = request.getParameter("emailId");
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		
		String message = dao.setStatus(emailId, status, user_name);

		if(message.equals("success") && status.equals("ACTIVE")){
			message = ""+user+" Inactivated";
			msgColor = "red";
		}else if(message.equals("success") && status.equals("INACTIVE")){
			message = ""+user+" Activated";
			msgColor = "green";
		}else if(message.equals("failure")){
			message = "Please try agin!";
		}
		
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		BusinessOwnerRegister bo = new BusinessOwnerRegister();
		bo.setSTATE(new VerifyFieldsUtil().verifyString(request.getParameter("country1")));
		bo.setDISTRICT(new VerifyFieldsUtil().verifyString(request.getParameter("state1")));
		bo.setVEHICLE_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("vehicletype")));
		bo.setMOBILE_NO(new VerifyFieldsUtil().verifyString(request.getParameter("mobile")));
		bo.setEMAIL_ID(new VerifyFieldsUtil().verifyString(request.getParameter("mailid")));
		bo.setUSER_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("userType")));
		
		try
		{
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(userType.equals("SC"))
			{
				pagename="./emSearchSCOwner.jsp";
			}
			else
			if(userType.equals("SP"))
			{
				pagename="./emSearchSPOwner.jsp";
			}
			else
			if(userType.equals("UD"))
			{
				pagename="./emSearchUDOwner.jsp";
			}
			
			al=dao.getOwnerDetails(bo,user_name,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=dao.getNoOfRecords();

			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
		request.setAttribute("BusinessOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		request.setAttribute("currentPage", page);
		request.setAttribute("message", message);
		request.setAttribute("msgColor", msgColor);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
