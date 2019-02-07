<%@page import="java.util.Iterator"%>
<%@page import="com.vaahanmitra.service.VehicleService"%>
<%@page import="com.vaahanmitra.model.BikePrice"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



</head>
<body>
<%
String b_id=request.getParameter("brand");String md=request.getParameter("model");String vt=request.getParameter("varient");String mk=request.getParameter("makeYear");
String vp=request.getParameter("type");String email=session.getAttribute("user").toString();

ArrayList<BikePrice> list=new ArrayList<BikePrice>();


list=new VehicleService().getCarPricedetails(b_id, md, vt, mk, vp,email);


BikePrice pr = null;
if(list.size()>=1){
	pr = list.get(0);
}else{}
request.setAttribute("list", list);
%>
<div class="col-md-12 col-sm-12 col-xs-12" id="item">	
		
					
					<div class="col-md-12">
				     <table class="table table-bordered table-sm">
				    <thead>
				      <tr>
				        <th>S.NO</th>
				        <th>ITEM TYPE</th>
				        <th>PRICE</th>
				       
				        <th>UPDATE</th>
				      </tr>
				        <%int i=1;int j=0;
				      if(list.size()<=0){
				      
				      %>
				      <tr> <td colspan="5" align="center"><font color=red>No Records Found</font></td></tr>
				     <%}else{
				     %>
				    </thead>
				    <tbody>
				     <c:forEach var="p_list" items="${list}">
				      <tr>
				        <td><%=i%></td>
				        <td>${p_list.ITEM_NAME}</td>
				        <td>${p_list.PRICE}</td>
				        
				       <td><a onclick="myFunctions(${p_list.SEQ_NO})"> <button type="button" class="btn btn-info btn-sm" >UPDATE</button></a></td>
				      <c:set var = "seq_id" value='${p_list.SEQ_NO}'/>
				      <c:set var = "item_id" value='${p_list.ITEM_NAME}'/>
				      <c:set var = "price_id" value='${p_list.PRICE}'/>
				      
				      </tr>
		<%-- 		      
				      				         			          <div class="modal fade" id="myModal<%=j%>" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
             <%String item_id = (String) pageContext.getAttribute("item_id");
             String price_id = (String) pageContext.getAttribute("price_id");
             int seq_id = (Integer) pageContext.getAttribute("seq_id"); %>
          <h4 class="modal-title">Update price of <%=item_id%></h4>
        </div>
        <form action="UpdateOnroadPriceDetails" method="post">
        <div class="modal-body">
        <b>Item Type :</b>  <input type="text" name="item" value="<%=item_id%>"/>
        <b>Price :</b>  <input type="text" name="price" value="<%=price_id %>" maxlength="10" onkeypress="CheckNumeric(event)"/>
        <input type="hidden" value="<%=seq_id%>" name="seq_id">
        <button type="submit">Update</button>
       
     
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div> --%>
				      <%i++;j++; %>
				         </c:forEach> 

				    </tbody>
				    
				  </table>
				  <%} %>
</div>
</div>
</body>
</html>