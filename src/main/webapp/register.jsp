<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Register</h2>
<form id="registerFormId" name="registerForm" method="POST" action="register">
    <div id="emailDiv" class="paddingBtm">
        <span id="email">Email: </span><input id="emailInput" type="text" name="email" />
    </div>
    <div id="usernameDiv" class="paddingBtm">
        <span id="user">Username: </span><input id="userInput" type="text" name="username" />
    </div>
    <div id="passwordDiv" class="paddingBtm">
        <span id="pass">Password: </span><input id="passInput" type="password" name="password" />
    </div>
    <div id="registerBtn">
        <input id="btn" type="submit" value="Sing up" />
    </div>
    <div> <p>Error: <%= request.getSession().getAttribute("Error")%></p></div>
</form>
</body>
</html>