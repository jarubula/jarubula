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
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class SearchCar
 */
public class SearchCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		String brand = request.getParameter("cb");
		String carId = request.getParameter("cid");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		
		CarDAO cdao=new CarDAOImpl();
		ArrayList<String> ceu = cdao.getRequesters(email);
		
		ArrayList<UsedCar> carDetails = cdao.searchUsedCar(brand);
		String demail = (String)request.getAttribute("demail");
		if(demail != null){
			page = "./searchHDealerUsedCar.jsp";
		}else{
			page = "./searchHUsedCar.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(page);
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("carrequest", ceu);
		request.setAttribute("carBrand", brand);
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
