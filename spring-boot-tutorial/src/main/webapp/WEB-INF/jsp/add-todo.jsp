<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Todo</title>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<br>
		<div class="alert alert-info">${name} you can add new item here:
		</div>

		<div class="container">
			<form:form method="POST" modelAttribute="todo">
				<fieldset class="form-group">
					<form:label path="description">Description:</form:label>
					<form:input required="required" type="text" class="form-control"
						path="description" placeholder="Enter todo" />
				</fieldset>
				<button type="submit" class="btn btn-success">Submit</button>
			</form:form>
		</div>

	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>