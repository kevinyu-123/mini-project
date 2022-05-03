<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <c:choose>
        <c:when test="">
            <h1>로그인 성공</h1>
            <h2>환영합니다.</h2>
            <button id="btn-logout">로그아웃</button>
        </c:when>
        <:c:otherwise>
            <button onclick="location.href='login'">로그인</button>
            <br>
            <button onclick="location.href='register'">회원가입</button>
        </:c:otherwise>

    </c:choose>
</body>
</html>
