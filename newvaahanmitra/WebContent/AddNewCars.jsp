<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">


	<style>
		label, .control-label {
    font-weight: inherit;
    float: left;
    font-size: 15px;
    font-family: sans-serif;
    line-height: 7px;
    color: #5e6061; 
}
.form-control {
    display: block;
    width: 100%;
    height: 30px;
    /* padding: 6px 12px; */
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
#b1{
    border: 1px solid #fff;
    border-radius: 5px;
    }
    h4{
    font-size:23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    
    }
    .form-control.boxed {
    border-radius: 0;
    box-shadow: none;
    border-radius: 3px;
    line-height: 15px;
    font-size: 13px;
}
.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:300px;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
      width:300px;
     text-align: center;
}
h4 {
    font-size: 23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    text-align: center;
}
@media  (max-width:767px){

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:100%;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
   width:100%;
   text-align: center;
}


}
ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		ul.tabs li{
			background: none;
			color: #222;
			display: inline-block;
			padding: 10px 15px;
			cursor: pointer;
		}

		ul.tabs li.current{
			background: #ededed;
			color: #222;
		}
ul.tabs li.current {
    background: #523f6d;
    color: #222;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
}
ul.tabs li {
 background: #8b9cb1;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
    color: #222;
    display: inline-block;
    cursor: pointer;
}
		.tab-content{
			display: none;
			
			padding: 15px;
		}

		.tab-content.current{
			display: inherit;
		}
		.c-1{
		color:#fff !important;
		}
	</style>	
	<style type="text/css">
		.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
  font-weight: bold;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
  background-color: #1e90ff;
}
	</style>
	<style type="text/css">
		.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
      font-weight: normal;
    height: 30px;
    padding: 4px 6px;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
    background-color: #f1f2f3;
}
.app .content {
    padding: 74px 30px 90px 50px;
    min-height: 100vh;
}
	</style>
	<script>
   
function Validate(oForm) {
	var _validFileExtensions = [".xls", ".xlsx"]; 
	
	if(document.getElementById("file").value == "")
	{
		alert("Please Select a File");
		document.getElementById("file").focus();
		return false;
	}
	
    var arrInputs = oForm.getElementsByTagName("input");
    for (var i = 0; i < arrInputs.length; i++) {
        var oInput = arrInputs[i];
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }
                
                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    return false;
                }
            }
        }
    }
  
    return true;
}
</script>
	
</head>
<body>
	<div class="center-block">
		<div class="main-wrapper">
			<div class="app" id="app">
				
				  <header class="">
			<div class="header-block header-block-nav"></div>
			</header>
			<br>
				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				
				 
				<div class="row">
			
				<h3 style="text-align: center; font-size: 33p">ADD CAR MASTER</h3>
					<div class="col-md-12" style="background: #fff;     border-radius: 5px; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;     padding-left: 0;">
								
					<%if(request.getAttribute("returnstring")!=null){%> <%=request.getAttribute("returnstring")%><%}else{} %>
						<div class="">
							<div class=""><!-- card-block -->
		                               <!---------------- new tabs ----------------->
		     <div class="col-md-12" style="padding-left: 0px; padding-right: 0px;" >
		     	<p></p>
          
				<div style="">
				<form  action="./NewCarsBulkUpload" onsubmit="return Validate(this);" method="post" enctype="multipart/form-data">
                                        <div class="form-group col-lg-12">
                                        Upload New Cars Details
										<!-- <a class="lin" href="./Files/CarDetails1.xlsx" style="font-size: 25px; color: #5074b8; text-decoration: underline;">Sample File Format Download Here</a> -->
									    </div>
									    
									    <div class="form-group col-lg-6">
									    <label> </label>
									      <input type="file" class="form-control"  name="file" id="file"/>
									    </div>
									    
									      <div class="form-group col-lg-3">
										  <label></label>
									      <input type="submit" class="btn btn-primary btn-block" value="UPLOAD FILE"/>
									      </div>
									      
									       <div class="form-group col-lg-2">
										  <label></label>
									      <input type="reset" class="btn btn-danger btn-block" id="RESET"/>

				</form>
				</div>	          </div>
	          <!---------------- end new tabs ----------------->
								<section class="example">
								
								</section>
							</div>
						</div>
					</div>
				</div>
				</section> </article>
				<footer class="footer">
				<div class="footer-block buttons"></div>
				<div class="footer-block author">
					<ul>
						<li>created by <a href="#">Kosuri Soft Pvt Ltd</a>
						</li>
						<li><a href="www.kosurisoft.com">get in touch</a></li>
					</ul>
				</div>
				</footer>
			</div>
		</div>
	</div>
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script language="javascript">
		populateBrands("brand", "model");
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
	xmlhttp.open("GET","./getAdminNewVecleBrand.jsp?carId="+str,true);   
	xmlhttp.send();    
	}
	</script>
	<pre>
 	</pre>
	<footer>Copyright &copy; vehicletracking.com</footer>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$('ul.tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})

	}) 
	</script>
		<script>
	
 var start = 2017;
var end = new Date().getFullYear();
var options = "";

for(var year = start ; year <=end; year++){
  options += "<option value="+year+">"+ year +"</option>";
}
document.getElementById("makeYear").innerHTML = options;
</script>
</body>
</html>