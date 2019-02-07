<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Vaahanmitra | Search</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
  <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
<style>
.well {
    min-height: 20px;
    padding: 19px;
    margin-bottom: 20px;
    background-color: #f5f5f5;
    border: 1px solid #c0baba; !important;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    box-shadow: rgba(0,0,0,.05);
    box-shadow: 0 1px 11px;  !important;
    border-radius: 7px; !important;
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
</style>
<%
String message1 = (String) request.getAttribute("message");
//	String bikeId = (String) request.getAttribute("bikeId");
//	if (message1 != null) {
%>
<style type="text/css">
.well {
    padding: 0px !important;
    }
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

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Search</title>
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

 	var popup1=window.open('./DisplayCarImage.jsp?photo='+myId)
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
  
  
  
 		<style type="text/css">
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
    margin: 3px 2px;
        text-align: left;
}
		
a.darken {
    display: inline-block;
    background: black;
    padding: 0;
    position:relative;
	
}
b{
    font-weight: initial !important;
    }
a.darken img {
    display: block;
    
    -webkit-transition: all 0.2s linear;
       -moz-transition: all 0.2s linear;
        -ms-transition: all 0.2s linear;
         -o-transition: all 0.2s linear;
            transition: all 0.2s linear;
}

.g:hover a.darken img{  
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
/* .w3-container, .w3-panel {
    padding: 0px !important;
} */
.btn-primary {
    color: #fff !important;
    background-color: #337ab7 !important;
    border-color: #2e6da4 !important;
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
    width: 176px; background: #fff;border: solid 1px #9a2220;color: #9a2220;letter-spacing: 0; height: 32px; line-height: 28px; padding: 0; text-align: center;  font-size: 15px; font-family: unset;
    }
     #se7:hover{
    width: 176px;  background: #9a2220;  border: solid 1px #9a2220; color: #fff; letter-spacing: 0; height: 32px; line-height: 28px; padding: 0; text-align: center;font-size: 15px; font-family: unset;
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
    
        <div class="se-pre-con"></div>
        <div id="page-content" style="background: #fff"> 
          <jsp:include page="./homeTop.jsp"></jsp:include>
            <section class="tour-inner" id="top2" style="background:#fff">
                <div class="container" >

                    <div class="col-md-12 col-xs-12 " style="background:#fff; border-radius: 6px;"> <!-- box-shadow: 0 1px 4px 0 rgba(0,0,0,.21);  -->
                    	
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
    	
    <div class="col-md-12 used">
     <h3>Used Cars</h3>
    </div>
     <div class="col-sm-4 col-md-3 res2" style=" background-color: #fff;
    border: 1px solid #e3e3e3;
    border-radius: 6px;">
                            <!-- price pips -->
                                <form action="./SearchUsedCar" method="post">
                            <div class="sidber-box cats-price" style="margin-top: 11px;">
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
                                     				String carVariant=(String)request.getAttribute("carVariant");
                                     				String carAge=(String)request.getAttribute("carAge");
                                     				String color=(String)request.getAttribute("color");
                                     				String fuelType=(String)request.getAttribute("fuelType");
                                     				String kms=(String)request.getAttribute("kms");
                                     				String transmission=(String)request.getAttribute("transmission");
                                     				String budget=(String)request.getAttribute("budget");
                                     				String message=(String)request.getAttribute("message");
                                     				String bodyType=(String)request.getAttribute("bodyType");
                                     				
                                                    GetUsedCarDetails carBudget=new GetUsedCarDetails();
                                                    ArrayList<UsedCar> carCity=carBudget.getUsedCarCity();
                                                    Iterator itr= carCity.iterator();
                                                    %>
                                        
  
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="carBrand"  id="brand" onchange="showBrand(this.value)">
                                                <option  style="display:none;" value="SELECT"><%=((carBrand1==null?"Brand":carBrand1.equals("SELECT")?"Brand":carBrand1))%></option>
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
															 <option value="SELECT" style="display:none;"><%=((carModel==null?"Model":carModel.equals("SELECT")?"Model":carModel)) %></option>
															 </select>
                                        </div>
                                         <div class="select-filters" style="margin-bottom: 5px;" id="txtHint2">
                                           <select name="carVariant" class="form-control">
															 <option value="SELECT" style="display:none;"><%=((carVariant==null?"Variant":carVariant.equals("SELECT")?"Variant":carVariant)) %></option>
															 </select>
                                        </div>
                                        
                                            <div class="select-filters" style="margin-bottom: 5px;">
                                    <select name="carBudget" id="sort-price">
                                                <option style="display:none;" value="SELECT"><%=((budget==null?"Budget":budget.equals("SELECT")?"Budget":budget)) %></option>
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
                                                                <option style="display:none;" value="SELECT"><%=((city1==null?"City":city1.equals("SELECT")?"City":city1)) %></option>
                                                                <option  value="All">All</option>
                                                                <%
                                                                while(itr.hasNext()){
                                                                	UsedCar city=(UsedCar)itr.next();
                                                                	%>
                                                                	<option><%=city.getCITY()%></option>
                                                                <%
                                                                }
                                                                %>
                                                            </select>
                                        </div>
                                        <button  type="submit" class="thm-btn btn-block" style="line-height: 10px;">Go&nbsp;&rarr;</button><br>
                                       
                                    <font><b>Advance Search</b></font>    
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="colors" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((color==null || color.equals("null")?"Color":color)) %></option>
                                               		<option>WHITE</option>
													<option>BLACK</option>
													<option>SILVER</option>
													<option>RED</option>
													<option>BLUE</option>
													<option>GREY</option>
													<option>BEIGE</option>
													<option>BROWN</option>
													<option>GOLD/YELLOW</option>
													<option>GREEN</option>
													<option>PURPLE</option>
													<option>MAROON</option>
													<option>ORANGE</option>
													<option>VIOLET</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="fuelType" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((fuelType==null || fuelType.equals("null")?"FuelType":fuelType)) %></option>
                                                <option>PETROL</option>
                                                <option>DIESEL</option>
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
                                  
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="owners" id="sort-price" onchange="this.form.submit()">
                                                <option value="0" style="display:none;">Owners</option>
                                                <option value="1">First Owner</option>
                                                <option value="2">Second Owner</option>
                                                <option value="3">More Owner</option>
                                                <option value="4" disabled>Unregistered Car</option>
                                            </select>
                                        </div>
                                  
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="transmission" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((transmission==null || transmission.equals("null")?"Transmission":transmission)) %></option>
                                                <option>Manual</option>
                                                <option>Automatic</option>
                                            </select>
                                        </div>
                                        
                                          <div class="select-filters" style="margin-bottom: 5px;">
                                            <select class="form-control" name="bodyType" onchange="this.form.submit()">
												<option selected disabled style="display:none;"><%=((bodyType==null || bodyType.equals("null")?"Body Type":bodyType)) %></option>
												<option value="HATCHBACK">HATCHBACK </option>
												<option value="COUPE">COUPE</option>
												<option value="SUV/MUV">SUV/MUV</option>
												<option value="STATION WAGON">STATION WAGON</option>
												<option value="SEDAN">SEDAN</option>
												<option value="CONVERTIBLE">CONVERTIBLE</option>
											</select>
                                        </div>
                                        
                                    </form>
                                    
                                </div>
                            </div>
                            <!-- help center -->
                            
                          
                            
                            <div class="sidber-box help-widget  res3" >
                                <i class="flaticon-photographer-with-cap-and-glasses"></i>
                                <h4>Need <span>Help?</span></h4>
                                <a href="#" class="phone">040 - 48510133</a>
                                <small>Monday to Saturday 9.00am - 7.30pm</small>
                            </div>
                        </div>
                        <%
                        
                        ArrayList<UsedCar> carDetails=(ArrayList<UsedCar>)request.getAttribute("carDetails");
                        %>
                        <div class="col-sm-8 col-md-9 col-xs-12 well">
                         <%int i=1,j=1; %>
                            <div class="hotel-list-content">
                           
                           <div class="col-md-12 col-xs-12  " style="padding:4px">
                              <div class="">
                                <span id="msg" style="color:red;float:left;"></span>
                                <button class="btn btn-danger" type="submit" style="float: right; color:#fff; font-size: 15px; font-weight: 500; font-family: unset;" class="thm-btn" onclick="alert(getCheckedCheckboxesFor('compare'));">
                           Compare</button>
                           
                              </div>
                              </div> 
                            
                         <div style="float:right" class="col-md-12 col-sm-12 col-xs-12" id="hiddenArea">                         
                         	<%if(carDetails.size()<=0){ %>
                         	 <div style="float:right" class="col-md-12 col-sm-6" id="hiddenArea"><font color="red" size="3">Data Not Available if you want to post your <b><u><font color="blue">car</font></u></b> then please register here</font color="blue"> <a href="./register.jsp"><b><u><font color="blue">Registar</font></u></b></a></div>
                         	
                         	<%}else{} %>
                         	
                           <c:forEach var="carDetails"  items="${carDetails}">
                                <div class="row grid-margin border ">

              <!--<section class="container animated bounceInRight"> -->
    	<aside class="col-md-4 col-sm-12 col-xs-12 g zoom">
        <div class="col-md-12  margin" align="center">
    	 <a onclick="callMe('${carDetails.CAR_NUMBER}');" style="cursor: pointer;" class="darken">
          <img style="width:100%; max-height:162px;" src="data:image/png;base64,${carDetails.PHOTO1}" class="img-tumbline img-responsive"  alt="Image">
          <span><i class="fa fa-camera" aria-hidden="true"></i></span>
		</a>
        </div>
    	</aside>
    	
    	
    	<aside  class="col-md-8 col-sm-12 col-xs-12" style="padding:0 0px;">
    		<div class="col-md-5"><span class="se4"><c:out value="${carDetails.CAR_BRAND}"></c:out> > <c:out value="${carDetails.CAR_MODEL}"></c:out> > <c:out value="${carDetails.VARIANT_NAME}"></c:out></span>
        	</div>
        	<div class="col-md-6 col-sm-9 col-xs-9"">
        	  <span class="se5">Last Updated :</span> <span class="se6"><c:out value="${carDetails.UPDATED_DATE}"></c:out></span>
        	</div>
           <div class="col-md-1 " align="right">
           <input type="checkbox"  class="number" name="compare" value="${carDetails.GEN_CAR_ID}" id="option<%=i %>" style="margin-top: 0px !important;" />
           </div>
           
           <div class="col-md-12 col-sm-12 col-xs-12" >
            <span class="se1">Car ID :</span> <span class="se2">  <c:out value="${carDetails.GEN_CAR_ID}"></c:out></span>
           </div>
           
           <div class="col-md-12 col-sm-12 col-xs-12 line" >
           <c:set var="VALUE" value="${carDetails.OFFER_PRICE}"></c:set>
           
           <%String price=""; String value=(String)pageContext.getAttribute("VALUE");
            double  value_1= Integer.parseInt(value);
           price= new CurrencyFormate().indianrupee(value_1); %>
           
           
            <span class="se1">Price :</span> <span class="se2">  <i class="fa fa-inr"></i> <c:out value="<%=price%>"></c:out></span><br>
           </div>
           
           <div class="col-md-7 row">
            <div class="col-md-12 col-sm-12 col-xs-12 style="line-height: 32px;">
           	<span class="se1">Fuel Type :</span> <span class="se2"><c:out value="${carDetails.FUEL_TYPE}"></c:out></span>
           </div>
           <div class=" col-md-12 col-sm-12 col-xs-12" style="line-height: 32px;">
           		<span class="se1">Registered Year : </span><span class="se2"> <c:out value="${carDetails.REGISTERED_YEAR}"></c:out></span>
           </div>
           <div class=" col-md-12 col-sm-12 col-xs-12" style="line-height: 32px;">
          <span class="se1">City : </span> <span class="se2"> <c:out value="${carDetails.CITY}"></c:out></span>
           </div>
            <div class="col-md-12 col-xs-12 col-sm-12 row">
          <a href="#demo<%=i%>" class="btn btn-defalut text-primary"  data-toggle="collapse" style="line-height: 0px;">
          <span class="se3"><u>More Details</u></span></a>

      <div id="demo<%=i%>" class="collapse">
      <div class=" col-md-12 col-sm-12 col-xs-12">
      <span class="se1">Kms Driven : </span> <span class="se2"> <c:out value="${carDetails.KMS_DRIVEN}"></c:out></span>
      </div>
       
      <div class=" col-md-12 col-sm-12 col-xs-12">
      <span class="se1">Body Type : </span> <span class="se2"> <c:out value="${carDetails.BODY_TYPE}"></c:out></span>
      </div>
      
      <div class=" col-md-12 col-sm-12 col-xs-12">
      <span class="se1">Color : </span> <span class="se2"> <c:out value="${carDetails.COLOR}"></c:out></span>
      </div>
      
       <div class=" col-md-12 col-sm-12 col-xs-12">
       <span class="se1">Model Year : </span> <span class="se2"> <c:out value="${carDetails.MODEL_YEAR}"></c:out></span>
       </div>
         <div class=" col-md-12 col-sm-12 col-xs-12">
       <span class="se1">No Of Owners Used : </span> <span class="se2"> <c:out value="${carDetails.NO_OF_OWNERS}"></c:out></span>
       </div>  
        
       </div>
           
           </div> 
           <div class="col-md-12 col-xs-12 col-sm-12 row min2" >
    
</div>
           </div>
           
           <div class=" col-md-5 res1" style="margin-left: 10px" align="center">
          
         <div class="col-md-12 col-sm-12  res1" align="center" style="margin-left: 40px" >
            <div class="w3-container" style="padding: 0px !important;"> 
           
         
	       <c:set var="carId" value="${carDetails.GEN_CAR_ID}"/>
	       <%
			String email = (String) session.getAttribute("user"); 
			ArrayList<CarEndUser> requesters = (ArrayList<CarEndUser>)request.getAttribute("carrequesters");
			String carid=(String)pageContext.getAttribute("carId");
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
	      	GetUsedCarDetails carVisitors = new GetUsedCarDetails(); 
	      	int visitorValue = carVisitors.getCarVisitors(carid, '4');
 			if (requester.contains(carid)&&email!=null) { 
	%>
		<button type="button" class="btn btn-success" id="se7" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b>
		</button>
			<span>Interested in this car : </span><span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	<% 	} else if(email!=null){
	%>  
<%-- 		<a style="border-radius: 25px; border-color: snow;" class="btn btn-primary" href="./SendRequest?cid=${carDetails.GEN_CAR_ID}&cb=${carDetails.CAR_BRAND}" ><b style="  vertical-align:middle">SEND REQUEST</b></a> --%>
		<form id="myfor<%=i %>" method="post" action="./SendRequest">
		<input class="form-control" type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/>
      <input class="form-control" type="hidden" name="vehicleType" value="4"/>
      <input class="form-control" type="hidden" name="carBrand" value="<%=carBrand1%>"/>
      <input class="form-control" type="hidden" name="carModel" value="<%=carModel%>"/>
      <input type="hidden" name="carVariant" value="<%=carVariant%>">
      <input class="form-control" type="hidden" name="carAge" value="<%=carAge%>"/>
      <input class="form-control" type="hidden" name="colors" value="<%=color%>"/>
      <input class="form-control" type="hidden" name="fuelType" value="<%=fuelType%>"/>
      <input class="form-control" type="hidden" name="kms" value="<%=kms%>"/>
      <input class="form-control" type="hidden" name="transmission" value="<%=transmission%>"/>
      <input class="form-control" type="hidden" name="carBudget" value="<%=budget%>"/>
      <input class="form-control" type="hidden" name="city1" value="<%=city1%>"/>
      <input class="form-control" type="hidden" name="city" value="<%=city1%>"/>
      <input class="form-control" type="hidden" name="lHPrice" value="<%=range%>"/>
      <input class="form-control" type="hidden" name="bodyType" value="<%=bodyType%>"/>
	  	<a id="se7" class="btn btn-danger" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;">
	  	<span style="vertical-align: middle;">CONTACT OWNER</span></a>
	  	
		<span>Interested in this car : </span>
		<span style="color:#fff; font-size: 15px; font-weight: 500; font-family: unset;"><%=visitorValue%>  persons</span>
	</form>
		
	<%} else{%>
	<a id="se7"id="se7" class="btn btn-danger" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'">
	<span style="vertical-align: middle; ">CONTACT OWNER</span></a>
	<br>
	 <span>Interested in this car : </span> <span style="color:#a52a2a;"><%=visitorValue%>  persons</span> 
	<%} %>
	
  <div id="id0<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px;border-radius: 8px;margin-top:20px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id0<%=i %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertEndUserDetails" method="post">
      <input class="form-control" type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/>
      <input class="form-control" type="hidden" name="vehicleType" value="4"/>
      <input class="form-control" type="hidden" name="carBrand" value="<%=carBrand1%>"/>
      <input class="form-control" type="hidden" name="carModel" value="<%=carModel%>"/>
      <input type="hidden" name="carVariant" value="<%=carVariant%>">
      <input class="form-control" type="hidden" name="carAge" value="<%=carAge%>"/>
      <input class="form-control" type="hidden" name="colors" value="<%=color%>"/>
      <input class="form-control" type="hidden" name="fuelType" value="<%=fuelType%>"/>
      <input class="form-control" type="hidden" name="kms" value="<%=kms%>"/>
      <input class="form-control" type="hidden" name="transmission" value="<%=transmission%>"/>
      <input class="form-control" type="hidden" name="carBudget" value="<%=budget%>"/>
      <input class="form-control" type="hidden" name="city1" value="<%=city1%>"/>
       <input class="form-control" type="hidden" name="city" value="<%=city1%>"/>
      <input class="form-control" type="hidden" name="lHPrice" value="<%=range%>"/>
      <input class="form-control" type="hidden" name="bodyType" value="<%=bodyType%>"/>
      <c:out value="${carDetails.GEN_CAR_ID}"></c:out>
        <div class="w3-section">
         <h4 align="center">NEW USER</h4>
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="w3-input w3-border form-control" type="email" placeholder="Enter Email" name="email" required>
          <label><b>Mobile No</b></label>
          <input class="w3-input w3-border form-control" type="text" placeholder="Enter Mobile No." name="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password" required>
          <br>
          <button class="w3-button btn-primary w3-block w3-green w3-section w3-padding form-control" type="submit">Submit</button>
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px">
      <div class="col-md-6">
        <button style="float:left;" onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="w3-button w3-red form-control">
        Cancel</button>
      </div>
      
      <div class="col-md-6">
      <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'" style='float:right' class="form-control w3-button w3-red">
      Existing User</a>
      </div>
      
      
		 
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->

      </div>
   
  
</div>
</div>
 <div class="w3-container"> 
   <div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 400px;border-radius:8px;margin-top:20px ">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
        <div class="w3-section">
        <div id="txtHint"></div>
        <form action="./IndividualUser" class="w3-container" method="post">
           <label><b>Email</b></label>
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Email" name="email" required>
    		<input class="form-control" type="hidden" name="carBrand" value="<%=carBrand1%>"/>
    		<input class="form-control" type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/>
 		    <input class="form-control" type="hidden" name="vehicleType" value="4"/>
      		<input class="form-control" type="hidden" name="carModel" value="<%=carModel%>"/>
      		<input type="hidden" name="carVariant" value="<%=carVariant%>">
      		<input class="form-control" type="hidden" name="carAge" value="<%=carAge%>"/>
      		<input class="form-control" type="hidden" name="colors" value="<%=color%>"/>
      		<input class="form-control" type="hidden" name="fuelType" value="<%=fuelType%>"/>
      		<input class="form-control" type="hidden" name="kms" value="<%=kms%>"/>
      		<input class="form-control" type="hidden" name="transmission" value="<%=transmission%>"/>
      		<input class="form-control" type="hidden" name="carBudget" value="<%=budget%>"/>
      		<input class="form-control" type="hidden" name="city1" value="<%=city1%>"/>
      		 <input class="form-control" type="hidden" name="city" value="<%=city1%>"/>
      		<input class="form-control" type="hidden" name="lHPrice" value="<%=range%>"/>
      		<input class="form-control" type="hidden" name="page" value="<%=page1%>"/>
      		<input class="form-control" type="hidden" name="bodyType" value="<%=bodyType%>"/>
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password"  required>
          <br>
          <div class="col-md-6">
           <button class="w3-button btn-primary  w3-green w3-section w3-padding form-control" type="submit">Submit</button>
          
          </div>
          <div class="col-md-6">
          <a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
          
          </div>
         
    		
    </form>
        </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px;">
      <div class="col-md-6">
       <button onclick="document.getElementById('register').style.display='none'" type="button" class="form-control w3-button w3-red">
        Cancel</button>
      </div>
      
      <div class="col-md-6">
      <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="form-control w3-button w3-red">
    Go Back</button>
      </div>
      
       
    
      </div>
    </div>
  </div>
 </div>
           </div>
          </div>
           </div>
         
          
<!--            <div class="col-md-4 col-sm-12 col-xs-12 hover" align="center" > -->
<!--            <a href="#" onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large" ><b style="  vertical-align:middle">SEND REQUEST</b></a> -->
			
    	</aside>

<!--     </section> -->
                                                </div>
                                              <%i++; j++;%>
                                                </c:forEach>
                                               
                                            </div>
                                           
                                            
                                            <div class=" min res4" style="text-align: center">
                                <i class="flaticon-photographer-with-cap-and-glasses" style="font-size:35px "></i>
                                <h4>Need <span>Help?</span></h4>
                                <a href="#" class="phone">040 - 40191909</a>
                                <small>Monday to Saturday 9.00am - 7.30pm</small>
                            </div>

 
                                            <section>
                <div class="col-md-1 col-sm-1 col-xs-12 grid-item">Pages:</div>
                <c:forEach begin="1" end="${noOfPages}" var="m">
                <div class="col-sm-12 col-md-12 col-xs-12" style="margin-left: -22px;width:40px;">
                <form id="myfor<%=i %>" method="post" action="./SearchUsedCar" > 

<%--          <input type="hidden" name="carId" value="${carDetails.GEN_CAR_ID}"/> --%>
           <input class="form-control" type="hidden" name="vehicleType" value="4"/>
            <input class="form-control" type="hidden" name="carBrand" value="<%=carBrand1==null?"SELECT":carBrand1%>"/>
            <input class="form-control" type="hidden" name="carModel" value="<%=carModel==null?"SELECT":carModel%>"/>
            <input type="hidden" name="carVariant" value="<%=carVariant==null?"SELECT":carVariant%>">
            <input class="form-control" type="hidden" name="carAge" value="<%=carAge%>"/>
            <input class="form-control" type="hidden" name="colors" value="<%=color%>"/>
            <input class="form-control" type="hidden" name="fuelType" value="<%=fuelType%>"/>
            <input class="form-control" type="hidden" name="kms" value="<%=kms%>"/>
            <input class="form-control" type="hidden" name="transmission" value="<%=transmission%>"/>
            <input class="form-control" type="hidden" name="carBudget" value="<%=budget==null?"SELECT":budget%>"/>
            <input class="form-control" type="hidden" name="city" value="<%=city1==null?"SELECT":city1%>"/>
            <input class="form-control" type="hidden" name="lHPrice" value="<%=range%>"/>
            <input class="form-control" type="hidden" name="bodyType" value="<%=bodyType%>"/>
             <input class="form-control" type="hidden" name="page" value="${m}"/> 
             
       <a onclick="document.getElementById('myfor<%=i %>').submit();" style="cursor: pointer;"><c:out value="${m}"></c:out>&nbsp;&nbsp;</a>
       
 
     
    <%i++; %>
    </form>
    </div>
   </c:forEach>
   
   
   </section>
                                        </div>
                                        
                                        
                                        
                                    </div>                               
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
	<script>
function showVariant(str) {

	var vbrand = document.getElementById("brand").value;
	if (str=="")  
	{  
		document.getElementById("txtHint2").innerHTML="";  
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
			document.getElementById("txtHint2").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getCarVariant.jsp?brand="+vbrand+"&model="+str,true);   
	xmlhttp.send();    
	}
	</script>
    </body>
</html>