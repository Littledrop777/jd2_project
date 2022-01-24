<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-nav">
    <nav class="navigation">
        <ul>
            <c:choose>
                <c:when test="${not empty sessionScope.currentUser}">
                    <li>
                        <a class="account"
                           href="${pageContext.request.contextPath}/${sessionScope.currentUser.id}/profile.html">
                            My Profile
                        </a>
                    </li>
                    <li><a class="friends" href="#">Friends</a></li>
                    <li><a class="messenger" href="#">Messenger</a></li>
                    <li><a class="news" href="#">News</a></li>
                    <li>
                        <a class="settings" href="${pageContext.request.contextPath}/settings.html">
                            Settings
                        </a>
                    </li>
                    <li>
                        <a class="logout" href="${pageContext.request.contextPath}/logout-user.html">
                            Logout
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a class="login" href="${pageContext.request.contextPath}/login.html">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</div>