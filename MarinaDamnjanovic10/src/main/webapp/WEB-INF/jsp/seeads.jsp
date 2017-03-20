<%-- 
    Document   : seeads
    Created on : Mar 19, 2017, 10:18:49 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Ads list</h1>
<c:if test="${!empty ads}">
<tr>
<th width="500"> title</th>
<th width="500"> description</th>
<th width="500"> deadline</th>
</tr>
<c:forEach items="${ads}" var="ad">
<div class="row">
<tr>
<td>${ad.title}</td>
<td>${ad.description}</td>
<td>${ad.deadline}</td>
<td><a href="<c:url value='/ad/${ad.id}' />">see</a></td>
<td><a href="<c:url value='/ad/${ad.id}' />">edit</a></td>
<td><a href="<c:url value='/deletead/${ad.id}' />">delete</a></td>
</tr>
</div>
</c:forEach>
</table>
</c:if>
</body>
</html>
