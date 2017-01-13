<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>user/list</title>
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
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>email</th>
						<th>rola</th>
						<th>imie</th>
						<th>nazwisko</th>
						<th>pesel</th>
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
								<c:out value="${user.role}" />
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
	</body>
</html>