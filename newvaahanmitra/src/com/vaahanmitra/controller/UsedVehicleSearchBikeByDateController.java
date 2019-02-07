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
 * Servlet implementation class UsedVehicleSearchBikeByDateController
 */
public class UsedVehicleSearchBikeByDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedVehicleSearchBikeByDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bikeId = request.getParameter("bikeId");
		String fdate = request.getParameter("fdate");
		String tdate = request.getParameter("tdate");
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		UsedVehicleGetRequesterDao dao = new UsedVehicleGetRequesterDaoImpl();
		ArrayList<UsedVehicleGetRequester> uvgr= dao.searchBikeByDate(bikeId, fdate, tdate,user_name);
		String count = dao.getBikesCount(bikeId ,user_name);
		String pageName=null;
		if(uvgr.size()>0)
		{
			pageName = "./usedVehicleRequestBikeDateWiseList.jsp";
			request.setAttribute("success", uvgr);
			request.setAttribute("countValue", count);
		}
		else
		{
			String msg = "NO REQUESTERS FOUND";
			pageName = "./usedVehicleBikeDate.jsp";
			request.setAttribute("failure", msg);
		}
		RequestDispatcher rd=request.getRequestDispatcher(pageName);
		rd.forward(request, response);
	}

}