<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.academy.it.entity.Status" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-prof">
        <div style="width: 270px">
            <img src="${pageContext.request.contextPath}/images.html?imgId=${userInfoDto.avatarId}" alt="photo"
                 class="container-photo">
            <c:if test="${not empty sessionScope.userId}">
                <c:choose>
                    <c:when test="${sessionScope.userId eq userInfoDto.uuid}">
                        <form method="post" action="${pageContext.request.contextPath}/save-image.do"
                              enctype="multipart/form-data">
                            <input type="file" name="image" id="userPhoto"/>
                            <button type="submit">download</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <div style="display: flex">
                            <c:choose>
                                <c:when test="${not empty status and status eq Status.REQUESTED}">
                                    <form method="post"
                                          action="${pageContext.request.contextPath}/delete-friend.do?id=${userInfoDto.uuid}">
                                        <button style="background: red; color: black" type="submit">cancel</button>
                                    </form>
                                </c:when>
                                <c:when test="${not empty status and status eq Status.ACCEPTED}">
                                    <form method="post"
                                          action="${pageContext.request.contextPath}/delete-friend.do?id=${userInfoDto.uuid}">
                                        <button style="background: red; color: black" type="submit">delete</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form method="post"
                                          action="${pageContext.request.contextPath}/add-friend.do?id=${userInfoDto.uuid}">
                                        <button type="submit">add to friends</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                            <form method="post"
                                  action="${pageContext.request.contextPath}/send-message.do?id=${userInfoDto.uuid}">
                                <button type="submit">send message</button>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
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

