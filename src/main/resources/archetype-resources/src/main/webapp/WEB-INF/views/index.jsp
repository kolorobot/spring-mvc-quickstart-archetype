<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Welcome to the Spring MVC application!</h1>

<h2>Log entries</h2>
<ul>
	<c:forEach var="logEntry" items="${logEntries}">
		<li>${logEntry.date} : ${logEntry.message}</li>
	</c:forEach>
</ul>
