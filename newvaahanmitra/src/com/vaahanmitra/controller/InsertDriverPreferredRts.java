package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.InsertDriverPreRtsAndSal;

/**
 * Servlet implementation class InsertDriverPreferredRts
 */
public class InsertDriverPreferredRts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDriverPreferredRts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		HttpSession userId=request.getSession(false);
		String userId1=(String)userId.getAttribute("user");
		
	InsertDriverPreRtsAndSal driverRts=new InsertDriverPreRtsAndSal();	
	DriverBean driverBean=new DriverBean();
	
	String permitType=request.getParameter("permitType");
	driverBean.setPERMIT_TYPE(permitType);
	driverBean.setM_USER_ID(userId1);
	
	String from=request.getParameter("from");
	driverRts.setFROM_LOCATION(from);
	driverRts.setTO_LOCATION(request.getParameter("to"));
	driverRts.setD_USER_ID(userId1);
	
	DriverDAO sdao=new DriverDAOImpl();
	String message=null;
	String pr=null;
	RequestDispatcher rd=null;
	
	if(from==null && permitType==null){
		
	ArrayList<DriverBean> drAl=sdao.getDriverDetails(userId1);
	Iterator it=drAl.iterator();
	while(it.hasNext()){
		DriverBean driver=(DriverBean)it.next();
		pr=driver.getPERMIT_TYPE();
	}
	}else if(from==null && permitType!=null){
		sdao.updateDriver(driverBean);
	}
	
	else{
		message=sdao.InsertDPreferredRts(driverRts);
	}
	
	
	
	if(message==null && pr!=null && pr.equals("Within State")){
		 rd=request.getRequestDispatcher("./hidingDriverRoutes.jsp");
		 rd.forward(request, response);
	}else if(message==null && pr!=null && pr.equals("Other State")){
		rd=request.getRequestDispatcher("./preferredRoutes.jsp");
		 rd.forward(request, response);
	}
	else if(pr==null && message!=null){
	    rd=request.getRequestDispatcher("./driverPreRtsMsg.jsp");
		request.setAttribute("message", message);
		rd.forward(request, response);
	}else if(pr==null && message==null){
		String message1="Data is not inserted..";
		rd=request.getRequestDispatcher("./preferredRoutes.jsp");
		request.setAttribute("message1", message1);
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
