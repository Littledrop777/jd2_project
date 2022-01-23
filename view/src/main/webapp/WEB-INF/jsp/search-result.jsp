<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_header.jsp"/>
<div class="profile">
        <jsp:include page="_menu.jsp"/>
    <div class="container-result">
        <h1>Search results</h1>
        <br>
        <table>
            <tbody>
            <c:forEach items="${results}" var="result">
                <c:if test="${result.login ne sessionScope.currentUser.login}">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/${result.login}/profile.html">
                                    ${result.login}
                                    ${result.firstname}
                                    ${result.lastname}
                            </a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="_footer.jsp"/>