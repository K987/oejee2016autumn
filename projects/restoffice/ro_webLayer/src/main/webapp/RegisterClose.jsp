<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%@ include file="style/header.jspf"%>
<title>Pénztárgép zárás</title>
</head>
<body>
	<h1>Pénztárgép zárás</h1>
	<br>
	<c:choose>
		<c:when test="${ requestScope.registers.size() eq 0 }">
			<p>Nincsenek pénztárgépek</p>
		</c:when>
		<c:otherwise>
			<form action="RegisterClose" method="POST">
				<table class="table table-stripped">
					<thead>
						<tr>
							<th scope="col">pénztárgép azonosító</th>
							<th scope="col">pénztárgép típusa</th>
							<th scope="col">zárás dátuma</th>
							<th scope="col">zárás történt</th>
							<th scope="col">zárás száma</th>
							<th scope="col">zárás összege</th>
						</tr>
					</thead>
					<c:forEach items="${requestScope.registers }" var="register">
						<tr>
							<td scope="row"><c:out
									value="${register.registerStub.registerId }"></c:out></td>
							<td><c:out value="${ register.registerStub.registerType == 0 ? 'pénztárgép' : 'kártya terminál'}"></c:out></td>
							<fmt:formatDate var="closeDate"
								value="${register.closeDate.getTime()}" type="date"
								dateStyle="short" />
							<td><c:out value="${closeDate}" /></td>
							<td><input type="checkbox" name="${register.registerStub.registerId }:isClosed" value="true"/></td>
							<td><input type="number"
								name="${register.registerStub.registerId }:closeNo"
								value="${register.closeNo }" /></td>
							<td><input type="number"
								name="${register.registerStub.registerId }:closeAmt"
								value="${register.closeAmt}"></td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="ment" />
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>