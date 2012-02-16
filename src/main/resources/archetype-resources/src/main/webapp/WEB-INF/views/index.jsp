<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<h1>Welcome to the Spring MVC application!</h1>

<h2><s:message code="view.index.title" /></h2>
<ul>
	<c:forEach var="logEntry" items="${logEntries}">
		<li>${logEntry.date} : ${logEntry.message}</li>
	</c:forEach>
</ul>
