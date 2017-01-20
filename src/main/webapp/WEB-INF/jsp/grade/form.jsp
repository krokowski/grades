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
			
			<div class="form-group">
				<label for="subjectBlock">Wybierz zajęcia:</label>
					<select class="form-control" id="subjectBlock" name="subjectBlock">
						<c:forEach items="${subjectBlockList}" var="subjectBlock">
							<option value="${subjectBlock.subjectBlockId}">${subjectBlock.description}</option>
						</c:forEach>
					</select>
			</div>			

			<form:form action="grade/add" modelAttribute="grade" method="post" id="gradeForm">
				<div class="form-group">
			    	<label for="subject">Wybierz studenta:</label>
			    	<select class="form-control" id="indexNo" name="indexNo">
				      	<!-- TUTAJ WRACAJĄ DANE PRZEZ AJAXA -->
			    	</select>
			 	</div>
			 	<div class="form-group">
			 		<label for="grade">Ocena:</label>
			 		<input type="number" name="grade" id="grade" min="2" max="5"/>
			 	</div>
			 	<div class="form-group">
			 		<label for="description">Opis:</label>
			 		<input type="text" name="description" id="description" />
			 	</div>
			 	<div class="form-group">
			 		<label for="date">Data:</label>
			 		<input type="date" name="date" id="date" />
			 	</div>
			 	<button type="submit" class="btn btn-primary" form="gradeForm">Zapisz</button>
			</form:form>

		</div>
	</body>

	<script type="text/javascript">

		jQuery(document).ready(function($) {

			$("#gradeForm").hide();
			document.getElementById("subjectBlock").selectedIndex = -1;

			$("#subjectBlock").on('change', function(event) {
				searchEnabled(false);
				searchViaAjax();
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
					$("#gradeForm").show();
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
</html>