<%-- 
    Document   : result
    Created on : 4 Apr, 2018, 7:11:58 PM
    Author     : Shaiwal Chandra <shaiwal.chandra007@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Your Marks <span>${requestScope.result}</span></p>
        <b><a href="ReviewController">Click </a>here to see answers</b>
    </body>
</html>
