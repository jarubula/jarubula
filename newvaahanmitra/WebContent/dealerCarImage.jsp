<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
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
<!--     <link rel="stylesheet" href="assets/css/display.css"> -->

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
.btn-primary {
    color: #fff !important;
    background-color: #337ab7 !important;
    border-color: #2e6da4 !important;
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


</head>
<body>
     
             <jsp:include page="./homeTop.jsp"></jsp:include>
             <!-- /.container --> 
        





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
	GetUsedCarDetails carImage=new GetUsedCarDetails();
	String vehicleType = "4";
	String demail = carImage.getVehicleEmailId(carNumber,vehicleType);
	
// 	String demail=request.getParameter("email");
	
	String email = (String)request.getAttribute("demail");
	if(carNumber == null && email!=null){
		carNumber = (String)request.getAttribute("carNumber");
		demail = email;
	}
	
	
	ArrayList<UsedCar> image=carImage.getCarImage(carNumber);
	UsedCar usedCar=carImage.getUsedCarByCarNo(carNumber);
	List<UsedCar> usedCarWithImage=carImage.getDealerUsedCar(usedCar.getCAR_BRAND(),usedCar.getOFFER_PRICE(),usedCar.getKMS_DRIVEN(),carNumber,demail);
	String userEmail = (String) session.getAttribute("user"); 
	if(userEmail!=null){
		ceu = carImage.getRequesters(userEmail);	
	}
	
	Iterator it=image.iterator();
%>

<div style="background: #fff">
<br>
  <div class="w3-content w3-display-container col-md-8 col-xs-12 col-sm-12">
  <%while(it.hasNext()){
	UsedCar photo=(UsedCar)it.next();
%>
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO1() %>" style="width:100%">
  <img class="mySlides" src="data:image/png;base64,<%=photo.getPHOTO2()==null?photo.getPHOTO1():photo.getPHOTO3() %>" style="width:100%">
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
<div class="col-md-4 col-xs-12  well">
  <div class="row a2">
    <div class="col-md-12">
      <span style="color: darkblue;font-size: 21px"><%=usedCar.getCAR_BRAND() %>&nbsp;&nbsp;&nbsp;<%=usedCar.getCAR_MODEL() %></span>
    </div>
<div class="col-md-12">
  <span>Car  Id:</span><span style="color:darkblue;"><%=usedCar.getGEN_CAR_ID() %></span>
</div>
<div class="col-md-12">
    <span style="color:brown;font-size: 21px">PRICE :<span style="font-size: 20px;
    padding-left: 14px;
    color: darkblue;"><mark>&#8377;&nbsp;<%=usedCar.getOFFER_PRICE() %></mark></span></span>
  </div>
  </div>
  <div class="row span1" >

  <div class="col-md-12">
    <span>Registered Year :<span><%=usedCar.getREGISTERED_YEAR() %></span></span>
    
  </div>
  <div class="col-md-12">
    <span>Color :<span><%=usedCar.getCOLOR() %></span></span>
  </div>
  <div class="col-md-12">
    <span>Kms Driven :<span><%=usedCar.getKMS_DRIVEN() %></span></span>
  </div>
  <div class="col-md-12">
    <span>City :<span><%=usedCar.getREGISTERED_CITY() %></span></span>
  </div>
  <div class="col-md-12">
    <span>Number Of Owners :<span><%=usedCar.getNO_OF_OWNERS() %></span></span>
  </div>

   <div class="col-md-12">
    <span>Current Mileage :<span><%=usedCar.getCURRENT_MILEAGE() %></span></span>
  </div>

  
  
    <div class="col-md-6">

<%int i=1;%>
<div class="w3-container"> 
	<%
 			if (ceu!=null && ceu.contains(usedCar.getGEN_CAR_ID())&&userEmail!=null) { 
	%>	
	<button type="button" class="btn btn-success" style="border-radius: 25px; border-color: snow;" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b></button>
	<br>
	 	<% 
	 		} else if(userEmail!=null){
		%>
	<form id="myfor<%=i %>" method="post" action="./SendCarRequest">
		<input type="hidden" name="carNumber" value="<%=carNumber%>"/>
		<input type="hidden" name="carId" value="<%=usedCar.getGEN_CAR_ID()%>"/>
		<input type="hidden" name="demail" value="<%=demail%>"/>
		  <a style="border-radius: 25px; border-color: snow;" class="btn btn-primary" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;">CONTACT OWNER</a>
	</form>
	<%} else{%>
	 <a style="border-radius: 25px; border-color: snow;" class="btn btn-primary" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'"><b style="  vertical-align:middle">CONTACT SELLER</b></a>		<br>
	 <%} %>
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px;margin-toop:20px;border-radius:8px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertIndividualUser" method="post">
        <div class="w3-section">
          <center><h4>NEW USER</h4></center>
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Username" name="name" required>
          <label><b>Email</b></label>
          <input class="w3-input w3-border form-control" type="email" placeholder="Enter Email" name="email" required>
          <label><b>Mobile No</b></label>
          <input class="w3-input w3-border form-control" type="text" placeholder="Enter Mobile No" name="mobileNo" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password" required>
          <input type="hidden" name="carNumber" value="<%=carNumber%>"/>
          <input type="hidden" name="carId" value="<%=usedCar.getGEN_CAR_ID()%>"/>
          <input type="hidden" name="demail" value="<%=demail%>"/>
          <input type="hidden" name="vehicleType" value="4"/>
          <br>
          <button class="w3-button btn-primary w3-block w3-green w3-section w3-padding form-control" type="submit">Submit</button>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px">
      <div class="col-md-6">
      <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red form-control">
      Cancel</button>
      </div>
      
      <div class="col-md-6">
       <a href="#" onClick="document.getElementById('id01').style.display='none',document.getElementById('register').style.display='block'" style='float:right'>Existing User</a>
      </div>
      
        
		
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>
<div class="w3-container"> 
   <div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 400px;border-radius:8px;margin-top:20px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('register').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <h4>USER LOGIN</h4>
      </div>
      <div class="w3-section">
       	<div id="txtHint"></div>
       		<form action="./IndividualOwnerLogin" class="w3-container" method="post">
       			<label><b>Email</b></label>
       			<input class="w3-input w3-border w3-margin-bottom form-control" type="text" placeholder="Enter Email" name="email" required>
	      		<label><b>Password</b></label>
       			<input class="w3-input w3-border form-control" type="password" placeholder="Enter Password" name="password"  required>
    			<input type="hidden" name="carNumber" value="<%=carNumber%>"/>
    			<input type="hidden" name="vehicleType" value="4"/>
    			<input type="hidden" name="demail" value="<%=demail%>"/>
    			<br>
    			<div class="col-md-6">
    			<button class="w3-button w3-block btn-primary w3-green w3-section w3-padding form-control" type="submit">Submit</button>
    			</div>
    			<div class="col-md-6">
    			<a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
    			</div>
          		
    			
   	 		</form>
      </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius:8px">
      <div class="col-md-6">
       	<button onclick="document.getElementById('register').style.display='none'" type="button" class="w3-button w3-red form-control">Cancel</button>
      </div>
      
      <div class="col-md-6">
      <button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" class="w3-button w3-red form-control">Go Back</button>
      </div>
     
    	
      </div>
    </div>
  </div>
 </div>

  </div>
<%i++;%>

  </div>
  



</div>



<%-- <div class="container-fluid">


  <div class="row">
  
    <div class="col-xs-12 col-sm-12 col-md-12" style="margin-top: 50px; 
    background: #fff;
    border: 1px solid #eee;
    box-shadow: 0 1px 9px #eadfdf;">
      <div class="carousel carousel-showmanymoveone slide" id="itemslider">
        <div class="col-md-12 ">
        <h3 style="font-family: Airial;color: brown;background: #fff;margin-left: 60px">Compare With Similar Bikes</h3>
    </div>
          <div class="carousel-inner"> 
        
        

<%
int count=0;
Iterator usedCarWithImageit=usedCarWithImage.iterator();
UsedCar relatedCar=null;
while(usedCarWithImageit.hasNext()){
	
	relatedCar=(UsedCar)usedCarWithImageit.next();

%>

		<%if(usedCarWithImage!=null && count==0){count++;%>
 		<div class="item active">
            <div class="col-xs-12 col-sm-6 col-md-2">
              <a href="./displayBikeImage.jsp?photo=<%=relatedCar.getCAR_NUMBER()%>">
              <img src="data:image/png;base64,<%=relatedCar.getPHOTO1() %>" class="img-responsive center-block">
              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Brand :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_BRAND() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Model :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_MODEL() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">KMS Driven:</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getKMS_DRIVEN() %> </span> </span></p>
              
              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Price:</span> <span style="color:brown; font-size:15px; ">&#8377;&nbsp;<%=relatedCar.getOFFER_PRICE() %> </span> </span></p>
            </a>
            </div>
          </div>
          <%} else if(usedCarWithImage!=null && usedCarWithImage.size()>0 && count!=0){%>
          <div class="item">
            <div class="col-xs-12 col-sm-6 col-md-2">
              <a href="./displayBikeImage.jsp?photo=<%=relatedCar.getCAR_NUMBER()%>">
              <img src="data:image/png;base64,<%=relatedCar.getPHOTO1() %>" class="img-responsive center-block">
              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Brand :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_BRAND() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Model :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_MODEL() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">KMS Driven:</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getKMS_DRIVEN() %> </span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Price:</span> <span style="color:brown; font-size:15px; ">&#8377;&nbsp;<%=relatedCar.getOFFER_PRICE() %> </span> </span></p>
            </a>
            </div>
          </div>
          <%}} %>
          
          
          
          </div> 

        <div id="slider-control">
        <a class="left carousel-control" href="#itemslider" data-slide="prev"><img src="http://img.freepik.com/free-icon/last-track-left-arrow_318-85985.jpg?size=338c&ext=jpg" alt="Left" class="img-responsive"></a>
        <a class="right carousel-control" href="#itemslider" data-slide="next"><img src="http://img.freepik.com/free-icon/right-arrow_318-131657.jpg?size=338c&ext=jpg" alt="Right" class="img-responsive"></a>
      </div>
      </div>
    </div>
  </div>
</div> --%>

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
      
<div class="slider responsive" style="height: auto !important">


<%
int count=0;
Iterator usedCarWithImageit=usedCarWithImage.iterator();
UsedCar relatedCar=null;
while(usedCarWithImageit.hasNext()){
	
	relatedCar=(UsedCar)usedCarWithImageit.next();

	if(usedCarWithImage!=null && usedCarWithImage.size()>0 && count!=0){
%>
          
<div>
						
<!-- <img src="http://placehold.it/200x150" alt="" /> -->

   <a href="./dealerCarImage.jsp?photo=<%=relatedCar.getCAR_NUMBER()%>">
              <img src="data:image/png;base64,<%=relatedCar.getPHOTO1() %>" class="img-responsive center-block">
              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Brand :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_BRAND() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Model :</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getCAR_MODEL() %></span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">KMS Driven:</span> <span style="color:#000; font-size:15px; "><%=relatedCar.getKMS_DRIVEN() %> </span> </span></p>

              <p style="margin: 0 0;"><span style="color:#000; font-size:17px;">Price:</span> <span style="color:brown; font-size:15px; ">&#8377;&nbsp;<%=relatedCar.getOFFER_PRICE() %> </span> </span></p>
            </a>
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
<jsp:include page="footer.jsp"/>
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