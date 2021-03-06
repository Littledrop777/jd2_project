<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/css/friends.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/search.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/result.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet">
    <title>Profile</title>
</head>
<body>
<div class="search-item">
    <form method="Get" action="${pageContext.request.contextPath}/${1}/search.html">
        <label>
            <input name="pattern" type="text" placeholder="Search...">
        </label>
        <button class="material-icons-outlined" type="submit">search</button>
    </form>
</div>