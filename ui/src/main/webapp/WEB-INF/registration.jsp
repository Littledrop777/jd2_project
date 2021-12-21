<%@ page contentType="text/html;charset=UTF-8" %>

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
        <form action="" method="post">   <%--method post, action--%>
            <div class="form-item">
                <label for="firstname">First Name:</label>
                <input type="text" name="firstname" id="firstname" placeholder="First Name"
                       pattern="([A-Za-z]|[А-Яа-яЁё])*" maxlength="20" required>
            </div>
            <div class="form-item">
                <label for="lastname">Last Name:</label>
                <input type="text" name="lastname" id="lastname" placeholder="Last Name"
                       pattern="([A-Za-z]|[А-Яа-яЁё])*" maxlength="20" required>
            </div>
            <div class="form-item">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" placeholder="User Name" pattern="[A-Za-z]*" required>
            </div>
            <div class="form-item">
                <label for="email">E-mail:</label>
                <input type="email" name="email" id="email" placeholder="email@xyz.com"
                       pattern="(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})" required>
            </div>
            <div class="form-item">
                <label for="pass">Password:</label>
                <input type="password" name="pass" id="pass" placeholder="password" autocomplete="off"
                       pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" required>
            </div>
            <div class="form-item">
                <label for="pass">Repeat password:</label>
                <input type="password" name="pass" id="repeat-pass" placeholder="password" autocomplete="off"
                       pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" required>
            </div>
            <div class="form-item">
                <label style="width: 131px" for="birthday">Birthday:</label>
                <input type="date" id="birthday" name="trip-start"
                       min="1920-01-01" required>
            </div>
            <div class="form-item">
                <label for="gender">Gender:</label>
                <div class="genders">
                    <p>Male</p> <input type="radio" name="gender" id="gender" value="male">
                    <p>Female</p> <input type="radio" name="gender" id="gender" value="female">
                </div>
            </div>
            <button class="signup" type="submit">Sign Up</button>
        </form>
    </div>

</div>

</body>

</html>