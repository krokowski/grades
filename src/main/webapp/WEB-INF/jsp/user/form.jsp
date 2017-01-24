<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Użytkownicy</title>

		<!-- jQuery 3.1.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Material Dashboard CSS -->
    	<link href="../resources/css/material-dashboard.css" rel="stylesheet"/>
    	
    	<link href="../resources/css/app.css" rel="stylesheet" type="text/css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<!-- Fonts and icons -->
    	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    	
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	</head>
	<body>

		<div class="wrapper">
			<div class="sidebar" data-color="green">
	
				<div class="logo">					
					<span class="simple-text">Informacje o ocenach</span>
				</div>
	
		    	<div class="sidebar-wrapper">
					<ul class="nav">
						<li>
			               <a href="../home">
			                  <i class="material-icons">dashboard</i>
			                  <p>Aktualności</p>
			               </a>
			            </li>
			            <sec:authorize access="hasRole('ROLE_STUDENT')">
				            <li>
				               <a href="grades">
				                  <i class="material-icons">grade</i>
				                  <p>Oceny</p>
				               </a>
				            </li>
				            <li>
			                  <a href="student-subject">
				                  <i class="material-icons">content_paste</i>
				                  <p>Zajęcia</p>
				               </a>
				            </li>
				         </sec:authorize>
				         <sec:authorize access="hasRole('ROLE_WORKER')">
			               <li>
			                  <a href="grade/add">
			                     <i class="material-icons">grade</i>
			                     <p>Dodaj ocenę</p>
			                  </a>
			               </li>
			               <li>
			                  <a href="subject-block">
			                     <i class="material-icons">content_paste</i>
			                     <p>Przedmioty</p>
			                  </a>
			               </li>
			            </sec:authorize>
			            <sec:authorize access="hasRole('ROLE_ADMIN')">
				            <li class="active">
				               <a href="../user">
				                  <i class="material-icons">person</i>
				                  <p>Użytkownicy</p>
				               </a>
				            </li>
				         </sec:authorize>
			         </ul>
		    	</div>
			</div>
		
			<div class="main-panel">
				<nav class="navbar navbar-transparent navbar-absolute">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand">Dodaj użytkownika</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a class="user-data"><sec:authentication property="principal.firstName" /> <sec:authentication property="principal.lastName" /></a></li>
								<li style="margin-top: 5px;">
									<form action="/logout" method="post">
										<input type="submit" class="btn btn-success btn-logout" value="Wyloguj" />
										
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									</form>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			
				<div class="content">
					<div class="container-fluid">
		            	<div class="row">
		               		<div class="col-md-12">
		                  		<div class="card">
                           			<div class="card-header" data-background-color="green">
                              			<h4 class="title">Użytkownicy</h4>
                              			<p class="category">Dodaj użytkownika</p>
                           			</div>
		                     		<div class="card-content">
											<form:form action="add" modelAttribute="user" method="post" id="userForm">
												<div class="form-group label-floating">
													<label class="control-label" for="email">Adres email</label>
												   <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp">
												</div>
												<div class="form-group label-floating">
													<label class="control-label" for="password">Hasło</label>
													<input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp">
													<!-- <small id="passwordHelp" class="form-text form-muted">Hasło musi zawierać...</small> -->
												</div>
												<div class="form-group label-floating">
													<label class="control-label" for="role">Rola</label>
													<select id="role" name="role" class="selectpicker" data-style="select-with-transition" title="Wybierz rolę" data-size="2">
			                                        	<option value="ROLE_WORKER">Pracownik</option>
			                        					<option value="ROLE_STUDENT">Student</option>
			                                     	</select>
												</div>    
												<div class="form-group label-floating">
													<label class="control-label" for="firstName">Imię</label>
													<input type="text" class="form-control" id="firstName" name="firstName">
												</div>
												<div class="form-group label-floating">
													<label class="control-label" for="lastName">Nazwisko</label>
													<input type="text" class="form-control" id="lastName" name="lastName">
												</div>
												<div class="form-group label-floating">
													<label class="control-label" for="pesel">Pesel</label>
													<input type="text" class="form-control" id="pesel" name="pesel">
												</div>
												<div class="form-group label-floating" id="indexNoDiv" style="display: none;">
													<label class="control-label" for="indexNo">Nr Indeksu</label>
													<input type="text" class="form-control" id="indexNo" name="indexNo">
												</div>
												<input type="submit" value="Dodaj" class="btn btn-primary pull-right"></input>
											</form:form>
									</div> 
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<footer class="footer">
					<div class="container-fluid">
						<p class="copyright pull-right">
							&copy; <script>document.write(new Date().getFullYear())</script> Wojciech Krokowski & Sylwia Wilk, projekt wykonany na przedmiot: Bazy Danych
						</p>
					</div>
				</footer>
				
			</div>
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
	<script src="../resources/js/material.min.js" type="text/javascript"></script>
	<script src="../resources/js/jquery.select-bootstrap.js" type="text/javascript"></script>
	<script src="../resources/js/material-dashboard.js"></script>



	

</html>