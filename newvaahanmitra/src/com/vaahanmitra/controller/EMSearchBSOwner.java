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
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.utilities.VerifyFieldsUtil;

public class EMSearchBSOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EMSearchBSOwner() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("k");
		String pagename=null;
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		BusinessOwnerRegister bo=new BusinessOwnerRegister();
		
		bo.setSTATE(new VerifyFieldsUtil().verifyString(request.getParameter("country1")));
		bo.setDISTRICT(new VerifyFieldsUtil().verifyString(request.getParameter("state1")));
		bo.setVEHICLE_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("vehicletype")));
		bo.setMOBILE_NO(new VerifyFieldsUtil().verifyString(request.getParameter("mobile")));
		bo.setEMAIL_ID(new VerifyFieldsUtil().verifyString(request.getParameter("mailid")));
		bo.setUSER_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("k")));
		BusinessOwnerRegisterDao bodao=new BusinessOwnerRegisterDaoImpl();

		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		try
		{
			bo.setUSER_TYPE(key);
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(key.equals("SC"))
			{
				pagename="./emSearchSCOwner.jsp";
			}
			else
			if(key.equals("SP"))
			{
				pagename="./emSearchSPOwner.jsp";
			}
			else
			if(key.equals("UD"))
			{
				pagename="./emSearchUDOwner.jsp";
			}
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			al=bodao.getOwnerDetails(bo,user_name,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=bodao.getNoOfRecords();

			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			System.out.println("hairsj"+al);
		request.setAttribute("BusinessOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		request.setAttribute("currentPage", page);
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
