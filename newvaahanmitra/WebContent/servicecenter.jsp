<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*,java.text.SimpleDateFormat" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<style type="text/css">
 @media screen and (max-width: 780px) {
    #m1 {
        margin-bottom:4px;
    }
    
} 
.content {
    padding: 0px;
      background: #ffffff;
}
.navbar {
    position: relative;
    min-height: 50px;
    margin-bottom: 0px !important;
    border: 1px solid transparent;
}
</style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>VaahanMitra | service center</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
        <link href="http://www.vaahanmitra.com/servicecenter.jsp" rel="canonical" />
        <!-- Base Css -->
        <link href="assets/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/modalForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="./css/tcal.css" />
		<script type="text/javascript" src="./js/tcal.js"></script>
       <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
     <style>
     .panel-default>.panel-heading {
      color: #333;
      background-color: #f5f5f5;
      border-color: #f5f5f5;
      padding: 10px 9px;
      border-top-left-radius: 4px;
      border-top-right-radius: 4px;
      }
      .panel-title {
       margin-top: 0;
       margin-bottom: 0;
       font-size: 19px;
       color: #5074b8;
       text-decoration: none !important;
       font-family: unset;
       }
       a:focus {
       outline: 0px auto -webkit-focus-ring-color !important;
       outline-offset: -2px;
       }
       a:focus, a:hover {
       color: white;
       text-decoration: none !important;
       }
       p {
	    color: #8a8282;
	    line-height: 26px;
	    letter-spacing: 0.25px;
	    margin: 6px 6px;
	    font-size: 17px;
        } 
        .one1{
         margin-top: 19px;
         margin-bottom: 5px;
         font-size: 21px;
         color: #5074b8;
         text-decoration: none !important;
         font-family: unset;
         text-decoration: underline !important;
       } 
       .one2{
        color: #026dc1 !important;
        font-size: 18px;
       }
        .one2:hover{
        color: #026dc1 !important;
        font-size: 18px;
       }
       .one3{
        font-size: 18px;
       color: #026dc1 !important;
       }
     .sticky + .content {
    padding-top: 73px !important;
    }
     </style>
    </head>
    <body>
  
        <div class="se-pre-con"></div>
        <div id="page-content">
            <!-- navber -->
         <jsp:include page="./homeTop.jsp"></jsp:include>
            <div class="clearfix"></div>
         <div class="container" style="padding: 0 0px !importangt;">   
         <div class="col-md-12" style="padding: 0 0px !importangt;">
         <br>
         <div class="clearfix"></div>
         <div class="panel-group" id="accordion">
  
        <div class="panel panel-default">
		<div class="panel-heading">
		<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
        <h4 class="panel-title">
          <i class="fa fa-angle-double-right"></i> What we do ?
        </h4></a>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body one">
             <p>We provide you required infrastructure and finance support to start a service center in your area. We share our expertise and bring good number of customers to the center.</p>
        </div>
        </div>
        </div>
	   
	   
	   <div class="panel panel-default">
       <div class="panel-heading">
	   <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
        <h4 class="panel-title">
        <i class="fa fa-angle-double-right"></i> What you do ?
        </h4></a>
       </div>
       <div id="collapse2" class="panel-collapse collapse">
       <div class="panel-body one">
           <p>You need to maintain service center under our brand and serve customers in best possible way. Your investment is zero percent. We work under profit sharing .
             </p>
      
              </div>
              </div>
              </div>
         <h4 class="one1">Contact us for further details</h4>
         <span class="one3"><i class="fa fa-phone"></i> :  040 - 40191909</span><br>
         <a href="#" class="one2"> <i class="fa fa-envelope-o"></i> : vaahanmitra@gmail.com</a>
  
                </div>
                </div>        
                </div></div>
                <div class="col-md-12"><br><br></div>
            <div class="clearfix"></div> 
             <section class="get-offer">
                <div class="container">
                    <div class="row">
                    <div class="col-sm-4"></div>
                        <div class="col-sm-5" style="text-align: center;">
                            <span>Subscribe to our Newsletter</span>
                            <h2>& Discover the best offers!</h2>
                        </div>
                        <div class="col-sm-4">
                            <div class="input-group">
<!--                                 <input type="text" class="form-control" placeholder="Enter Your Email" name="q"> -->
                                <div class="input-group-btn">
<!--                                     <button class="btn btn-default" type="submit"><i class="flaticon-paper-plane"></i> Subscribe</button> -->
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>
       <!-- Footer Section -->
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
        <!-- jQuery -->
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <!-- jquery ui js -->
        <script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!-- bootstrap js -->
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- fraction slider js -->
        <script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
        <!-- owl carousel js --> 
        <script src="assets/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
        <!-- counter -->
        <script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
        <script src="assets/js/waypoints.js" type="text/javascript"></script>
        <!-- filter portfolio -->
        <script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
        <script src="assets/js/portfolio.js" type="text/javascript"></script>
        <!-- magnific popup -->
        <script src="assets/js/jquery.magnific-popup.min.js" type="text/javascript"></script>
        <!-- range slider -->
        <script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
        <script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
        <!-- custom -->
        <script src="assets/js/custom.js" type="text/javascript"></script>
       
         
         <script type="text/javascript">
         
         $.fn.stars = function() {
        	    return $(this).each(function() {
        	        // Get the value
        	        var val = parseFloat($(this).html());
        	        // Make sure that the value is in 0 - 5 range, multiply to get width
        	        var size = Math.max(0, (Math.min(5, val))) * 16;
        	        // Create stars holder
        	        var $span = $('<span />').width(size);
        	        // Replace the numerical value with stars
        	        $(this).html($span);
        	    });
        	}
         $(function() {
        	    $('span.stars').stars();
        	});
         </script>
	 
    </body>
</html>