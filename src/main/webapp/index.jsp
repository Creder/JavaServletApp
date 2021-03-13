<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO.FanficDAO" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fanficoon</title>
</head>
<body>
    <%  pageContext.setAttribute("user", request.getSession().getAttribute("user"));%>
    <div id="menu">
        <a href="${pageContext.request.contextPath}/index"><p>Main</p></a>
        <c:choose>
            <c:when test="${user == null}">
                <form id="loginFormId" name="loginForm" method="POST" action="${pageContext.request.contextPath}/login">
                    <div id="usernameDiv" class="paddingBtm">
                        <span id="user">Username: </span><input id="userInput" type="text" name="username" />
                    </div>
                    <div id="passwordDiv" class="paddingBtm">
                        <span id="pass">Password: </span><input id="passInput" type="password" name="password" />
                    </div>
                    <div id="loginBtn">
                        <input id="btn" type="submit" value="Login" />
                    </div>
                </form>
                <a href="${pageContext.request.contextPath}/register">Sign up</a>
            </c:when>
            <c:when test="${user != null}">
                <H1>${user.getUsername()}</H1>
                <a href="${pageContext.request.contextPath}/user">My page</a>
                <form method ="post" action="${pageContext.request.contextPath}/logout">
                    <input type="submit" name="Logout" value="Logout"/>
                </form>
            </c:when>
        </c:choose>
    </div>
    <%
        FanficDAO fanficDAO = new FanficDAO();
        pageContext.setAttribute("fanfics", fanficDAO.readEntityList());
    %>
    <div id ="content">
        <c:if test="${fanfics !=null}">
            <c:forEach items="${fanfics}" var="fanfic">
                <a href="${pageContext.request.contextPath}/fanfic/${fanfic.getFanficId()}"><h3>${fanfic.getTitle()}</h3></a>
                <p>author: ${fanfic.getAuthor().getUsername()}</p>
            </c:forEach>
        </c:if>
    </div>

</body>
</html>
