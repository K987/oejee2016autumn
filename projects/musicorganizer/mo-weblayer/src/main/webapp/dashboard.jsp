<%@page import="hu.musicorganizer.ejbservice.domain.CustomerStub"%>
<%@page import="hu.musicorganizer.weblayer.session.SessionAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MO - Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>  <br/>
	<% 
	CustomerStub authenticatedUser = (CustomerStub)request.getSession().getAttribute(SessionAttribute.AUTHENTICATED_USER); 
	%>
	<h2>Welcome <a href="Settings"><%= authenticatedUser.getNickname() %>!</a></h2>
	
         <br/>
         <h3>All your tracklists: </h3>
         <table>
	         <thead>
	             <tr>
	                 <th>name</th>
	                 <th>action</th>
	             </tr>
	         </thead>
	         <tbody>
	         <c:forEach items="${requestScope.tracklists}" var="tracklist">
	            <tr>
	             	<td><a href="Tracklist?name=${tracklist.name}"/><c:out value="${tracklist.name}" /></a></td>
	                <td><a href="RemoveTracklist?name=${tracklist.name}"/>remove</a></td>
	            </tr>
	         </c:forEach>

			<tr>
			<form method="post" action="CreateTracklist">
				<td><input type="text" name="name" value="" /></td>
				<td><input type="submit" value="Create Tracklist" />&nbsp;</td>
			</form>
			</tr>

	         </tbody>
     	</table>

     <br/><br/>
     <a href="Logout">Logout</a>

</body>
</html>