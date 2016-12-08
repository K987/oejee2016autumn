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
    <form method="post" action="CreateTracklist">
			<td><input type="text" name="name" value="" /></td>
			<td><input type="submit" value="Create Tracklist" />&nbsp;</td>
	</form>
	
	<c:forEach items="${requestScope.tracklists}" var="tracklist">
		 <hr/>
         <strong>
             <c:out value="${tracklist.name}" /> ( <a href="RemoveTracklist?name=${tracklist.name}"/>remove</a> )
         </strong>
         <br/>
         <table>
	         <thead>
	             <tr>
	                 <th>artist</th>
	                 <th>title</th>
	                 <th>url</th>
	                 <th>category</th>
	                 <th>action</th>
	             </tr>
	         </thead>
	         <tbody>
	             <c:forEach items="${tracklist.streamingUrls}" var="streamingUrl">
	                 <tr>
                 		 <td><c:out value="${streamingUrl.song.artist.name}" /></td>
	                     <td><c:out value="${streamingUrl.song.title}" /></td>
	                     <td>
							<img src="resources/images/<c:out value="${streamingUrl.type}" />.png" alt="<c:out value="${streamingUrl.type}" />" height="20" width="20">
	                     	<a href="<c:out value="${streamingUrl.url}" />" target="_blank" ><c:out value="${streamingUrl.url}" /></a>
                     	 </td>
	                     <td><c:out value="${streamingUrl.song.category}" /></td>
	                     <td><a href="RemoveTrack?tracklistName=${tracklist.name}&streamingUrl=${streamingUrl.url}"/>remove</a></td>
	                 </tr>
	             </c:forEach>
	             
	             <form method="post" action="AddTrack">
		            <tr>
		            	<input type="hidden" name="tracklistName" value="${tracklist.name}"/>
   						<td><input type="text" name="artistName" value=""/></td>
   						<td><input type="text" name="songTitle" value=""/></td>
						<td><input type="text" name="streamingUrl" value=""/></td>
						<td><input type="text" name="songCategory" value="" /></td>
						<td><input type="submit" value="Add" />&nbsp;</td>
					<tr>
				</form>
	         </tbody>
     	</table>
        <hr/>
     </c:forEach>
     
     <br/><br/>
     <a href="Logout">Logout</a>

</body>
</html>