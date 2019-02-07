package com.vaahanmitra.service;

import java.util.Iterator;
import java.util.List;
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

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.DriverEndUser;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.utilities.SQLDate;

public class SendEmailToUser {

	public void send(String userEmail,String msg){
	
	/*final String username = "campusguide.in@gmail.com";//change accordingly
	final String password = "cguide1820@";//change accordingly
*/	
		final String senderEmailId="info@vaahanmitra.com";//Change Accordingly
		
		final String username="AKIAIPEKXQTOVO5DIHEA";
		final String password="Al9uyqPYacODzUlRazrnwL3ypy0vHGJ8C8263u3rJ3jV";	
		String host = "email-smtp.us-east-1.amazonaws.com";
	 
		MimeBodyPart mimeBodyPart=new MimeBodyPart();
		MimeMultipart multipart=new MimeMultipart();
		try 
		{
			mimeBodyPart.setContent(msg,"text/html");
			multipart.addBodyPart(mimeBodyPart);
		} catch (MessagingException e1) 
		{
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
		message.setSentDate(new java.util.Date());
		message.setText(msg,"UTF-8","html");
		Transport.send(message);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public void ratingMail(ServiceEndUser serviceEndUser){
		
		String msg="Thank You for Rating this Service Center";
		
		send(serviceEndUser.getEMAIL(),msg);
		
		
	}
	
	public void ConfirmServiceDate(String email,String apptId,String date){
		
		String msg=null;
		
		if(date!=null){
		SQLDate SQLdate=new SQLDate();
		String cnfmDate=SQLdate.getInDate(date);
		
		msg="Your Service has changed to "+cnfmDate+"<br>";
		msg+="<b>Appointment Id :</b> "+" "+apptId+" <br>";
		msg+="Service Center will Contact you Soon..";
		}else{
		
			msg="Your Service has conformed "+"<br>";
			msg+="<b>Appointment Id :</b> "+" "+apptId+" <br>";
			msg+="Service Center will Contact you Soon..";
			
		}
		
		send(email,msg);
	}
	
	public void sendApptIdToEndUser(String email,String genId,String name,String date){
		
		SQLDate sdate=new SQLDate();
		date=sdate.getInDate(date);
		
		MechanicDao mdao=new MechanicDaoImpl();
		BusinessOwnerRegister serviceCenter=mdao.getBookedServiceDetails(genId);
		
		String addr=serviceCenter.getADDRESS()==null?"N/A":serviceCenter.getADDRESS();
		String city=serviceCenter.getB_CITY()==null?" ":serviceCenter.getB_CITY();

		String msg="Accepted Your Requested Appointment <br><br>";
		msg+="<b>Service Center Name :</b> "+" "+name+" <br><br>";
		msg+="<b>Address :</b> "+" "+addr+","+city+" <br><br>";
		msg+="<b>Appointment Date :</b> "+" "+date+" <br><br>";
		msg+="<b>Appointment Id :</b> "+" "+genId+" <br><br>";
		msg+="Service Center will reach you soon to Confirm your Appointment..";
//		msg+="<a href='http://localhost:8887/Vaahanmitra/setBookAppointmentPSW.jsp'>Set your password to see your appointment details</a><br>";
//		msg+="<a href='http://localhost:8887/Vaahanmitra/BookAppointmentEmailVerification?email="+userEmail+"&id="+id+"'>verify your email </a><br>";
		
		send(email,msg);
		
	}
	
	public void driverRegisterMsg(String email){
		
		String msg="Thank you for Registring in vaahanmitra.com<br><br>";
		msg+="Now post your details in vaahanmitra.com and enjoy our service<br><br>";
		msg+="If you have any issue please feel free to contact us,we are always available for you<br><br>";
		//msg+="Please verify your mail after verification only we will give you permission to update your details..<br><br>";
		msg+="Please verify your mail, after verification You can update your details..<br><br>";
		msg+="<a href='http://vaahanmitra.com/DriverVerification?email="+email+"'>verify your email </a><br><br>";
		
		send(email,msg);	
		
	}
	
	public void sendMailToServiceCenter(String email,ServiceEndUser endUser){
		
		String msg=endUser.getNAME()+"has been requested to your Service Center<br><br>";
		msg+="<b>Appointment Id :</b> "+" "+endUser.getAPPOINTMENT_ID()+" <br><br>";
		msg+="<b>Appointment Date :</b> "+" "+endUser.getAPPOINTMENT_DATE()+" <br><br>";
		msg+="<b>Email :</b> "+" "+endUser.getEMAIL()+" <br><br>";
		msg+="<b>Mobile No :</b> "+" "+endUser.getMOBILE_NO()+" <br><br>";
		
		send(email,msg);
		
	}
	
	public void sendVerificationMailToDriverEndUser(DriverEndUser driverEndUser,List<String> driverList,String driverEndUserId){
		String msg="<font color='red' size="+3+">Your Requested Appointment will not accept until you verify your email details</font>";
		msg+="<a href='http://vaahanmitra.com/OnDemandDriverVerification?email="+driverEndUserId+"'>Verify your email </a><br><br>";
		msg+="<table border="+1+">";
		msg+="<tr>";
		msg+="<th>DRIVER NAME</th><th>DRIVER ID</th><th>DRIVER PHONE NO</th><th>APPT ID</th><th>APPT DATE</th><th>APPT TIME</th>";
		msg+="</tr>";
		msg+="<tr>";
		msg+="<td>"+driverList.get(0)+"</td><td>"+driverList.get(4)+"</td><td>"+driverList.get(3)+"</td><td>"+driverEndUserId+"</td><td>"+driverEndUser.getAPPOINTMENT_DATE()+"</td><td>"+driverEndUser.getAPPOINTMENT_TIME()+"</td>";
		msg+="</tr>";
		msg+="</table>";
		/*msg+="</form action='http://localhost:8887/Vaahanmitra/DriverVerification'>";
		msg+="</body>";
		msg+="<input type='hidden' name='email' value="+driverEndUser.getEMAIL()+"/>";
		msg+="<input type='submit' value='verify your mail'/>";
		msg+="</body>";
		msg+="</form>";*/
		
		send(driverEndUser.getEMAIL(),msg);
	}
	public void bookedMailToDriverEndUser(DriverEndUser driverEndUser,List<String> driverList,String driverEndUserId){
		
		String msg="<font color='red' size="+3+">Accepted your Request</font>";
		msg+="<table bgcolor='#F6DDCC' border="+1+">";
		msg+="<tr>";
		msg+="<th>DRIVER NAME</th><th>DRIVER ID</th><th>DRIVER PHONE NO</th><th>APPT ID</th><th>APPT DATE</th><th>APPT TIME</th>";
		msg+="</tr>";
		msg+="<tr>";
		msg+="<td>"+driverList.get(0)+"</td><td>"+driverList.get(4)+"</td><td>"+driverList.get(3)+"</td><td>"+driverEndUserId+"</td><td>"+driverEndUser.getAPPOINTMENT_DATE()+"</td><td>"+driverEndUser.getAPPOINTMENT_TIME()+"</td>";
		msg+="</tr>";
		msg+="</table>";
	
		
		send(driverEndUser.getEMAIL(),msg);
		sendEndUserDetailsToDriverMail(driverEndUser,driverList.get(2),driverEndUserId);
	}
	
		public void driverRatingMail(String email){
		
		String msg="Thank You for Rating this driver";
		
		send(email,msg);
		
		
	}
		
		public void sendCarBillToUser(String apptId,String billId,String email){
			
			
			String msg="Your Bill  ";
			
		
			msg+="<a href='http://vaahanmitra.com/CarBillFromMail?email="+email+"&id="+apptId+"&bid="+billId+"'>Click Here For Your Bill </a><br><br>";
			
			send(email,msg);
			
			
		}
		
			public void sendAcceptedMailToDriverEndUser(String userMail,String driverMail,String tripId){
			
			
			String msg="Your Request is accepted by Driver,He will reach you soon <br>";
			msg+="Your Trip Id is<mark>"+tripId+"</mark>";
			
			String msg1="You are accepted user request";
			msg1+="Your Trip Id is <mark>"+tripId+"</mark>";
			
			send(userMail,msg);
			send(driverMail,msg1);
			
		}
		
		public void bookedMultiDriverMailToDriverEndUser(DriverEndUser driverEndUser,List<DriverBean> driverList,String driverEndUserId){
			
			String msg="<font color='red' size="+3+">Accepted your request</font>";
			msg+="<table bgcolor='#F6DDCC'>";
			msg+="<tr>";
			msg+="<th>DRIVER NAME</th><th>DRIVER ID</th><th></th><th>DRIVER PHONE NO</th><th>APPT ID</th><th>APPT DATE</th><th>APPT TIME</th>";
			msg+="</tr><tr></tr>";
			Iterator it=driverList.iterator();
			while(it.hasNext()){
				DriverBean bean=(DriverBean)it.next();
			msg+="<tr>";
			msg+="<td>"+bean.getFIRST_NAME()+"</td><td>"+bean.getDRIVER_ID()+"</td><td></td><td align='center'>"+bean.getMOBILE_NO()+"</td><td>"+driverEndUserId+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_DATE()+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_TIME()+"</td>";
			msg+="</tr><tr></tr><tr></tr>";
			}
			msg+="</table>";
		
			
			send(driverEndUser.getEMAIL(),msg);
		}
		
		public void multiDriverRequestVerificationMailToDriverEndUser(DriverEndUser driverEndUser,List<DriverBean> driverList,String driverEndUserId){
			String msg="<font color='red' size="+3+">your requested appointment will not accept until you verify your email</font>";
			msg+="<a href='http://vaahanmitra.com/OnDemandDriverVerification?email="+driverEndUserId+"'>verify your email </a><br><br>";
			msg+="<table border="+1+">";
			msg+="<tr>";
			msg+="<th>DRIVER NAME</th><th>DRIVER ID</th><th>DRIVER PHONE NO</th><th>APPT ID</th><th>APPT DATE</th><th>APPT TIME</th>";
			msg+="</tr><tr></tr>";
			Iterator it=driverList.iterator();
			while(it.hasNext()){
				DriverBean bean=(DriverBean)it.next();
			msg+="<tr>";

			msg+="<td>"+bean.getFIRST_NAME()+"</td><td>"+bean.getDRIVER_ID()+"</td><td></td><td align='center'>"+bean.getMOBILE_NO()+"</td><td>"+driverEndUserId+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_DATE()+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_TIME()+"</td>";
			
			msg+="</tr><tr></tr><tr></tr>";
			}
			msg+="</table>";
			/*msg+="</form action='http://localhost:8887/Vaahanmitra/DriverVerification'>";
			msg+="</body>";
			msg+="<input type='hidden' name='email' value="+driverEndUser.getEMAIL()+"/>";
			msg+="<input type='submit' value='verify your mail'/>";
			msg+="</body>";
			msg+="</form>";*/
			
			send(driverEndUser.getEMAIL(),msg);
		}
		
		public void sendEndUserDetailsToDriverMail(DriverEndUser driverEndUser,String email,String driverEndUserId){
			
			String msg="<font color='red' size="+3+">Your Requester Details....</font>";
			msg+="<table bgcolor='#F6DDCC'>";
			msg+="<tr>";
			msg+="<th>PERSON NAME</th><th>EMAIL</th><th></th><th>MOBILE NO.</th><th>PICKUP ADDRESS</th><th>DESTINATION</th><th>APPT DATE</th><th>APPT TIME</th><th>APPT ID</th>";
			msg+="</tr><tr></tr>";

			msg+="<tr>";
			msg+="<td>"+driverEndUser.getNAME()+"</td><td>"+driverEndUser.getEMAIL()+"</td><td></td><td align='center'>"+driverEndUser.getMOBILE_NO()+"</td><td>"+driverEndUser.getADDRESS()+"</td><td>"+driverEndUser.getDESTINATION()+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_DATE()+"</td><td align='center'>"+driverEndUser.getAPPOINTMENT_TIME()+"</td><td>"+driverEndUserId+"</td>";
			msg+="</tr><tr></tr><tr></tr>";
			
			msg+="</table>";
		
			
			send(email,msg);
			
		}
		
		
		public String driverBillToUser(String apptId,String tripId,String driverMail,String userEmail){
			
			String message="Bill Has Sent To User Mail!..";
			String msg="Your Bill  ";
			
			
			msg+="<a href='http://vaahanmitra.com/DriverBillFromMail?did="+driverMail+"&id="+apptId+"&tid="+tripId+"'>Click Here For Your Bill </a><br><br>";
			
			send(userEmail,msg);
			
			return message;
		}
	
}
