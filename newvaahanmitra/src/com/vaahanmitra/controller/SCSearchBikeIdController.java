package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedVehicleGetRequesterDao;
import com.vaahanmitra.daoImpl.UsedVehicleGetRequesterDaoImpl;
import com.vaahanmitra.model.UsedVehicleGetRequester;

/**
 * Servlet implementation class SCSearchBikeIdController
 */
public class SCSearchBikeIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCSearchBikeIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bikeId = request.getParameter("bikeId");

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		UsedVehicleGetRequesterDao dao = new UsedVehicleGetRequesterDaoImpl();
		ArrayList<UsedVehicleGetRequester> uvgr = dao.getBikeRequest(bikeId, user_name);
		String count = dao.getBikeRequestCount(bikeId, user_name);
		String page = null;
		if (uvgr.size() > 0) {
			page = "./scSearchBikeIdList.jsp";
			request.setAttribute("success", uvgr);
			request.setAttribute("countValue", count);
		} else {
			String msg = " NO REQUESTERS FOUND ";
			page = "./scSearchBikeId.jsp";
			request.setAttribute("failure", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
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
