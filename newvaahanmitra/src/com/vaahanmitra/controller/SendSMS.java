package com.vaahanmitra.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendSMS
 */
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSMS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String recipient = "+918333055292";
        String message = " Greetings from Mr. Mahesh Babu I! Have a nice day!";
        String username = "admin";
        String password = "abc123";
        String originator = "+919246460494";*/
		String returnstring=null;
		try {
            String recipient = "+918333055292";
            String message = " Greetings from Mr. Mahesh Babu I! Have a nice day!";
            String username = "admin";
            String password = "abc123";
            String originator = "+919246460494";

            String requestUrl  = "http://192.168.1.33:8088/api?action=sendmessage&" +
            					 "username=" + URLEncoder.encode(username, "UTF-8") +
            					 "&password=" + URLEncoder.encode(password, "UTF-8") +
            					 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
            					 "&messagetype=SMS:TEXT" +
            					 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
            					 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
            					 "&serviceprovider=GSMModem1" +
            					 "&responseformat=html";



            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();

            System.out.println(uc.getResponseMessage());
            returnstring=uc.getResponseMessage();
            uc.disconnect();

    } catch(Exception ex) {
        ex.printStackTrace();    
    	System.out.println(ex.getMessage());
            returnstring=ex.getMessage();
    }
		RequestDispatcher rd=request.getRequestDispatcher("./SendSMS.jsp");
		request.setAttribute("returnstring", returnstring);
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
