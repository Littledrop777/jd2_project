<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp"/>
<div class="profile">
    <jsp:include page="_menu.jsp"/>
    <div class="container-prof" style="flex-direction: column">
        <h2 style="text-align: center">Settings</h2>
        <div class="form-wrapper">
            <f:form action="${pageContext.request.contextPath}/${sessionScope.userId}/update-settings.do" method="post"
                    modelAttribute="updateUserDto">
                <c:if test="${not empty error}">
                    <p class="error">
                        <c:out value="${error}"/>
                    </p>
                </c:if>
                <p style="text-align: center; color: green " >
                    <c:out value="${message}"/>
                </p>
                <div class="form-item">
                    <label for="firstname">First Name:</label>
                    <f:input type="text" path="firstname" name="firstname" id="firstname" placeholder="First Name"
                             maxlength="20"/>
                </div>
                <div class="form-item">
                    <label for="lastname">Last Name:</label>
                    <f:input type="text" path="lastname" name="lastname" id="lastname" placeholder="Last Name"
                             maxlength="20"/>
                </div>
                <div class="form-item">
                    <label for="username">Username:</label>
                    <f:input type="text" path="login" name="username" id="username" placeholder="User Name"/>
                </div>
                <div class="form-item">
                    <label for="email">E-mail:</label>
                    <f:input type="email" path="email" name="email" id="email" placeholder="email@xyz.com"/>
                </div>
                <div class="form-item">
                    <label for="pass">Password:</label>
                    <f:input type="password" path="password" name="password" id="pass" placeholder="password"
                             autocomplete="off"/>
                </div>
                <div class="form-item">
                    <label for="repeat-pass">Repeat password:</label>
                    <f:input type="password" path="repeatPassword" name="repassword" id="repeat-pass"
                             placeholder="repassword" autocomplete="off"/>
                </div>
                <div class="form-item">
                    <label style="width: 151px" for="birthday">Birthday:</label>
                    <f:input type="date" path="birthday" id="birthday" name="birthday" min="01.01.1920"/>
                </div>
                <div class="form-item">
                    <label for="gender">Gender:</label>
                    <div class="genders">
                        <p>Male</p> <f:radiobutton name="gender" id="gender" value="male" path="gender"/>
                        <p>Female</p> <f:radiobutton name="gender" id="gender" value="female" path="gender"/>
                    </div>
                </div>
                <button class="signup" type="submit">Update</button>
            </f:form>
        </div>
    </div>
</div>
<jsp:include page="_footer.jsp"/>

