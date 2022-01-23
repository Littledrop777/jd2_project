<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
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
<jsp:include page="_footer.jsp"/>

