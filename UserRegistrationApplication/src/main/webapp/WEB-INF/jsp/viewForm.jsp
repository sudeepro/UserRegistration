<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
</head>
<body>
	<form:form method="post" action="register" modelAttribute="user">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phNo" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><form:input path="dob" type="text" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender" items="${gendersList}" /></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><form:select path="countryId">
						<form:option value="">-Select-</form:option>
						<form:options items="${countryMap}" />
					</form:select></td>
			</tr>
			<tr>
				<th>State:</th>
				<td><form:select path="stateId">
						<form:option value="">-Select-</form:option>
					</form:select></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><form:select path="cityId">
						<form:option value="">-Select-</form:option>
					</form:select></td>

			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>