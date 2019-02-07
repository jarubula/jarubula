<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
    System.out.println(session.getAttribute("user"));
    
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./carsandBikes.jsp" />
<jsp:include page="./topMenu.jsp" />
<script src="./css/countries.js" type="text/javascript"></script>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/statecity.js"></script>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">

<script>
     var counter = 1;
     var limit = 6;
     function addInput(divName){
    	  
     
          if (counter == limit)  {
               alert("You have reached the limit of adding " + counter + " inputs");
          }
          
          else {
        	  
        	  var newdiv = document.createElement('div');
        	  newdiv.innerHTML = '<div class="col-md-12" style="padding: 0 0;"><div class="col-md-4"><input type="text" class="form-control input-sm" id="itemType" name="itemType" placeholder="EXTRA FITTINGS"></div><div class="col-md-4"><input type="text" class="form-control input-sm" id="price" name="price" placeholder="Enter Price"></div><div class="col-md-4"></div>';
              
              document.getElementById(divName).appendChild(newdiv);
              counter++;
          }
     }
          
     </script>
     
<style>
#item{
  background: #fff;
  box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);
  padding: 0 0; 
  border-bottom: 3px solid #a3b745;
  border-radius: 5px;"
  }
  .item1{
  padding: 0 0; 
  }
  label {
    font-weight: 500;
    display: inline-block;
    margin-bottom: 0px;
    font-size: 17px;
    color: #523f6d;
}
.form-control {
    display: block;
    width: 100%;
   height: 32px !important;
    font-size: 1rem;
    line-height: 1.3;
    color: #55595c;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: .25rem;
     padding: 0 6px;
    font-family: sans-serif;
    font-style: italic;
        font-size: 14px;
}
.item12{
  padding: 0 0; 
  }
@media  (max-width:767px){
 .item12{
    padding: 0px 33px;
  }
  .form-group {
    margin-bottom: 0.2rem;
}
  }

</style>
<script>
function myFunction() {
    var txt;
    if (confirm("Press a button!")) {
        txt = "your registration is successful OK!";
    } else {
        txt = "You pressed Cancel!";
    }
    document.getElementById("demo").innerHTML = txt;
}
</script>
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			
			<article class="content responsive-tables-page" style="background-color:#fff">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div align="center" style="font-size: 25px">USED VEHICLE DEALER DASHBOARD</div>
			</div>
			<section class="section">
			<div class="row">ADD NEW CAR PRICE
			<div class="col-md-12 col-sm-12 col-xs-12" id="item">
							
		<!----------------------- item section ------------------->
							
			<p></p>	     
      <div class="col-md-12 col-sm-12" style="padding-left: 0px;">
      <form action="./AddNewCarPrice" class="form-horizontal" role="form">
      <p id="demo" style="margin: 0 20px;color: #ff4444; font-size: 19px;">
      <%if(request.getAttribute("message")==null){}else{out.println(request.getAttribute("message"));} %>
      </p>
      <div class="col-md-12 item1">
	        <div class="form-group col-md-3 col-sm-6">
            <label>Brand :</label>
            <jsp:include page="./getDealerAuthorisedNewCarBrand.jsp" />
            </div>
           
           <div class="form-group col-md-3 col-sm-6">
           <label>Model :	</label>
           		<div id="txtHint1">
					<select name="carModel" class="form-control form-control-sm" required>
						<option value="">SELECT MODEL</option>
					</select>
				</div>
            </div>
            
            <div class="form-group col-md-3 col-sm-6">
           <label>Variant :	</label>
           		<div id="txtHintR">
					<select name="carModel" class="form-control form-control-sm" required>
						<option value="">SELECT VARIANT</option>
					</select>
				</div>
            </div>
            
             <div class="form-group col-md-3 col-sm-6">
            	<label>Make Year :	</label> 
            		<select name="makeYear" class="form-control">
						<option>Select Make Year</option>
						<option>2018</option>
						<option>2017</option>
						<option>2016</option>
					</select>
			</div>
            
        </div>    
           
         
          <div class="col-md-12 item1" id="dynamicInput"> 

            <div class="form-group col-md-4 col-sm-6">
            <label>Item Type :</label>
            <input type="text" class="form-control input-sm" id="itemType" name="itemType" placeholder="EXTRA FITTINGS">
            </div>
            
            <div class="form-group col-md-4 col-sm-6">
            <label>Price :</label>
            <input type="text" class="form-control input-sm" id="price" name="price" placeholder="Enter Price">
            </div>
            
            <div class="form-group col-md-2 col-sm-6 item12">
            <label style="color:#fff;">Price :</label>
            <button type="button" id="more_fields" onclick="addInput('dynamicInput');" class="btn btn-primary btn-block" style="line-height:18px;">Add Another</button>
            </div>
            <div class="form-group col-md-2 col-sm-6"></div>
        </div> 
       
       
       <div class="col-md-12"><p></p></div>
        <div class="col-md-12 item1">    
        <div class="form-group col-md-5 col-sm-6"></div>
        <div class="form-group col-md-2 col-sm-6"> 
        <input type="submit" class="btn btn-primary btn-block" value="SUBMIT" style="line-height: 22px; border: #fff;"></div>
        <div class="form-group col-md-5 col-sm-6"></div>
          
        </div>
         
			</form>	
				
	</div>		
							
							
		<!----------------------- end item section----------------->		 
								
							
										   
										</div>
									</div>
								
							</div>
							</section>
						</div>
					</div>
					
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
<script>
	function showModel(str) {
		if (str == "") {
			document.getElementById("txtHint1").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint1").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getNewCarModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>

<script>
 function getVariantName(str) {
  var brandid = document.getElementById("brandid").value;
  if (str == "") {
   document.getElementById("txtHintR").innerHTML = "";
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
    document.getElementById("txtHintR").innerHTML = xmlhttp.responseText;
   }
  }
  xmlhttp.open("GET", "./getNewCarVariantName.jsp?model="+str+ "&brand="+ brandid, true);
  xmlhttp.send();
 }
</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>