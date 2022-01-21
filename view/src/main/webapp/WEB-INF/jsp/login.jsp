<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <link href="css/error.css" rel="stylesheet">
    <title>Login form</title>

</head>
<body>
<div class="background"></div>
<div class="search-item">
    <form method="get" action="">     <%--method get, action--%>
        <label>
            <input type="text" placeholder="Search...">
        </label>
        <button class="material-icons-outlined" type="submit">search</button>
    </form>
</div>
<div class="container">
    <h2>Login Form</h2>
    <f:form action="${pageContext.request.contextPath}/login-user.do" method="post"
            modelAttribute="loginUserDto">
        <c:if test="${not empty error}">
            <p class="error">
                <c:out value="${error}"/>
            </p>
        </c:if>
        <div class="form-item">
                <span class="material-icons-outlined">
                    account_circle
                    </span>
            <label for="login"></label>
            <f:input path="login" type="text" name="login" id="login" placeholder="login"/>
        </div>
        <div class="form-item">
                <span class="material-icons-outlined">
                    lock
                    </span>
            <label for="pass"></label>
            <f:input path="password" type="password" name="pass" id="pass" placeholder="password"/>
        </div>
        <button type="submit"> LOGIN</button>
        <p>New User? <a href="${pageContext.request.contextPath}/registration.html">Create an account</a></p>
    </f:form>
</div>
</body>
</html>

