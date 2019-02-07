<html>
<head>
<script language="javascript">
	function validate() {
		var chks = document.getElementsByName('colors[]');
		var hasChecked = false;
		for (var i = 0; i < chks.length; i++) {
			if (chks[i].checked) {
				hasChecked = true;
				break;
			}
		}
		if (hasChecked == false) {
			alert("Please select at least one.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form name="form1" onSubmit="return validate()">
		Your colors are <br> <input type="checkbox" name="colors[]" value="blue" id="blue">Blue <br> 
		<input type="checkbox"	name="colors[]" value="red" id="red">red <br>
		 <input type="checkbox" name="colors[]" value="green" id="green">green<br>
		 <input type="checkbox" name="colors[]" value="yellow" id="yellow">yellow <br> 
		 <input type="checkbox" name="colors[]" value="voilet" id="voilet">voilet <br> 
		 <input type="checkbox" name="colors[]" value="grey" id="grey">grey <br>
		 <input type="submit" value="submit" name="submit" />
	</form>
</body>
</html>