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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*,com.vaahanmitra.utilities.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat,java.io.*" %>  
<html>
<head>
<meta charset="utf-8">
<jsp:include page="./individualOwner.jsp" />
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!--  <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
.modal-backdrop {background: none;}
@media (min-width: 1200px){
.container {
    width: 100px;
}
}
/* .modal {
   position:fixed;
   top:0;
   right:0;
   left:auto;
   bottom:0;
} */
</style>

<style>
.td {
	font-size: small;
}
</style>
<script type="text/javascript">
function DisableNextButton(btnId) {
	btnId.disabled = 'true';
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
		<div class="app" id="app">


			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

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
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<center>
 					<h3 style="">INDIVIDUAL OWNER DASHBOARD</h3>
				</center>
				<div class="col-md-12">
<!-- 					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;"> -->
<!-- 						<div class="card-block" style="border-bottom: 3px solid #a3b745;"> -->
							<section class="example">
							
								<div class="table-responsive well">
								<form action="./SearchIODriverRequest" method="post">
								<input type="hidden" value="IO" name="userType"/>
								
										<div class="col-md-12" style="background: #523f6d;color: #f5f5f5;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">
										SEARCH REQUESTER</div>
										
										<%
										List<DriverEndUser> endUserDetails=(ArrayList<DriverEndUser>)request.getAttribute("endUser"); 
										String apptDate=(String)request.getAttribute("date");
										String message=(String)request.getAttribute("message");
										String userType=(String)request.getAttribute("userType");
										%>
										<div class="col-md-12 col-xs-12 col-sm-12">
										<br>
										           </div>

												<div class="col-md-2 col-xs-12 col-sm-12">
										           <label for="exampleInputEmail1">DATE</label>
										           </div>
										           
										              <div class="col-md-3 col-xs-12 col-sm-12" align="left">
													<div class="form-group">
													
												<input type="date" name="date" class="form-control boxed" placeholder="To DATE"></input>
													</div>
												</div>
										           
												
											<div class="col-md-2 col-xs-12 col-sm-12" align="center">
															
															
											<div class="form-group"><input type="submit" value="Search" class="btn btn-primary"/></div>
															
											</div>
											
											</form>
											</section>	
											<section class="example" style="margin-top:20px;">
											 <div style="overflow-x:auto;">
											
											<%if(message!=null){ %>
											<font><%=message %></font>
											<%} %>

											 <div id="printableArea">
											 
											 <font color="red">Your Request To Driver</font>
											<table class="table table-striped table-bordered table-hover" style="border: 1px solid #ccc;">	
											
											<tr>
											<!-- <td><b>NAME</b></td>
											<td><b>EMAIL</b></td>
											<td><b>MOBILE NO</b></td> -->
											<td><b>ADDRESS</b></td>
											<td><b>APPOINTMENT DATE</b></td>
											<td><b>APPOINTMENT TIME</b></td>
											<td><b>APPOINTMENT ID</b></td>
											<td><b>DRIVER NAME</b></td>
											<td><b>DRIVER EMAIL</b></td>
											<td><b>DRIVER CONTACT</b></td>
											<td><b>DRIVER ID</b></td>
											<td><b>Driver Charges</b></td>
											<td><b>Driver Waiting Charges</b></td>
											<td><b>ACCEPT</b></td>
											</tr>
											<%if(endUserDetails!=null && endUserDetails.size()<=0){ %>
											<tr>
											<td colspan="11"><font color="red">No Request.......</font></td>
											</tr>
											<%}else{ }%>
											
											<% int i=1; %>
											<c:forEach var="endUserDetails" items="${endUser}">
											
											
											<c:set var="test" value="${endUserDetails.APPOINTMENT_DATE}"></c:set>
											<c:set var="demail" value="${endUserDetails.DRIVER_EMAIL}"></c:set>
											<%
											String appt=null;
											String demail=null;
											appt =(String)pageContext.getAttribute("test"); 
											demail =(String)pageContext.getAttribute("demail");
											
											GetDriverDetails driverDtls=new GetDriverDetails();
											List<DriverBean> driverBean=driverDtls.getDriverName(demail);
											Iterator it=driverBean.iterator();
											
											DriverBean bean=null;
											while(it.hasNext()){
											bean=(DriverBean)it.next();	
											}
											
											SQLDate sqlDate=new SQLDate();
											String indDate=sqlDate.getInDate(appt);
											
											
											%>
											
											<tr>
											<%-- <td><c:out value="${endUserDetails.NAME}"></c:out></td>
											<td><c:out value="${endUserDetails.EMAIL}"></c:out></td>
											<td><c:out value="${endUserDetails.MOBILE_NO}"></c:out></td> --%>
											<td><c:out value="${endUserDetails.ADDRESS}"></c:out></td>
											<td><%=indDate %></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_TIME}"></c:out></td>
											<td><c:out value="${endUserDetails.APPOINTMENT_ID}"></c:out></td>
<%-- 											<td><c:out value="${endUserDetails.ACCEPTANCE}"></c:out></td> --%>
											<td><%=bean.getFIRST_NAME()+" "+bean.getLAST_NAME()==null?"":bean.getLAST_NAME() %></td>
											<td><%=bean.getEMAIL() %></td>
											<td><%=bean.getMOBILE_NO() %></td>
											<td><%=bean.getDRIVER_ID() %></td>
											<td><c:out value="${endUserDetails.DRIVER_CHARGES}"></c:out></td>
											<td><c:out value="${endUserDetails.DRIVER_WAITING_CHARGES}"></c:out></td>
											<td><c:out value="${endUserDetails.ACCEPTANCE}"></c:out></td>
										<%-- 	<td>
											<a href="./DriverRequester?date=<%=apptDate %>&apptId=${endUserDetails.APPOINTMENT_ID}&status=${endUserDetails.ACCEPTANCE}" class="btn btn-primary"><c:out value="${endUserDetails.ACCEPTANCE}"></c:out></a>
											</td> --%>
									
									
											</tr>
											<%i++; %>
											</c:forEach>
											<tr>
											<td colspan="11" align="left">
											Pages:&nbsp;
											
											
						                 	<c:forEach begin="1" end="${noOfPages}" var="k">
										
						<%-- 				<td style="float: left" ><a href="./SearchHDriver?page=${k}&state=<%=state%>&dist=<%=dist%>&permitType=<%=permitType%>&range=<%=range%>&licenseType=<%=licenseType%>">${k}&nbsp;&nbsp; </a></td> --%>
									
												<c:set var="currentPage" value="${currentPage}"></c:set>
						             			<c:set var="noOfPages" value="${k}"></c:set>
						             			<%
						             			Integer currentPage1=(Integer)pageContext.getAttribute("currentPage");
						             			Integer noOfPages=(Integer)pageContext.getAttribute("noOfPages");
						             			if(currentPage1.equals(noOfPages)){
						             			%>
												<a href="./SearchIODriverRequest?page=${k}&date=<%=apptDate%>&userType=<%=userType %>" style="color:#fc6116;"><u>${k}&nbsp;</u></a>             			
												<%} else{%>
												             			
												<a href="./SearchIODriverRequest?page=${k}&date=<%=apptDate%>&userType=<%=userType %>">${k}&nbsp;</a> 				
												<%} %>
									
									</c:forEach>
									</td>
										</tr>	
											<tr>
											
											<td colspan="12" align="right">
 											<a href="javascript:void(0);" class="btn btn-primary" onclick="printPageArea('printableArea')"> Print</a>
<!--  														<button type="submit" value="Submit" onclick="document.getElementById('finRot').checked=!document.getElementById('finRot').checked;" class="btn btn-primary">Submit</button> -->
											</td>
											
											</tr>
											
											
											</table>
											
											</div>
											
											</div>
										</tbody>
									
							
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
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script language="javascript">
		populateBrands("brand", "model");
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>