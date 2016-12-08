<%@page import="hu.musicorganizer.ejbservice.domain.CustomerStub"%>
<%@page import="hu.musicorganizer.weblayer.session.SessionAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MO - Account settings</title>
</head>
<body>
	<h1>Account settings</h1>  <br/>
	<% 
	CustomerStub authenticatedUser = (CustomerStub)request.getSession().getAttribute(SessionAttribute.AUTHENTICATED_USER); 
	%>
	<h2>Change account settings</a></h2>
    <form method="post" action="ChangeCustomerData">
			Nickname: <input type="text" name="nickname" value="<%= authenticatedUser.getNickname() %>" /> <br/>
			E-mail address: <input type="text" name="emailAddress" value="<%= authenticatedUser.getEmailAddress() %>" /> <br/>
			New password: <input type="text" name="password" value="" /> <br/>
			<br/><input type="submit" value="apply" />
	</form>
	<br/><br/>
	<a href="Dashboard">Lead me back</a>
</body>
</html>