<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Vaahanmitra | Login</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
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
        <div class="auth">
            <div class="auth-container" style="box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);">
                <div class="card">
                    <header class="auth-header">
                        <h1 class="auth-title">User Login</h1> </header>
                    <div class="auth-content">
                        <form id="signup-form" action="./LoginController" method="post" novalidate="">
							<div class="form-group"> <label class="control-label"></label> <input type="hidden" name="name" class="form-control boxed"></div>
							<div class="form-group"> <label class="control-label">EMAIL ADDRESS</label> <input type="text" name="email" class="form-control boxed" placeholder="Enter EmailId" required> </div>
                            <div class="form-group"> <label class="control-label">PASSWORD</label> <input type="password" name="password" class="form-control boxed" placeholder="Enter Password" required> </div>
                            <div class="form-group"> <label for="agree">
                                <span><a href="#">Forgot Password</a></span>
                                </label> </div>
                            <div class="form-group"> <button type="submit" class="btn btn-block btn-primary">LOGIN</button> </div>
                            <div class="form-group">
                                <p class="text-muted text-xs-center">If you are new USER Click on<a href="registration.jsp">Registration</a></p>
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
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>

</html>