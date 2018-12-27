<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title><%=response.getStatus()%></title>
<link rel="stylesheet"
	href=<%=request.getContextPath() + "/static/css/bootstrap.min.css"%>>
<link rel="stylesheet"
	href=<%=request.getContextPath() + "/static/css/styles.css"%>>
</head>
<body>

	<jsp:include page="../header/menu.jsp"></jsp:include>

	<% int statuscode = response.getStatus(); %>
	<c:choose>
		<c:when test="<%= statuscode==404 %>">
			<jsp:include page="404.jsp"></jsp:include>
		</c:when>
		<c:when test="<%= statuscode==500 %>">
			<jsp:include page="500.jsp"></jsp:include>
		</c:when>
		<c:when test="<%= statuscode==405 %>">
			<jsp:include page="405.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<h1 class="error">Error Code: <%= statuscode %></h1>
		</c:otherwise>
	</c:choose>
	
	

	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/jquery-3.3.1.min.js"%>></script>
	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/popper.min.js"%>></script>
	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/bootstrap.min.js"%>></script>
	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/custom.js"%>></script>
</body>
</html>