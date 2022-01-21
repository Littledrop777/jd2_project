<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/signup.css" rel="stylesheet">
    <link href="css/error.css" rel="stylesheet">
    <title>Sign Up</title>
</head>

<body>
<div class="container">
    <h2>Sign Up From</h2>
    <div class="form-wrapper">
        <f:form action="${pageContext.request.contextPath}/registration-new-user.do" method="post"
                modelAttribute="addNewUserCommand">
            <c:if test="${not empty error}">
                <p class="error">
                    <c:out value="${error}"/>
                </p>
            </c:if>
            <div class="form-item">
                <label for="firstname" class="required-field">First Name:</label>
                <f:input type="text" path="firstname" name="firstname" id="firstname" placeholder="First Name"
                         maxlength="20"/>
            </div>
            <div class="form-item">
                <label for="lastname">Last Name:</label>
                <f:input type="text" path="lastname" name="lastname" id="lastname" placeholder="Last Name"
                         maxlength="20"/>
            </div>
            <div class="form-item">
                <label for="username" class="required-field">Username:</label>
                <f:input type="text" path="login" name="username" id="username" placeholder="User Name"/>
            </div>
            <div class="form-item">
                <label for="email" class="required-field">E-mail:</label>
                <f:input type="email" path="email" name="email" id="email" placeholder="email@xyz.com"/>
            </div>
            <div class="form-item">
                <label for="pass" class="required-field">Password:</label>
                <f:input type="password" path="password" name="password" id="pass" placeholder="password"
                         autocomplete="off"/>
            </div>
            <div class="form-item">
                <label for="repeat-pass" class="required-field">Repeat password:</label>
                <f:input type="password" path="repeatPassword" name="repassword" id="repeat-pass"
                         placeholder="repassword" autocomplete="off"/>
            </div>
            <div class="form-item">
                <label style="width: 151px" for="birthday" class="required-field">Birthday:</label>
                <f:input type="date" path="birthday" id="birthday" name="birthday" min="01.01.1920"/>
            </div>
            <div class="form-item">
                <label for="gender">Gender:</label>
                <div class="genders">
                    <p>Male</p> <f:radiobutton name="gender" id="gender" value="male" path="gender"/>
                    <p>Female</p> <f:radiobutton name="gender" id="gender" value="female" path="gender"/>
                </div>
            </div>
            <button class="signup" type="submit">Sign Up</button>
        </f:form>
    </div>
</div>
</body>
</html>