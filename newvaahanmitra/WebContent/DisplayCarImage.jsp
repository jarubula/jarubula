<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Image</title>
    <link rel="stylesheet" href="assets/css/display.css">

    <!-- Bootstrap CSS -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>     
       
       <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
       <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>

<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.css'>

      
<link rel="stylesheet" href="assets/css/couroselStyle.css">
   <%
String message1 = (String) request.getAttribute("message");
//	String bikeId = (String) request.getAttribute("bikeId");
//	if (message1 != null) {
%>
<style type="text/css">
.w3-section, .w3-code {
   
    margin: 0 0px !important;
}
.img img{
height:500px;

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
.two{
    font-size: 16px;
    color: #f50000;
    font-family: monospace;
    }
  .one{
       color: #000;
    font-size: 17px;
    font-weight: normal;
    font-family: monospace;
    opacity: 0.6;
    }
   .three{
       color: #000;
    font-size: 23px;
    font-weight: normal;
    font-family: monospace;
    }
    
    .five{
     color: #9a2220;
    font-size: 26px;
    font-weight: 500;
    font-family: monospace;
    }
.popup{
width: 100%;
margin: 0 auto;
display: none;
position: fixed;
z-index: 101;
}
b, strong {
    font-weight: normal;
    font-size: 15px;
    font-family: sans-serif;
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
#se7{
    width: 170px;
    background: #fff;
    border: solid 1px #9a2220;
    color: #9a2220;
    letter-spacing: 0;
    height: 32px;
    line-height: 28px;
    padding: 0;
    text-align: center;
    font-size: 15px;
    font-family: sans-serif;
    }
     #se7:hover{
    width: 170px;
     background: #9a2220;
    border: solid 1px #9a2220;
    color: #fff;
    letter-spacing: 0;
    height: 32px;
    line-height: 28px;
    padding: 0;
    text-align: center;
    font-size: 15px;
    font-family: sans-serif;
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
 
</head>
<body>
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


      	<jsp:include page="./homeTop.jsp"></jsp:include>

     <script type="text/javascript">
  $(document).ready(function(){

$('#itemslider').carousel({ interval: false });

$('.carousel-showmanymoveone .item').each(function(){
var itemToClone = $(this);

for (var i=1;i<6;i++) {
itemToClone = itemToClone.next();

if (!itemToClone.length) {
itemToClone = $(this).siblings(':first');
}

itemToClone.children(':first-child').clone()
.addClass("cloneditem-"+(i))
.appendTo($(this));
}
});
});
 </script>
<!--Item slider text-->
<!-- <div class="container">
  <div class="row" id="slider-text">
    <div class="col-md-6" >
      <h2>NEW COLLECTION</h2>
    </div>
  </div>
</div> -->

<!-- Item slider-->

<%
	ArrayList<String> ceu =null;
	String carNumber=request.getParameter("photo");
	if(carNumber==null){
		carNumber = (String)request.getAttribute("carNumber"); 		
	}	
	GetUsedCarDetails carImage=new GetUsedCarDetails();
	ArrayList<UsedCar> image=carImage.getCarImage(carNumber);
	UsedCar usedCar=carImage.getUsedCarByCarNo(carNumber);
	List<UsedCar> usedCarWithImage=carImage.getUsedCarWithPhotoByCarNo(usedCar.getCAR_BRAND(),usedCar.getOFFER_PRICE(),usedCar.getKMS_DRIVEN(),carNumber);
	String email = (String) session.getAttribute("user"); 
	if(email!=null){
		ceu = carImage.getRequesters(email);	
	}
	Iterator it=image.iterator();
%>

<div style="background: #FFF">
  <div class="w3-content w3-display-container col-md-8 col-xs-12 col-sm-12 img">
  <%while(it.hasNext()){
	UsedCar photo=(UsedCar)it.next();
%>
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO1() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO2()==null?photo.getPHOTO1():photo.getPHOTO2() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO3()==null?photo.getPHOTO1():photo.getPHOTO3() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO4()==null?photo.getPHOTO1():photo.getPHOTO4() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO5()==null?photo.getPHOTO1():photo.getPHOTO5() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO6()==null?photo.getPHOTO1():photo.getPHOTO6() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO7()==null?photo.getPHOTO1():photo.getPHOTO7() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO8()==null?photo.getPHOTO1():photo.getPHOTO8() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO9()==null?photo.getPHOTO1():photo.getPHOTO9() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO10()==null?photo.getPHOTO1():photo.getPHOTO10() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO11()==null?photo.getPHOTO1():photo.getPHOTO11() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO12()==null?photo.getPHOTO1():photo.getPHOTO12() %>" style="width:100%">
  <%
}
%>
  <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
</div>
<div class="col-md-4 col-xs-12  well" style=" border-radius: 4px; font-family: Georgia; background: #fff;box-shadow: 0 1px 4px 0 rgba(0,0,0,.21);">
  <div class="row a2">
    <div class="col-md-6">
      <span class="five"><%=usedCar.getCAR_BRAND() %>&nbsp;<%=usedCar.getCAR_MODEL() %></span>
    </div>
      <div class="col-md-6">
      
      
      <div class="col-md-12">

<%int i=1;%>
<div class="w3-container"> 
	<%
 			if (ceu!=null && ceu.contains(usedCar.getGEN_CAR_ID())&&email!=null) { 
	%>	
	<button type="button" class="btn btn-success" id="se7" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b></button>
	<br>
	 	<% 
	 		} else if(email!=null){
		%>
	<form id="myfor<%=i %>" method="post" action="./SendCarRequest">
		<input type="hidden" name="carNumber" value="<%=carNumber%>"/>
		<input type="hidden" name="carId" value="<%=usedCar.getGEN_CAR_ID()%>"/>
		  <a id="se7" class="btn btn-primary" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;">CONTACT OWNER</a>
	</form>
		
	<%} else{%>
	 <a id="se7" class="btn btn-primary" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'"><b style="  vertical-align:middle">CONTACT OWNER</b></a>
<!-- 	<a style="border-radius: 25px; border-color: snow;" class="btn btn-primary" href="#" onclick="document.getElementById('id01').style.display='block'"><b style="  vertical-align:middle">CONTACT OWNER</b></a> -->
 	<%} %>
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px ;border-radius: 9px;margin-top: 20px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertIndividualUser" method="post">
        <div class="w3-section" >
       <h4 align="center">NEW USER</h4>
       <div class="col-md-12">
          <label><b>Username</b></label>
    
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Username" name="name" required>
          </div>
          <div class="col-md-12">
          <label><b>Email</b></label>
          
          <input class="w3-input w3-border form-control" type="email" placeholder="Enter Email" name="email" required>
         </div>
         <div class="col-md-12">
          <label><b>Mobile No</b></label>
          <input class="w3-input w3-border form-control" type="text" placeholder="Enter Mobile No" name="mobileNo" required>
          </div>
          <div class="col-md-12">
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password" required>
          </div>
           <div class="col-md-12">
          <input class="form-control" type="hidden" name="carNumber" value="<%=carNumber%>"/>
           </div>
           <div class="col-md-12">
           
          <input class="form-control" type="hidden" name="carId" value="<%=usedCar.getGEN_CAR_ID()%>"/>
          </div>
           <div class="col-md-12">
          <input class="form-control" type="hidden" name="vehicleType" value="4"/>
          </div>
          <div class="col-md-12">
          
          <button class="form-control w3-button w3-block w3-green w3-section w3-padding btn-primary" type="submit" style="margin:20px  0px 20px !important;padding: 0px !important;margin:0px;">
          Submit</button>
         
          </div>
          
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius: 9px;">
      <div class="col-md-12">
      <br>
      </div>
      <div class="col-md-6">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="form-control w3-button w3-red">
        Cancel</button>
        </div>
        <div class="col-md-6">
		 <a href="#" onClick="document.getElementById('id01').style.display='none',document.getElementById('register').style.display='block'" style='float:right' class="form-control w3-button w3-red">
		 Existing User</a>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="w3-container"> 
   <div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 400px;    border-radius: 9px;margin-top: 20px">
      <div class="w3-center" style=" border-bottom: 1px solid #ccc!important;"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
      <div class="w3-section">
       	<div id="txtHint"></div>
       		<form action="./IndividualOwnerLogin" class="w3-container" method="post">
       		   <div class="col-md-12">
       			<label><b>Email</b></label>
       			<input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Email" name="email" required>
	      		</div>
	      		<div class="col-md-12">
	      		<label><b>Password</b></label>
       			<input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password"  required>
    			</div>
    			<div class="col-md-12">
    			<input class="form-control" type="hidden" name="carNumber" value="<%=carNumber%>"/>
    			</div>
    			<div class="col-md-12">
    			<input class="form-control" type="hidden" name="vehicleType" value="4"/>
          		</div>
          		<div class="col-md-12" style="padding: 0px;margin: 20px 0px 20px;">
          		<div class="col-md-6">
          		<button   class="form-control w3-button w3-block w3-green w3-section w3-padding btn-primary" type="submit">Submit</button>
          		</div>
          		<div class="col-md-6">
    			<a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
    			</div>
    			</div>
   	 		</form>
      </div>
     
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="    border-radius: 9px;">
       <div class="col-md-12">
       <div class="col-md-6">
       	<button onclick="document.getElementById('register').style.display='none'" type="button" class="w3-button w3-red form-control" style="    border-radius: 9px;">
      	Cancel</button>
       </div>
       
       <div class="col-md-6">
       <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-red form-control" style="    border-radius: 9px;">
    	Go Back</button>
       </div>
       
       </div>
      </div>
    </div>
  </div>
 </div>
  </div>
    
      </div>
<div class="col-md-12">
  <span class="one">Car Id : </span><span class="two"><%=usedCar.getGEN_CAR_ID() %></span>
</div>
<div class="col-md-12">

<%  String value=usedCar.getOFFER_PRICE();
    	double outs=Integer.parseInt(value);
    	
    	String price=new CurrencyFormate().indianrupee(outs);
    	
    	%>
  <span class="one">PRICE :</span> <span class="two"> <i class="fa fa-inr"></i> <%=price%></span>
  </div>
  </div>
  <div class="row span1" >
  <div class="col-md-12">
    <span class="one">Fuel Type :</span><span class="two"> <%=usedCar.getFUEL_TYPE() %>  </span>

  </div>
  <div class="col-md-12">
    <span ><span ></span></span>
 
  </div>
  <div class="col-md-12">
    <span class="one"> Registered Year :</span><span class="two"> <%=usedCar.getREGISTERED_YEAR() %></span>
    
  </div>
  <div class="col-md-12">
   <span class="one"> Color :</span><span class="two"> <%=usedCar.getCOLOR() %></span>
  </div>
  <div class="col-md-12">
    <span class="one"> Kms Driven :</span><span class="two"> <%=usedCar.getKMS_DRIVEN() %></span>
  </div>
  <div class="col-md-12">
    <span class="one"> City :</span><span class="two"> <%=usedCar.getCITY() %></span>
  </div>
  <div class="col-md-12">
   <span class="one"> Number Of Owners :</span><span class="two"> <%=usedCar.getNO_OF_OWNERS() %></span>
  </div>
  <div class="col-md-12">
    <span class="one"> Transmission : </span><span class="two"> <%=usedCar.getTRANSIMISSION() %></span>
  </div>
   <div class="col-md-12">
   <span class="one"> Current Mileage : </span><span class="two"> <%=usedCar.getCURRENT_MILEAGE() %></span>
  </div>
   <div class="col-md-12">
  <span class="one"> Body Type : </span><span class="two"> <%=usedCar.getBODY_TYPE() %></span>
  </div>
  
  
  
<%i++;%>
  </div>
</div>
<div class="col-md-12">
<br>
<br>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-md-12 col-xs-12 heroSlider-fixed " style="background: white">
        <h2 >Compare With Similar Cars</h2>
<div class="overlay">
</div>
<!-- Slider -->
      
<div class="slider responsive" style="height: auto !important;">


<%
Iterator usedCarWithImageit=usedCarWithImage.iterator();

UsedCar relatedCar=null;
while(usedCarWithImageit.hasNext()){
	
	relatedCar=(UsedCar)usedCarWithImageit.next();
	
	if(usedCarWithImage!=null && usedCarWithImage.size()>0){

%>
          
<div>
						
<!-- <img src="http://placehold.it/200x150" alt="" /> -->
<div class="row" style="width: 272 !important">
   <a href="./DisplayCarImage.jsp?photo=<%=relatedCar.getCAR_NUMBER()%>">
              <img src="data:image/png;base64,<%=relatedCar.getPHOTO1()%>" style="height: 200px;width: 250px;" class="img-responsive center-block">
              
              <div class="row" align="center">
              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Brand :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_BRAND() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Model :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_MODEL() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">KMS Driven:</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getKMS_DRIVEN() %> </span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Price:</span> <span style="color:brown; font-size:15px; ">&#8377;&nbsp;<%=relatedCar.getOFFER_PRICE() %> </span> </span></p>
              </div>
              
            </a>
		</div>			
</div>
					
<%}} %>
	
        
</div>
				 
<!-- control arrows -->
				
<div class="prev">
					
<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				
</div>
				
<div class="next">
					
<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				
</div>
				
      
</div>
    
</div>
  
</div>

</div>

<br><br>

<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
       <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
          <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.js'></script>

    
			<script src="assets/js/couroselJs.js"></script>
       <script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>

  
  </body>
</body>
</html>