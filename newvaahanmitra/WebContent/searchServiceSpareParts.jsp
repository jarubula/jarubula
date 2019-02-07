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
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp" />
<jsp:include page="./topMenu.jsp"></jsp:include>
<title>Vaahanmitra</title>
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
	function getVehicleBrand(str) {
		if (str == "") {
			document.getElementById("txtHint10").innerHTML = "";
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
				document.getElementById("txtHint10").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getSpBrand.jsp?spBrand=" + str, true);
		xmlhttp.send();
	}
</script>
<script>
function getSpModel(str)
{
	if (str=="")  
	{  
		document.getElementById("txtHint11").innerHTML="";  
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
			document.getElementById("txtHint11").innerHTML=xmlhttp.responseText;    
			}  
		}
	xmlhttp.open("GET","./getSpModels.jsp?brand="+str,true);   
	xmlhttp.send();    
	}
	</script>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class=""> </header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12" align="center">
					<h3 style="">SERVICE CENTER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive well">
								<form action="./SearchServiceSpareParts" method="GET">
									<div class="col-md-12"
										style="text-align: center; background-color: #523f6d; color: #fff;border-radius: 10px">
										<em>SEARCH SPARE PARTS</em>
									</div>

									<%
										String vehicleType = (String) request.getAttribute("vehicleType");
										String brandid = (String) request.getAttribute("vehicleBrand");
										String user_name = (String) request.getAttribute("user_name");
										String carModel = (String) request.getAttribute("vehicleModel");
										String sku = (String) request.getAttribute("sku");
										String partName = (String) request.getAttribute("partName");
									%>

									<div class="col-md-12">
										<br>
									</div>
									
									<div class="col-md-2" align="center">
									<label><b>Vehicle Type</b></label>
										<select name="vehicleType" class="form-control" id="spBrand"
											onchange="getVehicleBrand(this.value)">
											<option value="SELECT" style="display: none;">Vehicle
												Type</option>
											<option value="4,2,">All</option>
											<option value="2,">TWO WHEELER</option>
											<option value="4,">FOUR WHEELER</option>
										</select>

									</div>
									
									<div class="col-md-2" align="center">
									<label><b>Vehicle Brand</b></label>
									<div id="txtHint10">
										<select class="form-control" name="vehicleBrand">
											<option value="SELECT" style="display: none;">Vehicle Brand</option>
										</select>
									</div>
									</div>
									
									<div class="col-md-2" align="center" >
										<label><b>Vehicle Model</b></label>
										<div id="txtHint11">
											<select class="form-control" name="vehicleModel" >
												<option value="SELECT" style="display:none;">SELECT MODEL</option>
											</select>
										</div>

									</div>
									
									<div class="col-md-2" align="center" >
									<label><b>SKU</b></label>
										<%
											String message = (String) request.getAttribute("message");
											String email = (String) session.getAttribute("user");
											GetSparePartsDetails gsp = new GetSparePartsDetails();
											ArrayList<SpareParts> sp = gsp.getSparePartSku(email);
											Iterator it = sp.iterator();
										%>
										<select name="sku" class="form-control">
											<option value="SELECT" style="display:none;">Select SKU</option>
											<option value="All">All</option>
											<div class="form-group">
												<%
													while (it.hasNext()) {
														SpareParts sps = (SpareParts) it.next();
												%>
												<option><%=sps.getSKU()%></option>
												<%
													}
												%>
											</div>
										</select>

									</div>
									
									<div class="col-md-2" align="center" style="margin-bottom:4px;">
									<label><b>Spare Part Name</b></label>
										<select name="partName" class="form-control">
											<option value="SELECT" style="display:none;">Select Name</option>
											<option value="All">All</option>
											<div class="form-group">
												<%
													ArrayList<SpareParts> spn = gsp.getSparePartsNames(email);
													Iterator itn = spn.iterator();
													while (itn.hasNext()) {
														SpareParts spnn = (SpareParts) itn.next();
												%>
												<option><%=spnn.getSP_NAME()%></option>
												<%
													}
												%>
											</div>
										</select>

									</div>
									<!-- <div class="col-md-1">
										<b>Category</b>
									</div>
									<div class="col-md-1">
										<div class="form-group">
											<input type="text" name="category"
												placeholder="Enter Category Name" class="form-control">
										</div>
									</div> -->
                                   
									<div class="col-md-2" align="center">
									<label><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
										<button
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">SEARCH</button>

									</div>
									<div class="col-md-12"><br></div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<tr>
					<td colspan="3"><center>
							<%
								if (message != null) {
							%>
							<h4 class="text-primary"><%=message%></h4>
							<%
								} else {
								}
							%>
						</center></td>
				</tr>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745; border-radius: 10px">
						<div class="card-block"
							style="border-bottom: 3px solid #a3b745; border-radius: 10px">
							<section class="example">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<%
									int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
									ArrayList<SpareParts> al = new ArrayList<SpareParts>();
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

											al = (ArrayList<SpareParts>) request.getAttribute("spdetails");

										}
									} catch (Exception e) {
										e.printStackTrace();
									}
									int x = (maxrowsperpage * page1) - maxrowsperpage;
									
										ArrayList<SpareParts> spss = (ArrayList<SpareParts>) request.getAttribute("spdetails");
									%>
									<tr>
										<th style="text-align: center">IMAGE</th>
										<th style="text-align: center">SKU</th>
										<th style="text-align: center">PART NAME</th>
										<th style="text-align: center">VEHICLE BRAND</th>
										<th style="text-align: center">VEHICLE MODEL</th>
										<!-- 												<th style="text-align: center">PART NO</th> -->
										<!-- 												<th style="text-align: center">COMPANY NAME</th> -->
										<th style="text-align: center">CATEGORY</th>
										<!-- 												<th style="text-align: center">SUBCATEGORY</th> -->
										<!-- 												<th style="text-align: center">SPECIFICATIONS</th> -->
										<th style="text-align: center">WARRANTY</th>
										<th style="text-align: center">PRICE</th>
										<th style="text-align: center">DELEVERY
											METHOD</th>
										<th style="text-align: center">UPDATE</th>
										<th colspan="2" style="text-align: center">STATUS</th>
									</tr>
									<%
										int i = 1;
										int j = 1;
									%>
									<%
											if (spss!=null && spss.size() <= 0) {
										%>
										<tr>
											<td colspan="11" align="center"><font color=red>No
													Records Found</font></td>
										</tr>
										<%
											} else {
										%>
									<div class="container">
										<c:forEach var="spss1" items="${spdetails}">
												<tr>
													<td><img src="data:image/png;base64,${spss1.IMAGE}"
														border="0" width="85px" height="85px" alt="No image"
														class="img-responsive"></td>
													<td style="text-align: center"><abbr
														title="clickme for more details">
															<button data-toggle="modal" data-target="#myModal<%=i%>"
																type="button"
																style="border: 1px #a3b745; border-radius: 10px"
																class="btn btn-link">${spss1.SKU}</button>
													</abbr></td>
													<td style="text-align: center"><c:out
															value="${spss1.SP_NAME}"></c:out></td>
													<td style="text-align: center"><c:out
															value="${spss1.VEHICLE_BRAND}"></c:out></td>
													<td style="text-align: center"><c:out
															value="${spss1.VEHICLE_MODEL}"></c:out></td>
													<%-- 													<td style="text-align: center"><c:out value="${spss1.PARTNO}"></c:out></td> --%>
													<%-- 													<td style="text-align: center"><c:out value="${spss1.MANUFACTURE_COMPANY_NAME}"></c:out></td> --%>
													<td style="text-align: center"><c:out
															value="${spss1.CATEGORY}"></c:out></td>
													<%--      												<td style="text-align: center"><c:out value="${spss1.SUB_CATEGORY}"></c:out></td> --%>
													<%--      												<td style="text-align: center"><c:out value="${spss1.SPECIFICATIONS}"></c:out></td> --%>
													<td style="text-align: center"><c:out
															value="${spss1.WARRANTY}yr"></c:out></td>
													<td style="text-align: center"><c:out
															value="${spss1.PRICE}"></c:out></td>
													<td style="text-align: center"><c:out
															value="${spss1.DELEVERY_METHOD}"></c:out></td>
													<c:set var="vt" value='${spss1.VEHICLE_TYPE}'/>
													<%
														String svt = (String) pageContext.getAttribute("vt");
														if(svt.equals("4,")){
														%>
													<td><a href="./updateServiceSP4.jsp?sku=${spss1.SKU}&vt=${spss1.VEHICLE_TYPE}"><b>UPDATE</b></a></td>
													<% 
														}else{%>
															<td><a href="./updateServiceSP2.jsp?sku=${spss1.SKU}&vt=${spss1.VEHICLE_TYPE}"><b>UPDATE</b></a></td>
													<% 	}
													%>
												<form action="./ActiveInactiveServiceSpareParts" method="post">
													<input type="hidden" name="vehicleType" value="<%=vehicleType%>">
													<input type="hidden" name="brand" value="<%=brandid%>"> 
													<input	type="hidden" name="model" value="<%=carModel%>">
													<input type="hidden" name="page" value="<%=page1%>">
													<input type="hidden" name="skuId" value="<%=sku%>"/>
													<input type="hidden" name="sku" value="${spss1.SKU}"/> 
													<input type="hidden" name="spName" value="<%=partName%>" />
													<input	type="hidden" name="status" value="${spss1.STATUS}" />
													<c:set var="status" value='${spss1.STATUS}'/>
													<%
														String status = (String) pageContext.getAttribute("status");
														if(status.equals("ACTIVE")){
														%>	
														<td>
															<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="${spss1.STATUS}">
														</td>
													<%	
													}else{%>
													<td>
														<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="${spss1.STATUS}">
													</td>
													<% }%>
												</form>
												<td>
												<div class="modal fade" id="myModal<%=i%>" role="dialog">
													<div class="modal-dialog">
														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>
																<h2
																	style="color: #fff; margin-top: 0px; font-weight: 600;">
																	Vaahan<span style="margin-left: 2px; color: #fec107;">Mitra</span>
																</h2>
															</div>
															<div class="modal-body">
																<c:set var="sku" value='${spss1.SKU}' />
																<%
																	String sku1 = (String) pageContext.getAttribute("sku");
																		GetSparePartsDetails spd = new GetSparePartsDetails();
																		SpareParts sps = spd.getSparePartDetails(sku1);
																%>
																<!-- 																<div class="container"> -->
																<center>
																	<h2 style="color: #663399">SPARE PART DETAILS</h2>
																</center>
																<table class="table table-striped" border="1">
																	<tbody style="background-color: beige;">
																		<tr>
																			<th style="color: #C71585">PHOTO</th>
																			<td><img class="colc2"
																				src="data:image/png;base64,<%=sps.getIMAGE()%>"
																				style="height: 20%;width: 20%" alt="No image"
																				class="img-responsive"></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">SKU</th>
																			<td><%=sps.getSKU()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">PART NAME</th>
																			<td><%=sps.getSP_NAME()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">VEHICLE TYPE</th>
																			<td><%=sps.getVEHICLE_TYPE()%>WHEELER</td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">VEHICLE BRAND</th>
																			<td><%=sps.getVEHICLE_BRAND()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">VEHICLE MODEL</th>
																			<td><%=sps.getVEHICLE_MODEL()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">MODEL YEAR</th>
																			<td><%=sps.getMODEL_YEAR()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">PART NO</th>
																			<td><%=sps.getPARTNO()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">COMPANY NAME</th>
																			<td><%=sps.getMANUFACTURE_COMPANY_NAME()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">CATEGORY</th>
																			<td><%=sps.getCATEGORY()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">SUB CATEGORY</th>
																			<td><%=sps.getSUB_CATEGORY()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">SPECIFICATIONS</th>
																			<td><%=sps.getSPECIFICATIONS()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">DESCRIPTION</th>
																			<td><%=sps.getDESCRIPTION()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">WARRANTY</th>
																			<td><%=sps.getWARRANTY()%>yr</td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">PRICE</th>
																			<td><%=sps.getPRICE()%></td>
																		</tr>
																		<tr>
																			<th style="color: #C71585">DELIVERY METHOD</th>
																			<td><%=sps.getDELEVERY_METHOD()%></td>
																		</tr>
																	</tbody>
																</table>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	style="color: red" data-dismiss="modal">Close</button>
															</div>
														</div>

													</div>
												</div>
											</td>
											</tr>
											<%
												i++;
												j++;
											%>
										</c:forEach>
									</div>
								</table>
								<table>
										<tr>
											<td>Pages<b>:</b>
											</td>
											<c:forEach begin="1" end="${noOfPages}" var="x">
												<td><a
													href="./SearchServiceSpareParts?page=${x}&vehicleType=<%=vehicleType%>&vehicleBrand=<%=brandid%>&user_name=<%=user_name%>&vehicleModel=<%=carModel%>&sku=<%=sku%>&partName=<%=partName%>">&nbsp;${x}&nbsp;</a></td>
											</c:forEach>
										</tr>
										<%
											}
										%>
									</table>
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
