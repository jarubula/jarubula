package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

/**
 * Servlet implementation class GetBusinessOwners
 */
public class GetBusinessOwners extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBusinessOwners() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key=request.getParameter("k");
		String status=null,returnstring=null;
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		String pagename=null,bcity=null,bname=null;
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		BusinessOwnerRegister bo=new BusinessOwnerRegister();
		BusinessOwnerRegisterDao bodao=new BusinessOwnerRegisterDaoImpl();
		boolean b=false;
		System.out.println(key);
		try
		{
			bo.setUSER_TYPE(key);
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(key.equals("SC"))
			{
				pagename="./ServiceMechanicDetailsAct.jsp";
			}
			else
			if(key.equals("SP"))
			{
				pagename="./SparePartsShopAct.jsp";
			}
			else
			if(key.equals("UD"))
			{
				pagename="./UsedVehicleDealerAct.jsp";
			}
			if(request.getParameter("status")!=null)
        	{
        		status=request.getParameter("status");
        		bo.setSTATUS(status);
        		bo.setSEQUENTIAL_NO(Integer.parseInt(request.getParameter("sequenceid")));
        		b=bodao.businessOwnerActina(bo);
        		if(b)
        		{
        			returnstring="Request Processed...";
        		}
        		else
        		{
        			returnstring="Request Process Failed. Please Try Again..";
        		}	
        	}
			if(request.getParameter("bcity")!="SELECT CITY" || request.getParameter("bcity")!=null)
			{
				bcity=request.getParameter("bcity");
				bo.setB_CITY(bcity);
				if(request.getParameter("bname")!="SELECT BUSINESS NAME" || request.getParameter("bname")!=null)
				{
					bname=request.getParameter("bname");
					bo.setBUSINESS_NAME(bname);
				}
			}
			al=bodao.getInactiveOwnerDetails(bo,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=bodao.getNoOfRecords();
			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			
		request.setAttribute("businessOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("returnstring", returnstring);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(pagename);
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
