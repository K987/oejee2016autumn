<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="style/header.jspf"%>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<br>
	<form action="j_security_check" method="post">
		<fieldset>
			<legend>Login</legend>
			<div class="alert alert-danger">
				<c:out value="${requestScope.error }" />
			</div>
			<br>
			<div>
				<label for="username">Felhasználó név:</label> <input type="text"
					name="j_username" id="username" value="${requestScope.username }" />
			</div>
			<div>
				<label for="password">Jelszó:</label>
				<input type="password" name="j_password" id="password">
			</div>
			<input type="submit" name="submit" value="Bejelentkezés" />
		</fieldset>
	</form>
</body>
</html>