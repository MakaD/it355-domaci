<%-- 
    Document   : addcompany
    Created on : Mar 13, 2017, 12:09:25 PM
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
    <form:label path="name">Naziv
    </form:label>
    <form:input id="name" placeholder="name" path="name" />
    <form:label path="city">Grad
    </form:label>
    <form:input id="city" placeholder="city" path="city" />
    <form:label path="email">Email
    </form:label>
    <form:input id="email" placeholder="email" path="email" />
    <button type="submit">Dodaj</button>
    </form:form>
    </body>
</html>
