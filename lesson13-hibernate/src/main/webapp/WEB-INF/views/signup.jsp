<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String signup = request.getContextPath() + "/signup/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>J2EE Page</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Sign Up Form</h1>
			</div>
		</div>
		<div class="dropdown-divider"></div>
		<div class="row">
			<div class="col-md-12">
				<c:if test="${ alert != null }">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>${ alert }</strong>
						<c:if test="${ alert_email != null }">
							<p>${ alert_email }
							<p>
						</c:if>
						<c:if test="${ alert_passwords != null }">
							<p>${ alert_passwords }</p>
						</c:if>
						<c:if test="${ alert_re_passwords != null }">
							<p>${ alert_re_passwords }</p>
						</c:if>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<form action="<%=signup%>" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label>Email address</label> <input type="EMAIL"
							class="form-control" aria-describedby="emailHelp"
							placeholder="Enter email" name="EMAIL"> <small
							id="emailHelp" class="form-text text-danger">${ alert_email }</small>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="PASSWORDS"
							aria-describedby="passwordsHelp"> <small
							id="passwordsHelp" class="form-text text-danger">${ alert_passwords }</small>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="RE_PASSWORDS"
							aria-describedby="repasswordslHelp"> <small
							id="repasswordslHelp" class="form-text text-danger">${ alert_re_passwords }</small>
					</div>
					<div class="form-group justify-content-end">
						<label for="exampleFormControlFile2">Example file input</label> <input
							type="file" class="form-control-file" accept="image/*"
							name="IMAGE">
					</div>
					<button type="reset" class="btn btn-secondary">Reset</button>
					<button type="submit" class="btn btn-success">Signup</button>
				</form>
				<div class="dropdown-divider"></div>
				<p>
					<h1>Social Network</h1>
					<a class="btn btn-success"
						href="https://www.facebook.com/dialog/oauth?client_id=2270798753194391&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/facebook">Facebook</a>
					<a class="btn btn-success"
						href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/google&response_type=code
		    &client_id=737176525344-iuad7rinph1rt8ulm0vlk28r5njuk6g1.apps.googleusercontent.com&approval_prompt=force">Google</a>
					<a class="btn btn-success" href="#">GitHub</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>