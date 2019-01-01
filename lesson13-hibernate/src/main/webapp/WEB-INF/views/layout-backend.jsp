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
	String admin = request.getContextPath()+"/admin/";
	HttpSession ss = request.getSession();
	String url_image = "";
	if (ss.getAttribute("image") == null) {
		url_image = request.getContextPath() + "/static/img/default_user.png";
	} else {
		url_image = ss.getAttribute("image").toString();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>J2EE Page</title>

<!-- Bootstrap core CSS-->
<link
	href=<%=request.getContextPath() + "/static/css/bootstrap.min.css"%>
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link
	href=<%=request.getContextPath() + "/static/fontawesome-free/css/all.min.css"%>
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href=<%=request.getContextPath() + "/static/css/dataTables.bootstrap4.css"%>
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href=<%=request.getContextPath() + "/static/css/sb-admin.css"%>
	"" rel="stylesheet">

<link rel="stylesheet"
	href=<%=request.getContextPath() + "/static/css/styles.css"%>>

</head>
<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href=<%= index %>>Start Bootstrap</a>
		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-success" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
					class="badge badge-danger">9+</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="alertsDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
					class="badge badge-danger">7</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<img alt="..." src=<%= url_image %> class="img_account">
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a> <a
						class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item"
						href=<%=request.getContextPath() + "/signout/"%>>Logout</a>
				</div></li>
		</ul>
	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href=<%= admin %>> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Login Screens:</h6>
					<a class="dropdown-item" href="login.html">Login</a> <a
						class="dropdown-item" href="register.html">Register</a> <a
						class="dropdown-item" href="forgot-password.html">Forgot
						Password</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">Other Pages:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a> <a
						class="dropdown-item" href="blank.html">Blank Page</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#" class="text-success">Dashboard</a></li>
					<li class="breadcrumb-item active">Overview</li>
				</ol>

				<jsp:include page="${ param.view }"></jsp:include>

			</div>

		</div>

		<!-- Sticky Footer -->
		<footer class="sticky-footer">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>HELLO WORLD, SPRING MVC FRAMEWORK!</span>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script
		src=<%=request.getContextPath() + "/static/js/jquery-3.3.1.min.js"%>></script>
	<script
		src=<%=request.getContextPath() + "/static/js/bootstrap.bundle.min.js"%>></script>
	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/popper.min.js"%>></script>

	<!-- Core plugin JavaScript-->
	<script
		src=<%=request.getContextPath() + "/static/js/jquery.easing.min.js"%>></script>

	<!-- Page level plugin JavaScript-->
	<script src=<%=request.getContextPath() + "/static/js/Chart.min.js"%>></script>
	<script
		src=<%=request.getContextPath() + "/static/js/jquery.dataTables.js"%>></script>
	<script
		src=<%=request.getContextPath() + "/static/js/dataTables.bootstrap4.js"%>></script>

	<!-- Custom scripts for all pages-->
	<script
		src=<%=request.getContextPath() + "/static/js/sb-admin.min.js"%>></script>

	<script type="text/javascript"
		src=<%=request.getContextPath() + "/static/js/custom.js"%>></script>
</body>
</html>