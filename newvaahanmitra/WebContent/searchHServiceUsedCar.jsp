<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%
String message1 = (String) request.getAttribute("message");
//	String bikeId = (String) request.getAttribute("bikeId");
//	if (message1 != null) {
%>
<title>VaahanMitra | cheap used cars - old cars for sale | used cars for sale</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<link href="http://www.vaahanmitra.com/searchHServiceUsedCar.jsp" rel="canonical" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<style type="text/css">

#overlay {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
 <%if(message1!=null){ %>
 background-color: #000; 
 <%}%>
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
/*     width: 601px; */
    /* min-height: 190px; */
    top: 90px;
    height: 199px;
    margin: 100px auto;
    background: rgb(255, 255, 255);
    position: relative;
    z-index: 149px;
    padding: 50px;
    border-radius: 15px;
    box-shadow: 0 1px 30px;
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
    height: 34px;
    left: 49px;
    position: relative;
    top: -47px;
    width: 34px;
}
.cnt223 .x:hover{
cursor: pointer;
}
.content {
    padding: 0px;
    background: #f8f8f8;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 0px !important;
    border: 1px solid transparent;
}
</style>
<script type='text/javascript'>
$(function(){
	 <%if(message1!=null){ %>
 var overlay = $('<div id="overlay"></div>');
 overlay.show();
 overlay.appendTo(document.body);
 <%}%>
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
    <%if(message1!=null){ %>
  <div class='popup container'>
   <div class="col-md-5 col-sm-6"></div>
   <div class="col-md-6 col-sm-6">
<div class='cnt223 ' align="center">
<img src='images/cancel.png' alt='quit' class='x' id='x' />
<p>
<%=message1%>
<br/>
<br/>
<!-- <a href='#' class='close'> <img src='images/OK.jpg' alt='quit' class='x' id='x' /></a> -->
</p>
</div>
</div>

</div>
<%}else{} %>




<script type="text/javascript">
	function yesno(thecheckbox, thelabel) {
		var checkboxvar = document.getElementById(thecheckbox);
		var labelvar = document.getElementById(thelabel);
		if (checkboxvar.checked == false) {
			alert("ARE YOU SURE ACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "ACTIVE";
			labelvar.style.color = "black";
		} else {
			alert("ARE YOU SURE INACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "INACTIVE";
			labelvar.style.color = "red";
		}
	}
</script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        <%--  <% 
	String message = (String) request.getAttribute("message");
         if(message!=null){ %>
         <div class='popup'>
      <div class='cnt223'>
      <img src='images/cancel.png' alt='quit' class='x' id='x' />
      <p>
      <%=message%>
      <br/>
      <br/>
      <a href='#' class='close'>Close</a>
      </p>
      </div>
      </div>
      <%}else{} %> --%>
<script type="text/javascript">

function callMe(myId) {
 	var popup1=window.open('./DisplayCarImage.jsp?photo='+myId,'mywindow','width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no')
/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */
}

</script>
 <script type="text/javascript">
 alert=function(){}
 function getCheckedCheckboxesFor(checkboxName) {
	 
	 var checkboxes = document.getElementsByName(checkboxName);
	 
 var value1=[];

 for (var i=0; i<checkboxes.length; i++) {
	 
     if (checkboxes[i].checked) {
    	 
//     	 document.getElementById('checkboxName').appendChild(document.getElementById('hiddenArea'));
    	
        value1.push(checkboxes[i].value);
      
     }
  }
 if(value1.length>1&&value1.length<4){
	 
	 
	 
// 	 location.href="CompareUsedCar?compare="+value1;
var n=window.open("CompareUsedCar?compare="+value1,"myWin", "left=700, top=200, width=850, height=700");
 }else if(value1.length<2){
	
	/*  alert("please select maximum 3 checkboxes to compare your selection.."); */
	 document.getElementById("msg").innerHTML = "please select maximum 3 Cars <br>to compare your selection..";
	  
 }else if(value1.length>3){
	 
// 	 alert("you can not select more than  3 checkboxes to compare your selection..");
	 document.getElementById("msg").innerHTML = "you can not select more than  3 Cars <br>to compare your selection..";
	  
	  
 }
 return value1;

 }

</script>
        
        <style>
input[type=checkbox] {
    display: block;
    width: 30px;
    height: 30px;
    background-repeat: no-repeat;
    background-position: center center;
    background-size: contain;
    -webkit-appearance: none;
    outline: 0;
}
input[type=checkbox]:checked {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"><path id="checkbox-3-icon" fill="#000" d="M81,81v350h350V81H81z M227.383,345.013l-81.476-81.498l34.69-34.697l46.783,46.794l108.007-108.005 l34.706,34.684L227.383,345.013z"/></svg>');
}
input[type=checkbox]:not(:checked) {
    background-image: url('data:image/svg+xml;utf8,<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"> <path id="checkbox-9-icon" d="M391,121v270H121V121H391z M431,81H81v350h350V81z"></path> </svg>');
}
  </style>
    </head>
    <body>
    
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
         <jsp:include page="./homeTop.jsp"></jsp:include>
            <!-- /.nav end -->
            <!-- page header -->
            <!-- hotel -->
            <section class="tour-inner" >
                <div class="container"  >
                    <div class="row" style="margin-top: 17px;">
<%--                         <% --%>
<!-- 							String message2 = (String) request.getAttribute("message"); -->
<!--  							String carId = (String) request.getAttribute("carId"); -->
<!-- 							System.out.println("carId"+carId); -->
<!-- 						if (message1 != null) { -->
<%-- 						%> --%>
<%-- 						<center><h6 style='color:red'><b><%= message2 %></b></h6></center> --%>
<%-- 						<% } else {}%> --%>
                        <!-- collapse map -->
                        <div class="col-sm-12">
                            <div class="collapse" id="collapseMap">
                                <!-- The element that will contain Google Map. This is used in both the Javascript and CSS above. --> 
                                <div id="map"></div>
                            </div>
                        </div>
                        <!-- sideber -->
                        <%
    int page1=0,noofrecords=0,maxrowsperpage=0;
    try{
     page1=Integer.parseInt(request.getAttribute("currentPage").toString());
     maxrowsperpage=Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
    }
    catch(Exception e)
    {
    
    }
    int k=(maxrowsperpage*page1)-maxrowsperpage;
    %>
                        <div class="col-sm-4 col-md-3">
                            <!-- price pips -->
                                <form action="./SearchUsedCar" method="post">
                            <div class="sidber-box cats-price">
                                <div class="cats-title">Price</div>
                                <div class="price-Pips">
<!--                                     <input type="text" id="range" value="range" name="range" onchange="this.form.submit()"/> -->
										          <div class="select-filters" style="margin-bottom: 5px;">
										          <%String range=(String)request.getAttribute("range"); %>
										           <select name="lHPrice" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=range==null?"Price":range.equals("0")?"LOW-HIGH":range.equals("1")?"HIGH-LOW":"Price"%></option>
                                                <option value="0">LOW-HIGH</option>
                                                <option value="1">HIGH-LOW</option>
                                            </select>
                                            </div>
                                </div>
                            </div>                           
                            <!-- Facility -->
                            <div class="sidber-box cats-facility">
                                <div class="cats-title">
                                    Filter
                                </div>
                                <div class="facility">
                                     				
                                     				<%
                                   					String city1=(String)request.getAttribute("city");
                                     				String carBrand1=(String)request.getAttribute("carBrand");
                                     				String carModel=(String)request.getAttribute("carModel");
                                     				String carAge=(String)request.getAttribute("carAge");
                                     				String color=(String)request.getAttribute("color");
                                     				String fuelType=(String)request.getAttribute("fuelType");
                                     				String kms=(String)request.getAttribute("kms");
                                     				String transmission=(String)request.getAttribute("transmission");
                                     				String budget=(String)request.getAttribute("budget");
                                     				String message=(String)request.getAttribute("message");
                                     				
                                                    GetUsedCarDetails carBudget=new GetUsedCarDetails();
                                                    ArrayList<UsedCar> carCity=carBudget.getUsedCarCity();
                                                    Iterator itr= carCity.iterator();
                                                    %>
                                        
  
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="carBrand" id="sort-price" id="brand" onchange="showBrand(this.value)">
                                                <option  style="display:none;" value="SELECT"><%=((carBrand1==null?"Brand":carBrand1))%></option>
                                                <option  value="All">All</option>
                                                <%
											GetUsedCarDetails carBrand=new GetUsedCarDetails();
											ArrayList<UsedCar> carBnd=carBrand.getUsedCarBrand();
											%>
                                                <%
													Iterator it= carBnd.iterator();
													while(it.hasNext()){
														UsedCar usedCar=(UsedCar)it.next();
														%>
                                                <option><%=usedCar.getCAR_BRAND()%></option>
                                                <%
													}
													%>
                                            </select>
                                        </div>
                                            <div class="select-filters" style="margin-bottom: 5px;" id="txtHint1">
                                           <select name="carModel" class="form-control">
															 <option value="SELECT" style="display:none;"><%=((carModel==null?"Model":carModel)) %></option>
															 </select>
                                        </div>
                                        
                                            <div class="select-filters" style="margin-bottom: 5px;">
                                    <select name="carBudget" id="sort-price">
                                                <option style="display:none;" value="SELECT">Budget</option>
                                                <option value="Any">Any</option>
                                                 <option value="100000-300000">1 lack-3 lack</option>
                                                 <option value="300000-600000">3 lack-6 lack</option>
                                                 <option value="600000-900000">6 lack-9 lack</option>
                                                 <option value="900000-1200000">9 lack-12 lack</option>
                                                 <option value="1200000-1500000">12 lack-15 lack</option>
                                                 <option value="1500000-1800000">15 lack-18 lack</option>
                                                 <option value="1800000-2100000">18 lack-21 lack</option>
                                                 <option value="21000000-2400000">21 lack-24 lack</option>
                                                 <option value="24000000-2700000">24 lack-27 lack</option>
                                                 <option value="2700000-3000000">27 lack-30 lack</option>
                                            </select>
                                        </div>
                                      
                                                  <div class="select-filters" style="margin-bottom: 5px;">
                                                 	<select name="city" id="sort-price">
                                                                <option style="display:none;" value="SELECT"><%=((city1==null?"City":city1)) %></option>
                                                                <option  value="All">All</option>
                                                                <%
                                                                while(itr.hasNext()){
                                                                	UsedCar city=(UsedCar)itr.next();
                                                                	%>
                                                                	<option><%=city.getREGISTERED_CITY()%></option>
                                                                <%
                                                                }
                                                                %>
                                                            </select>
                                        </div>
                                        <button type="submit" style="float:right;padding-top: 10px;padding-bottom: 10px;margin-bottom: 10px;padding-left: 10px;padding-right: 10px;" class="thm-btn">Go&nbsp;&rarr;</button><br>
                                       
                                    <font><b>Advance Search</b></font>    
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="colors" id="sort-price" onchange="this.form.submit()">
                                            <%System.out.println("color"+color); %>
                                                <option selected disabled style="display:none;"><%=((color==null || color.equals("null")?"Color":color)) %></option>
                                                <option>Black</option>
                                                <option>White</option>
                                                <option>Silver</option>
                                                <option>blue</option>
                                                <option>purple</option>
                                                <option>Grey</option>
                                                <option>Brown</option>
                                                <option>Red</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="fuelType" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((fuelType==null || fuelType.equals("null")?"FuelType":fuelType)) %></option>
                                                <option>Petrol</option>
                                                <option>Diesel</option>
                                                <option>CNG</option>
                                                <option>LPG</option>
                                                <option>ELECTRIC</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="carAge" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;">Car Age</option>
                                                <option value="1-10">1 year to 10 years & above</option>
                                                <option value="2-10">2 year to 10 years & above</option>
                                                <option value="3-10">3 year to 10 years & above</option>
                                                <option value="4-10">4 year to 10 years & above</option>
                                                <option value="5-10">5 year to 10 years & above</option>
                                                <option value="6-10">6 year to 10 years & above</option>
                                                <option value="7-10">7 year to 10 years & above</option>
                                                <option value="8-10">8 year to 10 years & above</option>
                                                <option value="9-10">9 year to 10 years & above</option>
                                                <option value="10-10">10 year to 10 years & above</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="kms" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;">Kilometer</option>
                                                <option value="0">0 to 80000 Kms & above</option>
                                                <option value="5000">5000 to 80000 Kms & above</option>
                                                <option value="10000">10000 to 80000 Kms & above</option>
                                                <option value="15000">15000 to 80000 Kms & above</option>
                                                <option value="20000">20000 to 80000 Kms & above</option>
                                                <option value="25000">25000 to 80000 Kms & above</option>
                                                <option value="30000">30000 to 80000 Kms & above</option>
                                                <option value="35000">35000 to 80000 Kms & above</option>
                                                <option value="40000">40000 to 80000 Kms & above</option>
                                                <option value="45000">45000 to 80000 Kms & above</option>
                                                <option value="50000">50000 to 80000 Kms & above</option>
                                                <option value="55000">55000 to 80000 Kms & above</option>
                                                <option value="60000">60000 to 80000 Kms & above</option>
                                                <option value="65000">65000 to 80000 Kms & above</option>
                                                <option value="70000">70000 to 80000 Kms & above</option>
                                                <option value="75000">75000 to 80000 Kms & above</option>
                                                <option value="80000">80000 to 80000 Kms & above</option>
                                            </select>
                                        </div>
                                   <!--  <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="bodyType" id="sort-price">
                                                <option selected disabled style="display:none;">Body Type</option>
                                                <option value="lower">1 Lak</option>
                                                <option value="higher">2 Laks</option>
                                            </select>
                                        </div> -->
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="owners" id="sort-price" onchange="this.form.submit()">
                                                <option value="0" style="display:none;">Owners</option>
                                                <option value="1">First Owner</option>
                                                <option value="2">Second Owner</option>
                                                <option value="3">More Owner</option>
                                                <option value="4" disabled>Unregistered Car</option>
                                            </select>
                                        </div>
                                   <!--  <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="sellerType" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;">Seller Type</option>
                                                <option>Dealer</option>
                                                <option>Individual</option>
                                            </select>
                                        </div> -->
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="transmission" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((transmission==null || transmission.equals("null")?"Transmission":transmission)) %></option>
                                                <option>Manual</option>
                                                <option>Automatic</option>
                                            </select>
                                        </div>
                                    
                                    
                                    </form>
                                    
                                </div>
                            </div>
                            <!-- help center -->
                            
                            <div class="sidber-box help-widget">
                                <i class="flaticon-photographer-with-cap-and-glasses"></i>
                                <h4>Need <span>Help?</span></h4>
                                <a href="#" class="phone">040 - 40191909</a>
                                <small>Monday to Saturday 9.00am - 7.30pm</small>
                            </div>
                        </div>
                        <%
                        
                        ArrayList<UsedCar> carDetails=(ArrayList<UsedCar>)request.getAttribute("carDetails");
                        %>
                        <div class="col-sm-8 col-md-9">
                         <%int i=1,j=1; %>
                            <div class="hotel-list-content">
                           <div style="float:right" class="col-md-12 col-sm-12 col-xs-12" id="hiddenArea"><button type="button" style="padding:7px 15px;float: right;margin-bottom: 5px;position: relative;right: 5px;" class="btn btn-danger" onclick="alert(getCheckedCheckboxesFor('compare'));">compare</button></div>
                         	<%if(carDetails!=null && carDetails.size()<=0){ %>
                         	 <div style="float:right" class="col-md-12 col-sm-6" id="hiddenArea"><font color="red" size="3">Data Not Available if you want to post your <b><u><font color="blue">car</font></u></b> then please register here</font color="blue"> <a href="./register.jsp"><b><u><font color="blue">Registar</font></u></b></a></div>
                         	
                         	<%}else{} %>
                         	
<!--                          	session form -->
                           <c:forEach var="carDetails"  items="${carDetails}">
                                <div class="row grid-margin">
                                       <div class="col-md-4 col-sm-6 col-xs-12 grid-item well">
                                         <div class="grid-item-inner" id="mainDiv">
                                            <div class="grid-img-thumb">
                                                  ribbon 
                                                 <div class="ribbon"><span>Popular</span></div>
                                               <div style="height:100%;width:100%">
                                              	 <a onclick="callMe('${carDetails.CAR_NUMBER}');" style="cursor: pointer;">
                                             		  <img src="data:image/png;base64,${carDetails.PHOTO1}" alt="No image" class="img-responsive">
                                             	  </a>
                                               </div>
                                            </div> 

                                        </div> 
                                    </div>
                                     <!-- ../grid item -->
                                    <div class="col-md-8 col-sm-6 col-xs-12 grid-item" style="margin-left: 0px;">
                                      
<%--                                       <div id="somediv"><input type="checkbox"  name="compare" value="${carDetails.GEN_CAR_ID}" id="option<%=i %>" onclick="ShowHideDiv(this)"/></div> --%>
<!--                                     <div id="tog"><input type="submit" id ="btn" value="Submit" /></div> -->
                                        
                                        <section class="well" style="/* background-color: #efefef */;/* height: 240px */;padding-top:10px;">
                                           <span style="color: #3c763d;font-size: 15px;padding-left: 20px;margin-top:10px"><b><c:out value="${carDetails.CAR_BRAND}"></c:out>&nbsp;&nbsp;&nbsp;<c:out value="${carDetails.CAR_MODEL}"></c:out></b></span>/
                                           <span style="color: #523f6d;font-size: 12px;padding-left: 20px;margin-top:10px"><b><font color="red">Car &nbsp;&nbsp;Id:</font><c:out value="${carDetails.GEN_CAR_ID}"></c:out></b></span>
                                            
                                            <span style="float:right;margin-right:10px;"><input type="checkbox"  class="number" name="compare" value="${carDetails.GEN_CAR_ID}" id="option<%=i %>"/></span><span id="msg" style="color:red;float:right;position: relative;left: 48%;font-size: 12px;top: -16px;"></span>
                                        	       
                                                      <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b> <br>PRICE&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;">&#8377;&nbsp;&nbsp;&nbsp;<c:out value="${carDetails.OFFER_PRICE}"></c:out></span><br></b></span> 
                                                       
<%--                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Current Mileage&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.CURRENT_MILEAGE}"></c:out>&nbsp;&nbsp;&nbsp;km&nbsp;&nbsp;&nbsp;</span></b></span><br> --%>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Fuel Type&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.FUEL_TYPE}"></c:out>&nbsp;&nbsp;&nbsp;</span></b></span><br>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Registered Year&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.REGISTERED_YEAR}"></c:out></span></b></span><br>
                                                        <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Color&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.COLOR}"></c:out></span></b></span><br>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Kms Driven&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.KMS_DRIVEN}"></c:out></span><br></b></span>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>City&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${carDetails.CITY}"></c:out></span></b></span><br><br><br><br>
                                                          
<!--                                                           <button type="button" style="padding:10px 15px;float: right;margin-bottom: 5px;position: relative;right: 5px;" class="thm-btn" onclick="getMultipleCheckbox(this.form.compare);">compare</button>
 --><!-- 													  </form> -->
<div class="w3-container"> 
<c:set var="carid" value="${carDetails.GEN_CAR_ID}"/>
	<%
			String email = (String) session.getAttribute("user"); 
// 			ArrayList<CarEndUser> requesters = (ArrayList<CarEndUser>)request.getAttribute("carrequesters");
			String carid=(String)pageContext.getAttribute("carid");
			ArrayList<String> requester =new ArrayList<String>();
			try
			{
				if(request.getAttribute("carrequest")!=null)
				{
					requester = (ArrayList<String>)request.getAttribute("carrequest");
				}
			}
			catch(Exception e)
			{
				
			}
 			if (requester.contains(carid)&email!=null) { 
	%> 
		<button type="button" style="float:right;margin-top:-34px" class="w3-button w3-green w3-large" disabled><b style="color: green">REQUEST SENT</b></button>
		</form>
	<% 	} else if(email!=null){
	%>  
		<a href="./SendRequest?cid=${carDetails.GEN_CAR_ID}&cb=${carDetails.CAR_BRAND}" class="w3-button w3-green w3-large" style="float:right;margin-top:-34px"><b style="color:black">SEND REQUEST</b></a>
	<%} else{%>
	<a href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-green w3-large" style="float:right;margin-top:-34px"><b style="color:black">SEND REQUEST</b></a>
	<%} %>	<br>
  <div id="id0<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id0<%=i %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertEndUserDetails" method="post">
      <input type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/>
      <input type="hidden" name="vehicleType" value="4"/>
      <input type="hidden" name="carBrand" value="<%=carBrand1%>"/>
      <input type="hidden" name="carModel" value="<%=carModel%>"/>
      <input type="hidden" name="carAge" value="<%=carAge%>"/>
      <input type="hidden" name="colors" value="<%=color%>"/>
      <input type="hidden" name="fuelType" value="<%=fuelType%>"/>
      <input type="hidden" name="kms" value="<%=kms%>"/>
      <input type="hidden" name="transmission" value="<%=transmission%>"/>
      <input type="hidden" name="carBudget" value="<%=budget%>"/>
      <input type="hidden" name="city1" value="<%=city1%>"/>
      <input type="hidden" name="lHPrice" value="<%=range%>"/>
      <c:out value="${carDetails.GEN_CAR_ID}"></c:out>
        <div class="w3-section">
          <center><h4>NEW USER</h4></center>
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="w3-input w3-border" type="email" placeholder="Enter Email" name="email" required>
          <label><b>Mobile No</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Enter Mobile No" name="mobileNo" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Submit</button>
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
		 <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'" style='float:right'>Existing User</a>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>
 <div class="w3-container"> 
   <div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 516px;">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
        <div class="w3-section">
        <div id="txtHint"></div>
        <form action="./IndividualUser" class="w3-container" method="post">
           <label><b>Email</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Email" name="email" required>
    		<input type="hidden" name="carBrand" value="<%=carBrand1%>"/>
    		<input type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/>
 		    <input type="hidden" name="vehicleType" value="4"/>
      		<input type="hidden" name="carModel" value="<%=carModel%>"/>
      		<input type="hidden" name="carAge" value="<%=carAge%>"/>
<%--       		<%System.out.println("color"+color); %> --%>
      		<input type="hidden" name="colors" value="<%=color%>"/>
      		<input type="hidden" name="fuelType" value="<%=fuelType%>"/>
      		<input type="hidden" name="kms" value="<%=kms%>"/>
      		<input type="hidden" name="transmission" value="<%=transmission%>"/>
      		<input type="hidden" name="carBudget" value="<%=budget%>"/>
      		<input type="hidden" name="city1" value="<%=city1%>"/>
      		<input type="hidden" name="lHPrice" value="<%=range%>"/>
      		<input type="hidden" name="page" value="<%=page1%>"/>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password"  required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Submit</button>
    		<a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
    </form>
        </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('register').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
<!--       <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Go Back</button> -->
    <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-red">Go Back</button>
      </div>
    </div>
  </div>
 </div>                     
</section>
                                    </div> 
                                                </div>
                                              <%i++; j++;%>
                                                </c:forEach>
                                               
                                            </div>
                                            <section>
                <div class="col-md-1 col-sm-1 col-xs-12 grid-item">Pages:</div>
                <c:forEach begin="1" end="${noOfPages}" var="m">
                <div class="col-sm-12 col-md-12 col-xs-12" style="margin-left: -22px;width:40px;">
                <form id="myfor<%=i %>" method="post" action="./SearchUsedCar" > 

<%--          <input type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/> --%>
           <input type="hidden" name="vehicleType" value="4"/>
            <input type="hidden" name="carBrand" value="<%=carBrand1==null?"SELECT":carBrand1%>"/>
            <input type="hidden" name="carModel" value="<%=carModel==null?"SELECT":carModel%>"/>
            <input type="hidden" name="carAge" value="<%=carAge%>"/>
            <input type="hidden" name="colors" value="<%=color%>"/>
            <input type="hidden" name="fuelType" value="<%=fuelType%>"/>
            <input type="hidden" name="kms" value="<%=kms%>"/>
            <input type="hidden" name="transmission" value="<%=transmission%>"/>
            <input type="hidden" name="carBudget" value="<%=budget==null?"SELECT":budget%>"/>
            <input type="hidden" name="city" value="<%=city1==null?"SELECT":city1%>"/>
            <input type="hidden" name="lHPrice" value="<%=range%>"/>
             <input type="hidden" name="page" value="${m}"/> 
             
       <a onclick="document.getElementById('myfor<%=i %>').submit();" style="cursor: pointer;"><c:out value="${m}"></c:out>&nbsp;&nbsp;</a>
       
 
<%--      <td style="float: left" ><a href="./SearchUsedCar?page=${m}&carBrand=<%=carBrand1%>&carModel=<%=carModel%>&carBudget=<%=budget%>&city=<%=city1%>">${m}&nbsp;&nbsp; </a></td> --%>
     
    <%i++; %>
    </form>
    </div>
   </c:forEach>
   
   
   </section>
                                        </div>
                                        
                                    </div>                               
                                    <!-- ../grid item -->
                                </div>
                                   
<!--       </section> -->
<%--    <%i++; j++;%> --%>
<%--                                                 </c:forEach> --%>
                            </div>
                            
                            <!-- pagination -->
                           <!--  <div class="pagination-inner">
                                pager
                                <ul class="pager">
                                    <li class="previous"><a href="#">Previous</a></li>
                                    <li class="next"><a href="#">Next</a></li>
                                </ul>
                                pagination
                                <ul class="pagination">
                                    <li><a href="#">1</a></li>
                                    <li class="active"><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">...</a></li>
                                    <li><a href="#">15</a></li>
                                </ul>
                            </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </section> -->
            <!-- Newsletter -->
            <section class="get-offer">
               <!--  <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <span>Subscribe to our Newsletter</span>
                            <h2>& Discover the best offers!</h2>
                        </div>
                        <div class="col-sm-7">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Enter Your Email" name="q">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
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
        <!-- google map -->
       
        <script>
                                            //range slide
                                            $("#range").ionRangeSlider({
                                                type: "double",
                                                grid: true,
                                                min: 0,
                                                max: 200,
                                                from: 50,
                                                to: 150,
                                                prefix: "$"
                                            });
                                            </script>
                                         <!--    <script>
                                            function openModal(model) {
                                            	  model.style.display = "block";
                                            	}

                                            	function closeModal(model) {
                                            	  model.style.display = "none";
                                            	}

                                    var slideIndex = 1;
                                    showSlides(slideIndex);

                                    function plusSlides(n) {
                                      showSlides(slideIndex += n);
                                    }

                                    function currentSlide(n) {
                                      showSlides(slideIndex = n);
                                    }

                                    function showSlides(n) {
                                      var i;
                                      var slides = document.getElementsByClassName("mySlides");
                                      var dots = document.getElementsByClassName("demo");
                                      var captionText = document.getElementById("caption");
                                      if (n > slides.length) {slideIndex = 1}
                                      if (n < 1) {slideIndex = slides.length}
                                      for (i = 0; i < slides.length; i++) {
                                          slides[i].style.display = "none";
                                      }
                                      for (i = 0; i < dots.length; i++) {
                                          dots[i].className = dots[i].className.replace(" active", "");
                                      }
                                      slides[slideIndex-1].style.display = "block";
                                      dots[slideIndex-1].className += " active";
                                      captionText.innerHTML = dots[slideIndex-1].alt;
                                    }
                                    </script>  -->
                                           	 <script>
function showBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint1").innerHTML="";  
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
			document.getElementById("txtHint1").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getCarModels.jsp?brand="+str,true);   
	xmlhttp.send();    
	}
	</script>
    </body>
</html>