<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>search new bike</title>
<!-- Base Css -->
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/kosuri.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="assets/css/jquery.scrolling-tabs.css">
    <link rel="stylesheet" href="assets/css/st-demo.css">
    
     <script>
       function myFunction() {
	
       var x = document.getElementById("myDIV");

       if (x.style.display === "none") {
       x.style.display = "block";
       } else {
       x.style.display = "none";
      }
      }
     </script>
     
    <!--  <script>
         $(document).ready(function(){
        	$("$hi").hide();
        	$("#to4").click(function(){
        		$("#hi").show();
        	});
        }); 
        </script> -->
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
	
		var ArrNames = str.split("-")
        var Name0= ArrNames[0];
		var Name1 = ArrNames[1];
		var Name2 = ArrNames[2];
		var var_name = ArrNames[3];
	
		if (var_name == "") {
			document.getElementById(var_name).innerHTML = "";
			document.getElementById(Name2).innerHTML = "";

			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		    xmlhttp1 = new  XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			xmlhttp1 = new ActiveXObject("Microsoft.XMLHTTP");
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
		xmlhttp.open("GET", "./getDealersDeatilsByCity.jsp?city="
				+ str, true);
		xmlhttp1.open("GET", "./getExshowroomPriceBycar_id.jsp?ID="
				+ str, true);
		xmlhttp.send();
		xmlhttp1.send();

	}
</script>
<script type="text/javascript">
function CheckNumeric(e) {
	 
    if (window.event) // IE 
    {
        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
            event.returnValue = false;
            return false;

        }
    }
    else { // Fire Fox
        if ((e.which < 48 || e.which > 57) & e.which != 8) {
            e.preventDefault();
            return false;
        }
    }
}

</script>
<!-- <script>
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
	</script> -->

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
.bi1{
    font-size: 17px;
    color: #555;
 }
 .bi2{
    color: #f10;
    font-size: 15px;
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
    font-size: 16px;
    color: inherit;
    background: #fff;
   }
   .panel-default>.panel-heading+.panel-collapse>.panel-body {
    border-top-color: #fff;
}
.one {
   font-weight: 500;
    font-size: 16px;
    color: #000000;
    font-family: monospace;
    line-height: 0px; 
}
.two {
    margin: 0 0px;
    font-weight: 500;
    font-size: 14px;
    color: #332f2f;
    font-family: monospace;
    line-height: 0px;  
}
.bi4{
padding:0 0px;
}
.panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 16px;
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
</style>
</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		<jsp:include page="./homeTop.jsp"></jsp:include>

		<%  
		
			String veType = null;
			String vBrand = (String)request.getAttribute("vBrand");
			String vModel = (String)request.getAttribute("vModel");
			String vType = (String)request.getAttribute("vType");
			String vvariant     = (String)request.getAttribute("vvariant");
			String makeyear     = (String)request.getAttribute("makeyear");
			String spage        = (String)request.getAttribute("spage");
			String bodyType     = (String)request.getAttribute("bodytype");
			String fuelType     = (String)request.getAttribute("fueltype");
	        String transmission = (String)request.getAttribute("transmission");
	        String budget       = (String)request.getAttribute("budget");
	        String color        = (String)request.getAttribute("color");
			String pv_type="2,"; 
			
			
		 	if(vType.equals("2,")){
				veType = "Two Wheeler";
			}else{
			 veType = "Four Wheeler";
			}
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
   			 
    <section class="service-inner">
			<div class="containe">
				<form action="./SearchNewVehicle" method="post">
					<div class="col-md-12">
					<div class="row top">
						<div class="col-md-2" style=" padding: 0 0">
						<div class="col-md-12 col-sm-6 col-xsm-12">
							<label>Vehicle Type :</label>
								<select class="form-control" name="vType" id="vType" onchange="getNewVcleBrand(this.value)" required>
									<option  style="display:none;" value="SELECT"><%=((veType==null?"Vehicle Type":veType.equals("SELECT")?"Vehicle Type":veType))%></option>
									<option value="" style="display: none;">Vehicle Type</option>
									<option value="2,">Two Wheeler</option>
									<option value="4,">Four Wheeler(Light Vehicle)</option>
								</select>
						</div>
						</div>
						
							<div class="col-md-8" style=" padding: 0 0">
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<label>Vehicle Brand :</label>
								<div id="txtHint20">
									<select name="vehicleBrand" class="form-control" required="required">
										<option  style="display:none;" value="SELECT"><%=((vBrand==null?"Vehicle Brand":vBrand.equals("SELECT")?"Vehicle Brand":vBrand))%></option>
										<option value="SELECT" style="display: none;">Vehicle Brand</option>
									</select>
								</div>
						</div>
						<div class="col-md-3 col-sm-6 col-xsm-12">
							<div class="form-group">
									<label for="email">Vehicle Model :</label>
									
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
										<%-- <select name="makeYear" class="form-control">
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
										</select> --%>
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
				<form action="./SearchHSendEnquiries" method="get">	
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
				<form action="./SearchHSendEnquiries" method="get"><!-- ./SearchHSendEnquiries -->		
					<div id="register" class="w3-modal">
					 <input type="hidden" name="vehicleids" id="vehicleids">
					 <input type="hidden" name="usertype" id="usertype" value="new" >
					 <input type="hidden" name="vehicleBrand" id="vehicleBrand" value="<%=vBrand%>" >
					 <input type="hidden" name="vType" id="vType" value="<%=vType%>" >
					 <input type="hidden" name="vehicleModel" id="vehicleModel" value="<%=vModel%>" >
					 <input type="hidden" name="pCity4" id="pCity4">
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
                        <label for="firstname" style="font-size:16px;">City : </label>
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
			
		<!--================== pop up ==================-->
	       	
			</div>
		    <div class="col-md-1 col-sm-6 col-xsm-12">	
		    </div>
			</div>	
			<%-- 	<%
				ArrayList<AddBike> bikeDetails = (ArrayList<AddBike>) request.getAttribute("bikeDetails");
                 // 					int i = 0;
                     int i = 0,j=0;
			  	%> --%>
		<div class="col-lg-12 col-md-12 col-xs-12 side2">	
		
			<!--============================== side search bar ==========================-->
		    <form action="./SearchNewVehicle" method="post">
		    <div class="col-md-3 col-sm-6 col-xsm-12" style="padding-right: -1px;">	
		    <div class="side1">	
		    
		    <h2 class="side3">Advance Search</h2>
		              <input type="hidden" name="spage" value="result">
	                  <input type="hidden" name="vType" value="<%=vType%>">
	                  <input type="hidden" name="vehicleBrand" value="<%=vBrand%>">
	                  <input type="hidden" name="vehicleModel" value="<%=vModel%>">
	                  <input type="hidden" name="vvariant" value="<%=vvariant%>">
	                  <input type="hidden" name="makeYear" value="<%=makeyear%>">
                      <input type="hidden" name="bodyType" value="SELECT">
	                  <input type="hidden" name="transmission" value="SELECT">
	                                     
					   <div class="form-group">
					   <select  class="form-control" name="fuelType" onchange="this.form.submit()">
							<option style="display: none;" value="<%=((fuelType==null || fuelType.equals("null") || fuelType.equals("SELECT")?"SELECT":fuelType)) %>" selected><%=((fuelType==null || fuelType.equals("null") || fuelType.equals("SELECT")?"Fuel Type":fuelType)) %></option>
							 <option value="PETROL">PETROL</option>
                             <option value="DIESEL">DIESEL</option>
                             <option value="CNG">CNG</option>
                             <option value="LPG">LPG</option>
                             <option value="ELECTRIC">ELECTRIC</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					   </div>
		
					    <div class="form-group">
								<jsp:include page="./GetBikeColors.jsp"><jsp:param value="<%=color%>" name="color"/></jsp:include>
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
		<!--===========================  end side search bar =====================-->
		
		
			  <div class="col-md-4">
			  <c:forEach var="bikeal" items="${bikeDetails}">
	  
			   <div class="col-md-12 search1" id="to5">
		       <div class="col-md-12 search3">
			   <span class="search2">${bikeal.BIKE_BRAND} > ${bikeal.BIKE_MODEL} > <a href="bikeDetails.jsp?vid=${bikeal.NEW_BIKE_ID}" target="_blink" id="car8">${bikeal.VARIANT_NAME}</a></span>
			   </div>
				
		       <div class="col-md-11">
			   <span> <a href="#" style="cursor: pointer;">
			   <img src="data:image/png;base64,${bikeal.PHOTO1}"  onclick="myFunction()"  class="img-responsive" id="search1 to4"/></a>
		       </span>
			   </div>
				</div>
				
			   <div class="col-md-12 search1" id="to5"> 
		       <div class="col-md-12 search3">
			   <span class="search2">${bikeal.BIKE_BRAND} > ${bikeal.BIKE_MODEL} > <a href="bikeDetails.jsp?vid=${bikeal.NEW_BIKE_ID}" target="_blink" id="car8">${bikeal.VARIANT_NAME}</a></span>
			   </div>
				
		       <div class="col-md-11">
			   <span> <a href="#" style="cursor: pointer;">
			   <img src="data:image/png;base64,${bikeal.PHOTO1}" onclick="myFunction1()"  class="img-responsive" id="search1 to4"/></a>
		       </span>
			   </div>
				</div> 
				
				
			  
				
			<%--     <div class="col-md-12 search3">
						
				  <ul class="nav nav-tabs" role="tablist">
			      <li role="presentation" class="active"><a href="#engine<%=i%>" role="tab" data-toggle="tab">Engine</a></li>
			      <li role="presentation"><a href="#fuel<%=i%>" role="tab" data-toggle="tab">Fuel</a></li>
			      <li role="presentation"><a href="#brakes<%=i%>" role="tab" data-toggle="tab">Brakes</a></li>
			      <li role="presentation"><a href="#tyres<%=i%>" role="tab" data-toggle="tab">Tyres</a></li>
			      <li role="presentation"><a href="#chassies<%=i%>" role="tab" data-toggle="tab">Chassies</a></li>
			      <li role="presentation"><a href="#dimensions<%=i%>" role="tab" data-toggle="tab">Dimensions</a></li>
			      <li role="presentation"><a href="#electricals<%=i%>" role="tab" data-toggle="tab">Electricals</a></li>
			      <li role="presentation"><a href="#warranty<%=i%>" role="tab" data-toggle="tab">Warranty</a></li>
			      </ul>			
				
              <div class="tab-content">
              <div id="engine<%=i%>" class="tab-pane fade in active">
			  <div class="col-md-6">
			  <p><span class="one">Brand:</span><span class="two"> ${bikeal.BIKE_BRAND}</span></p>
			  </div>
			  <div class="col-md-12">
					<p><span class="one">Engine Type :</span><span class="two"> ${bikeal.ENGINE_TYPE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Displacement(cc) :</span><span class="two"> ${bikeal.DISPLACEMENT_CC}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Max Power  :</span><span class="two"> ${bikeal.MAX_POWER}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Maximum Torque :</span><span class="two"> ${bikeal.MAX_TORQUE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Bore :</span><span class="two"> ${bikeal.BORE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Stroke :</span><span class="two"> ${bikeal.STROKE}</span></p>
					</div>
					
						<div class="col-md-6">
					<p><span class="one">Ignition :</span><span class="two"> ${bikeal.IGNITION}</span></p>
					</div>
						
				    <div class="col-md-6">
					<p><span class="one">Electric Start :</span><span class="two"> ${bikeal.ENGINE_STARTING}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">No Gears :</span><span class="two"> ${bikeal.NO_OF_GEARS}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Mileage :</span><span class="two"> ${bikeal.MILEAGE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Top Speed :</span><span class="two"> ${bikeal.TOP_SPEED}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Color :</span><span class="two"> ${bikeal.COLOR}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Electric Start :</span><span class="two"> ${bikeal.ENGINE_STARTING}</span></p>
					</div>
					
					
             </div>
             <div id="fuel<%=i%>" class="tab-pane fade">
             <div class="col-md-6">
					<p><span class="one">Fuel System :</span><span class="two"> ${bikeal.FUEL_SYSTEM}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Fuel Type :</span><span class="two"> ${bikeal.FUEL_TYPE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Digital Fuel Indicator :</span><span class="two"> ${bikeal.DIGITAL_FUEL_INDICATOR}</span></p>
					</div>
             </div>
             <div id="brakes<%=i%>" class="tab-pane fade">
            
					<div class="col-md-6">
					<p><span class="one">Front Brakes :</span><span class="two"> ${bikeal.FRONT_BRAKE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Rear Brakes :</span><span class="two"> ${bikeal.REAR_BRAKE}</span></p>
					</div>
             </div>
             <div id="tyres<%=i%>" class="tab-pane fade">
             
			      <div class="col-md-6">
					<p><span class="one">Tyre Type :</span><span class="two"> ${bikeal.TYRE_TYPE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Front Tyre Size  :</span><span class="two"> ${bikeal.FRONT_TYRE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Rear Tyre Size :</span><span class="two"> ${bikeal.REAR_TYRE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Wheel Size :</span><span class="two"> ${bikeal.WHEEL_SIZE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Wheel Type :</span><span class="two"> ${bikeal.WHEEL_TYPE}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Wheelbase :</span><span class="two"> ${bikeal.WHEEL_BASE}</span></p>
					</div>
              
             </div>
             
              <div id="chassies<%=i%>" class="tab-pane fade">
            <div class="col-md-6">
					<p><span class="one">Chassis Type :</span><span class="two"> ${bikeal.CHASSIS_TYPE}</span></p>
					</div>
                     <div class="col-md-6">
					<p><span class="one">Front Suspension :</span><span class="two"> ${bikeal.FRONT_SUSPENSION}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Rear Suspension :</span><span class="two"> ${bikeal.REAR_SUSPENSION}</span></p>
					</div>
             </div>
             
              <div id="dimensions" class="tab-pane fade">
             <div class="col-md-6">
					<p><span class="one">Length :</span><span class="two">${bikeal.LENGTH}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Width :</span><span class="two"> ${bikeal.WIDTH}</span></p>
					</div>
					<div class="col-md-6">
					<p><span class="one">Height :</span><span class="two"> ${bikeal.HEIGHT}</span></p>
					</div>
					
		   <div class="col-md-6">
		   <p><span class="one">Ground Clearance :</span><span class="two"> ${bikeal.GROUND_CLEARANCE}</span></p>
		   </div>
           </div>
             
          <div id="electricals<%=i%>" class="tab-pane fade">
          <div class="col-md-6">
		  <p><span class="one">Battery :</span><span class="two"> ${bikeal.BATTERY_CAPACITY}</span></p>
		  </div>
		  <div class="col-md-6">
	      <p><span class="one">Head Lamp :</span><span class="two"> ${bikeal.HEAD_LAMP}</span></p>
		  </div>
		  </div>
             
          <div id="warranty<%=i%>" class="tab-pane fade">
          <div class="col-md-6">
		  <p><span class="one">Standard Warranty (years) :</span><span class="two"> ${bikeal.STANDARD_WARRANTY_YEARS}</span></p>
		  </div>
		  <div class="col-md-6">
		  <p><span class="one">Standard warranty (kms) :</span><span class="two"> ${bikeal.STANDARD_WARRANTY_KMS}</span></p>
		  </div>
          </div>
		  </div>
		  </div> --%>
		  
			    <%-- <c:set var = "brand" value='${bikeal.BIKE_BRAND}'/>
			    <c:set var = "model" value='${bikeal.BIKE_MODEL}'/>
			    <c:set var = "VAR_name" value='${bikeal.SEQUENCE_NO}'/>
			    <c:set var = "bike_id" value='${bikeal.NEW_BIKE_ID}'/>
					</section>
					<%
				     String brand = (String) pageContext.getAttribute("brand");
					 String model = (String) pageContext.getAttribute("model");
					int var_name = (Integer) pageContext.getAttribute("VAR_name");
					String bike_id = (String) pageContext.getAttribute("bike_id");
					 BusinessOwnerService bos = new BusinessOwnerService();
					ArrayList<BusinessOwnerRegister> city = bos.getCity();
					ArrayList<BusinessOwnerRegister> bor1 = bos.getDealers(brand,"Hyderabad",pv_type);
					String exshowroom=new GetNewBikeDetails().getExshowroompricebyplaceandId(bike_id, "Hyderabad"); 
					Iterator it = city.iterator();
					
					%>
					
					<div class="col-md-3" style="margin: 5px 0; padding: 0 0;">
					 <span style="font-size:15px;color: #555;">Ex-Showroom :</span>
					 <span style="font-size: 14px; color: red;"> 
					<i class="fa fa-inr" aria-hidden="true"></i><b id="<%=bike_id%>"><% try{
						 double value=0;String output=""; 
						 if(exshowroom!=""){ value= Integer.parseInt(exshowroom);
						 
						 output=new CurrencyFormate().indianrupee(value);
						 }
						 else{
							 output="NA";
						 }

                   %> <%=exshowroom.equals("")||exshowroom==""||exshowroom==null?"NA":output%></b><%}catch(NumberFormatException n){} %>
                  <input type="checkbox" calss="two1" id="scheckbox" name="scheckbox" value="${caral.SEQUENCE_NO}" onclick="enable_text()" style="width: 18px; height: 18px; float:right;"> 
				
                   </span>
					<div class="form-group" style="padding: 0 0; margin-bottom:6px;"">
                    <label class="col-sm-2 control-label" style="font-size:15px;color: #555;padding: 0 0;">City :</label>
                    <div class="col-sm-9">
                    <select id="preferredCity" name="preferredCity" onchange="gotoPage(this.value)" class="form-control" style="height: 24px; padding: 0px 6px;">                       	<% while(it.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)it.next();
					%>
					<option style="display: none">Hyderabad</option>
					<option value="<%=bor.getB_CITY()%>-<%=brand%>-<%=bike_id%>-<%=var_name%>-<%=pv_type%>"><%=bor.getB_CITY()%></option>
					   <% 
						}
						%>
                      </select>
                      </div>
                      </div> 
						<span> <a href="#" style="cursor: pointer;" onclick="document.getElementById('id2<%=i%>').style.display='block'"><img src="data:image/png;base64,${bikeal.PHOTO1}"  class="img-responsive"
								style="border-radius: 5px; height:auto; width:100%; font-size: 36px; font-family: sans-serif; text-align: center; margin-bottom:6px;" id="search1"/></a>
						</span>
						<div class="col-md-12">
						<div class="col-md-2"></div>
						<div class="col-md-8">
						</div>
				    <div class="col-md-2"></div>
				    </div>
					</div> --%>
				
					<div class="col-md-12" id="one">
					 
					<div class="clearfix"></div>
					    
					<!--==================== show and hide section ====================== -->    
					    
					<%-- <div class="col-md-12" style="padding: 0 0;">
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
                    Show Used Bikes <span class="glyphicon glyphicon-plus" id="bike2"></span></button>
					</div>
					     
					<div class="col-md-1"> </div> 
					<div class="col-md-2"></div>
					    
					<div class="col-md-12 searH">
				    <div id="de<%=j%>" class="collapse">
                    <div2 id="<%=var_name%>">
					<div id="<%=var_name%>">
					<div id="no-more-tables">
					<table  class="col-md-12 table-bordered table-striped table-condensed cf">
                    <thead class="cf">
			        <tr>
			        <th class="numeric">Dealer Name</th>
			        <th class="numeric">Email Id</th>
			        <th class="numeric">Address</th>
			        <th class="numeric">PhoneNo.</th>
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
        	<td data-title="Phone No" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
        	<%String car_id = (String) pageContext.getAttribute("car_id");
        	int price=new BusinessOwnerService().getonRoadPrice(bike_id,bor.getEMAIL_ID());
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
				         <p style="line-height: 8px;"><span class="sear1">EXSHOWROOM PRICE :</span> <p align="right"><span  class="sear2"><%=exshowroom==""?"NA":exshowroom%>  </span></p></p>
				         <%  HashMap<String,String> chm=new HashMap<String,String>();
				         chm=new GetNewCarDetails().getItemandPricebydealer_id(bike_id, bor.getEMAIL_ID());
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
				        <td data-title="Details" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
				        <input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
				        	
				        </td>
				        </tr>
						<%
						}
					    %>
				       </tbody>
				       </table></div></div></div2>
                       </div>
					   </div>
					      
					      <div class="col-md-12">
					      <div id="dea<%=j%>" class="collapse">
                          Comeing soon dem1.......................
                          </div>
					      </div>
					      
					      <div class="col-md-12">
					      <div id="deb<%=j%>" class="collapse">
                          Comeing soon dem2.......................
                          </div>
					      </div>
					      
					      <div class="col-md-12">
					      <div id="dec<%=j%>" class="collapse">
		                  <p><a href="./SearchHUsedBike?bikeBrand=<%=brand%>&vType=<%=vType %>&bikeModel=<%=model%>&city=SELECT&bikeBudget=SELECT" target="blank" >CLICK HERE TO GET SIMILAR TYPE OF USED BIKE</a></p>
                          </div>
					      </div>
					      </div>
					      
					     <!--==================== end show and hide section ====================== -->  
					      
					      </div>
					
					  <div id="de<%=j%>" class="collapse">
					  <div class="col-md-12 search3" id="a_l">
			          <ul class="nav nav-tabs col-x-1">
			          <li class="active"><a data-toggle="tab" href="#home<%=i%>">City</a></li>
			          <%--  <li><a data-toggle="tab" href="#menu1<%=i%>">Transmission</a></li> --%>
			          </ul>
                      <div class="tab-content">
                      <div id="home<%-- <%=i%> --%>" class="tab-pane fade in active table-responsive">
              
                      </div>        
		              </div>
		              </div>
			         
			 		 
							
						<%-- <div class="col-md-12">
						<div class="col-md-4"></div>
						<div class="col-md-4">
						<div id="id2<%=i%>" class="w3-modal">
						<div class="w3-modal-content1 w3-card-4 w3-animate-zoom" style="border-radius: 5px;">
						<div class="w3-cent">
						<span class="thre1">${bikeal.VARIANT_NAME} IMAGES </span>
					    <span style="font-size: 13px!important; " onclick="document.getElementById('id2<%=i%>').style.display='none'"
						class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal"><span class="glyphicon">&#xe014;</span></span>
						</div>
						<hr>
						<iframe frameBorder="0" class="col-md-12 col-sm-12 col-xs-12" src="NewBikeImageSlider.jsp?vid=${bikeal.NEW_BIKE_ID}"  style="min-height:500px; background: #fff;"></iframe>
						<div class="w3-container w3-border-top w3-padding-16 w3-light-grey" style="border-radius: 5px;">
						<button onclick="document.getElementById('id2<%=i%>').style.display='none'" type="button" class="btn btn-danger">Cancel</button>
						</div>
						</div>
						</div>
						</div>
						<div class="col-md-4"></div>
						</div> --%>
						
					    </div>
				
				<%-- 	  <%i++;j++;%> --%>
				      </c:forEach>
	                   
	                   <!--======================= right side bar ===================== -->
	                   			 <div class="col-md-5 search1" style="padding: 10px 18px; display:none;" id="myDIV">
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
	                   			  
	                  <!--======================== end right side bar =============== -->	
	                   			  
	                   			  
	                   			  <div class="col-md-5 search1"  style="display:none;" id="myDIV1">
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
	                   			     <p>Comeing soon........................</p>
								    
								    
								    </div> 
								    </div>
								    
	                   			  </div>
	                   			  
	                   			  
	                   			 </div>
	                   		
 					 </div>
					 <div class="container">
					 <div class="col-md-3"></div>
					 
            <!--=============== page section =====================-->
            
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
		 
	 <!--=============== end  page section =====================-->
	 
		 <div class="col-md-1"></div>
		 </div>
		</section>
	
		<div class="col-md-1"></div>
		</div>
    
		<br>
		<br>
	    </div>
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
	
	<!-- Footer Section -->
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<!-- jQuery -->
	<!-- <script src="assets/js/jquery.min.js" type="text/javascript"></script> -->
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
        
       <!-- <script>
       var x = document.getElementById("myDIV");
       x.style.display = "none";
       function myFunction() {
	
       var x = document.getElementById("myDIV");

       if (x.style.display === "none") {
       x.style.display = "block";
       } else {
       x.style.display = "none";
      }
      }
       
       function myFunction1() {
       	
     	  var x = document.getElementById("myDIV1");

     	  if (x.style.display === "none") {
     	    x.style.display = "block";
     	  } else {
     	    x.style.display = "none";
     	  }
     	} 
     </script>  -->
   
    <script>
    
       function myFunction() {
	
       var x = document.getElementById("myDIV");

       if (x.style.display === "none") {
       x.style.display = "block";
       } else {
       x.style.display = "none";
      }
      }
       
         function myFunction1() {
          	
      	  var x = document.getElementById("myDIV1");

      	  if (x.style.display === "none") {
      	    x.style.display = "block";
      	  } else {
      	    x.style.display = "none";
      	  }
      	} 
       </script>
</body>
</html>