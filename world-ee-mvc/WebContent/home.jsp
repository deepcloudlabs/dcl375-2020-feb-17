<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>World Countries v5</title>
</head>
<body>
	<form action="list" method="post">
		<label for="continent">Continent:</label>
		<select id="continent"
		        name="continent">
		     <c:forEach items="${continents}"
		                var="cont">
		      <c:choose>
		      	<c:when test="${param.continent eq cont}">
		      		<option selected label="${cont}">${cont}</option>       
		      	</c:when>
		      	<c:otherwise>
		      		<option label="${cont}">${cont}</option>       
		      	</c:otherwise>
		      </c:choose>          
		     </c:forEach>   
		 </select>
		<button>List</button>        
	</form>
	<table>
		<thead>
			<tr>
				<th>No</th>
				<th>Code</th>
				<th>Name</th>
				<th>Population</th>
				<th>Surface Area</th>
				<th>GNP</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${countries}"
			           var="country"
			           varStatus="status">
			    <tr>
			    	<td>${status.index + 1}</td>
			    	<td>${country.code}</td>
			    	<td>${country.name}</td>
			    	<td>${country.population}</td>
			    	<td>${country.surfaceArea}</td>
			    	<td>${country.gnp}</td>
			    </tr>       
			</c:forEach>
		</tbody>
	</table>
</body>
</html>



