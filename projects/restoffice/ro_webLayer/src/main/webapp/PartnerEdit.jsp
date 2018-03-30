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
<title>Partner kezelése</title>
</head>
<body>
	<h1>Partner kezelése</h1>
	<br>
	<form method="POST" action="PartnerEdit" accept-charset="UTF-8">
		<input type="hidden" id="id" name="id" value="${requestScope.partner.id}" />
		<label for="name">partner neve:</label><input type="text" id="name" name="name" value="${requestScope.partner.name}"/>
		<br>
		<label for="accountno">számla száma:</label><input type="text" id="accountno" name="accountno" value="${requestScope.partner.account}"/>
		<br>
        <label for="contact">kontakt neve:</label><input type="text" id="contact" name="contact" value="${ requestScope.partner.contact.name}"/>
		<br>
		<label for="phone">telefonszám:</label><input type="text" id="phone" name="phone" value="${ requestScope.partner.contact.phone}"/>
		<br>
		<label for="email">email:</label><input type="text" id="email" name="email" value="${ requestScope.partner.contact.email}"/>
	    <br>
        <input type="submit" value="küld">
    </form>
    <a href="Partner">vissza</a>
</body>
</html>