package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class CarBillFromMail
 */
public class CarBillFromMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarBillFromMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apptId=request.getParameter("id");
		String billId1=request.getParameter("bid");
		String email=request.getParameter("email");
		
	/*	ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		List<CarService> carService=sdao.getCarServiceDetails(apptId, billId, email);
		
		CarService serviceCenterId=carService.get(0);
		
		List<ServiceEndUser> serviceEndUser=sdao.getServiceEndUserById(apptId);
		List<BusinessOwnerRegister> serviceCenter=sdao.getServiceCenterByEmail(serviceCenterId.getSERVICE_CENTER_ID());
		
		RequestDispatcher rd=request.getRequestDispatcher("./printCarBillFromMail.jsp");
		request.setAttribute("carService", carService);
		request.setAttribute("serviceEndUser", serviceEndUser);
		request.setAttribute("serviceCenter", serviceCenter);
		rd.forward(request, response);*/
		
		 ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
			List<CarService> carService=sdao.getCarServiceDetails(apptId, billId1, email);
			
			CarService serviceCenterId=carService.get(0);
			
			List<ServiceEndUser> serviceEndUser=sdao.getServiceEndUserById(apptId);
			
			Iterator it=serviceEndUser.iterator();
			
			ServiceEndUser endUser=null;
			while(it.hasNext()){
				
				endUser=(ServiceEndUser) it.next();
			}
			
			List<BusinessOwnerRegister> serviceCenter=sdao.getServiceCenterByEmail(serviceCenterId.getSERVICE_CENTER_ID());
	        
			 Iterator it1=serviceCenter.iterator();
			 
			 BusinessOwnerRegister serviceCenter1=null;
			 while(it1.hasNext()){
				
				serviceCenter1=(BusinessOwnerRegister)it1.next();
			 }
	      
	        try {
	        	 Document doc=new Document();
				PdfWriter.getInstance(doc, response.getOutputStream());
				doc.open();
				
				String msg="                      ";
				String smsg=msg+"                                   "+serviceCenter1.getBUSINESS_NAME().toUpperCase()+"\n";
				smsg+=msg+serviceCenter1.getADDRESS()+","+serviceCenter1.getB_CITY()+","+serviceCenter1.getDISTRICT()+","+serviceCenter1.getSTATE()+","+serviceCenter1.getMOBILE_NO()+"\n";
				smsg+="\n";
				smsg+="\n";
				smsg+="\n";
				smsg+="\n";

				
				
//				msg1="Service Type    "+"Spare Parts   "+"Additional Comments";
				
				
			
				PdfPTable table = new PdfPTable(7);
				
				table.addCell("Service Type");
				table.addCell("Spare Parts");
				table.addCell("Discription");
				table.addCell("Amount");
				table.addCell("Discount");
				table.addCell("Tax");
				table.addCell("Final Price");
				
				Iterator carIt=carService.iterator();
				
				String billDate=null;
				String billId=null;
				float totalAmt=0;
				float totalTax=0;
				float totalDsct=0;
				String mechanicName=null;
				while(carIt.hasNext()){
					
					CarService bill=(CarService)carIt.next();
					
					table.addCell(bill.getSERVICE_TYPE());
					table.addCell(bill.getSPAREPARTS());
					table.addCell(bill.getDESCRIPTION());
					table.addCell(bill.getAMOUNT());
					table.addCell(bill.getDESCOUNT());
					table.addCell(bill.getTAX());
					table.addCell(bill.getFINAL_PRICE());

					
					Float disc=Float.valueOf(bill.getDESCOUNT());
					Float tax=Float.valueOf(bill.getTAX());
					Float totalAmount=Float.valueOf(bill.getFINAL_PRICE());
					
					totalDsct=totalDsct+disc;
					totalTax=totalTax+tax;
					totalAmt=totalAmt+totalAmount;
					
					billDate=bill.getBILL_DATE();
					billId=bill.getBILL_ID();
					
					mechanicName=bill.getMECHANIC_NAME();
					
				}
				
				
			      String msg2="\n";
			      msg2+="\n";
			      msg2+=msg+"                                              "+"Total Discount : "+totalDsct+"\n";
			      msg2+=msg+"                                              "+"Total Tax : "+totalTax+"\n";
			      msg2+=msg+"                                              "+"Total Payable Amount : "+totalAmt+"\n";
			      
			       
				
			      String msg3="                                                                            ";
			      String msg4="";
			      msg4+=msg3+"                   "+"Bill Id : "+billId+"\n";
			      msg4+=msg3+"                   "+"Bill Date : "+billDate+"\n";
			      msg4+="\n";
			      
			      String msg1="Appointment Id : "+endUser.getAPPOINTMENT_ID()+"\n";
					msg1+="Customer Name : "+endUser.getNAME()+ "\n";
					msg1+="Mobile Number : "+endUser.getMOBILE_NO()+"\n";
					msg1+="Vehicle No & Brand : "+endUser.getCAR_NO()+endUser.getVEHICLE_BRAND()+"\n";
					msg1+="Mechanic Name : "+mechanicName;
					msg1+="\n";
					msg1+="\n";
			      
				  Paragraph p4=new Paragraph("VaahanMitra\n"+"\n"+"\n");
			      Paragraph p=new Paragraph(smsg);
				  Paragraph p1=new Paragraph(msg1);
			      Paragraph p2=new Paragraph(msg2);
			      Paragraph p3=new Paragraph(msg4);
			      
			     
			    doc.add(p4);  
			    doc.add(p3); 
				doc.add(p);
				doc.add(p1);
				doc.add(table);
				doc.add(p2);
				doc.close();
		
	        } catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
