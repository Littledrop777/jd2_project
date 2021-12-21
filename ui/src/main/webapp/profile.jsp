<%@ page contentType="text/html;charset=UTF-8" %>
<%--<jsp:include page="_header.jsp">--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="css/search.css" rel="stylesheet">
    <title>Profile</title>
    <style>
        html {
            background-image: url("img/back-reg-img.jpg");
            background-attachment: fixed;
            background-size: cover;
        }

        .profile {
            display: flex;
            align-items: start;
            font-size: 15px;
        }
        .container-nav {
            background: #eff7fcf2;
            padding: 13px;
            border-radius: 15px;
            margin: 0 5px 0 auto;
            position: sticky;
            top: 10px;
        }

        .navigation {
            display: block;
            width: 160px;
            height: 175px;
        }

        .container-prof {
            display: flex;
            background: #eff7fcf2;
            padding: 13px;
            border-radius: 15px;
            margin: 0 auto 0 5px;
            width: 45%;
        }
        .container-photo{
            display: flex;
            border: 3px solid black;
            width: 210px;
            height: 280px;
            flex-direction: row;
        }
        .container-info{
            display: flex;
            flex-direction: column;
            width: 64%;
            padding-left: 21px;
            align-items: stretch;
        }
        .container-info h2 {
            margin: 10px 10px 7px 10px;
        }
        .container-info h4 {
            margin: 0 10px 10px 10px;
        }

        .container-info hr {
            width: 414px;
            margin: 1px;
            padding: 1px;
            border: none;
            background-color: #54547c4d;
        }

        .container-info p {
            margin: 10px;
        }

        ul {
            padding: 10px;
            margin: 0;
        }

        li {
            list-style-type: none;
            height: 28px;
            padding-bottom: 7px;
        }

        a {
            padding-left: 43px;
            text-decoration: none;
            line-height: 26px;
            display: block;
            height: 25px;
            width: 66%;
            color: black;
        }

        a.account {
            background: url("img/icons/account.png") no-repeat 7% 50%;
        }

        a.friends {
            background: url("img/icons/friends.png") no-repeat 7% 50%;
        }

        a.messenger {
            background: url("img/icons/chat.png") no-repeat 7% 50%;
        }

        a.news {
            background: url("img/icons/news.png") no-repeat 7% 50%;
        }

        a:hover{
            border-bottom: 2px solid rgb(52 39 106 / 32%);
            border-radius: 15px;
        }
        a.account:hover{
            background: rgb(182 191 222 / 32%) url("img/icons/account.png") no-repeat 7% 50%;
        }
        a.friends:hover{
            background: rgb(182 191 222 / 32%) url("img/icons/friends.png") no-repeat 7% 50%;
        }
        a.messenger:hover{
            background: rgb(182 191 222 / 32%) url("img/icons/chat.png") no-repeat 7% 50%;
        }
        a.news:hover{
            background: rgb(182 191 222 / 32%) url("img/icons/news.png") no-repeat 7% 50%;
        }

        @media screen and (max-width: 640px) {


            .form-item label {
                font-size: 14px;
                width: 100px;

            }
            .form-item input {
                margin: 5px 10px;
                height: 18px;
                width: 100px;
                font-size: 12px;
            }

        }

    </style>
</head>
<body>
<div class="search-item">
    <form method="" action="">     <%--method get, action--%>
        <input type="text" placeholder="Search...">
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
            <H2>User Name</H2>
            <H4>User Login</H4>
            <hr>
            <p>Birthday info</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <hr>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
            <p>text text text text</p>
        </div>

    </div>

</div>
</body>
</html>
