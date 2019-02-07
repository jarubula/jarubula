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
<jsp:include page="./Admin-right-side.jsp"/>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ShowUsedCarsList</title>
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
.close:hover {
      color: #fff;
    text-decoration: none;
    cursor: pointer;
    opacity: 0.2;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}
.modal-header {
    padding: 6px;
    border-bottom: 1px solid #e5e5e5;
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
								<form action="./SearchDealerDocuments" method="post" align="center">
									<div class="col-md-12" style="background-color: #523f6d;">
										<div align="center"
											style="text-align: center; background-color: #523f6d; color: #fff;">
											DEALER AUTHENTICATION
											</div>
										</div>
										<br>
										<br>
									<div class="col-md-12"></div>
									<div class="col-md-2 col-sm-12 col-xs-12" style="margin-bottom:6px">
									<b>Enter Email Id</b></div>
									<div class="col-md-2 col-sm-12 ">
										<input type="text" name="emailId" class="form-control" placeholder="Enter emailId" required>
									</div>
									
									
									<div class="col-md-1" align="center">
										<button TYPE="submit"
													style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
													class="btn btn-primary">SUBMIT</button>
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
				<div align="center">
					<%
						ArrayList ddocumets = (ArrayList) request.getAttribute("ddocumets");
						if (ddocumets != null && ddocumets.size() > 0) {
					%>
					<h5>
						<b style="color: #fc7f0a"><%="Dealer Details"%></b>
					</h5>
					<%
						} else if (ddocumets == null) {} else {
					%>
					<h5>
						<b style="color: #fc7f0a"><%=request.getAttribute("message")%></b>
					</h5>
					<%
						}
					%></div>
				<br>&nbsp;&nbsp;
				<div class="row">
					<div class="col-md-12">
						<div class="card"
							style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
							<div class="card-block" style="border-bottom: 3px solid #a3b745;">
								<section class="example">
								<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<tr>
												<th style="text-align: center">Dealer Email id</th>
												<th style="text-align: center">Brand Name</th>
												<th style="text-align: center">Document Name</th>
												<th style="text-align: center">File</th>
												<th style="text-align: center">Status</th>
												<th style="text-align: center"></th>
											</tr>
											<c:forEach var="ddocumets" items="${ddocumets}">
												<tr>
													<td style="text-align: center"><c:out
															value="${ddocumets.DEALER_NAME}"></c:out></td>
													<td style="text-align: center"><c:out
															value="${ddocumets.BRAND_NAME}"></c:out></td>
													<td style="text-align: center"><c:out
															value="${ddocumets.DOCUMENT_NAME}"></c:out></td>
													<td style="text-align: center"><img
														class="colc2" src="data:image/png;base64,${ddocumets.FILE}"
														onmouseover="bigImg(this)" border="0" width="85px" height="85px" alt="No image"
														class="img-rounded" style="cursor: pointer;"></td>
													<td style="text-align: center"><c:out
															value="${ddocumets.DEALER_AUTHENTICATION}"></c:out></td>
															
													<td>
													<c:choose>
													<c:when test="${ddocumets.DEALER_AUTHENTICATION=='Yes'}">
														<button type="submit" class="btn btn-warning btn-lg" style="border: 1px solid #fff;
                                                         border-radius: 5px; line-height: 15px;">Accepted</button>
													</c:when>
													<c:otherwise>
														<button type="submit" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal" style="    border: 1px solid #fff;
                                                         border-radius: 5px; line-height: 15px;">Accept</button>
													</c:otherwise>
													</c:choose></td>
													
												</tr>
												
												 <!-- Modal -->
											<form action="./AdDealerFeedback" method="post">
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">
														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>
																<h4 class="modal-title">Dealer Feedback</h4>
															</div>
															<input type="hidden" name="demail" value="${ddocumets.DEALER_NAME}">
															<div class="modal-body">
																<div class="form-group">
																	<label for="password" class="col-sm-3 control-label">Acceptance :</label>
																	<div class="col-sm-9">
																		<select name="acceptance">
																			<option value="Yes">Yes</option>
																			<option value="No">No</option>
																		</select>
																	</div>
																</div><br>
																<div class="form-group">
																	<label for="password" class="col-sm-3 control-label">Feed Back :</label>
																	<div class="col-sm-9">
																		<textarea class="form-control input-sm"  name ="feedback" id="address" rows="3"></textarea>
																	</div>
																</div>
															</div>
															<div>
																<input type="submit" class="" value="Submit" style="border: 1px solid #fff; border-radius: 5px;">
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-danger" data-dismiss="modal" 
																	style="border: 1px solid #fff; border-radius: 5px;">Close</button>
															</div>
														</div>
													</div>
												</div>
											</form>
										</c:forEach>
										<tr>
												</tr>
											</table>
										</div>
									</section>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
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