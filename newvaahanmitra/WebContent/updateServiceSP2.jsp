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
<jsp:include page="./carMenu.jsp" />
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
		xmlhttp.open("GET", "./getNewBikeModel.jsp?brand=" + str, true);
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
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<!-- <h3 style="">SPARE PARTS DASHBOARD</h3> -->
				<div> <h3 class="col-md-12" align="center">SERVICE CENTER DASHBOARD</h3></div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well" style="border-radius:4%">
								<form action="./UpdateServiceSpareParts" method="POST"
									onSubmit="return validate()" enctype="multipart/form-data">
									
									<div class="col-md-12" align="center" style="background-color: #523f6d; color: #fff;">
									<em>UPDATE SPARE PARTS</em>
									<% 
										SpareParts sp = null;
										String vt = request.getParameter("vt");
										String sku = request.getParameter("sku");
										
										String ssku = (String)request.getAttribute("ssku");
										String svt = (String)request.getAttribute("svt");
										
										GetSparePartsDetails gsp = new GetSparePartsDetails();
										if(sku!=null){
										sp = gsp.getSparePartDetails(sku);
										}else{
											sp = gsp.getSparePartDetails(ssku);
										}
												%>	
									</div>
									<%if(vt==null || vt.equals(null)){ %>
									<input type="hidden" name="vehicleType" value="<%=svt%>"/>
									<%}else{ %>
									<input type="hidden" name="vehicleType" value="<%=vt%>"/>
									<%} %>
									<%if (message != null) {
										%>
										<h5 style="color: #0e576d;"><%=message%>
										</h5>
										<%
											} else {
											}
										%> 
									<div class="col-md-12"><br></div>
									<div class="col-md-5" align="center">
									<!-- <label><input type="radio" name="vehicleType" value="4," checked><b> FOUR WHEELER
									</b></label> -->				
									</div>
									<div class="col-md-5" align="center">
									<!-- <label><input type="radio" name="vehicleType" value="2," onclick="location.href='bikeSpareParts.jsp'"><b>
                                    	TWO WHEELER </b></label> -->
									</div>
									<div class="col-md-12"></div>
									<div class="col-md-2">
									<label>Bike Brand</label>
									
									</div>
									<div class="col-md-4">
									<jsp:include page="./getNewBikeBrand.jsp" />
									
									</div>
									<div class="col-md-2">
									<label>Bike Model</label>
									
									</div>
									<div class="col-md-4">
									<div id="txtHint1">
									<select name="bikeModel" class="form-control">
									<option value=""><%=sp.getVEHICLE_MODEL()%></option>
									</select>
                                          </div>
									
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									<label>Model Year</label>
									</div>
									<div class="col-md-4">
									<select id="year1" class="form-control" name="year1">
													<option><%=sp.getMODEL_YEAR()%></option>
												</select>
									</div>
									<div class="col-md-2">
									 <label>Company Name</label>
									</div>
									<div class="col-md-4">
									<input type="text" name="companyName" value="<%=sp.getMANUFACTURE_COMPANY_NAME() %>"
													class="form-control" placeholder="Enter Company Name"
													required></input>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									<label>PartNo</label>
									</div>
									<div class="col-md-4">
									<input type="text" name="partNo" required value="<%=sp.getPARTNO()%>"
													class="form-control" placeholder="Enter PartNo">
									</div>
									<div class="col-md-2">
									<label>SKU</label>
									</div>
									<div class="col-md-4">
									<input type="text" class="form-control" readonly name="csku" value="<%=sp.getSKU()%>"
									required id="sku" placeholder="Enter SKU">
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									<label>Part Name</label>
									</div>
									<div class="col-md-4">
									<input type="text" name="name" value="<%=sp.getSP_NAME()%>"
													placeholder="Enter Name" class="form-control" required></input>
									</div>
									<div class="col-md-2">
									<label>Category</label>
									</div>
									<div class="col-md-4">
									<input type="text" name="category" value="<%=sp.getCATEGORY()%>"
													class="form-control" placeholder="Enter Category" required></input>
									</div>
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									<label>Sub Category</label>
									</div>
									<div class="col-md-4">
									<input type="text" name="subcategory" value="<%=sp.getSUB_CATEGORY()%>"
													class="form-control" placeholder="Enter Sub Category"></input>
									</div>
									<div class="col-md-2">
									<label>Specifications</label>
									</div>
									<div class="col-md-4">
									<label>Specification 1 :</label>
													<div id='TextBoxesGroup'>
														<div id="TextBoxDiv1">
															<input name="specification" type="text" value="<%=((sp.getSPECIFICATIONS()==null || sp.getSPECIFICATIONS().equals("null")?" ":sp.getSPECIFICATIONS())) %>"
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
									<label>Description</label>
									</div>
									<div class="col-md-4">
									<textarea name="description"  rows='3' coloumn='5' value="<%=sp.getDESCRIPTION()%>"
														class="form-control" id="desrciption"
														placeholder="Enter Description"></textarea>
									</div>
									<div class="col-md-2">
									<label>Warranty</label>
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
									<label>Price</label>
									</div>
									<div class="col-md-4">
									<input name="price" class="form-control"
													onkeyup="NumAndTwoDecimals(event , this);" type="text" value="<%=sp.getPRICE()%>"
													id="price" placeholder="Enter Price" maxlength="20">
									</div>
									<div class="col-md-2">
									<label>Image</label>
									</div>
									<div class="col-md-4">
									<img src="data:image/png;base64,<%=sp.getIMAGE()%>"
														alt="No image" width="150px" height="120px"> <input
														type="file" value="update" name="photo" accept="image/*"required">
									<input type="hidden" name="image"
														value="<%=sp.getIMAGE()%>">
									</div>
									
									<div class="col-md-12"><br></div>
									<div class="col-md-2">
									<label>Delivery Method</label>
									
									</div>
									<div class="col-md-10" align="left">
									<label>
										<input type="checkbox" name="dmethod" id="price" value="CASH ON DELEVERY"> CASH ON DELIVERY 
									</label>
									<label>
										<input type="checkbox" name="dmethod" id="price" value="CARD PAYMENT"> CARD PAYMENT 
									</label>
									<label>
										<input type="checkbox" name="dmethod" id="price" value="STORE PICKUP"> STORE PICKUP  
									</label>
									
									</div>
									<div clas="col-md-12"><br></div>
									<div class="col-md-12" align="center">
									<button TYPE="submit"
														style="background-color: #a3b745; border: 1px solid #a3b745;"
														class="btn btn-primary">UPDATE SPARE PART</button>
									
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

			<!-- /.modal -->

			<!-- /.modal -->
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
for(var year = start ; year <=end; year++){
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
