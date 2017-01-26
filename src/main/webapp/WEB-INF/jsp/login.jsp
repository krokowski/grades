<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<title>Informacje o ocenach</title>
	
		<!-- jQuery 3.1.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!--  Material Dashboard CSS    -->
    	<link href="resources/css/material-dashboard.css" rel="stylesheet"/>
    	
    	<link href="resources/css/app.css" rel="stylesheet" type="text/css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<!--     Fonts and icons     -->
    	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    	
    	<meta name="viewport" content="width=device-width, initial-scale=1">
	
</head>
<body class="login-body">

	<form action="/login" method="post">

		<div class="login-block col-md-6">
			<div class="card">
				<div class="card-content">
					<div class="logo">					
						Informacje o ocenach	
					</div>
					<c:if test="${param.error ne null}">
						<div class="alert alert-danger">Niepoprawny login lub hasło</div>
					</c:if>
					<c:if test="${param.logout ne null}">
						<div class="alert alert-success">Zostałeś poprawnie wylogowany</div>
					</c:if>
					<div class="form-group label-floating">
							<label class="control-label">Email</label>
							<input type="text" class="form-control" name="email" autofocus>
					</div>
					<div class="form-group label-floating">
							<label class="control-label">Hasło</label>
							<input type="password" class="form-control" name="password" >
					</div>
					<div style="text-align:center;">
						<input type="submit" value="Zaloguj się" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
	

</body>
<script src="resources/js/material.min.js" type="text/javascript"></script>
<script src="resources/js/material-dashboard.js"></script>

</html>
