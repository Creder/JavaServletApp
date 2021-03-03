<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="business.User" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.FanficDAO" %>
<%@ page import="business.Fanfic" %>
<%@ page import="java.util.ArrayList" %>
<%@ page session="false" %>
<html>

<title>Fanficoon</title>
<body>

<%
    User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            out.print("<h2>Login</h2>\n" +
                    "<a href=\"register.jsp\">Sign up</a>\n" +
                    "<form id=\"loginFormId\" name=\"loginForm\" method=\"POST\" action=\"login\">\n" +
                    "    <div id=\"usernameDiv\" class=\"paddingBtm\">\n" +
                    "        <span id=\"user\">Username: </span><input id=\"userInput\" type=\"text\" name=\"username\" />\n" +
                    "    </div>\n" +
                    "    <div id=\"passwordDiv\" class=\"paddingBtm\">\n" +
                    "        <span id=\"pass\">Password: </span><input id=\"passInput\" type=\"password\" name=\"password\" />\n" +
                    "    </div>\n" +
                    "    <div id=\"loginBtn\">\n" +
                    "        <input id=\"btn\" type=\"submit\" value=\"Login\" />\n" +
                    "    </div>\n" +
                    "    <div> <p>" +
                    "</form>\n"
                    );
        }
        else {
            out.print("<H1>Welcome "+ user.getUsername() + "</H1>"+
                    "<form method =\"post\" action=\"logout\">"+
                    "<a href=\"user.jsp\">My page</a>"+
                    "<input type=\"submit\" name=\"Logout\" value=\"Logout\"/>"+
                    "</form>"+
                    "<h2>Create new fanfic</h2>\n" +
                            "<form method=\"POST\" action=\"createFanfic\">\n" +
                            "    <input name=\"title\" placeholder=\"Title\"/>\n" +
                            "    <textarea name=\"content\" placeholder=\"Content\"></textarea>\n" +
                            "    <input type=\"submit\" name=\"Create\" value=\"Create\"/>\n" +
                            "</form>");


        }

    FanficDAO fanficDAO = new FanficDAO();
        List<Fanfic> fanfics = new ArrayList<>();
        if((fanfics = fanficDAO.readEntityList()) != null){
            for(Fanfic fanfic : fanfics){
                out.print("<h3>"+fanfic.getTitle()+"</h3>"+
                            "<p>author: </p>"+ fanfic.getAuthor().getUsername());
            }
        }
%>


</body>
</html>
