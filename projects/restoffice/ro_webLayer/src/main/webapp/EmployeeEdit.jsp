<%@page import="hun.restoffice.persistence.entity.employee.JobPosition"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Munkavállaló szerkesztése</title>
</head>
<body>
	<h1>Munkavállaló kezelése</h1>
	<br />
	<form action="EmployeeEdit" method="POST" accept-charset="UTF-8">
	     <input type="hidden" id="id" name="id"  value="${requestScope.employee.id }">
		<label for="name">név:</label> <input  type="text" id="name" name="name"
			value="${requestScope.employee.name }" ${requestScope.employee.id eq -1 ? '' : 'disabled' }/>
			 <br /> 
	    <label for="position">munkakör:</label>
		<select name="position" id="position" name="position">
        <c:set var="positions" value="<%=JobPosition.values() %>"></c:set>
        <c:forEach items="${positions}" var="position">
            <option value="${position.ordinal() }" ${ position.ordinal() eq requestScope.employee.position.ordinal() ? 'selected="selected"' : '' }>
            ${position.toString()}</option>
        </c:forEach>
		</select>
		<br>
		<label for="wage">órabér:</label>
		<input type="number" name="wage" id="wage" value="${requestScope.employee.wage }"/>
		<br>
		<label for="isActive">aktív:</label><br>
		<input type="radio" name="isActive" id="isActive" value="true" ${requestScope.employee.active ? 'checked' : '' }>igen<br>
		<input type="radio" name="isActive" id="isActive" value="false" ${requestScope.employee.active ? '' : 'checked' }>hamis<br> 
		<br>
		<input type="submit" value="küld">
	</form>
	<a href="Employee">vissza</a>
</body>
</html>