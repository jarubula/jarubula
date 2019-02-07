<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>VaahanMitra | Dashbord</title>
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
    <% 
    String str=null;
   // session.setAttribute("user","Mahesh Babu");
    try
    {
    if(session.getAttribute("user").toString()==null)
	{
	System.out.println("user null");
	%>
	<jsp:forward page="./login3.jsp"/>
	<%}
    else
    {
    	str=session.getAttribute("user").toString();
    }
    }
    catch(Exception e)
    {%>
    	<jsp:forward page="./login3.jsp"/>
    <%}
	%>
        <div class="main-wrapper">
            <div class="app" id="app">
                
               <header class="header" style="background-color: #523f6d;">
				
                    <div class="header-block header-block-collapse hidden-lg-up"> 
                    <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		  </button>
			  </div>
                    
                 <div class="header-block header-block-nav">
				<%--  <% HttpSession sion = request.getSession(false);
    				String str = (String)sion.getAttribute("user"); %> --%>
                        <ul class="nav-profile">
                            
                            <li class=" dropdown">
                               <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="img" > </div> <span class="name" style="color:white;"> <%= str %> </span></a>
                                <div class="dropdown-content" id="h" aria-labelledby="dropdownMenu1">
                                   <a style="display-none;" class="dropdown-item" href="./logout.jsp"><i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
        		<div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
		<footer class="footer">
                    <div class="footer-block buttons"></div>
                    <div class="footer-block author">
                        <ul>
                            <li> created by <a href="#">Kosuri Soft Pvt Ltd</a> </li>
                            <li> <a href="www.kosurisoft.com">get in touch</a> </li>
                        </ul>
                    </div>
                </footer>
				</div>
				</div>
				</body>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>

</html>