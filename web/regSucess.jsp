<%-- 
    Document   : regSucess
    Created on : 2 Apr, 2018, 11:11:12 AM
    Author     : RANJEET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Refresh" content="3;url=login.jsp">
        <title>Thanks</title>
    </head>
    <body>
        <h2>Congratulation <%=request.getAttribute("newUser")%> your account is sucessfully created </h2><br>
        <p>You will be redirected to login page in 3 sec</p>
        
    </body>
</html>
