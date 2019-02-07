package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.daoImpl.CarDAOImpl;

/**
 * Servlet implementation class UpdateMobileCar
 */
public class UpdateMobileCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMobileCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;

//		HttpSession session = request.getSession(false);
//		String carId = (String) session.getAttribute("carId");
//		String email = (String) session.getAttribute("email");
//		String mobileNo = (String) session.getAttribute("mobileNo");
//		String name = (String) session.getAttribute("name");
		
		String carId = request.getParameter("cid");
		String mobileNo = request.getParameter("mno");
		String email = request.getParameter("eid");
		String name = request.getParameter("nm");

		CarDAO cdao = new CarDAOImpl();

		message = cdao.updateMobileNo(carId,name, email, mobileNo);
		message = "<b> YOUR MOBILE NO  (" + mobileNo + ")  SUCCESSFULLY UPDATED <b>";
		RequestDispatcher rd = request.getRequestDispatcher("./successEmailVerification.jsp");
		request.setAttribute("message", message);
		request.setAttribute("carId", carId);
		request.setAttribute("email", email);
		request.setAttribute("mobileNo", mobileNo);
		rd.forward(request, response);

//		session.removeAttribute("name");
//		session.removeAttribute("mobileNo");
//		session.removeAttribute("email");
//		session.removeAttribute("carId");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
