<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page import="com.vaahanmitra.service.VehicleService"%>
<%@page import="com.vaahanmitra.model.BikePrice"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <%    
             String seq_id =request.getParameter("seq_id"); 
       ArrayList<BikePrice> list=new ArrayList<BikePrice>();



       list=new VehicleService().getCardetailsValues(seq_id);
       Iterator it = list.iterator();

		while (it.hasNext()) {
			BikePrice td = (BikePrice) it.next();
             
             %>
          <h4 class="modal-title">Update Price and Amount </h4>
     
        <form action="UpdateOnroadPriceDetails" method="post">
        <div class="modal-body">
        <b>Item Type :</b>  <input type="text" name="item" value="<%=td.getITEM_NAME()%>" required="required"/>
        <b>Price     :</b>  <input type="text" name="price" value="<%=td.getPRICE()%>" maxlength="10" onkeypress="CheckNumeric(event)" autocomplete="off" required="required"/>
        <input type="hidden" value="<%=seq_id%>" name="seq_id">
        <input type="hidden" value="<%=td.getNEW_VEHICLE_ID()%>" name="vch_id">
        <center><button type="submit">Update</button></center>
        </div>
        
        </form>
<%} %>
</body>
</html>