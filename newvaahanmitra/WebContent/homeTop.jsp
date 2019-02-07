<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 .navbar-fixed-bottom, .navbar-fixed-top {
    position:relative !important;
    }
    
#navbar a {
  display: block;
}

.content {
  padding: 16px;
}

.sticky {
  position: fixed;
  z-index:2222;
  top: 0;
  width: 100%
}

.sticky + .content {
       padding-top: 115px;
}
 
 #navbar {
  
     background:none !important;
}
.dropdown-submenu {
    position: relative;
}

.dropdown-submenu .dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -1px;
}
 .navbar-nav > li > .dr::before {bottom: 100%;left: 72% !important ;border: solid transparent;content: " ";height: 0;width: 0;position: absolute;pointer-events: none;border-bottom-color: #fec107;border-width: 7px;margin-left: -7px;}
 #one1{
margin: 0  55px;
}
 
  @media  (max-width:1024px){
#one1{
margin: 0  15px;
}
} 

 @media  (max-width:1280px){
#one1{
margin: 0  40px;
}
} 

 @media  (max-width:768px){
.one2{
float:none !important;
}

.one2 li{
padding: 0;
margin: 0 !important;
}
.navbar-nav {
    margin: 0.1px 0px;
}
} 
</style>

</head>
<body  onscroll="myFunction()">
 <div id="navbar">
<nav id="mainNav" class="navbar navbar-fixed-top affix-top" style="background: #9a2220;">
        <div class="col-md-12 col-xs-12">
         
                <div class="container-fluid " style="position:relative;bottom:0px;">
                
                    <div class="navbar-header ">
                        <button type="button" class="navbar-toggle col-xs-1 collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span><i class="fa fa-bars"></i>
                        </button>
                        <div>
                          <h2  style="color:#fff;margin-top:3px;font-weight:600;">
                         <!--  <a href="index.jsp"> <img src="images/logo.png" class="img-responsive" style=" margin-top: 6px;"></a> -->
                       <a class="navbar-brand  f1" href="./index.jsp" style="color:#fff;margin-top:3px;font-weight:600;font-size: 24px">
                          Vaahan<span style="margin-left:2px; color:#fec107;">Mitra</span>
                        </a> </h2></div>
                    </div>
                    <!--Collect the nav links, forms, and other content for toggling--> 
                    
                    
                    <div class="navbar-collapse collapse  " id="bs-example-navbar-collapse-1" aria-expanded="false" style="height: 1px;overflow-x:hidden">
                    
                        <ul class="nav navbar-nav left1">
                            <li class="active" id="index"><a href="./index.jsp">Home</a></li>
                            <li class="left1" id="aboutUs"><a href="#">About Us</a></li>
                            <li class="dropdown left1" id="service">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Services<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="./searchHServiceUsedCar.jsp">Used Car</a></li>
                                    <li><a href="./searchHServiceUsedBike.jsp">Used Bike</a></li>
                                    <li><a href="./searchHServiceMechanic.jsp">Service Center</a></li>
                                    <li><a href="./searchHServiceUsedVehicleDealer.jsp">Vehicle Dealer</a></li>
                                    
                                </ul>
                              </li>
                              
                              
                               <li class="dropdown left1" id="service">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Compare<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="./searchHServiceUsedCar.jsp">New Car</a></li>
                                    <li><a href="./searchHServiceUsedBike.jsp">New Bike</a></li>
                                </ul>
                               </li>
                               
                                <li class="dropdown left1" id="service">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Cars<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Budget</a></li>
                                    <li><a href="#">Body Type</a></li>
                                     <li><a href="#">Brands</a></li>
                                </ul>
                               </li>
                               
                                <li class="dropdown left1" id="service">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Own Our Store<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="./servicecenter.jsp">Service Center</a></li>
                                    <li><a href="#">Spareparts Store</a></li>
                                </ul>
                               </li>
                            
                            <li class="left1 hidden-lg hidden-md" id="auto"><a href="vehicleFinance.jsp">Vehicle Finance</a></li>
                            
                            <li class="left1 hidden-lg hidden-md" id="road"><a href="roadAssistance.jsp">Road Assistance</a></li>
                            
                            <li class="left1 hidden-lg hidden-md" id="vechicle"><a href="vehicleInsurence.jsp">Vehicle Insurance</a></li>
                           
                            <%
       String verifiedEmail=(String)session.getAttribute("user"); 
                        
       %>
                         
                        </ul>
                     
                     
                        
                        
                     
           <div id="navbar" class="pull-right one2">
              <nav  style="background: #9a2220;" >
                <div class="container-fluid " style="position:relative;bottom:0px;">
                  
             
                        <ul class="nav navbar-nav left1">
                           <%if(verifiedEmail!=null){ %>  

                        <%} else{%>
      <li class="left1" id="login"><a href="./login3.jsp">Login</a></li>
      <li class="left1" id="register1"><a href="./register.jsp">Register</a></li>
                     <%} %>
       
                         <%if(verifiedEmail!=null){ %>
                         <li class="dropdown" id="one1">
                         <a href="./LoginHController">My Account</a>
					       <ul class="dropdown-menu">
					        <li>
					        <a href="#" class="btn  dropdown-toggle" type="button" data-toggle="dropdown" role="button" aria-haspopup="true" style="text-transform: lowercase"><%="Hi "+verifiedEmail%><span class="caret"></span></a>
					        
					        </li>
					        <li><a href="./logout.jsp">LogOut</a></li>
					       </ul></li>
					       <%}else{%>
					        <%} %>
					        
					        
                          
                                <li class="dropdown left1 hidden-xs" id="service">
                              
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"><span class="glyphicon">&#xe011;</span></a>
                                <ul class="dr dropdown-menu" style="margin-left: -115px;">
                               
                                    <li><a href="./searchHServiceUsedCar.jsp">Vehicle Finance</a></li>
                                    <li><a href="./searchHServiceUsedBike.jsp">Road Assistance</a></li>
                                    <li><a href="./searchHServiceUsedBike.jsp">Vehicle Insurance</a></li>
                                </ul>
                              </li>
                             
                        </ul>
                </div> 
            </nav>
            </div> 
            </div>
                 
                </div> 
                </div>
                
                
            </nav>
           
          </div>
          
          
           <div class="content"></div>
    
<script>
var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>
<script type="text/javascript">

/* 
	 window.onscroll = function () {
         alert("scrolling");
     }
 */
</script>
<script>
$(document).ready(function(){
  $('.dropdown-submenu a.test').on("click", function(e){
    $(this).next('ul').toggle();
    e.stopPropagation();
    e.preventDefault();
  });
});
</script>


 
</body>
</html>