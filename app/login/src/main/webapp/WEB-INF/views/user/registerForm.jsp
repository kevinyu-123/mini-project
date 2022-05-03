
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
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
        <button id="btn-save" class="btn btn-primary">회원가입</button>
    </div>

    <br/>
</body>
<script src="/js/user.js"></script>
</html>