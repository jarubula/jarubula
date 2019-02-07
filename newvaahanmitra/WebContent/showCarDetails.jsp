<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>car details</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">

		<!-- Bootstrap CSS -->
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>     
       
       <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
		
	</head>
	<body>
	<nav id="mainNav" class="navbar navbar-fixed-top affix-top" style="background: #523f6d;">
		<jsp:include page="./homeTop.jsp"></jsp:include>
	</nav>
	<br>

<br>
		<section class="container to col-lg-12" style=" background: #ffffff none repeat scroll 0 0; margin-top: 50px; margin-bottom: 50px;
    padding: 40px 30px !important;
    position: relative;
   
    color: #333333;
    font-family: open sans;">
    
    <%
			String carId = (String) request.getParameter("cid");
			GetUsedCarDetails carDetails = new GetUsedCarDetails();
			UsedCar car = carDetails.getUsedCarDetails(carId);
			String message = (String)request.getAttribute("message");
			String id = (String)request.getAttribute("id");
		%>
		<%if(id!=null){ %>
    		<div align="center"><h4 style="color:green"><%=message%></h4></div>
			<%}else{} %>
			<aside class="col-md-12 col-lg-12" align="center">
				<h1 class="text-info">CAR DETAILS</h1>

			</aside>
			<aside class="col-md-4" style="margin-top:46px">
            <b>REQUESTED CAR ID:&nbsp;&nbsp;<spann class="" style="color:red"><%=car.getGEN_CAR_ID()%></spann></b><br>
            <br>
           
            <img class="img-rounded" width="100%" style="height:200px" src="data:image/png;base64,<%=car.getPHOTO1()%>" alt="No Image"/>				
			</aside>
			<aside class="col-md-8">
				<div style="overflow-x:auto;">
                <br>
                <br>
                 <table class="table table-hover">
                  <thead>
                  	 <tr>
                            <th class="col-md-3 col-md-12" ><span class="text-primary"></span> </th>
                            <td class="col-md-3 col-md-12"></td>
                        	 <th >OFFER PRICE</th>
                           <td><b><span class="text-danger" style="color:red">&#8377;&nbsp;&nbsp;<%=car.getOFFER_PRICE()%></span></b></td>
                        </tr>
                  </thead>
                    <tbody>
                        <tr>
                         <th class="col-md-3 col-md-12">BRAND</th>
                         <td class="col-md-3 col-md-12"> <%=car.getCAR_BRAND()%></td>
                           <th class="col-md-3 col-md-12">MODEL</th>
                         <td class="col-md-3 col-md-12"> <%=car.getCAR_MODEL()%></td>
                        </tr>
                        <tr>
                         <th class="col-md-3 col-md-12">COLOR</th> 
                           <td class="col-md-3 col-md-12"><%=car.getCOLOR()%></td>
                           <th class="col-md-3 col-md-12">FULL TYPE</th>
                         <td class="col-md-3 col-md-12"><%=car.getFUEL_TYPE()%></td>
                        </tr>
                        <tr>
                        	<th class="col-md-3 col-md-12">CURRENT MILEAGE</th>
                        	<td class="col-md-3 col-md-12"><%=car.getCURRENT_MILEAGE()%></td>
                        	<th class="col-md-3 col-md-12">TRANSMISSION</th>
                        	<td class="col-md-3 col-md-12"><%=car.getTRANSIMISSION()%></td>
                        </tr>
                        <tr>
                        	<th class="col-md-3 col-md-12">MODEL YEAR</th>
                             <td class="col-md-3 col-md-12"><%=car.getMODEL_YEAR()%></td>
                           <th class="col-md-3 col-md-12">BODY TYPE</th>
                        	<td class="col-md-3 col-md-12"><%=car.getBODY_TYPE()%></td>
                        </tr>
                         <tr>
                         	<th class="col-md-3 col-md-12">KMS DRIVEN</th>
                         	<td class="col-md-3 col-md-12"><%=car.getKMS_DRIVEN()%></td>
                           <th class="col-md-3 col-md-12">CITY</th>
                        	<td class="col-md-3 col-md-12"><%=car.getCITY()%></td>
                         </tr>
                        <tr>
                        	<th class="col-md-3 col-md-12">REGISTERED YEAR</th>
                             <td class="col-md-3 col-md-12"><%=car.getREGISTERED_YEAR()%></td>
                           <th class="col-md-3 col-md-12">REGISTERED STATE</th>
                        	<td class="col-md-3 col-md-12"><%=car.getREGISTERED_STATE()%></td>
                        </tr>
                    </tbody>

                </table>


            </div>
			</aside>
		</section>
		<div style="background: #000">
            <div class="container">
                   

                <div class="row">
                    <!-- Address -->
                    <div class="col-sm-4 col-md-3">
                        <div class="footer-box address-inner">
                            <h4 style="color:#fff;">Vaahan<span style="color:#fec107 ">Mitra</span> </h4>
                            <div class="address">
                                <i class="flaticon-placeholder"></i>
                                <p>Unit - 602, Level 6,<br>
                                    Manjeera Majestic Commercial,<br>
                                   Hi-Tech City Road,KPHB,<br>
                                    Hyderabad - 500072<br>
                                    Telangana<br>
                                    India
                                </p>
                            </div>
                            <div class="address">
                                <i class="flaticon-customer-service"></i>
                                <p>040 - 40191909</p>
                            </div>
                            <div class="address">
                                <i class="flaticon-mail"></i>
                                <p>info@vaahanamitra.com</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8 col-md-6">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 style="color: #fff">Information</h4>
                                    <ul class="categoty">
                                        
                                        <li><a href="#">About us</a></li>
                                        <li><a href="#">Online Enquiry</a></li>
                                        <li><a href="#">Call us</a></li>
                                        <li><a href="#">Terms and Conditions</a></li>
                                        <li><a href="#">Privacy &amp; Cookies Policy</a></li>
                                        <li><a href="#">Become a partner</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 style="color: #fff">Our Parteners</h4>
                                    <ul class="categoty">
                                        <li><a href="#">Campusguide.in</a></li>
                                        <li><a href="#">Rythumitra.in</a></li>
                                        <li><a href="#">Frytemate.com</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="footer-box">
                                    <h4 style="color: #fff">Links</h4>
                                    <ul class="categoty">
                                        <li><a href="#">car&amp;bike in Hyderabad</a></li>
                                        <li><a href="#">car&amp;bike in Bangalore</a></li>
                                        <li><a href="#">car&amp;bike in Chennai</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="sub-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <p>Copyright © 2017. All rights reserved</p>
                        </div>
                        <div class="col-sm-7">
                            <div class="footer-menu">
                                <ul>
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Service</a></li>
                                    <li><a href="#">Blog</a></li>
                                    <li><a href="#">Shop</a></li>
                                    <li><a href="#">Forum</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
  
	</body>
</html>