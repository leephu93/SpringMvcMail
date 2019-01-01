<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	String index = request.getContextPath();
	String about = request.getContextPath() + "/about";
	String signout = request.getContextPath() + "/signout/";
	String admin = request.getContextPath() + "/admin/";
	String cssClass = "active";
	String ActiveHome = "";
	String ActiveAbout = "";
	String ActiveAccount = "";
	if (request.getParameter("view") != null) {
		String str_view = request.getParameter("view").substring(0, request.getParameter("view").length() - 4);
		if (str_view.equals("home")) {
			ActiveHome = cssClass;
		} else if (str_view.equals("about")) {
			ActiveAbout = cssClass;
		} else if (str_view.equals("account")) {
			ActiveAccount = cssClass;
		} else {
			cssClass = "";
		}
	} else {
		cssClass = "";
	}
	HttpSession ss = request.getSession();
	String url_image = "";
	if (ss.getAttribute("image") == null) {
		url_image = request.getContextPath() + "/static/img/default_user.png";
	} else {
		url_image = ss.getAttribute("image").toString();
	}
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand text-success" href=<%=index%>>ICT SMART SHOP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item <%=ActiveHome%>"><a class="nav-link"
				href=<%=index%>>Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item <%=ActiveAbout%>"><a class="nav-link"
				href=<%=about%>>About</a></li>
			<li class="nav-item <%=ActiveAccount%>"><a class="nav-link"
				href="#" tabindex="-1" aria-disabled="true">Accounts</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Contact </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Feedback</a> <a
						class="dropdown-item" href="#">Mail</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Our Partner</a>
				</div></li>
		</ul>
		<ul class="nav justify-content-end">
			<c:if test="${ sessionScope.user != null }">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-success" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img alt="..."
						src="<%=url_image%>" class="img_account"> Dashboard
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdown">
						<a class="dropdown-item text-success" href=<%= admin %>>Profile</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item text-success" href="#">Setting</a> <a
							class="dropdown-item text-success" href=<%=signout%>>Sign Out</a>
					</div></li>
			</c:if>
			<c:if test="${ sessionScope.user == null }">
				<li class="nav-item"><a class="nav-link text-success" href="#"
					data-toggle="modal" data-target="#signin">Sign In</a></li>
				<li class="nav-item"><a class="nav-link text-success" href="#"
					data-toggle="modal" data-target="#signup">Sign Up</a></li>
			</c:if>
		</ul>
	</div>
</nav>

<jsp:include page="../util/modal.jsp"></jsp:include>