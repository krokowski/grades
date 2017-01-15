<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Informacje o ocenach</title>
		<!-- jQuery 3.1.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
	</head>
	<body>
		<div class="container">
			<form:form action="add" modelAttribute="user" method="post">
				<div class="form-group">
					<label for="email">Adres email</label>
				    <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Podaj adres email">
				    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<label for="password">Hasło</label>
					<input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp" placeholder="Podaj hasło">
					<small id="passwordHelp" class="form-text form-muted">Hasło musi zawierać...</small>
				</div>
				<div class="form-group">
					<label for="role">Rola</label>
					<select class="form-control" id="role" name="role">
						<!-- <c:forEach items="${roles}" var="role">
							<option value="${role.name}"></option>
						</c:forEach> -->
						<option value="ROLE_WORKER">Pracownik</option>
						<option value="ROLE_STUDENT">Student</option>
					</select>
				</div>
				<div class="form-group">
					<label for="firstName">Imię</label>
					<input type="text" id="firstName" name="firstName" placeholder="Podaj imię">
				</div>
				<div class="form-group">
					<label for="lastName">Nazwisko</label>
					<input type="text" id="lastName" name="lastName" placeholder="Podaj nazwisko">
				</div>
				<div class="form-group">
					<label for="pesel">Pesel</label>
					<input type="text" id="pesel" name="pesel" placeholder="Podaj numer PESEL">
				</div>
				<div class="form-group" id="indexNoDiv" style="display: none;">
					<label for="indexNo">Nr Indeksu</label>
					<input type="text" id="indexNo" name="indexNo" placeholder="Podaj numer indeksu">
				</div>
				<button type="submit" class="btn btn-primary">Dodaj</button>
			</form:form>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#role').on('change', function() {
		      	if ( this.value == 'ROLE_STUDENT') {
		        		$("#indexNoDiv").show();
		      	}
		      	else {
		        		$("#indexNoDiv").hide();
		      	}
		    });
		});
	</script>
</html>