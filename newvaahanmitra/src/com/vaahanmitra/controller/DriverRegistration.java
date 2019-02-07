package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;

/**
 * Servlet implementation class DriverRegistration
 */
@javax.servlet.annotation.MultipartConfig
public class DriverRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverRegistration() {
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
		String email=request.getParameter("emailid");
		driver.setEMAIL(email);
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
		driver.setJOB_TYPE(request.getParameter("jobType"));
		
		Part doc=request.getPart("doc");
		Part pic=request.getPart("pic");
		
		driver.setPASSWORD(request.getParameter("psw"));
		driver.setUSERTYPE(request.getParameter("driver"));

		InputStream inputStream = null;
		InputStream inputStream1 = null;
		if(doc!=null && pic!=null){
			inputStream = doc.getInputStream();
			inputStream1 = pic.getInputStream();
		}
		DriverDAO sdao=new DriverDAOImpl();
		boolean existEmail = sdao.getEmail(email);
		String message1="Registered Successfully,Please Login Here..";
		String message="Emaild already registered ";
		String message2=null;
		RequestDispatcher rd=null;
		if(existEmail == false){
			message2=sdao.insertDriverDetails(driver,inputStream,inputStream1);
			if(message2!=null){
			rd=request.getRequestDispatcher("./login3.jsp");
			request.setAttribute("existemail", message1);
			rd.forward(request, response);
			}
		}else{
			rd=request.getRequestDispatcher("./driverRegistration.jsp");
			request.setAttribute("existemail", message);
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
