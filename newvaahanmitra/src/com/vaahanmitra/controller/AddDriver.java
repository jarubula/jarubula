package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;

/**
 * Servlet implementation class AddDriver
 */
public class AddDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DriverBean driver=new DriverBean();
		driver.setFIRST_NAME(request.getParameter("fname"));
		driver.setLAST_NAME(request.getParameter("lname"));
		driver.setEMAIL(request.getParameter("emailid"));
		driver.setMOBILE_NO(request.getParameter("mobileNo"));
		driver.setDOB(request.getParameter("date1"));
		driver.setADDRESS(request.getParameter("address"));
		driver.setSTREET(request.getParameter("street"));
		driver.setCITY(request.getParameter("city"));
		driver.setSTATE(request.getParameter("country"));
		driver.setDISTRICT(request.getParameter("state"));
		driver.setMANDAL(request.getParameter("mandal"));
		driver.setREGISTERED_STATE(request.getParameter("state1"));
		driver.setLICENSE_NO(request.getParameter("licenseNo"));
		driver.setLICENSE_TYPE(request.getParameter("licenseType"));
		driver.setEXPIRY_DATE(request.getParameter("date2"));
		driver.setDRIVING_EXP(request.getParameter("exp"));
		driver.setPERMIT_TYPE(request.getParameter("permitType"));
		driver.setWITHIN_RANGE(request.getParameter("range"));
		driver.setADHAR_NO(request.getParameter("adharNo"));
		driver.setPAN_NO(request.getParameter("panNo"));
		//driver.setLICENSE_DOC(request.getParameter("doc"));
		//driver.setPHOTO(request.getParameter("pic"));
		Part doc=request.getPart("doc");
		Part pic=request.getPart("pic");		
		HttpSession driverSession= request.getSession(false);
		String userId=(String)driverSession.getAttribute("userId");
		driver.setM_USER_ID(userId);
		
		InputStream inputStream = null;
		InputStream inputStream1 = null;
		if(doc!=null && pic!=null){
			inputStream = doc.getInputStream();
			inputStream1 = pic.getInputStream();
		}
		DriverDAO sdao=new DriverDAOImpl();
		String message=null;
		try{
		message=sdao.insertDriverDetails(driver,inputStream,inputStream1);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./driverMessage.jsp");
			request.setAttribute("message", message);
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
