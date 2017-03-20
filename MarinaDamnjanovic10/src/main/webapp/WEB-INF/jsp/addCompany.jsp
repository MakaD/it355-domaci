<%-- 
    Document   : addCompany
    Created on : Mar 19, 2017, 10:10:29 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<h1>Add product</h1>
<c:url var="addCompany" value="/addCompany" ></c:url>
<div class="container">
<div class="col-md-6 col-md-offset-3">
<c:url var="post_url" value="/addCompany/" />
<form:form method="POST" action="${post_url}"
modelAttribute="company">
<% String success = (String) request.getAttribute("successMsg");
%>
<%= (success != null) ? "<div class=\"alert alert-success\">"+success+"</div>" : "" %>
<div class="form-group">
<form:input type="hidden" id="id"
class="form-control" placeholder="id" path="id" />
<form:label path="name">
Name
</form:label>
<form:input type="name" id="name"
class="form-control" placeholder="name" path="name" />
</div>
<div class="form-group">
<form:label path="city">
Description
</form:label>
<form:input type="city" id="city"
class="form-control" placeholder="city"
path="city" />
</div>
<div class="form-group">
<form:label path="email">
Price
</form:label>
<form:input type="email" id="email"
class="form-control" placeholder="email" path="email" />
</div>
<button type="submit" class="btn
btn-primary">ADD</button>
</form:form>
</div>
</div>
<%@include file="footer.jsp" %>