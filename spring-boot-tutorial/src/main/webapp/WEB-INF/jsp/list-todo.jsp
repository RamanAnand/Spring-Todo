<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Todo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-light navbar-light">

		<a class="navbar-brand" href="#">Bizpal</a>
		
		<!-- Toggler/collapsibe Button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- navbar links -->
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/list-todo">Todos</a>
				</li>
			</ul>
			<ul class="navbar-nav">
			<a href="/logout">Logout</a>
			</ul>
		</div>
	</nav>
	<div class="container">
		<br>
		<div class="alert alert-info">${name} you can add new item here:
		</div>

		<div class="container">
			<form:form method="POST" modelAttribute="todo">
				<form:hidden path="id" />
				<fieldset class="form-group">
					<form:label path="description">Description:</form:label>
					<form:input required="required" type="text" class="form-control"
						path="description" placeholder="Enter todo" />
					<form:errors path="description"></form:errors>
				</fieldset>
				<button type="submit" class="btn btn-success">Submit</button>
			</form:form>
		</div>

		<!-- <a href="add-todo">Add a Todo</a> -->
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target date</th>
					<th>user</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.id }</td>
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.user }</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id }">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>