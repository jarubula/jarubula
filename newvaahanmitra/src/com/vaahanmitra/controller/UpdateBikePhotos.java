package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;

@javax.servlet.annotation.MultipartConfig
public class UpdateBikePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBikePhotos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String bikeNo = request.getParameter("bikeNo");
		String userType = request.getParameter("userType");
		if (userType.equals("SC")) {
			page = "./updateSCBikePhotos.jsp";
		} else if (userType.equals("UD")) {
			page = "./updateUDBikePhotos.jsp";
		} else if (userType.equals("IO")) {
			page = "./updateIOBikePhotos.jsp";
		}
		Part photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		photo1 = request.getPart("photo1");
		photo2 = request.getPart("photo2");
		photo3 = request.getPart("photo3");
		photo4 = request.getPart("photo4");
		photo5 = request.getPart("photo5");
		photo6 = request.getPart("photo6");
		photo7 = request.getPart("photo7");
		photo8 = request.getPart("photo8");
		photo9 = request.getPart("photo9");
		photo10 = request.getPart("photo10");
		/*
		 * photo11 = request.getPart("photo11"); photo12 =
		 * request.getPart("photo12");
		 */
		InputStream is = null;
		ArrayList<InputStream> al = new ArrayList<InputStream>();
		if (photo1 != null) {
			is = photo1.getInputStream();
			al.add(is);
		}
		if (photo2 != null) {
			is = photo2.getInputStream();
			al.add(is);
		}
		if (photo3 != null) {
			is = photo3.getInputStream();
			al.add(is);
		}
		if (photo4 != null) {
			is = photo4.getInputStream();
			al.add(is);
		}
		if (photo5 != null) {
			is = photo5.getInputStream();
			al.add(is);
		}
		if (photo6 != null) {
			is = photo6.getInputStream();
			al.add(is);
		}
		if (photo7 != null) {
			is = photo7.getInputStream();
			al.add(is);
		}
		if (photo8 != null) {
			is = photo8.getInputStream();
			al.add(is);
		}
		if (photo9 != null) {
			is = photo9.getInputStream();
			al.add(is);
		}
		if (photo10 != null) {
			is = photo10.getInputStream();
			al.add(is);
		}
		UsedBikeDao dao = new UsedBikeDaoImpl();
		/*
		 * HttpSession session = request.getSession(false); String user_name =
		 * (String) session.getAttribute("user");
		 */
		String message = dao.updateBikePhotos(bikeNo, is, al);
		if (message.equals("success")) {
			if (userType.equals("SC")) {
				message = "Photos are updated on '"+bikeNo+"'. <a href='./showUsedBikesList.jsp'><u> Click </u></a>for  Search your bikes.";
			} else if (userType.equals("UD")) {
				message = "Photos are updated on '"+bikeNo+"'. <a href='./showDashboard2UsedBikeList.jsp'><u> Click </u></a>for  Search your bikes.";
			} else if (userType.equals("IO")) {
				message = "Photos are updated on '"+bikeNo+"'. <a href='./searchIndividualUsedBike.jsp'><u> Click </u></a>for  Search your bikes.";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("message", message);
		request.setAttribute("bikeNo", bikeNo);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
