
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div>
        <form action="/api/login" method="post">
        <div>
            <label for="email">Email address:</label>
            <input type="email" placeholder="Enter email" id="email">
        </div>
        <div >
            <label for="password">Password:</label>
            <input type="password"  placeholder="Enter password" id="password">
        </div>
        <input type="submit" value="로그인">
        </form>
    </div>

</body>
</html>
