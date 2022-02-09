<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-prof">
        <div style="width: 225px">

            <img src="${pageContext.request.contextPath}/images.html?imgId=${userInfoDto.avatarId}" alt="photo"
                 class="container-photo">

            <c:if test="${not empty sessionScope.userId}">
                <div>
                    <form method="post" action="${pageContext.request.contextPath}/save-image.do"
                          enctype="multipart/form-data">
                        <input type="file" name="image" id="userPhoto"/>
                        <button type="submit">download</button>
                    </form>
                </div>
            </c:if>
        </div>
        <div class="container-info">
            <H2>${userInfoDto.firstname} ${userInfoDto.lastname}</H2>
            <H4>${userInfoDto.login}</H4>
            <p>Birthday: ${userInfoDto.birthday}</p>
            <p>Email: ${userInfoDto.email}</p>
            <p>Gender: ${userInfoDto.gender}</p>
        </div>
    </div>
</div>
<jsp:include page="_footer.jsp"/>

