package com.vaahanmitra.service;

import java.util.Properties;
import java.util.Calendar;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.vaahanmitra.utilities.SQLDate;

public class SendMailToUser {
	public static void send(String userEmail,String id,String name,String date) {

		SQLDate sdate=new SQLDate();
		date=sdate.getInDate(date);
		
		/*final String username = "campusguide.in@gmail.com";//change accordingly
		final String password = "campus@2017";//change accordingly
*/
		final String senderEmailId="info@vaahanmitra.com";//Change Accordingly
		
		final String username="AKIAIPEKXQTOVO5DIHEA";
		final String password="Al9uyqPYacODzUlRazrnwL3ypy0vHGJ8C8263u3rJ3jV";	
		String host = "email-smtp.us-east-1.amazonaws.com";
		
		String msg="Your Requested Appointment will not accept until you verify your email so please verify your email below. <br>";
		msg+="<b>Service Center Name :</b> "+" "+name+" <br>";
		msg+="<b>Appointment Date :</b> "+" "+date+" <br>";
		msg+="<b>Appointment Id :</b> "+" "+id+" <br>";
		msg+="Service Center will reach you soon to confirm your Appointment..";
//		msg+="<a href='http://localhost:8887/Vaahanmitra/setBookAppointmentPSW.jsp'>Set your password to see your appointment details</a><br>";
		msg+="<a href='http://vaahanmitra.com/BookAppointmentEmailVerification?email="+userEmail+"&id="+id+"'>verify your email </a><br>";
		
		  MimeBodyPart mimeBodyPart=new MimeBodyPart();
		  MimeMultipart multipart=new MimeMultipart();
	      try {
			mimeBodyPart.setContent(msg,"text/html");
		    multipart.addBodyPart(mimeBodyPart);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	      	Properties props = new Properties();
			props.put("mail.transport.protocol","smtp");
			props.put("mail.smtp.host", host);  
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.auth", "true");  
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.starttls.required","true");
			//Debugger will provide much more logs than in normal mode. remove this line for production
			props.put("mail.debug","true");
			
		 Session session = Session.getInstance(props,new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
		try {

			MimeMessage message = new MimeMessage(session);
			message.setContent(multipart);
			message.setFrom(new InternetAddress(senderEmailId));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userEmail));
			message.setSubject("Greetings from vaahanmitra.com");
			message.setText(msg,"UTF-8","html");
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
