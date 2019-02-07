package com.vaahanmitra.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	public static void send(String to, String msg) {

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		MimeMultipart multipart = new MimeMultipart();
		try {
			mimeBodyPart.setContent(msg, "text/html");
			multipart.addBodyPart(mimeBodyPart);
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
		
		/*final String username = "campusguide.in@gmail.com";// change accordingly
		final String password = "cguide1820@";// change accordingly
		final String senderEmailId="campusguide.in@gmail.com";//Change Accordingly	
*/		final String username = "info@vaahanmitra.com";//change accordingly
		final String password = "ksl@vahan2018";//change accordingly	
		 	
		final String senderEmailId="info@vaahanmitra.com";//Change Accordingly
		
		/*final String username="AKIAIPEKXQTOVO5DIHEA";
		final String password="Al9uyqPYacODzUlRazrnwL3ypy0vHGJ8C8263u3rJ3jV";	
		String host = "email-smtp.us-east-1.amazonaws.com";*/
		String host = "smtp.gmail.com";

		Properties props = new Properties();
	//	props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host", host);  
//		props.put("mail.smtp.port", "25"); // Port Number for AWS Mailing
		props.put("mail.smtp.port", "587");// Port Number for gmail
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.starttls.enable", "true");
	//	props.put("mail.smtp.starttls.required","true");
		//Debugger will provide much more logs than in normal mode. remove this line for production
		props.put("mail.debug","true");
		props.put("mail.user", username);
		props.put("mail.password", password);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			String sub = "Greetings! from Vaahanmitra....";
			MimeMessage message = new MimeMessage(session);

			message.setContent(multipart);
			message.setFrom(new InternetAddress(senderEmailId));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(sub);
			message.setSentDate(new java.util.Date());
			message.setText(msg, "UTF-8", "html");
			// message.setText(msg);
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void sendMail(String to,String email,String toMsg,String fromMsg) {

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		MimeMultipart multipart = new MimeMultipart();
		
		MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
		MimeMultipart multipart1 = new MimeMultipart();
		try {
			mimeBodyPart.setContent(toMsg, "text/html");
			multipart.addBodyPart(mimeBodyPart);
			
			mimeBodyPart1.setContent(fromMsg, "text/html");
			multipart1.addBodyPart(mimeBodyPart1);
			
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
		final String senderEmailId="info@vaahanmitra.com";
		final String username = "info@vaahanmitra.com";//change accordingly
		final String password = "set123456";//change accordingly	
		/*final String username="AKIAIPEKXQTOVO5DIHEA";
		final String password="Al9uyqPYacODzUlRazrnwL3ypy0vHGJ8C8263u3rJ3jV";	
		String host = "email-smtp.us-east-1.amazonaws.com";*/
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		//props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host", host);  
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.starttls.required","true");
		//Debugger will provide much more logs than in normal mode. remove this line for production
		/*props.put("mail.debug","true");*/

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			String sub = "GEETINGS FROM VAAHANMITRA";
			MimeMessage toMessage = new MimeMessage(session);
			MimeMessage fromMessage = new MimeMessage(session);
			
			toMessage.addRecipients(Message.RecipientType.CC, InternetAddress.parse(to));
			fromMessage.addRecipients(Message.RecipientType.CC, InternetAddress.parse(email));
			
			toMessage.setFrom(new InternetAddress(senderEmailId));
			fromMessage.setFrom(new InternetAddress(senderEmailId));
			
			toMessage.setContent(multipart);
			fromMessage.setContent(multipart1);
			
			toMessage.setSubject(sub);
			fromMessage.setSubject(sub);
			
			toMessage.setText(toMsg, "UTF-8", "html");
			fromMessage.setText(fromMsg, "UTF-8", "html");

			Transport.send(toMessage);
			Transport.send(fromMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMailToMuliple(String[] to, String msg) {

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		MimeMultipart multipart = new MimeMultipart();
		try {
			mimeBodyPart.setContent(msg, "text/html");
			multipart.addBodyPart(mimeBodyPart);
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
		/*
		final String username = "campusguide.in@gmail.com";// change accordingly
		final String password = "cguide1820@";// change accordingly
		*/
		final String username = "info@vaahanmitra.com";//change accordingly
		final String password = "set123456";//change accordingly	
		 		
		final String senderEmailId="info@vaahanmitra.com";//Change Accordingly
		
		/*final String username="AKIAIPEKXQTOVO5DIHEA";
		final String password="Al9uyqPYacODzUlRazrnwL3ypy0vHGJ8C8263u3rJ3jV";	
		String host = "email-smtp.us-east-1.amazonaws.com";*/
		String host = "smtp.gmail.com";

		Properties props = new Properties();
//		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host", host);  
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.starttls.required","true");
		//Debugger will provide much more logs than in normal mode. remove this line for production
		//props.put("mail.debug","true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		
		try {
			
			InternetAddress[] recipientAddress = new InternetAddress[to.length];
			int counter = 0;
			for (String recipient : to) {
				//System.out.println("Recepents :: "+recipient.trim());
			    recipientAddress[counter] = new InternetAddress(recipient.trim());
			    counter++;
			}
			
			String sub = "Info! from Vaahanmitra....";
			MimeMessage message = new MimeMessage(session);
			//System.out.println("All Receipents ::"+recipientAddress);
			message.setContent(multipart);
			message.setFrom(new InternetAddress(senderEmailId));
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject(sub);
			message.setSentDate(new java.util.Date());
			message.setText(msg, "UTF-8", "html");
			// message.setText(msg);
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
 /*public static void send(String to,String subject,String msg){  
  
	MimeBodyPart mimeBodyPart = new MimeBodyPart();
	MimeMultipart multipart = new MimeMultipart();
	try {
		mimeBodyPart.setContent(msg, "text/html");
		multipart.addBodyPart(mimeBodyPart);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	final String user="info@vaahanmitra.com";//change accordingly  
	final String pass="ksl@vahan2018";

	
//1st step) Get the session object    
Properties props = new Properties();  
props.put("mail.smtp.host", "smtp.gmail.com");//Gmail smtp host
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");  
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.debug", "true");
//my changes 
props.put("mail.user", user);
props.put("mail.password", pass);
EMailAuthenticator auth=new EMailAuthenticator(user,pass);

Session session = Session.getDefaultInstance(props, auth);  
//2nd step)compose message  
try {  
 MimeMessage message = new MimeMessage(session);  
 message.setContent(multipart);
 message.setFrom(new InternetAddress(user));  
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
 message.setSubject(subject);
 message.setSentDate(new java.util.Date());
 
 message.setText(msg, "UTF-8", "html");
 
 //message.setText(msg);  
   
 //3rd step)send message  
 Transport.send(message);  
  
 //System.out.println("Done");  
  
 } catch (MessagingException e) {  
	 e.printStackTrace();
    throw new RuntimeException(e);  
 }  
      
} */ 
	
	public static void main(String []args) {
		// TODO Auto-generated method stub
		send("maheshbabu.i@kosruisoft.com", "Hai Test");

	}

}
