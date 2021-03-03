
<%@ page import="business.Fanfic" %>
<%@ page import="DAO.FanficDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="business.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My Page</title>
</head>
<body>

<%  User user = (User) request.getSession().getAttribute("user");
    if( user==null){
        response.sendRedirect("index.jsp");
    }
    out.print("<h1>Welcome "+user.getUsername()+"!</h1>");
    FanficDAO fanficDAO = new FanficDAO();
    List<Fanfic> fanficList = fanficDAO.readEntityList(user);
    if(fanficList == null){
        out.println("<h3>Nothing found!</h3>");
    }
    else{
        for(Fanfic fanfic : fanficList){
            out.println("<h3>"+fanfic.getTitle()+"</h3>");
        }
    }

%>

</body>
</html>
