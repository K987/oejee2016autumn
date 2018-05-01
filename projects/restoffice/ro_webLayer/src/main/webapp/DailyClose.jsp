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

	<c:if test="${requestScope.onGoingClose }">
		<fmt:formatDate value="${requestScope.closeDate.getTime()}"
			var="closeDate" type="date" dateStyle="short" />

		<div>
			folyamatban lévő napi zárás
			<c:out value="${closeDate}" />
		</div>
		<div>
		<a href="DailyClose?reset=true">napi zárás megszakítása</a>
		</div>
		<div>
			<a href="DailyClose?reset=false">napi zárás folytatása</a>
		</div>
	</c:if>
	<c:if test="${!requestScope.onGoingClose }">
		<form method="post" action="DailyClose">
			<label for="closeDate">Válasszon dátumot: </label> <input type="date"
				name="closeDate" id="closeDate" /> <input type="submit"
				value="küld" />

		</form>
	</c:if>
	<a href="/webpage">vissza a főoldalra</a>


</body>
</html>