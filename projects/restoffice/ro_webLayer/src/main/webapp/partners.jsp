<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="hun.restoffice.ejbservice.domain.PartnerStub"%>
<% List<PartnerStub> book = (List<PartnerStub>) request.getAttribute("partners"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Bank account #</th>
			<th>is technical</th>
		</tr>
		<% for(int i = 0; i<book.size(); i++){ %>
		<tr>
			<td><%= book.get(i).getName() %></td>
			<td><%= book.get(i).getContact() %></td>
			<td><%= book.get(i).getAddress() %></td>
			<td><%= book.get(i).getBankAccount() %></td>
			<td><%= book.get(i).getTechnical() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>