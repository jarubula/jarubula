<%@page import="java.io.PrintWriter"%>
<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vaahanmitra | Search</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />
<%-- <% --%>
<!-- 	String message1 = (String) request.getAttribute("message"); -->
<!--  	String requestMSG = (String) request.getAttribute("requestMSG"); -->
<!--  	if (message1 != null) { -->
<!-- %> -->
<%-- 	<h3><b><%= message1 %></b></h3> --%>
<!-- <script type="text/javascript"> -->
<%--          alert("<%=message1%>"); --%>
<!--  	function showMsg() { -->

<!--  	} -->
<!-- </script> -->
<%-- <% --%>
<!--  	} else { -->
<!-- }  -->
<!-- %> -->


<style type="text/css">
b{
    font-weight: initial !important;
    }
.well {
    min-height: 20px;
    padding:0px;
    margin-bottom: 20px;
     background-color: #fff;
    border: 1px solid #e3e3e3;
    border-radius: 6px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
}
.border {
    border: 1px solid #bfbcbc !important;
    margin-bottom: 8px;
    padding: 10px;
    border-radius: 4px !important;
}

.border:hover {
    box-shadow: 0px 0px 12px #b7b7b7 !important;
}

 .hover:hover{ 
              background: rgb(82, 63, 109);
                
 			} 
			
			.hover{
			
				width: 200px;
			}
			.hover a{
         text-decoration: none;
			}
			.animated {
            
            background-repeat: no-repeat;
            background-position: left top;
            /*padding-top:95px;
            margin-bottom:60px;*/
            -webkit-animation-duration: 10s;
            animation-duration: 1s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
         }
         
         @-webkit-keyframes bounceInRight {
            0% {
               opacity: 0;
               -webkit-transform: translateX(2000px);
            }
            60% {
               opacity: 1;
               -webkit-transform: translateX(-30px);
            }
            80% {
               -webkit-transform: translateX(10px);
            }
            100% {
               -webkit-transform: translateX(0);
            }
         }
         
         @keyframes bounceInRight {
            0% {
               opacity: 0;
               transform: translateX(2000px);
            }
            60% {
               opacity: 1;
               transform: translateX(-30px);
            }
            80% {
               transform: translateX(10px);
            }
            100% {
               transform: translateX(0);
            }
         }
         
         .bounceInRight {
            -webkit-animation-name: bounceInRight;
            animation-name: bounceInRight;
         }
label {
    /* display: inline-block; */
    /* max-width: 100%; */
    margin-bottom: 5px;
    font-weight: 700;
    float: left;
        text-align: left;
    margin: 3px 2px;
}
		</style>


<head>
<%
String message1 = (String) request.getAttribute("message");
//	String bikeId = (String) request.getAttribute("bikeId");
//	if (message1 != null) {
%>
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
   <div class="col-md-3 col-sm-6"></div>
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
	function callMe(myId) {
		var popup1 = window.open('./displayBikeImage.jsp?photo=' + myId)
		/* 	var n=window.open("DisplayCarImage.jsp?photo="+myId,"mywindow", " width=2000, height=1000"); */

	}
</script>
<script type="text/javascript">
	alert = function() {
	}
	function getCheckedCheckboxesFor(checkboxName) {

		var checkboxes = document.getElementsByName(checkboxName);

		var value1 = [];

		for (var i = 0; i < checkboxes.length; i++) {

			if (checkboxes[i].checked) {

				//     	 document.getElementById('checkboxName').appendChild(document.getElementById('hiddenArea'));

				value1.push(checkboxes[i].value);

			}
		}
		if (value1.length > 1 && value1.length < 4) {

			// 	 location.href="CompareUsedCar?compare="+value1;
			var n = window.open("CompareUsedBike?compare=" + value1, "myWin",
					"left=700, top=200, width=850, height=700");
		} else if (value1.length < 2) {

			/*  alert("please select maximum 3 checkboxes to compare your selection.."); */
			document.getElementById("msg").innerHTML = "please select maximum 3 Cars <br>to compare your selection..";

		} else if (value1.length > 3) {

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
</style>

	<style type="text/css">
		
 a.darken {
    display: inline-block;
    background: black;
    padding: 0;
    position:relative;
	
}

a.darken img {
    display: block;
    
    -webkit-transition: all 0.2s linear;
       -moz-transition: all 0.2s linear;
        -ms-transition: all 0.2s linear;
         -o-transition: all 0.2s linear;
            transition: all 0.2s linear;
}

.g:hover a.darken img {
    opacity: 0.3;           
}
a.darken span{
    visibility:hidden; 
    font-size:16px;
      position: absolute;
      top: 50%;
      left: 50%;
      -webkit-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
      line-height: 100%;
}
.g:hover a.darken span{color:#fff; visibility:visible;
    -webkit-transition: all 0.2s linear;
       -moz-transition: all 0.2s linear;
        -ms-transition: all 0.2s linear;
         -o-transition: all 0.2s linear;
            transition: all 0.2s linear;
}
.btn-primary {
    color: #fff !important;
    background-color: #337ab7 !important;
    border-color: #2e6da4 !important;
}
#page-content {
    position: relative;
    /* margin-bottom: 421px; */
    z-index: 10;
    background-color:#fff;
    /* margin-top: 70px; */
}
.se1{
    font-size: 15px;color: #777474; font-family: inherit;  line-height: 25px;
}
.se2{
font-size: 14px; color: #131212; font-weight: 500; font-family: inherit;
}
.se3{
    font-size: 17px; font-weight: 500 !important; color: #ff0016;
    }
     .se4{
  color: #3c763d; font-size:22px; color: #9a2220; font-weight: 600;font-family: inherit;
  }  
  .se5{
        font-size: 13px; opacity: .7;  color: #24272c;
    }
   .se6{
     color: red;font-weight: 500;font-size: 14px;
    }
    #se7{
    width: 176px;
    background: #fff;
    border: solid 1px #9a2220;
    color: #9a2220;
    letter-spacing: 0;
    height: 32px;
    line-height: 28px;
    padding: 0;
    text-align: center;
    font-size: 15px;
    font-family: unset;
    }
     #se7:hover{
    width: 176px;
     background: #9a2220;
    border: solid 1px #9a2220;
    color: #fff;
    letter-spacing: 0;
    height: 32px;
    line-height: 28px;
    padding: 0;
    text-align: center;
    font-size: 15px;
    font-family: unset;
    }
    .used h3{
     text-align: center;
    font-size: 30px;
    color: #fec107;
       margin-bottom: 10px;
    }
 /*   .sticky + .content {
    padding-top: 41px !important;
} */
#top2 {
    margin-top: -60px;
}
	</style>

</head>
<body>

	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
	
			<jsp:include page="./homeTop.jsp"></jsp:include>
			<!-- /.container -->
		
		<!-- /.nav end -->
		<!-- page header -->
		<!-- hotel -->
		<section class="tour-inner" id="top2" style="background:#fff">
			<div class="container">
				      <div class="col-md-12 col-xs-12 " style="background:#fff; border-radius: 6px;">
<%-- 				 <%
	String message1 = (String) request.getAttribute("message");
 	String bikeId = (String) request.getAttribute("bikeId");
 	if (message1 != null) {
%>
 --%><%-- 	<center><h6 style='color:red'><b><%= message1 %></b></h6></center> --%>
<%-- 	<% } else {}%> --%>

					<!-- collapse map -->
					<div class="col-sm-12">
						<div class="collapse" id="collapseMap">
							<!-- The element that will contain Google Map. This is used in both the Javascript and CSS above. -->
							<div id="map"></div>
						</div>
					</div>
					
    <%
    String email = (String) session.getAttribute("user"); 
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
  
   <div class="col-md-12 used">
     <h3>Used Bikes</h3>
    </div>
				<div class="col-sm-4 col-md-3 res2" style=" background-color: #fff;
    border: 1px solid #e3e3e3;
    border-radius: 6px;">
    		<form action="./SearchHUsedBike" method="post">
                            <div class="sidber-box cats-price" style="margin-top: 11px;">
                                <div class="cats-title">Price</div>
                                <div class="price-Pips">
<!--                                     <input type="text" id="range" value="range" name="range" /> -->
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
							<div class="cats-title">Filter</div>
							<div class="facility">
									<%
										ArrayList<UsedBike> bikeDetails = (ArrayList<UsedBike>) request.getAttribute("bikeDetails");
										String bcity = (String)request.getAttribute("city");
										String bikeBrand1 = (String)request.getAttribute("bikeBrand");
										String budget = (String)request.getAttribute("budget");
										String bikeModel = (String)request.getAttribute("bikeModel");
										String bikeVariant =(String)request.getAttribute("bikeVariant");
										String bikeAge = (String)request.getAttribute("bikeAge");
										String color = (String) request.getAttribute("color");
										String kms = (String) request.getAttribute("kms");
										String owners = (String) request.getAttribute("owners");
										GetUsedBikeDetails bikeCity1 = new GetUsedBikeDetails();
										ArrayList<UsedBike> bikeCity = bikeCity1.getUsedBikeCity();
										Iterator itr = bikeCity.iterator();
									%>

									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="bikeBrand" id="bikeBrand"
											onchange="showModel(this.value)">
											<option value="SELECT" style="display: none;"><%=bikeBrand1 == null? "Brand":bikeBrand1.equals("SELECT") ? "Brand" : bikeBrand1%>
											<option value="All">All</option>
<%-- 											<%=((bikeBrand1.equals("SELECT") ? "Brand" : bikeBrand1))%> --%>
											</option>
											<%
												GetUsedBikeDetails bikeBrand = new GetUsedBikeDetails();
												ArrayList<UsedBike> bikeBnd = bikeBrand.getUsedBikeBrand();
											%>
											<%
												Iterator it = bikeBnd.iterator();
												while (it.hasNext()) {
													UsedBike usedBike = (UsedBike) it.next();
											%>
											<option><%=usedBike.getBIKE_BRAND()%></option>
											<%
												}
											%>
										</select>
									</div>

									<div class="select-filters" style="margin-bottom: 5px;"
										id="txtHint2">
										<select name="bikeModel" class="form-control">
											<option value="SELECT" style="display: none;"><%=bikeModel == null? "Model":bikeModel.equals("SELECT") ? "Model" : bikeModel%></option>
										</select>
									</div>
									
									<div class="select-filters" style="margin-bottom: 5px;"
										id="txtHint3">
										<select name="bikeVariant" class="form-control">
											<option value="SELECT" style="display: none;"><%=bikeVariant == null? "Variant":bikeVariant.equals("SELECT") ? "Variant" : bikeVariant%></option>
										</select>
									</div>

									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="bikeBudget" id="sort-price">
											<option value="SELECT" style="display: none;">Budget</option>
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
											<option value="SELECT" style="display: none;"><%=bcity == null? "City":bcity.equals("SELECT") ? "City" : bcity%></option>
											<option value="All">All</option>
											<%
												while (itr.hasNext()) {
													UsedBike bcity1 = (UsedBike) itr.next();
											%>
											<option><%=bcity1.getCITY()%></option>
											<%
												}
											%>
										</select>
									</div>

									<button type="submit" class="thm-btn btn-block" style="line-height: 10px;">Go&nbsp;&rarr;</button>
									<br> <font><b>Advance Search</b></font>

									<div class="select-filters" style="margin-bottom: 5px;">
									<%System.out.println("dsfsdgfdg"+color); %>
										<select name="colors" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;"><%=((color == null || color.equals("null") ? "Color" : color))%></option>
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
										<select name="bikeAge" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;">Bike
												Age</option>
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
										<select name="kms" id="sort-price"
											onchange="this.form.submit()">
											<option selected disabled style="display: none;">Kilometer</option>
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
									<!-- <div class="select-filters" style="margin-bottom: 5px;">
										<select name="bodyType" id="sort-price">
											<option selected disabled style="display: none;">Body
												Type</option>
											<option value="lower">1 Lak</option>
											<option value="higher">2 Laks</option>
										</select>
									</div> -->
									<div class="select-filters" style="margin-bottom: 5px;">
										<select name="owners" id="sort-price"
											onchange="this.form.submit()">
											<option value="0" style="display: none;">Owner</option>
											<option value="1">First Owner</option>
											<option value="2">Second Owner</option>
											<option value="3">More Owner</option>
											<option value="4" disabled>Unregistered Car</option>
										</select>
									</div>
									<!-- <div class="select-filters" style="margin-bottom: 5px;">
										<select name="sellerType" id="sort-price">
											<option selected disabled style="display: none;">Seller
												Type</option>
											<option>Dealer</option>
											<option>Individual</option>
										</select>
									</div> -->
									<!--                 <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="transmission" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled>Transmission</option>
                                                <option>Manual</option>
                                                <option>Automatic</option>
                                            </select>
                                        </div> -->


								</form></div>

							</div>
						<!-- help center -->

						<div class="sidber-box help-widget  res3">
							<i class="flaticon-photographer-with-cap-and-glasses"></i>
							<h4>
								Need <span>Help?</span>
							</h4>
							<a href="#" class="phone">040 - 48510133</a> <small>Monday
								to Saturday 9.00am - 7.30pm</small>
						</div>
					</div>
					
					<div class="col-sm-8 col-md-9 col-xs-12 well">
					 
						<%
							int i = 1, j = 1;
						%>
						
						<div class="hotel-list-content">
						
						<div class="col-md-12 col-xs-12  " style="padding:4px">
						<div class="">
						<span id="msg" style="color:red;position: relative;font-size: 12px;">
						
						</span>
						</div>
						</div>
						
						 <div class="col-md-12 col-xs-12  " style="padding:4px">
                              <div class="">
                                <span id="msg" style="color:red;float:left;"></span>
								<button type="button" class="btn btn-danger" type="submit" style="float: right; color:#fff; font-size: 15px; font-weight: 500; font-family: unset;" class="thm-btn"
									onclick="alert(getCheckedCheckboxesFor('compare'));">Compare</button>
							</div></div>
						
							<!--                                <form action="./CompareUsedCar" method="post">  -->
							<div style="float: right" class="col-md-12 col-sm-12 col-xs-12 "
								id="hiddenArea">
								
							<!-- </div> -->
					        <%
// 								System.out.println("Mahesh 11");
								if (bikeDetails.size() <= 0) {
// 									System.out.println("Mahesh 112");
							%>
							<div style="float: right" class="col-md-12 col-sm-6"
								id="hiddenArea">
								<font color="red" size="3">Data Not Available if you want
									to post your <b><u><font color="blue">bike</font></u></b> then
									please register here
								</font color="blue"> <a href="./register.jsp"><font color="blue"><b><u>Registar</u></b></font></a>
							</div>

							<%
								} else {
								}
							%>
							<c:forEach var="bikeDetails" items="${bikeDetails}">
								<div class="row grid-margin border">
								    
             <aside class="col-md-4 col-sm-12 col-xs-12 g zoom" >
            
    		<div class="col-md-12  margin " align="center">
    		
    		<a onclick="callMe('${bikeDetails.BIKE_NUMBER}');" style="cursor: pointer;" class="darken"> 
			<img style="width:100%; max-height:162px;" src="data:image/png;base64,${bikeDetails.PHOTO1}"  class="img-tumbline img-responsive"  alt="Image">
			<span><i class="fa fa-camera" aria-hidden="true"></i></span>
			</a>
			
        </div>

    	</aside>
    	<aside class="col-md-8 col-sm-12 col-xs-12" style="padding: 0 0px;">
    		<div class="col-md-5"><span class="se4"><c:out value="${bikeDetails.BIKE_BRAND}"></c:out> > <c:out value="${bikeDetails.BIKE_MODEL}"></c:out> > <c:out value="${bikeDetails.VARIANT_NAME}"></c:out></span>
        	</div>
        	
        	  <div class="col-md-6 col-sm-9 col-xs-9"">
        	  <span class="se5">Last Updated :</span> <span class="se6"><c:out value="${bikeDetails.UPDATED_DATE}"></c:out></span>
        	  </div>
        	
           <div class="col-md-1 " align="right">
           <input type="checkbox"  name="compare" value="${bikeDetails.GEN_BIKE_ID}" id="option<%=i %>" onclick="ShowHideDiv(this)"/>
           </div>
           
           <div class=" col-md-12 col-sm-12 col-xs-12">
             <span class="se1">Bike ID :</span> <span class="se2"><c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out></span>
           </div>
           
           <div class="col-md-12 col-sm-12 col-xs-12 line" >
            <c:set var="VALUE" value="${bikeDetails.OFFER_PRICE}"></c:set>
           <%String price=""; String value=(String)pageContext.getAttribute("VALUE");
            double  value_1= Integer.parseInt(value);
           price= new CurrencyFormate().indianrupee(value_1); %>
           
           <span class="se1">PRICE :</span> <span class="se2">  <i class="fa fa-inr"></i> <c:out value="<%=price%>"></c:out></span><br>
           </div>
          <div class="col-md-7 row">
          
           <div class=" col-md-12 col-sm-12 col-xs-12">
             <span class="se1">Registered Year :</span> <span class="se2"><c:out value="${bikeDetails.REGISTERED_YEAR}"></c:out></span>
           </div>
         
           <div class=" col-md-12 col-sm-12 col-xs-12" style="line-height: 32px;">
           <span class="se1">Registered State :</span> <span class="se2"><c:out value="${bikeDetails.REGISTERED_STATE}"></c:out></span>
           </div>
           
          <div class="col-md-12 col-xs-12 col-sm-12 row">
          <a href="#demo<%=i%>" class="btn btn-defalut text-primary"  data-toggle="collapse" style="line-height: 0px;">
           <span class="se3"><u>More Details</u></span></a>

        <div id="demo<%=i%>" class="collapse">
        <div class=" col-md-12 col-sm-12 col-xs-12">
         <span class="se1">Kms Driven : </span> <span class="se2"><c:out value="${bikeDetails.KMS_DRIVEN}"></c:out></span>
           </div>
 	    	<div class=" col-md-12 col-sm-12 col-xs-12">
 	    	 <span class="se1">Color : </span> <span class="se2"> <c:out value="${bikeDetails.COLOR}"></c:out></span>
           </div>
           <div class=" col-md-12 col-sm-12 col-xs-12">
            <span class="se1">Starting System : </span> <span class="se2"> <c:out value="${bikeDetails.STARTING_SYSTEM}"></c:out></span>
           </div>
            <div class=" col-md-12 col-sm-12 col-xs-12">
            <span class="se1">No Of Owners Used : </span> <span class="se2"> <c:out value="${bikeDetails.NO_OF_OWNERS}"></c:out></span>
           </div>
  </div>
           
           </div>
            <div class="col-md-12 col-xs-12 col-sm-12 row " style="    min-height:auto;" >
   
            </div>
           </div>
                  
           <div class="col-md-5 col-sm-12 col-xs-12 " align="center" > 
<!--            <a href="#" onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large" ><b style="  vertical-align:middle">SEND REQUEST</b></a> -->
        
            <div class="col-md-12 col-sm-12  res1" align="center" style="margin-left:50px" >
<div class="w3-container" style="    padding: 0px !important;"> 
<c:set var="bikeid" value="${bikeDetails.GEN_BIKE_ID}"/>
	<%
			String bikeid=(String)pageContext.getAttribute("bikeid");
			ArrayList<String> requester =new ArrayList<String>();
			try
			{
				if(request.getAttribute("bikerequest")!=null)
				{
					requester = (ArrayList<String>)request.getAttribute("bikerequest");
				}
			}
			catch(Exception e)
			{
				
			}
			GetUsedBikeDetails bikeVisitors = new GetUsedBikeDetails(); 
	      	int visitorValue = bikeVisitors.getBikeVisitors(bikeid, '2');
 			if (requester.contains(bikeid)&&email!=null) { 
	%> 
		<button type="button" class="btn btn-success" id="se7" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b></button>
		<br>
			Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
<!-- 		</form> -->
	<% 	} else if(email!=null){
	%>  
<%-- 		<a style="border-radius: 25px; border-color: snow;" class="btn btn-primary"  href="./SendBikeRequest?bid=${bikeDetails.GEN_BIKE_ID}&bb=${bikeDetails.BIKE_BRAND}"><b style="vertical-align:middle">SEND REQUEST</b></a> --%>
		<form id="myfor<%=i %>" method="post" action="./SendBikeRequest">
		<input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}" /> 
		<input type="hidden" name="vehicleType" value="2" /> 
		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>" />
		<input type="hidden" name="bikeModel" value="<%=bikeModel%>" />
		<input type="hidden" name="bikeVariant" value="<%=bikeVariant%>"> 
		<input type="hidden" name="bikeAge" value="<%=bikeAge%>" />
 		<input	type="hidden" name="colors" value="<%=color%>" /> 
 		<input type="hidden" name="kms" value="<%=kms%>" />
 		<input type="hidden" name="bikeBudget" value="<%=budget%>" /> 
 		<input type="hidden" name="city" value="<%=bcity%>" />
		<input type="hidden" name="lHPrice" value="<%=range%>"/>
	  <a id="se7" class="btn btn-danger" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;"><span style="vertical-align:middle">CONTACT OWNER</span></a></span>
		Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	</form>
	
	<%} else{%>
	<a id="se7" class="btn btn-danger" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'"><span style="vertical-align:middle">CONTACT OWNER</span></a>
		Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	<%} %>	
												<div id="id0<%=i%>" class="w3-modal">
													<div class="w3-modal-content w3-card-4 w3-animate-zoom"
														style="max-width: 400px;border-radius:8px;margin-top:20px">

														<div class="w3-center">
															<br> <span
																onclick="document.getElementById('id0<%=i%>').style.display='none'"
																class="w3-button w3-xlarge w3-hover-red w3-display-topright"
																title="Close Modal">&times;</span>
														</div>
														<form class="w3-container" action="./InsertBikeRequester"
															method="post">
															<input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}" /> 
															<input type="hidden" name="vehicleType" value="2" /> 
															<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>" />
															<input type="hidden" name="bikeModel" value="<%=bikeModel%>" /> 
															<input type="hidden" name="bikeVariant" value="<%=bikeVariant%>">
															<input type="hidden" name="bikeAge" value="<%=bikeAge%>" />
 															<input	type="hidden" name="colors" value="<%=color%>" /> 
 															<input type="hidden" name="kms" value="<%=kms%>" />
 															<input type="hidden" name="bikeBudget" value="<%=budget%>" /> 
 															<input type="hidden" name="city" value="<%=bcity%>" />
															<input type="hidden" name="lHPrice" value="<%=range%>"/>
															<c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out>
			<div class="w3-section">
          <h4 align="center">NEW USER</h4>
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="w3-input w3-border form-control" type="email" placeholder="Enter Email" name="email" required>
          <label><b>Mobile No</b></label>
          <input class="w3-input w3-border form-control" type="text" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" name="mobileNo" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password" required>
          <br>
          <button class="w3-button w3-block w3-green w3-section w3-padding btn-primary form-control" type="submit">
          Submit</button>
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
	</form>
	<div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px">
	<div class="col-md-6">
	 <button onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="w3-button w3-red form-control">
	 Cancel</button>
	</div>
	<div class="col-md-6">
	 <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'" style='float:right'><u>Existing User</u></a>
	</div>
	
       
		
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>
</div>


<div class="w3-container">
	<div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 400px; border-radius:8px;margin-top:20px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
        <div class="w3-section">
        <div id="txtHint"></div>
        <form action="./IndividualBike"  class="w3-container" method="post">
           <label><b>Email</b></label>
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Email" name="email" required>
    		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>"/>
    		<input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}" /> 
			<input type="hidden" name="vehicleType" value="2" /> 
			<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>" />
			<input type="hidden" name="bikeModel" value="<%=bikeModel%>" /> 
			<input type="hidden" name="bikeVariant" value="<%=bikeVariant%>">
			<input type="hidden" name="bikeAge" value="<%=bikeAge%>" />
 			<input type="hidden" name="colors" value="<%=color%>" /> 
 			<input type="hidden" name="kms" value="<%=kms%>" />
 			<input type="hidden" name="bikeBudget" value="<%=budget%>" /> 
 			<input type="hidden" name="city" value="<%=bcity%>" />
			<input type="hidden" name="lHPrice" value="<%=range%>"/>
			<input type="hidden" name="page" value="<%=page1%>"/>
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password"  required>
          <br>
          <div class="col-md-6">
          <button class="w3-button w3-block w3-green w3-section w3-padding btn-primary form-control" type="submit">Submit</button>
          </div>
          <div class="col-md-6">
          <a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
          </div>
          
    		
    </form>
        </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px">
       <div class="col-md-6">
        <button onclick="document.getElementById('register').style.display='none'" type="button" class="form-control w3-button w3-red">
        Cancel</button>
       </div>
       <div class="col-md-6">
       <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="form-control w3-button w3-red">
       Go Back</button>
       </div>
<!--       <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Go Back</button> -->
          
      </div>
    </div>
  </div>
</div>
           
           
           </div>


    	</aside>
                           
                                                </div>
                                              <%i++; j++;%>
                                                </c:forEach>
                                               
                            <div class=" mi res4 border" style="margin-right: -36px;margin-left: -36px;text-align: center;">
							<i class="flaticon-photographer-with-cap-and-glasses" style="font-size: 35px"></i>
							<h4>
								Need <span>Help?</span>
							</h4>
							<a href="#" class="phone">040 - 40191909</a> <small>Monday
								to Saturday 9.00am - 7.30pm</small>
						</div>
                                               
                                               
                                            </div>
                                             <section>
               <div class="col-md-1 col-sm-1 col-xs-12 grid-item">Pages:</div>
              
                <c:forEach begin="1" end="${noOfPages}" var="m">
                <div class="col-sm-12 col-md-12 col-xs-12" style="margin-left: -22px;width:40px;">
                <form id="myfor<%=i %>" method="post" action="./SearchHUsedBike"> 

<%--          <input type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/> --%>
           <input type="hidden" name="vehicleType" value="2"/>
          <input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>"/>
            <input type="hidden" name="bikeModel" value="<%=bikeModel%>"/>
            <input type="hidden" name="bikeVariant" value="<%=bikeVariant%>">
<%--             <input type="hidden" name="bikeAge" value="<%=bikeAge%>"/> --%>
            <input type="hidden" name="colors" value="<%=color%>"/>
            <input type="hidden" name="kms" value="<%=kms%>"/>
            <input type="hidden" name="bikeBudget" value="<%=budget%>"/>
            <input type="hidden" name="city" value="<%=bcity%>"/>
            <input type="hidden" name="lHPrice" value="<%=range%>"/>
              <input type="hidden" name="page" value="${m}"/> 
<%--        <a onclick="document.getElementById('myfor<%=i %>').submit();" style="cursor: pointer;">${m}&nbsp;&nbsp;</a> --%>
  
 
<%--      <td style="float: left" ><a href="./SearchUsedCar?page=${m}&carBrand=<%=carBrand1%>&carModel=<%=carModel%>&carBudget=<%=budget%>&city=<%=city1%>">${m}&nbsp;&nbsp; </a></td> --%>
     
     <c:set var="currentPage" value="${currentPage}"></c:set>
                <c:set var="noOfPages" value="${m}"></c:set>
       <%
                Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
                Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
                if(currentPage1.equals(noOfPages)){
                %>
            <a onclick="document.getElementById('myfor<%=i %>').submit();" style="cursor: pointer;color:#fc6116;"><u><c:out value="${m}"></c:out></u>&nbsp;&nbsp;</a>
      <%} else{%>
                      
            <a onclick="document.getElementById('myfor<%=i %>').submit();" style="cursor: pointer;"><c:out value="${m}"></c:out>&nbsp;&nbsp;</a>
      <%} %>
    <%i++; %>
    </form>
    </div>
    
   </c:forEach>
   
   
   </section>
                                        </div>
                                        
                                    </div>  
                                    </section>
                                    </div>                             
                                    <!-- ../grid item -->
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
	<!-- <section class="get-offer">
		<div class="container">
			<div class="row">
				<div class="col-sm-5">
					<span>Subscribe to our Newsletter</span>
					<h2>& Discover the best offers!</h2>
				</div>
				<div class="col-sm-7">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Enter Your Email" name="q">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="flaticon-paper-plane"></i> Subscribe
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> -->
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
	<script src="assets/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- counter -->
	<script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
	<script src="assets/js/waypoints.js" type="text/javascript"></script>
	<!-- filter portfolio -->
	<script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
	<script src="assets/js/portfolio.js" type="text/javascript"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"
		type="text/javascript"></script>
	<!-- range slider -->
	<script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<!-- google map -->

	<script>
		//range slide
		$("#range").ionRangeSlider({
			type : "double",
			grid : true,
			min : 0,
			max : 200,
			from : 50,
			to : 150,
			prefix : "$"
		});
	</script>



	<script>
		function showModel(str) {
			if (str == "") {
				document.getElementById("txtHint2").innerHTML = "";
				return;
			}
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari  
				xmlhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5  
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("txtHint2").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "./getHBikeModels.jsp?brand=" + str, true);
			xmlhttp.send();
		}
		function showVariant(str) {
			
		var brand  = document.getElementById("bikeBrand").value;
			if (str == "") {
				document.getElementById("txtHint3").innerHTML = "";
				return;
			}
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari  
				xmlhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5  
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("txtHint3").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "./getHBikeVariant.jsp?brand=" +brand+"&model="+str, true);
			xmlhttp.send();
		}
	</script>

</body>

</html>