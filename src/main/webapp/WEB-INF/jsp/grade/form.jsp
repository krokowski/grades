<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Oceny</title>

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
		               <li class="active">
		                  <a href="../subject-block">
		                     <i class="material-icons">content_paste</i>
		                     <p>Przedmioty</p>
		                  </a>
		               </li>
		               <li>
		                  <a href="../subject-block/add-subject">
		                     <i class="material-icons">grade</i>
		                     <p>Dodaj przedmiot</p>
		                  </a>
		               </li>
		               <li>
		                  <a href="../subject-block/add-subject-form">
		                     <i class="material-icons">grade</i>
		                     <p>Dodaj formę zajęć</p>
		                  </a>
		               </li>
		               <li>
		                  <a href="../subject-block/add-group">
		                     <i class="material-icons">grade</i>
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
							<a class="navbar-brand">Dodaj ocenę</a>
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
                              <h4 class="title">Oceny</h4>
                              <p class="category">Dodaj ocenę</p>
                           </div>
		                     <div class="card-content table-responsive">
			                     <div class="container-fluid" id="container">			
										<form:form action="add" modelAttribute="grade" method="post" id="gradeForm">
											<div class="form-group label-floating">
												<label class="control-label" for="subjectBlock">Wybierz zajęcia:</label>
												<select id="subjectBlock" name="subjectBlockId" class="selectpicker" data-style="select-with-transition" title="Wybierz zajęcia" data-size="8">
													<c:forEach items="${subjectBlockList}" var="subjectBlock">
														<option value="${subjectBlock.subjectBlockId}">${subjectBlock.description}</option>
													</c:forEach>
												</select>
											</div>			

											<div id="gradeDiv">
												<div class="form-group">
											    	<label class="control-label" for="subject">Wybierz studenta:</label>
											    	<!-- <select id="indexNo" name="indexNo" class="selectpicker" data-style="select-with-transition" title="Wybierz studenta" data-size="8"> -->
											    	<select class="form-control" id="indexNo" name="indexNo">
												      	<!-- TUTAJ WRACAJĄ DANE PRZEZ AJAXA -->
											    	</select>
											 	</div>
											 	<div class="form-group label-floating">
											 		<label class="control-label" for="grade">Ocena:</label>
											 		<input type="number" class="form-control" name="grade" id="grade" min="2" max="5" required/>
											 	</div>
											 	<div class="form-group label-floating">
											 		<label class="control-label" for="description">Opis:</label>
											 		<input type="text" class="form-control" name="description" id="description" required/>
											 	</div>
											 	<div class="form-group">
											 		<label class="control-label" for="date">Data:</label>
											 		<input type="date" class="form-control" name="date" id="date" required/>
											 	</div>
											 	<button type="submit" class="btn btn-primary pull-right" form="gradeForm">Zapisz</button>
											 </div>
											</form:form>
										</div>
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
	
		$("#gradeForm").validate();

		jQuery(document).ready(function($) {

			var bigger = false;

			$("#gradeDiv").hide();
			document.getElementById("subjectBlock").selectedIndex = -1;

			$("#subjectBlock").on('change', function(event) {
				searchEnabled(false);
				searchViaAjax();
			});

			$(".filter-option.pull-left").click(function() {
				var x = $(".dropdown-menu.open").height();
				if (!bigger) {
					$(".card").css('min-height', $(".card").height() + x + 10);
					$("#container").css('min-height', $(".card-content.table-responsive").height() + 10);
					$(".card-content.table-responsive").css('min-height', $(".card-content.table-responsive").height() + x + 10);
					bigger = !bigger;
				}
			});

			$(".btn.dropdown-toggle.bs-placeholder.select-with-transition").click(function() {
				var x = $(".dropdown-menu.open").height();
				if (!bigger) {
					$(".card").css('min-height', $(".card").height() + x + 10);
					$("#container").css('min-height', $(".card-content.table-responsive").height() + 10);
					$(".card-content.table-responsive").css('min-height', $(".card-content.table-responsive").height() + x + 10);
					bigger = !bigger;
				}
			});			
		});

		function searchViaAjax() {

			var search = {}
			search["subjectBlockId"] = $("#subjectBlock").val();

			var trHTML = "";

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : window.location.protocol + "//" + window.location.host + "/ajax/grade/add",
				data : JSON.stringify(search) ,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {

					for (i=0; i<data.length; i++) {
						trHTML += '<option value=' + data[i].indexNo + '>' + data[i].description + '</option>';
					}
					$('#indexNo').html(trHTML);
					$("#gradeDiv").show();
				},
				error : function(e) {
					console.log("ERROR: ", e);
				},
				done : function(e) {
					searchEnabled(true);
				}
			});
		}

		function searchEnabled(flag) {
			$("#search").prop("enabled", flag);
		}
	</script>
	<script src="../resources/js/material.min.js" type="text/javascript"></script>
	<script src="../resources/js/jquery.select-bootstrap.js" type="text/javascript"></script>
	<script src="../resources/js/material-dashboard.js"></script>

</html>