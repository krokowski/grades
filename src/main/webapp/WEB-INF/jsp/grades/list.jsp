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

			<form:form id="search">
				<div class="form-group">
					<label for="role">Rola</label>
						<select class="form-control" id="studentSubject" name="studentSubject">
							<c:forEach items="${studentSubjectList}" var="studentSubject">
								<option value="${studentSubject.id}">${studentSubject.name}</option>
							</c:forEach>
						</select>
				</div>
			</form:form>

			<table class="table" id="grades">
				<thead>
					<tr>
						<th>Opis</th>
						<th>Ocena</th>
						<th>Data</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${recordsList}" var="item" >
						<tr>
							<th>
								<c:out value="${item.description}" />
							</th>
							<th>
								<c:out value="${item.grade}" />
							</th>
							<th>
								<c:out value="${item.date}" />
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>

	<script type="text/javascript">

		jQuery(document).ready(function($) {

			document.getElementById("studentSubject").selectedIndex = -1;

			$("#studentSubject").on('change', function(event) {

				// Disble the search button
				enableSearchButton(false);

				// Prevent the form from submitting via the browser.
				event.preventDefault();

				searchViaAjax();

			});

		});

		function searchViaAjax() {

			var search = {}
			search["studentSubject"] = $("#studentSubject").val();

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : window.location.protocol + "//" + window.location.host + "/ajax/grades",
				data : JSON.stringify(search),
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					$('#grades').append(data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
				},
				done : function(e) {
					console.log("DONE");
					enableSearchButton(true);
				}
			});

		}

		function enableSearchButton(flag) {
			$("#search").prop("disabled", flag);
		}
	</script>
</html>