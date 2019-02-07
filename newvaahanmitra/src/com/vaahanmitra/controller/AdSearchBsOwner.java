package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.utilities.VerifyFieldsUtil;

/**
 * Servlet implementation class AdSearchBsOwner
 */
public class AdSearchBsOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdSearchBsOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key=request.getParameter("k");
		String brandDealer = request.getParameter("j");
		String pagename=null;
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		BusinessOwnerRegister bo=new BusinessOwnerRegister();
		bo.setSTATE(new VerifyFieldsUtil().verifyString(request.getParameter("tstate")));
		bo.setCITY(new VerifyFieldsUtil().verifyString(request.getParameter("tcity")));
		bo.setVEHICLE_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("vehicletype")));
		bo.setMOBILE_NO(new VerifyFieldsUtil().verifyString(request.getParameter("mobile")));
		bo.setEMAIL_ID(new VerifyFieldsUtil().verifyString(request.getParameter("mailid")));
		BusinessOwnerRegisterDao bodao=new BusinessOwnerRegisterDaoImpl();
		try
		{
			bo.setUSER_TYPE(key);
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(key.equals("SC"))
			{
				pagename="./AdSearchSCOwner.jsp";
			}
			else
			if(key.equals("SP"))
			{
				pagename="./AdSearchSPOwner.jsp";
			}
			else
			if(key.equals("UD"))
			{
				if(brandDealer.equals("UDB")){
					pagename="./AdSearchUdOwnerBrand.jsp";
				}else{
					pagename="./AdSearchUdOwner.jsp";
				}
			}
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			al=bodao.getOwnerDetails(bo,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=bodao.getNoOfRecords();

			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
		request.setAttribute("BusinessOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
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
