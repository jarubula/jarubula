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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./sparePartsMenu.jsp" />
<%-- <jsp:include page="./right-side.jsp" /> --%>
<jsp:include page="./topMenu.jsp" />
<link rel="stylesheet" href="css/vendor.css">
<script type="text/javascript">

$(document).ready(function(){

    var counter = 2;

    $("#addButton").click(function () {

 if(counter>20){
            alert("Only 20 textboxes allow");
            return false;
 }

 var newTextBoxDiv = $(document.createElement('div'))
      .attr("id", 'TextBoxDiv' + counter);

 newTextBoxDiv.after().html('<label>Specification '+ counter + ' : </label>' +
       '<input type="text" class="form-control" placeholder="Enter Specification '+ counter + '" name="specification"'  + counter +
       '" id="textbox"' + counter + '" value="" >');

 newTextBoxDiv.appendTo("#TextBoxesGroup");


 counter++;
     });

     $("#removeButton").click(function () {
 if(counter==2){
          alert("No more textbox to remove");
          return false;
       }

 counter--;

        $("#TextBoxDiv" + counter).remove();

     });

     $("#getButtonValue").click(function () {

 var msg = '';
 for(i=1; i<counter; i++){
      msg += "\n Textbox #" + i + " : " + $('#textbox' + i).val();
 }
       alert(msg);
     });
  });
</script>


<script>
function NumAndTwoDecimals(event , obj){
	reg = /[^0-9.,]/g;
	obj.value =  obj.value.replace(reg,"");
 }
</script>

<script language="javascript">
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

<script type="text/javascript">
         function checkSpcialChar(event){
            if(!((event.keyCode >= 65) && (event.keyCode <= 90) || (event.keyCode >= 97) && (event.keyCode <= 122) || (event.keyCode >= 48) && (event.keyCode <= 57))){
               event.returnValue = false;
               return;
            }
            event.returnValue = true;
         }
 </script>

<script>
	function RestrictSpace() {
		if (event.keyCode == 32) {
			event.returnValue = false;
			return false;
		}
	}
</script>

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


<script type="text/javascript">

function show1(){
	  document.getElementById('div1').style.display ='none';
	}
	function show2(){
	  document.getElementById('div1').style.display = 'block';
	}

</script>
<style>
 .one{
    font-size: 17px;
    color: #000;
    font-weight: 400;
    font-family: sans-serif;
    }
   .two{
    padding:0 9px;
   } 
   .form-control{
     height:35px !important;
   }
 .boa h5{
    font-size: 21px;
    text-decoration: underline;
    color: #f94141 !important;
    font-family: inherit;
    }
     .cart{
	      padding: 6px 7px;
          border-bottom: 2px solid #fec107;
          border-top: 2px solid #fec107;
	     }
	      .box1 p {
		      font-size: 22px;
		    padding: 0 0;
		    color: #000;
		    margin-top: 0px;
		    font-family: sans-serif;
		    font-weight: 500;
		    margin-bottom: 0rem !important;
		    }
		    .bo2{
    width: 20px;
    height: 20px;
    border: 1px solid #a7a1a1;
    background: #fff;
    border-radius: 2px;
    } 
  
       .bo {
	    font-size:16px;
	    color: #f94141;
	    font-family: sans-serif;
	    font-weight: 500;
	    }
	    .bo1 {
	        font-size: 15px;
		    color: #3f4040;
		    font-family: sans-serif;
		    font-weight: 500;
		    margin: 0px 4px;
		   line-height: 2.3rem;
	     }
	       .cartq{
    border-radius: 3px;
    border: 1px solid #ccc;
    line-height:22px;
    padding: 0 5px;
    width: 100px;
    }  
    .rt{
    padding:0 0px;
    }
     .cart0{
		    float: right;
		    font-size: 19px;
		    color: #000;
		    margin: 7px 0;
		    }
</style>
</head>
<body>
<%
		String message = (String) request.getAttribute("success");
	%>

	<div class="main-wrapper">
		<div class="app" id="app">

		<header class="" style="font-family: 'Oswald', sans-serif;">
			
	    <div class="header-block header-block-nav">
				
			</div>
			</header>
			
			<article class="content responsive-tables-page" style="background-color:#fff"> 
				<section class="section">
			<div class="row">
				<!-- <h3 style="">SPARE PARTS DASHBOARD</h3> -->
				<div> <h3 class="col-md-12" align="center">SPARE PARTS DASHBOARD</h3></div>
				<div class="col-md-12" style="padding:0px 0px;">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15);">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well" style="border-radius:4%">
							
                             <!--================ new section ================ -->
                             <div class="col-md-12 rt">
                             <a href="./orderRequest.jsp" style="font-size:21px;
                               color: #59c2e6;  text-decoration: underline; padding: 9px;"><i class="fa fa-arrow-left"></i> Back</a>
                             </div>
                               <div class="col-lg-12 rt">
					           <div class="col-md-12 boa">
					           <h5>Cart Items</h5>
					           </div>
					           </div>
                             
                 <div class="col-md-12 cart">
                <div class="col-lg-12 rt">
                <div class="col-md-10 box1">
                <p>Spare Parts</p> 
                </div>
               <!--  <div class="col-md-2">
                <input type="checkbox" name="vehicle1" value="Bike" style="width:21px; height:21px;"> <span class="cart10"><a href="#">Remove</a></span>  
                 <button type="button" class="close" data-dismiss="alert" aria-label="close" data-dismiss="modal">&times;</button>
                </div> -->
                </div>
                
                <div class="col-lg-12" style="padding: 0 0;">
                <div class="col-md-4 rt">
                <div class="col-md-12 box2">
	            <span class="bo">Name :</span><span class="bo1">Gasket Maker</span>
	            </div>
	            
	            <div class="col-md-12 box2">
	            <span class="bo">SKU :</span><span class="bo1">0987654322 </span>
	            </div>
	            
	            <div class="col-md-12 box2">
                <c:set var="painttype" value="${pd.INTER_EXTER}" scope="request"/>
                <span class="bo">Brand :</span><span class="bo1">Hero</span>
                </div>
               
                </div>
                
               <div class="col-md-4 rt">
              
               <div class="col-md-12 box2">
               <span class="bo">Model :</span><span class="bo1">Duet</span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Mfd. By :</span><span class="bo1">Elofic Elofic </span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Vehicle Type :</span><span class="bo1">2,WHEELER</span>
               </div>
                 
               </div>
               
               <div class="col-md-4 rt">
               <div class="col-md-12 box2">
               <span class="bo">Category :</span><span class="bo1">Spare Parts</span>
               </div>
                
               <div class="col-md-12 box2">
               <span class="bo">Order Quantity :</span>
               <span class="bo1"><input type="text" id="username" name="username" placeholder="" class="cartq"></span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Price :</span><span class="bo1"><i class="fa fa-inr"></i> 250</span>
               </div>
		      
               </div>
               </div>
               </div> 
                
             
                   <div class="col-md-12">
                  <br>
                  <div class="col-md-2"></div>
                   <div class="col-md-3">
                   <select class="form-control" id="sel1">
                    <option> ------ Place Select ------</option>
			        <option>Pending</option>
			        <option>In Process</option>
			        <option>In Transit</option>
			        <option>Delivered</option>
			        </select>
                   
                   </div>
                   <div class="col-md-2">
                   <button type="button" id="mr" class="btn btn-danger">update status</button>
                   </div> 
                
                  <div class="col-md-5">
                  <p class="cart0">Total No of items ordered</p>
                  </div>
                  </div>
               
                             <!--================ end new section ================ -->   
                               
                                
							</div>
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

	    <div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
		<div class="color-primary"></div>
		<div class="color-secondary"></div>
		</div>
	    </div>
	    
	<script>
	var start = 1970;
    var end = new Date().getFullYear();
    var options = "";
    for(var year = end ; year >=start; year--){
    options += "<option>"+ year +"</option>";
    }
    document.getElementById("year1").innerHTML = options;
    </script>

	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
	<script language="javascript">
    populateBrands("brand", "model");
 	</script>
	<pre>
 	</pre>
 	
	<footer>Copyright &copy; vehicletracking.com</footer>
</body>
</html>
