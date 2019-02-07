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
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
	<jsp:include page="./AdminMenu.jsp" />
	<jsp:include page="./Admin-right-side.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Show Used Cars</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
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
<script>
	function myFunction(string) {
		var myWindow = window.open("./usedCarDetails.jsp?CAR_ID=" + string,
				"myWin", "left=250, top=150, width=1150, height=330");
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
	function printPageArea(areaID) {
		var printContent = document.getElementById(areaID);
		var WinPrint = window.open('', '', 'width=900,height=650');
		WinPrint.document.write(printContent.innerHTML);
		WinPrint.document.close();
		WinPrint.focus();
		WinPrint.print();
		WinPrint.close();
	}
</script>
<style>
.td {
	font-size: small;
}
</style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<header class="" style="font-family: 'Oswald', sans-serif;">

			<div class="header-block header-block-nav"></div>
			</header>
			<br>

			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div align="center">
						<h3>ADMIN DASHBOARD</h3>
					</div>
				</div>

				<div class="col-md-12 col-xs-12 col-sm-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;border-radius:10px">
							<section class="example">
							<div class="table-responsive well">
								<form action="./AdSearchDriver" method="post" align="center">
									<div class="col-md-12" style="background-color: #523f6d;">
										<div align="center"
											style="text-align: center; background-color: #523f6d; color: #fff;">
											SEARCH DRIVER
											</div>
										</div>
										<%
										String fdate = (String) request.getAttribute("fdate");
										String tdate = (String) request.getAttribute("tdate");
										String message = (String) request.getAttribute("message");
									%>
										<br>
										<br>
									<div class="col-md-12"></div>
									<input type="hidden" name="carRequester" value="csc">
									<div class="col-md-2 col-sm-12" style="margin-bottom:4px;"><b>From Date</b></div>
									<div class="col-md-2" style="margin-bottom:4px;">
										<input type="date" class="form-control" name="fdate" />
									</div>
									<div class="col-md-2" style="margin-bottom:4px"><b>TO DATE</b></div>
									<div class="col-md-2" style="margin-bottom:4px;">
										<input type="date" class="form-control" name="tdate"/>
									</div>
									<div class="col-md-2" style="margin-bottom:4px;">
										<button TYPE="submit"
													style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													class="btn btn-primary">SEARCH</button>
									</div>
									<div class="col-md-2"></div>
									<br> <br>
									<div class="col-md-12" align="center">
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
				<%-- <div align="center">
					<%
						ArrayList<DriverBean> dr = (ArrayList<DriverBean>) request.getAttribute("drDetails");
						if (dr != null && dr.size() > 0) {
					%>
					<h5>
						<b style="color: #fc7f0a"><%="Driver Details"%></b>
					</h5>
					<%
						} else if (dr == null) {} else {
					%>
					<h5>
						<b style="color: #fc7f0a"><%="No Request"%></b>
					</h5>
					<%
						}
					%></div> --%>
					<div align="center">
							<%
								if (message != null) {
							%>
							<h5 class="text-primary"><%=message%></h5>
							<%
								} else {
								}
							%>
					</div>
				&nbsp;&nbsp;
				<div class="row">
					<div class="col-md-12">
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
										<div id="printableArea">
										<table class="table table-striped table-bordered table-hover">
											<%-- <%
										int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
										ArrayList<DriverBean> al = new ArrayList<DriverBean>();
									%>

									<%
										String returnString = "";
										try {
											returnString = request.getAttribute("returnString").toString();
											out.println(" <font color=green>" + returnString + "</font>");
										} catch (Exception e) {
										}
									%>
									<br>
									<%
										try {
											if (request.getAttribute("currentPage") != null) {
												page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
												maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());

												al = (ArrayList<DriverBean>) request.getAttribute("drDetails");

											}
										} catch (Exception e) {
											e.printStackTrace();
										}
										int x = (maxrowsperpage * page1) - maxrowsperpage;
									%>
									<%
										ArrayList<DriverBean> drd = (ArrayList<DriverBean>) request.getAttribute("drDetails");
									%> --%>
											
											<tr>
												<th style="text-align: center">First Name</th>
												<th style="text-align: center">Last Name</th>
												<th style="text-align: center">Email</th>
												<th style="text-align: center">Mobile No</th>
												<th style="text-align: center">DOB</th>
												<th style="text-align: center">Address</th>
												<th style="text-align: center">Street</th>
												<th style="text-align: center">City</th>
												<th style="text-align: center">State</th>
												<th style="text-align: center">District</th>
												<th style="text-align: center">Mandal</th>
												<th style="text-align: center">License Registered State</th>
												<th style="text-align: center">License No</th>
												<th style="text-align: center">License Type</th>
												<th style="text-align: center">Expiry Date</th>
												<th style="text-align: center">Driving Ex</th>
												<th style="text-align: center">Worked Location</th>
												<th style="text-align: center">Available Within</th>
												<th style="text-align: center">Job Type</th>
												<th style="text-align: center">Adhar No</th>
												<th style="text-align: center">Pan No</th>
												<th style="text-align: center">Driver Id</th>
												<th style="text-align: center">Registered Date</th>
												<th style="text-align: center">Status</th>
											</tr>
											<%-- <%
										int i = 1;int j = 1;
									%>
									<%
										if (drd.size() <= 0) {
									%>
									<tr>
										<td colspan="11" align="center"><font color=red>No
												Records Found</font></td>
									</tr>
									<%
										} else {
									%> --%>
											<c:forEach var="dr" items="${drDetails}">
												<tr>
													<td style="text-align: center">
													<c:out value="${dr.FIRST_NAME}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.LAST_NAME}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.EMAIL}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.MOBILE_NO}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.DOB}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.ADDRESS}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.STREET}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.CITY}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.STATE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.DISTRICT}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.MANDAL}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.REGISTERED_STATE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.LICENSE_NO}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.LICENSE_TYPE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.EXPIRY_DATE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.DRIVING_EXP}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.PERMIT_TYPE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.WITHIN_RANGE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.JOB_TYPE}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.ADHAR_NO}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.PAN_NO}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.DRIVER_ID}"></c:out></td>
													<td style="text-align: center">
													<c:out value="${dr.REGISTERED_DATE}"></c:out></td>
													<%-- <td style="text-align: center">
													<c:out value="${dr.DRIVER_AVAILABILITY}"></c:out></td> --%>
													<form action="./ActiveInactiveDriver" method="post">
														<input type="hidden" name="driverId" value="${dr.DRIVER_ID}">
														<input type="hidden" name="status" value="${dr.DRIVER_AVAILABILITY}"/>
														<input type="hidden" name="fdate" value="<%=fdate%>">
														<input type="hidden" name="tdate" value="<%=tdate%>">
														<input type="hidden" name="drEmail" value="${dr.EMAIL}">
														<c:set var="status" value='${dr.DRIVER_AVAILABILITY}'/>
														<%
															String status = (String) pageContext.getAttribute("status");
															if(status.equals("ACTIVE")){
														%>	
														<td style="text-align: center">
															<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="${dr.DRIVER_AVAILABILITY}">
														</td>
														<%	
														}else{%>
														<td style="text-align: center">
															<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="${dr.DRIVER_AVAILABILITY}">
														</td>
														<% }%>
													</form>
													</tr>
										<%-- <%
											i++;
										j++;
										%> --%>
									</c:forEach>
											</table>
								<%-- <table>
									<tr>
										<td>Pages<b>:</b>
										</td>
										<c:forEach begin="1" end="${noOfPages}" var="x">
											<td><a href="./adSearchDriver?page=${x}&fdate=<%=fdate%>&tdate=<%=tdate%>">&nbsp;${x}&nbsp;</a></td>
											</c:forEach>
									</tr>
									<%
										}
									%>
								</table> --%>
										</div>
								</div>
								</section>
							</div>
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