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
<title>Műszak zárás</title>
</head>
<body>
	<h1>Műszak zárás</h1>
	<br>
	<c:choose>
		<c:when test="${requestScope.employeeShifts.size() eq 0 }">
			<p>Nincsenek lezárandó műszakok</p>
		</c:when>
		<c:otherwise>
			<form action="EmployeeShiftClose" method="POST">
				<table class="table table-stripped">
					<thead>
						<tr>
							<th scope="col">név</th>
							<th scope="col">munkakör</th>
							<th scope="col">kezdés ideje</th>
							<th scope="col">végzés ideje</th>
							<th scope="col">tényleges munkakör</th>
						</tr>
					</thead>
					<c:forEach items="${requestScope.employeeShifts }" var="shift">
						<tr>
							<td scope="row"><c:out value="${shift.employeeName}"></c:out></td>
							<td><c:out value="${ shift.actualPosition}"></c:out></td>
							<fmt:formatDate var="startTime"
								value="${shift.actualStart.getTime()}" type="time"
								dateStyle="short" />
                               
							<td><input type="time" value="${ startTime}"
								name="actualStart" ${ shift.closed ? 'disabled' :''}/> <fmt:formatDate var="endTime"
									value="${shift.actualEnd.getTime()}" type="time"
									dateStyle="short" />
							<td><input type="time" value="${ endTime}" name="actualEnd" ${ shift.closed ? 'disabled' :''}/>
							<td><select name="actualPosition" ${ shift.closed ? 'disabled' :''}>
									<c:forEach items="${requestScope.positions }" var="position">
									<option value="${position }" ${position eq shift.actualPosition ? 'selected' : ''} >${position }</option>
									</c:forEach>
							</select></td>

						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="ment" />
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>