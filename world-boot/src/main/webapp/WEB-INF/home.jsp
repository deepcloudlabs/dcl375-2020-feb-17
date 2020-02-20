<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>World Countries v6</title>
</head>
<body>
    <c:url var="actionUrl" value="/countries/list"/>
	<form action="${actionUrl}" method="post">
		<util:select name="continent" label="Continent"
			options="${continents}"></util:select>
		<button>List</button>
	</form>
	<util:table items="${countries}"
		columns="Code,Name,Population,Surface Area"
		props="code,name,population,surfaceArea"></util:table>
</body>
</html>