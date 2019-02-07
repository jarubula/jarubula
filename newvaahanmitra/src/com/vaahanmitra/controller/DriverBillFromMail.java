package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.DriverEndUser;
import com.vaahanmitra.model.DriverFeedBack;

/**
 * Servlet implementation class DriverBillFromMail
 */
public class DriverBillFromMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverBillFromMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apptId=request.getParameter("id");
		String tripId=request.getParameter("tid");
		String driverEmail=request.getParameter("did");
		
		DriverDAO ddo=new DriverDAOImpl();
		List<DriverBean> driverBean=ddo.getDriverName(driverEmail);
		
		List<DriverEndUser> driverEndUser=ddo.getDriverEndUserById(apptId);
		
		List<DriverFeedBack> driverBill=ddo.getDriverBill(apptId, tripId);
		
		Iterator driverBeanIt=driverBean.iterator();
		Iterator driverEndUserIt=driverEndUser.iterator();
		Iterator driverBillIt=driverBill.iterator();
		
		DriverBean driverDetails=null;
		DriverEndUser driverEndUserDetails=null;
		DriverFeedBack driverBillDetails=null;
		while(driverBeanIt.hasNext()){
			
			driverDetails=(DriverBean)driverBeanIt.next();
			
		}while(driverEndUserIt.hasNext()){
			
			driverEndUserDetails=(DriverEndUser)driverEndUserIt.next();
			
		}while(driverBillIt.hasNext()){
			
			driverBillDetails=(DriverFeedBack)driverBillIt.next();
		}
		
		 try {
			 
			 String space="                                                                         ";
			 String space1="                     ";
			 
			 
			 String vm=space+space1+"VaahanMitra\n";
			 vm+=space+space1+"+91 12345-6789 \n";
			 vm+=space+space1+"info@gmail.com\n";
			 vm+=space+space1+"Jntu\n";
			 vm+=space+space1+"Date: "+driverBillDetails.getDRIVER_BILL_DATE()+"\n";
			 vm+=space+space1+"Bill Id: "+driverBillDetails.getDRIVER_BILL_ID()+"\n\n\n\n\n\n";
			 
			 String driver="Driver Details"+space+"User Details\n";
			 driver+=driverDetails.getFIRST_NAME()+"  "+driverDetails.getLAST_NAME()+space+driverEndUserDetails.getNAME()+"\n";
			 driver+="Mobile:  "+driverDetails.getMOBILE_NO()+space1+space1+"                Mobile:  "+driverEndUserDetails.getMOBILE_NO()+"\n";
			 driver+="Email:  "+driverDetails.getEMAIL()+space1+"           Email:"+driverEndUserDetails.getEMAIL()+"\n";
			 driver+="From Address:"+driverEndUserDetails.getADDRESS()+"\n";
			 driver+="To Address:"+driverEndUserDetails.getDESTINATION()+"\n";
			 driver+="Trip Id:"+driverBillDetails.getTRIP_ID()+"\n\n\n";
			 
			 String Recept=space+"Payment Receipt\n\n";
			 
			 String extraDetails="Date: "+space+space1+"          SIGNATURE:\n";
			 extraDetails+="Thank you for your traveling!";
			 
			 int dcharges=Integer.parseInt(driverEndUserDetails.getDRIVER_CHARGES());
			 int dhour=Integer.parseInt(driverBillDetails.getTRAVELLING_HOUR());
			 int wcharges=Integer.parseInt(driverEndUserDetails.getDRIVER_WAITING_CHARGES());
			 int whour=Integer.parseInt(driverBillDetails.getWAITING_HOUR());
			 
			 int travelingCharges=dcharges*dhour;
			 int waitingCharges=wcharges*whour;
			 
			 int totalAmount=travelingCharges+waitingCharges;
			 
			 String totalCharges=String.valueOf(travelingCharges);
			 String totalWaiting=String.valueOf(waitingCharges);
			 String totalPayableAmount=String.valueOf(totalAmount);
			 
        	Document doc=new Document();
			PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			
			PdfPTable table = new PdfPTable(4);
			table.addCell("Description");
			table.addCell("Hours");
			table.addCell("Charges");
			table.addCell("Total");
			
			table.addCell("Traveling charges");
			table.addCell(driverBillDetails.getTRAVELLING_HOUR());
			table.addCell(driverEndUserDetails.getDRIVER_CHARGES());
			table.addCell(totalCharges);
			table.addCell("Waiting charges");
			table.addCell(driverBillDetails.getWAITING_HOUR());
			table.addCell(driverEndUserDetails.getDRIVER_WAITING_CHARGES());
			table.addCell(totalWaiting);
			
			  Paragraph p1=new Paragraph(vm);
		      Paragraph p2=new Paragraph(driver);
			  Paragraph p3=new Paragraph(Recept);
			  Paragraph p4=new Paragraph(space+space1+"Total Amount: "+totalPayableAmount+"\n\n");
			  Paragraph p5=new Paragraph(extraDetails);
			  
			  doc.add(p1);  
			  doc.add(p2); 
			  doc.add(p3);
			  doc.add(table);
			  doc.add(p4);
			  doc.add(p5);
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
