package com.vaahanmitra.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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

import Decoder.BASE64Decoder;

/**
 * Servlet implementation class UpdateDriverProfile
 */
@javax.servlet.annotation.MultipartConfig
public class UpdateDriverProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDriverProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DriverBean driver=new DriverBean();
		String fname=request.getParameter("fname");
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
		driver.setLICENSE_DOC(request.getParameter("doc"));
		String pic=request.getParameter("photo");
		driver.setJOB_TYPE(request.getParameter("jobType"));
		
		InputStream inputStream = null;
		if(fname!=null){
			Part pic1=request.getPart("pic");
		if(pic1.getSize()>0){
			
		inputStream = pic1.getInputStream();	
		
		}else{
			
		    BASE64Decoder decoder = new BASE64Decoder();
		    byte[] decodedBytes = decoder.decodeBuffer(pic);
			inputStream = new ByteArrayInputStream(decodedBytes);
		}
		}
		HttpSession session=request.getSession(false);
		String userId=(String)session.getAttribute("user");
		driver.setM_USER_ID(userId);
		
		
		DriverDAO sdao=new DriverDAOImpl();
		ArrayList<DriverBean> driverDtl=null;
		RequestDispatcher rd=null;
		if(fname==null){
			
	    driverDtl=sdao.viewDriverProfile(userId);
		rd=request.getRequestDispatcher("./updateDriverProfile.jsp");
		request.setAttribute("driverDtl", driverDtl);
		rd.forward(request, response);
		
		}else if(fname!=null){
			sdao.updateDriverProfile1(driver,inputStream);
			driverDtl=sdao.viewDriverProfile(userId);
			rd=request.getRequestDispatcher("./updateDriverProfile.jsp");
			request.setAttribute("driverDtl", driverDtl);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
