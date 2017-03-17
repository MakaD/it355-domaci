<%-- 
    Document   : addad
    Created on : Mar 13, 2017, 12:09:14 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    </head>
    <body>
    <form:form method="POST" modelAttribute="ad">
    <form:label path="title">Naslov
    </form:label>
    <form:input id="title" placeholder="title" path="title" />
    <form:label path="description">Opis
    </form:label>
    <form:input id="description" placeholder="description" path="description" />
    <form:label path="deadline">Rok
    </form:label>
    <form:input id="deadline" placeholder="deadline" path="deadline" />
    <button type="submit">Dodaj</button>
    </form:form>
    </body>
</html>
