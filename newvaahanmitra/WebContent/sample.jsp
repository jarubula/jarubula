<head>
<title>Javascript Form Validation Without alert</title>
<script language="javascript">
	function validate() {
// 		var str = false;
		document.getElementById("msg1").innerHTML = "";
		document.getElementById("msg2").innerHTML = "";
		document.getElementById("msg3").innerHTML = "";
		document.getElementById("msg4").innerHTML = "";
		if (document.frm.userid.value == '') {
			document.getElementById("msg1").innerHTML = "Please Enter User ID";
// 			str = false;
			return false;
		}

		if (document.frm.password.value == '') {
			document.getElementById("msg2").innerHTML = "Please Enter Password";
// 			str = false;
			return false;
		}

		if (document.frm.password.value != document.frm.confirm_password.value) {
			document.getElementById("msg3").innerHTML = "Password and Confirm Password does not match";
// 			str = false;
			return false;
		}

		var validate_char = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (!document.frm.email.value.match(validate_char)) {
			document.getElementById("msg4").innerHTML = "Please Enter Valid Email ID";
// 			str = false;
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form name="frm" action="" method="post" onSubmit="return validate()">
		<table border="1" align="center">
			<tr>
				<td>User ID</td>
				<td><input name="userid" type="text">
					<div id="msg1" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password">
					<div id="msg2" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input name="confirm_password" type="password">
					<div id="msg3" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email" type="text">
					<div id="msg4" style="color: #FF0000"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="btnsubmit"
					type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>