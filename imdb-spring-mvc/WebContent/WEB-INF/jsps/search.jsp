<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Imdb Search Page</title>
<style type="text/css">
table tbody tr:NTH-CHILD(2n) {
	background-color: #efefef;
}

table tbody tr:NTH-CHILD(2n+1) {
	background-color: #cfcfcf;
}

table thead tr th {
	background: url("../images/bg.jpg");
}
</style>
</head>
<body>
    <c:url var="actionUrl" value="/movies/search"/> 
	<form action="${actionUrl}" method="post">
		<table>
			<tbody>
				<tr>
					<td>From:</td>
					<td><input type="text" name="fromYear" value="${imdb.fromYear}" /></td>
				</tr>
				<tr>
					<td>To:</td>
					<td><input type="text" name="toYear" value="${imdb.toYear}" /></td>
				</tr>
				<tr>
					<td>Genre:</td>
					<td colspan="2"><select name="genre">
							<c:forEach items="${genres}" var="genre">
								<c:choose>
									<c:when test="${param.genre eq genre.id}">
										<option selected label="${genre.name}" value="${genre.id}">${genre.name}</option>
									</c:when>
									<c:otherwise>
										<option label="${genre.name}" value="${genre.id}">${genre.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> <button name="action" value="search">Search</button></td>
				</tr>
			</tbody>
		</table>
	<c:if test="${not empty imdb.movies}">
		<table>
			<thead>
				<tr>
					<th><button name="action" value="title">Title</button></th>
					<th><button name="action" value="year">Year</button></th>
					<th>Imdb Page</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${imdb.movies}" var="movie">
					<tr>
						<td>${movie.title}</td>
						<td>${movie.year}</td>
						<td><a href="http://www.imdb.com/title/${movie.imdb}"
							target="_blank">Visit!</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</form>
</body>
</html>