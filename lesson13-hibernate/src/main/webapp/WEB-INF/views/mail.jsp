<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Email Page</title>
</head>
<body>
	<form action="<%= request.getContextPath()+"/mail" %>" method="post">
		<input type="email" name="from" placeholder="from"><br>
		<input type="email" name="to" placeholder="to"><br>
		<input type="text" name="subject" placeholder="subject"><br>
		<textarea rows="3" cols="25" name="body" placeholder="body"></textarea><br>
		<button type="submit">Send</button>
	</form>
	${ alert }
</body>
</html>