<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*,java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
 @media screen and (max-width: 780px) {
    #m1 {
        margin-bottom:4px;
    }
    
} 
.content {
    padding: 0px;
    background: #efefef;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 0px !important;
    border: 1px solid transparent;
}
.sidebar {
  width:45%;
  /* height: 95vh; */
  height:95vh;
  min-height: 200px;
  overflow: auto;
  position: -webkit-sticky;
  position: sticky;
  top:10%;
}

.main {
  width:55%;
  height: 200vh;
  min-height: 1000px;
  display: flex;
  flex-direction: column;
}

.main,
.sidebar {
  border: 0px solid #222;
  background-color: #f9f7f7;
  border-radius: 0px;
  color: #222;
  padding: 15px;
}
#b0{
    background-color: #f9f7f7;
    border-radius: 0px;
    }

.wrapper {
  display: flex;
  justify-content: space-between;
}       
</style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Vaahanmitra | Search Service Center</title>
        <link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <link href="http://www.vaahanmitra.com/searchHServiceMechanic.jsp" rel="canonical" />
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="./css/tcal.css" />
        <link href="assets/css/kosuri.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script type="text/javascript" src="./js/tcal.js"></script>
		
	    <script type="text/javascript">
	
	    function yesnoCheck() {
	    if (document.getElementById('yesCheck').checked) {
	        document.getElementById('ifYes').style.display = 'block';
	    }
	    else document.getElementById('ifYes').style.display = 'none';

	    }
	    </script>	

        <% String message1=(String)request.getAttribute("message");
         /* if(message1!=null){ */
        %>
	
       <script>
       function toggle_it(itemID,text){ 
       // Toggle visibility between none and ''
       var text=document.getElementById(text);
       if ((document.getElementById(itemID).style.display == 'none')) {
          document.getElementById(itemID).style.display = ''
          text.innerHTML="-"
          event.preventDefault()
        } else { 
          document.getElementById(itemID).style.display = 'none'; 
          text.innerHTML="+"
          event.preventDefault()
       }    
       }   

      </script>
     
     <style>
	    span.stars, span.stars span {
	    display: block;
	    background: url(./images/stars.png) 0 -16px repeat-x;
	    width: 80px;
	    height: 16px;
	    }

    span.stars span {
       background-position: 0 0;
       }
       label {
	    font-size: 16px;
	    color: #555;
	    font-weight: 500;
	    }
	    .sticky + .content {
	    padding-top: 87px !important;
	     background-color: #f9f7f7;
	    }
	    .scrtabs-tabs-fixed-container {
    float: left;
    height: 27px !important;
    overflow: hidden;
    width: 100%;
}
.scrtabs-tab-container {
    height: 28px;
}
.bi1{
    font-size: 18px;
    color: #555;
 }
 .bi2{
    color: #f10;
    font-size: 17px;
    }
    .bi3{
    font-size: 18px;
    color: #dc1410 !important;
    font-weight: normal;
    font-family: monospace;
    text-decoration: none;
    line-height: 25px;
    }
    .panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 18px !important;
    color: inherit;
    background: #fff;
   }
   .panel-default>.panel-heading+.panel-collapse>.panel-body {
    border-top-color: #fff;
}
.one {
   font-weight: 500;
    font-size: 17px;
    color:#10100f;
    font-family: monospace;
    line-height: 0px; 
}
.two {
    margin: 0 0px;
    font-weight: 500;
    font-size: 16px;
    color:#555;
    font-family: monospace;
    line-height: 0px;  
}
.bi4{
padding:0 0px;
}
.panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 18px;
    color: inherit;
    background: #fff;
    line-height: 22px;
}
.to4{
 border-radius: 5px;
 height:auto; width:100%;
 font-size: 36px; 
 font-family: sans-serif; 
 text-align: center; 
 margin-bottom:6px;
}
#to5{
    padding: 0 0;
    margin-bottom: 13px;
    }
    img {
    margin-bottom: 2px !important;
   }
.pa-2{
    padding-right: 0px;
/*     margin-top: -0.9rem; */
    }
 
     </style>
  <!--  <script>
    
       function myFunction() {
	
       var x = document.getElementById("five");

       if (x.style.display === "none") {
       x.style.display = "block";
       } else {
       x.style.display = "none";
      }
      }
       
         function myFunction1() {
          	
      	  var x = document.getElementById("five1");

      	  if (x.style.display === "none") {
      	    x.style.display = "block";
      	  } else {
      	    x.style.display = "none";
      	  }
      	} 
       </script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>

    </head>
    <body>
    <!--================= top section ==================-->
    <%if(message1!=null){ %>
     <div class='popup'>
     <div class='cnt223'>
     <img src='images/cancel.png' alt='quit' class='x' id='x' />
		<p>
		<%=message1%>
		<br/>
		<br/>
		<a href='#' class='close' style="margin-right:250px">ok</a>
		</p>
		</div>
		</div>
		<%}else{} %>
        <!-- page loader -->
        <div class="se-pre-con"></div>
        <div id="page-content">
        <jsp:include page="./homeTop.jsp"></jsp:include>
        <%
        GetMechanicDetails mdetails=new GetMechanicDetails();
	    String verifiedEmail=(String)session.getAttribute("user"); 
        int page1=0,noofrecords=0,maxrowsperpage=0,currentPage=0;
        try{
    	page1=Integer.parseInt(request.getAttribute("currentPage").toString());
    	maxrowsperpage=Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
    	currentPage=Integer.parseInt(request.getAttribute("currentPage").toString());
        }
        catch(Exception e)
        {
    
        }
        int k=(maxrowsperpage*page1)-maxrowsperpage;
    
        %>
          
        </div>
        <div class="clearfix"></div>
        <!--================= end top section ==================-->
             
        <!--================= header section ==================-->
           
                           <div class="" style="margin-top:0%;">
				            <form action="./SearchNewVehicle" method="post">
					        
						    <div class="col-md-2" style="padding: 0 0;" id="b0">
					        <div class="col-md-12 col-sm-6 col-xsm-12">
							<label>Vehicle Type :</label>
							<select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
							<option  style="display:none;" value="SELECT"></option>
							<option value="" style="display: none;">Vehicle Type</option>
						    <option value="2,">Two Wheeler</option>
						    <option value="4,">Four Wheeler(Light Vehicle)</option>
							</select>
						    </div>
						    </div>
						
							<div class="col-md-8" style=" padding: 0 0" id="b0">
						    <div class="col-md-3 col-sm-6 col-xsm-12">
							<label>Vehicle Brand :</label>
							<div id="txtHint20">
							<select name="vehicleBrand" class="form-control" required="required">
							<option  style="display:none;" value="SELECT"></option>
							<option value="SELECT" style="display: none;">Vehicle Brand</option>
							</select>
						    </div>
						    </div>
						
						    <div class="col-md-3 col-sm-6 col-xsm-12">
						    <div class="form-group">
						    <label for="email">Vehicle Model :</label>
							<div id="txtHintD">
							<select name="vehicleModel" class="form-control">
					    	<option  style="display:none;" value="SELECT"></option>
					        <option value="SELECT" style="display: none;">Vehicle Model</option>
						    </select>
							</div>
							</div>
						    </div>
						
						    <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
							<label for="email">Variant :</label>
							<div id="txtHintV">
							<select name="vvariant" class="form-control">
							<option  style="display:none;" value="SELECT"></option>
							<option value="SELECT" style="display: none;">Vehicle Variant</option>
							</select>
						    </div>
							</div>
						    </div>
						    
						    <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
							<label for="email">Make Year :</label>
						     <div id="txtHintD">
						     <select name="makeYear" class="form-control">
							 <%
	                         Date today = new Date();
	                         Calendar cal = Calendar.getInstance();
	                         cal.setTime(today);
	                         int currentyear = cal.get(Calendar.YEAR);
	                         int previous =currentyear-1;
	                         %>
                             <option value="SELECT" style="display:none;"></option>
	                         <option value="<%=currentyear%>">Current Year</option>
	                         <option value="">Previous Year</option>
							 </select>
			                 <input type="hidden" name="spage" value="result">
	                         <input type="hidden" name="bodyType" value="SELECT">
	                         <input type="hidden" name="fuelType" value="SELECT">
	                         <input type="hidden" name="transmission" value="SELECT">
	                         <input type="hidden" name="color" value="SELECT">
	                         <input type="hidden" name="budget" value="SELECT">
	                         <input type="hidden" name="vType" value="">
							 </div>
						     </div>
						     </div>
						     </div>
						     
						     <div class="col-md-2" id="b0">
						     <label class="invisible">h</label>
                             <button type="submit" class="btn btn-primary btn-block">Search</button>
						     </div>
			             	</form>
			             	 
			             	<div class="col-md-12 pa-2" id="b0">
                            <div class="col-md-10" style="text-align: center;">
                            <span style="font-size: 16px; color: #ff3737;  font-family: inherit;">
					        <%if(request.getAttribute("message")==null){}else{out.println(request.getAttribute("message"));} %>
					        </span>
                            </div>
          		            <div class="col-md-2">
         		            <a href="#" role="button" class="btn btn-warning btn-block  disabled" onclick="document.getElementById('sendpopup2').style.display='block'" id="sendenquiry" name="sendenquiry"   style="line-height: 16px;">Send Enquiry</a>
      			            </div>
      					    </div>
      						 
			             	</div>
                            <div class="clearfix" style="background-color: #f9f7f7;"></div>
        
        <!--================= end header section ==================-->     
             
          <!--================= service section ==================-->
            
      <div class="wrapper">
               <div class="main" style="padding-right: 2px;" id="b0">
                <div class="col-md-12 main1" style="padding: 0 0;">
                            <div class="col-md-5" style="padding: 0 0;">
                            <form action="./SearchNewVehicle" method="post">
		                    <div class="col-md-12 col-sm-12 col-xsm-12" style="padding-right: -1px; padding-left: 0.5em;">	
		                    <div class="side1">	
		    
		                    <h2 class="side3">Advance Search</h2>
		                    <input type="hidden" name="spage" value="result">
	                        <input type="hidden" name="vType" value="2,">
	                        <input type="hidden" name="vehicleBrand" value="Hero">
	                        <input type="hidden" name="vehicleModel" value="SELECT">
	                        <input type="hidden" name="vvariant" value="SELECT">
	                        <input type="hidden" name="makeYear" value="SELECT">
	                        <input type="hidden" name="bodyType" value="SELECT">
	                        <input type="hidden" name="transmission" value="SELECT">
	                                           
						    <div class="form-group">
							<select class="form-control" name="fuelType" onchange="this.form.submit()">
							<option style="display: none;" value="SELECT" selected="">Fuel Type</option>
							<option value="PETROL">PETROL</option>
						    <option value="DIESEL">DIESEL</option>
						    <option value="CNG">CNG</option>
						    <option value="LPG">LPG</option>
						    <option value="ELECTRIC">ELECTRIC</option>
						    </select>
						    <span id="error_gender" class="text-danger"></span>
						    </div>
											   
						    <div class="form-group">	
						    <select name="color" id="color" class="form-control form-control-sm" onchange="this.form.submit()" required="">
						    <option style="display: none;" value="SELECT" selected="">Color Type</option>
							<option value=" Matte Grey &amp; Yellow"> Matte Grey &amp; Yellow</option>
							<option value=" Pearl Sport Yellow"> Pearl Sport Yellow</option>
							<option value="Peral White">Peral White</option>
							<option value="Pyro Orange">Pyro Orange</option>
							<option value="Racing Blue">Racing Blue</option>
							<option value="Racing Red.Racing Black">Racing Red.Racing Black</option>
							<option value="Ravine Black">Ravine Black</option>
							<option value="Rebel Red Metallic">Rebel Red Metallic</option>
							<option value="Red">Red</option>
							<option value="Red Dash">Red Dash</option>
							<option value="Regal Red">Regal Red</option>
							<option value="Revving Blue">Revving Blue</option>
							<option value="Rhythmic Red">Rhythmic Red</option>
							<option value="Rock Matte Black">Rock Matte Black</option>
							<option value="Saffire Blue">Saffire Blue</option>
							<option value="Sassy Cyan">Sassy Cyan</option>
							<option value="Scorching Red">Scorching Red</option>
							<option value="Silver">Silver</option>
							<option value="Smoky Black">Smoky Black</option>
							<option value="Souiful Cyan">Souiful Cyan</option>
							<option value="Sparkling Silver">Sparkling Silver</option>
							<option value="Sparky Green">Sparky Green</option>
							<option value="SpicyRed">SpicyRed</option>
							<option value="Stand Sillver Metallic">Stand Sillver Metallic</option>
							<option value="Striking Green">Striking Green</option>
							<option value="Thunder Grey">Thunder Grey</option>
							<option value="Titanium Grey">Titanium Grey</option>
							<option value="Track White">Track White</option>
							<option value="Vibrant Orange">Vibrant Orange</option>
							<option value="Vivacious Purple">Vivacious Purple</option>
							<option value="Volcano Red">Volcano Red</option>
							<option value="White">White</option>
						    </select>
        
						    <span id="error_gender" class="text-danger"></span>
					        </div>
					        
					        <div class="form-group">
                            <select name="budget" class="form-control" onchange="this.form.submit()">
                            <option style="display:none;" value="SELECT" selected="">Budget</option>
                            <option value="SELECT">Any</option>
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
                            <span id="error_gender" class="text-danger"></span>
					        </div>
		                    </div>
		                    </div>
		                    </form>
                            </div>
                            
                     <!--================== center section ===================--> 
                               <di v class="col-md-7" style="padding-right: 0px;">
                               <div class="col-md-12 search1" id="to5">
						       <div class="col-md-12 search3">
							   <span class="search2"> <a href="#" target="_blink" id="car8">${bikeal.VARIANT_NAME}</a></span>
							   </div>
								
						       <div class="col-md-11">
							   <span> <a href="#" style="cursor: pointer;">
							   <img src="images/bo12.jpg"  onclick="toggle_visibility('foo');" class="img-responsive" id="search1 to4"/></a>
						       </span>
							   </div>
							   </div>
							   
							   
							   <div class="col-md-12 search1" id="to5">
						       <div class="col-md-12 search3">
							   <span class="search2"> <a href="#" target="_blink" id="car8">${bikeal.VARIANT_NAME}</a></span>
							   </div>
								
						       <div class="col-md-11">
							   <span> <a href="#" style="cursor: pointer;">
							   <img src="images/bo12.jpg"  onclick="toggle_visibility('foo1');"  class="img-responsive" id="search1 to4"/></a>
						       </span>
							   </div>
							   </div>
							   
                               </div>
                      <!--================== center section ===================-->       
                            
                            </div>
                
              

				    <div class="sidebar">
				    <div class="col-md-12 search1" style="padding: 8px 11px; border-top: 2px solid #dc0404; border-left: 2px solid #dc0404; display:none;" id="foo">
                                <div class="col-md-10" style="padding:0px 0px;"><span class="bi1">Ex-Showroom :</span>
	                   		    <span class="bi2"><i class="fa fa-inr"></i> 65,869</span>
	                   			</div>
	                   			  
	                   			 <div class="col-md-1">
	                   			 <input type="checkbox" id="scales" name="scales" style="width:20px; height: 20px;">
	                   			 </div>
	                   			  
	                   			   <div class="col-md-12" style="padding:0px 0px;">
	                   			   <div class="control-group">
                                    <label class="col-md-1 control-label" for="username" style="padding:0px 0px;">City</label>
                                    <div class="col-md-5 controls">
                                     <select id="inputState" class="form-control" style="height: 25px;">
                                    <option selected>Hyderabad</option>
                                    <option> S.r nager</option>
                                    <option> Ameerpet</option>
                                    <option> JntuH</option>
                                    <option> Kphb</option>
                                    </select>
                                    </div>
                                    </div>
	                   			  </div>
	                   			  
	                   			  <div class="col-md-12" style="padding:0 0px;">
	                   			     <div class="panel-group" id="accordion">
                                     <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                     <h4 class="panel-title"> Engine</h4>   
                                     </a>
                                     </div>
                                     <div id="collapse1" class="panel-collapse collapse in">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Engine Type :</span>
                                     <span class="two">Single Cylinder, 4-Stroke, OHC with i3S</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Displacement(cc) :</span>
                                     <span class="two">149.1 c</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Maximum Torque :</span>
                                     <span class="two">8.7 Nm @ 5500 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Bore :</span>
                                     <span class="two">50 mm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Stroke :</span>
                                     <span class="two">58.5 mm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Ignition :</span>
                                     <span class="two">Full Transisterized CDI</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Electric Start :</span>
                                     <span class="two">Self Start</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">No Gears :</span>
                                     <span class="two">0</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Mileage : </span>
                                     <span class="two">63.8 Kmpl </span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Top Speed :</span>
                                     <span class="two">85 kmpl</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Color :</span>
                                     <span class="two">Grace Grey,Candy Blazing Red</span>
                                     </div>
                                     
                                     </div>
                                     </div>
                                     </div>
                                     
                                     <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                     <h4 class="panel-title">Fuel </h4>
                                     </a>
                                     </div>
							         <div id="collapse2" class="panel-collapse collapse">
							         <div class="panel-body">
							         <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
							         </div>
							         </div>
							         </div>
							         
                                     <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                     <h4 class="panel-title"> Brakes </h4>
                                     </a>
                                     </div>
                                     <div id="collapse3" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                                     <h4 class="panel-title">Tyres </h4>
                                     </a>
                                     </div>
                                     <div id="collapse4" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                                     <h4 class="panel-title">Chassies</h4>
                                     </a>
                                     </div>
                                     <div id="collapse5" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse6">
                                     <h4 class="panel-title">Dimensions </h4>
                                     </a>
                                     </div>
                                     <div id="collapse6" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse7">
                                     <h4 class="panel-title">Electricals </h4>
                                     </a>
                                     </div>
                                     <div id="collapse7" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    <div class="panel panel-default">
                                     <div class="panel-heading">
                                     <a class="bi3" data-toggle="collapse" data-parent="#accordion" href="#collapse8">
                                     <h4 class="panel-title">Warranty </h4>
                                     </a>
                                     </div>
                                     <div id="collapse8" class="panel-collapse collapse">
                                     <div class="panel-body">
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     
                                     <div class="col-md-12 bi4">
                                     <span class="one">Max Power :</span>
                                     <span class="two">13.59 Nm @ 8000 rpm</span>
                                     </div>
                                     </div>
                                     </div>
								    </div>
								    
								    </div> 
								    </div>
	                   			    </div>
	                   			   
                        </div>
                        </div>
                           
                           <div class="clearfix"></div>
        
           <!--================= end service section ==================-->   
             
         <!--============= scoical Section ================--> 
                <section class="get-offer">
                <div class="container">
                <div class="row">
                <div class="col-sm-4">
                <div class="input-group">
                <div class="input-group-btn">                                   
                </div>
                </div>
                </div>
                <div class="col-sm-5" style="text-align: center;">
                <span>Subscribe to our Newsletter</span>
                <h2>& Discover the best offers!</h2>
                </div>
                <div class="col-sm-4">
                <div class="input-group">
                <div class="input-group-btn">                                   
                </div>
                </div>
                </div>
                </div>
                </div>
                </section>
    <!--============= end scoical Section ================-->
        
    <!--============= Footer Section ================-->
            <footer>
            <jsp:include page="footer.jsp"></jsp:include>
            </footer>
	<!--============= end Footer Section ================-->
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
        
     <script type="text/javascript">
     
     $('input[type="text"]').keyup(function() {
    	    var col_name = $(this).attr('class');
    	    var search_val = $(this).val().toLowerCase();
    	    $('.' + col_name).closest('.content-wrap').css('display', 'none');
    	    $('.' + col_name).each(function() {
    	        console.log($(this).text(), 'text');
    	        var val = $(this).text();
    	        if(val.toLowerCase().indexOf(search_val) >= 0) {
    	            $(this).closest('.content-wrap').css('display', 'block');
    	        }
    	        
    	    });
    	    //$('.' + col_name).closest('.content-wrap').style('display', 'none');
    	});
     
     </script>   
     
<script>
function showServiceModal(str,email)
{
 	var email=email.value;
	if (str=="")  
	{  
		document.getElementById("txtHint").innerHTML="";  
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
			document.getElementById("txtHint").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("POST","./getServiceModal.jsp?sBrand="+str+"&email="+email,true);   
	xmlhttp.send();    
	}
	</script>

      <script>
function showVehicleBrand(str)
{
 	// var city=document.getElementById("mcity").value;
	if (str=="")  
	{  
		document.getElementById("txtHint3").innerHTML="";  
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
			document.getElementById("txtHint3").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./vehicleBrand.jsp?vBrand="+str,true);   
	xmlhttp.send();    
	}
	</script>
	
      <script>
function showServiceStreet(str)
{
 	// var city=document.getElementById("mcity").value;
	if (str=="")  
	{  
		document.getElementById("txtHint6").innerHTML="";  
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
			document.getElementById("txtHint6").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getServiceStreet.jsp?street="+str,true);   
	xmlhttp.send();    
	}
	</script>
         
         <script type="text/javascript">
         
         $.fn.stars = function() {
        	    return $(this).each(function() {
        	        // Get the value
        	        var val = parseFloat($(this).html());
        	        // Make sure that the value is in 0 - 5 range, multiply to get width
        	        var size = Math.max(0, (Math.min(5, val))) * 16;
        	        // Create stars holder
        	        var $span = $('<span />').width(size);
        	        // Replace the numerical value with stars
        	        $(this).html($span);
        	    });
        	}
         $(function() {
        	    $('span.stars').stars();
        	});
         </script>
         
       <script type="text/javascript">

        function toggle_visibility(id) {
        var e = document.getElementById("foo");
        if(e.style.display == 'block')
        e.style.display = 'none';
        else
        e.style.display = 'block';
        }
  
    
     </script>
     
     <script type="text/javascript">
     document.getElementById('home1').className = 'active';
     </script>
     
	<!--  <script>
       function myFunction() {
	
       var x = document.getElementById("five");

       if (x.style.display === "none") {
       x.style.display = "block";
       } else {
       x.style.display = "none";
      }
      }
     </script> -->
    </body>
</html>