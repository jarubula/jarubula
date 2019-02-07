<%@ page language="java"
import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>

<body>
<%

String value=request.getParameter("ID");
String Arr[]= value.split("~");
String city= Arr[0];
String Brand = Arr[1];
String id=Arr[2];   
String v_type=Arr[4];




BusinessOwnerService bos = new BusinessOwnerService();
ArrayList<BusinessOwnerRegister> bor1 = bos.getServiceCenterDealers(Brand, city, v_type);

%>

                <div id="no-more-tables">
			<table class="col-md-12 table-bordered table-striped table-condensed cf">
    <thead>
      <tr>
        <th class="numeric">Dealer Name</th>
        <th class="numeric">Email Id</th>
        <th class="numeric">Address</th>
        <th class="numeric">PhoneNo.</th>
        <th class="numeric">Offers</th>
      </tr>
    </thead>
    <tbody><%Iterator al = bor1.iterator();
    		if(bor1.size()<= 0){
 		   %>
    <tr><td colspan="6" style=" text-align: center;
       padding: 10px 0;font-size: 14px;">Service Center Dealers not available! at <%=city%> </td></tr>
   <%} %>
   		 	<% while(al.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)al.next();
			%>
		<tr>
			<td data-title="Name" class="numeric"><%=bor.getNAME()==null || bor.getNAME().equals("")?"NA":bor.getNAME()%></td>
        	<td data-title="Email" class="numeric"><%=bor.getEMAIL_ID()==null?"NA":bor.getEMAIL_ID()%></td>
			<td data-title="Address" class="numeric"><%=bor.getADDRESS()==null?"NA":bor.getADDRESS()%></td>
        	<td data-title="Phone No" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
        	<td data-title="Details" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
        	<input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
        	
        	</td>
        		</tr>
	<%} %>		
    </tbody>
  </table></div>

</body>
</html>