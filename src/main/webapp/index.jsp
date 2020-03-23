<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>WITH SCRIPTLETS:</h2>
<table border="1">
    <% for (int i = 0; i < 10; i++) {%>
    <tr>
        <%for (int j = 0; j < 10; j++) {
            if (i == 0 && j == 0) {%>
        <td> </td>
        <%} else if (i == 0) {%>
        <td><%=j %></td>
        <%} else if (j == 0) {%>
        <td><%=i %></td>
        <%} else {%>
        <td><%=i * j%></td>
        <%
                }
            }%>
    </tr>
    <%
        }%>
</table>
<h2>WITH JSTL:</h2>
<table border ="1">
    <c:forEach var="i" begin="0" end="9">
        <tr>
            <c:forEach var="j" begin="0" end="9">
                <c:choose>
                    <c:when test="${i == 0 && j == 0}">
                    <td> </td>
                    </c:when>
                    <c:when test="${i == 0 && j != 0}">
                        <td> ${j} </td>
                    </c:when>
                    <c:when test="${i != 0 && j == 0}">
                    <td> ${i} </td>
                    </c:when>
                    <c:otherwise>
                        <td>${i*j}</td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
