<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-prof">
        <div>
            <div class="container-photo">
                Photo
<%--                <img src="${pageContext.request.contextPath}/images/${sessionScope.userId}/${sessionScope.imageName}" alt="User Photo">--%>
            </div>
            <c:if test="${not empty sessionScope.userId}">
                <div>
                    <form method="post" action="${pageContext.request.contextPath}/save-image.do" enctype="multipart/form-data">
                        <label for="userPhoto">User photo</label>
                        <input type="file" name="image" id="userPhoto"/>
                        <button type="submit">download</button>
                    </form>
                </div>
            </c:if>
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

