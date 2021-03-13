
<%@ page import="business.Fanfic" %>
<%@ page import="DAO.FanficDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="business.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<div id="menu">
    <%  User user = (User) request.getSession().getAttribute("user");
        if( user==null){
            response.sendRedirect(request.getContextPath()+"/index");
        }
        else{
        pageContext.setAttribute("user", request.getSession().getAttribute("user"));
    %>
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
    String username = user.getUsername();
    List<Fanfic> fanficList = fanficDAO.findByUser(username);
    pageContext.setAttribute("fanficList", fanficList);
    }
%>
<div id="content">
    <c:choose>
        <c:when test="${fanficList.size() == 0}">
            <H1>No fanfics</H1>
        </c:when>
        <c:when test="${fanficList != null}">
            <c:forEach items="${fanficList}" var="fanfic">
                <a href="${pageContext.request.contextPath}/fanfic/${fanfic.getFanficId()}"><h3>${fanfic.getTitle()}</h3></a>
                <p>author: ${fanfic.getAuthor().getUsername()}</p>
            </c:forEach>
        </c:when>
    </c:choose>
</div>

<h2>Create new fanfic</h2>
    <form method="POST" action="${pageContext.request.contextPath}/addfanfic">
        <input name="title" placeholder="Title"/>
        <textarea name="content" placeholder="Content"></textarea>
        <input type="submit" name="Create" value="Create"/>
    </form>
</body>
</html>
