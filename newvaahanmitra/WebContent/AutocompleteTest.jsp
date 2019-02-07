<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
		GetSparePartsDetails spd = new GetSparePartsDetails();
		ArrayList<BusinessOwnerRegister> spdAl = spd.getCity();
		Iterator itsp = spdAl.iterator();
		String cities="{\"";
		while(itsp.hasNext()){
            BusinessOwnerRegister spCity = (BusinessOwnerRegister)itsp.next();
            cities+=spCity.getB_CITY()+"\",";
		}
		cities+="}";
		out.println(cities);
		%>
<script language="javascript">

function getDetails(str)
{
	var city = <%=cities%>;
	alert(str);
	alert(city);
	}
</script>
</head>
<body>

                                                    <div  class="select-filters">
                                                     <input type="text" name="bcity" id="bcity" onkeydown="getDetails(this.value)">
                                                     <select name="city" class="form-control" id="city">
										             <option value="SELECT" style="display:none;">City</option>
										             <option value="All">All</option>
										             <%
										             int i=0; String str[]=null,query="";
                                                     while(itsp.hasNext()){
                                                      BusinessOwnerRegister spCity = (BusinessOwnerRegister)itsp.next();
                                                    // str[i] = spCity.getB_CITY();
                                                      %>
                                                     <option value="<%=spCity.getB_CITY()%>"><%=spCity.getB_CITY()%></option>
                                                     <%i++;} %>
                								     </select>
                                                     </div>
                                                     <%-- <%
                                                     int cnt=1;
                                     				for(int j=0;j<str.length;j++)
                                     				{
                                     					if(str[j].toUpperCase().startsWith(query.toUpperCase()))
                                     					{
                                     						out.print(str[j]+"\n");
                                     						if(cnt>=5)
                                     							break;
                                     						cnt++;
                                     					}
                                     				}

                                                     %> --%>
</body>
</html>