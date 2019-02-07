<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<jsp:include page="./DriverMenu.jsp" />
<%-- <jsp:include page="./right-side.jsp" /> --%>
<jsp:include page="./topMenu1.jsp" />
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
	
	<style type="text/css">
::-webkit-scrollbar { 
    display: none; 
}
</style>
	

	
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">


			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<!-- <button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button> -->
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
				<%
               String message=(String)request.getAttribute("message");
                 String message1=(String)request.getAttribute("message1");
                      %>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page" style="background-color:#fff"> 
			<section class="section">
			
			<div class="row">
				<div class="col-md-12">
				     <%
            if(message!=null){
              %>
             <font color="red"><%=message %></font>
                <%
                 }else if(message1!=null){
                  %>
                        <font color="red"><%=message1 %></font>
                   <%	
                         }
                     %>
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./DriverChangePassword" method="post" onSubmit="return validateForm()">
					<div class="col-md-12" style="background: #052963;color: #fff;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;">
					CHANGE YOUR PASSWORD</div>
					<br>
					<br>
					<br>
				
<!--                       <tr> -->
<!--                  <td colspan="3"> -->
            
					<div class="col-md-3 col-xs-12 col-sm-6">
					<div class="form-group">
                  <label for="exampleInputEmail1">OLD PASSWORD</label>
                  <input type="password" class="form-control input-sm" name="psw1" id="oldpswd" placeholder="Old Password"/>
                     </div>
					
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
					<div class="form-group">
                  <label for="exampleInputEmail1">NEW PASSWORD</label>
                 <input type="password" class="form-control input-sm" name="psw2" id="newpswd" placeholder="New Password"/>
                    </div>
					
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
					<div class="form-group">
                    <label for="exampleInputEmail1">CONFIRM PASSWORD</label>
                    <input type="password" class="form-control input-sm" name="psw3"  id="conformpswd" required placeholder="Confirm Password"/>
                      </div>
					
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
					<br>
					
					<div class="form-group" style="position: relative;top:5px;"><input type="submit" value="Submit" class="btn btn-primary"/></div>
					
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
<script type="text/javascript">
function validateForm() {
 var oldpassword = document.getElementById("oldpswd").value;
    var password = document.getElementById("newpswd").value;
    var confirmPassword = document.getElementById("conformpswd").value;
    if (password != confirmPassword) {
        alert("NewPassword & ConformPassword doesn't not match...Please TryAgain");
        return false;
    }
    if(oldpassword==password){
     alert("OldPassword & NewPassword have matched");
     return false;
    }
    return true;
}
</script>
</body>

</html>