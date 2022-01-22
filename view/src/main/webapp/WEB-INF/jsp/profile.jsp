<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="../css/search.css" rel="stylesheet">
    <link href="../css/profile.css" rel="stylesheet">
    <title>Profile</title>
</head>
<body>
<div class="search-item">
    <form method="Get" action="">     <%--method get, action--%>
        <label>
            <input type="text" placeholder="Search...">
        </label>
        <button class="material-icons-outlined" type="submit">search</button>
    </form>
</div>
<div class="profile">
    <div class="container-nav">
        <nav class="navigation">
            <ul>
                <li>
                    <a class="account" href="${pageContext.request.contextPath}/${sessionScope.currentUser.login}/profile.html">
                        My Profile
                    </a>
                </li>
                <li><a class="friends" href="#">Friends</a></li>
                <li><a class="messenger" href="#">Messenger</a></li>
                <li><a class="news" href="#">News</a></li>
                <li><a class="settings" href="#">Settings</a></li>
                <li><a class="logout" href="${pageContext.request.contextPath}/logout-user.html">Logout</a></li>
            </ul>
        </nav>
    </div>
    <div class="container-prof">
        <div class="container-photo">
            Photo
        </div>
        <div class="container-info">
            <H2>${userInfoDto.firstname} ${userInfoDto.lastname}</H2>
            <H4>${userInfoDto.login}</H4>
            <hr>
            <p>Birthday: ${userInfoDto.birthday}</p>
            <c:out value="${sessionScope.currentUser.login}"/>
            <hr>
            <p>Email: ${userInfoDto.email}</p>
            <hr>
            <p>Gender: ${userInfoDto.gender}</p>
            <hr>
        </div>
    </div>
</div>
</body>
</html>
