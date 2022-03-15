<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-prof">
        <h2>Chats</h2>
        <br>
        <table>
            <tbody>
            <c:forEach items="${dialogs}" var="dialog">
                <a href="${pageContext.request.contextPath}/${dialog.userId}/user-chat.html?page=1">
                    <tr>
                        <td class="btn">
                                ${dialog.userLogin}
                        </td>
                    </tr>
                    <tr>
                        <td class="btn">
                                ${dialog.lastMessageFromLogin}
                                ${dialog.message}
                                ${dialog.createTime}
                        </td>
                    </tr>
                </a>
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