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
 * Servlet implementation class SearchBusinessOwners
 */
public class SearchBusinessOwners extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBusinessOwners() {
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
	//	System.out.println(key);
		try
		{
			bo.setUSER_TYPE(key);
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
				pagename="";
				if(key.equals("SC"))
				{
					pagename="./SearchServiceMechanicDetails.jsp";
				}
				else
				if(key.equals("SP"))
				{
					pagename="./SearchSparePartsShop.jsp";
				}
				else
				if(key.equals("UD"))
				{
					pagename="./SearchUsedVehicleDealer.jsp";
				}
			
			if(request.getParameter("bcity").equals("City") || request.getParameter("bcity").equals("All"))
			{}
			else
			{
				bo.setB_CITY(request.getParameter("bcity"));
			}
			if(request.getParameter("vehicletype").equals("Vehicle Type") || request.getParameter("vehicletype").equals("All"))
			{}
			else
			{
				bo.setVEHICLE_TYPE(request.getParameter("vehicletype"));
			}	
			if(request.getParameter("bname").equals("Business Name"))
			{}
			else
			{
				bo.setBUSINESS_NAME(request.getParameter("bname"));
			}	
			
			al=bodao.searchBusinessOwner(bo,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=bodao.getNoOfRecords();
			System.out.println("No of Recordds :: "+noofRecords);
			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			System.out.println(al);
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
