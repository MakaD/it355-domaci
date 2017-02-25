<%-- 
    Document   : showAd
    Created on : Feb 11, 2017, 3:58:47 PM
    Author     : Marina
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

        <h2>Podaci o oglasu</h2>

        <table>
            <tr>
                <th><spring:message code="title"></spring:message></th>
                <td>${ad.title}</td>
            </tr>
            <tr>
                <th><spring:message code="description"></spring:message></th>
                <td>${ad.description}</td>
            </tr>
            <tr>
                <th><spring:message code="deadline"></spring:message></th>
                <td>${ad.deadline}</td>
            </tr>
        </table>

<%@ include file="footer.jsp" %>
