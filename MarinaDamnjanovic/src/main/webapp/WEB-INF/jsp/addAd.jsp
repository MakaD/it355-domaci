<%-- 
    Document   : adAd
    Created on : Feb 11, 2017, 3:58:31 PM
    Author     : Marina
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Unesite informacije o oglasu</h2>
<form:form method="POST" action="/MarinaDamnjanovic/addAd">
    <table>
        <tr>
            <td><form:label path="title"><spring:message code="naslov"/></form:label></td>            
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td><form:label path="description"><spring:message code="opis"/></form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td><form:label path="deadline"><spring:message code="rok"/></form:label></td>
            <td><form:input path="deadline" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Pošalji"/>
            </td>
        </tr>
    </table>
</form:form>

<%@ include file="footer.jsp" %>
