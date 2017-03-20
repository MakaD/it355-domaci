<%-- 
    Document   : addAd
    Created on : Mar 19, 2017, 10:10:38 PM
    Author     : Marina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<h1>Add product</h1>
<c:url var="addAd" value="/addAd" ></c:url>
<div class="container">
<div class="col-md-6 col-md-offset-3">
<c:url var="post_url" value="/addAd/" />
<form:form method="POST" action="${post_url}"
modelAttribute="ad">
<% String success = (String) request.getAttribute("successMsg");
%>
<%= (success != null) ? "<div class=\"alert alert-success\">"+success+"</div>" : "" %>
<div class="form-group">
<form:input type="hidden" id="id"
class="form-control" placeholder="id" path="id" />
<form:label path="title">
Name
</form:label>
<form:input type="title" id="title"
class="form-control" placeholder="title" path="title" />
</div>
<div class="form-group">
<form:label path="description">
Description
</form:label>
<form:input type="description" id="description"
class="form-control" placeholder="description"
path="description" />
</div>
<div class="form-group">
<form:label path="deadline">
Price
</form:label>
<form:input type="deadline" id="deadline"
class="form-control" placeholder="deadline" path="deadline" />
</div>
<button type="submit" class="btn
btn-primary">ADD</button>
</form:form>
</div>
</div>
<%@include file="footer.jsp" %>
