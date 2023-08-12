<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Classes</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class = "navBar">
	<h1>Welcome <c:out value = "${ name }"/></h1>
	<p><a href = "/classes/new">Create Class</a></p>
	<p><a href = "/clear">log out</a></p>
</div>
<div class = "super">
	<h4>Your dashboard!</h4>
	<hr>
	<div class = "row">
		<div class = "col">
			<h2>I'm Teaching</h2>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "classITeach" items = "${classesITeach}"> 
						<tr>
							<td><c:out value = "${classITeach.id }"></c:out></td>
							<td><a href = "/classes/${classITeach.id }"><c:out value = "${classITeach.title }"/></a></td>
							<td>Rating</td>
							<td><a href = "classes/${classITeach.id}/edit">Edit</a></td>
							<td><a href = "/classes/${ classITeach.id }/delete">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class = "col">
			<h3>I'm Learning</h3>
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "classIStudy" items = "${ classesIStudy }">
						<tr>
							<td><a href = "classes/${classIStudy.id}"><c:out value = "${classIStudy.title }"/></a></td>
							<td><a href="classes/${ classIStudy.id }/leave">Leave</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	<div class = "col">
		<h4>Available Classes</h4>
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "availableClass" items = "${ availableClasses }">
						<tr>
							<td><a href = "/classes/${availableClass.id }"><c:out value = "${ availableClass.title }"/></a></td>
							<td><a href = "/classes/${ availableClass.id }/join">Join</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</div>
</body>
</html>