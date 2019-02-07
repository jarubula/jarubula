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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.vaahanmitra.service.*,com.vaahanmitra.model.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="./css/countries.js" type="text/javascript"></script>
	<jsp:include page="./employeeMenu.jsp"/>
	<jsp:include page="./topMenu.jsp"/>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Vaahanmitra | AddServiceCentre</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
        <script language="javascript">
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
        <script src="./css/countries.js" type="text/javascript"></script>
	<script language="javascript">
 	function validate() {
 		if(document.getElementById("pincodeNo").value!="")
 			{
 		if(document.getElementById("pincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits PINCODE No");
		  document.getElementById("pincodeNo").focus();
		  return false;
		 }
 			}
 		if(document.getElementById("phoneNo").value.length !=11 )
		 {
		  alert("Please enter 11 digits PHONE No.");
		  document.getElementById("phoneNo").focus();
		  return false;
		 }
 		if(document.getElementById("bpincodeNo").value.length !=6 )
		 {
		  alert("Please enter 6 digits BUSINESS PINCODE No");
		  document.getElementById("bpincodeNo").focus();
		  return false;
		 }
 		if(document.getElementById("mobileNo").value!="" )
		 {
 		if(document.getElementById("mobileNo").value.length !=10 )
		 {
		  alert("Please enter 10 digits PHONE No.");
		  document.getElementById("mobileNo").focus();
		  return false;
		 }
		 }
 		return true;
 	}

	function CheckNumeric(e) {
		  
	    if (window.event) // IE 
	    {
	        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
	            event.returnValue = false;
	            return false;

	        }
	    }
	    else { // Fire Fox
	        if ((e.which < 48 || e.which > 57) & e.which != 8) {
	            e.preventDefault();
	            return false;

	        }
	    }
	}
	</script>
    </head>

    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
                
                
                <header class="header">
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button> </div>
                    
                <div class="header-block header-block-nav">
                    </div>
                </header>
                <%
                String key = request.getParameter("k");
                String boid = request.getParameter("boid");
            	if((key==null || key.equals("null"))){
            		key = (String)request.getAttribute("k");
            		/* int bid = (Integer)request.getAttribute("boid"); */
            	}
            	String message = (String)request.getAttribute("message");
                /* String key=request.getParameter("k"); */
                BusinessOwnerService bo=new BusinessOwnerService();
                BusinessOwnerRegister bor=bo.getBOProfileDetails(boid);
                System.out.println(bor);
                %>
                
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <article class="content responsive-tables-page" style="background-color:#fff">
                    <section class="section">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- <div class="card" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
                                    <div class="card-block" style="border-bottom: 3px solid #a3b745;">
                                    </div>
                                </div> -->
                                        <section class="example">
                                            <div class="table-responsive">
                             <form name="frm" action="./UpdateBSOwnerProfile" method="post" onSubmit="return validate()" enctype="multipart/form-data">
                                              <div class="container col-lg-10 col-md-10 col-sm-12 col-xsm-12"> 
                                              <div class="form-group">
                                              <%
										if (message != null) {
									%>
									<h5 style="color: orange" align="center"><%=message%></h5>
									<%
										} else {
										}%>
                              <div class="col-sm-12"> 
								<%if(key.equals("SC")){%>
                                 <label for="email"><strong><u><i>Update Service Centre</i></u></strong></label>
                            	<%}else if(key.equals("UD")){ %>
                            	<label for="email"><strong><u><i>Update Dealer</i></u></strong></label>
                            	<%}else if(key.equals("SP")){ %>
                            	<label for="email"><strong><u><i>Update Spare Part Shop</i></u></strong></label>
                            	<%}%>
                            </div>
                              </div>
                              <div class="form-group">
                              <%-- <div class="col-sm-12"> 
                                 <label for="email"><%try{if(request.getAttribute("message")!=null){out.println(request.getAttribute("message"));}}catch(Exception e){} %></label>
                            					</div>
                              </div> --%>
                              <div class="form-group"> 
                              <div class="col-sm-6"> 
                                 <label for="email">BUSINESS NAME <span style="color: red">*</span></label>
                                 <input type="hidden" name="boid" value="<%=boid%>">
                                 <input type="hidden" name="userType" value="<%=key%>">
                                 <input type="text" class="form-control underlined" name="businessName" value="<%=bor.getBUSINESS_NAME()%>" required placeholder="Enter Business Name">
                                 </div>
                              </div> <div class="col-sm-12"></div>
                           	  <div class="form-group">
                                        <div class="col-sm-6"> 
                                        <label for="password">PANCARD NO</label>
                                            <input type="text" class="form-control underlined" value="<%=bor.getPANCARD_NO() %>" name="pancardNo" placeholder="Enter Pancard No."> 
                                        </div>
                                    
                                   <div class="form-group">
                                   <div class="col-sm-6">
                              	
                              <img src="data:image/png;base64,<%=bor.getPHOTO()%>" class="img-thumbnail"
														alt="No image" width="150px" height="120px"> <input
														type="file" value="update" name="photo" accept="image/*"required">
													<input type="hidden" name="image" value="<%=bor.getPHOTO()%>">
									<br>				
								</div>
                                   
                                   </div>    
                                    </div>
                                    <div class="col-md-12 col-xs-12"></div>
                                    <div class="form-group">
                                    <div class="col-sm-6"> 
                                        <label for="password">GST NO</label>
                                            <input type="text" class="form-control underlined" value="<%=bor.getGSTNO()%>" name="GSTNo" placeholder="Enter GST No."> 
                                        </div>
                                        
                                        
                                        <div class="col-sm-6"> 
                                        <label for="password">VEHICLE TYPE</label><br>
										<%
										System.out.println(bor.getVEHICLE_TYPE());
										if(bor.getVEHICLE_TYPE().equals("4,")){ %>                                        	
                                            <input type="checkbox" class="" name="vehicletype" value="4" checked>FOUR WHEELER
                                            <input type="checkbox" class="" name="vehicletype" value="2">TWO WHEELER
                                            <%} else if(bor.getVEHICLE_TYPE().equals("2,")){ %>                                        	
                                            <input type="checkbox" class="" name="vehicletype" value="4">FOUR WHEELER
                                            <input type="checkbox" class="" name="vehicletype" value="2" checked>TWO WHEELER
                                            <%} else  if(bor.getVEHICLE_TYPE().equals("4,2,")){ %>                                        	
                                            <input type="checkbox" class="" name="vehicletype" value="4" checked>FOUR WHEELER
                                            <input type="checkbox" class="" name="vehicletype" value="2" checked>TWO WHEELER
                                            <%}%>  
                                        </div>
                                    
                                    </div>
                                    
                               <div class="form-group">
                                        <div class="col-sm-12"> 
                                            <label><strong><u><i>BUSINESS ADDRESS</i></u></strong></label>
                                        </div>
                               </div>
                                <div class="form-group">
                                        <div class="col-sm-6"> 
                                            <label>ADDRESS<span style="color: red">*</span></label>
                                             <input class="form-control underlined" type="text" placeholder="Enter Address" value="<%=bor.getADDRESS()%>" name="address" required >
                                        </div>
                                        <div class="col-sm-6"> 
                                            <label>LOCATION<span style="color: red">*</span></label>
                                             <input class="form-control underlined" type="text" placeholder="Location" value="<%=bor.getADDRESS()%>" name="location" required >
                                        </div>
                                        </div>
                                    <div class="form-group">   
                                     <div class="col-sm-6"> <label for="password">CITY<span style="color: red">*</span></label>
                                           <input type="text" class="form-control underlined" id="city" name="bcity" value="<%=bor.getB_CITY()%>" placeholder="Enter City" required>
                                        </div>
                                      <div class="col-sm-6"> 
                                 <label for="email">OFFICE PHONE NO.<span style="color: red">*</span></label>
                                  <input class="form-control underlined" type="text" required value="<%=bor.getOFFICE_PHONE_NO()%>" name="phoneNo" id="phoneNo" maxlength="11" placeholder="Enter Office Phone no."onkeypress="CheckNumeric(event)">
                              </div>
                              </div>
                              <div class="form-group">
                              
                               <div class="col-sm-6"> 
                                            <label>STATE<span style="color: red">*</span></label>
                                            <input type="hidden" name="state1" value="<%=bor.getSTATE() %>">
                                            <%=bor.getSTATE() %>
                                            <select class="form-control underlined"  id="country" name="state" required>
                                                    <option value="">Select State</option>                                     
                                            </select> 
                                        </div>
                               <div class="col-sm-6"> 
                                 <label for="email">DISTRICT<span style="color: red">*</span></label>
                                 <select class="form-control underlined" id="state" name="district" required>
                                 					<option><%=bor.getDISTRICT()%></option>
                                                     <option value="">Select District</option>                                                          
                                             </select> 
                              </div>
                              <div class="form-group">
                               <div class="col-sm-6"> 
                                 <label for="email">PINCODE<span style="color: red">*</span></label>
                                 <input class="form-control underlined" type="text" value="<%=bor.getOFFICE_PINCODE_NO()%>" placeholder="Enter Pincode no" name="bpinNo" required id="bpincodeNo" onkeypress="CheckNumeric(event)">
                              </div>
                              </div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-12"> 
                                            <label><strong><u><i>CONTACT INFORMATION</i></u></strong></label>
                                        </div>
                              </div>
                              <div class="form-group"> 
                              <div class="col-sm-6"> 
                                 <label for="email">NAME</label>
                                <input class="form-control underlined" type="text" value="<%=bor.getNAME()%>" placeholder="Enter Name" name="name" id="name">
                              </div>
                              <div class="col-sm-6"> 
                                 <label for="email">MOBILE</label>
                                 <input class="form-control underlined" type="text" value="<%=bor.getMOBILE_NO()%>" placeholder="Enter Mobile No." name="mobileNo" id="mobileNo" maxlength="10" onkeypress="CheckNumeric(event)"> 
                              </div>
                              </div>
                              <div class="form-group">
                              <div class="col-sm-6"> 
                                            <label>CITY</label>
                                            <input type="text" class="form-control underlined" id="city" name="city" value="<%=bor.getCITY()%>" placeholder="Enter City" required>
                                        </div>
                                        <div class="col-sm-6"> <label for="password">PINCODE</label>
                                               <input class="form-control underlined" value="<%=bor.getPINCODE_NO()%>" type="text" placeholder="Enter Pincode no" name="pinNo" id="pincodeNo" onkeypress="CheckNumeric(event)">
                                        </div>
                              </div>
                              <div class="form-group"> 
                              	<div class="col-sm-6">
                                 <label for="email">EMAIL</label>
                                 <input class="form-control underlined" value="<%if(bor.getEMAIL_ID().equals("-")){}else{out.println(bor.getEMAIL_ID());}%>" type="text" placeholder="Enter EmailId" name="email" id="email" required> 
                              </div>
                              <div class="col-sm-6"> 
                                 <label for="email">VERIFIED</label>
                                 <div style="text-align:left; ">
                                 <input type="radio" value="verified" name="verified" CHECKED> YES
                                 <input type="radio" value="NOTverified" name="verified"> NO</div>
                              </div> 
                              </div>
                              <div class="form-group"> 
                              	
								</div>
                             <div class="form-group">
                             
                                        <div class="col-sm-12 " align="center">
                                        <br>
                                         <button type="submit"  class="btn btn-primary rounded">UPDATE</button>
                                        </div>
                             </div>
                            </div>
                                                 </form>
                                            </div>
                                        </section>
                                        
                            </div>
                        </div>
                    </section>
                </article>
                <footer class="footer">
                    <div class="footer-block buttons"></div>
                    <div class="footer-block author">
                        <ul>
                            <li> created by <a href="#">Kosuri Soft Pvt Ltd</a> </li>
                            <li> <a href="www.kosurisoft.com">get in touch</a> </li>
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
			populateCountries("country", "state");
		</script>
		<script language="javascript">
			populateCountries("country1", "state1");
		</script>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>
</html>