<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html:html lang="en">

<script type="text/javascript">
	function save() {
		studentId = document.getElementById("studentId").value;
		firstName = document.getElementById("firstName").value;
		lastName = document.getElementById("lastName").value;
		gender = document.getElementById("gender").value;
		courseId = document.getElementById("courseId").value;
		var url = "studentinsert.do?method=insertStudent" + "&studentId="
				+ studentId + "&firstName=" + firstName + "&lastName="
				+ lastName + "&gender=" + gender + "&courseId=" + courseId;
		document.forms[0].action = url;
		alert(url);
		document.forms[0].submit();
	}
</script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<h2>Student Entry</h2>

		<form method="Post">
			<div class="row">
				<label class="col-sm-2">Student Id</label> <input class="col-sm-2"
					id="studentId" type="text">
			</div>
			<div class="row">
				<label class="col-sm-2">First Name</label> <input class="col-sm-2"
					id="firstName" type="text">
			</div>
			<div class="row">
				<label class="col-sm-2">Last Name</label> <input class="col-sm-2"
					id="lastName" type="text">
			</div>
			<div class="row">
				<label class="col-sm-2">Gender</label> <input class="col-sm-2"
					id="gender" type="text">
			</div>
			<div class="row">
				<label class="col-sm-2">Course Id</label> <input class="col-sm-2"
					id="courseId" type="text">
			</div>
			<input type="submit" class="btn btn-info" value="inserStudent"
				onClick="javascript:save()">
		</form>
	</div>

</body>
</html:html>
