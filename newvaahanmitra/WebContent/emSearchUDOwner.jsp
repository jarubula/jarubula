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
<%@ page language="java" import="java.util.*,com.vaahanmitra.model.*,com.vaahanmitra.utilities.*" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra | Vehicletracking</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./employeeMenu.jsp"/>
	<jsp:include page="./topMenu.jsp"/>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>AddCar</title>
<meta name="description" content="Vaahanmitra, service center, used cars, mechanics">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/statecity.js"></script>
<script src="./css/countries.js" type="text/javascript"></script>
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            }
            else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
<script type="text/javascript">
function getBusinessName(str)
{
	var usertype="SC";
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }  
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","BusinessOwnersBNames.jsp?bcity="+str+"&usertype="+usertype,true);
xmlhttp.send();
  
}
</script>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="header">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
					<%
						int page1 = 0, noofrecords = 0, maxrowsperpage = 0;
						try {
							if (request.getAttribute("currentPage") != null) {
								page1 = Integer.parseInt(request.getAttribute("currentPage").toString());
								maxrowsperpage = Integer.parseInt(request.getAttribute("maxrowsperpage").toString());
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						int x = (maxrowsperpage * page1) - maxrowsperpage;
					%>
					<div class="row">
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
							<%
							String state=new VerifyFieldsUtil().verifyString(request.getParameter("state"));
							String district=new VerifyFieldsUtil().verifyString(request.getParameter("district"));
							String mailid=new VerifyFieldsUtil().verifyString(request.getParameter("mailid"));
							String mobile=new VerifyFieldsUtil().verifyString(request.getParameter("mobile"));
							String vehicletype=new VerifyFieldsUtil().verifyString(request.getParameter("vehicletype"));
							ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
							al=(ArrayList<BusinessOwnerRegister>)request.getAttribute("BusinessOwnerDetails");
							Iterator itr= al.iterator();
							%>
							<div class="col-md-12 row" >
								<form action="./EMSearchBSOwner" method="post">
								<div class="col-md-12">
								<h5 align="center" style="background:#7a98b1;color:#fff">SEARCH DEALER</h5></div><br><br>
								<section class="col-md-2">
								<input type="hidden" name="k" id="k" value="UD" />
<!-- 								<select name="state" class="form-control states order-alpha underlined" id="stateId"> -->
								<select id="country1" name="country1" class="form-control underlined">
									<%
								if(!state.equals("NA"))
								{%>
									<option><%=state%></option>
								<%}else
								{
								%>
									<option value="">Select State</option>
									<%} %>
								</select>
								</section>
								<section class="col-md-2">
								<abbr title="Type Your City">
								<select id="state1" name="state1" class="form-control underlined">
								<%
									if(!district.equals("NA"))
									{%>
										<option><%=district%></option>
									<%}else
									{
								%>
									<option value="">Select Distict</option>
								<%} %>
								</select>
									
					
								</abbr>
								</section>
								<section class="col-md-2">
								<select name="vehicletype" class="form-control underlined" id="vehicletype">
									<%
								if(!vehicletype.equals("NA"))
								{%>
									<option><%if(vehicletype.equals("4,")){out.println("FOUR WHEELER");}else if(vehicletype.equals("2,")){out.println("TWO WHEELER");}else {out.println("ALL");}%></option>
								<%}else{%>
									<option value="">Vehicle Type</option>
									<%} %>
									<option>ALL</option>
									<option value="4,">FOUR WHEELER</option>
									<option value="2,">TWO WHEELER</option>
								</select>
								</section>
								<section class="col-md-2">
								<input type="text" name="mailid" id="mailid" class="form-control underlined" placeholder="e-mail">
								</section>
								<section class="col-md-2">
								<input type="text" name="mobile" id="mobile" class="form-control underlined" placeholder="mobile">
								</section>
								<section class="col-md-2">
								<input class="btn-primary btn-sm" type="submit" value="Search">
								</section>
								</form>
							<!-- Search ending -->
						</div><br><br><br>  
						<%
							String message = (String)request.getAttribute("message"); 
							String msgColor = (String)request.getAttribute("msgColor"); 
							if(message!=null && msgColor.equals("red")){
								%>
							<h5 style="color:red" align="center"><%=message%></h5>
						<%} else if(message!=null && msgColor.equals("green")){
							%>
						<h5 style="color:green" align="center"><%=message%></h5>
					<%}%><br>
						
							<div class="col-md-12" style="font-family: 'Roboto', sans-serif; background-color: #fff; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
								<section class="col-md-2" style="font-size: 14px;"><strong>NAME</strong></section>
								<section class="col-md-4 " style="font-size: 14px;"><strong>EMAIL ID</strong></section>
								<section class="col-md-2" style="font-size: 14px;"><strong>MOBILE</strong></section>
								<section class="col-md-2"  style="font-size: 14px;"><strong>PANCARD NO.</strong></section>
								<section class="col-md-2"  style="font-size: 14px;"><strong>STATUS</strong></section>
						</div>
						<%
						while(itr.hasNext()){
							BusinessOwnerRegister bo=(BusinessOwnerRegister)itr.next();
						%>
						<div class="col-md-12"
							style="font-family: 'Roboto', sans-serif; border-radius: 4px; margin-bottom: 7px; position: relative; right: 20px;">
							<section class="col-md-2" style="font-size: 14px;"><u><a href="./emUpdateBSOwner.jsp?k=UD&boid=<%=bo.getSEQUENTIAL_NO()%>"><%=bo.getNAME()%></a></u></section>
							<section class="col-md-4" style="font-size: 14px;"><strong><%=bo.getEMAIL_ID()%></strong></section>
							<section class="col-md-2" style="font-size: 14px;"><%=bo.getMOBILE_NO()%></section>
							<section class="col-md-2" style="font-size: 14px;"><%=new VerifyFieldsUtil().verifyString(bo.getPANCARD_NO())%></section>
							<section class="col-md-2" style="font-size: 14px;">
							
							<form action="./EMAIBsOwner" method="post">
								<input type="hidden" name="emailId" value="<%=bo.getEMAIL_ID()%>">
								<input type="hidden" name="country1" value="<%=state%>">
								<input type="hidden" name="state1" value="<%=district%>">
								<input type="hidden" name="mobile" value="<%=mobile%>">
								<input type="hidden" name="mailid" value="<%=mailid%>">
								<input type="hidden" name="vehicletype" value="<%=vehicletype%>">
								<input type="hidden" name="userType" value="UD">
								<input type="hidden" name="status" value="<%=bo.getSTATUS()%>">
								<input type="hidden" name="page" value="<%=page1%>">
								<%
									if(bo.getSTATUS().equals("ACTIVE")){
								%>	
								<td colspan="25" align="right">
									<input type="submit" class="btn btn-primary active" style="border-radius: 10px" value="<%=new VerifyFieldsUtil().verifyString(bo.getSTATUS())%>">
								</td>
								<%	
									}else{%>
									<td colspan="25" align="right">
										<input type="submit" class="btn btn-warning" style="border-radius: 10px" value="<%=new VerifyFieldsUtil().verifyString(bo.getSTATUS())%>">
									</td>
								<% }%>
							</form></section>
						</div>
						<%} %>
						<div>Pages <c:forEach begin="1" end="${numofpages}" var="x">
				<td><a href="./EMSearchBSOwner?country1=<%=state%>&state1=<%=district%>&mailid=<%=mailid%>&mobile=<%=mobile%>&vehicletype=<%=vehicletype%>&k=UD&page=${x}">${x}</a></td>
			</c:forEach></div>
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
			populateCountries("country1", "state1");
		</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>