<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-result">
        <h2>Friends</h2>
        <br>
        <a href="${pageContext.request.contextPath}/1/requests-from-users.html">
            Request
        </a>
        <table>
            <tbody>
            <c:forEach items="${friends}" var="friend">
                <tr>
                    <td class="btn" rowspan="2">
                        <a href="${pageContext.request.contextPath}/${friend.id}/profile.html">
                                ${friend.login}
                                ${friend.firstname}
                                ${friend.lastname}
                        </a>
                    </td>
                    <td>
                        <form method="get"
                              action="${pageContext.request.contextPath}/${friend.id}/user-chat.html">
                            <button type="submit">send message</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form method="post"
                              action="${pageContext.request.contextPath}/delete-friend.do?id=${friend.id}">
                            <button style="background: red; color: black" type="submit">delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table>
            <tr>
                <c:forEach begin="1" end="${pageAmount}" step="1" varStatus="position">
                    <td>
                        <a href="${pageContext.request.contextPath}/${position.current}/friends.html">
                            <c:if test="${pageAmount > 1}">
                                ${position.current}
                            </c:if>
                        </a>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="_footer.jsp"/>