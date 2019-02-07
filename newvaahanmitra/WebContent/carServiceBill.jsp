<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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


<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>carService</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<script type= "text/javascript" src = "./js/countries.js"></script>
<link rel="stylesheet" type="text/css" href="./css/myStyle.css" />
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>
<!-- Theme initialization -->
<script>
	var themeSettings = (localStorage.getItem('themeSettings')) ? JSON
			.parse(localStorage.getItem('themeSettings')) : {};
	var themeName = themeSettings.themeName || '';
	if (themeName) {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
	} else {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
	}
</script>
<style>
	.td{
	 font-size: small;
	}
	</style>
	
	
		<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
	 }
	</style>
	
	

	 
	<!--  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
	 <script>
	  $(document).ready(function(){
	  $("#num").click(function () {
	  $(".Box:first").clone().appendTo("#form"); 
	});
	});
	  </script> -->
	
<script type="text/javascript">

function CalcDiscount(str)
{
 var total = document.getElementById("price").value;
//  var value = document.getElementById("item-price").innerText;
 var discount = document.getElementById("discount").value;
 var tax = document.getElementById("tax").value;
//  var total =  value * qty;
 var disc=discount/100;
 var gtotal =  total - (disc*total);
 var ptax = (gtotal*tax)/100;
 var total=gtotal+ptax;
 //document.getElementById("total-price").value = gtotal; 
 $("#total-price").val(total);
}

</script>
	
	        <style>
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
input[type=checkbox]:checked {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"><path id="checkbox-3-icon" fill="#000" d="M81,81v350h350V81H81z M227.383,345.013l-81.476-81.498l34.69-34.697l46.783,46.794l108.007-108.005 l34.706,34.684L227.383,345.013z"/></svg>');
}
input[type=checkbox]:not(:checked) {
    background-image: url('data:image/svg+xml;utf8,<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"> <path id="checkbox-9-icon" d="M391,121v270H121V121H391z M431,81H81v350h350V81z"></path> </svg>');
}
  </style>
	
<!-- 	<script type="text/javascript">
	
	function check(){
	var	checkboxvar=document.getElementById("checked");
	if (checkboxvar.checked == false){
		
	alert("Please select checkboxes");
			
   			return false;
		}else{
// 			return false
		}
 		return true;
	}
	
	</script> -->
	
	<script type="text/javascript">
	
	function admSelectCheck(nameSelect)
	{
	    if(nameSelect){
	        admOptionValue = document.getElementById("admOption").value;
	        if(admOptionValue == nameSelect.value){
	        	
	            document.getElementById("admDivCheck").style.display = "block";
	            document.getElementById("admCheck").style.display = "none";
	        }
	        else{
	            document.getElementById("admDivCheck").style.display = "none";
	            document.getElementById("admCheck").style.display = "block";
	        }
	    }
	    else{
	        document.getElementById("admDivCheck").style.display = "none";
	    }
	}
	
	</script>
	
</head>

<body>
	<div class="main-wrapper">
<!-- 		<div class="app" id="app" style="background-color:#ffffff"> -->


			<!-- <header class="header">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div> -->

			<div class="header-block header-block-nav">
<!-- 				<ul class="nav-profile"> -->

<!-- 					<li class="profile dropdown"><a -->
<!-- 						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" -->
<!-- 						role="button" aria-haspopup="true" aria-expanded="false"> -->
<!-- 							<div class="img" style=""></div> <span class="name"> Mohan -->
<!-- 								Amasa</span> -->
<!-- 					</a> -->
<!-- 						<div class="dropdown-menu profile-dropdown-menu" -->
<!-- 							aria-labelledby="dropdownMenu1"> -->

<!-- 							<a class="dropdown-item" href="#"> <i -->
<!-- 								class="fa fa-power-off icon"></i> Logout -->
<!-- 							</a> -->
<!-- 						</div></li> -->
<!-- 				</ul> -->
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page" style="background-color:#fff"> 
			<section class="section">
			<div class="row">
				<div class="col-md-12" style="margin-top: 10px;">
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);">
						<div class="card-block">
							<section class="example">
							<div class="table-responsive">
					 			 <form action="./CarServiceBill" method="post" onSubmit="return validate()"> 
					 			 <%
					 			System.out.println("sdfdsf");
					 			List<CarService> carServiceal=(ArrayList<CarService>)request.getAttribute("carService");
					 			String appt=(String)request.getAttribute("apptId");
					 			String vehicleType=(String)request.getAttribute("vehicleType");
					 			String vehicleType1=request.getParameter("vehicleType");
					 			Iterator serviceList=null;
					 			System.out.println(carServiceal);
					 			if(carServiceal!=null && carServiceal.size()>0){
					 			serviceList=carServiceal.iterator();
					 			System.out.println(serviceList);
					 			}
					 			 %>
					 			 <%if(vehicleType!=null){ %>
					 			 <input type="hidden" name="vehicleType" value="<%=vehicleType%>"/>
					 			 <%}else{ %>
					 			  <input type="hidden" name="vehicleType" value="<%=vehicleType1%>"/>
					 			 <%} %>
					 			 
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th colspan="8" style="text-align: center;">Service Bill</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                     <tr>
                                                     <%
                                                     String apptId=request.getParameter("apptId");
                                                     %>
                                                     <td colspan="8" style="color:red">
                                                     
                                                     <%if(appt!=null){ %>
                                                     <h4><%=appt%></h4>
                                                     <%}else{ %>
                                                     <h4><%=apptId %></h4>
                                                     <%} %>
                                                     </td>
                                                      <input type="hidden" name="apptId" value="<%=apptId==null?appt:apptId%>"/>
                                                    </tr>
                                                     <tr style="background-color: #ccc;">
                                                     
                                                            <th>
																 Service Type 
																
                                                            </th>
                                                            
                                                              <th>
																 Spare Parts
																
                                                            </th>
                                                            
                                                            <th>
																  Additional Comments
																
                                                            </th>
                                                            
                                                             <th>
																 Amount
																
                                                            </th>
                                                            
                                                              <th>
																 Discount(%)
																
                                                            </th>
                                                            <th>
																 Tax(%)
																
                                                            </th>
                                                             <th>
																 Final Price
																
                                                            </th>
                                                           
                                                             <th><div class="form-group">
																  <div class="col-sm-12">
																</div>
																</div>
                                                            </th> 
                                                            
                                                       </tr>
                                                    <%
                                                    System.out.println(serviceList);
                                                    if(serviceList!=null){ 
                                                    
                                                    while(serviceList.hasNext()){
                                                    
                                                    	CarService carService=(CarService)serviceList.next();
                                                    	
                                                    %>
                                                           <tr>
                                                            <td>
																 <input type="text" name="serviceType" value="<%=carService.getSERVICE_TYPE() %>" style="border:0;" class="form-control1 input-sm" required>
					
                                                            </td>
                                                            
                                                              <td>
																 <input type="text" name="spareParts" value="<%=carService.getSPAREPARTS() %>" style="border:0;" class="form-control1 input-sm">
															
                                                            </td>
                                                            
                                                            <td>
																 <textarea name="desc" style="border:0;" rows="2" cols="20"><%=carService.getDESCRIPTION() %></textarea>
														
                                                            </td>
                                                            
                                                             <td>
																 <input type="text" name="amount" style="border:0;" value="<%=carService.getAMOUNT() %>"  class="form-control1 input-sm" required>
															
                                                            </td>
                                                            
                                                              <td>
																 <input type="text" name="discount" style="border:0;" value="<%=carService.getDESCOUNT() %>" class="form-control1 input-sm" required>
															
                                                            </td>
                                                            
                                                            <td>
																 <input type="text" name="tax" style="border:0;" value="<%=carService.getTAX() %>" class="form-control1 input-sm" required>
															
                                                            </td>
                                                            
                                                             <td>
																 <input type="text" name="finalPrice" style="border:0;" value="<%=carService.getFINAL_PRICE() %>" class="form-control1 input-sm" required>
															
                                                            </td>
                                                            
                                                       </tr>
                                                    <%}} %>
                                                        <tr>
                                                      
                                                            <td>
																 <select name="serviceType" style="width:200px;" id="getFname" onchange="admSelectCheck(this);" required>
																 <option value="">Service Type</option>
																 <option id="admOption">Spareparts Replacement</option>
																 <%
																 String id=(String)session.getAttribute("user");
																 GetServiceCenterDetails serviceCenter=new GetServiceCenterDetails();
																 Set<String> serviceTypeList=serviceCenter.getServiceType(id);
																 Iterator serviceIt=serviceTypeList.iterator();
																 int i=0;
																 while(serviceIt.hasNext()){
																	String serviceType=(String) serviceIt.next(); 
																 %>
																 <option><%=serviceType %></option>
																 <%} %>
																 </select>
																
                                                            </td>
                                                            
                                                             <td>
                                                             <div id="admCheck" >
                                                            	<select style="width:200px;">
																 <option>Spare Parts</option>
																 </select>
                                                             </div>
                                                             <div id="admDivCheck" style="display:none;">
																  
																 <select name="spareParts" style="width:200px;">
																 <option value="Nill">Spare Parts</option>
																 <%
																 Set<CarService> sparePartsList=serviceCenter.getSpareParts(id);
																 Iterator sparePartsIt=sparePartsList.iterator();
																
																 while(sparePartsIt.hasNext()){
																	 CarService spareParts=(CarService) sparePartsIt.next(); 
																 %>
																 <option><%=spareParts.getSPAREPARTS() %></option>
																 <%} %>
																 </select>
																</div>
                                                            </td>
                                                            
                                                             <td>
																 <textarea name="desc" rows="2" cols="20" placeholder="Additional Comment" required></textarea>
																
                                                            </td>
                                                            
                                                            <td>
																 <input type="text" name="amount" class="form-control1 input-sm" value="0" id="price" required>
																
                                                            </td>
                                                           
                                                            <td>
																 <input type="text" name="discount"  value="0" id="discount" class="form-control1 input-sm" onkeyup="CalcDiscount(<%=i%>);" placeholder="Discount" required>
																
                                                            </td>
                                                            <td>
																 <input type="text" name="tax" class="form-control1 input-sm" onkeyup="CalcDiscount(<%=i%>);" id="tax" value="0" required>
															
                                                            </td>
                                                             <td>
																 <input type="text" name="finalPrice" class="form-control1 input-sm" id="total-price" readonly required>
															
                                                            </td>
                                                       
                                                         <td align="center">
<!-- 																  <button id="num">Add</button> -->
 																  <input type="submit" value="Add" name="submit" class="btn btn-primary"/>
																
                                                            </td>
                                                            
                                                       </tr>
                                                        <tr>
 														<!-- <td colspan="2" align="left" style="color:red">
 														If you want to submit please check this
														</td>
														<td colspan="1" align="left">
 														<input type="checkbox" name="checked" value="copl" id="checked" class="btn btn-primary"/>
														</td> -->
														<!--  <td colspan="2">
														Tax(%):<input type="text" name="tax" value="0" id="tax" class="form-control1 input-sm" placeholder="Tax" required>		
                                                        </td> -->
														<td colspan="8">
 														Mechanic Name:<input type="text" name="mechanicName"/>
														</td>
														</tr>
                                                        <tr>
 														<td colspan="8" align="center">
<!--  														<button type="submit" value="Submit" onclick="document.getElementById('finRot').checked=!document.getElementById('finRot').checked;" class="btn btn-primary">Submit</button> -->
														<input type="submit" name="submit" value="Submit" class="btn btn-primary">
														
														</td>
														</tr>

                                                    </tbody>
                                                </table>
                                                </form>
                                                
                                                
<!--                                                 	<tr>
                                                	 <div id="form">
  Hai Add Another by clicking the button
  </div>
														 <div class='Box'>
														 																 <input type="text" name="discount" class="form-control1 input-sm" placeholder="Discount" required>
														                                                         <input type="hidden" name="sub" value="sub"/>
														 																 <input type="text" name="discount" class="form-control1 input-sm" placeholder="Discount" required>
														 
														 <button id="num">Add</button>
														 </div>
														</tr> -->
                                                
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
<!-- 		</div> -->
	</div>
	<!-- Reference block for JS -->
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
populateCountries("country", "state");
</script>
</body>

</html>