<%@ page import="DB.UserDB" %>
<%@ page import="business.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String username = (String) request.getSession().getAttribute("username");
        if(username == null || "".equals(username)){
            response.sendRedirect("index.jsp");
        }%>
    <title>Welcome ${username} </title>
</head>
<body><H1>Welcome ${username}</H1>
<h2>Users List</h2>
<%
    List<User> users = UserDB.getUserList();

    for (User user : users){
       out.println("<p>"+ user.getuserId() + " " + user.getUsername() + " " + user.getPassword()+ "</p>");
    }
%>

<h2>Create new user</h2>
<form method="POST" action="user">
    <input name="usrn" placeholder="Name">
    <input name="pass" placeholder="password">
    <button type="submit" value="Create"></button>
</form>
</body>
</html>
