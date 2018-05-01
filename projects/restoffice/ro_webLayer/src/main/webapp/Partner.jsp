<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="style/header.jspf"%>
<title>Partnerek</title>
</head>
<body>
	<h1>Partnerek listája</h1>
	<br>
	<a href="PartnerEdit?partnerId=-1">új partner</a>
	<br>
	<a href="PartnerDelete?partnerId=-1">nem használt partnerek törlése</a>
	<br>
	<a href="/webpage">vissza a főoldalra</a>
	<c:choose>
		<c:when test="${requestScope.partners.size() eq 0 }">
			<h2>Partnerek listája üres</h2>
		</c:when>
		<c:otherwise>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th scope="col">partner neve</th>
						<th scope="col">számlászáma</th>
						<th scope="col">kontakt név</th>
						<th scope="col">telefonszám</th>
						<th scope="col">email</th>
						<th scope="col">módosít</th>
						<th scope="col">töröl</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.partners}" var="partner">
						<tr>
							<th scope="row"><c:out value="${partner.name }"></c:out></th>
							<td><c:out value="${partner.account }"></c:out></td>
							<td><c:out value="${partner.contact.name }"></c:out></td>
							<td><c:out value="${partner.contact.phone }"></c:out></td>
							<td><c:out value="${partner.contact.email }"></c:out></td>
							<td><a href="PartnerEdit?partnerId=<c:out value="${partner.id }"/>">módosít</a></td>
							<td><a href="PartnerDelete?partnerId=<c:out value="${partner.id }"/>">töröl</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>