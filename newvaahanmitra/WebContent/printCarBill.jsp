<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*,java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
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
<link rel="stylesheet" type="text/css" href="./css/style.css" media="print" />
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
//  var total =  value * qty;
 var gtotal =  total - discount;
 //document.getElementById("total-price").value = gtotal; 
 $("#total-price").val(gtotal);
}

</script>
	
	<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #4CAF50;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 14px;
  padding: 2px 2px;
  width: 120px;
  transition: all 1s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 1s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 20px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
	
	<script>
	 function printPageArea(areaID){
    var printContent = document.getElementById(areaID);
    var WinPrint = window.open('', '', 'width=900,height=650');
    WinPrint.document.write(printContent.innerHTML);
    WinPrint.document.close();
    WinPrint.focus();
    WinPrint.print();
    WinPrint.close();
}
</script>
	
</head>

<body>
	<div class="main-wrapper">
<!-- 		<div class="app" id="app" style="background-color:#ffffff"> -->


			<header class="">
			<!-- <div class="header-block header-block-collapse hidden-lg-up">
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
			
				<div class="col-md-12">
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);">
						<div class="card-block">
							<section class="example">
							<div class="table-responsive">
<!-- 					 			 <form action="./CarServiceBill" method="post" onSubmit="return validate()">  -->
					 			 <%
					 			List<CarService> carServiceal=(ArrayList<CarService>)request.getAttribute("carService");
					 			List<ServiceEndUser> serviceEndUser=(ArrayList<ServiceEndUser>)request.getAttribute("serviceEndUser");
					 			List<BusinessOwnerRegister> serviceCenter=(ArrayList<BusinessOwnerRegister>)request.getAttribute("serviceCenter");
					 			String carBill=(String)request.getAttribute("carBill");
					 			String mechanicName=(String)request.getAttribute("mechanicName");
// 					 			String tax=(String)request.getAttribute("tax");
					 			
					 			BusinessOwnerRegister seriveCenterDetls=null;
					 			if(serviceCenter!=null){
					 				seriveCenterDetls=serviceCenter.get(0);
					 			}
					 			
					 			ServiceEndUser service=null;
					 			if(serviceEndUser!=null){
					 				service=(ServiceEndUser)serviceEndUser.get(0);
					 			}
					 			
					 			String appt=(String)request.getAttribute("apptId");
					 			Iterator serviceList=null;
					 			if(carServiceal!=null && carServiceal.size()>0){
					 			serviceList=carServiceal.iterator();
					 			}
					 			 %>
					 			<div id="printableArea">
                                                <table class="table table-striped table-bordered">
                                                 
                                                    <thead>
                                                   
                                                        <tr>
                                                        <h2 style="color:#0275d8;margin-top:4px;font-weight:600;">Vaahan<span style="margin-left:2px; color:#ff4444;">Mitra</span></h2>
                                                            
                                                            <th colspan="7" style="text-align: center;">Service Bill</th>
                                                        </tr>
                                                        
                                                         <tr>
                                                    <th colspan="7" style="text-align: right;"><b><font color="red">Bill Id:</font><%=carBill%></b></th>
                                                    </tr>
                                                        
                                                    </thead>
                                                    <tbody>
                                                     <tr>
                                                     <%String apptId=request.getParameter("apptId"); %>
                                                     <td colspan="3" style="color:#08bef5">
                                                     <h6><%="Appointment Id"+" : "+service.getAPPOINTMENT_ID()%></h6>
                                                     <h6><%="Customer Name"+" : "+service.getNAME()%></h6>
                                                     <h6><%="Mobile Number"+" : "+service.getMOBILE_NO()%></h6>
                                                     <h6><%="Vehicle No & Brand"+" : "+service.getCAR_NO()+","+service.getVEHICLE_BRAND()%></h6>
                                                     <h6><%="Mechanic Name"+" : "+mechanicName%></h6>
                                                     </td>
                                                      <td colspan="4" style="color:#b15350">
                                                     <h4><u><%=seriveCenterDetls.getBUSINESS_NAME()%></u></h4>
                                                     <h6><%=seriveCenterDetls.getADDRESS()+" , "+seriveCenterDetls.getB_CITY()+" , "+seriveCenterDetls.getDISTRICT()%></h6>
                                                     <h6><%=seriveCenterDetls.getSTATE()%></h6>
                                                     <h6><%=seriveCenterDetls.getMOBILE_NO()%></h6>
                                                     </td>
                                                    </tr>
                                                     <tr style="background-color: #ccc;">
                                                     
                                                            <th align="center">
																 Service Type 
														
                                                            </th>
                                                            
                                                              <th align="center">
																 Spare Parts
																
                                                            </th>
                                                            
                                                            <th align="center">
																  Additional Comments
																
                                                            </th>
                                                            
                                                             <th align="center">
																 Amount
																
                                                            </th>
                                                            
                                                              <th align="center">
																 Discount
																
                                                            </th>
                                                            
                                                            <th align="center">
																 Tax
																
                                                            </th>
                                                            
                                                             <th align="center">
																 Final Price
																
                                                            </th>
 
                                                       </tr>
                                                    <%
                                                    System.out.println(serviceList);
                                                    float total=0;
                                                    float tax=0;
                                                    float discount=0;
                                                    if(serviceList!=null){ 
                                                    
                                                    while(serviceList.hasNext()){
                                                    
                                                    	CarService carService=(CarService)serviceList.next();
                                                    	
                                                    	float f=Float.parseFloat(carService.getFINAL_PRICE());
                                                    	float t=Float.parseFloat(carService.getTAX());
                                                    	float d=Float.parseFloat(carService.getDESCOUNT());

                                                    	total=total+f;
                                                    	tax=tax+t;
                                                    	discount=discount+d;
                                                    	
                                                    %>
                                                           <tr>
                                                            <td align="center">
																 <%=carService.getSERVICE_TYPE() %>
																
                                                            </td>
                                                            
                                                              <td align="center">
																 <%=carService.getSPAREPARTS() %>
																
                                                            </td>
                                                            
                                                            <td align="center">
																<%=carService.getDESCRIPTION() %>
																
                                                            </td>
                                                            
                                                             <td align="center">
																 <%=carService.getAMOUNT() %>
																
                                                            </td>
                                                            
                                                              <td align="center">
																 <%=carService.getDESCOUNT() %>
																
                                                            </td>
                                                            
                                                            <td align="center">
																 <%=carService.getTAX() %>
																
                                                            </td>
                                                            
                                                             <td align="center">
																 <%=carService.getFINAL_PRICE() %>
																
                                                            </td>
                                                            
                                                       </tr>
                                                    <%}} 
//                                                     float tax1=(total*t);
//                                                     float tax2=tax1/100;
                                                    %>
                                                    
                                                   <tr>
                                                   <td colspan="7" align="right">
                                                   <b><%="Total Discount"+" : "+discount %></b><br>
                                                   <b><%="Total Tax"+" : "+tax %></b><br>
                                                   <b><%="Total payable Amount"+" : "+total %></b>
                                                   </td>
                                                   </tr>
                                                        <tr>
 														<td colspan="6" align="center">
 														<a href="javascript:void(0);" class="btn btn-primary" onclick="printPageArea('printableArea')"> Print Bill</a>
<!--  														<button type="submit" value="Submit" onclick="document.getElementById('finRot').checked=!document.getElementById('finRot').checked;" class="btn btn-primary">Submit</button> -->
														</td>
														<td align="right">
														<a class="btn btn-primary" href="./SendBillToUser?id=<%=service.getAPPOINTMENT_ID() %>&billId=<%=carBill %>&mail=<%=service.getEMAIL() %>">Send To Mail</a>
														</td>
														</tr>

                                                    </tbody>
                                                </table>
                                                 </div>
<!--                                                 </form> -->
                                                
                                                
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