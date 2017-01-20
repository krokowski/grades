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
			<form:form action="add" modelAttribute="subjectBlock" method="post">
				<div class="form-group">
			    	<label for="subject">Wybierz przedmiot:</label>
			    	<select class="form-control" id="subject" name="subjectId">
				      	<c:forEach items="${subjectDictionary}" var="subject">
				      		<option value="${subject.subjectId}">${subject.name}</option>
				      	</c:forEach>
			    	</select>
			 	</div>
			 	<div class="form-group">
			    	<label for="subjectForm">Wybierz formę zajęć:</label>
			    	<select class="form-control" id="subjectForm" name="subjectFormId">
				      	<c:forEach items="${subjectFormDictionary}" var="subjectForm">
				      		<option value="${subjectForm.subjectFormId}">${subjectForm.name}</option>
				      	</c:forEach>
			    	</select>
			 	</div>
			 	<div class="form-group">
			    	<label for="group">Wybierz grupę:</label>
			    	<select class="form-control" id="group" name="groupId">
				      	<c:forEach items="${groupDictionary}" var="group">
				      		<option value="${group.groupId}">${group.name}</option>
				      	</c:forEach>
			    	</select>
			 	</div>
			 	<button type="submit" class="btn btn-primary">Zapisz</button>
			</form:form>
		</div>
	</body>
	<script type="text/javascript">

		jQuery(document).ready(function($) {
			document.getElementById("subject").selectedIndex = -1;
			document.getElementById("subjectForm").selectedIndex = -1;
			document.getElementById("group").selectedIndex = -1;
		});

	</script>
</html>