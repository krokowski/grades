<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <c:choose>
 	<c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-subject'}">
		<c:set var="title" value="Przedmiot" />
		<c:set var="description" value="Dodaj przedmiot" />
		<c:set var="successMessage" value="Pomyślnie dodano nowy przedmiot" />
	</c:when>
	<c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-subject-form'}">
		<c:set var="title" value="Forma zajęć" />
		<c:set var="description" value="Dodaj formę zajęć" />
		<c:set var="successMessage" value="Pomyślnie dodano nową formę zajęć" />
	</c:when>
	<c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-group'}">
		<c:set var="title" value="Grupa" />
		<c:set var="description" value="Dodaj grupę" />
		<c:set var="successMessage" value="Pomyślnie dodano nową grupę" />
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
	<head>
		<title>Informacje o ocenach</title>
		
		<!-- jQuery 3.1.1 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		
		<script src="../resources/js/jquery.validate.js"></script>

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
		                  <a href="../grade/add">
		                     <i class="material-icons">grade</i>
		                     <p>Dodaj ocenę</p>
		                  </a>
		               </li>
		               <li>
		                  <a href="../subject-block">
		                     <i class="material-icons">content_paste</i>
		                     <p>Zajęcia</p>
		                  </a>
		               </li>
		               <c:choose>
		               <c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-subject'}">
		               <li class="active">
		               </c:when>
		               <c:otherwise>
		               <li>
		               </c:otherwise>
		               </c:choose>
		                  <a href="../subject-block/add-subject">
		                     <i class="material-icons">add_circle_outline</i>
		                     <p>Dodaj przedmiot</p>
		                  </a>
		               </li>
		               <c:choose>
		               <c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-subject-form'}">
		               <li class="active">
		               </c:when>
		               <c:otherwise>
		               <li>
		               </c:otherwise>
		               </c:choose>
		                  <a href="../subject-block/add-subject-form">
		                     <i class="material-icons">add_circle_outline</i>
		                     <p>Dodaj formę zajęć</p>
		                  </a>
		               </li>
		               <c:choose>
		               <c:when test="${requestScope['javax.servlet.forward.request_uri'] == '/subject-block/add-group'}">
		               <li class="active">
		               </c:when>
		               <c:otherwise>
		               <li>
		               </c:otherwise>
		               </c:choose>
		                  <a href="../subject-block/add-group">
		                     <i class="material-icons">add_circle_outline</i>
		                     <p>Dodaj grupę</p>
		                  </a>
		               </li>
		            </sec:authorize>
		            <sec:authorize access="hasRole('ROLE_ADMIN')">
			            <li>
			               <a href="user">
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
							<a class="navbar-brand"><c:out value="${description}" /></a>
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
                              <h4 class="title"><c:out value="${title}" /></h4>
                              <p class="category"><c:out value="${description}" /></p>
                           </div>
		                     <div class="card-content">
		                     				<c:if test="${successMessageShow}">
												<div class="alert alert-success alert-with-icon" data-notify="container">
				                               		<i data-notify="icon" class="material-icons">info_outline</i>
													<span data-notify="message"><c:out value="${successMessage}" /></span>
												</div>
											</c:if> 
											<form:form modelAttribute="dictionaryElement" method="post" id="dictionaryElementForm">
												<div class="form-group label-floating">
											    	<label class="control-label" for="name">Wprowadź nazwę:</label>
											    	<input class="form-control" type="text" name="name" id="name" required maxlength="45">
											 	</div>
											 	<button type="submit" class="btn btn-primary pull-right">Zapisz</button>
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
		
		$("#dictionaryElementForm").validate();
	
	</script>

	<script src="../resources/js/material.min.js" type="text/javascript"></script>
	<script src="../resources/js/jquery.select-bootstrap.js" type="text/javascript"></script>
	<script src="../resources/js/material-dashboard.js"></script>
</html>