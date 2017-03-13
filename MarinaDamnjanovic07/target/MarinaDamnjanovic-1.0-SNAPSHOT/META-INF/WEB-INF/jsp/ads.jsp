<%-- 
    Document   : ads
    Created on : Mar 13, 2017, 12:09:36 PM
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
    <h1>Oglasi:</h1>
    <c:if test="${!empty ads}">
    <table>
    <tr>
    <th width="350"> naslov</th>
    <th width="400"> opis</th>
    <th width="200"> rok</th>
    </tr>
    <c:forEach items="${ads}" var="ad">
    <tr>
    <td>${ad.title}</td>
    <td>${ad.description}</td>
    <td>${ad.deadline}</td>
    <td>
    </td>
    </tr>
    </c:forEach>
    </c:if>
    </table>
    </body>
</html>
