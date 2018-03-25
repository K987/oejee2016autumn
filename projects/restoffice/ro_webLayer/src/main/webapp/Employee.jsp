<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="style/header.jspf"%>
<title>Munkavállalók</title>
</head>
<body>
	<t1>Munkavállalók listája</t1>
	<br />
    <a href="/webpage">vissza a főoldalra</a>
        <br />
    <a href="EmployeeEdit?employeeId=-1">új munkavállaló</a>
	<c:choose>
		<c:when test="${requestScope.employees.size() eq 0 }}">
			<h2>Munkavállaló lista üres</h2>
			<a href="Employee">vissza</a>
		</c:when>
		<c:otherwise>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">név</th>
						<th scope="col">munkakör</th>
						<th scope="col">bér</th>
						<th scope="col">aktív</th>
						<th scope="col">módosítás</th>
						<th scope="col">törlés</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.employees }" var="employee">
						<tr>
							<th scope="row"><c:out value="${employee.name }"></c:out></th>
							<td><c:out value="${employee.position }" /></td>
						      <fmt:formatNumber var="wage" value="${employee.wage}"
                                type="currency" />
							<td><c:out value="${wage} "/></td>
							<td><c:out value="${employee.active }" /></td>
							<td><a href="EmployeeEdit?employeeId=<c:out value="${employee.id}"/>">módosít</a></td>
							<td><a href="EmployeeDelete?employeeId=<c:out value="${employee.id}"/>">töröl</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>