<%-- 
    Document   : companies
    Created on : Mar 13, 2017, 12:09:44 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    </head>
    <body>
    <h1>Kompanije: </h1>
    <c:if test="${!empty companies}">
    <table>
    <tr>
    <th width="350"> naziv</th>
    <th width="400"> grad</th>
    <th width="200"> email</th>
    </tr>
    <c:forEach items="${companies}" var="company">
    <tr>
    <td>${company.name}</td>
    <td>${company.city}</td>
    <td>${company.email}</td>
    <td>
    </td>
    </tr>
    </c:forEach>
    </c:if>
    </table>
    </body>
</html>

