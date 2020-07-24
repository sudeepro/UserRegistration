<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="login" modelAttribute="loginUser" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
		<a href="/viewForm.jsp"> <strong>Register</strong></a>
		
		<a href="/forgotPassword.jsp"> <strong>Forgot Password?</strong></a>
	</form:form>

</body>
</html>