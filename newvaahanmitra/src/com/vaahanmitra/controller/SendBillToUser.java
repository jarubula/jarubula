package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.service.SendEmailToUser;

/**
 * Servlet implementation class SendBillToUser
 */
public class SendBillToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendBillToUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apptId=request.getParameter("id");
		String billId=request.getParameter("billId");
		String email=request.getParameter("mail");
		
		SendEmailToUser sendMail=new SendEmailToUser();
		sendMail.sendCarBillToUser(apptId, billId, email);
		
		String message="bill sent to mail successfully....";
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		List<CarService> carService=sdao.getCarServiceDetails(apptId, billId, email);
		
		CarService serviceCenterId=carService.get(0);
		
		List<ServiceEndUser> serviceEndUser=sdao.getServiceEndUserById(apptId);
		List<BusinessOwnerRegister> serviceCenter=sdao.getServiceCenterByEmail(serviceCenterId.getSERVICE_CENTER_ID());
		
		RequestDispatcher rd=request.getRequestDispatcher("./printCarBillFromMail.jsp");
		request.setAttribute("carService", carService);
		request.setAttribute("serviceEndUser", serviceEndUser);
		request.setAttribute("serviceCenter", serviceCenter);
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
