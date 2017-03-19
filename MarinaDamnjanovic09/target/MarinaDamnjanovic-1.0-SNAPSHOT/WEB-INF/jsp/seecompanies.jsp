<%-- 
    Document   : seecompanies
    Created on : Mar 19, 2017, 10:18:39 PM
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
<h1>Company list</h1>
<c:if test="${!empty companies}">
<tr>
<th width="500"> name</th>
<th width="500"> city</th>
<th width="500"> email</th>
</tr>
<c:forEach items="${companies}" var="company">
<div class="row">
<tr>
<td>${company.name}</td>
<td>${company.city}</td>
<td>${company.email}</td>
<td><a href="<c:url value='/company/${company.id}' />">see</a></td>
<td><a href="<c:url value='/company/${company.id}' />">edit</a></td>
<td><a href="<c:url value='/deletecompany/${company.id}' />">delete</a></td>
</tr>
</div>
</c:forEach>
</table>
</c:if>
</body>
</html>
