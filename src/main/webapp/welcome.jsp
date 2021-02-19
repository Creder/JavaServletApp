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

</body>
</html>
