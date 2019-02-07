<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>
<table border="10">
<%
	Blob image = null;

	Connection con = null;

	byte[] imgData = null;

	Statement stmt = null;

	ResultSet rs = null;

	try {

		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost/VehicleTracking","root","root");

		stmt = con.createStatement();

		rs = stmt.executeQuery("select PHOTO from used_car where EMAIL_ID = 'sriram@gmail.com'");

		if (rs.next()) {

			image = rs.getBlob(1);

			imgData = image.getBytes(1, (int) image.length());
			System.out.println("imagdata"+ imgData);
		} else {

			out.println("Display Blob Example");

			out.println("image not found for given id>");

			return;

		}
		%>
		<table border=2>
		<tr>
		<td> hai this is image </td>
		<td>
		<% 
		// display the image
		response.setContentType("image/gif");

		OutputStream o = response.getOutputStream();
		System.out.println("image jsp");
		out.println(imgData);
		o.write(imgData);
		
		o.flush();

		o.close();

	} catch (Exception e) {

		out.println("Unable To Display image");

		out.println("Image Display Error=" + e.getMessage());

		return;

	} finally {

		try {

			rs.close();

			stmt.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
%>
</td>
</tr>
</table>