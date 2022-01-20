<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/signup.css" rel="stylesheet">
    <title>Sign Up</title>
</head>

<body>
<div class="container">
    <h2>Sign Up From</h2>
    <div class="form-wrapper">
        <f:form action="${pageContext.request.contextPath}ui/registration-new-user.do" method="post" modelAttribute="addNewUserCommand">   <%--method post, action--%>
            <div class="form-item">
                <label for="firstname">First Name:</label>
                <f:input type="text" path="firstname" name="firstname" id="firstname" placeholder="First Name"
                       pattern="([A-Za-z]|[А-Яа-яЁё])*" maxlength="20"/>
            </div>
            <div class="form-item">
                <label for="lastname">Last Name:</label>
                <f:input type="text" path="lastname" name="lastname" id="lastname" placeholder="Last Name"
                       pattern="([A-Za-z]|[А-Яа-яЁё])*" maxlength="20"/>
            </div>
            <div class="form-item">
                <label for="username">Username:</label>
                <f:input type="text" path="login" name="username" id="username" placeholder="User Name" pattern="[A-Za-z]*"/>
            </div>
            <div class="form-item">
                <label for="email">E-mail:</label>
                <f:input type="email" path="email" name="email" id="email" placeholder="email@xyz.com"
                       pattern="(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})"/>
            </div>
            <div class="form-item">
                <label for="pass">Password:</label>
                <f:input type="password" path="password" name="pass" id="pass" placeholder="password" autocomplete="off"
                       pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"/>
            </div>
            <div class="form-item">
                <label for="repeat-pass">Repeat password:</label>
                <f:input type="password" path="repeatPassword" name="pass" id="repeat-pass" placeholder="password" autocomplete="off"
                       pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"/>
            </div>
            <div class="form-item">
                <label style="width: 131px" for="birthday">Birthday:</label>
                <f:input type="date" path="birthday" id="birthday" name="trip-start"
                       min="1920-01-01"/>
            </div>
            <div class="form-item">
                <label for="gender">Gender:</label>
                <div class="genders">
                    <p>Male</p> <f:radiobutton type="radio" name="gender" id="gender" value="male" path="gender"/>
                    <p>Female</p> <f:radiobutton type="radio" name="gender" id="gender" value="female" path="gender"/>
                </div>
            </div>
            <button class="signup" type="submit">Sign Up</button>
        </f:form>
    </div>

</div>

</body>

</html>