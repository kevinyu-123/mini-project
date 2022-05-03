
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body>
<div class="container">
    <form>
        <div >
            <label for="email">Email address:</label>
            <input type="email"  placeholder="Enter email" id="email">
            <button id="btn-check-email">이메일 중복 확인</button>
            <label id="check-email"></label>
        </div>
        <div >
            <label for="password">Password:</label>
            <input type="password" placeholder="Enter password" id="password">
        </div>
    </form>
    <button id="btn-save">회원가입</button>
</div>
<br/>
</body>
</html>