<%-- 
    Document   : 403
    Created on : Mar 12, 2017, 5:56:08 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <body>
    <h1>Nije ti dozvoljeno da vidis ovu stranu</h1>
    <c:choose>
    <c:when test="${empty username}">
    <h2>Uloguj se</h2>
    </c:when>
    <c:otherwise>
    <h2>Korisnice ${username} <br/>nije ti dozvoljeno da vidis ovu stranu!</h2>
    </c:otherwise>
    </c:choose>
    </body>
</html>