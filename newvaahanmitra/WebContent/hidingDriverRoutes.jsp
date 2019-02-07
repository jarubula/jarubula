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
<jsp:include page="./topMenu1.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra | Driver Routes</title>
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
	<script
  src="https://code.jquery.com/jquery-2.1.3.js"
  integrity="sha256-goy7ystDD5xbXSf+kwL4eV6zOPJCEBD1FBiCElIm+U8="
  crossorigin="anonymous"></script>
<script type="text/javascript">

$(document).ready(function () {

    var hideOptions = function () {
        var $select = $('select');
        $select.find('option').show();
        $select.each(function () {
            var $this = $(this);
            var value = $this.val();
            var $options = $this.parents('table').find('select').not(this).find('option');
            var $option = $options.filter('[value="' + value + '"]');
            if (value) {
                $option.hide();
                $option.each(function () {
                    if (this.defaultSelected) {
                        $(this).parent('select').val('');
                    }
                });
            }
        });
    }

    hideOptions();

    $('select').on('change', function () {
        hideOptions();
    });
});

</script>

	<style>
	 :required:focus {
	   box-shadow: 0  0 6px rgba(255,0,0,0.5);
	   border: 1px red solid;
	   outline: 0;
	 }
	</style>

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
			<article class="content responsive-tables-page" style="background-color:#fff"> 
			<section class="section">
			<div class="row">
				<div class="col-md-12">
					<div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								
									
									
	
<form action="./InsertDriverPreferredRoutes" method="post">									

<div class="col-md-12" style="background: #523f6d;color: #fff;text-align: center;font-weight: bolder;height:44px;margin-top:8px;padding: 10px;"><span style="margin-top:8px;">Update Permit Type</span></div>


<div class="col-md-12 col-xs-12 col-sm-12" align="left">
<div class="form-group">
If You Want To Add Preferred Routes Please Select Other State
</div>
</div><br>

<div class="col-md-3 col-xs-12 col-sm-12">
<label for="exampleInputEmail1">PERMIT TYPE</label>
</div>

<div class="col-md-3 col-xs-12 col-sm-12" align="center">
<div class="form-group">
<select name ="permitType" id="selector1" class="form-control input-sm" required>
<option value="">SELECT PERMIT TYPE</option>
<option>Within State</option>
<option>Other State</option>
</select>
</div>
</div>

<div class="col-md-3 col-xs-12 col-sm-12" align="center">
															
															
<div class="form-group"><input type="submit" value="Submit" class="btn btn-primary"/></div>
															
</div> 
<div class="col-md-3"></div>

								
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
	<script language="javascript">
		populateBrands("brand", "model");
 	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>

</html>