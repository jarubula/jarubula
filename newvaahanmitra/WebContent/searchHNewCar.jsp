<%@page import="sun.invoke.empty.Empty"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra | Search New Car</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/kosuri.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />



<!--  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="assets/css/jquery.scrolling-tabs.css">

    <link rel="stylesheet" href="assets/css/st-demo.css">
<script type="text/javascript">
function b(){
    if(document.getElementById('scheckbox').checked)
    {
   var element = document.getElementById("sendenquiry");
  element.classList.remove("disabled");  	
    }
    else{
   var element = document.getElementById("sendenquiry");
   element.classList.add("disabled");  
    }
   
   }
</script>
<script LANGUAGE="JavaScript">

function enable_text()
{
	if(document.getElementById('scheckbox').checked)
    {
   var element = document.getElementById("sendenquiry");
  	element.classList.remove("disabled");  	
    }
    else{
   var element = document.getElementById("sendenquiry");
   element.classList.add("disabled");  
    }

var checkboxes = document.getElementsByName("scheckbox");
var checkboxesChecked = [];
// loop over them all
for (var i=0; i<checkboxes.length; i++) {
   // And stick the checked ones onto an array...
   if (checkboxes[i].checked) {
      checkboxesChecked.push(checkboxes[i].value);
   }
}
//alert(checkboxesChecked);
// Return the array if it is non-empty, or null
//return checkboxesChecked.length > 0 ? checkboxesChecked : null;
document.getElementById("vehicleids").value=checkboxesChecked;
document.getElementById("vehicleids1").value=checkboxesChecked;
document.getElementById("pCity2").value=document.getElementById("preferredCity").value;
document.getElementById("pCity4").value=document.getElementById("preferredCity").value;
/* status=!status;
document.getElementById("sendenquiry").disabled = status; */
}

</script>
<script>
function getNewVcleBrand(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint20").innerHTML="";  
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
			document.getElementById("txtHint20").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getADNewVecleBrand.jsp?vType="+str,true);   
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

<script>
	function getVehicleModels(str) {
	
		var vType = document.getElementById("vType").value;
		if (str == "") {
			document.getElementById("txtHintD").innerHTML = "";
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
				document.getElementById("txtHintD").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getADNewHVecleModel.jsp?vBrand="+str+ "&vType="+ vType, true);
		xmlhttp.send();
	}
</script>

<script>
	function getVehicleVariant(str) {
		
		var vbrand = document.getElementById("vehicleBrand").value;
		var vmodel = document.getElementById("vehicleModel").value;
		var vType = document.getElementById("vType").value;
		
		if (str == "") {
			document.getElementById("txtHintV").innerHTML = "";
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
				document.getElementById("txtHintV").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getVariantbyBrandModel.jsp?vbrand="+vbrand+ "&vmodel="+vmodel+"&vType="+vType, true);
		xmlhttp.send();
	}
</script>

<script>
	function gotoPage(str) {
		var ArrNames = str.split("~")
        var Name0= ArrNames[0];
		var Name1 = ArrNames[1];
		var Name2 = ArrNames[2];
		var var_name = ArrNames[3];
	
		if (var_name == "") {
			
			document.getElementById(var_name).innerHTML          = "";
			document.getElementById(Name2).innerHTML             = "";
			document.getElementById(var_name+Name2).innerHTML    = "";
			document.getElementById(Name2+var_name).innerHTML    = "";

			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp  = new XMLHttpRequest();
		    xmlhttp1 = new XMLHttpRequest();
		    xmlhttp2 = new XMLHttpRequest();
		    xmlhttp3 = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp  = new ActiveXObject("Microsoft.XMLHTTP");
			xmlhttp1 = new ActiveXObject("Microsoft.XMLHTTP");
			xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
			xmlhttp3 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById(var_name).innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp1.onreadystatechange = function() {
			if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
				document.getElementById(Name2).innerHTML = xmlhttp1.responseText;
			}
		}
		xmlhttp2.onreadystatechange = function() {
			if (xmlhttp2.readyState == 4 && xmlhttp2.status == 200) {
				document.getElementById(var_name+Name2).innerHTML = xmlhttp2.responseText;
			}
		}
		xmlhttp3.onreadystatechange = function() {
			if (xmlhttp3.readyState == 4 && xmlhttp3.status == 200) {
				document.getElementById(Name2+var_name).innerHTML = xmlhttp3.responseText;
			}
		}
		xmlhttp.open("GET", "./getDealersDeatilsByCity.jsp?city="+ str, true);
		xmlhttp1.open("GET", "./getExshowroomPriceBycar_id.jsp?ID="+ str, true);
		xmlhttp2.open("GET", "./getSparePartDealerByCity.jsp?ID="+ str, true);
		xmlhttp3.open("GET", "./getServiceCenterByCity.jsp?ID="+ str, true);
		xmlhttp.send();
		xmlhttp1.send();
		xmlhttp2.send();
		xmlhttp3.send();

	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
window.toggleChevron = function(button) {
    $(button).find('span').toggleClass('glyphicon glyphicon-plus glyphicon glyphicon-minus ');
}
</script>

<style>
.scrtabs-tabs-fixed-container {
    float: left;
    height: 27px !important;
    overflow: hidden;
    width: 100%;
}
.scrtabs-tab-container {
    height: 28px;
}
</style>

</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
	
		<jsp:include page="./homeTop.jsp"></jsp:include>
		<%
			String veType       = null;
			String vBrand       = (String)request.getAttribute("vBrand");
			String vModel       = (String)request.getAttribute("vModel");
			String vType        = (String)request.getAttribute("vType");
			String vvariant     = (String)request.getAttribute("vvariant");
			String makeyear     = (String)request.getAttribute("makeyear");
			String spage        = (String)request.getAttribute("spage");
			String bodyType     = (String)request.getAttribute("bodytype");
			String fuelType     = (String)request.getAttribute("fueltype");
	        String transmission = (String)request.getAttribute("transmission");
	        String color        =  (String)request.getAttribute("color");
	        String budget       = (String)request.getAttribute("budget");
	 		if(vType.equals("2,")){
				veType = "Two Wheeler";
			}else{
			 veType = "Four Wheeler(Light Vehicle)";
			}
	 		
				String pv_type="4,"; 		
	 		
			int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
			try {
				page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
				maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
			} catch (Exception e) {

			}
			int k = (maxrowsperpage * page1) - maxrowsperpage;
		%>
		<section class="service-inner">
			<div class="container">
				<form action="./SearchNewVehicle" method="post">
				<div class="col-md-12" style="padding: 0px">
					<div class="row top">
					
					<div class="col-md-2" style=" padding: 0 0">
					   <div class="col-md-12 col-sm-6 col-xsm-12">
						 <div class="form-group">
					      <label for="email">Vehicle Type :</label>
					      <select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
									<option  style="display:none;" value="SELECT"><%=((veType==null?"Vehicle Type":veType.equals("SELECT")?"Vehicle Type":veType))%></option>
									<option value="" style="display: none;">Vehicle Type</option>
									<option value="2,">Two Wheeler</option>
									<option value="4,">Four Wheeler(Light Vehicle)</option>
								</select>
                            </div>
                            	  </div>
                            	  </div>
					<div class="col-md-8" style=" padding: 0 0">
					
						<div class="col-md-3 col-sm-6 col-xsm-12">
						<div class="form-group">
					      <label for="email">Vehicle Brand :</label>
								<div id="txtHint20">
									<select name="vehicleBrand" class="form-control" required="required">
										<option  style="display:none;" value="SELECT"><%=((vBrand==null?"Vehicle Brand":vBrand.equals("SELECT")?"Vehicle Brand":vBrand))%></option>
										<option value="SELECT" style="display: none;">Vehicle Brand</option>
									</select>
								</div>
                            </div>
						</div>
						
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Vehicle Model :</label>
									<!-- filters select -->
									<div id="txtHintD">
										<select name="vehicleModel" class="form-control">
											<option  style="display:none;" value="SELECT"><%=((vModel==null?"Vehicle Model":vModel.equals("SELECT")?"Vehicle Model":vModel))%></option>
											<option value="SELECT" style="display: none;">Vehicle Model</option>
										</select>
									</div>
								</div>
						    </div>
						    
						     <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Variant :</label>
									<!-- filters select -->
									<div id="txtHintV">
											<select name="vvariant" class="form-control">
											<option  style="display:none;" value="SELECT"><%=((vvariant==null?"Vehicle Variant":vvariant.equals("SELECT")?"Vehicle Variant":vvariant))%></option>
											<option value="SELECT" style="display: none;">Vehicle Variant</option>
										</select>
									</div>
								</div>
						    </div>
						    
						    <div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Make Year :</label>
									<!-- filters select -->
									<div id="txtHintD">
										<select name="makeYear" class="form-control">
											      <%
	                                            Date today = new Date();
	                                            Calendar cal = Calendar.getInstance();
	                                            cal.setTime(today);
	                                            int currentyear = cal.get(Calendar.YEAR);
	                                            int previous =currentyear-1;
	                                            %>
	                                            <option value="SELECT" style="display:none;"><%=((makeyear==null?"Make Year":makeyear.equals("SELECT")?"Make Year":makeyear.equals(currentyear)?"Current Year":makeyear.equals(previous)?"Previous Year":makeyear))%></option>
	                                            <option value="<%=currentyear%>">Current Year</option>
	                                            <option value="<%=previous%>">Previous Year</option>
										</select>
										        <input type="hidden" name="spage" value="result">
	                                            <input type="hidden" name="bodyType" value="SELECT">
	                                            <input type="hidden" name="fuelType" value="SELECT">
	                                            <input type="hidden" name="transmission" value="SELECT">
	                                            <input type="hidden" name="color" value="SELECT">
	                                            <input type="hidden" name="budget" value="SELECT">
	                                            <input type="hidden" name="vType" value="<%=vType%>">
									</div>
								</div>
						    </div>
						    </div>
						    
						    <div class="col-md-2" >
						    <label class="invisible">h</label>
                             <button type="submit" class="btn btn-primary btn-block">Search</button>
						   </div>
			           </form>
			        
			           	<div class="col-md-12 pa-2">
                 <div class="col-md-10" style="text-align: center;">
                  <span style="font-size: 16px; color: #ff3737;  font-family: inherit;">
					<%if(request.getAttribute("message")==null){}else{out.println(request.getAttribute("message"));} %>
					</span>
                 </div>
          		<div class="col-md-2">
         		<a href="#" role="button" class="btn btn-warning btn-block  disabled" onclick="document.getElementById('sendpopup2').style.display='block'" id="sendenquiry" name="sendenquiry"   style="line-height: 16px;">Send Enquiry</a>
      			</div>
      						</div>
						
						<!----------------- poppup ------------------- -->

	    <div class="col-md-12">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="./SearchHSendEnquiries" method="post">	
					<div id="sendpopup2" class="w3-modal">
					<input type="hidden" name="vehicleids1" id="vehicleids1">
					 <input type="hidden" name="usertype" id="usertype" value="old" >
					 <input type="hidden" name="vehicleBrand" id="vehicleBrand" value="<%=vBrand%>" >
					 <input type="hidden" name="vType" id="vType" value="<%=vType%>" >
					 <input type="hidden" name="vehicleModel" id="vehicleModel" value="<%=vModel%>" >
					 <input type="hidden" name="pCity2" id="pCity2">
					 		 <input type="hidden" name="vvariant" value="<%=vvariant%>">
	                 <input type="hidden" name="makeYear" value="<%=makeyear%>">
					 <input type="hidden" name="spage" value="result">
					 <input type="hidden" name="bodyType" value="<%=bodyType%>">
	                 <input type="hidden" name="fuelType" value="<%=fuelType%>">
	                 <input type="hidden" name="transmission" value="<%=transmission%>">
	                 <input type="hidden" name="color" value="<%=color%>">
	                  <input type="hidden" name="budget" value="<%=budget%>">
					<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="border-radius: 5px;">
					<div class="w3-cent"><span class="thre1">Send Enquiry</span>
					<span style="font-size: 13px!important;" onclick="document.getElementById('sendpopup2').style.display='none'"
					class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal"><span class="glyphicon">&#xe014;</span></span>
					</div>
									<hr>
						
                        <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">EMail ID : </label>
                         <input type="text" name="emailid" id="emailid" class="form-control" placeholder="Enter Your Email ID"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                        
                       <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">Password : </label>
                       <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                  
                    <div class="col-md-12" style=" border: 1px solid #ddd;margin: 0px 0;background: #eee; border-bottom-left-radius: 4px; border-bottom-right-radius: 4px;">
                       <div class="col-md-3" style="margin: 5px 0;"><button onclick="document.getElementById('sendpopup2').style.display='none'" type="button" class="btn btn-danger btn-block">Cancel</button></div>
                       <div class="col-md-6" style="margin: 5px 0;">
                         <a href="#" onClick="document.getElementById('sendpopup2').style.display='none',document.getElementById('register').style.display='block'" style="color:red;"><u style="font-size: 16px;">New User?</u></a>
                       </div>
                      <div class="col-md-3" style="margin: 5px 0;"><input type="submit" class="btn btn-primary btn-block" value="Submit"></div></div>
                  
                    
					<div class="w3-container w3-border-to style="border-radius: 5px;">
					</div>
								</div>
							</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		   </div>
			
							<!----------------- poppup ------------------- -->									 
									
<!----------------- poppup ------------------- -->
 

	    <div class="col-md-12">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="./SearchHSendEnquiries" method="post"><!-- ./SearchHSendEnquiries -->		
					<div id="register" class="w3-modal">
					 <input type="hidden" name="vehicleids" id="vehicleids">
					 <input type="hidden" name="usertype" id="usertype" value="new" >
					 <input type="hidden" name="vehicleBrand" id="vehicleBrand" value="<%=vBrand%>" >
					 <input type="hidden" name="vType" id="vType" value="<%=vType%>" >
					 <input type="hidden" name="pCity4" id="pCity4">
					 <input type="hidden" name="vehicleModel" id="vehicleModel" value="<%=vModel%>" >
					 <input type="hidden" name="vvariant" value="<%=vvariant%>">
	                 <input type="hidden" name="makeYear" value="<%=makeyear%>">
					  <input type="hidden" name="spage" value="result">
					 <input type="hidden" name="bodyType" value="<%=bodyType%>">
	                 <input type="hidden" name="fuelType" value="<%=fuelType%>">
	                 <input type="hidden" name="transmission" value="<%=transmission%>">
	                 <input type="hidden" name="color" value="<%=color%>">
	                  <input type="hidden" name="budget" value="<%=budget%>">
					 
					 
					 
					 
					 
					 
					<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="border-radius: 5px;">
					<div class="w3-cent"><span class="thre1">Send Enquiry</span>
					<span style="font-size: 13px!important; " onclick="document.getElementById('register').style.display='none'"
											class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal"><span class="glyphicon">&#xe014;</span></span>
					</div>
									<hr>
						<div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">Name : </label>
                        <input type="text" name="name" id="name" class="form-control" placeholder="Enter Your Name"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                        
                        <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">EMail ID : </label>
                         <input type="text" name="emailid" id="emailid" class="form-control" placeholder="Enter Your Email ID"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                        
                        <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">Phone Number : </label>
                        <input type="text" name="phoneno" id="phoneno" class="form-control" placeholder="Enter Phone No." onKeyPress="CheckNumeric(event)"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                        
                        <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">City </label>
                       <input type="text" name="city" id="city" class="form-control" placeholder="Enter City"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
				
                       <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">Password : </label>
                       <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
                  
                    <div class="col-md-12" style=" border: 1px solid #ddd;margin: 0px 0;background: #eee; border-bottom-left-radius: 4px; border-bottom-right-radius: 4px;">
                    
                       <div class="col-md-3" style="margin: 5px 0;"><button onclick="document.getElementById('register').style.display='none'" type="button"  class="btn btn-danger btn-block">Cancel</button></div>
                         <div class="col-md-6"><a href="#" onClick="document.getElementById('register').style.display='none',document.getElementById('sendpopup2').style.display='block'" style="color:red;"><u style="font-size: 16px;">already Existing User?</u></a></div>
                       <div class="col-md-3" style="margin: 5px 0;"><input type="submit" class="btn btn-primary btn-block" value="Submit"></div>
                      
                    </div>
                    
					<div class="w3-container w3-border-to style="border-radius: 5px;">
					<!-- <button onclick="document.getElementById('sendpopup').style.display='none'" type="button" class="btn btn-danger">Cancel</button> -->
					</div>
								</div>
							</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		    </div>
			
							<!----------------- poppup ------------------- -->
	       	
						</div>

					</div>
						
				<%
					ArrayList<AddCar> carDetails = (ArrayList<AddCar>) request.getAttribute("carDetails");
					int i = 0,j=0;
				%>
				
			<div class="col-lg-12 col-md-12 col-xs-12 side2" style="padding:0 0px;">	
		
			<!-----------------------side search bar ---------------------------->
		    <form action="./SearchNewVehicle" method="post">
		    <div class="col-md-3 col-sm-6 col-xsm-12" style="padding-right: -1px; padding-left: 0.5em;">	
		    <div class="side1">	
		    
		    <h2 class="side3">Advance Search</h2>
		                                          <input type="hidden" name="spage" value="result">
	                                           <input type="hidden" name="vType" value="<%=vType%>">
	                                            <input type="hidden" name="vehicleBrand" value="<%=vBrand%>">
	                                            <input type="hidden" name="vehicleModel" value="<%=vModel%>">
	                                            <input type="hidden" name="vvariant" value="<%=vvariant%>">
	                                            <input type="hidden" name="makeYear" value="<%=makeyear%>">
	                                           
	                                           
		    
			    	    <div class="form-group">
												<jsp:include page="./GetBodyType.jsp"><jsp:param value="<%=bodyType%>" name="bodytype"/></jsp:include>

						<span id="error_gender" class="text-danger"></span>
					   </div>
					
						
						 <div class="form-group">
						<select  class="form-control" name="fuelType" onchange="this.form.submit()">
							<option style="display: none;" value="<%=((fuelType==null || fuelType.equals("null") || fuelType.equals("SELECT")?"SELECT":fuelType))%>" selected><%=((fuelType==null || fuelType.equals("null") || fuelType.equals("SELECT")?"Fuel Type":fuelType)) %></option>
							 <option value="PETROL">PETROL</option>
                             <option value="DIESEL">DIESEL</option>
                             <option value="CNG">CNG</option>
                             <option value="LPG">LPG</option>
                             <option value="ELECTRIC">ELECTRIC</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					   </div>
					   
					    <div class="form-group">
						<select name="transmission" class="form-control"  onchange="this.form.submit()">
							<option style="display: none;" value="<%=((transmission==null || transmission.equals("null") || transmission.equals("SELECT")?"SELECT":transmission)) %>" selected><%=((transmission==null || transmission.equals("null") || transmission.equals("SELECT")?"Transmission":transmission)) %></option>
							<option value="Manual">Manual</option>
                            <option value="Automatic">Automatic</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					   </div>
					   
					    <div class="form-group">
						<jsp:include page="./GetColors.jsp"><jsp:param value="<%=color%>" name="color"/></jsp:include>
						<span id="error_gender" class="text-danger"></span>
					   </div>
					   
					     <div class="form-group">
                                                <select name="budget" class="form-control" onchange="this.form.submit()">
                                                <option style="display:none;" value="<%=((budget==null || budget.equals("null") || budget.equals("SELECT")?"SELECT":budget)) %>" selected><%=((budget==null || budget.equals("null") || budget.equals("SELECT")?"Budget":budget)) %></option>
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
		    </div></form>
		<!-------------------------end side search bar ------------------------>	
				<div class="col-md-9" style="padding:0px">
				<c:forEach var="caral" items="${carDetails}">
			
	   <div class="col-md-12 search1">
	   <section class="col-lg-9 col-md-9 col-sm-9 col-xsm-9"  id="pa-1">
					<div class="containe">
        <div class="col-md-8 search3">
				<span class="search2">${caral.CAR_BRAND} > ${caral.CAR_MODEL} > <a href="carDetails.jsp?vid=${caral.NEW_CAR_ID}"  target="_blink" id="car8">${caral.VARIANT_NAME}</a></span>
						</div>
						<div class="col-md-3 " style="margin: 8px 2px;">
							<%-- <button	onclick="document.getElementById('idr<%=i%>').style.display='block'" class="btn btn-primary btn-block" style="font-size: 14px;">
								Show Dealers
							</button> --%>
							<div class="col-md-12">
							<div class="col-md-4"></div>
							<div class="col-md-4">
							<form action="./SearchDealers" method="post">
							 <div id="idr<%=i%>" class="w3-modal">
							 <br><br><br>
							 <input type="hidden" name="model" value="${caral.CAR_MODEL}">
							 <input type="hidden" name="brand" value="${caral.CAR_BRAND}">
							 <input type="hidden" name="vType" value="4,">
								<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="border-radius: 5px;">
									<div class="w3-cent">
									<span class="thre1">Show Dealers</span>
									 <span style="font-size: 13px!important; " onclick="document.getElementById('idr<%=i%>').style.display='none'"
											class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">×</span>
									</div>
									<hr>
									 <div class="col-md-12">
					    <div class="form-group"> 	 
                        <label for="firstname" style="font-size:16px;">City </label>
                         <input type="text" name="city" class="form-control" placeholder="Enter City"  required>
                        <div id="errFirst"></div>    
                        </div>	
                        </div>
							
                   <div class="col-md-12" style=" border: 1px solid #ddd;margin: 0px 0;background: #eee; border-bottom-left-radius: 4px; border-bottom-right-radius: 4px;">
                    <div class="col-md-1"></div>
                       <div class="col-md-3" style="margin: 5px 0;"><button onclick="document.getElementById('idr<%=i%>').style.display='none'" type="button" class="btn btn-danger btn-block">Cancel</button></div>
                         <div class="col-md-4"></div>
                       <div class="col-md-3" style="margin: 5px 0;"><input type="submit" class="btn btn-primary btn-block" value="Submit"></div>
                       <div class="col-md-1"></div>
                    </div>
									<div class="w3-container w3-border-to style="border-radius: 5px;">
										<%-- <button onclick="document.getElementById('idr<%=i%>').style.display='none'" type="button" class="btn btn-danger">Cancel</button> --%>
									</div>
								</div>
							</div>
							</form>
							</div>
							<div class="col-md-4"></div>
							</div>
						
					</div>
						<div class="col-md-12 search3 xs-12">
						
			    <ul class="nav nav-tabs" role="tablist">
			      <li role="presentation" class="active"><a href="#engine<%=i%>" role="tab" data-toggle="tab">Engine</a></li>
			      <li role="presentation"><a href="#fuel<%=i%>" role="tab" data-toggle="tab">Fuel</a></li>
			      <li role="presentation"><a href="#color<%=i%>" role="tab" data-toggle="tab">Color</a></li>
			      <li role="presentation"><a href="#brake<%=i%>" role="tab" data-toggle="tab">Brakes & Tyres</a></li>
			      <li role="presentation"><a href="#dimensions<%=i%>" role="tab" data-toggle="tab">Dimensions</a></li>
			      <li role="presentation"><a href="#suspensions<%=i%>" role="tab" data-toggle="tab">Suspensions</a></li>
			      <li role="presentation"><a href="#seating<%=i%>" role="tab" data-toggle="tab">Seating</a></li>
			      <li role="presentation"><a href="#safety<%=i%>" role="tab" data-toggle="tab">Safety</a></li>
			      <li role="presentation"><a href="#lock<%=i%>" role="tab" data-toggle="tab">Lock & Security</a></li>
			      <li role="presentation"><a href="#comfort<%=i%>" role="tab" data-toggle="tab">Comfort</a></li>
			      <li role="presentation"><a href="#lamp<%=i%>" role="tab" data-toggle="tab">Lamp</a></li>
			      <li role="presentation"><a href="#doors<%=i%>" role="tab" data-toggle="tab">Doors & Windows</a></li>
			      <li role="presentation"><a href="#entertainment<%=i%>" role="tab" data-toggle="tab">Entertainment</a></li>
			      <li role="presentation"><a href="#instrmentation<%=i%>" role="tab" data-toggle="tab">Instrumentation</a></li>
			      <li role="presentation"><a href="#warranty<%=i%>" role="tab" data-toggle="tab">Warranty</a></li>      
			    </ul>		
					
              <div class="tab-content">
              <div id="engine<%=i%>" class="tab-pane fade in active">
					<%-- <div class="col-md-6">
						<p><span class="one">Brand:</span><span class="two"> ${caral.CAR_BRAND}</span></p>
					</div> --%>
					<div class="col-md-12">
						<p><span class="one">Engine Type :</span><span class="two" style="line-height: 18px;">${caral.ENGINE_TYPE}</span></p>
					</div>
					
					<div class="col-md-6">
						<p><span class="one">Seating Capacity:</span><span class="two" style="line-height: 18px;"> ${caral.SEATING_CAPACITY}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Car Make Year :</span><span class="two" style="line-height: 18px;"> ${caral.CAR_MAKE_YEAR}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">No of Gears :</span><span class="two" style="line-height: 18px;">${caral.NO_OF_GEARS}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Body Type :</span><span class="two" style="line-height: 18px;">${caral.BODY_TYPE} </span></p>
					</div>
					
					<div class="col-md-6">
						<p><span class="one">Displacement(cc) :</span><span class="two" style="line-height: 18px;">${caral.ENGINE_DISPLACEMENT} </span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">No.of.Cylinders :</span><span class="two" style="line-height: 18px;"> ${caral.NO_OF_CYLINDERS}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Valves per Cylinder :</span><span class="two" style="line-height: 18px;">${caral.VALVES_PER_CYLINDERS}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Max Power :</span><span class="two" style="line-height: 18px;">${caral.MAX_POWER}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Max Torque :</span><span class="two" style="line-height: 18px;">${caral.MAX_TORQUE} </span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Fuel supply System :</span><span class="two" style="line-height: 18px;"> ${caral.FUEL_SUPPLY_SYSTEM}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Transmission Type :</span><span class="two" style="line-height: 18px;">${caral.TRANSMISSION_TYPE}</span></p>
					</div>
					<div class="col-md-6">
						<p><span class="one">Gear Box :</span><span class="two" style="line-height: 18px;">${caral.GEAR_BOX}</span></p>
					</div>
					<div class="col-md-12">
						<p><span class="one">Wheel Drive :</span><span class="two" style="line-height: 18px;">${caral.WHEEL_DRIVE} </span></p>
					</div>
             </div>
             
             <div id="fuel<%=i%>" class="tab-pane fade">
             <div class="col-md-6">
					<p><span class="one">Mileage :</span><span class="two" style="line-height: 18px;">${caral.MILEAGE} </span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Fuel Type :</span><span class="two" style="line-height: 18px;">${caral.FUEL_TYPE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Fuel Tank Capacity :</span><span class="two" style="line-height: 18px;">${caral.FUELTANK_CAPACITY}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Top Speed :</span><span class="two" style="line-height: 18px;"> ${caral.TOP_SPEED}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Acceleration(0-100Kms) :</span><span class="two" style="line-height: 18px;"> ${caral.ACCELERATION}</span></p>
					</div>
					
             </div>
             
                <div id="color<%=i%>" class="tab-pane fade">
             <div class="col-md-6">
					<p><span class="one">Color :</span><span class="two" style="line-height: 18px;">${caral.COLOR} </span></p>
					</div>
				
             </div>
             
             <div id="brake<%=i%>" class="tab-pane fade">
             <div class="col-md-6">
					<p><span class="one">Tyre Type :</span><span class="two" style="line-height: 18px;"> ${caral.TYRE_TYPE}</span></p>
				</div>
             	<div class="col-md-6">
					<p><span class="one">Front Brake Type :</span><span class="two" style="line-height: 18px;"> ${caral.FRONT_BRAKE_TYPE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Rare Brake Type :</span><span class="two" style="line-height: 18px;"> ${caral.RARE_BRAKE_TYPE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Anti Lock Braking System :</span><span class="two" style="line-height: 18px;"> ${caral.ANTI_LOCK_BRAKING_SYSTEM}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Tyre Size :</span><span class="two" style="line-height: 18px;"> ${caral.TYRE_SIZE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Wheel Size :</span><span class="two" style="line-height: 18px;"> ${caral.WHEEL_SIZE}</span></p>
				</div>
             </div>
             
             <div id="dimensions<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Length :</span><span class="two" style="line-height: 18px;">${caral.LENGTH}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Width :</span><span class="two" style="line-height: 18px;"> ${caral.WIDTH}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Height :</span><span class="two" style="line-height: 18px;">${caral.HEIGHT}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Wheel base :</span><span class="two" style="line-height: 18px;"> ${caral.WHEEL_BASE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Ground Clearance :</span><span class="two" style="line-height: 18px;">${caral.GROUND_CLEARANCE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Boot Space :</span><span class="two" style="line-height: 18px;">${caral.BOOT_SPACE}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Krab Weight :</span><span class="two" style="line-height: 18px;">${caral.KRAB_WEIGHT}</span></p>
				</div>
             </div>
             
             <div id="suspensions<%=i%>" class="tab-pane fade">
             	<div class="col-md-12">
					<p><span class="one">Front Suspension :</span><span class="two" style="line-height: 18px;">${caral.FRONT_SUSPENSION}</span></p>
				</div>
				<div class="col-md-12">
					<p><span class="one">Rear Suspension :</span><span class="two" style="line-height: 18px;">${caral.REAR_SUSPENSION}</span></p>
				</div>
				<div class="col-md-12">
					<p><span class="one">Steering Type :</span><span class="two" style="line-height: 18px;">${caral.STEERING_TYPE}</span></p>
				</div>
				<div class="col-md-12">
					<p><span class="one">Minimum Truning Radius(Wheel) :</span><span class="two" style="line-height: 18px;">${caral.TURNING_RADIONS}</span></p>
				</div>
             </div>
             
             <div id="seating<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Seating Capacity :</span><span class="two" style="line-height: 18px;">${caral.SEATING_CAPACITY}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Front Passenger Seat Adjustment :</span><span class="two" style="line-height: 18px;">${caral.ADJUST_PASSENGER_SEAT}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Folding Rear Seat :</span><span class="two" style="line-height: 18px;">${caral.FOLDING_REAR_SEAT}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Split Rear Seat :</span><span class="two" style="line-height: 18px;">${caral.SPLIT_RARE_SEAT}</span></p>
				</div>
             </div>
             <div id="safety<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Air Bags :</span><span class="two" style="line-height: 18px;">${caral.AIR_BAGS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Seat Belt Warning :</span><span class="two" style="line-height: 18px;">${caral.SEAT_BELT_WARNING}</span></p>
				</div>
             </div>
             
             
             <div id="lock<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Engine Immobilizer :</span><span class="two" style="line-height: 18px;">${caral.ENGINE_IMMOBILIZER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Central Locking System :</span><span class="two" style="line-height: 18px;">${caral.CENTRAL_LOCKING_SYSTEM}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Child Locking System :</span><span class="two" style="line-height: 18px;">${caral.CHILD_LOCKING_SYSTEM}</span></p>
				</div>
             </div>
             
             <div id="comfort<%=i%>" class="tab-pane fade">
            	 <div class="col-md-6">
					<p><span class="one">Power Steering :</span><span class="two" style="line-height: 18px;">${caral.POWER_STEERING}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Air Conditioner :</span><span class="two" style="line-height: 18px;">${caral.AIR_CONDITIONER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Rear A/C :</span><span class="two" style="line-height: 18px;">${caral.REAR_AC}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Steering Adjustment :</span><span class="two" style="line-height: 18px;">${caral.STEERING_ADJUSTMENT}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Keyless Start/Button Start :</span><span class="two" style="line-height: 18px;">${caral.KEYLESS_START}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Parking Sensors :</span><span class="two" style="line-height: 18px;">${caral.PARKING_SENSORS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Parking Assist :</span><span class="two" style="line-height: 18px;">${caral.PARKING_ASSIST}</span></p>
				</div>
             </div>
             
             <div id="lamp<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Automatic Head Lamps:</span><span class="two" style="line-height: 18px;">${caral.AUTOMATIC_HEAD_LAMPS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Fog Lamps:</span><span class="two" style="line-height: 18px;">${caral.FOR_LAMPS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Tail Lamps:</span><span class="two" style="line-height: 18px;">${caral.TAIL_LAMPS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Head Lamps :</span><span class="two" style="line-height: 18px;">${caral.HEAD_LIGHT}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Height Light Adjuster :</span><span class="two" style="line-height: 18px;">${caral.HEIGHT_ADJUSTER}</span></p>
				</div>
             </div>
             
             <div id="doors<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Power Windows :</span><span class="two" style="line-height: 18px;">${caral.POWER_WINDOWS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Rear Defogger :</span><span class="two" style="line-height: 18px;">${caral.REAR_DETOGGER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Rear Wiper :</span><span class="two" style="line-height: 18px;">${caral.REAR_WIPER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Rain Sensing Wiper :</span><span class="two" style="line-height: 18px;">${caral.RAIN_SENSING_WIPER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">No of Doors :</span><span class="two" style="line-height: 18px;">${caral.NO_OF_DOORS}</span></p>
				</div>
             </div>
             
             <div id="entertainment<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Music System :</span><span class="two" style="line-height: 18px;">${caral.MUSIC_SYSTEM}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Display :</span><span class="two" style="line-height: 18px;">${caral.DISPLAY}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Display Screen for Rear Passengers :</span><span class="two" style="line-height: 18px;">${caral.DISPLAY_SCREEN_REAR_PASSENGERS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">GPS Navigation System :</span><span class="two" style="line-height: 18px;">${caral.GPS_NAVIGATION_SYSTEM}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Speakers :</span><span class="two" style="line-height: 18px;">${caral.SPEAKERS}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">USB compatibility :</span><span class="two" style="line-height: 18px;">${caral.USB_COMPATIBILITY}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">MP3 Player :</span><span class="two" style="line-height: 18px;">${caral.MP3_PLAYER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">CD Player :</span><span class="two" style="line-height: 18px;">${caral.CD_PLAYER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">DVD Player :</span><span class="two" style="line-height: 18px;">${caral.DVD_PLAYER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">FM/AM Radio :</span><span class="two" style="line-height: 18px;">${caral.FM_RADIO}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">BlueTooth Compatibility :</span><span class="two" style="line-height: 18px;">${caral.BLUETOOTH}</span></p>
				</div>
             </div>
             
              <div id="instrmentation<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Clock :</span><span class="two" style="line-height: 18px;">${caral.CLOCK}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Low Fuel level Waring :</span><span class="two" style="line-height: 18px;">${caral.LOW_FUEL_LEVEL_WARNING}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Door Ajar Waring :</span><span class="two" style="line-height: 18px;">${caral.DOOR_CLOSE_WARNING}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Trip Meter :</span><span class="two" style="line-height: 18px;">${caral.TRIP_METER}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Gear Shift Indicator :</span><span class="two" style="line-height: 18px;">${caral.GEAR_SHIFT_INDICATOR}</span></p>
				</div>
             </div>
             <div id="warranty<%=i%>" class="tab-pane fade">
             	<div class="col-md-6">
					<p><span class="one">Warranty (Years) :</span><span class="two" style="line-height: 18px;">${caral.WARRANTY_YEAR}</span></p>
				</div>
				<div class="col-md-6">
					<p><span class="one">Warranty (Kms) :</span><span class="two" style="line-height: 18px;">${caral.WARRANTY_KMS}</span></p>
				</div>
             </div>
    
		  </div>
		  </div>
		  </div>
		  
		  <c:set var = "brand" value='${caral.CAR_BRAND}'/>
		  <c:set var = "model" value='${caral.CAR_MODEL}'/> 
		  <c:set var = "car_id" value='${caral.NEW_CAR_ID}'/>
		  <c:set var = "VAR_name" value='${caral.SEQUENCE_NO}'/>
		  <c:set var = "variant" value='${caral.VARIANT_NAME}'/>
		   
		  
		  <% 
		  		String brand                            = (String) pageContext.getAttribute("brand");
		        String model                            = (String) pageContext.getAttribute("model");
		        int var_name                            = (Integer) pageContext.getAttribute("VAR_name");
		        String variant                          = (String) pageContext.getAttribute("variant");
		        String car_id1                          = (String) pageContext.getAttribute("car_id");
		        
		        BusinessOwnerService bos                = new BusinessOwnerService();
		        String exshowroom                       = new GetNewCarDetails().getExshowroompricebyplaceandId(car_id1, "Hyderabad"); 
		        
		    	ArrayList<BusinessOwnerRegister> bor1   = bos.getDealers(brand,"Hyderabad",pv_type);
		    	ArrayList<BusinessOwnerRegister> splist = bos.getSparepartsDealers(brand, "Hyderabad", pv_type);
		    	ArrayList<BusinessOwnerRegister> sclist = bos.getServiceCenterDealers(brand, "Hyderabad", pv_type);
		  		ArrayList<BusinessOwnerRegister> city   = bos.getCity();
		  		
		  		Iterator it                             = city.iterator();
		  	
		  		
		  %>
		  
		  </section>
					<div class="col-md-3" style="margin: 5px 0; padding-right: 0px; padding-left: 0px;">
					 <span style="font-size:14px;color: #555;">Ex-Showroom :</span>
					 <span style="font-size: 14px; color: red;"> 
					 <i class="fa fa-inr" aria-hidden="true"></i><b id="<%=car_id1%>"><% try{
						 double value=0;String output=""; 
						 if(exshowroom!=""){ value= Integer.parseInt(exshowroom);
						 
						 output=new CurrencyFormate().indianrupee(value);
						 }
						 else{
							 output="NA";
						 }

%> <%=exshowroom.equals("")||exshowroom==""||exshowroom==null?"NA":output%></b><%}catch(NumberFormatException n){} %>
			  		 
			  		 
			  		 
			  		 
			  		 
			  		  <%--  ${bikeal.PRICE} --%>	&nbsp; &nbsp;
				    <input type="checkbox" calss="two1" id="scheckbox" name="scheckbox" value="${caral.SEQUENCE_NO}" onclick="enable_text()" style="width: 18px; height: 18px; float:right;"> 
					 </span>
					  <br>
					  <div class="tooltip1">
					
					 <span class="tooltiptext1" >PRICE</span>
					 </div>
					 
					 
					 
					 <div class="form-group" style="padding: 0 0; margin-bottom:6px;">
                    <label class="col-sm-2 control-label" style="font-size:15px;color: #555;padding: 0 0;">City </label>
                    <div class="col-sm-9">
                        <select id="preferredCity" name="preferredCity" onchange="gotoPage(this.value)" class="form-control" style="height: 24px; padding: 0px 6px;">
							<% while(it.hasNext()){
								BusinessOwnerRegister bor = (BusinessOwnerRegister)it.next();
							%>
							<option style="display: none">Hyderabad</option>
							<option value="<%=bor.getB_CITY()%>~<%=brand%>~<%=car_id1%>~<%=var_name%>~<%=pv_type%>"><%=bor.getB_CITY()%></option>
							<% 
								}
								%>
                        </select>
                    </div>
                </div> 
						<span> <a href="#" onclick="document.getElementById('id2<%=i%>').style.display='block'"><img src="data:image/png;base64,${caral.PHOTO1}" class="img-responsive"
								style="margin-top: 14px; border-radius: 5px; height:auto; width: 100%; font-size: 36px; font-family: sans-serif; text-align: center; margin-bottom: 3px;" id="search1"></a>
						</span>
						<div class="col-md-12">
						  <div class="col-md-2"></div>
						  <div class="col-md-8">
						  <%--  <span>
						   <button	onclick="document.getElementById('idr<%=i%>').style.display='block'" class="btn btn-primary btn-block" style="font-size: 14px;">
								Show Dealers
							</button>
						  </span> --%>
						  </div>
						   <div class="col-md-2"></div>
						</div>
					</div>
					  					
					<!------------------------- drop down ------------------------------>
		
					<div class="col-md-12" id="one">
					  <%-- <div class="col-md-3">
					  <button type="button"  style="line-height: 17px; background-color: #9a2220;" class="btn btn-danger arrow" data-toggle="collapse" data-target="#de<%=j%>" onclick="toggleChevron(this)">
                         Show Dealers  <span class="glyphicon glyphicon-plus"></span>
                     </button>
					  </div> --%>
					  
					<!--   <div class="col-md-9"> </div>
 -->					  
					   <!--  <div class="col-md-4">
					      <span class="se1"><a href="#" class="side4" style="text-decoration: underline;color: #e8392c;     font-size: 14px;
                          font-weight: 700;">show used cars</a></span>
					    </div> -->
					    
					    <div class="clearfix"></div>
					   
					     <div class="col-md-12" style="padding: 0 0;">
	
					    <div class="col-md-3 searH">
					     <button type="button" class="ten" data-toggle="collapse" data-target="#de<%=j%>" onclick="toggleChevron(this)">
                               Show Dealers  <span class="glyphicon glyphicon-plus" id="bike1"></button>
					     </div>
					    
					     <div class="col-md-3 searH">
					     <button type="button" class="ten" data-toggle="collapse" data-target="#dea<%=j%>" onclick="toggleChevron(this)">
                              Spare Parts <span class="glyphicon glyphicon-plus" id="bike4"></span></button> 
					     </div>
					     
					     <div class="col-md-3 searH">
					     <button type="button" class="ten" data-toggle="collapse" data-target="#deb<%=j%>" onclick="toggleChevron(this)">
                             Service Centre <span class="glyphicon glyphicon-plus" id="bike1"></span></button>
					     </div>
					     
					     <div class="col-md-3 searH">
					     <button type="button" class="ten" data-toggle="collapse" data-target="#dec<%=j%>" onclick="toggleChevron(this)">
                            Show Used Cars <span class="glyphicon glyphicon-plus" id="bike2"></span></button>
					     </div>
					     
					     <div class="col-md-1"> </div> 
					     <div class="col-md-2"></div>
					    
					      <div class="col-md-12 searH">
					    		  <div id="de<%=j%>" class="collapse">
					    <div class="col-md-12 search3" id="a_l">
			  <ul class="nav nav-tabs col-x-1">
			    <li class="active"><a data-toggle="tab" href="#home<%=i%>">City</a></li>
			   <%--  <li><a data-toggle="tab" href="#menu1<%=i%>">Transmission</a></li> --%>
			  </ul>
			
              <div class="tab-content">
              <div id="home<%=i%>" class="tab-pane fade in active table-responsive">
              <div2 id="<%=var_name%>">
              
					<div id="<%=var_name%>">
					<div id="no-more-tables">
					<table class="col-md-12 table-bordered table-striped table-condensed cf">
        <thead  class="cf">
        <tr>
        <th class="numeric">Dealer Name</th>
        <th class="numeric">Email Id</th>
        <th class="numeric">Address</th>
        <th class="numeric">Phone No.</th>
        <th class="numeric">On Road Price</th>
        <th class="numeric">Offers</th>
      </tr>
    </thead>
    <tbody><%Iterator al = bor1.iterator();
    		if(bor1.size()<= 0){
 		   %>
    <tr><td colspan="6" style=" text-align: center;
       padding: 10px 0;font-size: 14px;">Dealers not available! </td></tr>
   <%} %>
   		 	<% while(al.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)al.next();
			%>
		<tr>
			<td data-title="Name" class="numeric"><%=bor.getNAME()==null || bor.getNAME().equals("")?"NA":bor.getNAME()%></td>
        	<td data-title="Email" class="numeric"><%=bor.getEMAIL_ID()==null?"NA":bor.getEMAIL_ID()%></td>
			<td data-title="Address" class="numeric"><%=bor.getADDRESS()==null?"NA":bor.getADDRESS()%></td>
        	<td data-title="Phone" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
        	<%String car_id = (String) pageContext.getAttribute("car_id");
        	   int price=new BusinessOwnerService().getonRoadPrice(car_id,bor.getEMAIL_ID());
        	   int onroadprice=0;
        	   double on_ex=0;
        	   String final_value="";
        	   
        	   
        	   try{   if(price!=0){
        		   int exshowroomprice=Integer.parseInt(exshowroom);
        		   int dealercharge=price;
        		   onroadprice=exshowroomprice+dealercharge;
                   Integer integer=new Integer(onroadprice);
        		    on_ex=integer.doubleValue();
        		    final_value=new CurrencyFormate().indianrupee(on_ex);
        		    
        	   }else{
        		   onroadprice=0;
        	   }
        	   
        	   
        	   %>
        	   
        	   
        	<td data-title="Road Price" class="tooltip3"><%=onroadprice==0?"NA":final_value%> 
        
        	  <span class="tooltiptext3">
        	     <p style="line-height: 8px;"><span class="sear1">EXSHOWROOM PRICE :</span> <p align="right"><span  class="sear2"><%=exshowroom==""?"NA":exshowroom%> </span></p></p>
        	  	<%  HashMap<String,String> chm=new HashMap<String,String>();
        	      chm=new GetNewCarDetails().getItemandPricebydealer_id(car_id, bor.getEMAIL_ID());
        	      String item="";String price_item="";
        	      Set<Map.Entry<String,String>> entry=chm.entrySet();
        	      Iterator<Map.Entry<String,String>> it1=entry.iterator();
        	      while(it1.hasNext()){
        	    	  
        	    	  Map.Entry<String,String> entrySet=it1.next();
        	    	   item=entrySet.getKey();
        	    	  price_item= entrySet.getValue();
        	    
        	 
        	      %>
        	  <p style="line-height: 8px;"><span class="sear1"><%=item%> :</span> <p align="right"><span   class="sear2" ><%=price_item%> </span></p></p>
        	  <%}%>
        	  </span>
        	
        	</td>   <%}catch(NullPointerException n){} %>
        	<td data-title="Offers" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
        	<input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
        	
        	</td>
        		</tr>
			<%
				}
			%>
    </tbody>
    </table></div></div></div2></div>
             </div>   
     </div>
     </div>
					      </div>
					      
					      <div class="col-md-12">
					      <div id="dea<%=j%>" class="collapse">
                            
					    <div class="col-md-12 search3" id="a_l">
              <div class="tab-content">
              <div id="home<%=i%>" class="tab-pane fade in active table-responsive">
              
					<div id="<%=var_name+car_id1%>">
					<div id="no-more-tables">
					<table class="col-md-12 table-bordered table-striped table-condensed cf">
        <thead  class="cf">
        <tr>
        <th class="numeric">Dealer Name</th>
        <th class="numeric">Email Id</th>
        <th class="numeric">Address</th>
        <th class="numeric">Phone No.</th>
        <th class="numeric">Offers</th>
      </tr>
    </thead>
    <tbody><%Iterator spl = splist.iterator();
    		if(splist.size()<= 0){
 		   %>
    <tr><td colspan="6" style=" text-align: center;
       padding: 10px 0;font-size: 14px;">Spare Parts Dealers not available! </td></tr>
   <%} %>
   		 	<% while(spl.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)spl.next();
			%>
		<tr>
			<td data-title="Name" class="numeric"><%=bor.getNAME()==null || bor.getNAME().equals("")?"NA":bor.getNAME()%></td>
        	<td data-title="Email" class="numeric"><%=bor.getEMAIL_ID()==null?"NA":bor.getEMAIL_ID()%></td>
			<td data-title="Address" class="numeric"><%=bor.getADDRESS()==null?"NA":bor.getADDRESS()%></td>
        	<td data-title="Phone" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
                	   
        	   
        
        
        	
        	<td data-title="Offers" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
        	<input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
        	
        	</td>
        		</tr>
			<%
				}
			%>
    </tbody>
    </table></div></div></div>
             </div>   
     </div>
     </div>
					      </div>
                        
					      
					      <div class="col-md-12">
					      <div id="deb<%=j%>" class="collapse">
                           <div class="col-md-12 search3" id="a_l">
              <div class="tab-content">
              <div id="home<%=i%>" class="tab-pane fade in active table-responsive">
              
					<div id="<%=car_id1+var_name%>">
					<div id="no-more-tables">
					<table class="col-md-12 table-bordered table-striped table-condensed cf">
        <thead  class="cf">
        <tr>
        <th class="numeric">Dealer Name</th>
        <th class="numeric">Email Id</th>
        <th class="numeric">Address</th>
        <th class="numeric">Phone No.</th>
        <th class="numeric">Offers</th>
      </tr>
    </thead>
    <tbody><%Iterator scl = sclist.iterator();
    		if(sclist.size()<= 0){
 		   %>
    <tr><td colspan="6" style=" text-align: center;
       padding: 10px 0;font-size: 14px;">Service Center Dealers not available! </td></tr>
   <%} %>
   		 	<% while(scl.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)scl.next();
			%>
		<tr>
			<td data-title="Name" class="numeric"><%=bor.getNAME()==null || bor.getNAME().equals("")?"NA":bor.getNAME()%></td>
        	<td data-title="Email" class="numeric"><%=bor.getEMAIL_ID()==null?"NA":bor.getEMAIL_ID()%></td>
			<td data-title="Address" class="numeric"><%=bor.getADDRESS()==null?"NA":bor.getADDRESS()%></td>
        	<td data-title="Phone" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
                	   
        	   
        
        
        	
        	<td data-title="Offers" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
        	<input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
        	
        	</td>
        		</tr>
			<%
				}
			%>
    </tbody>
    </table></div></div></div>
             </div>   
     </div>
                          </div>
					      </div>
					      
					      <div class="col-md-12">
					      <div id="dec<%=j%>" class="collapse">
					    <p><a href="./SearchUsedCar?carBrand=<%=brand%>&vType=<%=vType %>&carModel=<%=model%>&carVariant=<%=variant%>&city=SELECT&carBudget=SELECT" target="blank" >CLICK HERE TO GET SIMILAR TYPE OF USED CAR</a></p>
                          </div>
					      </div>
					   	   
					    </div>
					    
				    	</div>
					
					  <div id="de<%=j%>" class="collapse">
					    <div class="col-md-12 search3" id="ShowDealers<%=i%>">
			  <ul class="nav nav-tabs col-x-1">
			    <li class="active"><a data-toggle="tab" href="#home<%=i%>">City</a></li>
			   <%--  <li><a data-toggle="tab" href="#menu1<%=i%>">Transmission</a></li> --%>
			  </ul>
			
             </div>   
  </div>
  </div>			 
					<!-- ----------------------- end drop down ---------------------- -->
					
					<div class="col-md-12">
							<div class="col-md-4"></div>
							<div class="col-md-4">
							  <div id="id2<%=i%>" class="w3-modal">
								<div class="w3-modal-content1 w3-card-4 w3-animate-zoom" style="border-radius: 5px;">
									<div class="w3-cent">
									<span class="thre1">${caral.VARIANT_NAME} IMAGES</span>
									 <span style="font-size: 13px!important; " onclick="document.getElementById('id2<%=i%>').style.display='none'"
											class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal"><span class="glyphicon">&#xe014;</span></span>
									</div>
									<hr>
									<iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="NewCarImageSlider.jsp?vid=${caral.NEW_CAR_ID}"  style="min-height:540px; background: #fff;"></iframe>
									<div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius: 5px;">
										<button onclick="document.getElementById('id2<%=i%>').style.display='none'" type="button" class="btn btn-danger">Cancel</button>
									</div>
								</div>
							</div> 
							</div>
							<div class="col-md-4"></div>
							</div>
				
				<%i++;j++;%>
				</c:forEach> 
				</div>
				  <div class="container">
				 <div class="col-md-3"></div>
		         <div class="col-md-9" style="padding:0 0px;">
		         			         	
		  <c:set var = "currentPage" value='${currentPage}'/>
 <c:set var = "noOfPages" value='${noOfPages}'/>
 <%  int currentpage = (Integer) pageContext.getAttribute("currentPage");int noofpages = (Integer) pageContext.getAttribute("noOfPages"); %>
<nav aria-label="...">
      <ul class="pagination">
      <%if(currentpage==1){ %>
        <li class="page-item disabled">
          <a class="page-link"><i class="fa fa-angle-double-left" aria-hidden="true" style=" min-height:17px;"></i></a>
        </li>
      <%}else{ %>
     <li class="page-item">
          <a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage-1%>"><i class="fa fa-angle-double-left" aria-hidden="true" style=" min-height: 20px;"></i></a>
        </li>
        <%}
        for(int m=1;m<=noofpages;m++){ 
         if(m==currentpage)
         {
        %>
         <li class="page-item active"><a class="page-link"href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=m%>"><%=currentpage %></a></li>
         <%}else{ %>
       
         <%}} if(currentpage<noofpages){ %>
          <li class="page-item"><a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage+1%>"><%=currentpage+1%></a></li>
      <%if(currentpage+2<noofpages){ %>    <li class="page-item"><a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage+2%>"><%=currentpage+2%></a></li>
        <%}if(currentpage+3<noofpages){ %>  <li class="page-item"><a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage+3%>"><%=currentpage+3%></a></li>
          <li class="page-item"><a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage+4%>"><%=currentpage+4%></a></li>
      <%}}else{ %>
       <li class="page-item disabled"><a class="page-link">END</a></li>
       <% } if(currentpage==noofpages){ %>      
        <li class="page-item disabled">
          <a class="page-link" href="#"><i class="fa fa-angle-double-right" aria-hidden="true" style=" min-height: 17px;"></i></a>
        </li>
         <%}else{ %>
         <li class="page-item">
          <a class="page-link" href="./SearchNewVehicle?vehicleBrand=<%=vBrand%>&vehicleModel=<%=vModel%>&vvariant=<%=vvariant%>&vType=<%=vType%>&makeYear=<%=makeyear%>&bodyType=<%=bodyType%>&fuelType=<%=fuelType%>&transmission=<%=transmission %>&color=<%=color%>&budget=<%=budget%>&spage=result&page=<%=currentpage+1%>"><i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
        </li>
         <%} %>
        
      </ul>
</nav>
		         </div>
		         <div class="col-md-1"></div>
		      </div>
				</div>
				</div>
			</div>
		</section>
		     
					    
		<br>
		<br>
	</div>

	<!-- blog section -->

	<!-- Newsletter -->
	<section class="get-offer">
		<div class="container">
			<div class="row">
			<div class="col-sm-4"></div>
				<div class="col-sm-5" style="text-align: center;">
					<span>Subscribe to our Newsletter</span>
					<h2>& Discover the best offers!</h2>
				</div>
				<div class="col-sm-4">
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

<!-- 
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script> -->
        <script src="assets/js/st-demo.js"></script>
        <script src="assets/js/jquery.scrolling-tabs.js"></script>
        
</body>
</html>