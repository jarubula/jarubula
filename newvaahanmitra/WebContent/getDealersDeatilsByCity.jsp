<%@ page language="java"
import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>

<body>
<%
String value=request.getParameter("city");
String Arr[]= value.split("~");
String city= Arr[0];
String Brand = Arr[1];
String id=Arr[2];   
String v_type=Arr[4];

//alert(Name1);
String exshowroom="";


BusinessOwnerService bos = new BusinessOwnerService();
ArrayList<BusinessOwnerRegister> bor1 = bos.getDealers(Brand, city, v_type);
try{ if(v_type.equals("4,")){ exshowroom=new GetNewCarDetails().getExshowroompricebyplaceandId(id, city);
}
else{exshowroom=new GetNewBikeDetails().getExshowroompricebyplaceandId(id, city);
	}
%>

                <div id="no-more-tables">
			<table class="col-md-12 table-bordered table-striped table-condensed cf">
    <thead>
      <tr>
        <th class="numeric">Dealer Name</th>
        <th class="numeric">Email Id</th>
        <th class="numeric">Address</th>
        <th class="numeric">PhoneNo.</th>
        <th class="numeric">On Road Price</th>
        <th class="numeric">Offers</th>
      </tr>
    </thead>
    <tbody><%Iterator al = bor1.iterator();
    		if(bor1.size()<= 0){
 		   %>
    <tr><td colspan="6" style=" text-align: center;
       padding: 10px 0;font-size: 14px;">Dealers not available! at <%=city%> </td></tr>
   <%} %>
   		 	<% while(al.hasNext()){
					BusinessOwnerRegister bor = (BusinessOwnerRegister)al.next();
			%>
		<tr>
			<td data-title="Name" class="numeric"><%=bor.getNAME()==null || bor.getNAME().equals("")?"NA":bor.getNAME()%></td>
        	<td data-title="Email" class="numeric"><%=bor.getEMAIL_ID()==null?"NA":bor.getEMAIL_ID()%></td>
			<td data-title="Address" class="numeric"><%=bor.getADDRESS()==null?"NA":bor.getADDRESS()%></td>
        	<td data-title="Phone No" class="numeric"><%=bor.getOFFICE_PHONE_NO()==null?"NA":bor.getOFFICE_PHONE_NO()%></td>
        	<%
        	 int price=new BusinessOwnerService().getonRoadPrice(id,bor.getEMAIL_ID());
     	   int onroadprice=0;
     	  double on_ex=0;
   	   String final_value="";
     	   
     	   
   	  if(price!=0&exshowroom!=""){
		   int exshowroomprice=Integer.parseInt(exshowroom);
		   int dealercharge=price;
		   onroadprice=exshowroomprice+dealercharge;
         Integer integer=new Integer(onroadprice);
		    on_ex=integer.doubleValue();
		    final_value=new CurrencyFormate().indianrupee(on_ex);
		    
	   }else{
		   onroadprice=0;
	   }
	   
	   
	   %>
	   
	   
	<td class="tooltip3" data-title="On Road Price" class="numeric"><%=onroadprice==0?"NA":final_value%> 

	  <span class="tooltiptext3">
	     <p style="line-height: 8px;"><span class="sear1">EXSHOWROOM PRICE :</span> <p align="right"><span  class="sear2"><%=exshowroom==""?"NA":exshowroom%> </span></p></p>
	  	<%  HashMap<String,String> chm=new HashMap<String,String>();
	      chm=new GetNewCarDetails().getItemandPricebydealer_id(id, bor.getEMAIL_ID());
	      String item="";String price_item="";
	      Set<Map.Entry<String,String>> entry=chm.entrySet();
	      Iterator<Map.Entry<String,String>> it1=entry.iterator();
	      while(it1.hasNext()){
	    	  
	    	  Map.Entry<String,String> entrySet=it1.next();
	    	   item=entrySet.getKey();
	    	  price_item= entrySet.getValue();
	    
	 
	      %>
	  <p style="line-height: 8px;"><span class="sear1"><%=item%> :</span> <p align="right"><span   class="sear2" ><%=price_item%> </span></p></p>
	  <%}%>
	  </span>
	
	</td>   
        	<td data-title="Details" class="numeric"><a href="#"><u>Details</u></a> &nbsp; &nbsp; &nbsp;
        	<input type="checkbox" id="myCheck" onclick="myFunction()" style="width: 15px; height: 16px;">
        	
        	</td>
        		</tr>
			<%
				}}catch(NullPointerException n){}
			%>
    </tbody>
  </table></div>

</body>
</html>