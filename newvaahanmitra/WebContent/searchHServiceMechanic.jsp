<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*,java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<style type="text/css">
 @media screen and (max-width: 780px) {
    #m1 {
        margin-bottom:4px;
    }
    
} 
.content {
    padding: 0px;
    background: #efefef;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 0px !important;
    border: 1px solid transparent;
}
</style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Vaahanmitra | Search Service Center</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <link href="http://www.vaahanmitra.com/searchHServiceMechanic.jsp" rel="canonical" />
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="./css/tcal.css" />
		<script type="text/javascript" src="./js/tcal.js"></script>
		

	<script type="text/javascript">
	
	function yesnoCheck() {
	    if (document.getElementById('yesCheck').checked) {
	        document.getElementById('ifYes').style.display = 'block';
	    }
	    else document.getElementById('ifYes').style.display = 'none';

	}
	
	</script>	


 <% String message1=(String)request.getAttribute("message");
         /* if(message1!=null){ */
        %>
    <%--     <script type="text/javascript">
         alert("<%=message1%>");
         
         function showMsg(){
        	 
         }
         
         </script>
         <%}else{} %> --%>
         
      

	
<script>
function toggle_it(itemID,text){ 
    // Toggle visibility between none and ''
    var text=document.getElementById(text);
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = ''
          text.innerHTML="-"
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          text.innerHTML="+"
          event.preventDefault()
    }    
} 

</script>

<style>

span.stars, span.stars span {
    display: block;
    background: url(./images/stars.png) 0 -16px repeat-x;
    width: 80px;
    height: 16px;
}

span.stars span {
    background-position: 0 0;
}

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<style type="text/css">
#overlay {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
/* background-color: #000; */
 filter:alpha(opacity=70); 
-moz-opacity:0.7;
-khtml-opacity: 0.7;
opacity: 0.7;
z-index: 100;
display: none;
}
.cnt223 a{
text-decoration: none;
}
.popup{
width: 100%;
margin: 0 auto;
display: none;
position: fixed;
z-index: 101;
}
.cnt223{
min-width: 600px;
width: 600px;
min-height: 150px;
margin: 100px auto;
background: #ddd;
position: relative;
z-index: 103;
padding: 70px;
border-radius: 5px;
box-shadow: 0 2px 5px #000;
}
.cnt223 p{
clear: both;
color: #f94141;
text-align: justify;
}
.cnt223 p a{
color: #d91900;
font-weight: bold;
}
.cnt223 .x{
float: right;
height: 35px;
left: 22px;
position: relative;
top: -25px;
width: 34px;
}
.cnt223 .x:hover{
cursor: pointer;
}
</style>

<script type='text/javascript'>
$(function(){
// var overlay = $('<div id="overlay"></div>');
// overlay.show();
// overlay.appendTo(document.body);
$('.popup').show();
$('.close').click(function(){
$('.popup').hide();
overlay.appendTo(document.body).remove();
return false;
});
$('.x').click(function(){
	$('.popup').hide();
	overlay.appendTo(document.body).remove();
	return false;
	});
	});
	</script>

    </head>
    <body>
    <%if(message1!=null){ %>
   <div class='popup'>
<div class='cnt223'>
<img src='images/cancel.png' alt='quit' class='x' id='x' />
<p>
<%=message1%>
<br/>
<br/>
<a href='#' class='close' style="margin-right:250px">ok</a>
</p>
</div>
</div>
<%}else{} %>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
         <jsp:include page="./homeTop.jsp"></jsp:include>
            <!-- /.nav end -->
          
            <!-- service -->
            
               <%
               GetMechanicDetails mdetails=new GetMechanicDetails();
				String verifiedEmail=(String)session.getAttribute("user"); 
    int page1=0,noofrecords=0,maxrowsperpage=0,currentPage=0;
    try{
    	page1=Integer.parseInt(request.getAttribute("currentPage").toString());
    	maxrowsperpage=Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
    	currentPage=Integer.parseInt(request.getAttribute("currentPage").toString());
    }
    catch(Exception e)
    {
    
    }
    int k=(maxrowsperpage*page1)-maxrowsperpage;
    
    %>
            
            <section class="service-inner" style="background-color: #efefef;">
                <div class="container">
              <form action="./SearchHServiceCenter" method="post">
                    <div class="row" style="margin-top: 28px;">
                     <%
                     String city1=(String)request.getAttribute("city");
                     String vehicleType1=(String)request.getAttribute("vehicleType");
                     String vehicleBrand1=(String)request.getAttribute("vehicleBrand");
                     String street=(String)request.getAttribute("street");

                     
                      ArrayList<BusinessOwnerRegister> city=mdetails.getCity();
                      ArrayList<ServiceMechanic> vehicaleType=mdetails.getVehicleType();
                      Iterator typeit=vehicaleType.iterator();
                      Iterator it= city.iterator();
                     
                      %>
                        <div class="col-md-2 col-sm-6 col-xsm-12">
                  <label>City</label>
                       <!-- filters select -->
                 <div>
                   <select name="city" class="form-control" id="mcity" onchange="showServiceStreet(this.value)">
                   
					<option value="SELECT" style="display:none"><%=((city1==null?"city":city1.equals("null")?"city":city1.equals("SELECT")?"city":city1)) %></option>
					<option value="All">All</option>
					<%
					while(it.hasNext()){
						BusinessOwnerRegister bean=(BusinessOwnerRegister)it.next(); 
					%>
					<option value="<%=bean.getB_CITY() %>"><%=bean.getB_CITY() %></option>
					<% 
					}
					%>
														
					</select>
                 </div>                          
                
                   </div>
                   
                   <div class="col-md-2 col-sm-6 col-xsm-12">
                  <label>Location</label>
                       <!-- filters select -->
                 <div id="txtHint6">
                   <select name="street" class="form-control" id="street">
                   
					<option value="SELECT" style="display:none"><%=((street==null?"Location":street.equals("null")?"Location":street.equals("SELECT")?"Location":street)) %></option>
												
					</select>
                 </div>                          
                
                   </div>
                   
                   <div class="col-md-2 col-sm-6 col-xsm-12">
                <label>Vehicle Type</label>
                       <!-- filters select -->
                 <div>
                   <select name="vehicleType" class="form-control" id="vBrand" onchange="showVehicleBrand(this.value)">
                      <option value="SELECT" style="display:none;"><%=((vehicleType1==null?"Vehicle Type":vehicleType1.equals("null")?"Vehicle Type": vehicleType1.equals("2,")?"TWO WHEELER":vehicleType1.equals("4,")?"FOUR WHEELER":vehicleType1.equals("4,2,")?"All":"Vehicle Type")) %></option>
                       <option value="4,2,">All</option>
                       <option value="2,">TWO WHEELER</option>
                       <option value="4,">FOUR WHEELER</option>
                       

					</select>
                 </div>
                 </div>
                   <div class="col-md-2 col-sm-6 col-xsm-12">
                
                <label>Vehicle Brand</label>
                       <!-- filters select -->
                 <div id="txtHint3">
                   <select name="vehicleBrand" class="form-control">
                    <option value="SELECT" style="display:none"><%=((vehicleBrand1==null?"vehicle Brand":vehicleBrand1.equals("null")?"vehicle Brand":vehicleBrand1.equals("SELECT")?"vehicle Brand": vehicleBrand1)) %></option>
                    </select>
                 </div>
                </div>
                <div class="col-md-2 col-sm-6 col-xsm-12" style="margin-top:24px;">
                <button type="submit" class="btn btn-danger btn-block">Search</button>
                </div>
                </form>
               
                    </div>
                    
<br>
                    
                      <%
                      
                      if(vehicleType1!=null && vehicleType1.equals("2,")){
                     	 vehicleType1="TWO WHEELER";
                      } else if(vehicleType1!=null && vehicleType1.equals("4,")){
                     	 vehicleType1="FOUR WHEELER";
                      }else if(vehicleType1!=null && vehicleType1.equals("4,2,")){
                     	 vehicleType1="TWO WHEELER & FOUR WHEELER";
                      }
                      
                ArrayList mechanicDetails=(ArrayList)request.getAttribute("mechanicDetails");
                      if(mechanicDetails!=null && mechanicDetails.size()>0){
                Iterator itr= mechanicDetails.iterator();
                int i=1;int j=1;
                while(itr.hasNext()){
                	BusinessOwnerRegister bean1=(BusinessOwnerRegister)itr.next();
                	ServiceMechanic bean2=(ServiceMechanic)itr.next();
                	%>
  
                <section class="container">

	<div class="col-md-10 col-sm-12 col-xs-12  well" style="background-color: #fff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15); border-radius: 4px; margin-bottom: 7px; position: relative; right: 17px;margin-top: 0px;">
	
	<aside class="col-md-8">
		<div class="row">
		
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;;font-weight:500;">

          <div class="col-md-6 col-sm-12 col-xs-12"><span style="font-weight:600;color:#000;font-size:15px;"><%=bean1.getBUSINESS_NAME() %> </span> </div>
          
         				 <%
                        String suser=bean1.getEMAIL_ID();
                        float rate=mdetails.getRate(suser);
                        %>
          <div class="col-md-2 col-sm-12 col-xs-12"><span><font style="color:#3c763d;font-size:15px;"><b>Rating:</b></font></span></div>
          <div class="col-md-4 col-sm-12 col-xs-12"><span class="stars"><%=rate %><span style="width: 16px;"></span></span></div>
	
                        
                        
                        
                        

             

                        </div> 
		</div>
		
		<%if(vehicleType1.equals("SELECT")){ %>
		<div class="row">
		<div class="col-md-12 col-xs-12 col-sm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
		<div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">Vehicle Type:</span></div>
        <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=(bean1.getVEHICLE_TYPE().equals("2,"))?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals("4,2,"))?"TWO WHEELER & FOUR WHEELER":"N/A"%></span></div>
		
		</div>
		</div>
		<% }else{%>
		<div class="row">
		<div class="col-md-12 col-xs-12 col-sm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
		<div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">Vehicle Type:</span></div>
        <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=(bean1.getVEHICLE_TYPE().equals("2,"))?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals(vehicleType1))?"TWO WHEELER & FOUR WHEELER":vehicleType1 %></span></div>
		
		</div>
		</div>
		<%} %>
		
		<div class="row">
		<div class="col-md-12 col-xs-12 col-sm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
		<div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">Brand:</span></div>
        <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=bean2.getVEHICLE_BRAND()==null?"N/A":bean2.getVEHICLE_BRAND() %></span></div>
		
		
		
		</div>
		</div>
		  <div class="row">
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
             <div class="col-md-3 col-sm-6 col-sm-6"><span style="color: #555;font-weight: 600;">Address:</span></div>
             <div class="col-md-9 col-sm-6 col-sm-6"><span style="text-transform: lowercase;"><%=bean1.getADDRESS()+","+bean1.getLOCATION() %></span>
           </div>


		
			
			</div>

		</div>
   <div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
    <div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">City:</span></div>
      <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=bean1.getB_CITY() %></span></div>

	
	</div>

     </div>
       <div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
     <div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">State:</span></div>
      <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=bean1.getSTATE() %></span></div>

	
	

	</div>
	
         </div>
          <div class="row">

          
	        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">
	        <div class="col-md-3 col-xs-12 col-sm-6"><span style="color: #555;font-weight: 600;">Verified:</span></div>
          <div class="col-md-9 col-xs-12 col-sm-6"><span style="text-transform: lowercase;"><b><%=bean1.getVERIFIED() %></b></span></div>
	        

	        </div>
	
            </div>
               <div class="row">
	
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">

     <div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">Email Address:</span></div>
     <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=bean1.getEMAIL_ID() %></span></div>
	


	</div>
	
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;">

     <div class="col-md-3 col-sm-6 col-xs-12"><span style="color: #555;font-weight: 600;">Phone Number:</span></div>
     <div class="col-md-9 col-sm-6 col-xs-12"><span style="text-transform: lowercase;"><%=bean1.getOFFICE_PHONE_NO()==null?"N/A":bean1.getOFFICE_PHONE_NO()+" , "%><%=bean1.getMOBILE_NO()==null?"N/A":bean1.getMOBILE_NO().equals("NA")?"":bean1.getMOBILE_NO()%></span></div>
	


	</div>
             </div>
     
        <div class="row">
        <div class="col-md-4" id="m1">
<!--         	<button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large" style="background: #fec107;color: white;" >Service Type</button> -->
  <div class="w3-container" style="padding:0px;">
<button onclick="document.getElementById('id0<%=i %>').style.display='block'" class="btn-primary w3-large" style="margin-bottom:4px;color: white;width: 160px;">Service Type</button>

  <div id="id0<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:700px">

      <div class="w3-center"><br><br>
        <span onclick="document.getElementById('id0<%=i %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
     <div align="center"> <font color="#009" size="4"><%=bean1.getBUSINESS_NAME() %></font></div>
                        <%
//                         String retval: str.split(",")
                        String str=((bean2.getSERVICE_TYPE()==null)?"N/A":bean2.getSERVICE_TYPE());
                        String price=((bean2.getPRICE()==null)?"N/A":bean2.getPRICE());
                        String descount=((bean2.getDISCOUNT()==null)?"N/A":bean2.getDISCOUNT());
                        String str2=((bean2.getFINAL_PRICE()==null)?"N/A":bean2.getFINAL_PRICE());
                        String desc=((bean2.getSERVICE_DESCRIPTION()==null)?"N/A":bean2.getSERVICE_DESCRIPTION());
                        
                        String[] price1=price.split(",");
                        String[] descount1=descount.split(",");
                        String[] desc1=desc.split("\\|");
                        String[] str1=str.split(",");
                        String[] str3=str2.split(",");
                        int n=1;
                       if(n<str1.length){
                       for (int x=0,y=0,z=0,p=0,q=0; x<str1.length || y<str3.length || z<desc1.length || p<price1.length || q<descount1.length ; x++,y++,z++,p++,q++)
                       {
                      
                    	%> 
				       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12  " style="margin-top: 10px;font-size: 12px;margin-bottom: 5px;">&nbsp;&nbsp;
				       <%if(p<str1.length){ %>
				       <span style="color:#000;font-size:17px;"><u><%=str1[x] %></u></span>&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
				       <%}else{ %>
				       <span ></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%="N/A"%></span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
				        <%} %>
				       </div>
				       <div class="col-md-12 col-xs-12 col-sm-12">
				       <%if(p<price1.length){ %>
				      <span >Price</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%=price1[p] %></span>&nbsp;&nbsp;|&nbsp;&nbsp;
				       <%}else{ %>
				       <span >Price</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%="N/A"%></span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
				       <%} %>
				        <%if(q<descount1.length){ %>
				      <span >Discount</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%=descount1[q] %></span>&nbsp;|
				       <%}else{ %>
				       <span >Discount</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%="N/A"%></span>&nbsp;|
				       <%} %>
				       <%if(y<str3.length){ %>
				      <span >Total Price</span>&nbsp;&nbsp;:<span class="text-primary"><%=str3[y] %></span>&nbsp;|
				       <%}else{ %>
				       <span >Total Price</span>&nbsp;&nbsp;:<span class="text-primary"><%="N/A"%></span>&nbsp;|
				       <%} %>
				        <%if(z<desc1.length){ 
				        String	desc2[]=desc1[z].split("\\.");
				        %>
				      <span >Description</span>&nbsp;&nbsp;:&nbsp;&nbsp;
				      <% for(String desc3:desc2){%>
				      <span class="text-primary"><%=desc3 %></span>
 				       <%}%>
				      
				       <% }else{ %> 
 				   		<span >Description</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class="text-primary"><%="N/A" %></span><br><br>
 				   <%} %><br><br>
				       </div>
					<%} %>
					 <%}else{ %> 
 				       <span style="color:red;font-size:15px;">Service Type is not available if it is your service center please <a href="./register.jsp"><font color="blue" font-size="3">register</font></a> here and update your contact details</span>
 				       <%} %>
 				       
 				       
                     <!--    </section> -->
                      <!--  </div>  -->
                         <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="background-color: #fff">
        <button onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
      </div>
    </div>
  </div>
  </div>
  

        </div>
        

        
        <div class="col-md-4" id="m1">
<!--         	<button onclick="document.getElementById('id1').style.display='block'" class="w3-button w3-green w3-large " style="background: #fec107;color: white;" >Book Appointment</button> -->

<%if(bean1.getVERIFIED()!=null && bean1.getVERIFIED().equals("YES")){ %>
  <div class="w3-container" style="padding:0px">
 <button onclick="document.getElementById('id<%=j %>').style.display='block'" class="btn-primary w3-large" style="margin-bottom:4px;color: white;width: 160px;">Book Appointment</button>

  <div id="id<%=j %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id<%=j %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertServiceEndUserDetails" method="post">
      
      <input type="hidden" name="vehicleType" value="<%=vehicleType1==null?"":(vehicleType1.equals("TWO WHEELER"))?"2,":(vehicleType1.equals("FOUR WHEELER"))?"4,":(vehicleType1.equals("TWO WHEELER & FOUR WHEELER"))?"4,2,":""%>"/>
      <input type="hidden" name="city" value="<%=city1%>"/>
      <input type="hidden" name="vehicleBrand" value="<%=vehicleBrand1%>"/>
      <input type="hidden" name="street" value="<%=street%>"/>
      <input type="hidden" name="page" value="<%=currentPage%>"/>
      
      <input type="hidden" name="emailId" value="<%=bean1.getEMAIL_ID()%>" id="emailId<%=i%>"/>
      
<%--        <font color="red" size="4" face="Times New Roman">if you are existing user <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'">Login Here</a></font><br>
      <font color="red" size="4" face="Times New Roman">if you are existing user <a onclick="window.open('./login3.jsp','mywindow','width=1000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no')"><u>login here..</u></a></font><br>
      
      <input type="hidden" name="vehicleType1" value="<%=bean1.getVEHICLE_TYPE()%>"/>
	<%=(bean1.getVEHICLE_TYPE().equals("2,"))?"TWO WHEELER":(bean1.getVEHICLE_TYPE().equals("4,"))?"FOUR WHEELER":(bean1.getVEHICLE_TYPE().equals("4,2,"))?"TWO WHEELER & FOUR WHEELER":"N/A"%> --%>
       
       <font color="660033" size="4" face="Times New Roman"><%=bean1.getBUSINESS_NAME() %></font><br><br>
       
            <%
        Date dNow = new Date( );
        SimpleDateFormat ft = 
        new SimpleDateFormat ("yyyy-MM-dd");
     %>
       
        <%
        GetMechanicDetails sbrand=new GetMechanicDetails();
        ArrayList<ServiceMechanic> vbrand=sbrand.getVehicleBrand(bean1.getVEHICLE_TYPE());
        Iterator vit=vbrand.iterator();
        %>
  		<%
  		ServiceEndUser endUser=null;
        if(verifiedEmail!=null){
        	ArrayList<ServiceEndUser> serviceEndUser=sbrand.getEndUserDetails(verifiedEmail);
        	if(serviceEndUser!=null && serviceEndUser.size()>0){
        	endUser=serviceEndUser.get(0);
        	}
        	
        }
        %>
        <div class="w3-section">
           <label><b>Vehicle Type</b></label>
        <select name="vehicleType1" id="vehicleBrand" class="w3-input w3-border w3-margin-bottom" required>
        <option value="<%=endUser==null?"":endUser.getVEHICLE_TYPE()==null?"":endUser.getVEHICLE_TYPE()%>" style="display:none;"><%=endUser==null?"Vehicle Type":endUser.getVEHICLE_TYPE()==null?"Vehicle Type":endUser.getVEHICLE_TYPE().equals("2,")?"TWO WHEELER":endUser.getVEHICLE_TYPE().equals("4,")?"FOUR WHEELER":"Vehicle Type" %></option>
    
        	<option value="2,">TWO WHEELER</option>
        	<option value="4,">FOUR WHEELER</option>
       
        </select>
        <label><b>Vehicle Brand</b></label>
        <select name="evehicleBrand" id="vehicleBrand" class="w3-input w3-border w3-margin-bottom" onchange="showServiceModal(this.value,emailId<%=i%>)">
        <option value="<%=endUser==null?" ":endUser.getVEHICLE_BRAND()==null?" ":endUser.getVEHICLE_BRAND() %>" style="display:none;"><%=endUser==null?"Vehicle Brand":endUser.getVEHICLE_BRAND()==null?"Vehicle Brand":endUser.getVEHICLE_BRAND() %></option>

        <%
        while(vit.hasNext()){
        	ServiceMechanic bean=(ServiceMechanic)vit.next();
        	%>
        	<option value="<%=bean.getBRAND()%>"><%=bean.getBRAND()%></option>
        <% 	
        }
        %>
        </select>
         <div id="txtHint"><label><b>Vehicle Modal</b></label>
        <select name="model" id="model" class="w3-input w3-border w3-margin-bottom">
        <option  value="<%=endUser==null?" ":endUser.getMODEL()==null?" ":endUser.getMODEL() %>" style="display:none;"><%=endUser==null?"Vehicle Model":endUser.getMODEL()==null?"Vehicle Model":endUser.getMODEL() %></option>
        </select></div>
          <label><b>Name</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Username" value="<%=endUser==null?"":endUser.getNAME()==null?"User Name":endUser.getNAME() %>" name="name"  required>
         <%if(verifiedEmail!=null){ %>
          <%} else{%>
          <label><b>Email</b></label>
          <input class="w3-input w3-border" type="email" placeholder="Email" name="email" value="<%=endUser==null?"":endUser.getEMAIL()==null?"Email":endUser.getEMAIL() %>" required>
           <%} %>
           <label><b>Mobile No</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Mobile No" name="mobileNo" value="<%=endUser==null?"":endUser.getMOBILE_NO()==null?"Mobile Number":endUser.getMOBILE_NO() %>" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" required maxlength="10">
          <label><b>Vehicle No</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Vehicle No" name="carNo" value="<%=endUser==null?"":endUser.getCAR_NO()==null?"Vehicle Number":endUser.getCAR_NO() %>" required>
           <label><b>Date Of Appointment</b></label>
          <input class="w3-input w3-border" type="date"  placeholder="Date" name="date" value="<%=endUser==null?"":endUser.getAPPOINTMENT_DATE()==null?"Date":endUser.getAPPOINTMENT_DATE() %>" min="<%=ft.format(dNow)%>" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Select date';}" required>
           
            <%if(verifiedEmail!=null){ %>
          <%} else{%>
          
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password"  placeholder="Password" name="psw" required>
          <%} %>
          
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Submit</button>
          
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id<%=j %>').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>

        </div>
        
       
        <div class="col-md-4" id="m1">
<!--         	<button onclick="document.getElementById('idr1').style.display='block'" class="w3-button w3-green w3-large" style="background: #fec107;color: white;" >Rate</button> -->

<div class="w3-container" style="padding:0px;">
 <button onclick="document.getElementById('idr<%=j %>').style.display='block'" class="btn-primary w3-large" style="margin-bottom:4px;color: white;width: 160px;">Rate</button>

  <div id="idr<%=j %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('idr<%=j %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertServiceRating" method="post">
      <input type="hidden" name="vehicleType" value="<%=vehicleType1==null?"SELECT":(vehicleType1.equals("TWO WHEELER"))?"2,":(vehicleType1.equals("FOUR WHEELER"))?"4,":(vehicleType1.equals("TWO WHEELER & FOUR WHEELER"))?"4,2,":"SELECT"%>"/>
      <input type="hidden" name="city" value="<%=city1%>"/>
      <input type="hidden" name="vehicleBrand" value="<%=vehicleBrand1%>"/>
      <input type="hidden" name="street" value="<%=street%>"/>
       <input type="hidden" name="remailId" value="<%=bean1.getEMAIL_ID()%>"/>
       <input type="hidden" name="page" value="<%=currentPage%>"/>
        <div class="w3-section">
        <font color="660033" size="4" face="Times New Roman"><%=bean1.getBUSINESS_NAME() %></font><br><br>
        
        <label><b>Rate</b></label>
        <select name="rate" id="model" class="w3-input w3-border w3-margin-bottom">
        <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
        </select>
  		<%if(verifiedEmail!=null){ %>
          <%} else{%>
           <label><b>Email Id</b></label>
          <input class="w3-input w3-border" type="email"  placeholder="Email" name="email" value="<%=endUser==null?"":endUser.getEMAIL()==null?"Email":endUser.getEMAIL() %>"  required>
          
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Password" name="psw" required>
         <%} %>
          <label><b>Vehicle No</b></label>
          <input class="w3-input w3-border" type="text"  placeholder="Vehicle No" name="vehicleNo" value="<%=endUser==null?"":endUser.getCAR_NO()==null?"Vehicle Number":endUser.getCAR_NO() %>" required>
          
           <label><b>Appointment Id</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Appointment Id" name="appId" required>
          
          
          
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Submit</button>
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('idr<%=j %>').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>
<%}else{} %>


        </div> 

              <!-- <div class="col-md-5"></div> -->



	</aside>
	<aside class="col-md-4 col-sm-12 col-xs-12" align="right">
		<div class="row">
			
			<%if(bean1.getPHOTO()!=null && !bean1.getPHOTO().equals("null") && !bean1.getPHOTO().equals("")){ %>
             			<a href="#" style="cursor: pointer;"><img class="img-thumbline" src="data:image/png;base64,<%=bean1.getPHOTO() %>" alt="No image" style="width:60%;height:200px;margin-bottom:0px;"></a>
             			<%}else{ %>
             			
             			 <a href="#" style="cursor: pointer;"><img class="img-thumbline" src="./images/ServiceImage.png" alt="No image" style="width:60%;height:200px;margin-bottom: 0px;"></a>
             			
             			<%} %>
			
		</div>
	</aside>
	</div>
</section>    
                    
                    
                      
              
       <%i++;j++;}%>
             	<section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-left: 0px;background-color: #fff;margin-top: 0px;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-radius: 5px;">
             			Pages:&nbsp;
                 	<c:forEach begin="1" end="${noOfPages}" var="k">
				
<%-- 				<td style="float: left" ><a href="./SearchHServiceCenter?page=${k}&city=<%=city1%>&vehicleType=<%=vehicleType1%>&vehicleBrand=<%=vehicleBrand1%>">${k}&nbsp;&nbsp; </a></td> --%>
			
						<c:set var="currentPage" value="${currentPage}"></c:set>
             			<c:set var="noOfPages" value="${k}"></c:set>
             			
             			<%
             			Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
             			if(currentPage1.equals(noOfPages)){
             			%>
				<a href="./SearchHServiceCenter?page=${k}&city=<%=city1%>&vehicleType=<%=vehicleType1%>&vehicleBrand=<%=vehicleBrand1%>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>
             			<%} else{%>
             			
				<a href="./SearchHServiceCenter?page=${k}&city=<%=city1%>&vehicleType=<%=vehicleType1%>&vehicleBrand=<%=vehicleBrand1%>">${k}&nbsp;</a>
 				<%} %>
			
			</c:forEach>
			</section>
        <%}else{if(mechanicDetails==null){%>
        
        <!-- <section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 0px;margin-bottom: 10px;">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"></div>
                    </section> -->
        
        <%}else{ %>
        
         <section class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="height:200px;background: #f5f5f5;border-radius: 5px;margin-top: 0px;margin-bottom: 10px;">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 10px;font-size: 18px;margin-bottom: 5px;"><span style="font-weight:600;color:red">Data not found.....</span></div>
                    </section>
        
        <%	
        }}
       %>
       		
       </section>
                </div>
            
            <!-- blog section -->
            
            <!-- Newsletter -->
            <section class="get-offer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <span>Subscribe to our Newsletter</span>
                            <h2>& Discover the best offers!</h2>
                        </div>
                        <div class="col-sm-7">
                            <div class="input-group">
<!--                                 <input type="text" class="form-control" placeholder="Enter Your Email" name="q"> -->
                                <div class="input-group-btn">
<!--                                     <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button> -->
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>
       <!-- Footer Section -->
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
        <!-- jQuery -->
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <!-- jquery ui js -->
        <script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!-- bootstrap js -->
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- fraction slider js -->
        <script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
        <!-- owl carousel js --> 
        <script src="assets/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
        <!-- counter -->
        <script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
        <script src="assets/js/waypoints.js" type="text/javascript"></script>
        <!-- filter portfolio -->
        <script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
        <script src="assets/js/portfolio.js" type="text/javascript"></script>
        <!-- magnific popup -->
        <script src="assets/js/jquery.magnific-popup.min.js" type="text/javascript"></script>
        <!-- range slider -->
        <script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
        <script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
        <!-- custom -->
        <script src="assets/js/custom.js" type="text/javascript"></script>
        
     <script type="text/javascript">
     
     $('input[type="text"]').keyup(function() {
    	    var col_name = $(this).attr('class');
    	    var search_val = $(this).val().toLowerCase();
    	    $('.' + col_name).closest('.content-wrap').css('display', 'none');
    	    $('.' + col_name).each(function() {
    	        console.log($(this).text(), 'text');
    	        var val = $(this).text();
    	        if(val.toLowerCase().indexOf(search_val) >= 0) {
    	            $(this).closest('.content-wrap').css('display', 'block');
    	        }
    	        
    	    });
    	    //$('.' + col_name).closest('.content-wrap').style('display', 'none');
    	});
     
     </script>   
     
     
     
<script>
function showServiceModal(str,email)
{
 	var email=email.value;
	if (str=="")  
	{  
		document.getElementById("txtHint").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("POST","./getServiceModal.jsp?sBrand="+str+"&email="+email,true);   
	xmlhttp.send();    
	}
	</script>



      <script>
function showVehicleBrand(str)
{
 	// var city=document.getElementById("mcity").value;
	if (str=="")  
	{  
		document.getElementById("txtHint3").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint3").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./vehicleBrand.jsp?vBrand="+str,true);   
	xmlhttp.send();    
	}
	</script>
	
      <script>
function showServiceStreet(str)
{
 	// var city=document.getElementById("mcity").value;
	if (str=="")  
	{  
		document.getElementById("txtHint6").innerHTML="";  
		return;  
		}  
	if (window.XMLHttpRequest)  
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari  
		xmlhttp=new XMLHttpRequest();  
		}
	else  
	{
		// code for IE6, IE5  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
		}
	xmlhttp.onreadystatechange=function()  
	{  
		if (xmlhttp.readyState==4 && xmlhttp.status==200)    
		{    
			document.getElementById("txtHint6").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getServiceStreet.jsp?street="+str,true);   
	xmlhttp.send();    
	}
	</script>
         
         <script type="text/javascript">
         
         $.fn.stars = function() {
        	    return $(this).each(function() {
        	        // Get the value
        	        var val = parseFloat($(this).html());
        	        // Make sure that the value is in 0 - 5 range, multiply to get width
        	        var size = Math.max(0, (Math.min(5, val))) * 16;
        	        // Create stars holder
        	        var $span = $('<span />').width(size);
        	        // Replace the numerical value with stars
        	        $(this).html($span);
        	    });
        	}
         $(function() {
        	    $('span.stars').stars();
        	});
         </script>
	 
    </body>
</html>