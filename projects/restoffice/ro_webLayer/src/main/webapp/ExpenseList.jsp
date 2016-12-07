<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="hun.restoffice.ejbservice.domain.ExpenseStub"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>Kiadások</title>
</head>
<body>
	<h1>Kiadások listája</h1>
	<br />
	<a href="Expense?docId=-1">új kiadás rözítése</a>
	<br />
	<br />
	<table class=expenseTable>
		<thead>
			<tr>
				<th>sorszám</th>
				<th>kibocsátó</th>
				<th>kelt</th>
				<th>leírás</th>
				<th>bruttó összeg</th>
				<th>költséghely</th>
				<th>költségnem</th>
				<th>fizetés módja</th>
				<th>fizetési határidő</th>
				<th>fizetve</th>
				<th>módosít</th>
				<th>töröl</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${requestScope.expensesSize} == 0">
					<h2>kiadás lista üres</h2>
				</c:when>
				<c:otherwise>
					<form method="post" action="ExpenseList">
						<tr>
							<td>-</td>
							<!-- partners -->
							<td><select name="partner" id="partner">
									<option value="-1">-</option>
									<c:forEach items="${requestScope.partners}" var="partner">
										<option value="${partner}">${partner.name}</option>
									</c:forEach>
							</select></td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<!-- costCenter -->
							<td><select>
									<option value="-1">-</option>
									<c:forEach items="${requestScope.costCenters }"
										var="costCenter">
										<option value="${costCenter}">${costCenter.name}</option>
									</c:forEach>
							</select></td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td><input type="submit" value="Szűr"></td>
							<td>-</td>
						</tr>
					</form>
					<c:forEach items="${requestScope.expenses}" var="expense">
						<tr>
							<td><c:out value="${expense.docId}" /></td>
							<td><c:out value="${expense.issuer}" /></td>
							<fmt:formatDate var="regDate" value="${expense.registered.time}"
								type="date" dateStyle="short" />
							<td><c:out value="${regDate}" /></td>
							<td><c:out value="${expense.description}" /></td>
							<fmt:formatNumber var="total" value="${expense.grossTotal}"
								type="currency" />
							<td><c:out value="${total}" /></td>
							<td><c:out value="${expense.costCenter}" /></td>
							<td><c:out value="${expense.costType}" /></td>
							<td><c:out value="${expense.payMethod}" /></td>
							<fmt:formatDate var="expDate" value="${expense.expiry.time}"
								type="date" dateStyle="short" />
							<td><c:out value="${expDate}" /></td>
							<fmt:formatDate var="payDate" value="${expense.payed.time}"
								type="date" dateStyle="short" />
							<td><c:out value="${payDate}" /></td>
							<td><a
								href="Expense?docId=<c:out value="${expense.docId}"/>">módosít</a></td>
							<td><a
								href="ExpenseDelete?docId=<c:out value="${expense.docId}"/>">töröl</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>


</body>
</html>