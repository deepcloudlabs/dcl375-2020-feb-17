<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="items"
              type="java.util.Collection"
              required="true"
              rtexprvalue="true" %>
<%@ attribute name="columns"
              required="true"
              rtexprvalue="false" %>
<%@ attribute name="props"
              required="true"
              rtexprvalue="false" %>
                            
<table>
		<thead>
			<tr>
			<th>No</th>
			<c:forEach items="${fn:split(columns,',')}"
			           var="column">
				<th>${column}*</th>
			</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" 
			           var="item" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<c:forEach items="${fn:split(props,',')}"
					           var="prop">
						<td>${item[prop]}</td>
					</c:forEach>					
				</tr>
			</c:forEach>
		</tbody>
	</table>