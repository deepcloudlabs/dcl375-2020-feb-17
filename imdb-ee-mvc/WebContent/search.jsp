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
	<form action="search" method="post">
		<table>
			<tbody>
				<tr>
					<td>From:</td>
					<td><input type="text" name="from" value="${imdb.fromYear}" /></td>
				</tr>
				<tr>
					<td>To:</td>
					<td><input type="text" name="to" value="${imdb.toYear}" /></td>
				</tr>
				<tr>
					<td>Genre:</td>
					<td colspan="2"><select name="genreId">
							<c:forEach items="${genres}" var="genre">
								<c:choose>
									<c:when test="${param.genreId eq genre.id}">
										<option selected label="${genre.name}" value="${genre.id}">${genre.name}</option>
									</c:when>
									<c:otherwise>
										<option label="${genre.name}" value="${genre.id}">${genre.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> <input type="submit" value="Search" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<c:if test="${not empty imdb.movies}">
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Year</th>
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
</body>
</html>