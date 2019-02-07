<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Vaahanmitra | Search Dealer</title>
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
         <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        
	        	 <script>
function showDealerName(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint4").innerHTML="";  
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
			document.getElementById("txtHint4").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getDealerName.jsp?city="+str,true);   
	xmlhttp.send();    
	}
	</script>
	
<script>
function toggle_it(itemID){ 
    // Toggle visibility between none and '' 
    if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = '' 
          event.preventDefault()
    } else { 
          document.getElementById(itemID).style.display = 'none'; 
          event.preventDefault()
    }    
} 

</script>

<style type="text/css">

.button1 {
    display: block;
    width: 180px;
    height: 40px;
    background: #356e9f;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}
.sticky + .content {
    padding-top: 67px !important;
}
.content {
    padding: 0px !important;
}
#search1 {
  max-width: 100%;
  -moz-transition: all 0.3s;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
}
#search1:hover{
  -moz-transform: scale(1.1);
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
  
}
.one{
    font-size: 25px;
    color: #467aa1;
    font-weight: 500;
    font-family: sans-serif;
    text-transform: capitalize;
    }
</style>
    </head>
    <body>
	<% int fourWheeler = 0,twoWheeler = 0;%>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
                <jsp:include page="./homeTop.jsp"></jsp:include>
            <!-- /.nav end -->
          
            <!-- service -->
            
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
           
            <section class="service-inner" >
                <div class="container">
				<form action="./SearchHUsedVehicleDealer" method="post">
					<div class="row top">
						<%
                     ArrayList<BusinessOwnerRegister> dealerAl=(ArrayList<BusinessOwnerRegister>)request.getAttribute("bol");
                      %>

						<div class="col-md-3 col-sm-6 col-xsm-12"></div>
						<div class="col-md-3 col-sm-6 col-xsm-12"></div>
						<div class="col-md-3 col-sm-6 col-xsm-12"></div>
						<div class="col-md-3 col-sm-6 col-xsm-12"
							style="margin-top: 15px;"></div>
				</form>
			</div>
                    <%
                    	if(dealerAl.isEmpty()){
                    	%>
                    	<h3> Dealers not found </h3>
                    	<% 
                    	}else {
                    	for(BusinessOwnerRegister bor : dealerAl){
                    	%>
               <section class="col-lg-9 col-md-10 col-sm-10 col-xsm-10" style="background: #ffffff;box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-radius: 5px;margin-top: 5px;margin-bottom: 0px;padding-bottom:11px;">
                        <div class="col-md-9">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin: 7px 0;">
						 <span class="one"><%=bor.getBUSINESS_NAME()%></span>
                 		  </div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Address:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bor.getADDRESS() %></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">City:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bor.getB_CITY()%></span></div><br><br>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">State:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bor.getSTATE()%></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Email Address:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bor.getEMAIL_ID()%></span></div>
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12" style="margin-top: 0px;font-size: 12px;margin-bottom: 5px;"><span style="color: #555;font-weight: 600;">Phone Number:</span>&nbsp;&nbsp;<span style="text-transform: lowercase;"><%=bor.getOFFICE_PHONE_NO()%></span></div>
<!-- 						</div> -->
                       </div>
                       <div class="col-md-3">
                      <span>
                      <a href="#" style="cursor: pointer;" ><img src="./images/ServiceImage.png" alt="No image" class="img-responsive" style="margin-top: 14px;border-radius: 5px;height: 150px;width: 150px;font-size: 36px; font-family: sans-serif;text-align: center;margin-bottom: 3px;" id="search1"></a>
                    </span>
                    </div>
                    </section><%}} %>
                </div>
            <br><br>
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
        
 
    </body>
</html>