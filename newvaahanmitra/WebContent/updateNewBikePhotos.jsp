
<%
	try {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if (session.getAttribute("user") == null) {
%>
<jsp:forward page="./login3.jsp"></jsp:forward>
<%
	} else {
		}
	} catch (Exception ex) {
		out.println(ex);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<jsp:include page="./AdminMenu.jsp" />
<jsp:include page="./Admin-right-side.jsp" />

<script src="./css/countries.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
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
		label, .control-label {
    font-weight: inherit;
    float: left;
    font-size: 15px;
    font-family: sans-serif;
    line-height: 7px;
    color: #5e6061; 
}
.form-control {
    display: block;
    width: 100%;
    height: 30px;
    /* padding: 6px 12px; */
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
#b1{
    border: 1px solid #fff;
    border-radius: 5px;
    }
    h4{
    font-size:23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    
    }
    .form-control.boxed {
    border-radius: 0;
    box-shadow: none;
    border-radius: 3px;
    line-height: 15px;
    font-size: 13px;
}
.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:300px;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
      width:300px;
     text-align: center;
}
h4 {
    font-size: 23px;
    color: #efa844;
    font-weight: 500;
    font-family: sans-serif;
    text-align: center;
}
@media  (max-width:767px){

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
    color: #fff;
    cursor: default;
    background-color: #523f6d;
    border: 1px solid #523f6d;
    border-bottom-color: transparent;
    font-size: 21px;
    line-height: 15px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
     width:100%;
     text-align: center;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.42857143;
    border: 1px solid transparent;
    border-radius: 4px 4px 0 0;
    background: #f5f5f5;
    color: #000;
    line-height: 14px;
     border-top-left-radius: 5px;
    border-top-right-radius: 5px;
   width:100%;
   text-align: center;
}


}
ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		ul.tabs li{
			background: none;
			color: #222;
			display: inline-block;
			padding: 10px 15px;
			cursor: pointer;
		}

		ul.tabs li.current{
			background: #ededed;
			color: #222;
		}
ul.tabs li.current {
    background: #523f6d;
    color: #222;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
}
ul.tabs li {
 background: #8b9cb1;
    border-radius: 7px 7px 0 0;
    line-height: 14px;
    padding: 10px 52px 10px 52px;
    border: 1px solid #fff;
    color: #222;
    display: inline-block;
    cursor: pointer;
}
		.tab-content{
			display: none;
			
			padding: 15px;
		}

		.tab-content.current{
			display: inherit;
		}
		.c-1{
		color:#fff !important;
		}
		.app .content {
    padding: 74px 30px 90px 20px;
    min-height: 100vh;
}
#one{
    border: 1.6px solid #eceeef;
    border-radius: 4px;
    padding: 15px 5px 20px 4px;
        width: 100%;
    }
    #one:hover{
    border: 1.6px solid #eceeef;
    border-radius: 4px;
    padding: 15px 5px 20px 4px;
    box-shadow: 2px 0px 13px #ccc;
        width: 100%;
    }
	</style>	
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">

				<header class="">
			<div class="header-block header-block-nav"></div>
			</header>
			<br>

				<article class="content responsive-tables-page" style="background-color:#fff">
				<section class="section">
				<div class="row">
				<h3 style="text-align: center; font-size: 33p">UPDATE BIKE PHOTOS</h3>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="card" style="background: #fff; border-radius: 5px; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
							<div class="" style="padding-left: 0px;">
							<section class="example">
							<div class="table-responsive" style="overflow: hidden;">
								<form action="./UpdateNewBikePhotos" enctype="multipart/form-data"
									method="post">
									<div class="col-md-12 col-xs-12" style="padding-left: 0px;">
										<div align="center" style="text-align: center; color: #fff;">
											
											<%
												String message = (String) request.getAttribute("message");
												String bikeNo  = (String) request.getAttribute("bikeNo");
							      				ArrayList<AddBike> b_details = new ArrayList<AddBike>();
											    AddBikeDao dao = new AddBikeDaoImpl();
									         	b_details = dao.getBikeDetailsByVariantName(bikeNo);
										     	int count = b_details.size();
												if(count==0){
											%>
											
											
												</div>
									</div>
							
									<div class="col-md-12">
										
									</div>
									<div class="col-md-6 col-sm-12 col-xs-12" style="    margin: 7px 20px;">
										<span style=" font-size: 19px;font-weight: 500;">BIKE REGISTRATION NO :</span>
										<span style=" font-size: 18px;font-weight: 500; font-size: 19px;color: #ff4444;"><%=bikeNo%></span>
									</div>
									
									<div class="col-md-12 col-xs-12" style=" padding-left: 0px;">
										<div class="card">
											<div class="card-block">
												<div id="printableArea">
													<input type="hidden" name="bikeNo" value="<%=bikeNo%>">
													<input type="hidden" name="page" value="ADD">
													<div class="col-md-12">
													<h6 style="color:red">Upload image with Height and Width must not exceed  350px and 500px.</h6>
													
													</div>
														
										<div class="col-md-12" style="padding:0 0;">
										<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;"> 
											<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;">
											
											<div class="col-md-3 col-xs-12" style="padding:0 0;">
											 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" src="data:image/png;base64, alt="Profile pic" src="#" name="photo_1" id="photo_1"  style="width: 100%;">
														
														</div>
														
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_1(this);" name="photo_1"/>			
										                  	<input type="hidden"   name="photo_1.1"/>
																
																
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_2" id="photo_2" >
														
														</div>
														
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_2(this);"  name="photo_2"/>			
											                <input type="hidden"   name="photo_2.1"/>
														</div>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_3" id="photo_3" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_3(this);"  name="photo_3"/>			
									              		    <input type="hidden"   name="photo_3.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_4" id="photo_4" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_4(this);"  name="photo_4"/>			
									              		    <input type="hidden"   name="photo_4.1"/>
														</div>
														</div>
														</div>
														
														
												</div>
												
												<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;  margin: 12px 0;">
												<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_5" id="photo_5" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_5(this);"  name="photo_5"/>			
									              		    <input type="hidden"   name="photo_5.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_6" id="photo_6" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_6(this);"  name="photo_6"/>			
									              		    <input type="hidden"   name="photo_6.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_7" id="photo_7" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_7(this);"  name="photo_7"/>			
									              		    <input type="hidden"   name="photo_7.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_8" id="photo_8" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_8(this);" name="photo_8"/>			
									              		    <input type="hidden"   name="photo_8.1"/>
														</div>
														</div>
														</div>
												
												         </div>
												         
												         <div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;  margin: 12px 0;">
												<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_9" id="photo_9" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_9(this);"  name="photo_9"/>			
									              		    <input type="hidden"   name="photo_9.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64," alt="Profile pic" src="#" name="photo_10" id="photo_10" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_10(this);"  name="photo_10"/>			
									              		    <input type="hidden"   name="photo_10.1"/>
														</div>
														</div>
														</div>
														
														
														
												
												         </div>
												         
												
								                 	    </div>
													
													<div class="col-md-12 col-xs-12">
													
													<div class="col-md-5 col-xs-12"></div>
													<div class="col-md-2 col-xs-12">
													<button type="submit" onclick="return(svalidate())" class="btn btn-primary btn-block" style="    border: 1px solid #fff;
                                             border-radius: 5px;">SUBMIT</button>
													</div>
													<div class="col-md-5 col-xs-12"></div>
													</div>
											
											
											
											
											<%}else{Iterator it = b_details.iterator();
																while (it.hasNext()) {
															
																		AddBike ab = (AddBike) it.next();
															%>
														
										</div>
									</div>
							
									<div class="col-md-12">
										
									</div>
									<div class="col-md-6 col-sm-12 col-xs-12" style="    margin: 7px 20px;">
										<span style=" font-size: 19px;font-weight: 500;">BIKE REGISTRATION NO :</span>
										<span style=" font-size: 18px;font-weight: 500; font-size: 19px;color: #ff4444;"><%=bikeNo%></span>
									</div>
									
									<div class="col-md-12 col-xs-12" style=" padding-left: 0px;">
										<div class="card">
											<div class="card-block">
												<div id="printableArea">
													<input type="hidden" name="bikeNo" value="<%=bikeNo%>">
													<input type="hidden" name="page" value="UPDATE">
													<div class="col-md-12">
													<h6 style="color:red">Upload image with Height 350px and Width must not exceed 500px.</h6>
													
													</div>
														
										<div class="col-md-12" style="padding:0 0;">
										<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;"> 
											<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;">
											
											<div class="col-md-3 col-xs-12" style="padding:0 0;">
											 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" src="data:image/png;base64,<%=ab.getPHOTO1()%>" alt="Profile pic" src="#" name="photo_1" id="photo_1"  style="width: 100%;">
														
														</div>
														
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_1(this);" value="<%=ab.getPHOTO1()%>" name="photo_1"/>			
											<input type="hidden"  value="<%=ab.getPHOTO1()%>" name="photo_1.1"/>
																
																
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO2()%>" alt="Profile pic" src="#" name="photo_2" id="photo_2" >
														
														</div>
														
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_2(this);" value="<%=ab.getPHOTO2()%>" name="photo_2"/>			
											                <input type="hidden"  value="<%=ab.getPHOTO2()%>" name="photo_2.1"/>
														</div>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO3() %>" alt="Profile pic" src="#" name="photo_3" id="photo_3" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_3(this);" value="<%=ab.getPHOTO3()%>" name="photo_3"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO3()%>" name="photo_3.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO4() %>" alt="Profile pic" src="#" name="photo_4" id="photo_4" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_4(this);" value="<%=ab.getPHOTO3()%>" name="photo_4"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO4()%>" name="photo_4.1"/>
														</div>
														</div>
														</div>
														
														
												</div>
												
												<div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;  margin: 12px 0;">
												<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO5() %>" alt="Profile pic" src="#" name="photo_5" id="photo_5" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_5(this);" value="<%=ab.getPHOTO5()%>" name="photo_5"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO5()%>" name="photo_5.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO6() %>" alt="Profile pic" src="#" name="photo_6" id="photo_6" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_6(this);" value="<%=ab.getPHOTO6()%>" name="photo_6"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO6()%>" name="photo_6.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO7() %>" alt="Profile pic" src="#" name="photo_7" id="photo_7" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_7(this);" value="<%=ab.getPHOTO7()%>" name="photo_7"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO7()%>" name="photo_7.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO8() %>" alt="Profile pic" src="#" name="photo_8" id="photo_8" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_8(this);" value="<%=ab.getPHOTO8()%>" name="photo_8"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO8()%>" name="photo_8.1"/>
														</div>
														</div>
														</div>
												
												         </div>
												         
												         <div class="col-md-12 col-sm-12 col-xs-12" style="padding:0 0;  margin: 12px 0;">
												<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO9() %>" alt="Profile pic" src="#" name="photo_9" id="photo_9" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_9(this);" value="<%=ab.getPHOTO9()%>" name="photo_9"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO9()%>" name="photo_9.1"/>
														</div>
														</div>
														</div>
														
														<div class="col-md-3 col-xs-12" style="padding:0 0;">
														 <div class="col-md-3 col-xs-12" id="one">
														<div class="col-md-12 col-xs-12" style="padding: 0 0;">
															<%-- <input type="file" name="photo1" accept="image/*" required
																onchange="return svalidate('file1')" value="<%=ab.getPHOTO1() %>" id="file1"
																placeholder="Select Image" required> --%>
																<img class="img-responsive" style="width: 100%;" src="data:image/png;base64,<%=ab.getPHOTO10() %>" alt="Profile pic" src="#" name="photo_10" id="photo_10" >
														
														</div>
														<div class="col-md-12 col-sm-12 col-xs-12"  style="padding: 0 0; margin: 0 0px">
															<input type='file' onchange="readphoto_10(this);" value="<%=ab.getPHOTO10()%>" name="photo_10"/>			
									              		    <input type="hidden"  value="<%=ab.getPHOTO10()%>" name="photo_10.1"/>
														</div>
														</div>
														</div>
														
														
														
												
												         </div>
												         
												
								                 	    </div>
													
													<div class="col-md-12 col-xs-12">
													
													<div class="col-md-5 col-xs-12"></div>
													<div class="col-md-2 col-xs-12">
													<button type="submit" onclick="return(svalidate())" class="btn btn-primary btn-block" style="    border: 1px solid #fff;
                                             border-radius: 5px;">SUBMIT</button>
													</div>
													<div class="col-md-5 col-xs-12"></div>
													</div>
													
													<div class="col-md-12" align="center">
													
														<%
																}	if (message != null) {
														%>
														<h5 style="color: #ff5400">
															<%=message%>
														</h5>
														<%
															} else {
															}}
														%>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- /page content --> <!-- footer content --> <footer class="footer">
			<div class="footer-block buttons"></div>
			<div class="footer-block author">
				<ul>
					<li>created by <a href="#">Kosuri Soft Pvt Ltd</a>
					</li>
					<li><a href="www.kosurisoft.com">get in touch</a></li>
				</ul>
			</div>
			</footer>
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
	<script>
		function svalidate(id) {
			var fileUpload = document.getElementById(id);
		    //Check whether the file is valid Image.
		    var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(.jpg|.png|.gif)$");
		    if (regex.test(fileUpload.value.toLowerCase())) {
		 
		        //Check whether HTML5 is supported.
		        if (typeof (fileUpload.files) != "undefined") {
		            //Initiate the FileReader object.
		            var reader = new FileReader();
		            //Read the contents of Image File.
		            reader.readAsDataURL(fileUpload.files[0]);
		            reader.onload = function (e) {
		                //Initiate the JavaScript Image object.
		                var image = new Image();
		 
		                //Set the Base64 string return from FileReader as source.
		                image.src = e.target.result;
		                       
		                //Validate the File Height and Width.
		                image.onload = function () {
		                    var height = this.height;
		                    var width = this.width;
		                    if (height > 350 || width > 500) {
		                    	document.getElementById(id).value = '';
		                        alert("Upload image with Height 350px and Width must not exceed 500px.");
		                        return false;
		                    }
		                    return true;
		                };
		 
		            }
		        } else {
		            alert("This browser does not support HTML5.");
		            return false;
		        }
		    } else {
		        alert("Please select a valid Image file.");
		        return false;
		    }
		}
	</script>
			 <script type="text/javascript">


function readphoto_1(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#photo_1')
                .attr('src', e.target.result)
                .min-width(150)
                .min-height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
    
    }
    
    function readphoto_2(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_2')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_3(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_3')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_4(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_4')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_5(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_5')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_6(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_6')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_7(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_7')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_8(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_8')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_9(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_9')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
    function readphoto_10(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#photo_10')
                    .attr('src', e.target.result)
                    .min-width(150)
                    .min-height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }

}
</script>
</body>
</html>