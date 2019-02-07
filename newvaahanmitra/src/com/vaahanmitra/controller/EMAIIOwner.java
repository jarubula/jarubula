package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.utilities.VerifyFieldsUtil;

public class EMAIIOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		String msgColor = null;
		String key = request.getParameter("userType");
		
		String status = request.getParameter("status");
		String emailId = request.getParameter("emailId");
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		
		String message = dao.setStatus(emailId, status, user_name);
		if(message.equals("success") && status.equals("ACTIVE")){
			message = "Inactivated";
			msgColor = "red";
		}else if(message.equals("success") && status.equals("INACTIVE")){
			message = "Activated";
			msgColor = "green";
		}else if(message.equals("failure")){
			message = "Please try agin!";
		}
		
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		IndividualOwnerRegister io=new IndividualOwnerRegister();
		io.setCITY(new VerifyFieldsUtil().verifyString(request.getParameter("city")));
		io.setVEHICAL_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("vehicletype")));
		System.out.println(request.getParameter("vehicletype"));
		io.setMOBILE_NO(new VerifyFieldsUtil().verifyString(request.getParameter("mobile")));
		io.setEMAIL_ID(new VerifyFieldsUtil().verifyString(request.getParameter("mailid")));
		io.setUSER_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("k")));

		try
		{
			io.setUSER_TYPE(key);
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			al = dao.getOwnerDetails(io,user_name,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords = dao.getNoOfRecords();

			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			System.out.println("hairsj"+al);
		request.setAttribute("individualOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		request.setAttribute("currentPage", page);
		request.setAttribute("msgColor", msgColor);
		request.setAttribute("message", message);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("./emSearchIOwner.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
