<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>VAAHANMITRA | Dashbord</title>
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
    <% HttpSession sion = request.getSession(false);
    	String str = (String)sion.getAttribute("user"); %>
        <div class="main-wrapper">
            <div class="app" id="app">
                <nav id="mainNav" class="navbar navbar-fixed-top" style="background:#523f6d;">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="index.html">
                           <h2 style="color:#fff; margin-top:0px; font-weight:600; margin-left:-75px;">Vaahan<span style="margin-left:2px; color:#fec107;">Mitra</span></h2>
                        </a>
                    </div>
                    <div>	<b style="color:white;margin-left: 740px"><%= str %></b> &nbsp &nbsp 
                            <b><a href="./logout.jsp" style="margin-left: 800px;color:#fec107;">LOGOUT</a></b>
                    </div> <!-- /.navbar-collapse --> 
                </div> <!-- /.container --> 
            </nav>
                
                <header class="header"> 
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button> </div>
                    
                <div class="header-block header-block-nav">
                        <ul class="nav-profile">
                            <li class="profile dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="img" style=""> </div> 
<%--                                     <span class="name"><%= str %> </span> </a> --%>
                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                   
                                    <a class="dropdown-item" href="#"> <i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <article class="content dashboard-page" style="background-color:#fff">
                    
                    
                    <section class="section map-tasks" style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0,0,0,0.15);border-bottom: 3px solid #a3b745;">
                        <div class="row sameheight-container">
                            <div class="col-md-12">
                                <div class="card sameheight-item" data-exclude="xs,sm">
                                    <div class="card-header" >
                                        <div class="header-block">
                                            <h3 class="title">Tracking By Country</h3> </div>
                                    </div>
                                    <div class="card-block">
                                        <div id="dashboard-sales-map" style="width: 100%; height: 400px;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </article>
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
    </body>

</html>