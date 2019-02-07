<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Image</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
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
.img img{
height:500px;

}

.bor{
border-radius: 8px !important;
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
   .one{
       color: #000;
    font-size: 17px;
    font-weight: normal;
    font-family: monospace;
    }
    .four{
        font-size: 19px;
       color: #fb1f1b;
    } 
    .five{
    color: #9a2220;
    font-size: 26px;
    font-weight: 500;
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
b, strong {
    font-weight: 500;
    font-size: 14px;
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
	String bikeNumber=request.getParameter("photo");
	if(bikeNumber==null){
		bikeNumber = (String)request.getAttribute("carNumber"); 		
	}
	GetUsedBikeDetails bikeImage=new GetUsedBikeDetails();
	ArrayList<UsedBike> image=bikeImage.getBikeImages(bikeNumber);
	UsedBike usedBike=bikeImage.getUsedBikeByBikeNo(bikeNumber);
	List<UsedBike> usedBikeWithImage=bikeImage.getUsedBikeWithPhotoByBikeNo(usedBike.getBIKE_BRAND(),usedBike.getOFFER_PRICE(),usedBike.getKMS_DRIVEN(),bikeNumber);
	String email = (String) session.getAttribute("user"); 
	if(email!=null){
		ceu = bikeImage.getRequesters(email);	
	}
	Iterator it=image.iterator();
%>

<div style="background: #FFF">
<br>
  <div class="w3-content w3-display-container col-md-8 col-xs-12 col-sm-12 img">
  <%while(it.hasNext()){
	UsedBike photo=(UsedBike)it.next();
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
<div class="col-md-4 col-xs-12  well" style=" border-radius: 4px; font-family: Georgia; background: #fff;box-shadow: 0 1px 4px 0 rgba(0,0,0,.21);">
  <div class="row a2">
    <div class="col-md-6">
      <span class="five"><%=usedBike.getBIKE_BRAND() %>&nbsp;<%=usedBike.getBIKE_MODEL() %></span>
    </div>
    
     <div class="col-md-6">
        <div class="col-md-6">

<%int i=1;%>
<div class="w3-container"> 
	<%
 			if (ceu!=null && ceu.contains(usedBike.getGEN_BIKE_ID())&&email!=null) { 
	%>	
	<button type="button" class="btn btn-success" id="se7" disabled><b style="color:black;vertical-align:middle">REQUEST SENT</b></button>
	<br>
	 	<% 
	 		} else if(email!=null){
		%>
	<form id="myfor<%=i %>" method="post" action="./SendingBikeRequest">
		<input type="hidden" name="bikeNumber" value="<%=bikeNumber%>"/>
		<input type="hidden" name="bikeId" value="<%=usedBike.getGEN_BIKE_ID()%>"/>
		  <a id="se7" class="btn btn-primary" onclick="document.getElementById('myfor<%=i %>').submit();"  class="button1" style="cursor: pointer;">CONTACT OWNER</a>
	</form>
	<%} else{%>
		<a id="se7" class="btn btn-primary" href="#" onClick="document.getElementById('id0<%=i %>').style.display='block'"><b style="  vertical-align:middle">CONTACT OWNER</b></a>
	<%}%><br>
  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:443px;    border-radius: 8px">
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertIndividualRequest" method="post">
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
           <input type="hidden" name="bikeNumber" value="<%=bikeNumber%>"/>
          <input type="hidden" name="bikeId" value="<%=usedBike.getGEN_BIKE_ID()%>"/>
          <input type="hidden" name="vehicleType" value="2"/>
          <br>
          <button class="w3-button btn-primary w3-block w3-green w3-section w3-padding form-control" type="submit">Submit</button>
        </div>
      </form>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey"  style="border-radius:4px;">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red" style="border-radius: 4px;">Cancel</button>
		 <a href="#" onClick="document.getElementById('id01').style.display='none',document.getElementById('register').style.display='block'" style="float:right; border-radius:4px;" class="w3-button w3-red">Existing User</a>
      </div>
    </div>
  </div>
</div>
<div class="w3-container"> 
   <div id="register" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="width: 430px;border-radius: 8px;">
      <div class="w3-center" style="    border-bottom: 1px solid #ccc;"><br>
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
    			<input class="form-control" type="hidden" name="carNumber" value="<%=bikeNumber%>"/>
    			<input class="form-control" type="hidden" name="vehicleType" value="2"/>
    			<br>
    			<div class="col-md-6">
    			<button class="w3-button w3-block btn-primary w3-green w3-section w3-padding form-control" type="submit">Submit</button>
    			</div>
          		<div class="col-md-6">
          		<a href="./forgotPasswordEmail.jsp" style="color:red;float:right"><u>Forgot Password</u></a>
          		</div>
    			
   	 		</form>
      </div>
      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey " style=" border-radius: 4px;">
      	<button onclick="document.getElementById('register').style.display='none'" type="button" class="w3-button w3-red" style="    border-radius: 9px;">Cancel</button>
    	<button onclick="document.getElementById('register').style.display='none',document.getElementById('id0<%=i %>').style.display='block'" style="float:right; border-radius:4px;" class="w3-button w3-red">Go Back</button>
      </div>
    </div>
  </div>
 </div>
<%i++;%>
  </div>
    </div>
    
    
<div class="col-md-12">
  <span class="one">Car Id:</span><span class="two"><%=usedBike.getGEN_BIKE_ID() %></span>
</div>
<div class="col-md-12">
<%  String value=usedBike.getOFFER_PRICE();
    	double outs=Integer.parseInt(value);
    	
    	String price=new CurrencyFormate().indianrupee(outs);
    	
    	%>

    <span class="one">PRICE : </span><span  class="two"> <i class="fa fa-inr"></i> <%=price%></span>
  </div>
  </div>
  <div class="row span1" >

  <div class="col-md-12">
    <span class="one">Registered Year :</span> <span class="two"><%=usedBike.getREGISTERED_YEAR() %></span>
    
  </div>
  <div class="col-md-12">
    <span class="one">Color : </span><span class="two"><%=usedBike.getCOLOR() %></span>
  </div>
  <div class="col-md-12">
    <span class="one">Kms Driven :</span><span class="two"><%=usedBike.getKMS_DRIVEN() %></span>
  </div>
  <div class="col-md-12">
    <span class="one">City :</span><span class="two"><%=usedBike.getREGISTERED_CITY() %></span>
  </div>
  <div class="col-md-12">
    <span class="one">Number Of Owners :</span><span class="two"><%=usedBike.getNO_OF_OWNERS() %></span>
  </div>

   <div class="col-md-12">
    <span class="one">Current Mileage : </span><span class="two"><%=usedBike.getCURRENT_MILEAGE() %></span>
  </div>
  
  
   
  </div>
</div>
<div class="col-md-12">
<br>
<br>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-md-12 col-xs-12 heroSlider-fixed " style="background: white">
        <h2 >Compare With Similar Bikes</h2>
<div class="overlay">
      
</div>
         
<!-- Slider -->
      
<div class="slider responsive" style="height: auto !important">


<%
Iterator usedBikeWithImageit=usedBikeWithImage.iterator();

UsedBike relatedBike=null;
while(usedBikeWithImageit.hasNext()){
	
	relatedBike=(UsedBike)usedBikeWithImageit.next();
	
	if(usedBikeWithImage!=null && usedBikeWithImage.size()>0){

%>
          
<div>
						
<!-- <img src="http://placehold.it/200x150" alt="" /> -->

        <a href="./displayBikeImage.jsp?photo=<%=relatedBike.getBIKE_NUMBER()%>" style=" text-decoration: none;">
              <img src="data:image/png;base64,<%=relatedBike.getPHOTO1() %>" class="img-responsive center-block" style="    width: 100%;
                  min-height:180px; border-radius: 9px; margin: 2px -2px;">
              <p style="margin: 0 0;"><span class="one">Brand :</span> <span class="two"><%=relatedBike.getBIKE_BRAND() %></span></p>

              <p style="margin: 0 0;"><span class="one">Model :</span> <span class="two"><%=relatedBike.getBIKE_MODEL() %></span></p>

              <p style="margin: 0 0;"><span class="one">KMS Driven:</span> <span class="two"><%=relatedBike.getKMS_DRIVEN() %> </span></p>

              <p style="margin: 0 0;"><span class="one">Price:</span> <span class="two"><%=relatedBike.getOFFER_PRICE() %> </span></p>
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