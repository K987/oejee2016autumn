<%@page import="hu.musicorganizer.ejbservice.domain.CustomerStub"%>
<%@page import="hu.musicorganizer.weblayer.session.SessionAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dashboard</h1>  <br/>
	<% 
	CustomerStub authenticatedUser = (CustomerStub)request.getSession().getAttribute(SessionAttribute.AUTHENTICATED_USER); 
	%>
	<p>Welcome <%= authenticatedUser.getNickname() %>!</p>
	
	
	 <c:forEach items="${requestScope.tracklists}" var="tracklist">
         <strong>
             <c:out value="${tracklist.name}" />
         </strong>
         <br/>
         <table>
	         <thead>
	             <tr>
	                 <th>artist</th>
	                 <th>title</th>
	                 <th>url</th>
	                 <th>category</th>
	                 <th></th>
	             </tr>
	         </thead>
	         <tbody>
	             <c:forEach items="${tracklist.streamingUrls}" var="streamingUrl">
	                 <tr>
	                     <td><c:out value="${streamingUrl.song.title}" /></td>
	                     <td><a href="<c:out value="${streamingUrl.url}" />"><c:out value="${streamingUrl.url}" /></a></td>
	                 </tr>
	             </c:forEach>
	             
	             <form method="post" action="AddTrack">
		            <tr>
   						<td><input type="text" name="artistName" value=""/></td>
   						<td><input type="text" name="songTitle" value=""/></td>
						<td><input type="text" name="streamingUrl" value=""/></td>
						<td><input type="text" name="songCategory" value="" /></td>
						<td><input type="submit" value="Add" />&nbsp;</tr>
					<tr>
				</form>
	             
	         </tbody>
     	</table>
         
     </c:forEach>
</body>
</html>