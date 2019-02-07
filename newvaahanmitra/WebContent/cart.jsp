<%@page import="java.io.PrintWriter"%>
<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/modalForm.css" rel="stylesheet" type="text/css" />


<style>
.sticky + .content {
    padding-top: 60px !important;
}
input[type=checkbox] {
	display: block;
	width: 21px;
	height:21px;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: contain;
	-webkit-appearance: non !important;
	outline: 0;
}
input[type=checkbox]:checked {
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"><path id="checkbox-3-icon" fill="#000" d="M81,81v350h350V81H81z M227.383,345.013l-81.476-81.498l34.69-34.697l46.783,46.794l108.007-108.005 l34.706,34.684L227.383,345.013z"/></svg>');
}
input[type=checkbox]:not(:checked) {
    background-image: url('data:image/svg+xml;utf8,<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve"> <path id="checkbox-9-icon" d="M391,121v270H121V121H391z M431,81H81v350h350V81z"></path> </svg>');
}
.boa h5{
    font-size: 21px;
    text-decoration: underline;
    color: #f94141 !important;
    font-family: inherit;
    }
   @media (min-width: 992px){
   .ore{
    width: 20% !important;
    } 
   } 
  .bo2{
    width: 20px;
    height: 20px;
    border: 1px solid #a7a1a1;
    background: #fff;
    border-radius: 2px;
    } 
  
       .bo {
	    font-size:16px;
	    color: #f94141;
	    font-family: sans-serif;
	    font-weight: 500;
	    }
	    .bo1 {
	        font-size: 15px;
		    color: #3f4040;
		    font-family: sans-serif;
		    font-weight: 500;
		    margin: 0px 4px;
		   line-height: 2.4rem;
	     }
	     .cart{
	      padding: 6px 7px;
          border-bottom: 2px solid #fec107;
          border-top: 2px solid #fec107;
	     }
        .form-control {
		    display: block;
		    width: 100%;
		    height:28px;
		    padding:0px 6px;
		    font-size: 13px;
		    line-height: 1.42857143;
		    color: #555;
		    background-color: #fff;
		    background-image: none;
		    border: 1px solid #18aedf;
		    border-radius: 4px;
		    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		    -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
		    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
		    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
           }
		    .bo3 i{
            font-size:24px;
		    color: #18aedf;
		    margin: 6px 7px;
		    }
		     .bo3 span{
            font-size:17px;
		    color: #18aedf;
		    margin: 6px 7px;
		    }
		     .bo3 a{
		    float: right;
		    margin: 6px 7px;
		    }
		    .cart0{
		    float: right;
		    font-size: 19px;
		    color: #000;
		    margin: 7px 0;
		    }
		    .cart10{
		    font-size: 17px;
		    position: absolute;
		    margin: -11% 14%;
		    color: #9a2220;
		    text-decoration: none;
			    }
		    .box9{
            height: 24px;
		    padding: 0px 4px;
		    font-size: 13px;
		    line-height: 1.42857143;
		    color: #555;
		    background-color: #fff;
		    background-image: none;
		    border: 1px solid #18aedf;
		    border-radius: 4px;
		    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
		    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
		    }
		    .bob small {
		    font-size: 15px;
		    float: right;
		    margin: 10px 0px;
		    color: #18aedf;
		    }
		    .box1 p {
		    font-size: 22px;
		    padding: 0 0;
		    color: #000;
		    margin-top: 10px;
		    font-family: sans-serif;
		    font-weight: 500;
		    }
		    .content {
              padding:3px;
              }
            
			.productbox img {
			    -webkit-transform: scale(0.9);
			    transform: scale(0.9);
			    -webkit-transition: .3s ease-in-out;
			    width: 100%;
			}
			.productbox:hover img {
			    -webkit-transform: scale(1);
			    transform: scale(1);
			}
			.sidber-box {
			    margin-bottom: 20px;
			    position: relative;
			    border: 1px solid #d4cfcf;
			    border-radius: 4px !important;
			    background: #fff;
			    }
			   .content {
              padding: 3px !important;
            } 
            :focus {
                outline: -webkit-focus-ring-color auto 0px !important;
             }
             .cart2{
             padding-right: 0px;
             }
              .cart1{
             padding-left:3px;
             
             }
             .bo8{
                position: absolute;
			    margin: -6px 10px;
			    background: #26bd2c;
			    width: 22px;
			    height: 22px;
			    border: 1px solid #03A9F4;
			    border-radius: 41px;
			    color: #fff;
			    padding: 0px 0px 0px 6px;
			    font-size: 15px;
			    }
			   .boa h5{
			    font-size: 21px;
			    text-decoration: none;
			    color: #18aedf;
			    font-family: inherit;
			    } 
			   .boa{
			    padding:0 0px;
			    } 
			     @media (max-width:768px){
			    .bo3 a {
			    float: initial;
			    margin: 2px 0px;
			    }
			    .cart1{
			     padding-left: 15px;
                 margin: 5px 0;
               }
               .cart2{
			     padding-right: 15px;
                 
               }
			    }
         .cartq{
    border-radius: 3px;
    border: 1px solid #ccc;
    line-height:22px;
    padding: 0 5px;
    width: 100px;
    }
    .close {
    float: right;
    font-size: 36px;
    font-weight: 600;
    line-height: 1;
    color: #000000;
    text-shadow: 0 1px 0 #fff;
    filter: alpha(opacity = 20);
    opacity: .5;
   }
   .content {
    padding: 0px !important;
   }
   .sticky + .content {
    padding-top:68px !important; 
   }
   #mr{
    line-height: 17px;
    font-size: 17px;
    background: #f94141;
    border: 1px solid #f94141;
    }
  </style>
    </head>
    <body>
	        <div class="se-pre-con"></div>
	        <div id="page-content">
		    <nav id="mainNav" class="navbar navbar-fixed-top" style="background: #fff;">
			<jsp:include page="homeTop.jsp"></jsp:include>
		    </nav>
			</div>
			
		<!--=============== new section ================ -->  	
		<div class="container">
		   <div class="col-lg-12">
           <div class="col-md-12 boa">
           <h5>Cart Items</h5>
           </div>
           </div>
           
           <!-- ======= start====== -->
           
              <div class="col-md-12 cart alert  alert-dismissible">
              <div class="col-lg-12">
                <div class="col-md-10 box1">
                <p>Spare Parts</p> 
                </div>
                <div class="col-md-2">
                <!-- <input type="checkbox" name="vehicle1" value="Bike" style="width:21px; height:21px;"> <span class="cart10"><a href="#">Remove</a></span>   -->
                 <button type="button" class="close" data-dismiss="alert" aria-label="close" data-dismiss="modal">&times;</button>
                </div>
                </div>
                
                <div class="col-lg-12" style="padding: 0 0;">
                <div class="col-md-4">
                <div class="col-md-12 box2">
	            <span class="bo">Name :</span><span class="bo1">Gasket Maker</span>
	            </div>
	            
	            <div class="col-md-12 box2">
	            <span class="bo">SKU :</span><span class="bo1">0987654322 </span>
	            </div>
	            
	            <div class="col-md-12 box2">
                <c:set var="painttype" value="${pd.INTER_EXTER}" scope="request"/>
                <span class="bo">Brand :</span><span class="bo1">Hero</span>
                </div>
               
                </div>
                
               <div class="col-md-4">
              
               <div class="col-md-12 box2">
               <span class="bo">Model :</span><span class="bo1">Duet</span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Mfd. By :</span><span class="bo1">Elofic Elofic </span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Vehicle Type :</span><span class="bo1">2,WHEELER</span>
               </div>
                 
               </div>
               
               <div class="col-md-4">
               <div class="col-md-12 box2">
               <span class="bo">Category :</span><span class="bo1">Spare Parts</span>
               </div>
                
               <div class="col-md-12 box2">
               <span class="bo">Order Quantity :</span>
               <span class="bo1"><input type="text" id="username" name="username" placeholder="" class="cartq"></span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Price :</span><span class="bo1"><i class="fa fa-inr"></i> 250</span>
               </div>
		      
               </div>
               </div>
               </div>    
               
               <!--========== section ================= -->
               
                  <div class="col-md-12 cart alert  alert-dismissible">
              <div class="col-lg-12">
                <div class="col-md-10 box1">
                <p>Spare Parts</p> 
                </div>
                <div class="col-md-2">
                <!-- <input type="checkbox" name="vehicle1" value="Bike" style="width:21px; height:21px;"> <span class="cart10"><a href="#">Remove</a></span>   -->
                 <button type="button" class="close" data-dismiss="alert" aria-label="close" data-dismiss="modal">&times;</button>
                </div>
                </div>
                
                <div class="col-lg-12" style="padding: 0 0;">
                <div class="col-md-4">
                <div class="col-md-12 box2">
	            <span class="bo">Name :</span><span class="bo1">Gasket Maker</span>
	            </div>
	            
	            <div class="col-md-12 box2">
	            <span class="bo">SKU :</span><span class="bo1">0987654322 </span>
	            </div>
	            
	            <div class="col-md-12 box2">
                <c:set var="painttype" value="${pd.INTER_EXTER}" scope="request"/>
                <span class="bo">Brand :</span><span class="bo1">Hero</span>
                </div>
               
                </div>
                
               <div class="col-md-4">
              
               <div class="col-md-12 box2">
               <span class="bo">Model :</span><span class="bo1">Duet</span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Mfd. By :</span><span class="bo1">Elofic Elofic </span>
               </div>
               
               <div class="col-md-12 box2">
               <span class="bo">Vehicle Type :</span><span class="bo1">2,WHEELER</span>
               </div>
                 
               </div>
               
               <div class="col-md-4">
               <div class="col-md-12 box2">
               <span class="bo">Category :</span><span class="bo1">Spare Parts</span>
               </div>
                
               <div class="col-md-12 box2">
               <span class="bo">Order Quantity :</span>
               <span class="bo1"><input type="text" id="username" name="username" placeholder="" class="cartq"></span>
               </div>
		       
		       <div class="col-md-12 box2">
               <span class="bo">Price :</span><span class="bo1"><i class="fa fa-inr"></i> 250</span>
               </div>
                
               </div>
               </div>
               </div>   
                  
              <div class="col-md-5"></div>
              <div class="col-md-2">
              <button type="button" id="mr" class="btn btn-danger">Checkout</button>
              </div> 
                
               <div class="col-md-5">
               <p class="cart0">Total No of items ordered</p>
               </div>
               </div>
               
               
         	      
           <div class="clearfix"> </div>
    <!--============================ end new section ============================ -->  
        <div class="col-lg-12">
          <p style="min-height:100px;"></p>
        </div>
        <div class="clearfix"> </div>
       <!--=============== footer section ================ -->  
		    <footer>
			<jsp:include page="footer.jsp"></jsp:include>
		    </footer>
	 <!--=============== end footer section ================ -->  
	 
	<script src="assets/js/jquery.min.js" type="text/javascript"></script>
	<!-- jquery ui js -->
	<script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
	<!-- bootstrap js -->
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- fraction slider js -->
	<script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
	<!-- owl carousel js -->
	<script src="assets/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- counter -->
	<script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
	<script src="assets/js/waypoints.js" type="text/javascript"></script>
	<!-- filter portfolio -->
	<script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
	<script src="assets/js/portfolio.js" type="text/javascript"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"
		type="text/javascript"></script>
	<!-- range slider -->
	<script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<!-- google map -->
	<script src="js/SparepartsAutocomplete.js" type="text/javascript"></script>

</body>
</html>
