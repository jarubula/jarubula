package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;

/**
 * Servlet implementation class DealerUsedCar
 */
public class DealerUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealerUsedCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("dealerName");
		String vehicleType=request.getParameter("vehicleType");
		String name=request.getParameter("name");
		
		HttpSession session = request.getSession(false);
		String uemail = (String) session.getAttribute("user");
		ArrayList<String> ceu = null;
		ArrayList<String> bikeRequesters = null;
		CarDAO cdao=new CarDAOImpl();
		if(uemail!=null){
			ceu = cdao.getRequesters(uemail);
			SearchHUsedBikeDAO dao=new SearchHUsedBikeDAOImpl();
			bikeRequesters = dao.getRequesters(uemail);
		}
		
		RequestDispatcher rd=null;
		if(vehicleType.equals("4,")){
			
		rd=request.getRequestDispatcher("./SearchHDealerUsedCar");	
		request.setAttribute("carrequest", ceu);
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		
		rd.forward(request, response);
			
		}else if(vehicleType.equals("2,")){
			
			rd=request.getRequestDispatcher("./SearchHDealerUsedBike");	
			request.setAttribute("bikerequest", bikeRequesters);
			request.setAttribute("email", email);
			request.setAttribute("name", name);
			rd.forward(request, response);
			
		} else if (vehicleType.equals("4,2,")) {

			rd = request.getRequestDispatcher("./SearchHDealerUsedCar");
			request.setAttribute("carrequest", ceu);
			request.setAttribute("email", email);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("name", name);
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
