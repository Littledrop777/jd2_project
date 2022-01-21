<%@ page contentType="text/html;charset=UTF-8" %>
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
<%--<a href="view/${login}/profile.html"></a>--%>
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
                <li><a class="account" href="#">My Profile</a></li>
                <li><a class="friends" href="#">Friends</a></li>
                <li><a class="messenger" href="#">Messenger</a></li>
                <li><a class="news" href="#">News</a></li>
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
