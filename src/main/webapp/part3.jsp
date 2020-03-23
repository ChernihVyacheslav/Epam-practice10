<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Part3</title>
</head>
<body>
    <form action="/practice10/part3" method="post">
        <input name="name"><br>
        <input type="submit" value="Submit">
    </form>
    <a href="/confirmation.jsp">Remove</a> <br>
    <ul style="list-style-type:none;">
        <c:forEach var="entry" items="${sessionScope.names}">
            <li>${entry}</li>
        </c:forEach>
    </ul>
</body>
</html>
