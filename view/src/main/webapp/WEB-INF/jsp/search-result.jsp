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
                <c:if test="${result.uuid ne sessionScope.userId}">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/${result.uuid}/profile.html">
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
        <c:if test="${results.size() eq 5}">
            <div style="text-align: right">
                <a href="${pageContext.request.contextPath}/${page+1}/search.html?pattern=${pattern}">next</a>
            </div>
        </c:if>
        <c:if test="${page>1}">
            <div style="text-align: left">
                <a href="${pageContext.request.contextPath}/${page-1}/search.html?pattern=${pattern}">prev</a>
            </div>
        </c:if>
    </div>
</div>
<jsp:include page="_footer.jsp"/>