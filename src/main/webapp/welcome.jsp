<%@ page import="DAO.UserDao" %>
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
    UserDao userDao = new UserDao();
    List<User> users = userDao.readAllList();

    for (User user : users){
       out.println("<p>"+ user.getuserId() + " " + user.getUsername() + " " + user.getPassword()+ "</p>");
    }
%>

<h2>Create new user</h2>
<form method="POST" action="user">
    <input name="email" placeholder="Email">
    <input name="usrn" placeholder="Name">
    <input name="pass" type="password" placeholder="password">
    <button type="submit" value="Create"></button>
</form>
</body>
</html>
