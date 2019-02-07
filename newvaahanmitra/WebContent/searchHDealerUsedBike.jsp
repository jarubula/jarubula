<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vaahanmitra | Search</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
 
 
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
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

 	var popup=window.open('./dealerBikeImage.jsp?photo='+myId,'mywindow','width=2000,height=1000,titlebar=0,status=no,toolbar=no,location=no,directories=no');
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
var n=window.open("CompareUsedBike?compare="+value1,"myWin", "left=700, top=200, width=850, height=700");
 }else if(value1.length<2){
	
	/*  alert("please select maximum 3 checkboxes to compare your selection.."); */
	 document.getElementById("msg").innerHTML = "please select maximum 3 Bikes <br>to compare your selection..";
	  
 }else if(value1.length>3){
	 
/*  	 alert("you can not select more than  3 checkboxes to compare your selection.."); */
	 document.getElementById("msg").innerHTML = "you can not select more than  3 Bikes <br>to compare your selection..";
	  
	  
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
}
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

	</style>
  
  
    </head>
    <body>
 
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content" style="background:#f1f2f3">
            <!-- navber -->
             <jsp:include page="./homeTop.jsp"></jsp:include>     <!-- /.container --> 
            <!-- /.nav end -->
            <!-- page header -->
            <!-- hotel -->
            <section class="tour-inner" id="top2" style="background:#f1f2f3">
                <div class="container" >
                    <div class="col-md-12 col-xs-12" style="background:#fff">
                        
                        <!-- collapse map -->
                        <div class="col-sm-12">
                            <div class="collapse" id="collapseMap">
                                <!-- The element that will contain Google Map. This is used in both the Javascript and CSS above. --> 
                                <div id="map"></div>
                            </div>
                        </div>
                        <!-- sideber -->
                        <div class="col-sm-4 col-md-3">
                            <!-- price pips -->
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
    String email1 = (String) session.getAttribute("user"); 
    %>
    <br>
                            <form action="./SearchHDealerUsedBike" method="post">
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
                                   					String bcity=(String)request.getAttribute("city");
                                     				String bikeBrand1=(String)request.getAttribute("bikeBrand");
                                     				String budget=(String)request.getAttribute("budget");
                                     				String bikeModel=(String)request.getAttribute("bikeModel");
                                     				String bikeAge=(String)request.getAttribute("bikeAge");
                                     				String color=(String)request.getAttribute("color");
                                     				String kms=(String)request.getAttribute("kms");
                                     				String owners=(String)request.getAttribute("owners");
                                     				String email=(String)request.getAttribute("email");
                                     				String vehicleType=(String)request.getAttribute("vehicleType");
                                     				String name=(String)request.getAttribute("name");
                                     				
                                     				System.out.println("brand"+bikeBrand1);
                                     				
                                                    GetUsedBikeDetails bikeCity1=new GetUsedBikeDetails();
                                                    ArrayList<UsedBike> bikeCity=bikeCity1.getUsedBikeCity();
                                                    Iterator itr= bikeCity.iterator();
                                                    %>
                                                    <input type="hidden" name="email" value="<%=email %>"/>
                                                    <input type="hidden" name="vehicleType" value="<%=vehicleType %>"/>
                                                    <input type="hidden" name="dealerName" value="<%=name %>"/>
                                                    
                                            <%--         <div class="select-filters" style="margin-bottom: 5px;">
                                                 	<select name="city" id="sort-price" onchange="this.form.submit()">
                                                                <option selected disabled style="display:none;"><%=((bcity==null?"city":bcity)) %></option>
                                                                <%
                                                                while(itr.hasNext()){
                                                                	UsedBike bcity1=(UsedBike)itr.next();
                                                                	%>
                                                                	<option><%=bcity1.getCITY()%></option>
                                                                <%
                                                                }
                                                                %>
                                                            </select>
                                        </div> --%>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                    <select name="bikeBudget" id="sort-price" onchange="this.form.submit()">
                                                <option value="" style="display:none;">Budget</option>
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
                                            <select name="bikeBrand" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=bikeBrand1 == null? "Brand":bikeBrand1.equals("SELECT") ? "Brand" : bikeBrand1%></option>
                                               	<option value="All">All</option>
                                                <%
											GetUsedBikeDetails bikeBrand=new GetUsedBikeDetails();
											ArrayList<UsedBike> bikeBnd=bikeBrand.getUsedBikeBrand();
											%>
                                                <%
													Iterator it= bikeBnd.iterator();
													while(it.hasNext()){
														UsedBike usedBike=(UsedBike)it.next();
														%>
                                                <option><%=usedBike.getBIKE_BRAND()%></option>
                                                <%
													}
													%>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="colors" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;"><%=((color == null ? "Color" : color))%></option>
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
                                <!--     <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="fuelType" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled>Fuel Type</option>
                                                <option>Petrol</option>
                                                <option>Diesel</option>
                                                <option>CNG</option>
                                                <option>LPG</option>
                                                <option>ELECTRIC</option>
                                            </select>
                                        </div> -->
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="bikeAge" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled style="display:none;">Bike Age</option>
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
                                            <select name="bodyType" id="sort-price">
                                                <option selected disabled style="display:none;">Body Type</option>
                                                <option value="lower">1 Lak</option>
                                                <option value="higher">2 Laks</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="owners" id="sort-price" onchange="this.form.submit()">
                                                <option value="0" style="display:none;">Owner</option>
                                                <option value="1">First Owner</option>
                                                <option value="2">Second Owner</option>
                                                <option value="3">More Owner</option>
                                                <option value="4" disabled>Unregistered Car</option>
                                            </select>
                                        </div>
                                    <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="sellerType" id="sort-price">
                                                <option selected disabled style="display:none;">Seller Type</option>
                                                <option>Dealer</option>
                                                <option>Individual</option>
                                            </select>
                                        </div>
                    <!--                 <div class="select-filters" style="margin-bottom: 5px;">
                                            <select name="transmission" id="sort-price" onchange="this.form.submit()">
                                                <option selected disabled>Transmission</option>
                                                <option>Manual</option>
                                                <option>Automatic</option>
                                            </select>
                                        </div> -->
                                    
                                    
                                    </form>
                                    
                                </div>
                            </div>
                            <!-- help center -->
                            
                            <div class="sidber-box help-widget res3">
                                <i class="flaticon-photographer-with-cap-and-glasses"></i>
                                <h4>Need <span>Help?</span></h4>
                                <a href="#" class="phone">040 - 40191909</a>
                                <small>Monday to Saturday 9.00am - 7.30pm</small>
                            </div>
                        </div>
                        <%
                        
                        ArrayList<UsedCar> bikeDetails=(ArrayList<UsedCar>)request.getAttribute("bikeDetails");
                        
                        %>
                       <div class="col-sm-8 col-md-9 col-xs-12 well"  style="margin-top:21px">
                       <br>
                         <%int i=1,j=1; %>
                            <div class="hotel-list-content">
                            <div class="col-md-8 col-xs-12">
                            
                            Search two wheeler for 
					        <form id="myfor<%=i %>" method="post" action="./SearchHDealerUsedCar">
						  <input type="hidden" name="email" value="<%=email%>" />
						  <input type="hidden" name="vehicleType" value="<%=vehicleType%>" />
						  <input type="hidden" name="name" value="<%=name%>" />
						  <input type="submit" value="<%=name%>" class="thm-btn submitLink" style="position: relative;margin-bottom: 14px;">
						  dealer
						</form>
                            <%-- <a href="./SearchHDealerUsedCar?email=<%=email %>&vehicleType=<%=vehicleType %>&name=<%=name %>" class="thm-btn" style="margin-bottom: 14px;">
                           Search four wheeler for <u><%=name %></u> dealer	</a> --%>
                            
                            </div>
                            <div class="col-md-4 col-xs-12">
                             <button class="btn btn-primary" type="submit" style="padding:10px 15px; float: right;margin-bottom: 5px;position: relative;right: 5px;" class="thm-btn" onclick="alert(getCheckedCheckboxesFor('compare'));">
                             
                             Compare
                             </button>
                             
                             </div>
                             <div class="col-md-6 col-xs-12" style="margin-top:10px">
                             <font color="red" style="box-sizing: inherit;color: #523f6d;font-size: 18px;font-family: sans-serif;text-align: center;">Inventory of <%=name %></font> 
                             
                             </div>
                             
                             <div class="col-md-6 col-xs-12">
                             
                             <span id="msg" style="color:red;float:right;position: relative;font-size: 12px;">
           
           </span>
                             </div>
                            <div class="col-md-12 col-xs-12">
                             <br>
                            </div>
                             
<!--                                <form action="./CompareUsedCar" method="post"> -->
					        <div style="float:right" class="col-md-12 col-sm-12 col-xs-12" id="hiddenArea">
					       
					       
	
    	 					<div style="float:right" class="col-md-12 col-sm-12 col-xs-12" id="hiddenArea">        
					       
					         
					         <%
					         if(vehicleType!=null){
					         if(vehicleType.equals("4,2,")){ 
					         %>
								
							<%}}else{} %>
                           </div>
                         <%if(bikeDetails!=null && bikeDetails.size()<=0){ %>
                         	 <div style="float:right" class="col-md-12 col-sm-6" id="hiddenArea"><font color="red" size="3">Data Not Available if you want to post your <b><u><font color="blue">Inventory</font></u></b> then please login here</font color="blue"> <a href="./login3.jsp"><font color="blue"><b><u>Login</u></b></font></a></div>
                         	
                         	<%}else{} %>
                           <c:forEach var="bikeDetails"  items="${bikeDetails}">
                                <div class="row grid-margin border">
                                        <%--         <div class="col-md-4 col-sm-6 col-xs-12 grid-item well">
                                         <div class="grid-item-inner" id="mainDiv">
                                            <div class="grid-img-thumb">
                                                  ribbon 
                                                 <div class="ribbon"><span>Popular</span></div>
                                               <div style="height:100%;width:100%"><a onclick="callMe('${bikeDetails.BIKE_NUMBER}');" style="cursor: pointer;">
                                               <img src="data:image/png;base64,${bikeDetails.PHOTO1}" alt="No image" class="img-responsive">
                                               </a>
                                               </div>
                                            </div> 

                                        </div> 
                                        

                                    </div> --%>
                                     <!-- ../grid item -->
                             <%--        <div class="col-md-8 col-sm-6 col-xs-12 grid-item">
                                      
                                        
                                        <section class="well"  style="/* background-color: #efefef;height: 204px; */padding-top:10px;">
                                           <span style="color: #3c763d;font-size: 15px;padding-left: 20px;margin-top:10px"><b><c:out value="${bikeDetails.BIKE_BRAND}"></c:out>&nbsp;&nbsp;&nbsp;<c:out value="${bikeDetails.BIKE_MODEL}"></c:out></b></span>&nbsp;/&nbsp;
                                           <span style="color: #523f6d;font-size: 12px;padding-left: 20px;margin-top:10px"><b><font color="red">BikeId :</font>&nbsp;&nbsp;<c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out></b></span>
                                            
                                            <span style="float:right;margin-right:10px;"><input type="checkbox"  class="number" name="compare" value="${bikeDetails.GEN_BIKE_ID}" id="option<%=i %>"/></span><span id="msg" style="color:red;float:right;position: relative;left: 48%;font-size: 12px;top: -16px;"></span>
                                               
                                                      <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b> <br>PRICE&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;">&#8377;&nbsp;&nbsp;&nbsp;<c:out value="${bikeDetails.OFFER_PRICE}"></c:out></span><p></p></b></span> 
                                                       
                                        <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Current Mileage&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${bikeDetails.CURRENT_MILEAGE}"></c:out>&nbsp;&nbsp;&nbsp;km&nbsp;&nbsp;&nbsp;</span></b></span><p></p>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Registered Year&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${bikeDetails.REGISTERED_YEAR}"></c:out></span></b></span><p></p>
                                                        <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Color&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${bikeDetails.COLOR}"></c:out></span></b></span><p></p>
                                                       <span style="color: red;font-size: 12px;padding-left: 20px;position: relative;top: 10px;"><b>Registered State&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<span style="color:#523f6d;"><c:out value="${bikeDetails.REGISTERED_STATE}"></c:out></span></b></span>
                                                          <br>
<div class="w3-container"> 
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
 			if (requester.contains(bikeid)&&email1!=null) { 
	%> 
		<button type="button" style="float:right;margin-top:25px" class="w3-button w3-green w3-large" disabled><b style="color: green">REQUEST SENT</b></button>
	<% 	} else if(email1!=null){
	%>  
		<a href="./SendBikeRequest?bid=${bikeDetails.GEN_BIKE_ID}&de=<%=email %>&vt=2," class="w3-button w3-green w3-large" style="float:right;margin-top:25px"><b style="color:black">SEND REQUEST</b></a>
	<%} else{%>
	<a href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-green w3-large" style="float:right;margin-top:25px"><b style="color:black">SEND REQUEST</b></a>
	<%} %>	
												<div id="id0<%=i%>" class="w3-modal">
													<div class="w3-modal-content w3-card-4 w3-animate-zoom"
														style="max-width: 600px">

														<div class="w3-center">
															<br> <span
																onclick="document.getElementById('id0<%=i%>').style.display='none'"
																class="w3-button w3-xlarge w3-hover-red w3-display-topright"
																title="Close Modal">&times;</span>
														</div>
      <form class="w3-container" action="./InsertBikeRequester" method="post">
      <input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}"/>
      <input type="hidden" name="vehicleType" value="2"/>
      <input type="hidden" name="city" value="<%=bcity%>"/>
      <input type="hidden" name="demail" value="<%=email %>"/>
      <input type="hidden" name="dealerName" value="<%=name %>"/>
      <input type="hidden" name="bikeBrand" value="<%=bikeBrand1 %>"/>
      <input type="hidden" name="budget" value="<%=budget %>"/>
      <input type="hidden" name="bikeModel" value="<%=bikeModel %>"/>
      <input type="hidden" name="bikeAge" value="<%=bikeAge %>"/>
      <input type="hidden" name="colors" value="<%=color %>"/>
      <input type="hidden" name="kms" value="<%=kms %>"/>
      <input type="hidden" name="owners" value="<%=owners %>"/>
      <input type="hidden" name="lHPrice" value="<%=range%>"/>
      
      <c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out>
        <div class="w3-section">
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="w3-input w3-border" type="email" placeholder="Enter Email" name="email" required>
           <label><b>Mobile No</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Enter Mobile No" name="mobileNo" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Submit</button>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
		 <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'" style='float:right'><u>Existing User</u></a>
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
        <form action="./IndividualBike" class="w3-container" method="post">
           <label><b style="margin-left: 13px;">Email</b></label>
          <input class="w3-input w3-border w3-margin-bottom"  type="text" placeholder="Enter Email" name="email" required>
    		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>"/>
          <label><b style="margin-left: 13px;">Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password"  required>
          <button class="w3-button w3-block w3-green w3-section w3-padding"  type="submit">Submit</button>
          <a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
    </form>
        </div>
       <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('register').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
         <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-red">Go Back</button>
      </div>   
      </div>
  </div>


</section>
                                    </div>  --%>
                                    
                                    
                                    
             <aside class="col-md-4 col-sm-12 col-xs-12 g zoom">
    		<div class="col-md-12 " align="center" class="darken">
    		
<%--     		<a onclick="callMe('${bikeDetails.BIKE_NUMBER}');" style="cursor: pointer;" class="darken">  --%>
			  <a href="./dealerBikeImage.jsp?photo=${bikeDetails.BIKE_NUMBER}" style="cursor: pointer;" class="darken" target="_blank">
			<img style="width: 200px;height:160px" src="data:image/png;base64,${bikeDetails.PHOTO1}"  class="img-responsive" style="height: 204px;" alt="Image">
			<span><i class="fa fa-camera" aria-hidden="true"></i></span>
			</a>
			
        </div>

    	</aside>
    	<aside class="col-md-8 col-sm-12 col-xs-12">
    		<div class="col-md-10"><span style="color: #3c763d;font-size: 15px;"><b><c:out value="${bikeDetails.BIKE_BRAND}"></c:out>&nbsp;&nbsp;<c:out value="${bikeDetails.BIKE_MODEL}"></c:out></b></span>
             <span style="color: #523f6d;font-size: 12px;"><br><b><font color="red">BikeId:</font><c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out></b></span>
        	</div>
           <div class="col-md-2 col-sm-12 " align="right">
        
           <input type="checkbox"  name="compare" value="${bikeDetails.GEN_BIKE_ID}" id="option<%=i %>" onclick="ShowHideDiv(this)"/>
           
           
           </div>
           <div class="col-md-12 col-sm-12 col-xs-12 line">
           	<span style="color: #555;font-size: 12px;padding-left: 20px;position: "><b style="color:black;font-size:17px"> <br>PRICE&nbsp;:&nbsp;<span style="color:brown;text-transform: lowercase;">&#8377;&nbsp;&nbsp;&nbsp;<c:out value="${bikeDetails.OFFER_PRICE}"></c:out></span><br></b></span>
           </div>
          
          <div class="row col-md-7">
           <div class=" col-md-12 col-sm-12 col-xs-12">
           	<span style="color: #555;font-size: 12px;"><b>Registered Year&nbsp;:&nbsp;<span style="color:#523f6d;text-transform: lowercase;"><c:out value="${bikeDetails.REGISTERED_YEAR}"></c:out></span></b></span>
           </div>
           <div class=" col-md-12 col-sm-12 col-xs-12">
           <span style="color: #555;font-size: 12px;"><b>City&nbsp;:&nbsp;<span style="color:#523f6d;"><c:out value="${bikeDetails.REGISTERED_STATE}"></c:out></span></b></span>
           </div>
           <div class="col-md-12 col-xs-12 col-sm-12 row">
           
       <a href="#demo<%=i%>" class="btn btn-defalut text-primary collapsed" data-toggle="collapse" aria-expanded="false">
       <b><u>More Details</u></b></a>

  <div id="demo<%=i%>" class="collapse" aria-expanded="false" style="height: 0px;">
 <div class=" col-md-12 col-sm-12 col-xs-12">
           	<span style="color: #555;font-size: 12px;"><b>Kms Driven&nbsp;:&nbsp;<span style="color:#523f6d;text-transform: lowercase;"><c:out value="${bikeDetails.KMS_DRIVEN}"></c:out></span><br></b></span>
           </div>
 	    	<div class=" col-md-12 col-sm-12 col-xs-12">
           	<span style="color: #555;font-size: 12px;"><b>Color&nbsp;:&nbsp;<span style="color:#523f6d;text-transform: lowercase;"><c:out value="${bikeDetails.COLOR}"></c:out></span><br></b></span>
           </div>
           <div class=" col-md-12 col-sm-12 col-xs-12">
           	<span style="color: #555;font-size: 12px;"><b>Starting System&nbsp;:&nbsp;<span style="color:#523f6d;text-transform: lowercase;"><c:out value="${bikeDetails.STARTING_SYSTEM}"></c:out></span><br></b></span>
           </div>
  </div>
           
           </div>
          
          </div>
		<div class="col-md-5 col-sm-12 col-xs-12  res1" align="center"  style="margin-left: 29px;">
<!--            <a href="#" onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large" ><b style="  vertical-align:middle">SEND REQUEST</b></a> -->
           
            <div class="col-md-12 col-sm-12  " align="center"  >
<div class="w3-container"> 
         
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
 			if (requester.contains(bikeid)&&email1!=null) { 
	%> 
		<button type="button" class="btn btn-success" style="  border-radius: 5px;border-color: snow;font-size: 13px;" class="btn btn-primary" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b></button>
		<br>
			Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	<% 	} else if(email1!=null){
	%>  
<%-- 		<a style="border-radius: 25px; border-color: snow;" class="btn btn-primary" href="./SendBikeRequest?bid=${bikeDetails.GEN_BIKE_ID}&de=<%=email %>&vt=2,"><b style="vertical-align:middle">SEND REQUEST</b></a> --%>
			
			<form id="myfor<%=i %>" method="post" action="./SendBikeRequest">
			<input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}"/>
      		<input type="hidden" name="vehicleType" value="<%=vehicleType%>"/>
      		<input type="hidden" name="city" value="<%=bcity%>"/>
      		<input type="hidden" name="demail" value="<%=email %>"/>
      		<input type="hidden" name="dealerName" value="<%=name %>"/>
      		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1 %>"/>
      		<input type="hidden" name="budget" value="<%=budget %>"/>
      		<input type="hidden" name="bikeModel" value="<%=bikeModel %>"/>
      		<input type="hidden" name="bikeAge" value="<%=bikeAge %>"/>
      		<input type="hidden" name="colors" value="<%=color %>"/>
      		<input type="hidden" name="kms" value="<%=kms %>"/>
      		<input type="hidden" name="owners" value="<%=owners %>"/>
      		<input type="hidden" name="lHPrice" value="<%=range%>"/>
      		<input type="hidden" name="page" value="<%=page1%>"/>
	       <a style="  border-radius: 5px;border-color: snow;font-size: 13px;" class="btn btn-primary" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;">CONTACT SELLER</a></span>
			Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	</form>
	
	<%} else{%>
	<a style="  border-radius: 5px;border-color: snow;font-size: 13px;" class="btn btn-primary" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'"><b style="vertical-align:middle">CONTACT SELLER</b></a>
	<br>
	Interested in this Bike :<span style="color:#a52a2a;"><%=visitorValue%></span>  persons
	<%} %>	
												<div id="id0<%=i%>" class="w3-modal">
													<div class="w3-modal-content w3-card-4 w3-animate-zoom"
														style="max-width: 425px; border-radius: 9px;">

														<div class="w3-center">
															<br> <span
																onclick="document.getElementById('id0<%=i%>').style.display='none'"
																class="w3-button w3-xlarge w3-hover-red w3-display-topright"
																title="Close Modal">&times;</span>
														</div>
      <form class="w3-container" action="./InsertBikeRequester" method="post">
      <input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}"/>
      <input type="hidden" name="vehicleType" value="<%=vehicleType%>"/>
      <input type="hidden" name="city" value="<%=bcity%>"/>
      <input type="hidden" name="demail" value="<%=email %>"/>
      <input type="hidden" name="dealerName" value="<%=name %>"/>
      <input type="hidden" name="bikeBrand" value="<%=bikeBrand1 %>"/>
      <input type="hidden" name="budget" value="<%=budget %>"/>
      <input type="hidden" name="bikeModel" value="<%=bikeModel %>"/>
      <input type="hidden" name="bikeAge" value="<%=bikeAge %>"/>
      <input type="hidden" name="colors" value="<%=color %>"/>
      <input type="hidden" name="kms" value="<%=kms %>"/>
      <input type="hidden" name="owners" value="<%=owners %>"/>
      <input type="hidden" name="lHPrice" value="<%=range%>"/>
      <input type="hidden" name="page" value="<%=page1%>"/>
      
      <c:out value="${bikeDetails.GEN_BIKE_ID}"></c:out>
        <div class="w3-section">
          <label><b>Username</b></label>
          <input class="form-control" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="form-control" type="email" placeholder="Enter Email" name="email" required>
           <label><b>Mobile No</b></label>
          <input class="form-control" type="text" pattern="[1-9]{1}[0-9]{9}" placeholder="Enter 10 digit mobile number" title="Enter 10 digit mobile number" name="mobileNo" required>
          <label><b>Password</b></label>
          <input class="form-control" type="password" placeholder="Enter Password" name="password" required>
          <br>
         <button type="submit" class="btn btn-primary btn-block">Submit</button> <br>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey " style="border-radius: 9px;">
        <button onclick="document.getElementById('id0<%=i %>').style.display='none'" type="button" class="btn btn-danger">Cancel</button>
		 <a href="#" onClick="document.getElementById('id0<%=i %>').style.display='none',document.getElementById('register').style.display='block'" ><u>Existing User</u></a>
      </div>
    </div>
  </div>
  </div>

<div class="w3-container"> 
	<div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 425px; border-radius: 9px;">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
        <div class="w3-section">
        <div id="txtHint"></div>
        <form action="./DealerUsedBikeLogin" class="w3-container" method="post">
           	<label><b>Email</b></label>
          	<input class="form-control"  type="text" placeholder="Enter Email" name="email" required>
<%--     		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1%>"/> --%>
          	<label><b>Password</b></label>
          	<input class="form-control" type="password" placeholder="Enter Password" name="password"  required>
          <br>
         <button type="submit" class="btn btn-primary btn-block">Submit</button> 
          	<a href="./forgotPasswordEmail.jsp" style="color:red;float:right;  margin: 10px 0;"><u>Forgot Password</u></a>
    		
    		<input type="hidden" name="bikeId" value="${bikeDetails.GEN_BIKE_ID}"/>
      		<input type="hidden" name="vehicleType" value="<%=vehicleType%>"/>
      		<input type="hidden" name="city" value="<%=bcity%>"/>
      		<input type="hidden" name="demail" value="<%=email %>"/>
      		<input type="hidden" name="dealerName" value="<%=name %>"/>
      		<input type="hidden" name="bikeBrand" value="<%=bikeBrand1 %>"/>
      		<input type="hidden" name="budget" value="<%=budget %>"/>
      		<input type="hidden" name="bikeModel" value="<%=bikeModel %>"/>
      		<input type="hidden" name="bikeAge" value="<%=bikeAge %>"/>
      		<input type="hidden" name="colors" value="<%=color %>"/>
      		<input type="hidden" name="kms" value="<%=kms %>"/>
      		<input type="hidden" name="page" value="<%=page1%>"/>
      		<input type="hidden" name="owners" value="<%=owners %>"/>
      		<input type="hidden" name="lHPrice" value="<%=range%>"/>
    	
    	</form>
        </div>
       <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius: 9px;">
        <button onclick="document.getElementById('register').style.display='none'" type="button" class="btn btn-danger">Cancel</button>
         <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="btn btn-danger">Go Back</button>
      </div>   
      </div>
  </div>
           
           
           </div>
           </div>
           </div>


    	</aside>
                           
                                                </div>
                                              <%i++; j++;%>
                                                </c:forEach>
                  <div class="sidber-box help-widget res4 border" style="margin-right:-9px;margin-left: -9px;">
                                <i class="flaticon-photographer-with-cap-and-glasses"></i>
                                <h4>Need <span>Help?</span></h4>
                                <a href="#" class="phone">040 - 40191909</a>
                                <small>Monday to Saturday 9.00am - 7.30pm</small>
                            </div>
                                               
                                            </div>
                                            <section>
                <div class="col-md-1 col-sm-1 col-xs-12 grid-item">Pages:</div>
              
                <c:forEach begin="1" end="${noOfPages}" var="m">
                <div class="col-sm-12 col-md-12 col-xs-12" style="margin-left: -22px;width:40px;">
                <form id="myfor<%=i %>" method="post" action="./SearchHDealerUsedBike"> 

             <input type="hidden" name="vehicleType" value="<%=vehicleType%>"/>
             <input type="hidden" name="city1" value="hyderabad"/>
             <input type="hidden" name="email" value="<%=email %>"/>
             <input type="hidden" name="lHPrice" value="<%=range%>"/>
             <input type="hidden" name="name" value="<%=name%>"/>
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
                                    <!-- ../grid item -->
                                </div>

                                </section>
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
                                <input type="text" class="form-control" placeholder="Enter Your Email" name="q">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section> --></div>
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
                 
                                    


    </body>

</html>