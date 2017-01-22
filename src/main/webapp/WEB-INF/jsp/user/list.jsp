<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

    	<link href="../resources/css/app.css" rel="stylesheet"/>
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<!-- Fonts and icons -->
    	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
		
	</head>
	<body>
		<div class="wrapper">
			<div class="sidebar" data-color="green">
	
				<div class="logo">					
					Informacje o ocenach	
				</div>
	
		    	<div class="sidebar-wrapper">
					<ul class="nav">
						<li>
		               <a href="home">
		                  <i class="material-icons">grade</i>
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
				<div class="content">
					<div class="container-fluid">
		            <div class="row">
		               <div class="col-md-12">
		                  <div class="card">
                           <div class="card-header" data-background-color="green">
                              <div class="inline-header">
	                              <h4 class="title">Użytkownicy</h4>
	                              <p class="category">Lista użytkowników systemu</p>
										</div>
                              <button class="btn">DODAJ</button>
                           </div>
		                     <div class="card-content table-responsive">
			                     <table class="table">
											<thead>
												<tr>
													<th>ID</th>
													<th>Email</th>
													<th>Rola</th>
													<th>Imię</th>
													<th>Nazwisko</th>
													<th>PESEL</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${usersList}" var="user" >
													<tr>
														<th>
															<c:out value="${user.userId}" />
														</th>
														<th>
															<c:out value="${user.email}" />
														</th>
														<th>
															<c:choose>
																<c:when test="${user.role == 'ROLE_ADMIN'}">
																	Administrator
																</c:when>
																<c:when test="${user.role == 'ROLE_WORKER'}">
																	Pracownik
																</c:when>
																<c:otherwise>
																	Student
																</c:otherwise>
															</c:choose>
														</th>
														<th>
															<c:out value="${user.firstName}" />
														</th>
														<th>
															<c:out value="${user.lastName}" />
														</th>
														<th>
															<c:out value="${user.pesel}" />
														</th>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="../resources/js/material.min.js" type="text/javascript"></script>
	<script src="../resources/js/material-dashboard.js"></script>
	
</html>