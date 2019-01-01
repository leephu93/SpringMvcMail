<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String signin = request.getContextPath() + "/signin/";
	String signup = request.getContextPath() + "/signup/";
%>

<!-- Modal Signin-->
<div class="modal fade" id="signin" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">Sign In
					Form</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<%=signin%>" method="post">
					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control" aria-describedby="emailHelp"
							placeholder="Enter email" name="EMAIL">
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" placeholder="password"
							name="PASSWORDS">
					</div>
					<button type="reset" class="btn btn-secondary">Reset</button>
					<button type="submit" class="btn btn-success">Signin</button>
				</form>
			</div>
			<div class="modal-footer">
				<div class="btn-group" role="group" aria-label="Basic example">
					<a class="btn btn-secondary" href="https://www.facebook.com/dialog/oauth?client_id=2270798753194391&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/facebook">Facebook</a>
					<a class="btn btn-secondary" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/google&response_type=code
    &client_id=737176525344-iuad7rinph1rt8ulm0vlk28r5njuk6g1.apps.googleusercontent.com&approval_prompt=force">Google</a>
    				<a class="btn btn-secondary" href="#">GitHub</a>
				</div>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Signup-->
<div class="modal fade" id="signup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">Sign Up
					Form</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="<%=signup%>" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control" aria-describedby="emailHelp"
							placeholder="Enter email" name="EMAIL"> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="PASSWORDS">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="RE_PASSWORDS">
					</div>
					<div class="form-group justify-content-end">
						<label for="exampleFormControlFile2">Example file input</label> <input
							type="file" class="form-control-file" accept="image/*"
							name="IMAGE">
					</div>
					<button type="reset" class="btn btn-secondary">Reset</button>
					<button type="submit" class="btn btn-success">Signup</button>
				</form>
			</div>
			<div class="modal-footer">
				<div class="btn-group" role="group" aria-label="Basic example">
					<a class="btn btn-secondary" href="https://www.facebook.com/dialog/oauth?client_id=2270798753194391&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/facebook">Facebook</a>
					<a class="btn btn-secondary" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/lesson13-hibernate/auth/google&response_type=code
    &client_id=737176525344-iuad7rinph1rt8ulm0vlk28r5njuk6g1.apps.googleusercontent.com&approval_prompt=force">Google</a>
    				<a class="btn btn-secondary" href="#">GitHub</a>
				</div>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>