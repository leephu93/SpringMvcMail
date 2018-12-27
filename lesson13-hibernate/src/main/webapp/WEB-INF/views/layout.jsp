<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String view = request.getParameter("view");
	if (view.startsWith("admin/")) {
		pageContext.forward("layout-backend.jsp");
	} else {
		pageContext.forward("layout-frontend.jsp");
	}
%>