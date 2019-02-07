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
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well" style="border-radius:4%">
								<form action="./AddSpareParts" method="POST"
									onSubmit="return validate()" enctype="multipart/form-data">
									
									<div class="col-md-12" align="center" style="background-color: #523f6d; color: #fff;">
									<em>ADD SPARE PARTS</em>
									</div>
									<%
													if (message != null) {
												%>
												<h4 style="color: #59c2e6;"><%=message%>
												</h4>
												<%
													} else {
													}
												%>
									<div class="col-md-12"><br></div>
									<div class="col-md-5" align="center">
									<label><input type="radio" name="vehicleType" value="4," checked><b> FOUR WHEELER
									</b></label>				
									</div>
									<div class="col-md-5" align="center">
									<label><input type="radio" name="vehicleType" value="2," onclick="location.href='bikeSpareParts.jsp'"><b>
                                    	TWO WHEELER </b></label>
									</div>
									<div class="col-md-12"></div>
									<div class="col-md-2">
									Car Brand
									
									</div>
									<div class="col-md-4">
									<jsp:include page="./getNewCarBrand.jsp" />
									
									</div>
									<div class="col-md-2">
									Car Model
									
									</div>
									<div class="col-md-4">
									<div id="txtHint1">
									<select name="carModel" class="form-control">
									<option value="">SELECT MODEL</option>
									</select>
                                          </div>
									
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Model Year
									</div>
									<div class="col-md-4">
									<select id="year1" class="form-control" name="year1">
											<option>SELECT YEAR</option>
									</select>
									</div>
									<div class="col-md-2">
									Manufacturer
									</div>
									<div class="col-md-4">
									<input type="text" name="companyName"
													class="form-control" placeholder="Enter Manufacturer Name"
													required></input>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									PartNo
									</div>
									<div class="col-md-4">
									<input type="text" name="partNo" required
													class="form-control" placeholder="Enter Part No.">
									</div>
									<div class="col-md-2">
									SKU
									</div>
									<div class="col-md-4">
									<input type="text" class="form-control" name="csku"
									required id="sku" placeholder="Enter SKUID">
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Part Name
									</div>
									<div class="col-md-4">
									<input type="text" name="name"
													placeholder="Enter Part Name" class="form-control" required></input>
									</div>
									<div class="col-md-2">
									Category
									</div>
									<div class="col-md-4">
									<input type="text" name="category"
													class="form-control" placeholder="Enter Category" required></input>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Sub Category
									</div>
									<div class="col-md-4">
									<input type="text" name="subcategory"
													class="form-control" placeholder="Enter Sub Category"></input>
									</div>
									<div class="col-md-2">
									Specifications
									</div>
									<div class="col-md-4">
									<label>Specification 1 :</label>
													<div id='TextBoxesGroup'>
														<div id="TextBoxDiv1">
															<input name="specification" type="text"
																class="form-control" id="specification"
																placeholder="Enter Specification 1" />
														</div>
														<br> 
													</div> <input type='button' value='Add Button'
													class="btn btn-primary" id='addButton'> 
													<input
													type='button' class="btn btn-primary" value='Remove Button'
													id='removeButton'>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Description
									</div>
									<div class="col-md-4">
									<textarea name="description"  rows='3' coloumn='5'
														class="form-control" id="desrciption"
														placeholder="Enter Description"></textarea>
									</div>
									<div class="col-md-2">
									Warranty
									</div>
									<div class="col-md-4">
									<label><input type="radio" name="warranty" value="YES" onclick="show2();" required> YES </label> 
												<label><input type="radio" name="warranty" value="0" onclick="show1();">NO </label>
													<div id="div1" style="display: none;">
														<input type="text" name="war" onkeyup="NumAndTwoDecimals(event , this);" placeholder="Warranty">
													</div>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Price
									</div>
									<div class="col-md-4">
									<input name="price" class="form-control"
													onkeyup="NumAndTwoDecimals(event , this);" type="text"
													id="price" placeholder="Enter Price" maxlength="20">
									</div>
									<div class="col-md-2">
									Image
									</div>
									<div class="col-md-4">
									<input type="file" class="form-control"
													name="photo" placeholder="Enter Image" required>
									</div>
									
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									Delivery Method
									
									</div>
									<div class="col-md-10" align="left">
									<label>
										<input type="checkbox" name="dmethod" checked  id="price" value="CASH ON DELEVERY"> CASH ON DELIVERY 
									</label>
									<label>
										<input type="checkbox" name="dmethod" id="price" value="CARD PAYMENT"> CARD PAYMENT 
									</label>
									<label>
										<input type="checkbox" name="dmethod" id="price" value="STORE PICKUP"> STORE PICKUP  
									</label>
									
									</div>
									<div clas="col-md-12"><br></div>
									<div class="col-md-6" align="center">
									<button TYPE="submit"
														style="background-color: #a3b745; border: 1px solid #a3b745;"
														class="btn btn-primary">ADD SPARE PART</button>
									
									</div>
                                    <div class="col-md-6" align="center">
									<input
													style="background-color: #a3b745; border: 1px solid #a3b745;"
													type="reset" value="RESET" class="btn btn-primary" />
									
									</div>									
									
									
									
								</form>
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
