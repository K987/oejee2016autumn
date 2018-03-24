<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="hun.restoffice.remoteClient.domain.PaymentMethodStub"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
  <%@ include file="style/header.jspf" %>
<title>Bevételek</title>
</head>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/page.css" />
	<title>Bevételek</title>
</body>
<h1>Bevételek listája</h1>
<br />
<a href="IncomeEdit?docId=-1">új bevétel rögzítése</a>
<br />
<a href="/webpage">vissza a főoldalra</a>
<br />
<c:choose>
	<c:when test="${requestScope.incomes.size() eq  0}">
		<h2>bevétel lista üres</h2>
		<a href="Income">vissza</a>
	</c:when>
	<c:otherwise>

		<table class=incomeTable>
			<thead>
				<tr>
					<th>sorszám</th>
					<th>partner</th>
					<th>kelt</th>
					<th>leírás</th>
					<th>bruttó összeg</th>
					<th>bevétel típus</th>
					<th>fizetés módja</th>
					<th>fizetési határidő</th>
					<th>fizetve</th>
				</tr>
			</thead>
			<tbody>
			                 <tr>
                        <form method="post" action="Income">
                            <td>-</td>
                            <!-- partners -->
                            <td><select name="partner" id="partner">
                                    <option value="-1">-</option>
                                    <c:forEach items="${requestScope.partners}" var="partner">
                                        <option value="${partner.id}">${partner.name}</option>
                                    </c:forEach>
                            </select></td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <!-- costType -->
                            <td><select name="incomeType" value="incomeType">
                                    <option value="-1">-</option>
                                    <c:forEach items="${requestScope.incomeTypes }" var="incomeType">
                                        <option value="${incomeType.id}">${incomeType.name}</option>
                                    </c:forEach>
                            </select></td>
                            <!-- payMethod -->
                            <td><select name="paymentMethod" value="paymentMethod">
                                    <option value="-1">-</option>
                                    <c:set var="paymentMethods"
                                        value="<%=PaymentMethodStub.values()%>" />
                                    <c:forEach items="${paymentMethods}" var="paymentMethod">
                                        <option value="${paymentMethod.ordinal()}">${paymentMethod.description}</option>
                                    </c:forEach>
                            </select></td>
                            <td>-</td>
                            <!-- payed -->
                            <td><select name="isPayed" id="isPayed">
                                    <option value="-1">-</option>
                                    <option value="0">nincs fizetve</option>
                                    <option value="1">fizetve</option>
                            </select></td>

                            <td><input type="submit" value="szűrés"/></td>
                        </form>
                        <form method="get" action="Income">
                            <td><input type="submit" value="szűrés törlése" /></td>
                        </form>
				<c:forEach items="${requestScope.incomes}" var="income">
					<tr>
						<td><c:out value="${income.docId }"></c:out></td>
						<td><c:out value="${income.partner }"></c:out></td>
						<fmt:formatDate var="regDate" value="${income.registered.time}"
							type="date" dateStyle="short" />
						<td><c:out value="${regDate}" /></td>
						<td><c:out value="${income.description}" /></td>
						<fmt:formatNumber var="total" value="${income.grossTotal}"
							type="currency" />
						<td><c:out value="${total}" /></td>
						<td><c:out value="${income.incomeType}" /></td>
						<td><c:out value="${income.payMethod.description}" /></td>
						<fmt:formatDate var="expDate" value="${income.expiry.time}"
							type="date" dateStyle="short" />
						<td
							class="${income.expiry.time < requestScope.today.time ?  'expiredDate' : 'valid' }"><c:out
								value="${expDate}" /></td>
						<fmt:formatDate var="payDate" value="${income.payed.time}"
							type="date" dateStyle="short" />
						<td><c:out value="${payDate}" /></td>
						                          <td><a
                                href="IncomeEdit?docId=<c:out value="${income.docId}"/>">módosít</a></td>
                            <td><a
                                href="IncomeDelete?docId=<c:out value="${income.docId}"/>">töröl</a></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			</c:otherwise>
			</c:choose>			
</body>
</html>