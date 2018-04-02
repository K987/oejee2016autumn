<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<%@ include file="style/header.jspf"%>
<title>Napzárás</title>
</head>
<body>

	<h1>Napzárás</h1>

	<form method="post" action="DailyClose">
		<label for="closeDate">Válasszon dátumot: </label> <input type="date"
			name="closeDate" id="closeDate" /> <input type="submit" value="küld" />
	</form>
	<a href="/webpage">vissza a főoldalra</a>
</body>
</html>