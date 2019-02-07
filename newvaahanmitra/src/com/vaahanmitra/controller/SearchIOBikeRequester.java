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
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class SearchIOBikeRequester
 */
public class SearchIOBikeRequester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchIOBikeRequester() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String br = request.getParameter("bikeRequester");
		String fdate = request.getParameter("fdate");
		String tdate = request.getParameter("tdate");
		String bikeId = request.getParameter("bikeId"); 
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		UsedVehicleGetRequesterDao dao = new UsedVehicleGetRequesterDaoImpl();
		ArrayList<UsedBike> uvgr= dao.searchBikeRequester(fdate,tdate,bikeId,user_name);
		String page= null;

		if(br!=null && br.equals("bio")){
			page ="./searchIOBikeRequester.jsp";
		}else if(br!=null && br.equals("bsc")){
			page ="./searchSCBikeRequester.jsp";
		}else if(br!=null && br.equals("bud")){
			page ="./searchUDBikeRequester.jsp";
		}else if(br!=null && br.equals("bsp")){
			page ="./searchSPBikeRequester.jsp";
		}else if(br!=null && br.equals("bdr")){
			page ="./searchDRBikeRequester.jsp";
		}
		request.setAttribute("bikeDetails", uvgr);
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
