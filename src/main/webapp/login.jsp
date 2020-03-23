<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/practice10/login" method="post">
        <div>
            <label for="login"><b>Login</b></label> <br>
            <input type="text" placeholder="Enter Login" name="login"> <br>
            <label for="password"><b>Password</b></label> <br>
            <input type="password" placeholder="Enter Password" name="password"> <br>
            <input type="submit" value="Submit"> <br>
        </div>
    </form>
</body>
</html>
