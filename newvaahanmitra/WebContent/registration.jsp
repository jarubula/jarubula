<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./css/countries.js" type="text/javascript"></script>
<title>Vaahanmitra | Register</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<script language="javascript">
function validate()
{
	if(document.getElementById("panno").value.length !=8 )
	{
		alert("Please enter 8 digits in PANno.");
		document.getElementById("panno").focus();
		return false;
	}
	if(document.getElementById("mobileNo").value.length !=10 )
	{
		alert("Please enter 10 digits Mobile No");
		document.getElementById("mobileNo").focus();
		return false;
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

        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Registration</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
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
</head>
<body>
 <%String message =(String)request.getAttribute("existemail"); %>
        <div class="auth">
            <div class="auth-container" style="position: absolute;top: 98%;left: 50%; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);"">
                <div class="card">
                    <header class="auth-header">
                        <h1 class="auth-title">Registration</h1>
                     <% if(message!=null){%>
                    	<h4 style="color:red"><%= message %> </h4>    
              <%}else{}%>
                    </header>
                    <div class="auth-content">
                        <form action="./registrationController" name="frm" method="post" onSubmit="return validate()">
                            <div class="form-group"> <label class="control-label">FIRST NAME</label> <input type="text" name="firstName" class="form-control boxed" placeholder="Enter First Nmae" required> </div>
                            <div class="form-group"> <label class="control-label">lAST NAME</label> <input type="text" name="lastName" class="form-control boxed" placeholder="Enter Last Name" required> </div>
                            <div class="form-group"> <label class="control-label">GENDER</label>
                                    <div> <label>
			                    <input class="radio squared"  name="gender" value="MALE" type="radio" required>
			                    <span>MALE</span>
			                </label> <label>
			                    <input class="radio squared"  name="gender" value="FEMALE" type="radio" required>
			                    <span>FEMALE</span>
			                </label> </div>
                                </div>
                            <div class="form-group"> <label class="control-label">E-MAIL</label> <input type="email" autocomplete="off" name="emailId" class="form-control boxed" placeholder="Enter Email" required> </div>
                            <div class="form-group"> <label class="control-label">PHONE NO</label> <input type="text" name="phoneNo" id="mobileNo" onkeypress="CheckNumeric(event)" required placeholder="Enter 10 Digits Mobile No" class="form-control boxed"> </div>
                            <div class="form-group"> <label class="control-label">PANCARD NO</label> <input type="text" name="panno" id="panno" class="form-control boxed" required placeholder="Enter Pancard number"> </div>
                            <div class="form-group"> <label class="control-label">ADDRESS</label> <input type="text" name="address" class="form-control boxed" placeholder="Enter Address" required> </div>
                            <div class="form-group"> <label class="control-label">CITY</label> <input type="text" name="city" class="form-control boxed" placeholder="Enter City" required> </div>
                            <div class="form-group"> <label class="control-label">STATE</label>
							<tr>
								<td>
									<div class="form-group">
										<select id="country" name="country"
											class="form-control form-control-sm" required>
											<option value="">Select State</option>
										</select>
									</div>
								</td>
								<div class="form-group"> <label class="control-label">DISTRICT</label>
								<td>
									<div class="form-group">
										<select id="state" name="state"
											class="form-control form-control-sm" required>
											<option value="">Select District</option>
										</select>
									</div>
								</td>
							</tr>
                            <div class="form-group"> <label class="control-label">PASSWORD</label> <input type="password"  name="password" class="form-control boxed" placeholder="Enter 8 digits Password" required> </div>
                            <div class="form-group"> <button type="submit" class="btn btn-block btn-primary">SUBMIT</button> </div>
                            <div class="form-group">
                                <p class="text-muted text-xs-center">Already you have an account<a href="login.jsp">LOGIN</a></p>
                            </div>
                        </form>
                    </div>
                </div>
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
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>

</html>