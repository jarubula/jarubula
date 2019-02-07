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
        <title>Vaahanmitra | Search Driver</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
		<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
		
 <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

  
   <script>
  
  $(function(){
    
    $('#datepicker').datepicker({
        dateFormat: 'dd-mm-yy',
        altField: '#thealtdate',
        altFormat: 'yy-mm-dd',
        minDate: 0
    });
    
});

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

<script type="text/javascript">
function validateForm()
{
if( document.getElementById("state").value == "SELECT" )
   {
     alert( "Please select State!" );
     document.getElementById("state").focus();
     return false;
   }
return true;
}
</script>

	<script
  src="https://code.jquery.com/jquery-2.1.3.js"
  integrity="sha256-goy7ystDD5xbXSf+kwL4eV6zOPJCEBD1FBiCElIm+U8="
  crossorigin="anonymous"></script>
<script type="text/javascript">

$(document).ready(function () {

    var hideOptions = function () {
        var $select = $('select');
        $select.find('option').show();
        $select.each(function () {
            var $this = $(this);
            var value = $this.val();
            var $options = $this.parents('div').find('select').not(this).find('option');
            var $option = $options.filter('[value="' + value + '"]');
            if (value) {
                $option.hide();
                $option.each(function () {
                    if (this.defaultSelected) {
                        $(this).parent('select').val('');
                    }
                });
            }
        });
    }

    hideOptions();

    $('select').on('change', function () {
        hideOptions();
    });
});

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
.w3-animate-zoom {
    animation: animatezoom 0.6s;
    border-radius: 6px;
}
.w3-padding-16 {
    padding-top: 6px!important;
    padding-bottom: 6px!important;
    border-bottom-left-radius: 6px;
    border-bottom-right-radius: 6px;
        margin-top: 16px;
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<style type="text/css">
#overlay {
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
/* background-color: #000; */
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
min-width: 600px;
width: 600px;
min-height: 150px;
margin: 100px auto;
background: #ddd;
position: relative;
z-index: 103;
padding: 70px;
border-radius: 5px;
box-shadow: 0 2px 5px #000;
}
.cnt223 p{
clear: both;
color: #f94141;
text-align: justify;
}
.w3-xlarge {
    font-size: 17px!important;
}
.cnt223 p a{
color: #d91900;
font-weight: bold;
}
.cnt223 .x{
float: right;
height: 35px;
left: 22px;
position: relative;
top: -25px;
width: 34px;
}
.cnt223 .x:hover{
cursor: pointer;
}
</style>

<script type='text/javascript'>
$(function(){
// var overlay = $('<div id="overlay"></div>');
// overlay.show();
// overlay.appendTo(document.body);
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
	
	
	        <style>
	        /* .content {
    padding: 0px !important;
      } */
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
#one1{
    min-height: 249px;
    background: #fff;
    border-radius: 4px;
    margin: 1px 0px;
    margin-bottom: 23px;
    }
input[type=checkbox]:checked {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"><path id="checkbox-3-icon" fill="#000" d="M81,81v350h350V81H81z M227.383,345.013l-81.476-81.498l34.69-34.697l46.783,46.794l108.007-108.005 l34.706,34.684L227.383,345.013z"/></svg>');
}
input[type=checkbox]:not(:checked) {
    background-image: url('data:image/svg+xml;utf8,<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"> <path id="checkbox-9-icon" d="M391,121v270H121V121H391z M431,81H81v350h350V81z"></path> </svg>');
}
label{
    font-size: 17px;
    font-family: sans-serif;
    font-weight: normal;
    color: #807d7d;
    margin: 0 4px;
        line-height: 0px;
    }
    .top {
    margin-top: 0px !important;
}
figure {
    margin: 0em 42px;
    margin-bottom: 8px;
}
#car6{
border-radius: 6px;
    margin-top: 8px;
    background: #fff none repeat scroll 0 0;
    border: 1px solid #ddd;
    }
    #car6:hover {
    border-radius: 6px;
    margin-top: 8px;
    background: #fff none repeat scroll 0 0;
    border: 1px solid #ddd;
    box-shadow: 0px 0px 11px rgb(70, 122, 161);
}
.text-danger{
    color: #ff3333;
    font-size: 19px;
    margin: 0px 3px;
    }
    #two{
    padding: 3px 21px;
    float: right;
    margin-bottom: 0px;
    position: relative;
    color: #000;
    z-index: 1;
    background-color: #fec107 !important;
    font-size: 18px;
    font-family: sans-serif;
    font-weight: 300;
    border: 1px solid #fec107;
    border-radius: 3px;
    }
    #box h3{
       margin-top: 0px;
    font-size: 24px;
    font-weight: normal;
    color: #555;
    text-decoration: underline;
    }
    .car1{
    box-sizing: inherit;
    font-size: 16px;
    color: red;
    }
    #car2{
        margin-bottom: 6px;
    color: white;
    width: 130px;
    border: 1px solid #337ab7;
    border-radius: 4px;
    line-height: 30px;
    font-size:18px;
    font-weight: normal;
    font-family: monospace;
    
    }
    .car3{
      color: #555;
    font-weight: 600;
    }
    .car5{
        color: #337ab7;
    padding: 0 0;
    font-size: 18px;
    font-weight: normal;
    }
    .car4{
    text-transform: lowercase;
    font-size: 16px;
    color: #514d4d;
    }
  </style>

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
var n=window.open("./displayDriver.jsp?driverId="+value1,"myWin", "left=700, top=200, width=500, height=700");
 }else if(value1.length<2){
	
	/*  alert("please select maximum 3 checkboxes to compare your selection.."); */
	 document.getElementById("msg").innerHTML = "please select maximum 3 Drivers";
	  
 }else if(value1.length>4){
	 
// 	 alert("you can not select more than  3 checkboxes to compare your selection..");
	 document.getElementById("msg").innerHTML = "you can not select more than  3 Drivers";
	  
	  
 }
 return value1;

 }

</script>


<script type="text/javascript">

/* var checkoutHistory = document.getElementById('option1');
checkoutHistory.onchange = function() {
    console.log(checkoutHistory);
    if (checkoutHistory.checked) {
        alert("please click on GetQuotes button to send request to multiple driver...");
    } else {
       
    }
} */

function cTrig(clickedid) { 
    if (document.getElementById(clickedid).checked == true) {
     var box= confirm("please click on GetQuotes button to send request to multiple driver...");
      
    } else {

       return false;   
    }
  }

</script>

    </head>
    <body>
    <%String message=(String)request.getAttribute("message"); %>
        <%if(message!=null){ %>
   <div class='popup'>
<div class='cnt223'>
<img src='images/cancel.png' alt='quit' class='x' id='x' />
<p>
<%=message%>
<br/>
<br/>
<a href='#' class='close'>OK</a>
</p>
</div>
</div>
<%}else{} %>
    
        <!-- page loader -->
        
        
        
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
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
          <jsp:include page="./homeTop.jsp"></jsp:include>
            <!-- /.nav end -->
          
            <!-- service -->
            <section class="service-inner" >
                <div class="container">
                 					<%
                 					String verifiedEmail=(String)session.getAttribute("user"); 
                                    GetDriverDetails gdd=new GetDriverDetails();
                                    Set<String> location=gdd.getOnDemandDriverLocation();
                                	String fromCity=(String)request.getAttribute("fromCity");
                       		 		String toCity=(String)request.getAttribute("toCity");
                       		 		String date=(String)request.getAttribute("date");
                       		 		String time=(String)request.getAttribute("time");
                       		 		
                                    if(location!=null){
                                    location.remove("Any City");
                                    }
                                    
                                     Iterator locationIt=location.iterator();
                                     Iterator locationIt1=location.iterator();
                                    %>
              <form action="./SearchHOnDemandDriver" method="post" onsubmit="return validateForm()">
   				 <div class="row top" >
   				 <div class="col-md-10">
   				<div class="col-md-3 col-sm-6 col-xsm-10">
   					<div class="form-group">
   				<label for="lastname">From :</label>
				 <select id="fromCity" name="fromCity" class="form-control" class="preferenceSelect">
                  <option value="" style="display:none;"><%=fromCity==null?"From":fromCity.equals("")?"From":fromCity %></option>
                   <%
                    while(locationIt.hasNext()){ 
                    String fromcity=(String)locationIt.next();
                     %>
                    <option value="<%=fromcity %>"><%=fromcity %></option>
                     <%} %>
                    </select>
				</div>
   				</div>
   				
   				<div class="col-md-3 col-sm-6 col-xsm-10">
   				 <div class="form-group">
   				<label for="lastname">To :</label>
                <div class="section_room">
               
				  <select id="toCity" name="toCity" class="form-control" class="preferenceSelect">
					<option value="" style="display:none;"><%=toCity==null?"To":toCity.equals("")?"To":toCity %></option>
					<option value="AnyCity" style="display:none;">Any City</option>
					<%
                     while(locationIt1.hasNext()){ 
                    String fromcity1=(String)locationIt1.next();
                     %>
                     <option value="<%=fromcity1 %>"><%=fromcity1.equals("Any City")?"":fromcity1 %></option>
                     <%} %>
					</select>
				</div>
				</div>
                </div>
                
               <div class="col-md-3 col-sm-6 col-xsm-10">
               <div class="form-group">
   				<label for="lastname">Date :</label> 
               <input type="text" name="date" placeholder="<%=date==null?"DD/MM/YYYY":date.equals("")?"DD/MM/YYYY":date %>" id="datepicker" class="form-control" height="100%"/>
				</div>
                </div>
                
              <div class="col-md-3 col-sm-6 col-xsm-10">
               <div class="form-group">
   				<label for="lastname">Time :</label>
               <input type="time" name="time" placeholder="Time" class="form-control" height="100%"/>
				</div>
                </div>
                </div>
                
                 <div class="col-md-2">
                <div class="col-md-12 col-sm-12 col-xsm-12">
                <div class="form-group">
   				<label for="lastname" style="color:#f1f2f3;">From </label>
   				    <button type="submit" class="btn btn-primary btn-block">Search</button>
   				</div>
            
                </div>
                </div>
                </div>
                 </form>
                    
                    		<%
							ArrayList driverAl=(ArrayList)request.getAttribute("driverAl"); 
               		 	
							if(driverAl!=null && driverAl.size()>0){
							Iterator it1=driverAl.iterator();
							%>
							<div class="col-md-6">
							<h5 class="text-danger">On Demand Driver Details</h5>
							
							</div>
                     <div align="right" class="col-md-4 col-sm-12 col-xs-12" id="hiddenArea">
                     
                    <button type="button" id="two" class="thm-bt" onclick="alert(getCheckedCheckboxesFor('compare'));">
                      
                     Get Quotes</button></div>
                     
                     <div class="col-md-8"></div>
							
							<%
							int i=1;
							while(it1.hasNext()){
								DriverBean bean1=(DriverBean)it1.next();
								OnDemandDriverRoutes prtSal=(OnDemandDriverRoutes)it1.next();
								
								String status=gdd.getDriverStatus(bean1.getEMAIL());

							%>
					
					<section class="container">

		  	<aside class="col-md-10" id="car6">
		  	<br>
	        <div class="col-md-6" id="box">
				<h3><%=bean1.getFIRST_NAME()+"  "+bean1.getLAST_NAME() %>  /  id:  <%=bean1.getDRIVER_ID() %></h3>
	        
			</div>
			 <div  class="col-md-5" style="color: brown;margin-top: 5px; " align="right" >
   <em class="car1"> send request to multiple driver</em>
   
   </div>
   <div class="col-md-1" align="right"  >
      <input type="checkbox" name="compare" value="<%=bean1.getDRIVER_ID() %>" id="option<%=i %>" class="number" onchange="cTrig('option<%=i %>')">
     
</div>
   <div class="col-md-12" align="right">
   <span id="msg" style="color:red;float:center;position: relative;font-size: 12px;"></span>
   </div>

	  	 <aside class="col-md-7">
	  	
		 <div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6">
		 	<span class="car3">State :</span>

		 </div>	
		 <div class="col-md-7 col-sm-6 col-xs-6">
		 	<span class="car4"><%=bean1.getSTATE() %></span>
		 	
		 </div>	
         

		</div>
		<div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6" class="car3">
		 	<span class="car3">Driving Experience:</span>

		 </div>	
		 <div class="col-md-7 col-sm-6 col-xs-6" class="car3">
		 	
		 	<span class="car4"><%=bean1.getDRIVING_EXP() %>&nbsp;&nbsp;years</span>
		 </div>	
         

		</div>
		<div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6" class="car3">
		 	<span class="car3">Permit Type:</span>

		 </div>	
		 <div class="col-md-7 col-sm-6 col-xs-6" class="car3">
		 	<span class="car4"><%=bean1.getPERMIT_TYPE() %></span>
		 	
		 </div>	
         

		</div>
		
		<div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6" class="car3">
		 	<span class="car3">From Location:</span>

		 </div>	
		 <div class="col-md-7 col-sm-6 col-xs-6" class="car3">
		 	<span class="car4"><%=prtSal.getFROM_CITY()==null?"N/A":prtSal.getFROM_CITY()%></span>
		 	
		 </div>	
         

		</div>
		
		<div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6" class="car3">
		 	<span class="car3">To Location:</span>

		 </div>	
		 <div class="col-md-7 col-sm-6 col-xs-6" class="car3">
		 	<span class="car4"><%=prtSal.getTO_CITY()==null?"N/A":prtSal.getTO_CITY() %></span>
		 	
		 </div>	
         

		</div>
		
		<div class="row">
		 <div class="col-md-5 col-sm-6 col-xs-6">
		 	<span class="car3">Availability Date :</span>

		 </div>
		 <div class="col-md-7 col-sm-6 col-xs-6" class="car3">
		 	<span class="car4"><%=prtSal.getDATE()==null?"N/A":prtSal.getDATE()%></span>
		 </div>	
         </div>
         </aside>
         
         <aside class="col-md-3 col-xs-12 col-sm-12" style="float: right;">
	<div class="row">

		<figure >

				
<!-- 				<img src="data:image/png;base64,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" alt="No image" width="100%" height="150px"> -->
				
<!--              	<img width="100%" height="200px" src="http://globalcomment.com/wp-content/uploads/2009/12/avatarstill1.jpg">  -->
			<%if(!bean1.getPHOTO().equals("")){%>	
				<img src="data:image/png;base64,<%=bean1.getPHOTO() %>" alt="No image" width="100%" height="150px">
				<%}else{ %>
				<img src="./images/driverImage.gif" alt="No image" width="100%" height="150px">		
             	<%} %>
             	
             		 <%
                        String suser=bean1.getEMAIL();
                        float rate=gdd.getDriverRate(suser);
                        %>	 
             	 <figcaption>Rating:<span class="stars"><%=rate %><span style="width: 16px;"></span></span></figcaption>
         
		</figure>
		</div>
         <div class="row" align="center">
          
         </div>

         </aside>   
         <aside class="col-md-12">
         <div class="col-md-8" style="padding:0 0px;">
         <!-- <div class="col-md-5"> -->
				<a id="toggle" href="javascript:toggle_it('<%="toggleText"+i %>')" class="car5"> <u style="color: #337ab7;">More Details</u></a>
               <section id="<%="toggleText"+i %>" style="display: none">
               
               <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car3">License Type :</span>
		 </div>	
		 
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car4"><%=bean1.getLICENSE_TYPE() %></span>
		 </div>	
		 
		</div>
               
                    <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car3">License No:</span>
		 </div>
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car4"><%=bean1.getLICENSE_NO() %></span>
		 </div>
		 	
		</div>
		
		
		  <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12" class="car3">
		 	<span class="car3">Expected Charges:</span>
		 </div>
		 <div class="col-md-6 col-sm-6 col-xs-12" class="car3">
		 	<span class="car4"><i class="fa fa-inr" aria-hidden="true"></i>&nbsp;<%=prtSal.getEXPECTED_CHARGES()==null?"Nill":prtSal.getEXPECTED_CHARGES() %></span>
		 </div>
		</div>
		
		       <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12" >
		 	<span class="car3">Waiting Charges:</span>
		 </div>	
		 <div class="col-md-6 col-sm-6 col-xs-12" >
          <span class="car4"><i class="fa fa-inr" aria-hidden="true"></i>&nbsp;<%=prtSal.getWAITING_CHARGES()==null?"Nill":prtSal.getWAITING_CHARGES() %></span>
		 </div>	
		</div>
		
		      <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car3">Driver Email:</span>
		 </div>	
		 <div class="col-md-6 col-sm-6 col-xs-12">
           <span class="car4"><%=bean1.getEMAIL() %></span>
		 </div>
	      </div>
		
               
         <div class="row">
		 <div class="col-md-6 col-sm-6 col-xs-12">
		 	<span class="car3">Driver Contact:</span>
		 </div>	
		 <div class="col-md-6 col-sm-6 col-xs-12">
            <span class="car4"><%=bean1.getMOBILE_NO() %></span>
		 </div>	
		</div>   
               </section>
			</div>
         
        
         <div class="w3-container col-md-2">
 <button onclick="document.getElementById('id<%=i %>').style.display='block'" class="btn-primary w3-large" id="car2">Rate</button>

  <div id="id<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id<%=i %>').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertDriverRating" method="post">
      <input type="hidden" name="driverId" value="<%=bean1.getDRIVER_ID() %>"/>
      <input type="hidden" name="driverMail" value="<%=bean1.getEMAIL()%>"/>
      <input type="hidden" name="fromCity" value="<%=fromCity%>"/>
      <input type="hidden" name="toCity" value="<%=toCity%>"/>
      <input type="hidden" name="date" value="<%=date%>"/>
      <input type="hidden" name="time" value="<%=time%>"/>
     
     <span style="font-size: 20px; font-family: sans-serif;  font-weight: 500; color: #f44336; margin: 0 10px;"> <%=bean1.getDRIVER_ID() %></span>
        <div class="w3-section">
        <div class="form-group">
        <label>Rating :</label>
          <select  class="form-control" placeholder="Rate" name="rate" required>
          <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
          </select>
          <%if(verifiedEmail!=null){} else{%>
          </div>
          
          <div class="form-group">
          <label>Email :</label>
          <input  class="form-control" type="email" placeholder="Email" name="email" required>
          </div>
          
          <div class="form-group">
          <label>Password :</label>
          <input  class="form-control" type="password" placeholder="Password" name="psw" required>
          <%} %>
          </div>
          
          <div class="form-group">
          <label>Appointment Id :</label>
          <input  class="form-control" type="text" placeholder="Appointment Id" name="apptId" required>
          </div>
          
        </div>
        <div class="col-md-12">
         <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id<%=i %>').style.display='none'" type="button" class="w3-button w3-red" style="border: 1px solid #fff;border-radius: 6px;  line-height: 19px;">Cancel</button>
      </div>
    </div>
  </div>
</div>	

 <div class="w3-container col-md-2">
 <button onclick="document.getElementById('id0<%=i %>').style.display='block'" class="btn-primary" id="car2" style=" width: 155px;">Contact Driver</button>

  <div id="id0<%=i %>" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:400px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id0<%=i %>').style.display='none'" class=" w3-button w3-xlarge w3-hover-red w3-display-topright btn-primary" title="Close Modal">&times;</span>
      </div>
      <form class="w3-container" action="./InsertDriverEndUser" method="post">
      <input type="hidden" name="driverId" value="<%=bean1.getDRIVER_ID() %>"/>
      <input type="hidden" name="driverMail" value="<%=bean1.getEMAIL()%>"/>
      <input type="hidden" name="fromCity" value="<%=fromCity%>"/>
      <input type="hidden" name="toCity" value="<%=toCity%>"/>
      <input type="hidden" name="date" value="<%=date%>"/>
      <input type="hidden" name="time" value="<%=time%>"/>
      <input type="hidden" name="expCharges" value="<%=prtSal.getEXPECTED_CHARGES()%>"/>
      <input type="hidden" name="waitingCharges" value="<%=prtSal.getWAITING_CHARGES()%>"/>
      <input type="hidden" name="avlId" value="<%=prtSal.getON_DEMAND_ROUTE_ID()%>"/>
     
    <span style="font-size: 20px; font-family: sans-serif;  font-weight: 500; color: #f44336; margin: 0 10px;"> <%=bean1.getDRIVER_ID() %></span>
        <div class="w3-section">
        <div class="form-group">
          <label>Contact Person :</label>
          <input class="form-control" type="text" placeholder="Enter Username" name="name" required>
          <%if(verifiedEmail!=null){} else{%>
          </div>
          
          <div class="form-group">
          <label>Email :</label>
          <input class="form-control" type="email" placeholder="Email" name="email" required>
          </div>
          
          <div class="form-group">
          <label>Password :</label>
          <input class="form-control" type="password" placeholder="Password" name="psw" required>
          <%} %>
         </div>
         
         <div class="form-group">
           <label>Destination :</label>
																	<select  name="destination" class="form-control input-sm" id="smallinput" required>
																	<option value=" " style="display:none">Destination</option>
															 		 <optgroup label="Top Cities">
														             <option value="New Delhi">New Delhi</option>
														             <option value="Mumbai">Mumbai</option>
														             <option value="Bangalore">Bangalore</option>
														             <option value="Pune">Pune</option>
														             <option value="Chennai">Chennai</option>
														             <option value="Kolkata">Kolkata</option>
														             <option value="Hyderabad">Hyderabad</option>
														             <option value="Ahmedabad">Ahmedabad</option>
														             <option value="Chandigarh">Chandigarh</option>
														             <option value="Gurgaon">Gurgaon</option>
														             <option value="Noida">Noida</option>
														             <option value="Navi Mumbai">Navi Mumbai</option>
														             <option value="Thane">Thane</option>
														             <option value="Cochin">Cochin</option>
														             <option value="Faridabad">Faridabad</option>
														             <option value="Ghaziabad">Ghaziabad</option>
														            </optgroup>
														            <optgroup label="All Other Cities">
														             <option value="Agra">Agra</option>
														             <option value="Ahmednagar">Ahmednagar</option>
														             <option value="Ajmer">Ajmer</option>
														             <option value="Akola">Akola</option>
														             <option value="Alappuzha">Alappuzha</option>
														             <option value="Aligarh">Aligarh</option>
														             <option value="Allahabad">Allahabad</option>
														             <option value="Alwar">Alwar</option>
														             <option value="Amalapuram">Amalapuram</option>
														             <option value="Ambala">Ambala</option>
														             <option value="Amravati">Amravati</option>
														             <option value="Amritsar">Amritsar</option>
														             <option value="Anand">Anand</option>
														             <option value="Anantapur">Anantapur</option>
														             <option value="Aurangabad">Aurangabad</option>
														             <option value="Bareilly">Bareilly</option>
														             <option value="Bathinda">Bathinda</option>
														             <option value="Beed">Beed</option>
														             <option value="Belgaum">Belgaum</option>
														             <option value="Bellary">Bellary</option>
														             <option value="Bharuch">Bharuch</option>
														             <option value="Bhavnagar">Bhavnagar</option>
														             <option value="Bhilai">Bhilai</option>
														             <option value="Bhilwara">Bhilwara</option>
														             <option value="Bhimavaram">Bhimavaram</option>
														             <option value="Bhopal">Bhopal</option>
														             <option value="Bhubaneswar">Bhubaneswar</option>
														             <option value="Bhuj">Bhuj</option>
														             <option value="Bikaner">Bikaner</option>
														             <option value="Bilaspur">Bilaspur</option>
														             <option value="Bulandshahar">Bulandshahar</option>
														             <option value="Chidambaram">Chidambaram</option>
														             <option value="Chittoor">Chittoor</option>
														             <option value="Coimbatore">Coimbatore</option>
														             <option value="Cuddalore">Cuddalore</option>
														             <option value="Davangere">Davangere</option>
														             <option value="Dehradun">Dehradun</option>
														             <option value="Dhanbad">Dhanbad</option>
														             <option value="Dharwad">Dharwad</option>
														             <option value="Dibrugarh">Dibrugarh</option>
														             <option value="Dindigul">Dindigul</option>
														              <option value="Durg">Durg</option>
														             <option value="Durgapur">Durgapur</option>
														             <option value="Eluru">Eluru</option>
														             <option value="Erode">Erode</option>
														             <option value="Firozabad">Firozabad</option>
														             <option value="Gandhidham">Gandhidham</option>
														             <option value="Gandhinagar">Gandhinagar</option>
														             <option value="Goa">Goa</option>
														             <option value="Gorakhpur">Gorakhpur</option>
														             <option value="Gulbarga">Gulbarga</option>
														             <option value="Guntur">Guntur</option>
														             <option value="Gurdaspur">Gurdaspur</option>
														             <option value="Guwahati">Guwahati</option>
														             <option value="Gwalior">Gwalior</option>
														             <option value="Haldwani">Haldwani</option>
														             <option value="Hapur">Hapur</option>
														             <option value="Himmatnagar">Himmatnagar</option>
														             <option value="Hissar">Hissar</option>
														             <option value="Hoshiarpur">Hoshiarpur</option>
														             <option value="Hospet">Hospet</option>
														             <option value="Hosur">Hosur</option>
														             <option value="Howrah">Howrah</option>
														             <option value="Hubli">Hubli</option>
														             <option value="Idukki">Idukki</option>
														             <option value="Indore">Indore</option>
														             <option value="Jabalpur">Jabalpur</option>
														             <option value="Jagdalpur">Jagdalpur</option>
														             <option value="Jaipur">Jaipur</option>
														             <option value="Jalandhar">Jalandhar</option>
														             <option value="Jalgaon">Jalgaon</option>
														             <option value="Jammu">Jammu</option>
														             <option value="Jamnagar">Jamnagar</option>
														             <option value="Jamshedpur">Jamshedpur</option>
														             <option value="Jodhpur">Jodhpur</option>
														             <option value="Kadapa">Kadapa</option>
														             <option value="Kakinada">Kakinada</option>
														             <option value="Kannur">Kannur</option>
														             <option value="Kanpur">Kanpur</option>
														             <option value="Karimnagar">Karimnagar</option>
														             <option value="Karnal">Karnal</option>
														             <option value="Karur">Karur</option>
														             <option value="Kasaragod">Kasaragod</option>
														             <option value="Khammam">Khammam</option>
														             <option value="Khanna">Khanna</option>
														             <option value="Kolar">Kolar</option>
														             <option value="Kolhapur">Kolhapur</option>
														             <option value="Kollam">Kollam</option>
														             <option value="Kota">Kota</option>
														             <option value="Kottayam">Kottayam</option>
														             <option value="Kozhikode">Kozhikode</option>
														             <option value="Kurnool">Kurnool</option>
														             <option value="Kurukshetra">Kurukshetra</option>
														             <option value="Latur">Latur</option>
														             <option value="Lucknow">Lucknow</option>
														             <option value="Ludhiana">Ludhiana</option>
														             <option value="Madurai">Madurai</option>
														             <option value="Malappuram">Malappuram</option>
														             <option value="Mandi">Mandi</option>
														             <option value="Mangalore">Mangalore</option>
														             <option value="Mathura">Mathura</option>
														             <option value="Meerut">Meerut</option>
														             <option value="Mehsana">Mehsana</option>
														             <option value="Moga">Moga</option>
														             <option value="Mohali">Mohali</option>
														             <option value="Moradabad">Moradabad</option>
														             <option value="Muzaffarnagar">Muzaffarnagar</option>
														             <option value="Mysore">Mysore</option>
														             <option value="Nadia">Nadia</option>
														             <option value="Nagercoil">Nagercoil</option>
														             <option value="Nagpur">Nagpur</option>
														             <option value="Namakkal">Namakkal</option>
														             <option value="Nanded">Nanded</option>
														             <option value="Nashik">Nashik</option>
														             <option value="Nellore">Nellore</option>
														             <option value="Neyveli">Neyveli</option>
														             <option value="Nizamabad">Nizamabad</option>
														             <option value="Ongole">Ongole</option>
														             <option value="Palakkad">Palakkad</option>
														             <option value="Palwal">Palwal</option>
														             <option value="Panchkula">Panchkula</option>
														             <option value="Panipat">Panipat</option>
																	</select>	          
          
          </div>
          
          <div class="form-group">
          <label>Mobile No :</label>
          <input class="form-control" type="text" placeholder="Mobile No" name="mobileNo" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit mobile number" required>
          </div>
          
          <div class="form-group">
          <label>PICKUP DATE :</label>
          <input class="form-control" type="date" placeholder="Date" name="apptDate" required>
          </div>
          
          <div class="form-group">
          <label>PICKUP TIME :</label>
          <input class="form-control" type="time" placeholder="Time" name="apptTime" required>
          </div>
          
          <div class="form-group">
           <label>Pick Up Address :</label>
          <textarea class="form-control" col="2" row="3" name="address" required></textarea>
          </div>
        </div>
        <div class="col-md-12">
         <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>
    </div>
  </div>
</div>
         
         </aside>
           
	  	</aside>
	  	
</section>
					
     
    <%i++; %>
       <%} %>
       
         		<aside class="col-md-10" style="margin-left:14px; border-radius: 15px;margin-top:5px;  background: #fff none repeat scroll 0 0;box-shadow: 0 1px 5px #acacac;">
				<div class="row">             			
					&nbsp;&nbsp;Pages:&nbsp;
                 	<c:forEach begin="1" end="${noOfPages}" var="k">
				
<%-- 				<td style="float: left" ><a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>">${k}&nbsp;&nbsp; </a></td> --%>
			
						<c:set var="currentPage" value="${currentPage}"></c:set>
             			<c:set var="noOfPages" value="${k}"></c:set>
             			
             			<%
             			Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
             			if(currentPage1.equals(noOfPages)){
             			%>
						<a href="./SearchHOnDemandDriver?page=${k}&fromCity=<%=fromCity%>&toCity=<%=toCity%>&date=<%=date%>&time=<%=time%>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
						<%} else{%>
						             			
						<a href="./SearchHOnDemandDriver?page=${k}&fromCity=<%=fromCity%>&toCity=<%=toCity%>&date=<%=date%>&time=<%=time%>">${k}&nbsp;</a> 				
						<%} %>
			
			</c:forEach>
			<%

}else{if(driverAl==null){}else{%> 
 <div class="col-md-12">
 <div class="col-md-12" id="one1">
 <span style="font-weight:600;color:red">Data not found.....</span></div> 
 </div>
<%
}}
%>  </div>
			</div>
    		</aside> 
    		<br><br>&nbsp;
         </section>
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
        
    </body>
</html>