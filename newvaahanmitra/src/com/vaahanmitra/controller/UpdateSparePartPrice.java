package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.daoImpl.SparePartsDaoImpl;
import com.vaahanmitra.model.SpareParts;

/**
 * Servlet implementation class UpdateSparePartPrice
 */
public class UpdateSparePartPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateSparePartPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messge = null;
		String fPrice[] = request.getParameterValues("fPrice");
		String sku[] = request.getParameterValues("sku");
		String check[] = request.getParameterValues("check");
		String discount[] = request.getParameterValues("discount");
		
		List<SpareParts> list=new ArrayList<SpareParts>();
		
		System.out.println(discount.length);
		for(int i=0,j=0,k=0,l=0;i<fPrice.length || j<sku.length || k<check.length || l<discount.length;i++,j++,k++,l++){
			SpareParts sp = new SpareParts();
			if(l<discount.length && !discount[l].equals("")){
				sp.setSKU(sku[j]);
				sp.setPRICE(fPrice[i]);
				list.add(sp);
			}
		}
		
		String skusp = request.getParameter("skusp");
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		SparePartsDao dao = new SparePartsDaoImpl();
		String message = dao.updateSPPrice(list,user_name);
		ArrayList<SpareParts> sp= dao.getSPDetails(skusp.toUpperCase(),user_name);
		String page = null;
		String msg = null;
		if(sp.size()>0)
		{
			page = "./updateSparePartPrice.jsp";
			request.setAttribute("spdetails", sp);
//			request.setAttribute("message1", messge);
			request.setAttribute("skusp", skusp);
		}
		else
		{	
			msg = "*** NO SPARE PARTS FOUND ***";
			page = "./updateSparePartPrice.jsp";
			request.setAttribute("message1", msg);
		}
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
