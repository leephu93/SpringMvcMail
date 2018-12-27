<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String index = request.getContextPath();
	String about = request.getContextPath() + "/about";
	String signout = request.getContextPath() + "/signout/";
	String cssClass = "active";
	String ActiveHome = "";
	String ActiveAbout = "";
	String ActiveAccount = "";
	if(request.getParameter("view") != null){
		String str_view = request.getParameter("view").substring(0, request.getParameter("view").length() - 4);
		if (str_view.equals("home")) {
			ActiveHome = cssClass;
		} else if (str_view.equals("about")) {
			ActiveAbout = cssClass;
		}
		else if(str_view.equals("account")){
			ActiveAccount = cssClass;
		}
		else {
			cssClass = "";
		}
	}
	else{
		cssClass = "";
	}
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand text-success" href=<%=index%>>ICT SMART
		SHOP</a>
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
			<li class="nav-item <%=ActiveAccount%>"><a class="nav-link" href="#" tabindex="-1"
				aria-disabled="true">Accounts</a></li>
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
			<li class="nav-item"><a class="nav-link text-success" href="#"
				data-toggle="modal" data-target="#signin">Sign In</a></li>
			<li class="nav-item"><a class="nav-link text-success" href="#"
				data-toggle="modal" data-target="#signup">Sign Up</a></li>
			<li class="nav-item"><a class="nav-link text-success" href=<%= signout %>>Sign Out</a></li>
		</ul>
	</div>
</nav>

<jsp:include page="../util/modal.jsp"></jsp:include>