<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="options" type="java.util.Collection" required="true"
	rtexprvalue="true"%>
<%@ attribute name="label" required="true" rtexprvalue="false"%>
<%@ attribute name="name" required="true" rtexprvalue="false"%>

<label for="${name}">${label}:</label>
<select id="${name}" name="${name}">
	<c:forEach items="${options}" var="opt">
		<c:choose>
			<c:when test="${param[name] eq opt}">
				<option selected label="${opt}">${opt}</option>
			</c:when>
			<c:otherwise>
				<option label="${opt}">${opt}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>