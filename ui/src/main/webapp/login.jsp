<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- For google icons  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <title>Login form</title>

</head>
<body>
<div class="background"></div>
<div class="search-item">
    <form method="get" action="">     <%--method get, action--%>
        <input type="text" placeholder="Search...">
        <button class="material-icons-outlined" type="submit">search</button>
    </form>
</div>
<div class="container">
    <h2>Login Form</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-item">
                <span class="material-icons-outlined">
                    account_circle
                    </span>
            <input type="text" name="login" id="text" placeholder="username or email">
        </div>
        <div class="form-item">
                <span class="material-icons-outlined">
                    lock
                    </span>
            <input type="password" name="pass" id="pass" placeholder="password">
        </div>
        <button type="submit"> LOGIN</button>
        <p>New User? <a href="WEB-INF/registration.jsp">Create an account</a></p>
    </form>
</div>
</body>
</html>

