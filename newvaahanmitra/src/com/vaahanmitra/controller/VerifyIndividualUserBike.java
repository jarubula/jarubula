package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class VerifyIndividualUserBike
 */
public class VerifyIndividualUserBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyIndividualUserBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id="bike";
		String bikeId = request.getParameter("bid");
		String email = request.getParameter("eid");
		String mobileNo = request.getParameter("mno");
		String name = request.getParameter("nm");
		
		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		String message = bdao.varifyEmailId(bikeId, email, mobileNo);
		
		UsedBikeDao bkdao = new UsedBikeDaoImpl();
		UsedBike bike = bkdao.getBikeOwnerDetails(bikeId);
		
		String url = "http://vaahanmitra.com/showBikeDetails.jsp?bid="+bikeId+"";
		String toMsg = "Buyer requested for this BIKE ID<a href='" + url + "'> (" + bikeId + ")</a> <br>"
				+ "Buyer Name :"+name+" <br>"
				+ "Mobile No  :"+mobileNo+" <br>"
				+ "Email Id   :"+email+" ";
		String fromMsg = "You Requsted to this BIKE  <a href='" + url + "'> (" + bikeId + ") </a> <br>" 
				+ "Seller Name :"+bike.getBIKE_OWNER_NAME()+" <br>"
				+ "Mobile No   :"+bike.getMOBILE_NO()+" <br>"
				+ "Email Id    :"+bike.getEMAIL_ID()+"";
		
		SendMail.sendMail(bike.getEMAIL_ID(), email, toMsg, fromMsg);
		HttpSession session = request.getSession();
		session.setAttribute("user", email);
		RequestDispatcher rd = request.getRequestDispatcher("./showBikeDetails.jsp");
		request.setAttribute("message", message);
		request.setAttribute("bid", bikeId);
		request.setAttribute("id", id);
//		request.setAttribute("name", name);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
