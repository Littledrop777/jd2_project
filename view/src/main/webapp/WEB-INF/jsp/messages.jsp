<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-result">
        <div>
            <c:if test="${pageAmount gt 0}">
                <c:forEach begin="1" end="${pageAmount}" step="1" varStatus="position">
                    <a href="${pageContext.request.contextPath}/${receiverUserId}/user-chat.html?page=${position.current}">
                        <c:if test="${pageAmount > 1}">
                            ${position.current}
                        </c:if>
                    </a>
                </c:forEach>
            </c:if>
        </div>
        <div>
            <c:choose>
                <c:when test="${not empty messages}">
                    <c:forEach items="${messages}" var="message">
                        <c:choose>
                            <c:when test="${message.userId eq sessionScope.userId}">
                                <p style="text-align: right">
                                        ${message.login}
                                        ${message.createTime}
                                        ${message.message}
                                </p>
                            </c:when>
                            <c:otherwise>
                                <p style="text-align: left">
                                        ${message.login}
                                        ${message.createTime}
                                        ${message.message}
                                </p>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>No messages</p>
                </c:otherwise>
            </c:choose>

        </div>
        <div>
            <form method="post" action="${pageContext.request.contextPath}/${receiverUserId}/send-message.do">
                <label for="message">message</label>
                <input type="text" autofocus name="message" id="message"/>
                <button type="submit">send</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="_footer.jsp"/>