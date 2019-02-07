package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class VerifyIndividualUserCar
 */
public class VerifyIndividualUserCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyIndividualUserCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id="car";
		String carId = request.getParameter("cid");
		String email = request.getParameter("eid");
		String mobileNo = request.getParameter("mno");
		String name = request.getParameter("nm");
		
		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		String message = bdao.varifyEmailId(carId, email, mobileNo);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", email);
//		session.setAttribute("name", name);
		
		UsedCarDao cdao = new UsedCarDaoImpl();
		UsedCar car = cdao.getCarOwnerDetails(carId);
		
		String url = "http://vaahanmitra.com/showCarDetails.jsp?cid="+carId+"";
		String toMsg = "Buyer requested for this CAR ID<a href='" + url + "'> (" + carId + ")</a> <br>"
				+ "Buyer Name :"+name+" <br>"
				+ "Mobile No  :"+mobileNo+" <br>"
				+ "Email Id   :"+email+" ";
		String fromMsg = "You Requsted to this CAR  <a href='" + url + "'> (" + carId + ") </a> <br>" 
				+ "Seller Name :"+car.getCAR_OWNER_NAME()+" <br>"
				+ "Mobile No   :"+car.getMOBILE_NO()+" <br>"
				+ "Email Id    :"+car.getEMAIL_ID()+"";
		
		SendMail.sendMail(car.getEMAIL_ID(), email, toMsg, fromMsg);
		
		RequestDispatcher rd = request.getRequestDispatcher("./showCarDetails.jsp");
		request.setAttribute("message", message);
		request.setAttribute("cid", carId);
		request.setAttribute("id", id);
//		request.setAttribute("name", name);
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
